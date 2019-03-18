package com.sudaizhijia.ydjdq.ui.newpdu.recently;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.oushangfeng.pinnedsectionitemdecoration.PinnedHeaderItemDecoration;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.RecentlyAdapter;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.bean.PinnedHeaderEntity;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.newpdu.now.SpaceItemDecoration;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.umeng.analytics.MobclickAgent;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by WilliamWang on 2018/12/5
 */

public class RecentlyFragment extends MVPBaseFragment<RecentlyContract.View, RecentlyPresenter> implements RecentlyContract.View {


    private NewProductBean mHomeBean;
    private List<NewProductBean.ObjectBean.PastDayListBean> pastDayList;


    @BindView(R.id.recycler_recently)
    RecyclerView recyclerRecently;

    private List<PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX>> data;

    @Override
    protected void init() {
        mHomeBean = (NewProductBean) getArguments().getSerializable("homebean");
        pastDayList = mHomeBean.getObject().getPastDayList();
        initData();
        initRecycler();
    }

    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("最近上新"); //统计页面("MainScreen"为页面名称，可自定义)
    }

    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("最近上新");
    }

    private void initData() {
        data = new ArrayList<>();

        for (int i = 0; i < pastDayList.size(); i++) {
            String title = pastDayList.get(i).getTitle();
            data.add(new PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX>(null, RecentlyAdapter.TYPE_HEADER, title));
            for (NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX productShowListBeanX : pastDayList.get(i).getProductShowList()) {
                data.add(new PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX>(productShowListBeanX, RecentlyAdapter.TYPE_DATA, title));
            }
        }
    }

    private NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX.BorrowProductBeanXX borrowProduct;
    private NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX data1;

    private void initRecycler() {
        RecentlyAdapter recentlyAdapter = new RecentlyAdapter(data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recyclerRecently.setLayoutManager(linearLayoutManager);
        recyclerRecently.addItemDecoration(
                new PinnedHeaderItemDecoration.Builder(RecentlyAdapter.TYPE_HEADER)
//                        .setDividerId(R.drawable.divider).enableDivider(true)
//                        .setHeaderClickListener(headerClickListener)
                        .create());
        recyclerRecently.addItemDecoration(new SpaceItemDecoration(0, 0, 1, 1));
        recyclerRecently.setAdapter(recentlyAdapter);
        recyclerRecently.addOnItemTouchListener(new OnItemClickListener() {


            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int i) {
                switch (adapter.getItemViewType(i)) {
                    case RecentlyAdapter.TYPE_DATA:
                        PinnedHeaderEntity o = (PinnedHeaderEntity) adapter.getData().get(i);
                        data1 = (NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX) o.getData();
                        borrowProduct = data1.getBorrowProduct();
                        calculate(i, CusConstants.RECENTLY);
                        openDetail(CusConstants.RECENTLY, data1, i);
                        break;
                    case RecentlyAdapter.TYPE_HEADER:
//                        entity = mAdapter.getData().get(i);
//                        Toast.makeText(MainActivity.this,
//                                "item click, tag: " + entity.getPinnedHeaderName(),
//                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_recently;
    }

    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postUvData(data1, position, type);
            }
        }.start();
    }

    public void openDetail(int type, NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, (Serializable) data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);
    }
}
