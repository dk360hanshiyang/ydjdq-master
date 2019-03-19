package com.sudaizhijia.ydjdq.ui.market;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.GirdDropDownAdapter;
import com.sudaizhijia.ydjdq.adapter.MarketAdapter;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.bean.MarketBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.newpdu.now.SpaceItemDecoration;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.ui.search.SearchActivity;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.wiget.DropDownMenu;
import com.umeng.analytics.MobclickAgent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;

/**
 * Created by WilliamWang on 2018/12/5
 */
public class MarketFragment extends MVPBaseFragment<MarketContract.View, MarketPresenter> implements MarketContract.View, BGARefreshLayout.BGARefreshLayoutDelegate {

    @BindView(R.id.dropDownMenu)
    DropDownMenu mDropDownMenu;
    @BindView(R.id.rl_search)
    RelativeLayout rlSearch;
    @BindView(R.id.rl_titlebar)
    RelativeLayout rltitlebar;
    @BindView(R.id.ll_dropmenu)
    LinearLayout llDropMenu;
    private int currentPage = 0;
    private int pageSize = 16;

    private String headers[] = {"综合排序", "额度"};
    private String sort[] = {"综合排序", "额度最大", "最新上架"};
    private String monut[] = {"不限", "1-5千", "5千以上"};
    private GirdDropDownAdapter sortAdapter;
    private List<View> popupViews = new ArrayList<>();
    private GirdDropDownAdapter amountAdapter;
    private RecyclerView recycler;
    private BGARefreshLayout bgaRefreshLayout;
    private MarketAdapter marketAdapter;
    private int titlebarHeight;
    private int llDrpMenuHeight;
    private int screenHeight;
    private int itemHeight;
    private MarketBean bean;
    private String mSort = "moren";
    private String max;
    private String min;
//    private boolean isFirst = true;


    @Override
    public Context getContext() {
        return getActivity();
    }

    @Override
    protected void init() {
        initDropDown();
        initRefreshLayout();
        initRecycler();
        String string = SharedPreUtils.getString(getContext(), CusConstants.MARKET_DATA_INFO, "");
      /*  if (!TextUtils.isEmpty(string)) {
            MarketBean bean = new Gson().fromJson(string, MarketBean.class);
            if (bean.code == 1) {
//                setDemoList(bean);
                currentPage = 0;
                List<MarketBean.ObjectBean.DaQuanShowListBean> daQuanShowList = bean.getObject().getDaQuanShowList();
                marketAdapter.setNewData(daQuanShowList);

            }
        }
*/
        mPresenter.getMarketListInfo(false, currentPage + "", pageSize + "", 0, "moren", "9999999", "1");
        rltitlebar.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                rltitlebar.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                titlebarHeight = rltitlebar.getMeasuredHeight();
            }
        });

        ViewTreeObserver vto1 = llDropMenu.getViewTreeObserver();
        vto1.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                llDropMenu.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                llDrpMenuHeight = llDropMenu.getMeasuredHeight();
            }
        });
        initPX();
