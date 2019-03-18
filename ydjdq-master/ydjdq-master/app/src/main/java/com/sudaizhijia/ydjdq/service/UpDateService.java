package com.sudaizhijia.ydjdq.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.util.Log;

import com.sudaizhijia.ydjdq.bean.DownloadProgress;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.utils.AppManager;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import okhttp3.Response;

/**
 * 用于app更新
 * Created by wangqiang.
 */

public class UpDateService extends IntentService {
    private static final String ACTION_DOWNLOAD = "downloadapp";

    private DownloadProgress progress;

    public UpDateService() {
        super("");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public UpDateService(String name) {
        super(name);
    }
    public static void downloadApp(Context context, String url) {
        Intent intent = new Intent(context, UpDateService.class);
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(CusConstants.path, url);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if (ACTION_DOWNLOAD.equals(action)) {
                //开始下载
                String url = intent.getStringExtra(CusConstants.path);
                startDownload(url);
            }
        }
    }

    private void startDownload(String urlss) {
//        LogUtils.i("开始下载");
        final String downloadUrl = urlss;

//            final File file = new File(UpdateService.getDownloadDir(updateServiceWeakReference.get()),
//                    UpdateService.getSaveFileName(downloadUrl));
        final File file = new File(CusConstants.filePath, System.currentTimeMillis() + ".apk");
        File dir = file.getParentFile();
        if (!dir.exists()) {
            dir.mkdirs();
        }
        HttpURLConnection httpConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        int updateTotalSize = 0;
        URL url;
        try {
            url = new URL(downloadUrl);
            httpConnection = (HttpURLConnection) url.openConnection();
            httpConnection.setConnectTimeout(20000);
            httpConnection.setReadTimeout(20000);

            Log.d("wangqiang", "download status code: " + httpConnection.getResponseCode());

            if (httpConnection.getResponseCode() != 200) {
                return;
            }

            updateTotalSize = httpConnection.getContentLength();
//            LogUtils1.i("wangqiang", "总大小：" + updateTotalSize / 1024.0 / 1024.0);
            if (file.exists()) {
                if (updateTotalSize == file.length()) {
                    // 下载完成
//                        return file.getAbsolutePath();
//                    installIntent(file.getAbsolutePath());
                    installApk(file);
                } else {
                    file.delete();
                }
            }
            file.createNewFile();
            is = httpConnection.getInputStream();
            fos = new FileOutputStream(file, false);
            byte buffer[] = new byte[4096];

            int readSize = 0;
            int currentSize = 0;

            while ((readSize = is.read(buffer)) > 0) {
                fos.write(buffer, 0, readSize);
                currentSize += readSize;
//                    publishProgress((currentSize * 100 / updateTotalSize));
//                LogUtils1.i("wangqiang", (currentSize * 1.0f / updateTotalSize) + "");
                progress.progress = currentSize * 1.0f / updateTotalSize;
                progress.total = updateTotalSize;
                EventBus.getDefault().post(progress);
            }
            // download success
        } catch (Exception e) {
            e.printStackTrace();
            return;
        } finally {
            if (httpConnection != null) {
                httpConnection.disconnect();
            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        installApk(file);
//        installIntent(file.getAbsolutePath());
    }
    private void installApk(File apkFile) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        //放在此处
        //由于没有在Activity环境下启动Activity,所以设置下面的标签
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Uri apkUri = null;
        //判断版本是否是 7.0 及 7.0 以上
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            apkUri = FileProvider.getUriForFile(CusApplication.mContext, CusApplication.mContext.getApplicationContext().getPackageName() + ".provider", apkFile);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            apkUri = Uri.fromFile(apkFile);
        }

        intent.setDataAndType(apkUri,
                "application/vnd.android.package-archive");
        CusApplication.mContext.startActivity(intent);
    }
    /**
     * 安装app
     *
     * @param path
     * @return
     */
    private Intent installIntent(String path) {
        Uri uri = Uri.fromFile(new File(path));
        Intent installIntent = new Intent(Intent.ACTION_VIEW);
        installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        installIntent.setDataAndType(uri, "application/vnd.android.package-archive");
        startActivity(installIntent);
        //
        AppManager.getInstance().AppExit();
        return installIntent;
    }

    public File saveFile(Response response, String filedir, String fileName) throws IOException {
        InputStream is = null;
        byte[] buf = new byte[2048];
        int len = 0;
        FileOutputStream fos = null;
        try {
            is = response.body().byteStream();
            final long total = response.body().contentLength();

            long sum = 0;

            File dir = new File(filedir);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            File file = new File(dir, fileName);
            if (file.exists() && file.length() == total) {
                //如果file已经存在,并且大小于要下载的相同,直接return
                progress.progress = 1;
                EventBus.getDefault().post(progress);
                return file;
            }
            fos = new FileOutputStream(file);
            while ((len = is.read(buf)) != -1) {
                sum += len;
                fos.write(buf, 0, len);
                final long finalSum = sum;
                progress.progress = finalSum * 1.0f / total;
                progress.total = total;
                EventBus.getDefault().post(progress);
            }
            fos.flush();

            return file;

        } finally {
            try {
                response.body().close();
                if (is != null) is.close();
            } catch (IOException e) {
            }
            try {
                if (fos != null) fos.close();
            } catch (IOException e) {
            }

        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        progress = new DownloadProgress();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        progress = null;
    }
}
