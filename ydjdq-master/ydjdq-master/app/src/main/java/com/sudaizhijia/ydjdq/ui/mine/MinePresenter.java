package com.sudaizhijia.ydjdq.ui.mine;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MineBean;
import com.sudaizhijia.ydjdq.bean.MsgBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by WilliamWang on 2018/12/8
 */

public class MinePresenter extends BasePresenterImpl<MineContract.View> implements MineContract.Presenter {

    @Override
    public void getUnReadMsg(String lastOpenTime) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .addParams("lastOpenTimeStr", lastOpenTime + "")
                .url(API.UNREAD_MESSAGE)
                .build()
                .execute(new HttpCallback<MsgBean>() {
                    @Override
                    public void onResponse(MsgBean response, int id) {
                        if (mView == null) {
                            return;
                        }
                        mView.setMsgCout(response);
                    }

                    @Override
                    public void onSuccess(MsgBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {

                    }
                });
    }

    @Override
    public void getMineData() {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.MINE_DAT)
                .build().execute(new HttpCallback<MineBean>() {
            @Override
            public void onResponse(MineBean response, int id) {
                if (mView == null) {
                    return;
                }
                mView.setData(response);
            }

            @Override
            public void onSuccess(MineBean response, int id) {

            }

            @Override
            public void onFail(Call call, Exception e, int id) {
                Toast.makeText(mView.getContext(), "网络走丢了，稍后重试", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void postUvData(BaseBean bean, int position1, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int positionId = 0;
        int id = 0;
        MineBean mineBean = (MineBean) bean;
        try {


            if (type == CusConstants.MINE_SHOW) {
                productShowId = mineBean.getObject().getMyVo().getMyShowList().get(position1).getId();
                position = mineBean.getObject().getMyVo().getMyShowList().get(position1).getPosition().getKey();
                sortIndex = mineBean.getObject().getMyVo().getMyShowList().get(position1).getSortIndex();
                id = mineBean.getObject().getMyVo().getMyShowList().get(position1).getBorrowProduct().getId();
                positionId = mineBean.getObject().getMyVo().getMyShowList().get(position1).getPositionId();
            } else if (type == CusConstants.MINE_BANNER) {
//            productShowId = mineBean.getObject().getMyVo().getAppBannerList().getProductId();
//            position = mineBean.getObject().getMyVo().getAppBannerList().get(position1).getPosition().getKey();
//            sortIndex = mineBean.getObject().getMyVo().getAppBannerList().get(position1).getSortIndex();
//            id = mineBean.getObject().getMyVo().getAppBannerList().get(position1).getBorrowProduct().getId();
            } else if (type == CusConstants.MINE_ZHUANTI) {
                productShowId = mineBean.getObject().getMyVo().getMyShowList().get(position1).getId();
                position = mineBean.getObject().getMyVo().getMyShowList().get(position1).getPosition().getKey();
                sortIndex = mineBean.getObject().getMyVo().getMyShowList().get(position1).getSortIndex();
                id = mineBean.getObject().getMyVo().getMyShowList().get(position1).getBorrowProduct().getId();
                positionId = mineBean.getObject().getMyVo().getMyShowList().get(position1).getPositionId();
            }
        } catch (Exception e) {

        }
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", position)
                .addParams("sortIndex", sortIndex + "")
                .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
                .addParams("productId", id + "")
                .addParams("positionId", positionId + "")
                .addParams("actionSerialNumber", CusApplication.random)
                .addParams("userId", CusApplication.object.getUserId() + "")
                .addParams("accessPort", "2")
                .build()
                .execute(new HttpCallback() {
                    @Override
                    public void onSuccess(BaseBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                    }

                    @Override
                    public void onResponse(Object response, int id) {

                    }
                });
    }
}
