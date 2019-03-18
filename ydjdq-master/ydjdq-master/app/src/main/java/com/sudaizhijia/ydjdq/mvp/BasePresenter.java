package com.sudaizhijia.ydjdq.mvp;

import android.content.Context;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public interface BasePresenter<V extends BaseView> {
    void attachView(V view);

    void detachView();

    void onStop();

    void onStart();

    String getTag();

    Context getContext();
}
