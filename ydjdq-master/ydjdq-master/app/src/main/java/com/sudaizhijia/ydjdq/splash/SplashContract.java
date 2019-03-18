package com.sudaizhijia.ydjdq.splash;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.SplashBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/11
 */

public class SplashContract {
    interface View extends BaseView {
        void setData(SplashBean bean);

        void showJump();
    }

    interface  Presenter extends BasePresenter<View> {
        void postLogin();
        void startAndFinish();
        void getStartPage();
        void postUvData(SplashBean bean, int position, int type);

    }
}
