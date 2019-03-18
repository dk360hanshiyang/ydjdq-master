package com.sudaizhijia.ydjdq.utils;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;

import com.sudaizhijia.ydjdq.BuildConfig;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;

import java.io.File;

/**
 * Author: William Wang
 * Date:   On 2018/12/7
 */
public class InstallApkUtils {


    Activity context;

    public InstallApkUtils(Activity context) {
        this.context = context;
    }

    public void installApk(File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            boolean b = context.getPackageManager().canRequestPackageInstalls();
            if (b) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(context.getApplicationContext(),
                        BuildConfig.APPLICATION_ID + ".fileProvider", apkFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                context.startActivity(intent);
            } else {
                //请求安装未知应用来源的权限
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                //设置构造器标题
                builder.setTitle("提示");
                //构造器对应的图标
                builder.setIcon(R.mipmap.ic_launcher);
                //构造器内容,为对话框设置文本项(之后还有列表项的例子)
                builder.setMessage("Android8.0安装应用需要打开未\n知来源权限，请去设置中开启权限");
                builder.setPositiveButton("是呀", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which)
                    {
                        String[] mPermissionList = new String[]{Manifest.permission.REQUEST_INSTALL_PACKAGES};
                        ActivityCompat.requestPermissions(context, mPermissionList, 2);
                    }
                });
                //为构造器设置取消按钮,若点击按钮后不需要做任何操作则直接为第二个参数赋值null
                builder.setNegativeButton("不呀", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                Uri contentUri = FileProvider.getUriForFile(context.getApplicationContext(),
                        BuildConfig.APPLICATION_ID + ".fileProvider", apkFile);
                intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
                context.startActivity(intent);
            } else {
                intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        }

    }


}
