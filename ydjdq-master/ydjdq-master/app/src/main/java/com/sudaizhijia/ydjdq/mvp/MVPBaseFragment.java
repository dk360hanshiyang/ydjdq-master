package com.sudaizhijia.ydjdq.mvp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;

import java.lang.reflect.ParameterizedType;

import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public abstract class MVPBaseFragment<V extends BaseView,T extends BasePresenterImpl<V>> extends BaseFragment implements BaseView{
    public T mPresenter;


    @Override
    public void baseInit() {
        mPresenter= getInstance(this,1);
        mPresenter.attachView((V) this);
        init();
    }

    protected abstract void init();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter!=null)
            mPresenter.detachView();
    }

    @Override
    public Context getContext() {
        return super.getContext();
    }

    public  <T> T getInstance(Object o, int i) {
            try {
                return ((Class<T>) ((ParameterizedType) (o.getClass()
                        .getGenericSuperclass())).getActualTypeArguments()[i])
                        .newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassCastException e) {
                e.printStackTrace();
            } catch (java.lang.InstantiationException e) {
                e.printStackTrace();
            }
            return null;
        }

    public void initRefresh(BGARefreshLayout recyclerView, BGARefreshLayout.BGARefreshLayoutDelegate activity) {
        // 为BGARefreshLayout 设置代理
        recyclerView.setDelegate(activity);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder =
                new BGAMeiTuanRefreshViewHolder(getContext(), true);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_refreshing);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        // 设置下拉刷新和上拉加载更多的风格
        recyclerView.setRefreshViewHolder(refreshViewHolder);


        // 为了增加下拉刷新头部和加载更多的通用性，提供了以下可选配置选项  -------------START
        // 设置正在加载更多时不显示加载更多控件
        // mRefreshLayout.setIsShowLoadingMoreView(false);
        // 设置正在加载更多时的文本
//        refreshViewHolder.setLoadingMoreText(loadingMoreText);
//        // 设置整个加载更多控件的背景颜色资源 id
//        refreshViewHolder.setLoadMoreBackgroundColorRes(loadMoreBackgroundColorRes);
//        // 设置整个加载更多控件的背景 drawable 资源 id
//        refreshViewHolder.setLoadMoreBackgroundDrawableRes(loadMoreBackgroundDrawableRes);
//        // 设置下拉刷新控件的背景颜色资源 id
//        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
//        // 设置下拉刷新控件的背景 drawable 资源 id
//        refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
//        // 设置自定义头部视图（也可以不用设置）     参数1：自定义头部视图（例如广告位）， 参数2：上拉加载更多是否可用
//        mRefreshLayout.setCustomHeaderView(mBanner, false);
        // 可选配置  -------------END
    }
    public void stopRefresh(BGARefreshLayout bga, RecyclerView recycler){
        bga.endRefreshing();
        recycler.setVisibility(View.GONE);
    }

    public void addErrPageView(ViewGroup view,ErrNetListener listener){
        View errpage = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_errnet, null);
        view.removeAllViews();
        view.addView(errpage);
        errpage.findViewById(R.id.tv_net_err_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onReLoad();
            }
        });
    }

    public interface ErrNetListener{
        void onReLoad();
    }

    private ErrNetListener errNetListener;

    public void setOnErrNetListener(ErrNetListener listener){
        this.errNetListener = listener;
    }
    public boolean isLogin() {
        if (!CusApplication.isLogin) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return false;
        }
        return true;
    }


}
