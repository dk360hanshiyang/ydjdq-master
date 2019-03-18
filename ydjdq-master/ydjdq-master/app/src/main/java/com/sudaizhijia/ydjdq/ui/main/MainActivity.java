package com.sudaizhijia.ydjdq.ui.main;


import android.Manifest;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.UpdateManager;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.bbs.BBSFragment;
import com.sudaizhijia.ydjdq.ui.home.HomeFragment;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.ui.market.MarketFragment;
import com.sudaizhijia.ydjdq.ui.mine.MineFragment;
import com.sudaizhijia.ydjdq.ui.must.MustFragment;
import com.sudaizhijia.ydjdq.utils.FragmentUtil;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import pub.devrel.easypermissions.EasyPermissions;


/**
 * Created by WilliamWang on 2018/12/5
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View, EasyPermissions.PermissionCallbacks {


    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.ll_market)
    LinearLayout llMarket;
    @BindView(R.id.ll_bbs)
    LinearLayout llBBS;
    @BindView(R.id.ll_must)
    LinearLayout llMust;
    @BindView(R.id.ll_mine)
    LinearLayout llMine;
    @BindView(R.id.iv_home)
    ImageView ivHome;
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.iv_market)
    ImageView ivMarket;
    @BindView(R.id.ll_tab)
    LinearLayout llTab;
    @BindView(R.id.iv_bbs)
    ImageView ivBBS;
    @BindView(R.id.tv_market)
    TextView tvMarket;
    @BindView(R.id.tv_bbs)
    TextView tvBBS;
    @BindView(R.id.iv_must)
    ImageView ivMust;
    @BindView(R.id.tv_must)
    TextView tvMust;
    @BindView(R.id.iv_mine)
    ImageView ivMine;
    @BindView(R.id.tv_mine)
    TextView tvMine;
    private ArrayList<Fragment> fragments;
    private UpdateManager updateManager;
    private HomeFragment homeFragment;
    private MarketFragment marketFragment;
    private MustFragment mustFragment;
    private BBSFragment bbsFragment;
    private MineFragment mineFragment;
    private FragmentUtil mHideFragment;


    @Override
    protected void init() {

        //初始化Fragment
        initFragment();
        //设置默认页面
        setDefaultPage();
        initPermission();
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);


    }

    /* */

    /**
     * 通过设置全屏，设置状态栏透明
     *
     * @param
     *//*
    private void fullScreen(Activity activity) {
        int sysVersion = Build.VERSION.SDK_INT;
        if (sysVersion > Build.VERSION_CODES.JELLY_BEAN_MR2 ) {
            int result = 0;
            int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (resourceId > 0) {
                result = getResources().getDimensionPixelSize(resourceId);
            }
            LinearLayout toptop = (LinearLayout) this.findViewById(R.id.toptop);
            RelativeLayout.LayoutParams para = new RelativeLayout.LayoutParams(this.getWindowManager().getDefaultDisplay().getWidth(), result);
            //设置修改后的布局。
            toptop.setLayoutParams(para);
        }

    }*/
    public void visible() {
        llTab.setVisibility(View.GONE);
    }

    /**
     * 设置默认的页面
     */
    private void setDefaultPage() {
        setEnable(false, tvHome, ivHome);
        setOtherEnable(true, tvMarket, ivMarket, tvMust, ivMust, tvMine, ivMine, tvBBS, ivBBS);
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new HomeFragment()).commit();
    }

    /**
     * 初始化Fragment
     */
    private void initFragment() {
        fragments = new ArrayList<>();
        homeFragment = new HomeFragment();
        marketFragment = new MarketFragment();
        mustFragment = new MustFragment();
        mineFragment = new MineFragment();
        bbsFragment = new BBSFragment();
        fragments.add(homeFragment);
        fragments.add(marketFragment);
        fragments.add(bbsFragment);
        fragments.add(mustFragment);
        fragments.add(mineFragment);

        mHideFragment = new FragmentUtil(MainActivity.this);
        mHideFragment.dataFragment(homeFragment);


    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }


    @Override
    public void onBackPressed() {
        if (fragments.get(index).equals(bbsFragment)) {
            bbsFragment.goback();
        } else {
            // handle by activity
            super.onBackPressed();
        }
    }


    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    /**
     * HomeFragment点击查看更多跳转市场
     */
    public void toMrket() {
        setEnable(false, tvMarket, ivMarket);
        setOtherEnable(true, tvHome, ivHome, tvMust, ivMust, tvMine, ivMine, tvBBS, ivBBS);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl, new MarketFragment()).commit();
    }

    public boolean isLogin() {
        if (!CusApplication.isLogin) {
            startActivity(new Intent(this, LoginActivity.class));
            return false;
        }
        return true;
    }

    public static int index = 0;

    @OnClick({R.id.ll_home, R.id.ll_market, R.id.ll_must, R.id.ll_mine, R.id.ll_bbs})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_bbs:
                index = 2;
                if (isLogin()) {
                    setEnable(false, tvBBS, ivBBS);
                    setOtherEnable(true, tvMarket, ivMarket, tvMust, ivMust, tvMine, ivMine, tvHome, ivHome);
                    getSupportFragmentManager().beginTransaction().replace(R.id.fl, fragments.get(index)).commit();
                }

                break;
            case R.id.ll_home:
                index = 0;
                setEnable(false, tvHome, ivHome);
                setOtherEnable(true, tvMarket, ivMarket, tvMust, ivMust, tvMine, ivMine, tvBBS, ivBBS);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl, fragments.get(index)).commit();
                mHideFragment.dataFragment(fragments.get(index));
                break;
            case R.id.ll_market:
                index = 1;
                setEnable(false, tvMarket, ivMarket);
                setOtherEnable(true, tvHome, ivHome, tvMust, ivMust, tvMine, ivMine, tvBBS, ivBBS);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl, new MarketFragment()).commit();
                mHideFragment.dataFragment(fragments.get(index));
                break;
            case R.id.ll_must:
                index = 3;
                setEnable(false, tvMust, ivMust);
                setOtherEnable(true, tvMarket, ivMarket, tvHome, ivHome, tvMine, ivMine, tvBBS, ivBBS);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl, fragments.get(index)).commit();
                mHideFragment.dataFragment(fragments.get(index));
                mustFragment.reload();
                break;
            case R.id.ll_mine:
                index = 4;
                setEnable(false, tvMine, ivMine);
                setOtherEnable(true, tvMarket, ivMarket, tvMust, ivMust, tvHome, ivHome, tvBBS, ivBBS);