//        onBGARefreshLayoutBeginRefreshing(bgaRefreshLayout);
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("贷款大全");

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("贷款大全");

    }

    private MarketBean.ObjectBean.DaQuanShowListBean daQuanShowListBean;

    private void initPX() {
        WindowManager manager = getActivity().getWindowManager();
        DisplayMetrics outMetrics = new DisplayMetrics();
        manager.getDefaultDisplay().getMetrics(outMetrics);
        screenHeight = outMetrics.heightPixels;
//        WindowManager windowManager =
//                (WindowManager) getActivity().getApplication().getSystemService(Context.
//                        WINDOW_SERVICE);
//        final Display display = windowManager.getDefaultDisplay();
//        Point outPoint = new Point();
//        if (Build.VERSION.SDK_INT >= 19) {
//            // 可能有虚拟按键的情况
//            display.getRealSize(outPoint);
//        } else {
//            // 不可能有虚拟按键
//            display.getSize(outPoint);
//        }
//        int mRealSizeWidth;//手机屏幕真实宽度
//        int mRealSizeHeight;//手机屏幕真实高度
//        screenHeight = outPoint.y;
//        mRealSizeWidth = outPoint.x;

    }

    private int itemCount;

    private void initRecycler() {
        marketAdapter = new MarketAdapter(R.layout.layout_market_item);
        marketAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {

                if (MarketAdapter.itemHeight != 0) {
//                    itemCount = (screenHeight - llDrpMenuHeight - titlebarHeight) / MarketAdapter.itemHeight;
                    itemCount = (screenHeight - titlebarHeight) / MarketAdapter.itemHeight;
                    pageSize = itemCount * 2 + 4;
                }
                loadMore();

            }
        });
        marketAdapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 2);
        recycler.addItemDecoration(new SpaceItemDecoration(0, 0, 2, 2));
        recycler.setAdapter(marketAdapter);
        recycler.setLayoutManager(manager);
        marketAdapter.setPreLoadNumber(pageSize - 4);
        marketAdapter.bindToRecyclerView(recycler);
        marketAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {


            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (isLogin()) {
                    daQuanShowListBean = bean.getObject().getDaQuanShowList().get(position);
                    calculate(position, CusConstants.MARKET_DATA);
                    openDetail(CusConstants.MARKET_DATA, daQuanShowListBean, position);
                }
            }
        });
        marketAdapter.disableLoadMoreIfNotFullPage();
    }

    public void openDetail(int type, MarketBean.ObjectBean.DaQuanShowListBean data, int position) {
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

    private void loadMore() {

//        LogUtils.e("pagesize===" + pageSize);
        mPresenter.getMarketListInfo(false, currentPage + "", pageSize + "", 10, "moren", "9999999", "1");

    }

    /**
     * 初始化下拉菜单
     */
    private void initDropDown() {
        final ListView sortView = new ListView(getContext());
        sortAdapter = new GirdDropDownAdapter(getContext(), Arrays.asList(sort));
        sortView.setDividerHeight(0);
        sortView.setAdapter(sortAdapter);

        final ListView monutView = new ListView(getContext());
        amountAdapter = new GirdDropDownAdapter(getContext(), Arrays.asList(monut));
        monutView.setDividerHeight(0);
        monutView.setAdapter(amountAdapter);

        popupViews.add(sortView);
        popupViews.add(monutView);

        sortView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    mSort = "moren";
                } else if (position == 1) {
                    mSort = "maxAmount";
                } else if (position == 2) {
                    mSort = "zuiXin";
                }
                mPresenter.getMarketListInfo(false, 0 + "", 15 + "", 99, mSort, "9999999", "1");
                sortAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[0] : sort[position]);
                mDropDownMenu.closeMenu();
            }
        });

        monutView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    max = "9999999";
                    min = "1";
                } else if (position == 1) {
                    max = "5000";
                    min = "1000";
                } else if (position == 2) {
                    max = "9999999";
                    min = "5000";
                }
                mPresenter.getMarketListInfo(false, 0 + "", 15 + "", 99, mSort, max, min);
                amountAdapter.setCheckItem(position);
                mDropDownMenu.setTabText(position == 0 ? headers[1] : monut[position]);
                mDropDownMenu.closeMenu();
            }
        });
        //init context view
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_market_contentview, null);
        bgaRefreshLayout = view.findViewById(R.id.rl_refresh);
        recycler = view.findViewById(R.id.recycler_marekt);
        //init dropdownview
        mDropDownMenu.setDropDownMenu(Arrays.asList(headers), popupViews, view);

    }

    /**
     * 初始化RefershLayout
     */
    public void initRefreshLayout() {
        initRefresh(bgaRefreshLayout, this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_market;
    }

    /**
     * 下拉刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        try {
            pageSize = bean.getObject().getDaQuanShowList().size();
            mPresenter.getMarketListInfo(true, 0 + "", pageSize + "", 0, "moren", "9999999", "1");
        } catch (Exception e) {

        }

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }

    @Override
    public void refreshData(BaseBean baseBean) {
        currentPage = 0;
        setDemoList(baseBean);
        stopRefresh();
    }

    private void setDemoList(BaseBean baseBean) {
        if (!TextUtils.isEmpty(SharedPreUtils.getString(CusApplication.mContext, CusConstants.MARKET_DATA_INFO, ""))) {
            String cache = SharedPreUtils.getString(CusApplication.mContext, CusConstants.MARKET_DATA_INFO, "");
            MarketBean marketBean = new Gson().fromJson(cache, MarketBean.class);
            if (marketBean != null) {
                if (marketBean.getObject() != null) {
                    if (marketBean.getObject().getDaQuanShowList() != null && marketBean.getObject().getDaQuanShowList().size() > 0) {
                        marketAdapter.setNewData(marketBean.getObject().getDaQuanShowList());
                    }
                }
            }
        }
        currentPage = currentPage + pageSize;
        bean = (MarketBean) baseBean;
        List<MarketBean.ObjectBean.DaQuanShowListBean> daQuanShowList = bean.getObject().getDaQuanShowList();
        marketAdapter.setNewData(daQuanShowList);


    }

    @Override
    public void setMarketListData(BaseBean baseBean) {
//        isFirst = false;
        setDemoList(baseBean);
    }

    @Override
    public void stopRefresh() {
        bgaRefreshLayout.endRefreshing();
    }

    @Override
    public void loadMoreData(BaseBean baseBean) {
        currentPage = currentPage + pageSize;
        MarketBean bean = (MarketBean) baseBean;
        marketAdapter.addData(bean.getObject().getDaQuanShowList());
        marketAdapter.loadMoreComplete();
    }

    @Override
    public void stopLoadMore() {
        marketAdapter.loadMoreFail();
    }

    @Override
    public void loadComplete() {
        marketAdapter.loadMoreEnd();
//        Toast.makeText(getContext(), "无更多数据", Toast.LENGTH_SHORT).show();
    }


    @OnClick(R.id.rl_search)
    public void onViewClicked() {
        if (isLogin()) {
            startActivity(new Intent(getContext(), SearchActivity.class));
        }
    }


}
