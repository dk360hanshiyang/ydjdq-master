package com.sudaizhijia.ydjdq.splash;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.LoginBean;
import com.sudaizhijia.ydjdq.bean.SplashBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.ActivityUtils;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.utils.StringUtils;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by WilliamWang on 2018/12/11
 */

public class SplashPresenter extends BasePresenterImpl<SplashContract.View> implements SplashContract.Presenter {

    @Override
    public void postLogin() {
        String userId = SharedPreUtils.getString(mView.getContext(), CusConstants.USER_ID, "");
        String token = SharedPreUtils.getString(mView.getContext(), CusConstants.TOKEN, "");
        //登录操作（有id和token的时候直接登录）
        if (!TextUtils.isEmpty(userId + "") && !TextUtils.isEmpty(token)) {
            // userid和token以前都有的情况
            OkHttpUtils.post().tag(getTag())
                    .url(API.RE_LOGIN)
                    .build().execute(new HttpCallback<LoginBean>(false) {
                @Override
                public void onSuccess(LoginBean response, int id) {
                    if (response != null && response.code == 1 && response.getObject() != null) {

                        CusApplication.isLogin = true;
                        CusApplication.object = response.getObject();
                        CusApplication.setAuth(true);
//                             保存token和userId
                        String userId = response.getObject().getUserId() + "";
                        String token = response.getObject().getToken();
                        SharedPreUtils.putString(getContext(), CusConstants.USER_ID, userId);
                        SharedPreUtils.putString(getContext(), CusConstants.TOKEN, token);
//                        LogUtils.i("重新登录成功！userId = " + userId + ",token = " + token);
                        mView.showJump();
                        MobclickAgent.onProfileSignIn(userId+"");
                        //注册成功后添加友盟添加友盟推送标签
//                        ApkUtils.addPushTag(context, ApkUtils.REGISTER);
                    } else {
//                        LogUtils.e("重新登录失败！");
                        // 如果获取失败,将状态变成未登录，id和token置空
                        makeNoLogin();
                        mView.showJump();
                    }
                }

                @Override
                public void onFail(Call call, Exception e, int id) {
                    makeNoLogin();
//                    LogUtils.e("重新登录出错！");
                    mView.showJump();
                }
            });
        }
    }

    @Override
    public void startAndFinish() {


    }

    @Override
    public void getStartPage() {
        OkHttpUtils.post().tag(getTag())
                .url(API.START_PAGE)
                .build().execute(new HttpCallback<SplashBean>() {

            @Override
            public SplashBean parseNetworkResponse(Response response, int id) throws Exception {
                String cache = getCache();
                SharedPreUtils.putString(mView.getContext(), CusConstants.SPLASH, cache);
                return super.parseNetworkResponse(response, id);
            }

            @Override
            public void onResponse(SplashBean response, int id) {
                mView.setData(response);
            }

            @Override
            public void onSuccess(SplashBean response, int id) {

            }

            @Override
            public void onFail(Call call, Exception e, int id) {
//                Toast.makeText(CusApplication.mContext, "", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void postUvData(SplashBean bean, int position1, int type) {
        if (bean == null) {
            {
                return;
            }
        }
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int positionId = 0;
        int id = 0;

        if (type == CusConstants.SPLASH_TYPE) {
            if(bean.getObject() == null || bean.getObject().getProductList().size() <= 0 ){
                return;
            }
            productShowId = bean.getObject().getProductList().get(position1).getId();
            position = bean.getObject().getProductList().get(position1).getPosition().getKey();
            sortIndex = bean.getObject().getProductList().get(position1).getSortIndex();
            id = bean.getObject().getProductList().get(position1).getBorrowProduct().getId();
            positionId = bean.getObject().getProductList().get(position1).getPositionId();
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
                .addParams("positionId", positionId + "")
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
    }

    public void makeNoLogin() {
        CusApplication.isLogin = false;
        CusApplication.object.setUserId(-99);
        CusApplication.object.setToken("");


    }

}
