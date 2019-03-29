package com.sudaizhijia.ydjdq.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.sudaizhijia.ydjdq.global.CusConstants;

/**
 * Created by WilliamWang on 2018/12/3
 */
public class SharedPreUtils {

    private static SharedPreferences sp;

    private static SharedPreferences getInstance(Context context) {
        if (sp == null) {
            sp = context.
                    getSharedPreferences(CusConstants.sharedPreName, Context.MODE_PRIVATE);
        }

        return sp;
    }

    public static String getString(Context context, String key, String defValue) {
        String value = getInstance(context).getString(key, defValue);
        return value;
    }

    public static void putString(Context context, String key, String value) {
        getInstance(context).edit().putString(key, value).commit();
    }

    public static boolean getBoolean(Context context, String key, Boolean defValue) {
        boolean value = getInstance(context).getBoolean(key, defValue);
        return value;
    }

    public static void putBoolean(Context context, String key, boolean value) {
        getInstance(context).edit().putBoolean(key, value).commit();
    }

    public static void clearAll(Context context) {
        getInstance(context).edit().clear().commit();

    }

}
