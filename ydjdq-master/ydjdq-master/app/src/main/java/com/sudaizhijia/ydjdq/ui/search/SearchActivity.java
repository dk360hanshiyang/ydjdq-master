package com.sudaizhijia.ydjdq.ui.search;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.SearchrAdapter;
import com.sudaizhijia.ydjdq.bean.SearchBodyBean;
import com.sudaizhijia.ydjdq.bean.SearchHeaderBean;
import com.sudaizhijia.ydjdq.decoration.GridSectionAverageGapItemDecoration;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class SearchActivity extends MVPBaseActivity<SearchContract.View, SearchPresenter> implements SearchContract.View {

    @BindView(R.id.recycler_search)
    RecyclerView recyclerViewSearch;

    @Override
    protected void init() {
        initRecycler();
    }

    private void initRecycler() {
        List<SearchHeaderBean> sampleData = getSampleData();

        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
        recyclerViewSearch.setLayoutManager(manager);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return newNowAdapter.getItemViewType(position) == CusConstants.TYPE_NEWPRODUCT ? 1 : manager.getSpanCount();
//            }
//
//        });
        recyclerViewSearch.addItemDecoration(new GridSectionAverageGapItemDecoration(50,20,20,20));
        SearchrAdapter newNowAdapter = new SearchrAdapter(R.layout.layout_search_body, R.layout.layout_search_header,sampleData);
        recyclerViewSearch.setAdapter(newNowAdapter);

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_search;
    }

    public static List<SearchHeaderBean> getSampleData() {
        List<SearchHeaderBean> list = new ArrayList<>();
        list.add(new SearchHeaderBean(true, "热门搜索", "热门搜索"));
        list.add(new SearchHeaderBean(new SearchBodyBean("速贷之家")));
        list.add(new SearchHeaderBean(new SearchBodyBean("速贷之家")));
        list.add(new SearchHeaderBean(new SearchBodyBean("速贷之家")));
        list.add(new SearchHeaderBean(new SearchBodyBean("速贷之家")));
        list.add(new SearchHeaderBean(true, "搜索历史", "搜索历史"));
        list.add(new SearchHeaderBean(new SearchBodyBean("钱周周")));
        list.add(new SearchHeaderBean(new SearchBodyBean("钱周周")));
        list.add(new SearchHeaderBean(new SearchBodyBean("钱周周")));

        return list;
    }

}
