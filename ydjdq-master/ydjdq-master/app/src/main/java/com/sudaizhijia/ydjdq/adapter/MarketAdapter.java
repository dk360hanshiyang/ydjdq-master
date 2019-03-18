package com.sudaizhijia.ydjdq.adapter;

import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.bean.MarketBean;
import com.sudaizhijia.ydjdq.global.CusApplication;

import java.util.Random;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class MarketAdapter extends BaseQuickAdapter<MarketBean.ObjectBean.DaQuanShowListBean, BaseViewHolder> {

    public MarketAdapter(int layoutResId) {
        super(layoutResId);
    }

    public static int itemHeight;

    @Override
    protected void convert(BaseViewHolder helper,MarketBean.ObjectBean.DaQuanShowListBean item) {
        helper.getView(R.id.rl_adapter_root).getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                helper.getView(R.id.rl_adapter_root).getViewTreeObserver().removeGlobalOnLayoutListener(this);
                itemHeight = helper.getView(R.id.rl_adapter_root).getMeasuredHeight();
            }
        });
//        HomeBean.ObjectBean.ListBean.BorrowProductBeanX borrowProduct = item.getBorrowProduct();
        if (item.getBorrowProduct() == null) {
            Toast.makeText(mContext, "有错误" + helper.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            return;
        }
        String description = item.getBorrowProduct().getDescription();
        String des1 = description.substring(0, 4);
        String des2 = description.substring(4, description.length());
        TextView tv_des1 = helper.getView(R.id.tv_market_des1);
        TextView tv_des2 = helper.getView(R.id.tv_market_des2);
        int min = 0;
        int max = CusApplication.color.length;
        Random random = new Random();
        int num;
        int num1;
        num = random.nextInt(max) % (max - min + 1) + min;
        num1 = random.nextInt(max) % (max - min + 1) + min;
        while (num == num1) {
            num1 = random.nextInt(max) % (max - min + 1) + min;
        }
//        tv_des1.setTextColor(Color.parseColor(CusApplication.color[num]));
//        tv_des2.setTextColor(Color.parseColor(CusApplication.color[num1]));
        helper.setText(R.id.tv_market_title, item.getBorrowProduct().getName())
                .setText(R.id.tv_market_des1, des1)
                .setText(R.id.tv_market_des2, des2)
                .setText(R.id.tv_market_maxmount, "最高" + (int)item.getBorrowProduct().getMaxAmount() + "元")
                .addOnClickListener(R.id.rl_adapter_root);
        if (item.getNewLable() == 1) {
            helper.getView(R.id.iv_new).setVisibility(View.VISIBLE);
        }else{
            helper.getView(R.id.iv_new).setVisibility(View.GONE);
        }
        Glide.with(mContext).load(item.getBorrowProduct().getLogoUrl()).into((ImageView) helper.getView(R.id.iv_market_icon));
    }
}
