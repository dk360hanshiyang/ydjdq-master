package com.sudaizhijia.ydjdq.ui.market;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MarketBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class MarketContract {
    interface View extends BaseView {
        void refreshData(BaseBean bean);

        void setMarketListData(BaseBean baseBean);

        void stopRefresh();

        void loadMoreData(BaseBean baseBean);

        void stopLoadMore();
        void loadComplete();
    }

    interface Presenter extends BasePresenter<View> {
        void getMarketListInfo(boolean is, String start, String size, int loadMore,String sort,String maxMount,String minMount);
        void postUvData(MarketBean homeBean, int currentPosi, int type);
    }
}
