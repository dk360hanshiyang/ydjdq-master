package com.sudaizhijia.ydjdq.service;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.widget.Toast;

import java.io.File;

public class DownloadCompleteReceiver extends BroadcastReceiver {
    private DownloadManager manager;
    private String fileName;

    @Override
    public void onReceive(Context context, Intent intent) {
        manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
        if (intent.getAction().equals(DownloadManager.ACTION_DOWNLOAD_COMPLETE)) {
            //通过downloadId去查询下载的文件名
            long downloadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);
            Cursor myDownload = manager.query(query);
            if (myDownload.moveToFirst()) {
                int fileNameIdx = myDownload.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI);
                String fileUri = myDownload.getString(fileNameIdx);
                if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
                    if (fileUri != null) {
                        fileName = Uri.parse(fileUri).getPath();
                    }
                } else {
                    //Android 7.0以上的方式：请求获取写入权限，这一步报错
                    //过时的方式：DownloadManager.COLUMN_LOCAL_FILENAME
                    int fileNameIdx2 = myDownload.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);
                    fileName = myDownload.getString(fileNameIdx2);
                }
                installAPK(fileName, context);
            }
        }
    }

    //安装APK
    private void installAPK(String filePath, Context context) {
        Intent intent = new Intent();
        if (!TextUtils.isEmpty(filePath)) {
            if (filePath.endsWith(".apk")) {
                if (Build.VERSION.SDK_INT >= 24) {//判读版本是否在7.0以上
                    File file = new File(filePath);
                    Uri apkUri = FileProvider.getUriForFile(context, "com.sudaizhijia.ydjdq.provider", file);//在AndroidManifest中的android:authorities值
                    Intent install = new Intent(Intent.ACTION_VIEW);
                    install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    install.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);//添加这一句表示对目标应用临时授权该Uri所代表的文件
                    install.setDataAndType(apkUri, "application/vnd.android.package-archive");
                    context.startActivity(install);
                } else {
                    Intent install = new Intent(Intent.ACTION_VIEW);
                    install.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
                    install.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(install);
                }
            }
//        //判断是否是AndroidN以及更高的版本
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
//            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//            Uri contentUri = FileProvider.getUriForFile(context, BuildConfig.APPLICATION_ID + ".fileProvider", new File(filePath));
//            intent.setDataAndType(contentUri, "application/vnd.android.package-archive");
//        } else {
//            intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//
//        }


//
//        intent.setAction("android.intent.action.VIEW");
//        intent.addCategory("android.intent.category.DEFAULT");
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);//广播里面操作需要加上这句，存在于一个独立的栈里
//        intent.setDataAndType(Uri.fromFile(new File(filePath)), "application/vnd.android.package-archive");
//        context.startActivity(intent);
        } else {
            Toast.makeText(context, "服务器错误，下载失败！请稍后再试", Toast.LENGTH_LONG).show();
        }
    }
}
