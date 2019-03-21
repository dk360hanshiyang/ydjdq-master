package com.sudaizhijia.ydjdq.ui.home;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.ChangeBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.MobileInfoUtil;
import com.sudaizhijia.ydjdq.utils.MutiChannelConfig;
import com.sudaizhijia.ydjdq.utils.NetUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.utils.SystemUtil;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.util.List;
import java.util.Locale;

import okhttp3.Call;
import okhttp3.Request;

import static android.content.Context.LOCATION_SERVICE;
import static com.umeng.socialize.utils.ContextUtil.getPackageName;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class HomePresenter extends BasePresenterImpl<HomeContract.View> implements HomeContract.Presenter {

    private boolean isRefresh;
    private String city;


    @Override
    public void getIndexInfo(boolean isRefresh) {
        this.isRefresh = isRefresh;
        getLocations();

    }


    public void getLocations() {
        LocationManager locationManager = (LocationManager) getContext().getSystemService(LOCATION_SERVICE);
//        initNavi();
        //权限检查的代码
        if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            city = "没有获得权限";
            homeInfo();
            return;
        }
        locationManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER,//指定GPS定位提供者
                1000,//指定数据更新的间隔时间
                1,//位置间隔的距离为1m
                new LocationListener() {//监听GPS信息是否改变
                    @Override
                    public void onLocationChanged(Location location) {//GPS信息发送改变时回调
                        Log.i("lgq", "onLocationChanged====" + location.getProvider());
                    }

                    @Override
                    public void onStatusChanged(String provider, int status, Bundle extras) {//GPS状态发送改变时回调

                    }

                    @Override
                    public void onProviderEnabled(String provider) { //定位提供者启动时回调

                    }

                    @Override
                    public void onProviderDisabled(String provider) { //定位提供者关闭时回调

                    }
                }
        );
        Location location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);//获取最新的定位信息
        locationUpdates(location);
    }

    private void homeInfo() {
        OkHttpUtils.post().tag(getTag())
                .url(API.index)
                .addParams("position", city)//位置
                .addParams("netType", NetUtils.getNetworkState(getContext()))//联网方式
                .addParams("imSi", MobileInfoUtil.getIMSI(getContext()))
                .addParams("imEi", MobileInfoUtil.getIMEI(getContext()))
                .addParams("meId", MobileInfoUtil.getIMEI(getContext()))
                .addParams("brandType", SystemUtil.getSystemMANUFACTURER())//手机品牌
                .addParams("modelType", SystemUtil.getSystemModel())//手机型号
                .addParams("mobileVersion", SystemUtil.getSystemVersion())//系统版本号
                .build()
                .execute(new HttpCallback<HomeBean>() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
//                        mView.startLoading(true);
                        if (!isRefresh) {
                            mView.addLoadingPage();
                        }

                    }

                    @Override
                    public void onResponse(HomeBean response, int id) {
                        if (response == null) {
                            return;
                        }
                        CusApplication.isMock = response.getObject().getIsMock();
                        CusApplication.MockUrl = response.getObject().getMockUrl();
                        String cache = getCache();
                        SharedPreUtils.putString(CusApplication.mContext, CusConstants.HOMEDATA, cache);
                        if (mView == null) {
                            return;
                        }
                        mView.addContentPage();
                        if (isRefresh) {
                            mView.reFresh(response);
                        } else {
                            mView.setData(response);
                        }
//                        mView.startLoading(false);
//                        mView.stopRefresh();
                    }

                    @Override
                    public void onSuccess(HomeBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        Toast.makeText(mView.getContext(), "网络出小差了，重试一下吧", Toast.LENGTH_SHORT).show();
//                        mView.startLoading(false);
                        Log.e("Exception", e.getMessage() + " ");
                        if (isRefresh) {
                            //TODO 刷新时网络错误
                            mView.stopRefresh();
                        } else {
                            mView.stopRefresh();
                            //TODO 加载时网络错误
                        }
                        mView.addNetErrPage();

                    }

                });

    }

