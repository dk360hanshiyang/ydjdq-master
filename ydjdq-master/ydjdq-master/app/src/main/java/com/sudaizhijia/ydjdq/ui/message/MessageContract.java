package com.sudaizhijia.ydjdq.ui.message;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MessageBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MessageContract {
    interface View extends BaseView {
        void setErrNet();

        void setContentView();

        void setLoadingView();

        void setData(MessageBean bean);

        void setfreshEnding(MessageBean bean);

        void stopRefresh();

        void stopLoadMore();
        void loadMoreData(MessageBean msg);
    }

    interface Presenter extends BasePresenter<View> {
        void getData(boolean isFresh, int startPage, int PageSize, int isLoading);
        void postUvData(MessageBean homeBean, int currentPosi, int type);
    }
}