//                getSupportFragmentManager().beginTransaction().replace(R.id.fl, fragments.get(index)).commit();
                mHideFragment.dataFragment(fragments.get(index));
                break;
        }
    }

    /**
     * 设置tab
     *
     * @param b  是否可点击
     * @param tv tab文字
     * @param iv tab图片
     */
    private void setEnable(boolean b, TextView tv, ImageView iv) {
        tv.setEnabled(b);
        iv.setEnabled(b);
    }

    private void setOtherEnable(boolean b, TextView tv1, ImageView iv1, TextView tv2, ImageView iv2, TextView tv3,
                                ImageView iv3, TextView tv4, ImageView iv4) {
        tv1.setEnabled(b);
        tv2.setEnabled(b);
        tv3.setEnabled(b);
        tv4.setEnabled(b);
        iv1.setEnabled(b);
        iv2.setEnabled(b);
        iv3.setEnabled(b);
        iv4.setEnabled(b);

    }

    private static final int REQUEST_PERMISSION = 1;
    private static String[] PERMISSIONS = {
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
//            Manifest.permission.READ_PHONE_STATE,
    };

    private void initPermission() {
//        String[] perms = {Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, PERMISSIONS)) {
            // 已获取权限
            // ...

        } else {
            // 没有权限，现在去获取
            // ...
            EasyPermissions.requestPermissions(this, "您好，我们需要获取部分权限，仅用于应用更新。",
                    REQUEST_PERMISSION, PERMISSIONS);
        }
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {

        Toast.makeText(this, "授权成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
//        if (EasyPermissions.somePermissionPermanentlyDenied(this, perms)) {
//            new AppSettingsDialog.Builder(this).build().show();
//        }
        initPermission();
    }
}
