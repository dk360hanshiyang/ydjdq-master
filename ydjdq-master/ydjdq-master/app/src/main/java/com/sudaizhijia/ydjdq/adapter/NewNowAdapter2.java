package com.sudaizhijia.ydjdq.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
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
import com.sudaizhijia.ydjdq.utils.BlurTransformation;
import com.wonderkiln.blurkit.BlurKit;
import com.zhy.http.okhttp.OkHttpUtils;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

import cn.iwgang.countdownview.CountdownView;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

/**
 * Author: William Wang
 * Date:   On 2018/12/5
 */
public class NewNowAdapter2 extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    //    private TextView tv_second;
//    private TextView tv_minute;
//    private TextView tv_hour;
    private LinearLayout llCountDown;
    private LinearLayout llIsExpand;
    private NowExpandItem lv0;
    private List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList;
    private CountdownView view;
    //    private  bean;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public NewNowAdapter2(List<MultiItemEntity> data) {
        super(data);
        addItemType(CusConstants.TYPE_NEWNOW_1, R.layout.layout_now_expand_1);
        addItemType(CusConstants.TYPE_NEWPRODUCT, R.layout.layout_now_product);
    }


    @Override
    public void onViewDetachedFromWindow(@NonNull BaseViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        for (CountdownView view : list) {
            view.stop();
            view.allShowZero();
        }

    }

    private List<NewProductBean.ObjectBean.TodayNewListBean> mlist;

    public void setOnFoucus(List<NewProductBean.ObjectBean.TodayNewListBean> todayNewList) {
        this.mlist = todayNewList;
    }

    private ArrayList<CountdownView> list = new ArrayList<>();

    private int position;
    private Context mcontexct;

    @Override
    protected void convert(BaseViewHolder helper, MultiItemEntity item) {
        mcontexct = helper.itemView.getContext();
        view = helper.getView(R.id.cv_countdownViewTest2);
        switch (helper.getItemViewType()) {
            case CusConstants.TYPE_NEWNOW_1:
                lv0 = (NowExpandItem) item;

                this.position = lv0.getPosition();
                if (helper.getAdapterPosition() == 0) {
                    RelativeLayout rl_item_newpdu_root = helper.getView(R.id.rl_item_newpdu_root);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                            .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin = 0;
                    rl_item_newpdu_root.setLayoutParams(layoutParams);
                } else {
                    RelativeLayout rl_item_newpdu_root = helper.getView(R.id.rl_item_newpdu_root);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                            .LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    layoutParams.topMargin = 10;
                    rl_item_newpdu_root.setLayoutParams(layoutParams);
                }
                llCountDown = helper.getView(R.id.ll_coutdown);
                llIsExpand = helper.getView(R.id.ll_isexpand);
                if (!lv0.isCountDown()) {
                    mlist.size();
//                    Log.e("lv0.isCountDown()", lv0.isCountDown() + "");
//                    Log.e("mlist.size()", mlist.size() + "");
                    llCountDown.setVisibility(View.GONE);
                    llIsExpand.setVisibility(View.VISIBLE);
                    helper.setText(R.id.tv_time_title, lv0.getTime())
                            .setText(R.id.tv_new_number, "已上线" + lv0.getNumber() + "家")
                            .setText(R.id.tv_isexpand, lv0.isExpanded() ? "点击收起" : "点击展开")
                            .setImageResource(R.id.iv_action, lv0.isExpanded() ? R.mipmap.ic_top : R.mipmap.ic_down);
//                    Log.e("lv0.getTime()", lv0.getTime() + "");
                    helper.itemView.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int position = helper.getAdapterPosition();
                            if (lv0.isExpanded()) {
                                collapse(position);
                            } else {
                                expand(position);
                            }
                        }
                    });
                    if (mlist.size() > 0) {
                        for (int i = 0; i < mlist.size() - 1; i++) {
                        }
                    }
                } else {
                    llCountDown.setVisibility(View.VISIBLE);
                    llIsExpand.setVisibility(View.GONE);
                    helper.setText(R.id.tv_time_title, lv0.getTime())
                            .setText(R.id.tv_new_number, "即将上线?家");
                    int time = lv0.getNowTime();

                    list.add(view);
                    view.start(time * 1000);
//                    Log.e("time()", time + "");
                }


                break;
            case CusConstants.TYPE_NEWPRODUCT:

                NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX bean = (NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX) item;
                double maxAmount = bean.getBorrowProduct().getMaxAmount();
                NumberFormat nf = new DecimalFormat("#.#");

