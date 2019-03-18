package com.sudaizhijia.ydjdq.ui.business;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.AboutBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BusinessContract {
    interface View extends BaseView {
        void showData(AboutBean bean);
    }

    interface  Presenter extends BasePresenter<View> {
        void getData();
    }
}
