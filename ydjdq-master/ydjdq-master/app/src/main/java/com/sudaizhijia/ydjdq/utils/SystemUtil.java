package com.sudaizhijia.ydjdq.utils;

public class SystemUtil {
    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemMANUFACTURER() {
        return android.os.Build.MANUFACTURER;
    }
    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }
    /**
     * 获取当前手机系统版本号
     *
     * @return  系统版本号
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }
}
