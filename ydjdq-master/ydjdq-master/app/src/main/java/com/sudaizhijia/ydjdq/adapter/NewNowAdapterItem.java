package com.sudaizhijia.ydjdq.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.BlurTransformation;
import com.zhy.http.okhttp.OkHttpUtils;

import net.qiujuer.genius.blur.StackBlur;
import net.qiujuer.genius.blur.StackNative;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

/**
 * Author: William Wang
 * Date:   On 2018/12/5
 */
public class NewNowAdapterItem extends RecyclerView.Adapter<NewNowAdapterItem.ViewHolder> {

    private Context mContext;
    private List<NewProductBean.ObjectBean.TodayNewListBean> data;
    int position;

    public NewNowAdapterItem(Context mContext, List<NewProductBean.ObjectBean.TodayNewListBean> data) {
        this.mContext = mContext;
        this.data = data;
    }

    public void openDetail(int type, NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX data, int position) {
        int index = data.getSortIndex();
        if (index > 0) {
            Intent intent = new Intent(mContext, ProductDetailActivity.class);
            intent.putExtra(CusConstants.START_TYPE, type);
            intent.putExtra(CusConstants.PRODUCT_INFO, (Serializable) data);
            intent.putExtra(CusConstants.PRODUCT_POSITION, position);
            mContext.startActivity(intent);
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
                    .addParams("iemi", AppInfoUtil.getIMEI(mContext))
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
        View view = View.inflate(mContext, R.layout.layout_now_product1, null);
//        view.setOnClickListener(this);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX bean = data.get(position).getProductShowList().get(i);
        double maxAmount = bean.getBorrowProduct().getMaxAmount();
        Log.e("bean", bean.toString());
        Log.e("position", "position" + i);
        NumberFormat nf = new DecimalFormat("#.#");
        if (bean.getBorrowProduct().getName().equals("****")) {
            if (!TextUtils.isEmpty(bean.getBorrowProduct().getLogoUrl())) {
                viewHolder.tv_nowpdu_name.setText("");
                Glide.with(mContext).load(R.mipmap.mh).into(viewHolder.imgNowpauName);
                Glide.with(mContext).load(bean.getBorrowProduct().getLogoUrl()).apply(RequestOptions.bitmapTransform(new BlurTransformation(25, 1))).into((CircleImageView) viewHolder.iv_newproduct_icon);
//                viewHolder.tv_nowpdu_name.setDrawingCacheEnabled(true);
//                viewHolder.tv_nowpdu_name.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
//                viewHolder.tv_nowpdu_name.layout(0, 0, viewHolder.tv_nowpdu_name.getMeasuredWidth(), viewHolder.tv_nowpdu_name.getMeasuredHeight());
//                Bitmap bitmap = Bitmap.createBitmap(viewHolder.tv_nowpdu_name.getDrawingCache());
//                //千万别忘最后一步
//                viewHolder.tv_nowpdu_name.destroyDrawingCache();
//                StackBlur.blur(bitmap,25,false);
            }
        } else {
            Glide.with(mContext).load(bean.getBorrowProduct().getLogoUrl()).into((CircleImageView) viewHolder.iv_newproduct_icon);
            viewHolder.tv_nowpdu_name.setText(bean.getBorrowProduct().getName());

        }
        viewHolder.tv_nowpdu_des.setText("最高" + nf.format(maxAmount) + "元");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    calculate(i, CusConstants.NOW_NEWPRODUCT, bean);
                    openDetail(CusConstants.NOW_NEWPRODUCT, bean, i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.get(position).getProductShowList().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_nowpdu_name;
        CircleImageView iv_newproduct_icon;
        TextView tv_nowpdu_des;
        RelativeLayout rl_item_newpdu_root;
        ImageView imgNowpauName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_nowpdu_name = itemView.findViewById(R.id.tv_nowpdu_name);
            iv_newproduct_icon = itemView.findViewById(R.id.iv_newproduct_icon);
            tv_nowpdu_des = itemView.findViewById(R.id.tv_nowpdu_des);
            rl_item_newpdu_root = itemView.findViewById(R.id.rl_root);
            imgNowpauName = itemView.findViewById(R.id.img_nowpdu_name);

        }
    }

    public void setPosition(int position) {
        this.position = position;

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
}
