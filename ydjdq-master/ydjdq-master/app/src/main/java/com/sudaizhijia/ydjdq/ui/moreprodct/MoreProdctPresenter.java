package com.sudaizhijia.ydjdq.ui.moreprodct;

import android.content.Context;
import android.util.Log;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MoreProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoreProdctPresenter extends BasePresenterImpl<MoreProdctContract.View> implements MoreProdctContract.Presenter {

    @Override
    public void getData(boolean isFresh) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.MORE_PRODUCT)
                .build()
                .execute(new HttpCallback<MoreProductBean>() {
                    @Override
                    public void onBefore(Request request, int id) {
                        super.onBefore(request, id);
                        mView.showLoading();
                    }

                    @Override
                    public void onResponse(MoreProductBean response, int id) {
                        mView.addContentView();
                        if (isFresh) {
                            mView.setData(response);

                        } else {
                            mView.setfreshEnding(response);
                        }
                    }

                    @Override
                    public void onSuccess(MoreProductBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        mView.showErrPage();
                    }
                });
    }

    @Override
    public void postUvData(MoreProductBean bean, int position1, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;

        if (type == CusConstants.MOREPRODUCT) {
            productShowId = bean.getObject().get(position1).getId();
            position = bean.getObject().get(position1).getPosition().getKey();
            sortIndex = bean.getObject().get(position1).getSortIndex();
            id = bean.getObject().get(position1).getBorrowProduct().getId();
        }
        OkHttpUtils
                .post()
                .tag(getTag())
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", position)
                .addParams("sortIndex", sortIndex + "")
                .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
                .addParams("productId", id+"")
                .addParams("actionSerialNumber", CusApplication.random)
                .addParams("userId", CusApplication.object.getUserId()+"")
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
