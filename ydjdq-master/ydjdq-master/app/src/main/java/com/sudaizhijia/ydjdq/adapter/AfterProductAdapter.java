package com.sudaizhijia.ydjdq.adapter;

import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.AfterExpandItem;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.utils.BlurTransformation;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class AfterProductAdapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {
    private long timecurrent;
    private ArrayList<CountdownView> list = new ArrayList<>();
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public AfterProductAdapter(List<MultiItemEntity> data) {
        super(data);
        addItemType(CusConstants.TYPE_AFTEREXPAND, R.layout.layout_after_expand_1);
        addItemType(CusConstants.TYPE_AFTER, R.layout.layout_now_product);
    }

    public void setI(long timecurrent){
        this.timecurrent=timecurrent;
        this.notifyDataSetChanged();

    }

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        switch (helper.getItemViewType()) {
            case CusConstants.TYPE_AFTEREXPAND:
                AfterExpandItem lv0 = (AfterExpandItem) item;
                if (helper.getAdapterPosition() == 0) {
                    RelativeLayout rl = helper.getView(R.id.rl_after_newpdu_root);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                            .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin =0 ;
                    rl.setLayoutParams(layoutParams);
                }else{
                    RelativeLayout rl = helper.getView(R.id.rl_after_newpdu_root);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                            .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin =10 ;
                    rl .setLayoutParams(layoutParams);
                }
                if (lv0.isCountDown()) {
                    helper.setText(R.id.tv_after_time_title, lv0.getTime() + "")
                            .setText(R.id.tv_new_number, "即将上线");
                    int time_remain = lv0.getNowTime();
//                    CountdownView view =  helper.getView(R.id.cv_countdownViewTest1);
//                    list.add(view);
//                    view.start(time*1000);

                    time_remain= (int) (time_remain*1000-timecurrent);

                    TextView tv_hour = helper.getView(R.id.tv_hour);
                    TextView tv_minute = helper.getView(R.id.tv_minute);
                    TextView tv_second = helper.getView(R.id.tv_second);
                    if (time_remain <= 0) {
                        tv_hour.setText("00");
                        tv_minute.setText("00");
                        tv_second.setText("00");
                    } else {
                        long time_second = (time_remain / 1000) % 60;
                        String str_second;
                        if (time_second < 10) {
                            str_second = "0" + time_second;
                        } else {
                            str_second = "" + time_second;
                        }
                        long time_temp = ((time_remain / 1000) - time_second) / 60;
                        //分钟
                        long time_minute = time_temp % 60;
                        String str_minute;
                        if (time_minute < 10) {
                            str_minute = "0" + time_minute;
                        } else {
                            str_minute = "" + time_minute;
                        }

                        time_temp = (time_temp - time_minute) / 60;
                        //小时
                        long time_hour = time_temp;
                        String str_hour;
                        if (time_hour < 10) {
                            str_hour = "0" + time_hour;
                        } else {
                            str_hour = "" + time_hour;
                        }
                        tv_hour.setText(str_hour);
                        tv_minute.setText(str_minute);
                        tv_second.setText(str_second);
                    }
                }
//                helper.setText(R.id.tv_after_time_title, lv0.getTime() + "场");
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                    }
                });
                break;
            case CusConstants.TYPE_AFTER:
                NumberFormat nf = new DecimalFormat("#.#");
//                Glide.with(mContext).load(R.mipmap.mh).into((ImageView) helper.getView(R.id.img_nowpdu_name));
                NewProductBean.ObjectBean.TomorrowListBean.ProductShowListBean item1 =
                        (NewProductBean.ObjectBean.TomorrowListBean.ProductShowListBean) item;
                double maxAmount = item1.getBorrowProduct().getMaxAmount();
                helper.setText(R.id.tv_nowpdu_des, "最高" + nf.format(maxAmount) + "元");
                if (item1.getBorrowProduct().getLogoUrl() != "") {
                    Glide.with(mContext).load(item1.getBorrowProduct().getLogoUrl()).apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 1))).into((CircleImageView) helper.getView(R.id.iv_newproduct_icon));
                }
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"即将上线，敬请期待",Toast.LENGTH_LONG).show();
                    }
                });

                break;
        }
    }
    @Override
    public void onViewDetachedFromWindow(@NonNull BaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        for (CountdownView view : list) {
            view.stop();
            view.allShowZero();
        }

    }

}

