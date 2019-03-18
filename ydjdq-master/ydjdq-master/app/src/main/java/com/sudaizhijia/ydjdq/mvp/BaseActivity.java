package com.sudaizhijia.ydjdq.mvp;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.splash.SplashActivity;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.utils.AppManager;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Author: William Wang
 * Date:   On 2018/12/4
 */
public abstract class BaseActivity extends AppCompatActivity implements BaseView {


    private Unbinder bind;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState != null) {
            //异常销毁获取登录状态
            CusApplication.isLogin = savedInstanceState.getBoolean("isLogin");

        }
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        AppManager.getInstance().addActivity(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        setContentView(getLayoutId());
        bind = ButterKnife.bind(this);
        if (this instanceof LoginActivity || this instanceof SplashActivity) {
            //当FitsSystemWindows设置 true 时，会在屏幕最上方不会预留出状态栏高度的 padding
            StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        } else {
            //当FitsSystemWindows设置 true 时，会在屏幕最上方预留出状态栏高度的 padding
            StatusBarUtil.setRootViewFitsSystemWindows(this, true);
            //设置状态栏透明
        }

        StatusBarUtil.setTranslucentStatus(this);
        //一般的手机的状态栏文字和图标都是白色的, 可如果你的应用也是纯白色的, 或导致状态栏文字看不清
        //所以如果你是这种情况,请使用以下代码, 设置状态使用深色文字图标风格, 否则你可以选择性注释掉这个if内容
        if (!StatusBarUtil.setStatusBarDarkTheme(this, true)) {
            //如果不支持设置深色风格 为了兼容总不能让状态栏白白的看不清, 于是设置一个状态栏颜色为半透明,
            //这样半透明+白=灰, 状态栏的文字能看得清
            StatusBarUtil.setStatusBarColor(this, 0x55000000);
        }

        baseInit();
        PushAgent.getInstance(getContext()).onAppStart();

    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void startActivity(Intent intent) {
        super.startActivity(intent);
        startActivityAnimation();
    }

    private void startActivityAnimation() {
        overridePendingTransition(R.anim.base_slide_right_in, R.anim.hold);
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //在每次返回桌面的时候，将用户信息保存起来。防止应用长时间在后台，保存在application中的信息丢失保存登录状态
        outState.putBoolean("isLogin", CusApplication.isLogin);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if (savedInstanceState != null) {
            CusApplication.isLogin = savedInstanceState.getBoolean("isLogin");

        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getInstance().removeActivity(this);
        bind.unbind();
    }

    @Override
    public void finish() {
        super.finish();
        finishActivityAnimation();
    }

    private void finishActivityAnimation() {
        overridePendingTransition(R.anim.hold, R.anim.base_slide_right_out);
    }

    @Override
    public void finishSelf() {
        finish();
    }
}
