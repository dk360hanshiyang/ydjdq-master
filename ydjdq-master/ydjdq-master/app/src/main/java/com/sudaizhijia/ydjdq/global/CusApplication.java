package com.sudaizhijia.ydjdq.global;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.growingio.android.sdk.collection.Configuration;
import com.growingio.android.sdk.collection.GrowingIO;
import com.meituan.android.walle.WalleChannelReader;
import com.sudaizhijia.ydjdq.bean.LoginBean;
import com.sudaizhijia.ydjdq.http.interceptor.BasicParamsInterceptor;
import com.sudaizhijia.ydjdq.http.interceptor.EncryptInterceptor;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.ChannelUtil;
import com.sudaizhijia.ydjdq.utils.IpUtils;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.sudaizhijia.ydjdq.utils.MutiChannelConfig;
import com.sudaizhijia.ydjdq.utils.NetUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.PlatformConfig;
import com.wonderkiln.blurkit.BlurKit;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.cookie.CookieJarImpl;
import com.zhy.http.okhttp.cookie.store.PersistentCookieStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;
import okhttp3.OkHttpClient;


/**
 * Created by WilliamWang on 2018/12/3
 */
public class CusApplication extends Application {
//    public CusApplication() {
//        super(ShareConstants.TINKER_ENABLE_ALL, "com.sudaizhijia.ydjdq.SampleApplicationLike",
//                "com.tencent.tinker.loader.TinkerLoader", false);
//    }
    /**
     * 网络拦截器
     */
    public static BasicParamsInterceptor basicParamsInterceptor;
    public static Context mContext;
    public static LoginBean.ObjectBean object;
    public static boolean isLogin;
    public static String random;
    public static long lastOpenTime;
    public static boolean Home_isFirst = true;
    public static String color[] = {"#D0021B", "#417505", "#9013FE", "#002EFA", "#417505", "#9013FE", "#8b572a", "#002EFA", "#BD10E0", "#ff5a00", "#3FA536", "#B92281"};

    public static ArrayList<String> list = new ArrayList<>();
    public static boolean isUpdate;
    public static int isMock;
    public static String MockUrl;
    public static String shareUrl;

    @Override
    public void onCreate() {
        super.onCreate();
        //友盟多渠道打包
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "");
        LogUtils.init(CusConstants.isDebug);
        mContext = this.getApplicationContext();
        initUmeng();
        getUserInfo();

