package com.sudaizhijia.ydjdq.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.bean.NowExpandItem;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;
import okhttp3.Call;

/**
 * Author: William Wang
 * Date:   On 2018/12/5
 */
public class NewNowAdapter extends RecyclerView.Adapter<NewNowAdapter.ViewHolder> {
    private long timecurrent;
    private List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList;
    private CountdownView view;
    private List<MultiItemEntity> data;
    List<Boolean> isOpen = new ArrayList<>();
    //    private  bean;
    private Context mcontext;
    private NewNowAdapterItem newNowAdapterItem;

    public NewNowAdapter(List<MultiItemEntity> data, Context mcontext, List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList) {
        this.mcontext = mcontext;
        this.data = data;
        this.todayNewList = todayNewList;
        isOpen.clear();

    }

    public void setI(long timecurrent) {
        this.timecurrent = timecurrent;
        this.notifyDataSetChanged();

    }

    private List<NewProductBean.ObjectBean.TodayNewListBean> mlist;

    public void setOnFoucus(List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList) {
        this.mlist = todayNewList;
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull ViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        for (CountdownView view : list) {
            view.stop();
            view.allShowZero();
        }
    }

    private ArrayList<CountdownView> list = new ArrayList<>();

    private int position;


    public void openDetail(int type, NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX data, int position) {
        int index = data.getSortIndex();
        if (index > 0) {
            Intent intent = new Intent(mcontext, ProductDetailActivity.class);
            intent.putExtra(CusConstants.START_TYPE, type);
            intent.putExtra(CusConstants.PRODUCT_INFO, (Serializable) data);
            intent.putExtra(CusConstants.PRODUCT_POSITION, position);
            mcontext.startActivity(intent);
        } else {
            Toast.makeText(mcontext, "即将上线，敬请期待", Toast.LENGTH_LONG).show();
        }
    }

