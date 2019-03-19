package com.sudaizhijia.ydjdq.global;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.Html;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.DownloadProgress;
import com.sudaizhijia.ydjdq.bean.UpDateBean;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.service.UpDateService;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.StringUtils;
import com.sudaizhijia.ydjdq.wiget.MyDialog;
import com.sudaizhijia.ydjdq.wiget.VersionDialog;
import com.zhy.http.okhttp.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.List;

import okhttp3.Call;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * 更新管理类
 * Created by wangqiang on 2017/7/3.
 */

public class UpdateManager implements EasyPermissions.PermissionCallbacks {
    private Activity context;
    private ProgressBar progressBar;
    private TextView tv_progress;
    private Dialog progressDialog;
    private MyDialog updateDialog;
    private boolean canBack = true;
    public boolean isInApp;


    public UpdateManager(Activity context) {
        this.context = context;
//        initPermission();
        EventBus.getDefault().register(this);
    }

    private static String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_PHONE_STATE,
    };
//    private static final int REQUEST_PERMISSION = 1;
//    private void initPermission() {
////        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE};
//        if (EasyPermissions.hasPermissions(context, PERMISSIONS)) {
//            // 已获取权限
//            // ...
//
//        } else {
//            // 没有权限，现在去获取
//            // ...
//            EasyPermissions.requestPermissions(context, " 您好，为了给您提供更好的服务，你需要同意一下权限，谢谢",
//                    REQUEST_PERMISSION, PERMISSIONS);
//        }
//    }

    /**
     * 检查更新
     */
    public void fetchUpdate(boolean first) {
        OkHttpUtils.post().tag(this.getClass().getSimpleName())
                .url(API.UPDATEAPP)
                .build()
                .execute(new HttpCallback<UpDateBean>() {
                    @Override
                    public void onSuccess(UpDateBean response, int id) {
                        if (response.code == 1 && response.getObject() != null) {
                            //判断是否是强制更新
                            int versionCode = AppInfoUtil.getVersionCode(CusApplication.mContext);
                            int normalUpdateNo = response.getObject().getNormalUpdateNo();
                            int forceUpdateNo = response.getObject().getForcedUpdateNo();
                            if (versionCode < forceUpdateNo) {
                                CusApplication.isUpdate = true;
                                //强制更新
//                                showUpdateDialog(response.getObject(), true);
                                showUpdateDialog1(response.getObject(), true);
                            } else if (versionCode < normalUpdateNo) {
                                CusApplication.isUpdate = true;
                                //普通更新
//                                showUpdateDialog(response.getObject(), false);
                                showUpdateDialog1(response.getObject(), false);
                            } else if (versionCode >= normalUpdateNo) {
                                if (!first) {
                                    Toast.makeText(context, "已经是最新版本", Toast.LENGTH_LONG).show();
                                }
                            }

                        }
                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });

    }

    private void showUpdateDialog1(UpDateBean.ObjectBean object, boolean isForceUpdate) {
        View view = View.inflate(context, R.layout.dialog_update_version, null);
        TextView txtUpdateVetsion = view.findViewById(R.id.txt_update_vetsion);
        TextView txtUpdateVetsionCode = view.findViewById(R.id.txt_update_versioncode);
        txtUpdateVetsionCode.setText("V" + AppInfoUtil.getVersionName(context));
        TextView txtUpdataDetail = view.findViewById(R.id.txt_updata_detail);
        Button btnUpdateVersion = view.findViewById(R.id.btn_update_version);
        ImageView imgCloseUpdateVersion = view.findViewById(R.id.img_close_update_version);
        imgCloseUpdateVersion.setVisibility(isForceUpdate ? View.GONE : View.VISIBLE);
        VersionDialog versionDialog = new VersionDialog(context, ViewGroup.LayoutParams.MATCH_PARENT - 1,
                ViewGroup.LayoutParams.MATCH_PARENT, view, R.style.dialog);
        versionDialog.setCanceledOnTouchOutside(false);
        versionDialog.setCancelable(!isForceUpdate);
        txtUpdataDetail.setText(Html.fromHtml(object.getUpdateDetail()));
        imgCloseUpdateVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                versionDialog.dismiss();
            }
        });
        btnUpdateVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                versionDialog.dismiss();
                download(object.getDownloadUrl());
            }
        });
        btnUpdateVersion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                versionDialog.dismiss();
                download(object.getDownloadUrl());
            }
        });
        versionDialog.show();
    }


    /**
     * 弹出更新对话框
     *
     * @param object
     */
    private void showUpdateDialog(final UpDateBean.ObjectBean object, boolean isForceUpdate) {
        View view = View.inflate(context, R.layout.dialog_update, null);
        TextView tv_updata_detail = (TextView) view.findViewById(R.id.tv_updata_detail);
        Button bt_updata = (Button) view.findViewById(R.id.bt_updata);
        Button bt_cancle = (Button) view.findViewById(R.id.bt_cancle);
        LinearLayout ll_normalupdate = (LinearLayout) view.findViewById(R.id.ll_upDate);
        Button bt_forceUpdate = (Button) view.findViewById(R.id.bt_forceUpdate);
        ll_normalupdate.setVisibility(isForceUpdate ? View.GONE : View.VISIBLE);
        bt_forceUpdate.setVisibility(isForceUpdate ? View.VISIBLE : View.GONE);
        updateDialog = new MyDialog(context, AppInfoUtil.dip2px(context, 300),
                AppInfoUtil.dip2px(context, 350), view, R.style.dialog);
        updateDialog.setCanceledOnTouchOutside(false);
        updateDialog.setCancelable(!isForceUpdate);
//        tv_new_version.setText("最新版本 V" + object.getVersionName());
//        RichText.fromHtml(object.getUpdateDetail()).into(tv_updata_detail);
        tv_updata_detail.setText(Html.fromHtml(object.getUpdateDetail()));
        bt_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDialog.dismiss();
            }
        });
        bt_updata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDialog.dismiss();
                download(object.getDownloadUrl());
            }
        });
        bt_forceUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDialog.dismiss();
                download(object.getDownloadUrl());
            }
        });
        updateDialog.show();
    }

    private void download(String url) {
        if (StringUtils.isEmpty(url)) {
            return;
        }
//      NetworkStatusHelper.NetworkStatus status = NetworkStatusHelper.getStatus();
        UpDateService.downloadApp(context, url);
        showProgressDialog();
    }

    /**
     * 下载进度对话框
     */
    public void showProgressDialog() {


        View view = View.inflate(context, R.layout.dialog_progress, null);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        tv_progress = (TextView) view.findViewById(R.id.tv_progress2);
        progressDialog = new MyDialog(context, AppInfoUtil.dip2px(context, 300),
                LinearLayout.LayoutParams.WRAP_CONTENT, view, R.style.dialog);
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setCancelable(false);
        progressDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                //正在更新的时候,点击返回按钮回到桌面
                if (keyCode == KeyEvent.KEYCODE_BACK && isInApp && progressDialog.isShowing()) {
                    backHome();
                    return true;
                }
                return false;
            }
        });
        progressDialog.show();
    }

    /**
     * 返回桌面
     */
    public void backHome() {
        //回到桌面
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addCategory(Intent.CATEGORY_HOME);
        context.startActivity(intent);
        isInApp = false;
    }

    /**
     * 下载进度回调
     *
     * @param p
     */
    @Subscribe(threadMode = ThreadMode.MAIN) //在ui线程执行
    public void onReceiveDownloadProgress(DownloadProgress p) {
        try {
            int progress = (int) (p.progress * 100);
            if (progressDialog == null) {
                showProgressDialog();
            }
            if (progressBar != null) {
                progressBar.setProgress(progress);
            }
            if (tv_progress != null) {
                tv_progress.setText(progress + "%");
            }
            if (progress >= 100) {
                progressDialog.dismiss();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onDestory() {
        OkHttpUtils.getInstance().cancelTag(this.getClass().getSimpleName());
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(context, "授权成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        if (EasyPermissions.somePermissionPermanentlyDenied(context, perms)) {
            new AppSettingsDialog.Builder(context).build().show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }
}
