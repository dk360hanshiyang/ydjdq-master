package com.sudaizhijia.ydjdq.http;


import android.content.Intent;
import android.util.Log;

import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.mvp.BaseView;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Request;
import okhttp3.Response;

/**
 * http请求回调类，在这里拦截一下所有的请求回调，便于对所有的请求结果进行统一处理
 * Created by WilliamWang on 2018/12/3
 */

public abstract class HttpCallback<T extends BaseBean> extends Callback<T> {
    private Class<T> entityClass = null;
    private BaseView baseView;
    private boolean isCheckLogin = true;
    public String cache;
    public HttpCallback() {
    }

    public HttpCallback(BaseView mView) {
        this.baseView = mView;
    }

    public HttpCallback(boolean isCheckLogin) {
        this.isCheckLogin = isCheckLogin;
    }

    @Override
    public void onBefore(Request request, int id) {
        super.onBefore(request, id);
        if (baseView != null) {
//            baseView.showLoadingDialog();
        }
    }

    public String getCache() {
        return cache;
    }

    @Override
    public void onAfter(int id) {
        try {
            super.onAfter(id);
            if (baseView != null) {
//                baseView.dissMissLoadingDialog();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T parseNetworkResponse(Response response, int id) throws Exception {
        String s = response.body().string();
        Log.e("s",s);
        cache =s ;
        if (getEntityClass() == null) {
            return (T) new Gson().fromJson(s, BaseBean.class);
        }
        return new Gson().fromJson(s, getEntityClass());
    }

    @Override
    public void onError(Call call, Exception e, int id) {
        e.printStackTrace();
        LogUtils.e("http请求异常:" + e.toString());
        try {
            if (e.getMessage().equals("Canceled")) {
                //用户取消,不用提示错误信息
                LogUtils.i("请求取消");
            } else {
                onFail(call, e, id);
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void onResponse(BaseBean response, int id) {
        /**
         * 可以在这里进行一切全局的判断,比如返回code=-99，直接弹出登录页面
         */
        if (isCheckLogin && response.code == -99) {
            Intent i = new Intent(CusApplication.mContext, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            CusApplication.mContext.startActivity(i);
        } else {
            if (response != null) {
                onSuccess((T) response, id);
            } else {
                LogUtils.e("response为null!!!");
                onFail(null, new Exception("response为null"), 0);
            }
        }
    }

    /**
     * 获取泛型T的Class
     *
     * @return
     */
    public Class<T> getEntityClass() {
        Type t = getClass().getGenericSuperclass();
        if (t instanceof ParameterizedType) {
            Type[] p = ((ParameterizedType) t).getActualTypeArguments();
            entityClass = (Class<T>) p[0];
        }
        return entityClass;
    }

    public abstract void onSuccess(T response, int id);

    public abstract void onFail(Call call, Exception e, int id);
}
