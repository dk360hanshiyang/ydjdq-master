package com.sudaizhijia.ydjdq.ui.newpdu.recently;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class RecentlyContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        void postUvData(NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX bean, int position, int type);
    }
}
