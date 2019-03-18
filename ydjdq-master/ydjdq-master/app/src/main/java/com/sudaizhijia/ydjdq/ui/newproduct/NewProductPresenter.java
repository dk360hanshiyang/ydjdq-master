package com.sudaizhijia.ydjdq.ui.newproduct;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class NewProductPresenter extends BasePresenterImpl<NewProductContract.View> implements NewProductContract.Presenter{

    @Override
    public void getDataInfo() {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.NEW_PRODUCT)
                .build()
                .execute(new HttpCallback<NewProductBean>() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        mView.showLoading();
                    }

                    @Override
                    public void onResponse(NewProductBean response, int id) {
                            mView.showView(response);
                    }

                    @Override
                    public void onSuccess(NewProductBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        mView.showErr();
                    }
                });
    }
}
