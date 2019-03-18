package com.sudaizhijia.ydjdq.ui.home;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.ChangeBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class HomeContract {
    interface View extends BaseView {
        void setData(HomeBean homeBean);
        void setChangeOne(ChangeBean bean);
        void reFresh(HomeBean homeBean);
        void setAllData(HomeBean homeBean,boolean isFresh);
        void initRefreshLayout();
        void initRecycler();
        void stopRefresh();
        void error500();
        void addNetErrPage();
        void addLoadingPage();
        void addContentPage();

    }

    interface Presenter extends BasePresenter<View> {

        void getIndexInfo(boolean isRefresh);
        void getChangeInfo(int times);
        void postUvData(HomeBean homeBean,int currentPosi,int type);

    }
}
