package com.sudaizhijia.ydjdq.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;

import java.io.Serializable;
import java.util.List;

/**
 * Activity工具类
 */
public class ActivityUtils {
	public static boolean checkLogin(Context context) {
		if (!CusApplication.isLogin) {
			ActivityUtils.startActivity(context, LoginActivity.class);
		}
		return CusApplication.isLogin;
	}

	/**
	 * 启动一个Activity并关闭当前Activity
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity
	 */
	public static void startActivityAndFinish(Activity activity, Class<?> cls) {
		Intent intent = new Intent(activity, cls);
		activity.startActivity(intent);
		activity.finish();
	}

	/**
	 * 启动Activity
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity Class
	 */
	public static void startActivity(Context activity, Class<?> cls) {
		Intent intent = new Intent(activity, cls);
		activity.startActivity(intent);
	}

	public static void startActivityFroTask(Context activity, Class<?> cls) {
		Intent intent = new Intent(activity, cls);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		activity.startActivity(intent);
	}

	/**
	 * 启动Activity并传int数据 key:"data"
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity Class
	 * @param data
	 *            int型数据
	 */
	public static void startActivityForIntData(Context activity, Class<?> cls, int data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		activity.startActivity(intent);
	}

	/**
	 * 启动Activity并传String数据 key:"data"
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity Class
	 * @param data
	 *            String型数据
	 */
	public static void startActivityForData(Context activity, Class<?> cls, String data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		activity.startActivity(intent);
	}
	public static void startActivityForData(Context activity, Class<?> cls, double data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		activity.startActivity(intent);
	}

	public static void startActivityForData(Context activity, Class<?> cls, int data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		activity.startActivity(intent);
	}
	public static void startActivityForData(Context activity, Class<?> cls, long data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		activity.startActivity(intent);
	}
	/**
	 * 启动Activity传String数据并接收返回结果 key:"data"
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity Class
	 * @param data
	 *            String型数据
	 * @param flag
	 *            int标记
	 */
	public static void startActivityForResult(Activity activity, Class<?> cls, String data,
											  int flag) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.data, data);
		intent.setFlags(flag);
		activity.startActivityForResult(intent, flag);
	}

	/**
	 * 启动Activity并传序列化对象数据 key:"Serializable"
	 * 
	 * @param activity
	 *            当前Activity
	 * @param cls
	 *            要启动的Activity Class
	 * @param data
	 *            String型数据
	 */
	public static void startActivityForSerializable(Context activity, Class<?> cls,
													Serializable data) {
		Intent intent = new Intent(activity, cls);
//		intent.putExtra(KeyNamePro.Serializable, data);
		activity.startActivity(intent);
	}

	/**
	 * 启动Activity并传String对象数据
	 * 
	 * @param activity
	 *            当前Activity
	 * @param name
	 *            key
	 * @param cls
	 *            要启动的Activity Class
	 * @param data
	 *            String数据
	 */
	public static void startActivityForStringData(Context activity, String name, Class<?> cls,
												  String data) {
		Intent intent = new Intent(activity, cls);
		intent.putExtra(name, data);
		activity.startActivity(intent);
	}

	/**
	 * 启动网络设置
	 * 
	 * @param activity
	 *            当前Activity
	 */
	public static void startSetNetActivity(Context activity) {
		Intent intent = new Intent(Settings.ACTION_AIRPLANE_MODE_SETTINGS);
		activity.startActivity(intent);
	}

	/**
	 * 启动系统设置
	 * 
	 * @param activity
	 *            当前Activity
	 */
	public static void startSetActivity(Context activity) {
		Intent intent = new Intent(Settings.ACTION_SETTINGS);
		activity.startActivity(intent);
	}

	/**
	 * 获取当前栈顶的类名
	 * @param context
	 * @return
     */
	public static String getCurrentClassName(Context context){
		ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
		List<ActivityManager.RunningTaskInfo> runningTaskInfos=am.getRunningTasks(1);
		String packageName = runningTaskInfos.get(0).topActivity.getClassName();
		return packageName;
	}

	/**
	 * 跳转到应用市场
	 * @param context
     */
	public static void  goToMarket(Context context) {
//		Uri uri = Uri.parse("market://details?id=" + AppInfoUtil.getPkName(context));
//		Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
			try {
//			context.startActivity(goToMarket);
		} catch (ActivityNotFoundException e) {
			e.printStackTrace();
		}
	}
}
