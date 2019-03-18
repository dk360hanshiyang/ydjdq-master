package com.sudaizhijia.ydjdq.global;

import android.os.Environment;

/**
 * Created by WilliamWang on 2018/12/3
 */
public class CusConstants {

    public static final String CHANNEL = "channel";
    public static final String VERSIONNAME = "version_name";
    public static final int TYPE_AFTER = 3;
    public static final int TYPE_AFTEREXPAND = 4;
    public static final int  HOMEINFO = 801;
    public static final int  MINE_SHOW = 701;
    public static final int  BANNER = 802;
    public static final int  REPORTMENT = 803;
    public static final int  MARKET_DATA = 820;
    public static final int MIDDLE = 804;
    public static final int TOP = 805;
    public static final int RECENTLY = 809;
    public static final int  DUWNLOAD = 810;
    public static final int  POPUP = 811;
    public static final int  ZHUANTI = 900;
    public static final int  MINE_ZHUANTI= 100;
    public static final int NOW_NEWPRODUCT = 819;
    public static final String START_PAGE = "start_page";
    public static final int SPLASH_TYPE = 990;
    public static final int MESSAGE_MSG = 392;
    public static final int MOREPRODUCT = 987;
    public static final String USERNAME = "username";
    public static final String HOMEDATA = "home_data";
    public static final String MARKET_DATA_INFO = "market_data_info";
    public static final String MSG_TIME = "msg_time";
    public static final int MINE_BANNER = 702;
    public static final int MUST = 1001;
    public static final int HOME_DIALOG = 1002;
    public static final String HUODONG_TYPE = "HUODONG";
    public static final String ZHAUNTI_TYPE = "ZHUANTI";

    public static boolean isDebug = false;

    public static final String sharedPreName = "config_data";

    public static final String USER_ID = "user_id";

    public static final String TOKEN = "token";
    public static final int TYPE_NEWNOW_1 = 0;
    public static final int TYPE_NEWPRODUCT = 1;

    public static final int TYPE_HEADER = 4;
    public static final int TYPE_BODY = 5;
    public static String PRODUCT_INFO = "product_info";
    public static String PRODUCT_POSITION= "product_position";
    public static String START_TYPE= "start_type";
    public static String SPLASH = "splash";
    public static String filePath= Environment.getExternalStorageDirectory().getAbsolutePath()+"/k360/res/";
    public static String sessionId,path,domain;
    public static String UmSecret = "1d8b6711db2b6b421ff6323646e9953a";
    public static String UmAppKey = "5c219b5cb465f55a99000128";
    public static String APPID="wxb42682efbdfb618a";
}
