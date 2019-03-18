package com.sudaizhijia.ydjdq.utils;

import android.util.Log;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * Author: William Wang
 * Date:   On 2018/11/16
 * Log管理类
 */
public class LogUtils {

    public static boolean mIsDebug;


    public static void init(boolean isDebug) {
        mIsDebug = isDebug;

        if (isDebug) {
            Logger.addLogAdapter(new AndroidLogAdapter());
        }
        Log.e("logUtil", "LogUtils is " + (mIsDebug ? "isOpen" : "isClose"));
    }

    public static void d(String msg) {
        if (mIsDebug) {
            Logger.d(msg);
        }
    }

    public static void e(String o) {
        if (mIsDebug) {
            Logger.e(o);
        }
    }

    public static void i(String o) {
        if (mIsDebug) {
            Logger.i(o);
        }
    }


    public static void json(String json) {
        if (mIsDebug) {
            Logger.json(json);
        }
    }


    public static void v(String o) {
        if (mIsDebug) {
            Logger.v(o);
        }
    }

    public static void w(String o) {
        if (mIsDebug) {
            Logger.w(o);
        }
    }


    public static void wtf(String o) {
        if (mIsDebug) {
            Logger.wtf(o);
        }
    }

    public static void xml(String xml) {
        if (mIsDebug) {
            Logger.xml(xml);
        }
    }


}
