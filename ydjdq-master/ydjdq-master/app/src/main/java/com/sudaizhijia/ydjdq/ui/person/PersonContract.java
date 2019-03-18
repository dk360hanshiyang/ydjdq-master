package com.sudaizhijia.ydjdq.ui.person;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.PersonBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class PersonContract {
    interface View extends BaseView {
        void setData(PersonBean bean);
    }

    interface  Presenter extends BasePresenter<View> {
        void getData();
        void loginOut();
    }
}
