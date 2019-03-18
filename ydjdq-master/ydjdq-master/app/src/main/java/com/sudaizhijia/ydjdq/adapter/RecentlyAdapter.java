package com.sudaizhijia.ydjdq.adapter;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseIntArray;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.bean.PinnedHeaderEntity;
import com.sudaizhijia.ydjdq.mvp.BaseView;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;

import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class RecentlyAdapter extends BaseMultiItemQuickAdapter<PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX>, BaseViewHolder> {

    public static final int TYPE_HEADER = 1;
    public static final int TYPE_DATA = 2;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public RecentlyAdapter(List<PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX>> data) {
        super(data);
        addItemType(TYPE_HEADER, R.layout.item_recently_header);
        addItemType(TYPE_DATA, R.layout.item_recently_data);
    }

    @Override
    protected void convert(BaseViewHolder helper, PinnedHeaderEntity<NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX> item) {
        switch (helper.getItemViewType()) {
            case TYPE_HEADER:
                helper.setText(R.id.tv_date, item.getPinnedHeaderName());
                break;
            case TYPE_DATA:
                NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX data = item.getData();
                int position = helper.getLayoutPosition();
                helper.setText(R.id.tv_maxmount, "最高"+(int)data.getBorrowProduct().getMaxAmount()+"元")
                        .setText(R.id.tv_product_des1, data.getBorrowProduct().getDescription()+"")
                .setText(R.id.tv_product_name,data.getBorrowProduct().getName()+"");
                Glide.with(this.mContext).load(data.getBorrowProduct().getLogoUrl())
                        .into((ImageView) helper.getView(R.id.iv_recently_icon));


        }
    }


}


