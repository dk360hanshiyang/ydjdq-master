package com.sudaizhijia.ydjdq.ui.person;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MsgBean;
import com.sudaizhijia.ydjdq.bean.PersonBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.umeng.analytics.MobclickAgent;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonPresenter extends BasePresenterImpl<PersonContract.View> implements PersonContract.Presenter {

    @Override
    public void getData() {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.PERSON)
                .build()
                .execute(new HttpCallback<PersonBean>() {
                    @Override
                    public void onResponse(PersonBean response, int id) {
                        mView.setData(response);
                    }

                    @Override
                    public void onSuccess(PersonBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });
    }

    @Override
    public void loginOut() {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.LOGIN_OUT)
                .build()
                .execute(new HttpCallback<BaseBean>() {
                    @Override
                    public void onSuccess(BaseBean response, int id) {
                        makeNoLogin();
                        MobclickAgent.onEvent(getContext(), "loginout");
                        //登出
                        MobclickAgent.onProfileSignOff();
                        mView.finishSelf();
                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        Toast.makeText(mView.getContext(), "退出失败，请检查网络", Toast.LENGTH_SHORT).show();
                    }
                });
    }
    public void makeNoLogin() {
        CusApplication.isLogin = false;
        CusApplication.object.setUserId(-99);
        CusApplication.object.setToken("");


    }
}
