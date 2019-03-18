package com.sudaizhijia.ydjdq.utils;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Author: William Wang
 * Date:   On 2018/11/21
 */
public class AppInfoUtil {


    public static boolean checkLogin(Context mcontext){
        if (!CusApplication.isLogin) {
            mcontext.startActivity(new Intent(mcontext, LoginActivity.class));
            return false;
        }
        return true;
    }
    /**
     * 根据手机的分辨率从 dip 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 获取版本号
     *
     * @param context 上下文
     * @return 版本号
     */
    public static int getVersionCode(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 方法描述：获取版本名称
     *
     * @param context 上下文
     * @return 版本名称
     */
    public static String getVersionName(Context context) {
        PackageInfo packageInfo = null;
        try {
            packageInfo = context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            LogUtils.e("资源文件写入本地发生错误，错误信息：" + e.getMessage());
        }
        return null;
    }

    /**
     * 方法描述：将资源目录下文件写入本地
     *
     * @param context  上下文
     * @param fileName 资源目录文件名
     * @param path     写入本地的路径名
     * @return 是否成功
     */
    public static boolean retrieveApkFromAssets(Context context,
                                                String fileName, String path) {

        boolean bRet = false;

        try {
            InputStream is = context.getAssets().open(fileName);

            File file = new File(path);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);

            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }

            fos.close();
            is.close();
            bRet = true;
        } catch (IOException e) {
            e.printStackTrace();
            LogUtils.e("资源文件写入本地发生错误，错误信息：" + e.getMessage());
        }

        return bRet;

    }

    /**
     * [获取应用程序版本名称信息]
     * @param context
     * @return 当前应用的版本名称
     */
    public static synchronized String getPackageName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.packageName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 获取渠道号
     *
     * @param context
     * @return
     */
    public static String getChannel(Context context) {
        String channel = "";

        try {
            ApplicationInfo applicationInfo = context.getPackageManager().
                    getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            if (applicationInfo != null && applicationInfo.metaData != null) {
                String metaData = applicationInfo.metaData.getString(CusConstants.CHANNEL);
                if (!metaData.isEmpty()) {
                    channel = metaData;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return channel;
    }

    /**
     * 将流转换为字符串
     *
     * @param is
     * @return
     */
    public static String convertStreamToString(InputStream is) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is));

        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 方法描述：给文件加时间戳
     */
    public static void updateFileTime(String dir, String fileName) {
        File file = new File(dir, fileName);
        long newModifiedTime = System.currentTimeMillis();
        file.setLastModified(newModifiedTime);
    }

    /**
     * 方法描述：获取文件时间戳
     */
    public static long getFileTime(String dir, String fileName) {
        File file = new File(dir, fileName);
        return file.lastModified();
    }


    /**
     * 方法描述：检查SD卡是否存在
     */
    public static boolean isExistSDCard() {
        if (Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }

    }
    /**
     * 时间戳（只是服务器做记录）
     * @return
     */
//    public static String getTimestap() {
//        return DateUtil.format(new Date(), DateUtil.PIN_PATTERN_DATE_MINUTE);
//    }

/*    public static String getIMSI(Context context) {

        String imsi = (String) sharedpreUtils.getParam(context, CusConstants.IMSI, "");

        if (TextUtils.isEmpty(imsi)) {
            TelephonyManager telephonyManager = (TelephonyManager) context.
                    getSystemService(Context.TELEPHONY_SERVICE);

            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return TODO;
            }
            imsi = telephonyManager.getSubscriberId();
        }

    }*/

    /**
     * 验证手机格式
     */
    public static boolean isMobile(String number) {
    /*
    移动：134、135、136、137、138、139、150、151、152、157(TD)、158、159、178(新)、182、184、187、188
    联通：130、131、132、152、155、156、185、186
    电信：133、153、170、173、177、180、181、189、（1349卫通）
    总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
    */
        String num = "[1][34578]\\d{9}";//"[1]"代表第1位为数字1，"[34578]"代表第二位可以为3、4、5、7、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(number)) {
            return false;
        } else {
            //matches():字符串是否在给定的正则表达式匹配
            return number.matches(num);
        }
    }

    /**
     * 获取手机IMEI
     *
     * @param context
     * @return
     */
    public static final String getIMEI(Context context) {
        try {
            //实例化TelephonyManager对象
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            //获取IMEI号
            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                //                                          int[] grantResults)
                // to handle the case where the user grants the permission. See the documentation
                // for ActivityCompat#requestPermissions for more details.
                return "no obtain";
            }
            String imei = telephonyManager.getDeviceId();
            //在次做个验证，也不是什么时候都能获取到的啊
            if (imei == null) {
                imei = "no obtain";
            }
            return imei;
        } catch (Exception e) {
            e.printStackTrace();
            return "no obtain";
        }

    }
    public static String getAppMetaData(Context ctx, String key) {
        if (ctx == null || TextUtils.isEmpty(key)) {
            return null;
        }
        String resultData = null;
        try {
            PackageManager packageManager = ctx.getPackageManager();
            if (packageManager != null) {
                ApplicationInfo applicationInfo = packageManager.getApplicationInfo(ctx.getPackageName(), PackageManager.GET_META_DATA);
                if (applicationInfo != null) {
                    if (applicationInfo.metaData != null) {
                        resultData = applicationInfo.metaData.getString(key);
                    }
                }

            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return resultData;
    }

    public static String getNowTime(){
        Calendar calendar=Calendar.getInstance();  //获取当前时间，作为图标的名字
        String year=calendar.get(Calendar.YEAR)+"";
        String month=calendar.get(Calendar.MONTH)+1+"";
        String day=calendar.get(Calendar.DAY_OF_MONTH)+"";
        String hour=calendar.get(Calendar.HOUR_OF_DAY)+"";
        String minute=calendar.get(Calendar.MINUTE)+"";
        String second=calendar.get(Calendar.SECOND)+"";
        String time=year+month+day+hour+minute+second;
        Random rand = new Random();
        int i = rand.nextInt(1000);
        String random = time + i;
        return random;
    }

    public static String UrlEncoder(String s) {
        try {
            return 	URLEncoder.encode(s, "utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }


}