//                Log.e("name", bean.getBorrowProduct().getName());
                if (bean.getBorrowProduct().getName().equals("****")) {
                    if (!TextUtils.isEmpty(bean.getBorrowProduct().getLogoUrl())) {
                        Glide.with(mContext).load(bean.getBorrowProduct().getLogoUrl()).apply(RequestOptions.bitmapTransform(new BlurTransformation(15, 1))).into((CircleImageView) helper.getView(R.id.iv_newproduct_icon));
                        helper.setText(R.id.tv_nowpdu_name, bean.getBorrowProduct().getName())
                                .setText(R.id.tv_nowpdu_des, "最高" + nf.format(maxAmount) + "元");

                    }
                } else {
                    Glide.with(mContext).load(bean.getBorrowProduct().getLogoUrl()).into((CircleImageView) helper.getView(R.id.iv_newproduct_icon));
                    helper.setText(R.id.tv_nowpdu_name, bean.getBorrowProduct().getName())
                            .setText(R.id.tv_nowpdu_des, "最高" + nf.format(maxAmount) + "元");
                    TextView tv = helper.getView(R.id.tv_nowpdu_name);
                    tv.setDrawingCacheEnabled(true);
                    tv.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
                    tv.layout(0, 0, tv.getMeasuredWidth(), tv.getMeasuredHeight());
                    Bitmap bitmap = Bitmap.createBitmap(tv.getDrawingCache());
                    //千万别忘最后一步
                    tv.destroyDrawingCache();
                    BlurKit.getInstance().blur(bitmap, 20);

                }
                helper.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int adapterPosition = helper.getAdapterPosition();
                        try {
                            calculate(adapterPosition, CusConstants.NOW_NEWPRODUCT, bean);
                            openDetail(CusConstants.NOW_NEWPRODUCT, bean, adapterPosition);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
//                                }else{
//                                    Toast.makeText(mcontexct, "即将上线，记得来申请哦！", Toast.LENGTH_SHORT).show();
//                                }

                    }
                });
//                }


                break;
        }
    }

    public void calculate(int position, int type, NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX bean) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                postUvData(bean, position, type);
            }
        }.start();
    }

    public void openDetail(int type, NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX data, int position) {
        int index = data.getSortIndex();
        if (index > 0) {
            Intent intent = new Intent(mcontexct, ProductDetailActivity.class);
            intent.putExtra(CusConstants.START_TYPE, type);
            intent.putExtra(CusConstants.PRODUCT_INFO, (Serializable) data);
            intent.putExtra(CusConstants.PRODUCT_POSITION, position);
            mcontexct.startActivity(intent);
        } else {
            Toast.makeText(mContext, "即将上线，敬请期待", Toast.LENGTH_LONG).show();
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
            productShowId = bean1.getId();
            mposition = bean1.getPosition().getKey();
            sortIndex = bean1.getSortIndex();
            id = bean1.getBorrowProduct().getId();
            OkHttpUtils
                    .post()
                    .url(API.UV)
                    .addParams("productShowId", productShowId + "")
                    .addParams("position", mposition)
                    .addParams("sortIndex", sortIndex + "")
                    .addParams("iemi", AppInfoUtil.getIMEI(mcontexct))
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

}
