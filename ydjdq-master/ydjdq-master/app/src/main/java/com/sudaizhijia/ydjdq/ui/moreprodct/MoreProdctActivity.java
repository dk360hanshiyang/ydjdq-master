package com.sudaizhijia.ydjdq.ui.moreprodct;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.MoreAdapter;
import com.sudaizhijia.ydjdq.bean.MoreProductBean;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.newpdu.now.SpaceItemDecoration;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MoreProdctActivity extends MVPBaseActivity<MoreProdctContract.View, MoreProdctPresenter> implements MoreProdctContract.View, BGARefreshLayout.BGARefreshLayoutDelegate, BaseQuickAdapter.OnItemChildClickListener {

    //    @BindView(R.id.recyler_moreproduct)
    RecyclerView recylerMoreproduct;
    //    @BindView(R.id.refreshlayout)
    BGARefreshLayout refreshlayout;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;
    private MoreAdapter moreAdapter;
    private BounceLoadingView loadingView;

    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        mPresenter.getData(false);
    }

    public void onResume() {
        MobclickAgent.onPageStart("放水新口子"); //手动统计页面("SplashScreen"为页面名称，可自定义)
        super.onResume();
    }

    public void onPause() {
        MobclickAgent.onPageEnd("放水新口子"); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
        super.onPause();
    }

    private void initRefreshLayout(View view) {
        refreshlayout = view.findViewById(R.id.rl_modulename_refresh);
        // 为BGARefreshLayout 设置代理
        refreshlayout.setDelegate(this);
        // 设置下拉刷新和上拉加载更多的风格     参数1：应用程序上下文，参数2：是否具有上拉加载更多功能
        BGARefreshViewHolder refreshViewHolder =
                new BGAMeiTuanRefreshViewHolder(getContext(), true);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setPullDownImageResource(R.mipmap.bga_refresh_mt_pull_down);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setChangeToReleaseRefreshAnimResId(R.drawable.bga_refresh_mt_refreshing);
        ((BGAMeiTuanRefreshViewHolder) refreshViewHolder).setRefreshingAnimResId(R.drawable.bga_refresh_mt_refreshing);
        // 设置下拉刷新和上拉加载更多的风格
        refreshlayout.setRefreshViewHolder(refreshViewHolder);
        view.findViewById(R.id.ll_floating_window).setVisibility(View.GONE);
        view.findViewById(R.id.iv_close_floating_window).setVisibility(View.GONE);
    }

    private void initRecycler(View view) {
        recylerMoreproduct = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recylerMoreproduct.setLayoutManager(linearLayoutManager);
        moreAdapter = new MoreAdapter(R.layout.layout_more_item);
//
//        //TODO 没有数据的时候默认显示该布局
//        homeAdapter.setEmptyView(getView());
        moreAdapter.setOnItemChildClickListener(this);
        recylerMoreproduct.addItemDecoration(new SpaceItemDecoration(1, 1, 1, 1));
        recylerMoreproduct.setAdapter(moreAdapter);
        moreAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                calculate(position, CusConstants.MOREPRODUCT);
                MoreProductBean.ObjectBean objectBean = bean.getObject().get(position);
                openDetail(CusConstants.MOREPRODUCT, objectBean, position);

            }
        });
    }

    public void openDetail(int type, MoreProductBean.ObjectBean data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);
    }

    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postUvData(bean, position, type);
            }
        }.start();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_moreproduct;
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mPresenter.getData(true);
            }
        }, 1000);
    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {

    }

    private MoreProductBean bean;

    @Override
    public void setData(MoreProductBean bean) {
        setAllData(bean, false);

    }

    @Override
    public void showLoading() {
        View lodingView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_loading, null);
        fl.removeAllViews();
        fl.addView(lodingView);
        loadingView = lodingView.findViewById(R.id.loadingView);
        startLoadingView();
    }

    private void startLoadingView() {

        loadingView.addBitmap(R.mipmap.v4);
        loadingView.addBitmap(R.mipmap.v5);
        loadingView.addBitmap(R.mipmap.v6);
        loadingView.addBitmap(R.mipmap.v7);
        loadingView.addBitmap(R.mipmap.v8);
        loadingView.addBitmap(R.mipmap.v9);
        loadingView.setShadowColor(Color.LTGRAY);
        loadingView.setDuration(700);
        loadingView.start();
    }

    @Override
    public void showErrPage() {
        View errpage = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_errnet, null);
        fl.removeAllViews();
        fl.addView(errpage);
        errpage.findViewById(R.id.tv_net_err_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getData(false);
            }
        });
    }

    public void setAllData(MoreProductBean homeBean, boolean isFresh) {
        this.bean = homeBean;
        moreAdapter.setNewData(bean.getObject());

    }

    @Override
    public void setfreshEnding(MoreProductBean bean) {
        setAllData(bean, true);
        refreshlayout.endRefreshing();
    }

    @Override
    public void addContentView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_recycler, null);
        fl.removeAllViews();
        fl.addView(view);
        initRefreshLayout(view);
        initRecycler(view);
    }


    @OnClick(R.id.rl_back)
    public void onViewClicked() {
        finishSelf();
    }
}