    public void postUvData(NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX bean1, int position, int type) {
        if (bean1.getBorrowProduct() == null && bean1.getPosition() == null) {
            return;
        }
        try {
            CusApplication.random = AppInfoUtil.getNowTime();
            int productShowId = 0;
            String mposition = "";
            int sortIndex = 0;
            int id = 0;
            productShowId = bean1.getProductId();
            mposition = bean1.getPosition().getKey();
            sortIndex = bean1.getSortIndex();
            id = bean1.getId();
            OkHttpUtils
                    .post()
                    .url(API.UV)
                    .addParams("productShowId", productShowId + "")
                    .addParams("position", mposition)
                    .addParams("sortIndex", sortIndex + "")
                    .addParams("iemi", AppInfoUtil.getIMEI(mcontext))
                    .addParams("productId", id + "")
                    .addParams("actionSerialNumber", CusApplication.random)
                    .addParams("userId", CusApplication.object.getUserId() + "")
                    .addParams("accessPort", "2")
                    .build()
                    .execute(new HttpCallback() {
                        @Override
                        public void onSuccess(BaseBean response, int id) {

                        }

                        @Override
                        public void onFail(Call call, Exception e, int id) {
                        }

                        @Override
                        public void onResponse(Object response, int id) {

                        }
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(mcontext, R.layout.layout_now_expand_2, null);
//        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    private boolean isopen = false;

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.itemView.setTag(i);
//        viewHolder.setIsRecyclable(false);
        MultiItemEntity item = data.get(i);
        NowExpandItem lv0 = (NowExpandItem) item;
        isOpen.add(todayNewList.get(i).isSpread());
        if (i == 0) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.topMargin = 0;
            viewHolder.rl_item_newpdu_root.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                    .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            layoutParams.topMargin = 10;
            viewHolder.rl_item_newpdu_root.setLayoutParams(layoutParams);
        }
        GridLayoutManager layoutManager = new GridLayoutManager(mcontext, 2);
        viewHolder.recyclerView.setLayoutManager(layoutManager);
        List<NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX> productShowList = todayNewList.get(i).getProductShowList();
        Log.e("productShowList", productShowList.toString());
        Log.e("position", "positionyijj" + i);
        newNowAdapterItem = new NewNowAdapterItem(mcontext, todayNewList);
        newNowAdapterItem.setPosition(i);
        viewHolder.recyclerView.setAdapter(newNowAdapterItem);
        if (todayNewList.get(i).isSpread()) {
            viewHolder.recyclerView.setVisibility(View.VISIBLE);
        } else {
            viewHolder.recyclerView.setVisibility(View.GONE);
        }
        viewHolder.tv_isexpand.setText(todayNewList.get(i).isSpread() ? "点击收起" : "点击展开");
        viewHolder.iv_action.setImageResource(todayNewList.get(i).isSpread() ? R.mipmap.ic_top : R.mipmap.ic_down);

        if (!lv0.isCountDown()) {
            mlist.size();
            Log.e("lv0.isCountDown()", lv0.isCountDown() + "");
            Log.e("mlist.size()", mlist.size() + "");
            viewHolder.im_new_number.setVisibility(View.GONE);
            viewHolder.llCountDown.setVisibility(View.GONE);
            viewHolder.llIsExpand.setVisibility(View.VISIBLE);
            viewHolder.tv_time_title2.setText("");
            viewHolder.tv_time_title.setText(lv0.getTime());
            viewHolder.tv_new_number.setText("已上线" + lv0.getNumber() + "家");

            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isOpen.get((Integer) v.getTag()) == true) {
                        isOpen.set((Integer) v.getTag(), false);
                        viewHolder.recyclerView.setVisibility(View.GONE);
                        viewHolder.tv_isexpand.setText("点击展开");
                        viewHolder.iv_action.setImageResource(R.mipmap.ic_down);
                    } else {
                        isOpen.set((Integer) v.getTag(), true);
                        viewHolder.tv_isexpand.setText("点击收起");
                        viewHolder.recyclerView.setVisibility(View.VISIBLE);
                        viewHolder.iv_action.setImageResource(R.mipmap.ic_top);
                    }
                }
            });
//            helper.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int position = helper.getAdapterPosition();
//                    if (lv0.isExpanded()) {
//                        collapse(position);
//                    } else {
//                        expand(position);
//                    }
//                }
//            });
//            if (mlist.size() > 0) {
//                for (int i = 0; i < mlist.size() - 1; i++) {
//                }
//            }
        } else {
            viewHolder.tv_new_number.setText("即将上线");
            viewHolder.im_new_number.setVisibility(View.VISIBLE);
            viewHolder.llCountDown.setVisibility(View.VISIBLE);
            viewHolder.llIsExpand.setVisibility(View.GONE);
            viewHolder.tv_time_title.setText(lv0.getTime());
            viewHolder.tv_time_title2.setText("家");
            int time_remain = lv0.getNowTime();

            list.add(viewHolder.cv_countdownViewTest2);
            viewHolder.cv_countdownViewTest2.setTag(i);
            viewHolder.cv_countdownViewTest2.start(time_remain * 1000);
//            Log.e("time()", time + "");
//            time_remain= (int) (time_remain*1000-timecurrent);
//
//            if (time_remain <= 0) {
//                viewHolder.tv_hour.setText("00");
//                viewHolder.tv_minute.setText("00");
//                viewHolder.tv_second.setText("00");
//            } else {
//                long time_second = (time_remain / 1000) % 60;
//                String str_second;
//                if (time_second < 10) {
//                    str_second = "0" + time_second;
//                } else {
//                    str_second = "" + time_second;
//                }
//                long time_temp = ((time_remain / 1000) - time_second) / 60;
//                //分钟
//                long time_minute = time_temp % 60;
//                String str_minute;
//                if (time_minute < 10) {
//                    str_minute = "0" + time_minute;
//                } else {
//                    str_minute = "" + time_minute;
//                }
//
//                time_temp = (time_temp - time_minute) / 60;
//                //小时
//                long time_hour = time_temp;
//                String str_hour;
//                if (time_hour < 10) {
//                    str_hour = "0" + time_hour;
//                } else {
//                    str_hour = "" + time_hour;
//                }
//                viewHolder.tv_hour.setText(str_hour);
//                viewHolder.tv_minute.setText(str_minute);
//                viewHolder.tv_second.setText(str_second);
//                Log.e("tv_second",str_second);
//            }
        }

    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_time_title;
        RecyclerView recyclerView;
        LinearLayout llCountDown;
        LinearLayout llIsExpand;
        TextView tv_new_number;
        TextView tv_isexpand;
        ImageView iv_action;
        RelativeLayout rl_item_newpdu_root;
        CountdownView cv_countdownViewTest2;
        ImageView imgNowpauName;
        TextView tv_hour;
        TextView tv_minute;
        TextView tv_second;
        ImageView im_new_number;
        TextView tv_time_title2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cv_countdownViewTest2 = itemView.findViewById(R.id.cv_countdownViewTest2);
            tv_time_title = itemView.findViewById(R.id.tv_time_title);
            recyclerView = itemView.findViewById(R.id.layout_now_product);
            llCountDown = itemView.findViewById(R.id.ll_coutdown);
            llIsExpand = itemView.findViewById(R.id.ll_isexpand);
            tv_new_number = itemView.findViewById(R.id.tv_new_number);
            tv_isexpand = itemView.findViewById(R.id.tv_isexpand);
            iv_action = itemView.findViewById(R.id.iv_action);
            rl_item_newpdu_root = itemView.findViewById(R.id.rl_item_newpdu_root);
            imgNowpauName = itemView.findViewById(R.id.im_new_number);
            tv_hour = itemView.findViewById(R.id.tv_hour);
            tv_minute = itemView.findViewById(R.id.tv_minute);
            tv_second = itemView.findViewById(R.id.tv_second);
            im_new_number = itemView.findViewById(R.id.im_new_number);
            tv_time_title2 = itemView.findViewById(R.id.tv_time_title2);
        }
    }

}
