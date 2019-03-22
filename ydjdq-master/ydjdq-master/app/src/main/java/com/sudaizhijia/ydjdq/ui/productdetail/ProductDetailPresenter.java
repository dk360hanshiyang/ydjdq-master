package com.sudaizhijia.ydjdq.ui.productdetail;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.BuildConfig;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.event.MessageEvent;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.NetUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.wiget.CodeDialogView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;

import org.greenrobot.eventbus.EventBus;

import java.io.File;

import okhttp3.Call;
import pub.devrel.easypermissions.EasyPermissions;

import static android.content.Context.DOWNLOAD_SERVICE;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class ProductDetailPresenter extends BasePresenterImpl<ProductDetailContract.View> implements ProductDetailContract.Presenter {
    private DownloadManager manager;
    private long downloadId;

    public void openFile(File var0, Context var1) {
        Intent var2 = new Intent();
        var2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        var2.setAction(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri uriForFile = FileProvider.getUriForFile(var1, var1.getApplicationContext().getPackageName() + ".provider", var0);
            var2.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            var2.setDataAndType(uriForFile, var1.getContentResolver().getType(uriForFile));
        } else {
            var2.setDataAndType(Uri.fromFile(var0), getMIMEType(var0));
        }
        try {
            var1.startActivity(var2);
        } catch (Exception var5) {
            var5.printStackTrace();
            Toast.makeText(var1, "没有找到打开此类文件的程序", Toast.LENGTH_SHORT).show();
        }
    }

    private void installApk(File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //放在此处
        //由于没有在Activity环境下启动Activity,所以设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        Uri apkUri = null;
        //判断版本是否是 7.0 及 7.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            apkUri = FileProvider.getUriForFile(mView.getContext(), mView.getContext().getApplicationContext().getPackageName() + ".provider", apkFile);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            apkUri = Uri.fromFile(apkFile);
        }

        intent.setDataAndType(apkUri,
                "application/vnd.android.package-archive");
        mView.getContext().startActivity(intent);
    }

    public String getMIMEType(File var0) {
        String var1 = "";
        String var2 = var0.getName();
        String var3 = var2.substring(var2.lastIndexOf(".") + 1, var2.length()).toLowerCase();
        var1 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(var3);
        return var1;
    }


    @Override
    public void startDownLoad(String url, String productname, Activity activity, HomeBean homeBean) {
        final String DOWNLOAD_FILE_NAME = productname + ".apk";
        String networkState = NetUtils.getNetworkState(getContext());
        if (networkState.equals("无网络") || networkState.equals("3G网络") || networkState.equals("2G网络") || networkState.equals("无网络")) {
            Toast.makeText(activity, "您当前的网络是" + networkState + "可能会下载失败！", Toast.LENGTH_SHORT).show();
        }
//        OkHttpUtils.get()
//                .url(url)
//                .build()
//                .execute(new FileCallBack(Environment.getExternalStorageDirectory().getAbsolutePath(), productname + ".apk") {
//                    @Override
//                    public void onError(Call call, Exception e, int id) {
//                        mView.showDownLoadView(false);
//                    }
//
//                    @Override
//                    public void inProgress(float progress, long total, int id) {
//                        super.inProgress(progress, total, id);
//                        int v = (int) (progress * 100);
//                        EventBus.getDefault().post(new MessageEvent(v));
//                    }
//
//                    @Override
//                    public void onResponse(File downloadFile, int id) {
//                        mView.showDownLoadView(true);
//                        installApk(downloadFile);

//                    }
//                });
        manager = (DownloadManager) activity.getSystemService(DOWNLOAD_SERVICE);
        DownloadManager.Query query = new DownloadManager.Query();
        query.setFilterById(downloadId);
        query.setFilterByStatus(DownloadManager.STATUS_RUNNING);//正在下载
        Cursor c = manager.query(query);
        if (c.moveToNext()) {
            //正在下载中，不重新下载
            Toast.makeText(activity, productname + "正在下载中！", Toast.LENGTH_SHORT).show();
        } else {
            mView.calcuteDownload();
//            Toast.makeText(activity, productname + "已经开始下载！", Toast.LENGTH_SHORT).show();
            Display display = activity.getWindowManager().getDefaultDisplay();
            // 获取屏幕高度
            int height = display.getHeight();
            Toast toast = Toast.makeText(activity, productname + "正在下载，下拉状态栏可查看下载进度", Toast.LENGTH_LONG);
            // 这里给了一个1/4屏幕高度的y轴偏移量
            toast.setGravity(Gravity.TOP, 0, height / 6);
            toast.show();
            //创建下载请求
            DownloadManager.Request down = new DownloadManager.Request(Uri.parse(url));
            //设置允许使用的网络类型，这里是移动网络和wifi都可以
            down.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
            //显示在下载界面，即下载后的文件在系统下载管理里显示
            down.setVisibleInDownloadsUi(true);
            //设置下载标题
            down.setTitle(productname);
            //显示Notification
            down.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE);
            //设置下载后文件存放的位置，在SDCard/Android/data/你的应用的包名/files/目录下面
            down.setDestinationInExternalFilesDir(activity, null, DOWNLOAD_FILE_NAME);
            //将下载请求放入队列,返回值为downloadId
            downloadId = manager.enqueue(down);

            String cache = SharedPreUtils.getString(getContext(), CusConstants.HOMEDATA, "");
            if (!TextUtils.isEmpty(cache)) {
                HomeBean homeBean2 = new Gson().fromJson(cache, HomeBean.class);
                if (homeBean2 != null) {
                    if (homeBean2.getObject() != null) {
                        if (homeBean2.getObject().getDownLoadPreview() != null && homeBean2.getObject().getDownLoadPreview().size() > 0) {
                            mView.showDialog(homeBean2);
                        }
                    }
                }
            }
        }

    }

    private void showRecommendDialog(Activity activity) {

    }

    @Override
    public void postDownloadData(int productId, String random) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.STATISTICS_DOWNLOAD)
                .addParams("productId", productId + "")
                .addParams("actionSerialNumber", random)
                .build()
                .execute(new HttpCallback() {
                    @Override
                    public void onResponse(Object response, int id) {

                    }

                    @Override
                    public void onSuccess(BaseBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });
    }

    @Override
    public void postRegisterData(int productId, String random) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.STATISTICS_REGISTER)
                .addParams("productId", productId + "")
                .addParams("actionSerialNumber", random)
                .build()
                .execute(new HttpCallback() {
                    @Override
                    public void onResponse(Object response, int id) {

                    }

                    @Override
                    public void onSuccess(BaseBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });
    }

    @Override
    public void postUvData(HomeBean homeBean, int currentPosi, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int positionId = 0;
        int sortIndex = 0;
        int id = 0;

        if (type == CusConstants.HOMEINFO) {
            productShowId = homeBean.getObject().getList().get(currentPosi).getId();
            position = homeBean.getObject().getList().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getList().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getList().get(currentPosi).getBorrowProduct().getId();
            positionId = homeBean.getObject().getList().get(currentPosi).getPositionId();
        } else if (type == CusConstants.TOP) {
            productShowId = homeBean.getObject().getTop().get(currentPosi).getId();
            position = homeBean.getObject().getTop().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getTop().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getTop().get(currentPosi).getBorrowProduct().getId();
            positionId = homeBean.getObject().getTop().get(currentPosi).getPositionId();
        } else if (type == CusConstants.MIDDLE) {
            if (homeBean.getObject().getMiddle().size() < currentPosi) {
                return;
            }
            id = homeBean.getObject().getMiddle().get(currentPosi).getBorrowProduct().getId();
            productShowId = homeBean.getObject().getMiddle().get(currentPosi).getId();
            position = homeBean.getObject().getMiddle().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getMiddle().get(currentPosi).getSortIndex();
            positionId = homeBean.getObject().getMiddle().get(currentPosi).getPositionId();
        } else if (type == CusConstants.BANNER) {
            productShowId = homeBean.getObject().getBanner().get(currentPosi).getId();
            position = homeBean.getObject().getBanner().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getBanner().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getBanner().get(currentPosi).getBorrowProduct().getId();
            positionId = homeBean.getObject().getBanner().get(currentPosi).getPositionId();
        } else if (type == CusConstants.REPORTMENT) {
            productShowId = homeBean.getObject().getPaymentReport().get(currentPosi).getId();
            position = homeBean.getObject().getPaymentReport().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getPaymentReport().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getPaymentReport().get(currentPosi).getBorrowProduct().getId();
            positionId = homeBean.getObject().getPaymentReport().get(currentPosi).getPositionId();
        } else if (type == CusConstants.DUWNLOAD) {
            productShowId = homeBean.getObject().getDownLoadPreview().get(currentPosi).getId();
            position = homeBean.getObject().getDownLoadPreview().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getDownLoadPreview().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getDownLoadPreview().get(currentPosi).getBorrowProductDown().getId();
            positionId = homeBean.getObject().getDownLoadPreview().get(currentPosi).getPositionId();
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
}
