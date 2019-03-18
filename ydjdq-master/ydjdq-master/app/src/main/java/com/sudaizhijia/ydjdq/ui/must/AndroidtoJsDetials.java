package com.sudaizhijia.ydjdq.ui.must;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;

import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MustProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.ui.newproduct.NewProductActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import okhttp3.Call;

/**
 * Author: William Wang
 * Date:   On 2018/12/20
 */
public class AndroidtoJsDetials extends Object {
    private Context mContext;
    private MustProductBean mustProductBean;
    private ProductDetailActivity productDetailActivity;

    public AndroidtoJsDetials(Context context, ProductDetailActivity productDetailActivity) {
        this.productDetailActivity = productDetailActivity;
        this.mContext = context;
    }

    public boolean isLogin() {
        if (!CusApplication.isLogin) {
            mContext.startActivity(new Intent(mContext, LoginActivity.class));
            return false;
        }
        return true;
    }



    @JavascriptInterface
    public void JsFinish() {
        if (isLogin()) {
            productDetailActivity.finish();

        }
    }

    @JavascriptInterface
    public void Jsshare() {
        if (isLogin()) {
            productDetailActivity.finish();

        }
    }

    @JavascriptInterface
    public void xinkouzi() {
        if (isLogin()) {
            mContext.startActivity(new Intent(mContext, NewProductActivity.class));
        }

    }

    public void calculate() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                postUvData(mustProductBean);
            }
        }.start();
    }

    public void openDetail(int type, BaseBean data) {
        Intent intent = new Intent(mContext, ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, 999);
        mContext.startActivity(intent);
    }

    public void postUvData(MustProductBean homeBean) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;

        productShowId = homeBean.getProductId();
//        position = homeBean.getPosition().getKey();
        position = homeBean.getPosition();
        sortIndex = homeBean.getSortIndex();
        id = homeBean.getBorrowProduct().getId();

        OkHttpUtils
                .post()
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", position)
                .addParams("sortIndex", sortIndex + "")
                .addParams("iemi", AppInfoUtil.getIMEI(mContext))
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
