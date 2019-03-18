package com.sudaizhijia.ydjdq.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.MoreProductBean;

/**
 * Author: William Wang
 * Date:   On 2018/12/8
 */
public class MoreAdapter extends BaseQuickAdapter<MoreProductBean.ObjectBean, BaseViewHolder> {

    public MoreAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MoreProductBean.ObjectBean item) {

        helper.setText(R.id.tv_product_name, item.getBorrowProduct().getName())
                .setText(R.id.tv_product_des, item.getBorrowProduct().getDescription())
                .setText(R.id.tv_max, "最高" + ((int) item.getBorrowProduct().getMaxAmount()) + "元")
                .addOnClickListener(R.id.rl_moreProduct);
        Glide.with(mContext).load(item.getBorrowProduct().getLogoUrl()).into((ImageView) helper.getView(R.id.iv_icon));
    }
}