//    private boolean hasBasePhoneAuth() {
//        PackageManager pm = getContext().getPackageManager();
//        for (String auth : authBaseArr) {
//            if (pm.checkPermission(auth, getPackageName()) != PackageManager.PERMISSION_GRANTED) {
//                return false;
//            }
//        }
//        return true;
//    }
//
//    private void initNavi() {
//        // 申请权限
//        if (android.os.Build.VERSION.SDK_INT >= 23) {
//            if (!hasBasePhoneAuth()) {
//                ActivityCompat.requestPermissions((Activity) getContext(), authBaseArr, authBaseRequestCode);
//                return;
//            }
//        }
//    }


    public void locationUpdates(Location location) {

        if (location != null) {
            StringBuilder stringBuilder = new StringBuilder(); //构建一个字符串构建器，用于记录定位信息
            stringBuilder.append("您的位置是：\n");
            stringBuilder.append("经度：");
            stringBuilder.append(location.getLongitude());
            stringBuilder.append("\n纬度：");
            stringBuilder.append(location.getLatitude());
            Log.e("stringBuilder", stringBuilder.toString());
            Log.i("lgq", ".....经度===" + location.getLongitude() + "...纬度+=====" + location.getLatitude());
            Geocoder geocoder = new Geocoder(getContext(), Locale.getDefault());
            try {
                List<Address> addresses = geocoder.getFromLocation(location.getLatitude(),
                        location.getLongitude(), 1);
                if (addresses.size() > 0) {
                    Address address = addresses.get(0);
                    String data = address.toString();
                    int startCity = data.indexOf("locality=") + "locality=".length();
                    int endCity = data.indexOf(",", startCity);
                    city = data.substring(startCity, endCity);
                    int startPlace = data.indexOf("feature=") + "feature=".length();
                    int endplace = data.indexOf(",", startPlace);
                    String place = data.substring(startPlace, endplace);
                    Log.e("city", city + "");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            city = "无法获取地理位置";
        }

        Log.e("position", city);
        Log.e("netType", NetUtils.getNetworkState(getContext()));
        Log.e("version", SystemUtil.getSystemVersion());
        Log.e("accessPort", SystemUtil.getSystemModel());
        Log.e("pnoneType", SystemUtil.getSystemMANUFACTURER());
        Log.e("IMSI", MobileInfoUtil.getIMSI(getContext()));
        Log.e("IMEI", MobileInfoUtil.getIMEI(getContext()));
        homeInfo();
    }


    @Override
    public void getChangeInfo(int times) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.CHANGE_ONE)
                .addParams("times", times + "")
                .build()
                .execute(new HttpCallback<ChangeBean>() {
                    @Override
                    public void onResponse(ChangeBean bean, int id) {
                        // MobclickAgent.onEvent(mView.getContext(),"change", WalleChannelReader.getChannel(mView.getContext()));
                        MobclickAgent.onEvent(mView.getContext(), "change", MutiChannelConfig.getChannel(CusApplication.mContext) + "");

                        mView.setChangeOne(bean);
                    }

                    @Override
                    public void onSuccess(ChangeBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        if (e instanceof SocketTimeoutException) {//超时异常
                            mView.stopRefresh();
                        }
                        if (e instanceof ConnectException) {//连接异常
                            mView.stopRefresh();
                        }
                        mView.error500();
                    }
                });
    }

    @Override
    public void postUvData(HomeBean homeBean, int currentPosi, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;

        if (type == CusConstants.HOMEINFO) {
            productShowId = homeBean.getObject().getList().get(currentPosi).getId();
            position = homeBean.getObject().getList().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getList().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getList().get(currentPosi).getBorrowProduct().getId();
        } else if (type == CusConstants.TOP) {
            productShowId = homeBean.getObject().getTop().get(currentPosi).getId();
            position = homeBean.getObject().getTop().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getTop().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getTop().get(currentPosi).getBorrowProduct().getId();
        } else if (type == CusConstants.MIDDLE) {
            if (homeBean.getObject().getMiddle().size() < currentPosi) {
                return;
            }
            id = homeBean.getObject().getMiddle().get(currentPosi).getBorrowProduct().getId();
            productShowId = homeBean.getObject().getMiddle().get(currentPosi).getId();
            position = homeBean.getObject().getMiddle().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getMiddle().get(currentPosi).getSortIndex();
        } else if (type == CusConstants.BANNER) {
            productShowId = homeBean.getObject().getBanner().get(currentPosi).getId();
            position = homeBean.getObject().getBanner().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getBanner().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getBanner().get(currentPosi).getBorrowProduct().getId();
        } else if (type == CusConstants.REPORTMENT) {
            productShowId = homeBean.getObject().getPaymentReport().get(currentPosi).getId();
            position = homeBean.getObject().getPaymentReport().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getPaymentReport().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getPaymentReport().get(currentPosi).getBorrowProduct().getId();
        } else if (type == CusConstants.POPUP) {
            productShowId = homeBean.getObject().getPopUp().get(currentPosi).getId();
            position = homeBean.getObject().getPopUp().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getPopUp().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getPopUp().get(currentPosi).getPupUpBorrowProductBean().getId();
        } else if (type == CusConstants.ZHUANTI) {

            productShowId = homeBean.getObject().getTop().get(currentPosi).getId();
            position = homeBean.getObject().getTop().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getTop().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getTop().get(currentPosi).getBorrowProduct().getId();
        }
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", position)
                .addParams("sortIndex", sortIndex + "")
                .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
                .addParams("productId", id + "")
                .addParams("actionSerialNumber", CusApplication.random)
                .addParams("userId", CusApplication.object.getUserId() + "")
                .addParams("accessPort", "2")
                .build()
                .execute(new HttpCallback() {
                    @Override
                    public void onSuccess(BaseBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(Object response, int id) {

                    }
                });
        Log.e("show",productShowId + " id"+ id);
    }


}
