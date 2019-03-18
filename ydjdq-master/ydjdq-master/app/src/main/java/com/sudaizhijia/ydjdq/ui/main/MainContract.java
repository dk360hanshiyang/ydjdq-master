package com.sudaizhijia.ydjdq.ui.main;

import android.content.Context;

import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class MainContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
    }
}
