package com.sudaizhijia.ydjdq.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.ui.message.MessageActivity;

import org.greenrobot.eventbus.EventBus;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by aensun
 * JPush
 */

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "JPush";
    private int msgType;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Log.d(TAG, "[MyReceiver] onReceive - " + intent.getAction() + ", extras: " + printBundle(bundle));

        if (JPushInterface.ACTION_REGISTRATION_ID.equals(intent.getAction())) {
            String regId = bundle.getString(JPushInterface.EXTRA_REGISTRATION_ID);
            Log.d(TAG, "[MyReceiver] 接收Registration Id : " + regId);
            //send the Registration Id to your server...

        } else if (JPushInterface.ACTION_MESSAGE_RECEIVED.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 接收到推送下来的自定义消息: " + bundle.getString(JPushInterface.EXTRA_MESSAGE));
            processCustomMessage(context, bundle);
            EventBus.getDefault().post("Success");
        } else if (JPushInterface.ACTION_NOTIFICATION_RECEIVED.equals(intent.getAction())) {
            Log.d("TAG", "[MyReceiver] 接收到推送下来的通知");
            EventBus.getDefault().post("Success");

            int notifactionId = bundle.getInt(JPushInterface.EXTRA_NOTIFICATION_ID);
            Log.d(TAG, "[MyReceiver] 接收到推送下来的通知的ID: " + notifactionId);

        } else if (JPushInterface.ACTION_NOTIFICATION_OPENED.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 用户点击打开了通知");

//            {
//                "msgType": "1",
//                    "msgTitle": "测试标题",
//                    "msgContent": "测试内容",
//                    "senderId": "0",
//                    "receiverId": "130056",
//                    "msgId": "1111111111111111"
//            }


//          打开自定义的Activity
            Intent intentPushMsg = new Intent(context, MessageActivity.class);
            intentPushMsg.putExtras(bundle);
//            if (!TextUtils.isEmpty(msgType)) {
//                intentPushMsg.putExtra("type", msgType);
//            }
//            Log.d(TAG, "msgType" + this.msgType);
            //i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intentPushMsg.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            context.startActivity(intentPushMsg);

        } else if (JPushInterface.ACTION_RICHPUSH_CALLBACK.equals(intent.getAction())) {
            Log.d(TAG, "[MyReceiver] 用户收到到RICH PUSH CALLBACK: " + bundle.getString(JPushInterface.EXTRA_EXTRA));
            //在这里根据 JPushInterface.EXTRA_EXTRA 的内容处理代码，比如打开新的Activity， 打开一个网页等..

        } else if (JPushInterface.ACTION_CONNECTION_CHANGE.equals(intent.getAction())) {
            boolean connected = intent.getBooleanExtra(JPushInterface.EXTRA_CONNECTION_CHANGE, false);
            Log.w(TAG, "[MyReceiver]" + intent.getAction() + " connected state change to " + connected);
        } else {
            Log.d(TAG, "[MyReceiver] Unhandled intent - " + intent.getAction());
        }
    }

    // 打印所有的 intent extra 数据
    private static String printBundle(Bundle bundle) {

        return "";
    }

    //send msg to MainActivity
    private void processCustomMessage(Context context, Bundle bundle) {
//        String msg = bundle.getString(JPushInterface.EXTRA_EXTRA);
//        Gson gson = new Gson();
//        PushMsgBean pushMsgBean = gson.fromJson(msg, PushMsgBean.class);
//        if (pushMsgBean != null) {
//            msgType = pushMsgBean.getMsgType();
//            SharedPreferencesHelper.getInstance().saveData("msgType", msgType + "");
//            EventBus.getDefault().post(msgType);
//        }

    }
}