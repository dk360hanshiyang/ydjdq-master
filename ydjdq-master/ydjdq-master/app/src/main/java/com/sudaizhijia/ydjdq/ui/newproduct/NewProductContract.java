package com.sudaizhijia.ydjdq.ui.newproduct;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;
import com.sunfusheng.marqueeview.MarqueeView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class NewProductContract {
    interface View extends BaseView {
        void showView(NewProductBean bean);
        void showLoading();
        void showErr();
    }

    interface  Presenter extends BasePresenter<View> {
        void getDataInfo();
    }
}
