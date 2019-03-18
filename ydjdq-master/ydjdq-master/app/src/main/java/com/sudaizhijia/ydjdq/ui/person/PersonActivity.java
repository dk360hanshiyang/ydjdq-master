package com.sudaizhijia.ydjdq.ui.person;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.sudaizhijia.ydjdq.IPActivity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.PersonBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class PersonActivity extends MVPBaseActivity<PersonContract.View, PersonPresenter> implements PersonContract.View {

    @BindView(R.id.ivback)
    ImageView ivback;
    @BindView(R.id.rl_login_titlebar)
    RelativeLayout rlLoginTitlebar;
    @BindView(R.id.iv_header_go)
    ImageView ivHeaderGo;
    @BindView(R.id.ic_user_header)
    CircleImageView icUserHeader;
    @BindView(R.id.rl_user_header)
    RelativeLayout rlUserHeader;
    @BindView(R.id.iv_header_go1)
    ImageView ivHeaderGo1;
    @BindView(R.id.tv_user_name)
    TextView tvUserName;
    @BindView(R.id.rl_user_name)
    RelativeLayout rlUserName;
    @BindView(R.id.iv_header_go2)
    ImageView ivHeaderGo2;
    @BindView(R.id.tv_usernum)
    TextView tvUsernum;
    @BindView(R.id.rl_user_num)
    RelativeLayout rlUserNum;
    @BindView(R.id.tv_loginout)
    TextView tvLoginout;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;

    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        mPresenter.getData();
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_person;
    }

    @Override
    public void setData(PersonBean bean) {
        if (bean != null && bean.getObject() != null && !TextUtils.isEmpty(bean.getObject().getUseName())) {
            tvUserName.setText(bean.getObject().getUseName());
            tvUsernum.setText(bean.getObject().getMobile());
            Glide.with(getContext()).load(bean.getObject().getIconUrl()).into(icUserHeader);
        }

    }

    public void onResume() {
        MobclickAgent.onPageStart("个人中心"); //手动统计页面("SplashScreen"为页面名称，可自定义)

        super.onResume();
    }

    public void onPause() {
        MobclickAgent.onPageEnd("个人中心"); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。

        super.onPause();
    }

    @OnClick({R.id.tv_loginout, R.id.rl_back})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_loginout:
                mPresenter.loginOut();
                CusApplication.finishJpush(getContext());
                break;
            case R.id.rl_back:
                finish();
                break;
        }

    }


}