        initHttpPara();
        setAuth(true);
        initWebView();
        initBugly();
        initGrawing();
        initJpush();

    }

    private void initGrawing() {
        GrowingIO.startWithConfiguration(this, new Configuration()
                .trackAllFragments()
                .setChannel(AnalyticsConfig.getChannel(CusApplication.mContext))
        );

    }

    private void initBugly() {
        // 这里实现SDK初始化，appId替换成你的在Bugly平台申请的appId
        // 调试时，将第三个参数改为true
        Bugly.init(this, "2362552b5f", false);
//        Bugly.setIsDevelopmentDevice(this, true);//设置为开发者设备。
    }

    /**
     * 初始化Jpush
     */

    public static void initJpush() {
        JPushInterface.setDebugMode(false);//正式版的时候设置false，关闭调试
        JPushInterface.init(mContext);
        JPushInterface.resumePush(mContext);
        //建议添加tag标签，发送消息的之后就可以指定tag标签来发送了
        Set<String> set = new HashSet<>();
        set.add("10002");//名字任意，可多添加几个
//            JPushInterface.setTags(this, set, null);//设置标签


        //设置标签和别名
        JPushInterface.setAliasAndTags(mContext, "test", set, new TagAliasCallback() {

            @Override
            public void gotResult(int arg0, String arg1, Set<String> arg2) {
                Log.i("JPush", "Jpush status: " + arg0 + "   message--->" + arg1);//状态  为 0 时标示成功
            }

        });
    }

    /**
     * 注销Jpush
     *
     * @param context
     */
    public static void finishJpush(Context context) {
        JPushInterface.stopPush(context);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);


        // 安装tinker
        Beta.installTinker();
    }

    private void initUmeng() {
        /**
         * 初始化common库
         * 参数1:上下文，不能为空
         * 参数2:【友盟+】 AppKey
         * 参数3:【友盟+】 Channel
         * 参数4:设备类型，UMConfigure.DEVICE_TYPE_PHONE为手机、UMConfigure.DEVICE_TYPE_BOX为盒子，默认为手机
         * 参数5:Push推送业务的secret
         * 拿到渠道号
         */
        UMConfigure.init(this, CusConstants.UmAppKey, MutiChannelConfig.getChannel(CusApplication.mContext) + "", UMConfigure.DEVICE_TYPE_PHONE, CusConstants.UmSecret);
//        UMConfigure.init(this, CusConstants.UmAppKey, AnalyticsConfig.getChannel(CusApplication.mContext), UMConfigure.DEVICE_TYPE_PHONE, CusConstants.UmSecret);

        // UMConfigure.init(this, CusConstants.UmAppKey, WalleChannelReader.getChannel(getApplicationContext()), UMConfigure.DEVICE_TYPE_PHONE, CusConstants.UmSecret);
        UMConfigure.setLogEnabled(CusConstants.isDebug);
        UMConfigure.setEncryptEnabled(true);
        MobclickAgent.setScenarioType(mContext, MobclickAgent.EScenarioType.E_UM_NORMAL);
        MobclickAgent.openActivityDurationTrack(false);
        //获取消息推送代理示例
        PushAgent mPushAgent = PushAgent.getInstance(this);
//注册推送服务，每次调用register方法都会回调该接口
        mPushAgent.register(new IUmengRegisterCallback() {
            @Override
            public void onSuccess(String deviceToken) {
                //注册成功会返回deviceToken deviceToken是推送消息的唯一标志
                Log.d("U-Push", "注册成功：deviceToken：-------->  " + deviceToken);
            }

            @Override
            public void onFailure(String s, String s1) {
                Log.d("U-Push", "注册失败：-------->  " + "s:" + s + ",s1:" + s1);
            }
        });
        PlatformConfig.setWeixin("wxb42682efbdfb618a", "5f79a605de881d0c459b41f0e6ce0ab5");
        UmengMessageHandler messageHandler = new UmengMessageHandler() {

            @Override
            public Notification getNotification(Context context, UMessage msg) {
                switch (msg.builder_id) {
//                    case 1:
//                        Notification.Builder builder = new Notification.Builder(context);
//                        RemoteViews myNotificationView = new RemoteViews(context.getPackageName(),
//                                R.layout.notification_view);
//                        myNotificationView.setTextViewText(R.id.notification_title, msg.title);
//                        myNotificationView.setTextViewText(R.id.notification_text, msg.text);
//                        myNotificationView.setImageViewBitmap(R.id.notification_large_icon,
//                                getLargeIcon(context, msg));
//                        myNotificationView.setImageViewResource(R.id.notification_small_icon,
//                                getSmallIconId(context, msg));
//                        builder.setContent(myNotificationView)
//                                .setSmallIcon(getSmallIconId(context, msg))
//                                .setTicker(msg.ticker)
//                                .setAutoCancel(true);
//
//                        return builder.getNotification();
                    default:
                        //默认为0，若填写的builder_id并不存在，也使用默认。
                        return super.getNotification(context, msg);
                }
            }
        };

        mPushAgent.setMessageHandler(messageHandler);
//UmengNotificationClickHandler是在BroadcastReceiver中被调用，因此若需启动Activity，
// 需为Intent添加Flag：Intent.FLAG_ACTIVITY_NEW_TASK，否则无法启动Activity。
        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {
                Toast.makeText(context, "后续操作", Toast.LENGTH_LONG).show();
            }
        };
        mPushAgent.setNotificationClickHandler(notificationClickHandler);
        mPushAgent.setPushCheck(true);
    }

    public static void setAuth(boolean isLogin) {
          /*   String userID = SharedPreUtils.getString(mContext, CusConstants.USER_ID, "");
        String token = SharedPreUtils.getString(mContext, CusConstants.TOKEN, "");
        int userId = object.getUserId();
        String token1 = object.getToken();
        if (!TextUtils.isEmpty(userId + "") && !TextUtils.isEmpty(token1)) {
            map.put("userId", userId + "");
            map.put("token", AppInfoUtil.UrlEncoder(token1));
            Log.e("text88888", "setAuth: object ===" + object.getUserId() + "======" + object.getToken()+"===sharedprefrence===" + userID+"==="+token);
        }*/
        HashMap<String, String> map = new HashMap<>();
        map.put("accessPort", "2");
        map.put("version", AppInfoUtil.getVersionName(mContext));
        map.put("channel", MutiChannelConfig.getChannel(CusApplication.mContext) + "");//meituan
        Log.e("meituanChannel", MutiChannelConfig.getChannel(CusApplication.mContext) + " ");
        //友盟渠道信息
//        map.put("channel", AnalyticsConfig.getChannel(CusApplication.mContext));

        if (isLogin) {
            if (!TextUtils.isEmpty(object.getUserId() + "") && !TextUtils.isEmpty(object.getToken())) {
                map.put("userId", object.getUserId() + "");
                map.put("token", AppInfoUtil.UrlEncoder(object.getToken()));
                map.put("networkState", NetUtils.getNetworkState(mContext));
                map.put("ip", IpUtils.getNetIp());
                Log.e("ip", IpUtils.getNetIp());

            }
        }
        basicParamsInterceptor.setParamsMap(map);
        basicParamsInterceptor.setQueryParamsMap(map);
    }

    private void initWebView() {
        QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

            @Override
            public void onViewInitFinished(boolean arg0) {
                // TODO Auto-generated method stub
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                Log.d("app", " onViewInitFinished is " + arg0);
            }

            @Override
            public void onCoreInitFinished() {
                // TODO Auto-generated method stub
            }
        };
        //x5内核初始化接口
        QbSdk.initX5Environment(getApplicationContext(), cb);
    }


    /**
     * 获取本地用户信息
     * userId和Token
     */
    private void getUserInfo() {
        object = new LoginBean.ObjectBean();
        String userId = SharedPreUtils.getString(mContext, CusConstants.USER_ID, "");
        String token = SharedPreUtils.getString(mContext, CusConstants.TOKEN, "");
        if (!TextUtils.isEmpty(String.valueOf(userId)) && !TextUtils.isEmpty(token + "")) {
            object.setUserId(Integer.parseInt(userId));
            object.setToken(token);
        }

    }


    /**
     * 初始化网络组件
     */
    public void initHttpPara() {
        HashMap<String, String> map = new HashMap<>();
        map.put("accessPort", "2");
        map.put("version", AppInfoUtil.getVersionName(mContext));
        map.put("networkState", NetUtils.getNetworkState(mContext));
        map.put("ip", IpUtils.getIPAddress(mContext));
//        map.put("channel", WalleChannelReader.getChannel(CusApplication.mContext) + "");
        map.put("channel", AnalyticsConfig.getChannel(CusApplication.mContext) + "");
        basicParamsInterceptor = new BasicParamsInterceptor.Builder()
                .addQueryParamsMap(map)
                .addParamsMap(map)
                .build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(basicParamsInterceptor)
//                .addInterceptor(new MyLoggerInterceptor("williamWong", true))
                .addInterceptor(new EncryptInterceptor())
                .cookieJar(new CookieJarImpl(new PersistentCookieStore(getApplicationContext())))
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .build();
        OkHttpUtils.initClient(okHttpClient);
    }


}
