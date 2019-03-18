package com.sudaizhijia.ydjdq.mvp;

import android.content.Context;

import com.zhy.http.okhttp.OkHttpUtils;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BasePresenterImpl<V extends BaseView> implements BasePresenter<V> {
    protected V mView;

    @Override
    public void attachView(V view) {
        mView = view;
    }

    @Override
    public void detachView() {
        OkHttpUtils.getInstance().cancelTag(getTag());
        mView = null;
    }

    @Override
    public void onStop() {

    }

    @Override
    public void onStart() {

    }

    @Override
    public String getTag() {
        return this.getClass().getSimpleName();
    }

    @Override
    public Context getContext() {
        return mView.getContext();
    }


}
