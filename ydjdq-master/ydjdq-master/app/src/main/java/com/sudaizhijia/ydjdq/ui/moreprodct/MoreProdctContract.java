package com.sudaizhijia.ydjdq.ui.moreprodct;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.MoreProductBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoreProdctContract {
    interface View extends BaseView {
        void setData(MoreProductBean bean);

        void showLoading();

        void showErrPage();
        void setfreshEnding(MoreProductBean bean);
        void addContentView();
    }

    interface Presenter extends BasePresenter<View> {
        void getData(boolean isFresh);
       void postUvData(MoreProductBean bean,int position,int type);
    }
}
