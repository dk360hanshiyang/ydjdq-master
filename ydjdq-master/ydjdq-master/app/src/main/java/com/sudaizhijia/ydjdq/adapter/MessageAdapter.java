package com.sudaizhijia.ydjdq.adapter;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.MessageBean;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: William Wang
 * Date:   On 2018/12/8
 */
public class MessageAdapter extends BaseQuickAdapter<MessageBean.ObjectBean.MessageListBean,BaseViewHolder> {
    public MessageAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void convert(BaseViewHolder helper, MessageBean.ObjectBean.MessageListBean item) {
        helper.setText(R.id.tv_message_title,item.getTitle())
                .setText(R.id.tv_time_now,getNormalYMDTime(item.getValidateDate()))
                .setText(R.id.tv_des,item.getRecommendWords())
                .addOnClickListener(R.id.cardView);
        Glide.with(mContext).asBitmap().load(item.getImgUrl()).into(new SimpleTarget<Bitmap>(180, 180) {
            @Override
            public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                //设置宽高
                Drawable drawable = new BitmapDrawable(resource);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    helper.getView(R.id.banner).setBackground(drawable);   //设置背景
                }

            }
        });
    }

    public static String getNormalYMDTime(long value) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
        String time = format.format(new Date(value)) ;
        return time;
    }

}
