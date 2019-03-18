package com.sudaizhijia.ydjdq.ui.newproduct;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.newpdu.after.AfterFragment;
import com.sudaizhijia.ydjdq.ui.newpdu.now.NowFragment;
import com.sudaizhijia.ydjdq.ui.newpdu.recently.RecentlyFragment;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by WilliamWang on 2018/12/5
 */

public class NewProductActivity extends MVPBaseActivity<NewProductContract.View, NewProductPresenter> implements NewProductContract.View, ViewPager.OnPageChangeListener {
    @BindView(R.id.rl_npdu)
    FrameLayout fl_root;
    @BindView(R.id.tv_newpdu_total)
    TextView tvNewpduTotal;
    @BindView(R.id.tv_thousand_remain)
    TextView tvThousandRemain;
    @BindView(R.id.tv_hundred_remain)
    TextView tvHundredRemain;
    @BindView(R.id.tv_ten_remain)
    TextView tvTenRemain;
    @BindView(R.id.tv_number_remain)
    TextView tvNumberRemain;
    @BindView(R.id.rl_titlebar)
    RelativeLayout rlTitlebar;
    @BindView(R.id.tv_renctly)
    TextView tvRenctly;
    @BindView(R.id.rl_yesterday)
    RelativeLayout rlYesterday;
    @BindView(R.id.tv_now)
    TextView tvNow;
    @BindView(R.id.rl_now)
    RelativeLayout rlNow;
    @BindView(R.id.tv_after)
    TextView tvAfter;
    @BindView(R.id.rl_tomorrow)
    RelativeLayout rlTomorrow;
    public ArrayList<Fragment> fragments;
    @BindView(R.id.vp_npdu)
    ViewPager vpNpdu;
    private RecentlyFragment recentlyFragment;
    private NowFragment nowFragment;
    private AfterFragment afterFragment;
    private NewProductBean bean;
    private BounceLoadingView loadingView;

    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        if (fragments == null) {
            tvRenctly.setEnabled(false);
            tvNow.setEnabled(false);
            tvAfter.setEnabled(false);
        }
        mPresenter.getDataInfo();
    }

    private void setDefPage() {
        setEnable(false, tvNow);
        setOtherEnable(true, tvRenctly, tvAfter);
//        getSupportFragmentManager().beginTransaction().replace(R.id.rl_npdu, fragments.get(1)).commit();
    }

    private void initFragment() {
        fragments = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putSerializable("homebean", bean);
        recentlyFragment = new RecentlyFragment();
        recentlyFragment.setArguments(bundle);
        nowFragment = new NowFragment();
        nowFragment.setArguments(bundle);
        afterFragment = new AfterFragment();
        afterFragment.setArguments(bundle);
        fragments.add(recentlyFragment);
        fragments.add(nowFragment);
        fragments.add(afterFragment);
        tvRenctly.setEnabled(true);
        tvNow.setEnabled(true);
        tvAfter.setEnabled(true);
        NewProductAdapter newProductAdapter = new NewProductAdapter(getSupportFragmentManager(), fragments);
        vpNpdu.setAdapter(newProductAdapter);
        vpNpdu.setCurrentItem(1);
        vpNpdu.setOnPageChangeListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_newproduct;
    }


    private void setOtherEnable(boolean b, TextView tv, TextView tv1) {
        tv.setEnabled(b);
        tv1.setEnabled(b);
        tv1.setBackgroundColor(getResources().getColor(R.color.white));
        tv.setBackgroundColor(getResources().getColor(R.color.white));
    }

    private void setEnable(boolean b, TextView tv1) {
        tv1.setEnabled(b);
        tv1.setBackgroundResource(R.drawable.shape_npdu_tab);
    }


    @Override
    public void showView(NewProductBean bean) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.activity_newproduct, null);
        fl_root.removeAllViews();
        this.bean = bean;
        if (tvNewpduTotal != null) {
            tvNewpduTotal.setText(bean.getObject().getTotalCount() + "");
        }

        String hundredRemain;
        String ten;
        String leftCount = String.valueOf(bean.getObject().getLeftCount());
        char[] chars = leftCount.toCharArray();
        String thousand;

        String number;
        int length = leftCount.length();
        if (length == 4) {
            thousand = chars[0] + "";
            hundredRemain = chars[1] + "";
            ten = chars[2] + "";
            number = chars[3] + "";
        } else if (length == 3) {
            thousand = "0";
            hundredRemain = leftCount.charAt(0) + "";
            ten = leftCount.charAt(1) + "";
            number = leftCount.charAt(2) + "";
        } else if (length == 2) {
            thousand = "0";
            hundredRemain = "0";
            ten = leftCount.charAt(0) + "";
            number = leftCount.charAt(1) + "";
        } else if (length == 1) {
            thousand = "0";
            hundredRemain = "0";
            ten = "0";
            number = leftCount.charAt(0) + "";
        } else {
            thousand = "0";
            hundredRemain = "0";
            ten = "0";
            number = "0";
        }

        tvThousandRemain.setText(thousand + "");
        tvHundredRemain.setText(hundredRemain + "");
        tvTenRemain.setText(ten + "");
        tvNumberRemain.setText(number + "");
        initFragment();
        setDefPage();
    }

    @Override
    public void showLoading() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_loading, null);
        loadingView = view.findViewById(R.id.loadingView);
        fl_root.removeAllViews();
        fl_root.addView(view);
        startLoadingView();

    }

    private void startLoadingView() {
        loadingView.addBitmap(R.mipmap.v4);
        loadingView.addBitmap(R.mipmap.v5);
        loadingView.addBitmap(R.mipmap.v6);
        loadingView.addBitmap(R.mipmap.v7);
        loadingView.addBitmap(R.mipmap.v8);
        loadingView.addBitmap(R.mipmap.v9);
        loadingView.setShadowColor(Color.LTGRAY);
        loadingView.setDuration(700);
        loadingView.start();
    }

    @Override
    public void showErr() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_errnet, null);

        fl_root.removeAllViews();
        fl_root.addView(view);
        view.findViewById(R.id.tv_net_err_refresh).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.getDataInfo();
            }
        });
    }


    @OnClick({R.id.rl_yesterday, R.id.rl_now, R.id.rl_tomorrow, R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_yesterday:
                if (fragments != null) {
                    setEnable(false, tvRenctly);
                    setOtherEnable(true, tvNow, tvAfter);
                    vpNpdu.setCurrentItem(0);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.rl_npdu, fragments.get(0)).commit();
                }

                break;
            case R.id.rl_now:
                if (fragments != null) {
                    setEnable(false, tvNow);
                    setOtherEnable(true, tvRenctly, tvAfter);
                    vpNpdu.setCurrentItem(1);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.rl_npdu, fragments.get(1)).commit();
                }

                break;
            case R.id.rl_tomorrow:
                if (fragments != null) {
                    setEnable(false, tvAfter);
                    setOtherEnable(true, tvRenctly, tvNow);
                    vpNpdu.setCurrentItem(2);
//                    getSupportFragmentManager().beginTransaction().replace(R.id.rl_npdu, fragments.get(2)).commit();
                }
                break;
            case R.id.rl_back:
                finishSelf();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                setEnable(false, tvRenctly);
                setOtherEnable(true, tvNow, tvAfter);
                break;
            case 1:
                setEnable(false, tvNow);
                setOtherEnable(true, tvRenctly, tvAfter);
                break;
            case 2:
                setEnable(false, tvAfter);
                setOtherEnable(true, tvRenctly, tvNow);
                break;
        }

    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    public class NewProductAdapter extends FragmentPagerAdapter {

        public NewProductAdapter(FragmentManager fm, ArrayList<Fragment> fragmentList) {
            super(fm);
            fragments = fragmentList;
        }

        @Override
        public Fragment getItem(int i) {
            return fragments.get(i);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

    }
}
