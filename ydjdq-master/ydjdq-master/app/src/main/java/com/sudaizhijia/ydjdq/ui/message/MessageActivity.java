package com.sudaizhijia.ydjdq.ui.message;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.MessageAdapter;
import com.sudaizhijia.ydjdq.bean.MessageBean;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
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

public class MessageActivity extends MVPBaseActivity<MessageContract.View, MessagePresenter> implements MessageContract.View, BGARefreshLayout.BGARefreshLayoutDelegate, BaseQuickAdapter.OnItemChildClickListener {
    private int total;
    @BindView(R.id.ivback)
    ImageView ivback;
    @BindView(R.id.rl_message)
    RelativeLayout rlMessage;
    @BindView(R.id.ll_back)
    RelativeLayout llBack;
    //    @BindView(R.id.recyler_message)
    RecyclerView recylerMessage;
    //    @BindView(R.id.refreshlayout)
    BGARefreshLayout refreshlayout;
    @BindView(R.id.fl)
    FrameLayout fl;
    private MessageAdapter messageAdapter;
    private BounceLoadingView loadingView;
    private int currentPage = 1;
    private int pageSize = 8;

    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        mPresenter.getData(false, currentPage, pageSize, -99);
    }

    public void onResume() {
        MobclickAgent.onPageStart("消息界面"); //手动统计页面("SplashScreen"为页面名称，可自定义)
        super.onResume();
    }

    public void onPause() {
        MobclickAgent.onPageEnd("消息界面"); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
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
    }

    private void initRecycler(View view) {
        recylerMessage = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recylerMessage.setLayoutManager(linearLayoutManager);
        messageAdapter = new MessageAdapter(R.layout.layout_message_item);
        messageAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                loadMore();
            }
        });
        messageAdapter.bindToRecyclerView(recylerMessage);
        //        //TODO 没有数据的时候默认显示该布局
//        homeAdapter.setEmptyView(getView());
        messageAdapter.setOnItemChildClickListener(this);
        recylerMessage.setAdapter(messageAdapter);
        messageAdapter.disableLoadMoreIfNotFullPage();


    }

    private void loadMore() {
        if (total <= currentPage) {
            messageAdapter.loadMoreEnd();
            Toast.makeText(this, "没有更多数据", Toast.LENGTH_SHORT).show();
            return;
        } else {
            mPresenter.getData(false, currentPage, pageSize, 10);

        }

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_message;
    }


    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                currentPage = 1;
                mPresenter.getData(true, currentPage, pageSize, -99);
            }
        }, 1000);


    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        MessageBean.ObjectBean.MessageListBean messageListBean = msgBean.getObject().getMessageList().get(position);
        calculate(position, CusConstants.MESSAGE_MSG);
        openDetail(CusConstants.MESSAGE_MSG, messageListBean, position);
    }

    public void openDetail(int type, MessageBean.ObjectBean.MessageListBean data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);
    }

    @Override
    public void setErrNet() {
        currentPage = 1;
        View errpage = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_errnet, null);
        fl.removeAllViews();
        fl.addView(errpage);
        errpage.findViewById(R.id.tv_net_err_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getData(false, currentPage, pageSize, -99);
            }
        });
    }

    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postUvData(msgBean, position, type);
            }
        }.start();
    }

    @Override
    public void setContentView() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_recycler, null);
        view.findViewById(R.id.ll_floating_window).setVisibility(View.GONE);
        view.findViewById(R.id.iv_close_floating_window).setVisibility(View.GONE);
        fl.removeAllViews();
        fl.addView(view);
        initRefreshLayout(view);
        initRecycler(view);
    }

    @Override
    public void setLoadingView() {
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
    public void setData(MessageBean bean) {
        setAllData(bean, false);
    }

    @Override
    public void setfreshEnding(MessageBean bean) {
        setAllData(bean, true);
        refreshlayout.endRefreshing();
    }

    @Override
    public void stopRefresh() {
        refreshlayout.endRefreshing();
    }

    @Override
    public void stopLoadMore() {
        messageAdapter.loadMoreFail();

    }

    @Override
    public void loadMoreData(MessageBean msg) {
        currentPage = currentPage + pageSize;

        messageAdapter.addData(msg.getObject().getMessageList());
        messageAdapter.loadMoreComplete();
    }

    private MessageBean msgBean;


    public void setAllData(MessageBean homeBean, boolean isFresh) {
        this.msgBean = homeBean;
        this.total = msgBean.getObject().getTotal();
        messageAdapter.setNewData(msgBean.getObject().getMessageList());

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.ll_back)
    public void onViewClicked() {
        finish();
    }
}
