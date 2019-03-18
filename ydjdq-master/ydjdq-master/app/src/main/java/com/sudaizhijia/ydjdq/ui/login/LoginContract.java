package com.sudaizhijia.ydjdq.ui.login;

import android.content.Context;

import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void showTime(boolean isShow);

        void loginSuccess();

        void showErr();

        void showLoading();

        void getPhone(String servicePhone);
    }

    interface Presenter extends BasePresenter<View> {
        void getCode(String phone);

        void login(String userName, String passWord);

        void getServiceNubler();

    }
}
