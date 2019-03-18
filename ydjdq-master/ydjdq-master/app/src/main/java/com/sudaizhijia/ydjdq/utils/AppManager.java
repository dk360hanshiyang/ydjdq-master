package com.sudaizhijia.ydjdq.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * Author: 王强
 * Version:  1.0
 * Date:    2018/8/27
 * Modify:
 * Description:
 * Copyright notice:
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager mAppManager;

    public AppManager() {
    }

    public static AppManager getInstance() {
        if (mAppManager == null) {
            synchronized (AppManager.class) {
                if (mAppManager == null)
                    mAppManager = new AppManager();
            }
        }
        return mAppManager;
    }

    public void addActivity(Activity activity) {
        if (activityStack == null) {
            activityStack = new Stack<>();
        }
        activityStack.add(activity);
        LogUtils.i("AppManager add " + activity.getClass().getSimpleName() + " is Success.");
    }

    public void removeActivity(Activity activity) {
        if (activityStack != null) {
            activityStack.remove(activity);
            LogUtils.i("AppManager remove" + activity.getClass().getSimpleName() + "is Success.");
        }
    }

    /**
     * 获取指定的Activity
     *
     * @param clazz
     * @return
     */
    public Activity getActivity(Class<?> clazz) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(clazz)) {
                    return activity;
                }
            }
        }
        return null;
    }

    /**
     * 获取当前 Activity
     *
     * @return
     */
    public Activity getLastActivity() {
        if (activityStack != null) {
            Activity activity = activityStack.lastElement();
            return activity;
        }
        return null;

    }

    /**
     * 获取所有的Activity
     *
     * @return
     */
    public Stack<Activity> getAllActivityStacks() {
        return activityStack;
    }

    /**
     * 关闭指定Activity
     *
     * @param activity
     */
    public void finishActivity(Activity activity) {
        if (activity != null) {
            if (!activity.isFinishing()) {
                activity.finish();
                activityStack.remove(activity);
            }
        }
    }

    /**
     * 关闭指定类名的Activity
     *
     * @param clazz
     */
    public void finishActivity(Class<?> clazz) {
        if (activityStack != null) {
            for (Activity activity : activityStack) {
                if (activity.getClass().equals(clazz)) {
                    activity.finish();
                    activityStack.remove(activity);
                }
            }
        }
    }

    /**
     * 结束除当前传入以外所有Activity
     */
    public void finishOthersActivity(Class<?> cls) {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                if (!activity.getClass().equals(cls)) {
                    activity.finish();
                }
            }
    }

    /**
     * 结束所有Activity
     */
    public void finishAllActivity() {
        if (activityStack != null)
            for (Activity activity : activityStack) {
                activity.finish();
            }
        activityStack.clear();
    }


    /**
     * 退出应用程序
     */
    public void AppExit() {
        try {
            finishAllActivity();
            android.os.Process.killProcess(android.os.Process.myPid());// 杀死该应用进程
            System.exit(0);
        } catch (Exception e) {
        }
    }
}
