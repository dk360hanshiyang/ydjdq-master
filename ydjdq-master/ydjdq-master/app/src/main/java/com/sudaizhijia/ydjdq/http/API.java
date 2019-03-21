package com.sudaizhijia.ydjdq.http;

/**
 * Author: William Wang
 * Date:   On 2018/12/4
 */
public class API {

    /**
     * 本地
     */
//    public static String SERVER_URL = "http://192.168.2.179:8080/app/v1/";

    /**
     * 测试
     */
//    public static String SERVER_URL = "http://39.98.194.113:8080/app/v1/";
    /**
     * 线上
     */
    public static String SERVER_URL = "http://39.98.84.34:8080/app/v1/";
    /**
     * 首页注册协议地址
     */
    public static final String index = SERVER_URL + "anon/index/index";
    /**
     * 验证码接口
     */
    public static final String SEND_CODE = SERVER_URL + "anon/send_code";
    /**
     * 登录接口
     */
    public static final String LOGIN = SERVER_URL + "anon/smslogin";
    /**
     * 统计UV
     */
    public static final String UV = SERVER_URL + "auth/productVisit/visit";
    /**
     * 统计注册
     */
    public static final String STATISTICS_DOWNLOAD = SERVER_URL + "auth/productVisit/download";
    /**
     * 统计注册
     */
    public static final String STATISTICS_REGISTER = SERVER_URL + "auth/productVisit/register";
    /**
     * 上新
     */
    public static final String NEW_PRODUCT = SERVER_URL + "anon/productShow/getNextComeList";
    /**
     * 贷款大全
     */
    public static final String MAREKT_DATA = SERVER_URL + "anon/productShow/getDaQuanList";

    /**
     * 自动登录
     */
    public static final String RE_LOGIN = SERVER_URL + "auth/account/reLogin";
    /**
     * 开屏页推荐
     */
    public static final String START_PAGE = SERVER_URL + "anon/index/startPage";
    /**
     * 自动登录
     */
    public static final String MORE_PRODUCT = SERVER_URL + "anon/productShow/xinkouzi";

    /**
     * 消息列表
     */
    public static final String MESSAGE_LIST = SERVER_URL + "anon/message/list";
    /**
     * 消息未读
     */
    public static final String UNREAD_MESSAGE = SERVER_URL + "anon/message/getUnReadCount";
    /**
     * 我的
     * v1/auth/my/index
     */
    public static final String MINE_DAT = SERVER_URL + "anon/my/index";
    /**
     * 关于我们
     */
    public static final String ABOUT = SERVER_URL + "anon/about/yijianbixia";
    /**
     * 个人中心
     */
    public static final String PERSON = SERVER_URL + "auth/account/myInfo";
    /**
     * 登出
     */
    public static final String LOGIN_OUT = SERVER_URL + "auth/logout";

    /**
     * app获取更新
     */
    public static final String UPDATEAPP = SERVER_URL + "anon/about/updateAndroidApp";
    /**
     * 一键必下
     */
    public static final String MUST = SERVER_URL + "anon/productShow/bixiaList";

    /**
     * 注册协议
     */
    public static final String REGISTER_AGREEMENT = SERVER_URL + "anon/protocol/register";
    /**
     * 更换一批
     */
    public static final String CHANGE_ONE = SERVER_URL + "anon/index/otherBatch";
    /**
     * 客服電話
     */
    public static final String SERVICE_NUBLER = SERVER_URL + "anon/about/getCmpyInfo";


}
