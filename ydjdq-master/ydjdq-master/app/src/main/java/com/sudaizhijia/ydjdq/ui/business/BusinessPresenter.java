package com.sudaizhijia.ydjdq.ui.business;

import android.content.Context;
import android.util.Log;

import com.sudaizhijia.ydjdq.bean.AboutBean;
import com.sudaizhijia.ydjdq.bean.MsgBean;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BusinessPresenter extends BasePresenterImpl<BusinessContract.View> implements BusinessContract.Presenter {

    @Override
    public void getData() {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.ABOUT)
                .build()
                .execute(new HttpCallback<AboutBean>() {
                    @Override
                    public void onResponse(AboutBean response, int id) {
                        mView.showData(response);
                    }

                    @Override
                    public void onSuccess(AboutBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });
    }
}
