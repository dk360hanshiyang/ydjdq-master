package com.sudaizhijia.ydjdq.ui.market;

import android.widget.Toast;

import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MarketBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.BasePresenterImpl;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.zhy.http.okhttp.OkHttpUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import okhttp3.Call;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class MarketPresenter extends BasePresenterImpl<MarketContract.View> implements MarketContract.Presenter {

    @Override
    public void getMarketListInfo(boolean isRefrsh, String start, String size, int isLoadMore, String sort, String maxMount, String minMount) {
        OkHttpUtils.post().tag(getTag()).url(API.MAREKT_DATA)
                .addParams("pageStart", start)
                .addParams("pageSize", size)
                .addParams("orderKey", sort)
                .addParams("minAmount", minMount)
                .addParams("maxAmount", maxMount)
                .build()
                .execute(new HttpCallback<MarketBean>() {

                    @Override
                    public void onResponse(MarketBean response, int id) {
//                        if(response == null){
//                            Toast.makeText(mView.getContext(), "网络错误，稍后重试！", Toast.LENGTH_SHORT).show();
//                            return;
//                        }
                        String cache = getCache();
                        SharedPreUtils.putString(CusApplication.mContext, CusConstants.MARKET_DATA_INFO, cache);
                        if (mView == null) {
                            return;
                        }
                        if (response.getObject().isHasNext()) {
                            if (isRefrsh) {
                                mView.refreshData(response);
                            } else if (isLoadMore == 10) {
                                mView.loadMoreData(response);
                            } else {
                                mView.setMarketListData(response);

                            }
                        } else {
                            if (isLoadMore == 10) {
                                mView.loadMoreData(response);
                                mView.loadComplete();
                            }else {
                                mView.setMarketListData(response);

                            }

                        }


                    }

                    @Override
                    public void onSuccess(MarketBean response, int id) {

                    }

                    @Override
                    public void onFail(Call call, Exception e, int id) {
                        Toast.makeText(mView.getContext(), "网络出小差了，重试一下吧", Toast.LENGTH_SHORT).show();
                        if (isRefrsh) {
                            //TODO 刷新时网络错误
                            mView.stopRefresh();
                        } else if (isLoadMore == 10) {
                            //TODO 加载时网络错误
                            mView.stopLoadMore();
                        }
                        if (e instanceof SocketTimeoutException) {//超时异常
                            mView.stopRefresh();
                        }
                        if (e instanceof ConnectException) {//连接异常
                            mView.stopRefresh();
                        }
                    }
                });
    }

    @Override
    public void postUvData(MarketBean homeBean, int currentPosi, int type) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;

        if (type == CusConstants.MARKET_DATA) {
            productShowId = homeBean.getObject().getDaQuanShowList().get(currentPosi).getId();
            position = homeBean.getObject().getDaQuanShowList().get(currentPosi).getPosition().getKey();
            sortIndex = homeBean.getObject().getDaQuanShowList().get(currentPosi).getSortIndex();
            id = homeBean.getObject().getDaQuanShowList().get(currentPosi).getBorrowProduct().getId();
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
