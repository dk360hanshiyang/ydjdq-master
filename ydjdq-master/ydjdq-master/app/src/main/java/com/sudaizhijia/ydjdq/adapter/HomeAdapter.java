package com.sudaizhijia.ydjdq.adapter;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;

import java.util.List;
import java.util.Random;

/**
 * Created by WilliamWang on 2018/12/4
 */
public class HomeAdapter extends BaseQuickAdapter<HomeBean.ObjectBean.ListBean, BaseViewHolder> {

    public HomeAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeBean.ObjectBean.ListBean item) {
        if (item == null && item.getBorrowProduct() == null) {
            Toast.makeText(mContext, "产品信息错误,请稍后重试！", Toast.LENGTH_SHORT).show();
            return;
        }

        if (item.getBorrowProduct() == null) {
            Toast.makeText(mContext, "weizhi" + helper.getAdapterPosition(), Toast.LENGTH_SHORT).show();
            return;
        }
        HomeBean.ObjectBean.ListBean.BorrowProductBeanX borrowProduct = item.getBorrowProduct();
        String description = borrowProduct.getDescription();
        String des1 = description.substring(0, 4);
        String des2 = description.substring(4, description.length());
        TextView tv_des1 = helper.getView(R.id.tv_product_des1);
        TextView tv_des2 = helper.getView(R.id.tv_product_des2);
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
        if(item.getNewLable() == 1) {
            helper.getView(R.id.iv_newlabel).setVisibility(View.VISIBLE);

        }
//        tv_des1.setTextColor(Color.parseColor(CusApplication.color[num]));
//        tv_des2.setTextColor(Color.parseColor(CusApplication.color[num1]));
        helper.setText(R.id.tv_product_title, borrowProduct.getName())
                .setText(R.id.tv_product_des1, des1 + "")
                .setText(R.id.tv_product_des2, des2)
                .setText(R.id.tv_product_maxmount, "最高" + (int) borrowProduct.getMaxAmount() + "元")
                .addOnClickListener(R.id.rl_item_root);
        Glide.with(mContext).load(borrowProduct.getLogoUrl()).into((ImageView) helper.getView(R.id.iv_product_icon));
//        Log.e("HOMELISTSIZE",item.getBorrowProduct().getDescription())
    }

}
