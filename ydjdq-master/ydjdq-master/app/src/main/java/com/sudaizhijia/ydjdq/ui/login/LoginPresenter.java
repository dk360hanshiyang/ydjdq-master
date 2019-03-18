package com.sudaizhijia.ydjdq.ui.login;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.meituan.android.walle.WalleChannelReader;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.LoginBean;
import com.sudaizhijia.ydjdq.bean.ServiceNuberBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.MutiChannelConfig;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.utils.L;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter {

    @Override
    public void getCode(String phone) {
        Log.e("mobile", phone);
        Log.e("channel", MutiChannelConfig.getChannel(CusApplication.mContext) + "");
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.SEND_CODE)
                .addParams("mobile", phone)
                .addParams("accessPort", "2")
                .addParams("deviceToken", "0")//TODO deviceToken
                .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
//                .addParams("channel", AppInfoUtil.getAppMetaData(getContext(), "UMENG_CHANNEL"))
//                .addParams("channel", AnalyticsConfig.getChannel(CusApplication.mContext)//UMENG
//                .addParams("channel",WalleChannelReader.getChannel(CusApplication.mContext)+""
//                )


                .build()
                .execute(new HttpCallback() {
                    @Override
                    public void onSuccess(BaseBean response, int id) {
                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        mView.showTime(false);
                    }

                    @Override
                    public void onResponse(Object response, int id) {
                    }
                });
    }

    @Override
    public void login(String userName, String passWord) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.LOGIN)
                .addParams("mobile", userName)
                .addParams("accessPort", "2")
                .addParams("code", passWord)//TODO deviceToken
                .addParams("loginOs", "Android")
                .build().execute(new HttpCallback<LoginBean>() {
            @Override
            public void onBefore(Request request, int id) {
                super.onBefore(request, id);
                mView.showLoading();
            }

            @Override
            public void onResponse(LoginBean response, int id) {
                if (response.code == 1) {
//                    MobclickAgent.onEvent(mView.getContext(),"login",WalleChannelReader.getChannel(mView.getContext()));
                    MobclickAgent.onEvent(mView.getContext(), "login", MutiChannelConfig.getChannel(CusApplication.mContext) + "");
                    CusApplication.isLogin = true;
                    CusApplication.object = response.getObject();
                    CusApplication.setAuth(true);
                    SharedPreUtils.putString(getContext(), CusConstants.USER_ID, response.getObject().getUserId() + "");
                    SharedPreUtils.putString(getContext(), CusConstants.TOKEN, response.getObject().getToken());
                    SharedPreUtils.putString(getContext(), CusConstants.USERNAME, response.getObject().getUsername());
                    mView.loginSuccess();
                    MobclickAgent.onProfileSignIn(response.getObject().getUserId() + "");
                } else {
                    Toast.makeText(mView.getContext(), response.message, Toast.LENGTH_SHORT).show();
                    mView.showErr();
                }

            }

            @Override
            public void onSuccess(LoginBean response, int id) {

            }

            @Override
            public void onFail(Call call, Exception e, int id) {
                Toast.makeText(mView.getContext(), "登录失败，稍后重试", Toast.LENGTH_SHORT).show();
                mView.showErr();
            }
        });
    }

    @Override
    public void getServiceNubler() {
        OkHttpUtils
                .get()
                .tag(getTag())
                .url(API.SERVICE_NUBLER)
                .build()
                .execute(new HttpCallback<ServiceNuberBean>() {

                    @Override
                    public void onSuccess(ServiceNuberBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        Log.e("ERROR", e.getMessage());
                    }

                    @Override
                    public void onResponse(ServiceNuberBean response, int id) {
                        if (response.code == 1) {
                            String value = response.getObject().getValue();
                            mView.getPhone(value);

                        }
                    }
                });
    }
}
