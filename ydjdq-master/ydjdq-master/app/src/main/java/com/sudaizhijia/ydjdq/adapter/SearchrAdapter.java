package com.sudaizhijia.ydjdq.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.AfterExpandItem;
import com.sudaizhijia.ydjdq.bean.SearchBodyBean;
import com.sudaizhijia.ydjdq.bean.SearchHeaderBean;
import com.sudaizhijia.ydjdq.global.CusConstants;

import java.util.List;

import static com.sudaizhijia.ydjdq.global.CusConstants.TYPE_BODY;
import static com.sudaizhijia.ydjdq.global.CusConstants.TYPE_HEADER;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class SearchrAdapter extends BaseSectionQuickAdapter<SearchHeaderBean, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param layoutResId      The layout resource id of each item.
     * @param sectionHeadResId The section head layout id for each item
     * @param data             A new list is created out of this one to avoid mutable list
     */
    public SearchrAdapter(int layoutResId, int sectionHeadResId, List<SearchHeaderBean> data) {
        super(layoutResId, sectionHeadResId, data);
    }


//    @Override
//    protected void convert(BaseViewHolder helper, SearchBodyBean item) {
//        switch (helper.getItemViewType()) {
//            case CusConstants.TYPE_HEADER:
//                helper.setText(R.id.iv_header, item.getTitle() );
//                break;
//            case CusConstants.TYPE_BODY:
//                helper.setText(R.id.tv_search_body, item.getTitle() );
//                break;
//        }
//    }

    @Override
    protected void convertHead(BaseViewHolder helper, SearchHeaderBean item) {
        helper.setText(R.id.tv_search__header_title, item.getTitle());
//        helper.setVisible(R.id.more, item.isMore());
//        helper.addOnClickListener(R.id.more);
    }

    @Override
    protected void convert(BaseViewHolder helper, SearchHeaderBean item) {
        SearchBodyBean bodyBean = item.t;
        helper.setText(R.id.tv_search_body, bodyBean.getTitle());

    }
}
