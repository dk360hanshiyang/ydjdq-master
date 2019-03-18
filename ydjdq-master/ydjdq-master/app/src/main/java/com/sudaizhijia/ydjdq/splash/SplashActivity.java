package com.sudaizhijia.ydjdq.splash;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.SplashBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.ActivityUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.utils.StringUtils;
import com.google.gson.Gson;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by WilliamWang on 2018/12/11
 */

public class SplashActivity extends MVPBaseActivity<SplashContract.View, SplashPresenter> implements SplashContract.View {
    private SplashBean bean;
    @BindView(R.id.iv_huodong)
    ImageView ivHuodong;
    @BindView(R.id.tv_jump)
    TextView tvJump;
    @BindView(R.id.iv_logo)
    ImageView ivLogo;
    private Handler handler;
    private long sleepTime = 3000;

    public Runnable runnable = () -> {
        if (CusApplication.isLogin) {
            intentMain();
        } else {
            try {
                if (!TextUtils.isEmpty(bean.getObject().getFOURCE_REDIRECT())) {
                    if (bean.getObject().getFOURCE_REDIRECT().equals("true")) {
                        ActivityUtils.startActivityFroTask(getContext(), LoginActivity.class);
                        finishSelf();
                    } else {
                        intentMain();
                    }
                } else {
                    intentMain();
                }
            } catch (Exception e) {
                intentMain();
            }

        }


    };

    private void intentMain() {
        ActivityUtils.startActivityFroTask(getContext(), MainActivity.class);
        finishSelf();
    }


    @Override
    protected void init() {
        handler = new Handler();
        initStartPageInfo();
        mPresenter.postLogin();
        handler.postDelayed(runnable, sleepTime);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    private void initStartPageInfo() {
        String string = SharedPreUtils.getString(getContext(), CusConstants.SPLASH, "");
        SplashBean splashBean = new Gson().fromJson(string, SplashBean.class);
        if (splashBean != null && splashBean.code == 1) {
            setData(splashBean);
        }
        mPresenter.getStartPage();
    }

    @Override
    protected void onResume() {
        MobclickAgent.onPageStart("闪屏页(启动第一页)");
        super.onResume();

    }

    @Override
    protected void onPause() {
        MobclickAgent.onPageEnd("闪屏页(启动第一页)");
        super.onPause();
    }

    @Override
    public void setData(SplashBean bean) {
        this.bean = bean;
        if (bean != null && bean.getObject() != null && bean.getObject().getProductList().size() > 0) {
            try {

                if (!StringUtils.isEmpty(bean.getObject().getProductList().get(0).getImgUrl())) {
                    Glide.with(SplashActivity.this)
                            .asBitmap()
                            .load(bean.getObject().getProductList().get(0).getImgUrl())
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    //设置宽高
                                    Drawable drawable = new BitmapDrawable(resource);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        ivHuodong.setBackground(drawable);   //设置背景
                                    }

                                }
                            });
                } else if (!StringUtils.isEmpty(bean.getObject().getProductList().get(0).getBorrowProduct().getLogoUrl())) {
                    Glide.with(SplashActivity.this)
                            .asBitmap()
                            .load(bean.getObject().getProductList().get(0).getBorrowProduct().getLogoUrl())
                            .into(new SimpleTarget<Bitmap>() {
                                @Override
                                public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                                    //设置宽高
                                    Drawable drawable = new BitmapDrawable(resource);
                                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                                        ivHuodong.setBackground(drawable);   //设置背景
                                    }

                                }
                            });
////

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void showJump() {
        tvJump.setVisibility(View.VISIBLE);
    }


    @OnClick({R.id.tv_jump, R.id.iv_huodong})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_jump:
                handler.removeCallbacks(runnable);
                if (CusApplication.isLogin) {
                    intentMain();
                } else {
                    try {
                        if (!TextUtils.isEmpty(bean.getObject().getFOURCE_REDIRECT())) {
                            if (bean.getObject().getFOURCE_REDIRECT().equals("true")) {
                                ActivityUtils.startActivityFroTask(getContext(), LoginActivity.class);
                                finishSelf();
                            } else {
                                intentMain();
                            }
                        } else {
                            intentMain();
                        }
                    } catch (Exception e) {
                        intentMain();
                    }

                }

                break;
            case R.id.iv_huodong:
                if (CusApplication.isLogin) {
                    intentProduct();
                    handler.removeCallbacks(runnable);
                } else {
                    try {
                        if (!TextUtils.isEmpty(bean.getObject().getFOURCE_REDIRECT())) {
                            if (bean.getObject().getFOURCE_REDIRECT().equals("true")) {
                                ActivityUtils.startActivityFroTask(getContext(), LoginActivity.class);
                                finishSelf();
                                handler.removeCallbacks(runnable);
                            } else {
                                intentProduct();
                                handler.removeCallbacks(runnable);
                                break;
                            }
                        } else {
                            intentMain();
                            handler.removeCallbacks(runnable);
                        }
                    } catch (Exception e) {
                        intentMain();
                        handler.removeCallbacks(runnable);
                    }

                }

        }
    }

    private void intentProduct() {
        try {
            if (bean != null && bean.getObject() != null && bean.code == 1 && bean.getObject().getProductList().size() > 0) {
                calculate(0, CusConstants.SPLASH_TYPE);
                openDetail(CusConstants.SPLASH_TYPE, bean, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postUvData(bean, position, type);
            }
        }.start();
    }

    public void openDetail(int type, BaseBean data, int position) {
        if (bean == null || bean.getObject() == null) {
            return;
        }
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        intent.putExtra("tag", "arr");
        startActivity(intent);
        finish();
        handler.removeCallbacks(runnable);
    }


}
