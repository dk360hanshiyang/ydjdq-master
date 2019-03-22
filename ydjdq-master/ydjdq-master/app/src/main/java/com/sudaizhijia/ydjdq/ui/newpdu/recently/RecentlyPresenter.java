package com.sudaizhijia.ydjdq.ui.newpdu.recently;

import android.content.Context;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class RecentlyPresenter extends BasePresenterImpl<RecentlyContract.View> implements RecentlyContract.Presenter {

    @Override
    public void postUvData(NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX bean1, int position, int type) {

        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String mposition = "";
        int sortIndex = 0;
        int id = 0;
        int positionId = 0;
        productShowId = bean1.getId();
        mposition = bean1.getPosition().getKey();
        sortIndex = bean1.getSortIndex();
        id = bean1.getBorrowProduct().getId();
        positionId = bean1.getPositionId();
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", mposition)
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
