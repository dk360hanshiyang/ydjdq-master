package com.sudaizhijia.ydjdq.ui.message;

import android.content.Context;
import android.util.Log;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.bean.MessageBean;
import com.sudaizhijia.ydjdq.bean.MoreProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MessagePresenter extends BasePresenterImpl<MessageContract.View> implements MessageContract.Presenter {

    @Override
    public void getData(boolean isFresh, int current, int pageSize, int isLoadingMore) {
        OkHttpUtils
                .post()
                .tag(getTag())
                .addParams("pageNow", current + "")
                .addParams("pageSize", pageSize + "")
                .url(API.MESSAGE_LIST)
                .build()
                .execute(
                        new HttpCallback<MessageBean>() {
                            @Override
                            public void onBefore(Request request, int id) {
                                super.onBefore(request, id);
                                mView.setLoadingView();
                            }

                            @Override
                            public void onResponse(MessageBean response, int id) {
                                Log.e("text101", "onResponse: "+response.getObject().getMessageList().size() );
                                SharedPreUtils.putString(mView.getContext(),CusConstants.MSG_TIME,response.getObject().getLastOpenTime()+"");
                                mView.setContentView();
                                if (isFresh) {
                                    mView.setfreshEnding(response);


                                } else if (isLoadingMore == 10) {
                                    mView.loadMoreData(response);
                                } else {
                                    mView.setData(response);

                                }
                            }

                            @Override
                            public void onSuccess(MessageBean response, int id) {

                            }

                            @Override
                            public void onFail(Call call, Exception e, int id) {
                                if (isFresh) {
                                    mView.stopRefresh();
                                } else if (isLoadingMore == 10) {
                                    mView.stopLoadMore();
                                } else {
                                    mView.setErrNet();

                                }
                            }
                        });
    }

    @Override
    public void postUvData(MessageBean homeBean, int currentPosi, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;


        if (type == CusConstants.MESSAGE_MSG) {
            productShowId = homeBean.getObject().getMessageList().get(currentPosi).getId();
            position = homeBean.getObject().getMessageList().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getMessageList().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getMessageList().get(currentPosi).getBorrowProduct().getId();
            OkHttpUtils
                    .post()
                    .tag(getTag())
                    .url(API.UV)
                    .addParams("productShowId", productShowId + "")
                    .addParams("position", position)
                    .addParams("sortIndex", sortIndex + "")
                    .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
                    .addParams("productId", id + "")
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
}
