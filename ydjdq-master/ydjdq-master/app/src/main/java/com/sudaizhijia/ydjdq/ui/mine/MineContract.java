package com.sudaizhijia.ydjdq.ui.mine;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MineBean;
import com.sudaizhijia.ydjdq.bean.MsgBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

/**
 * Created by WilliamWang on 2018/12/8
 */

public class MineContract {
    interface View extends BaseView {
        void setMsgCout(MsgBean bean);
        void setData(MineBean bean);

    }

    interface Presenter extends BasePresenter<View> {
        void getUnReadMsg(String lastOpenTime);
        void getMineData();
        void postUvData(BaseBean bean,int position,int type);
    }
}
