package com.sudaizhijia.ydjdq.ui.home;


import android.Manifest;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.facebook.rebound.ui.Util;
import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.adapter.HomeAdapter;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.ChangeBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.bean.TimeBean;
import com.sudaizhijia.ydjdq.bean.UpDateBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.newproduct.NewProductActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.CountDownUtil;
import com.sudaizhijia.ydjdq.utils.FloatingWindowAnimator;
import com.sudaizhijia.ydjdq.utils.GlideImageLoader;
import com.sudaizhijia.ydjdq.utils.LogUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;
import com.sudaizhijia.ydjdq.wiget.CodeDialogView;
import com.sudaizhijia.ydjdq.wiget.MyDialog;
import com.sunfusheng.marqueeview.MarqueeView;
import com.umeng.analytics.MobclickAgent;
import com.uuch.adlibrary.AdConstant;
import com.uuch.adlibrary.AdManager;
import com.uuch.adlibrary.bean.AdInfo;
import com.uuch.adlibrary.transformer.DepthPageTransformer;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import cn.bingoogolapple.refreshlayout.BGAMeiTuanRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class HomeFragment extends MVPBaseFragment<HomeContract.View, HomePresenter> implements HomeContract.View,
        BGARefreshLayout.BGARefreshLayoutDelegate,
        View.OnClickListener,
        BaseQuickAdapter.OnItemChildClickListener, MarqueeView.OnItemClickListener {


    @BindView(R.id.scrollview)
    RelativeLayout scrollview;
    private ImageView ivNewArrival;
    private TextView tvHour;
    private TextView tvMinute;
    private TextView tvSecond;
    private LinearLayout titleBar;
    private RelativeLayout rlGoodnews;
    private LinearLayout llOperationOne;
    private LinearLayout llOperationTwo;
    private LinearLayout llOperationThree;
    private LinearLayout llOperationFour;
    private LinearLayout llOperation;
    private TextView tvFourLoanOne;
    private TextView tvChange;
    private RelativeLayout llChangeLocation;
    private LinearLayout llChangeAppOne;
    private LinearLayout llChangeAppTwo;
    private LinearLayout llChangeAppThree;
    private LinearLayout llChangeAppFour;
    private LinearLayout llChangeApp;
    private Banner banner;
    private HomeAdapter homeAdapter;
    private TextView tv_operation_four, tv_operation_three, tv_operation_two, tv_operation_one;
    private ImageView iv_operation_four, iv_operation_three, iv_operation_two, iv_operation_one;
    private TextView tv_change_app_four, tv_change_app_three, tv_change_app_two, tv_change_app_one;
    private ImageView iv_change_app_four, iv_change_app_three, iv_change_app_two, iv_change_app_one, iv_go_anim;
    private RelativeLayout footView;
    private MarqueeView tv_goodnews;
    private List<HomeBean.ObjectBean.ListBean> listData;
    private HomeBean mHomeBean;
    private TextView newCome;
    private MyCount myCount;
    private RecyclerView recycler;
    private BounceLoadingView loadingView;
    private BGARefreshLayout rlModulenameRefresh;
    private MyDialog adDialog;
    private int times;
    private List<View> views;
    private RelativeLayout llFloatingWindow;
    private ImageView imgCloseFloating;
    private ImageView imgFloating;
    private List<View> viewList = new ArrayList<>();
    private LinearLayout linearLayoutIndicator;
    private View view1;
    private HomeBean.ObjectBean object;


    @Override
    protected void init() {
        mPresenter.getIndexInfo(false);
    }

    /**
     * 初始化RefreshLayout
     */
    @Override
    public void initRefreshLayout() {

        initRefresh(rlModulenameRefresh, this);
    }


    /**
     * 初始化recyclerView
     */
    @Override
    public void initRecycler() {

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(linearLayoutManager);
        homeAdapter = new HomeAdapter(R.layout.layout_item_homelist);
        View headerView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_header, null);
        View footView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_foot, null);
        initHeaerView(headerView);
        initFootView(footView);
        homeAdapter.addHeaderView(headerView);
        homeAdapter.addFooterView(footView);
        homeAdapter.setOnItemChildClickListener(this);
        recycler.setAdapter(homeAdapter);
    }

    private void initllFloatingWindow(View view) {
        llFloatingWindow = view.findViewById(R.id.ll_floating_window);
        imgFloating = view.findViewById(R.id.img_floating);
        imgCloseFloating = view.findViewById(R.id.iv_close_floating_window);
        imgCloseFloating.setOnClickListener(this);
        llFloatingWindow.setOnClickListener(this);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator animator = FloatingWindowAnimator.tada(llFloatingWindow);
                animator.setRepeatCount(ValueAnimator.INFINITE);
                animator.start();

//                ObjectAnimator nopeAnimator = FloatingWindowAnimator.nope(llFloatingWindow);
//                nopeAnimator.setRepeatCount(ValueAnimator.INFINITE);
//                nopeAnimator.start();
            }
        }, 300);

    }

    /**
     * 请求主页数据
     */
    @Override
    public void onStart() {
        super.onStart();
//        mPresenter.getIndexInfo(false);

    }


    /**
     * 刷新错误，显示net页面
     */
    @Override
    public void stopRefresh() {
        stopRefresh(rlModulenameRefresh, recycler);
    }

    @Override
    public void error500() {
        times = 1;
        mPresenter.getChangeInfo(times);
    }


    /**
     * 添加加载错误页面
     */
    @Override
    public void addNetErrPage() {
        addErrPageView(scrollview, new ErrNetListener() {
            @Override
            public void onReLoad() {
                mPresenter.getIndexInfo(false);
            }
        });
    }

    /**
     * 添加等待页面
     * 如果有缓存，先加载缓存，如果没有，则显示等待页
     */
    @Override
    public void addLoadingPage() {
        String cache = SharedPreUtils.getString(getContext(), CusConstants.HOMEDATA, "");
        if (!TextUtils.isEmpty(cache)) {
            addContentPage();
            HomeBean homeBean = new Gson().fromJson(cache, HomeBean.class);
            if (homeBean.code == 1) {
                setAllData(homeBean, false);
            }
        } else {
            View lodingView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_loading, null);
            scrollview.removeAllViews();
            scrollview.addView(lodingView);
            loadingView = lodingView.findViewById(R.id.loadingView);
            startLoadingView();
        }

    }

    @Override
    public Context getContext() {
        return getActivity();
    }

    /**
     * 添加内容页
     */
    @Override
    public void addContentPage() {
        View recyclerView = LayoutInflater.from(getContext()).inflate(R.layout.layout_home_recycler, null);
        scrollview.removeAllViews();
        scrollview.addView(recyclerView);
        RelativeLayout rlFloatingWindow = recyclerView.findViewById(R.id.ll_floating_window);
        rlFloatingWindow.setVisibility(View.VISIBLE);
        recycler = recyclerView.findViewById(R.id.recycler);
        rlModulenameRefresh = recyclerView.findViewById(R.id.rl_modulename_refresh);
        initRefreshLayout();
        initRecycler();
        initllFloatingWindow(recyclerView);
        titleBar.setOnClickListener(this);
    }

    private void initFloating() {

    }

    ViewGroup container;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.container = container;
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    /**
     * 等待页动画
     */
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

    /**
     * 初始化recyclerview的脚部View
     *
     * @param
     */
    private void initFootView(View mFootView) {
        footView = mFootView.findViewById(R.id.rl_foot_root);
        footView.setOnClickListener(this);
    }

    List<HomeBean.ObjectBean.OverlaysBean> overlays;

    private int viewPagePosition;

    private int positionOver = 0;

    /**
     * 广告弹窗
     *
     * @param overlays
     */
    private void showADDialog(List<HomeBean.ObjectBean.OverlaysBean> overlays) {
        this.overlays = overlays;
//        WindowManager wm = (WindowManager) getActivity()
//                .getSystemService(Context.WINDOW_SERVICE);
//        int width = wm.getDefaultDisplay().getWidth();
//        int height = wm.getDefaultDisplay().getHeight();
        //获取SingleTouchView所在父布局的中心点
        View view = getLayoutInflater().inflate(R.layout.anim_dialog_layout, null, false);

        BottomLineLayout bottomLineLayout = view.findViewById(R.id.linearLayout);
        if (overlays.size() > 1) {
            bottomLineLayout.initViews(overlays.size(), 15, 13);
        }
        Log.e("overLay", overlays.size() + "");
        ViewPager vp_dialog = view.findViewById(R.id.vp_dialog);
        ImageView close = view.findViewById(R.id.iv_close);
//        CodeDialogView adDialog = new CodeDialogView(getActivity(), 0, 0, view, R.style.DialogTheme);
        adDialog = new MyDialog(getActivity(), ViewGroup.LayoutParams.MATCH_PARENT - 1, ViewGroup.LayoutParams.MATCH_PARENT, view, R.style.DialogTheme);
        adDialog.setCanceledOnTouchOutside(false);
        adDialog.setCancelable(true);
        views = new ArrayList<>();
        for (int i = 0; i < overlays.size(); i++) {
            positionOver = i;
        }
        ViewPagerDialogAdapter adapter = new ViewPagerDialogAdapter();
        vp_dialog.setAdapter(adapter);
        vp_dialog.setOffscreenPageLimit(views.size());
        vp_dialog.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int position) {
                viewPagePosition = position;
                if (overlays.size() > 1) {
                    if (bottomLineLayout != null) {
                        bottomLineLayout.changePosition(position);
                    }

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adDialog.dismiss();
            }
        });
        adDialog.show();
    }

    /**
     * 初始化headerview
     */
    private void initHeaerView(View view) {
        ivNewArrival = view.findViewById(R.id.iv_new_arrival);
        tv_goodnews = view.findViewById(R.id.tv_goodnew);
        tvHour = view.findViewById(R.id.tv_hour);
        tvMinute = view.findViewById(R.id.tv_minute);
        tvSecond = view.findViewById(R.id.tv_second);
        titleBar = view.findViewById(R.id.title_bar);
        rlGoodnews = view.findViewById(R.id.rl_goodnews);
        llOperationOne = view.findViewById(R.id.ll_operation_one);
        llOperationTwo = view.findViewById(R.id.ll_operation_two);
        llOperationThree = view.findViewById(R.id.ll_operation_three);
        llOperationFour = view.findViewById(R.id.ll_operation_four);
        newCome = view.findViewById(R.id.tv_newcome);
        llOperationOne.setOnClickListener(this);
        llOperationTwo.setOnClickListener(this);
        llOperationThree.setOnClickListener(this);
        rlGoodnews.setOnClickListener(this);
        llOperationFour.setOnClickListener(this);
        llOperation = view.findViewById(R.id.ll_operation);
        tvFourLoanOne = view.findViewById(R.id.tv_four_loan_one);
        tvChange = view.findViewById(R.id.tv_change);
        tvChange.setOnClickListener(this);
        llChangeLocation = view.findViewById(R.id.ll_change_location);
        llChangeAppOne = view.findViewById(R.id.ll_change_app_one);
        llChangeAppTwo = view.findViewById(R.id.ll_change_app_two);
        llChangeAppThree = view.findViewById(R.id.ll_change_app_three);
        llChangeAppFour = view.findViewById(R.id.ll_change_app_four);
        llChangeApp = view.findViewById(R.id.ll_change_app);
        llChangeAppOne.setOnClickListener(this);
        llChangeAppTwo.setOnClickListener(this);
        llChangeAppThree.setOnClickListener(this);
        llChangeAppFour.setOnClickListener(this);
        banner = view.findViewById(R.id.banner);
        tv_operation_four = view.findViewById(R.id.tv_operation_four);
        tv_operation_three = view.findViewById(R.id.tv_operation_three);
        tv_operation_two = view.findViewById(R.id.tv_operation_two);
        tv_operation_one = view.findViewById(R.id.tv_operation_one);
        iv_operation_four = view.findViewById(R.id.iv_operation_four);
        iv_operation_three = view.findViewById(R.id.iv_operation_three);
        iv_operation_two = view.findViewById(R.id.iv_operation_two);
        iv_operation_one = view.findViewById(R.id.iv_operation_one);
        tv_change_app_four = view.findViewById(R.id.tv_change_app_four);
        tv_change_app_one = view.findViewById(R.id.tv_change_app_one);
        tv_change_app_two = view.findViewById(R.id.tv_change_app_two);
        tv_change_app_three = view.findViewById(R.id.tv_change_app_three);
        iv_change_app_one = view.findViewById(R.id.iv_change_app_one);
        iv_change_app_two = view.findViewById(R.id.iv_change_app_two);
        iv_change_app_three = view.findViewById(R.id.iv_change_app_three);
        iv_change_app_four = view.findViewById(R.id.iv_change_app_four);
        iv_go_anim = view.findViewById(R.id.iv_go_anim);
        iv_go_anim.setImageResource(R.drawable.anim_go);
        AnimationDrawable animationDrawable = (AnimationDrawable) iv_go_anim.getDrawable();
        animationDrawable.start();
        String str = "经统计，同时申请以下<font color='#0084FF'>四家</font>下款率高达<font color='#FF0000'>95%</font>";
//        tvEmail.setText(Html.fromHtml(str));
        tvFourLoanOne.setText(Html.fromHtml(str));
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("首页");
        initPopUp();
        //备注

    }

    private void initPopUp() {
        Log.e("index", index + "()");
        if (mHomeBean != null) {
            if (mHomeBean.getObject() != null) {
                if (mHomeBean.getObject().getPopUp() != null && mHomeBean.getObject().getPopUp().size() > 1) {
                    if (index == mHomeBean.getObject().getPopUp().size() - 1) {
                        index = 0;
                        if (TextUtils.isEmpty(mHomeBean.getObject().getPopUp().get(index).getImgUrl())) {
                            Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getPupUpBorrowProductBean().getLogoUrl()).into(imgFloating);
                        } else {
                            Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getImgUrl()).into(imgFloating);
                        }

                    } else {
                        index++;
                        if (TextUtils.isEmpty(mHomeBean.getObject().getPopUp().get(index).getImgUrl())) {
                            Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getPupUpBorrowProductBean().getLogoUrl()).into(imgFloating);
                        } else {
                            Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getImgUrl()).into(imgFloating);
                        }
                    }
                } else {
                    if (TextUtils.isEmpty(mHomeBean.getObject().getPopUp().get(0).getImgUrl())) {
                        Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(0).getPupUpBorrowProductBean().getLogoUrl()).into(imgFloating);
                    } else {
                        Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(0).getImgUrl()).into(imgFloating);
                    }
                }
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("首页");

    }

    /**
     * 设置数据
     *
     * @param homeBean
     */
    @Override
    public void setData(HomeBean homeBean) {
        if (homeBean != null) {
            //设置数据
            setAllData(homeBean, false);
        }
        try {
            if (homeBean != null) {
                //第一次进入APP，展示弹窗
                if (CusApplication.Home_isFirst) {
                    if (homeBean.getObject().getOverlays() != null && homeBean.getObject().getOverlays().size() > 0) {
                        showADDialog(homeBean.getObject().getOverlays());
                    }

                    CusApplication.Home_isFirst = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void setChangeOne(ChangeBean bean) {
        mHomeBean.getObject().setMiddle(bean.getObject().getMiddleShowList());
        List<HomeBean.ObjectBean.MiddleBean> middle = mHomeBean.getObject().getMiddle();
        if (middle.size() > 0) {
            setMiddle(middle);
        } else {
            Toast.makeText(getActivity(), "暂时没有更多", Toast.LENGTH_SHORT).show();
        }

    }


    public boolean isLogin() {
        if (!CusApplication.isLogin) {
            startActivity(new Intent(getActivity(), LoginActivity.class));
            return false;
        }
        return true;
    }

    @Override
    public void reFresh(HomeBean homeBean) {
        setAllData(homeBean, true);
        rlModulenameRefresh.endRefreshing();

    }

    @Override
    public void setAllData(HomeBean homeBean, boolean isFresh) {


        try {
            times = 0;
            this.mHomeBean = homeBean;
            if (homeBean != null) {
                footView.setVisibility(View.VISIBLE);
            }
            object = homeBean.getObject();
            String comeNum = object.getNewComeNum() + "";
            if (comeNum == "0") {
//                newCome.setVisibility(View.INVISIBLE);
                newCome.setText("共" + comeNum + "家");
            } else {
                newCome.setText("共" + comeNum + "家");
            }
//
            List<HomeBean.ObjectBean.XinKouziBean> xinkouzi = object.getXinKouzi();
            for (int i = 0; i < xinkouzi.size(); i++) {
                HomeBean.ObjectBean.XinKouziBean xinKouZi = xinkouzi.get(i);
                CusApplication.list.add(xinKouZi.getBorrowProduct().getLogoUrl());
            }

            List<HomeBean.ObjectBean.BannerBean> banner = object.getBanner();
            setBanner(banner);
            listData = object.getList();
            setList(listData);
            List<HomeBean.ObjectBean.PaymentReportBean> paymentReport = object.getPaymentReport();
            setePayMentReport(paymentReport);
            List<HomeBean.ObjectBean.MiddleBean> middle = object.getMiddle();
            setMiddle(middle);
            List<HomeBean.ObjectBean.OverlaysBean> overlays = object.getOverlays();
            setOverLays(overlays);
            List<HomeBean.ObjectBean.TopBean> top = object.getTop();
            setTop(top);
            if (sign) {
                setpopUp();
            }
            if (!isFresh) {
                String countDown = object.getCountDown() + "";
                initCoutDown(countDown);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private boolean sign = true;

    private void setpopUp() {
        if (mHomeBean.getObject().getPopUp().size() > 0) {
            imgCloseFloating.setVisibility(View.VISIBLE);
            llFloatingWindow.setVisibility(View.VISIBLE);
//            Log.e("popSize", mHomeBean.getObject().getPopUp().size() + "url" + mHomeBean.getObject().getPopUp().get(index).getImgUrl());
            if (TextUtils.isEmpty(mHomeBean.getObject().getPopUp().get(index).getImgUrl())) {
                Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getPupUpBorrowProductBean().getLogoUrl()).into(imgFloating);
            } else {
                Glide.with(getContext()).load(mHomeBean.getObject().getPopUp().get(index).getImgUrl()).into(imgFloating);
            }
        } else {
            llFloatingWindow.setVisibility(View.GONE);
            imgCloseFloating.setVisibility(View.GONE);
        }
    }

    public boolean isOne(String time) {
        if (time.length() == 1) {
            return true;
        }
        return false;
    }

    public class MyCount extends CountDownTimer {


        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            tvHour.setText("00");
            tvMinute.setText("00");
            tvSecond.setText("00");

        }

        @Override
        public void onTick(long millisUntilFinished) {
            long l = millisUntilFinished / 1000;
            TimeBean timeBean = CountDownUtil.formatTimeBySecond((int) l);
            tvHour.setText(isOne(String.valueOf(timeBean.Hour)) ? "0" + timeBean.Hour : timeBean.Hour + "");
            tvMinute.setText(isOne(String.valueOf(timeBean.minute)) ? "0" + timeBean.minute : timeBean.minute + "");
            tvSecond.setText(isOne(String.valueOf(timeBean.second)) ? "0" + timeBean.second : timeBean.second + "");
        }

    }

    private int mTime;

    private void initCoutDown(String time) {
        this.mTime = Integer.valueOf(time);
        TimeBean timeBean = CountDownUtil.formatTimeBySecond(mTime);
        tvHour.setText(isOne(String.valueOf(timeBean.Hour)) ? "0" + timeBean.Hour : timeBean.Hour + "");
        tvMinute.setText(isOne(String.valueOf(timeBean.minute)) ? "0" + timeBean.minute : timeBean.minute + "");
        tvSecond.setText(isOne(String.valueOf(timeBean.second)) ? "0" + timeBean.second : timeBean.second + "");
        if (myCount != null) {
            myCount.cancel();
            myCount = null;
        }
        myCount = new MyCount(mTime * 1000, 1000);
        myCount.start();
    }

    @Override
    public void onStop() {
        super.onStop();
//        timer.cancel();


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (myCount != null) {
            myCount.onFinish();
            myCount.cancel();
        }
    }

    /**
     * 设置下款捷报
     *
     * @param paymentReport
     */
    private void setePayMentReport(List<HomeBean.ObjectBean.PaymentReportBean> paymentReport) {
        ArrayList<Spanned> reportList = new ArrayList();
        if (paymentReport != null) {

            for (HomeBean.ObjectBean.PaymentReportBean paymentReportBean : paymentReport) {
                reportList.add(Html.fromHtml(paymentReportBean.getRemark()));
            }
            tv_goodnews.startWithList(reportList);
            tv_goodnews.setOnItemClickListener(this);
        }
    }


    /**
     * 设置头部
     *
     * @param top
     */
    private void setTop(List<HomeBean.ObjectBean.TopBean> top) {
        if (top == null || top.size() <= 0) {
            return;
        }
        if (top.get(0).getBorrowProduct().getName() == null) {
            return;
        }
        try {
            tv_operation_one.setText(top.get(0).getTitle());
            tv_operation_two.setText(top.get(1).getTitle());
            tv_operation_three.setText(top.get(2).getTitle());
            tv_operation_four.setText(top.get(3).getTitle());
            Glide.with(getContext()).load(top.get(0).getImgUrl()).into(iv_operation_one);
            Glide.with(getContext()).load(top.get(1).getImgUrl()).into(iv_operation_two);
//            if (mHomeBean.getObject().getTop().get(0).getImgUrl() != null) {
//                Glide.with(getContext()).load(mHomeBean.getObject().getTop().get(0).getImgUrl()).into(iv_operation_three);
//            } else {
            Glide.with(getContext()).load(top.get(2).getImgUrl()).into(iv_operation_three);
//            }

            Glide.with(getContext()).load(top.get(3).getImgUrl()).into(iv_operation_four);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 設置浮窗
     * TODO  浮窗后期
     *
     * @param overlays
     */
    private void setOverLays(List<HomeBean.ObjectBean.OverlaysBean> overlays) {
//        adInfos = new ArrayList<>();
//        for (HomeBean.ObjectBean.OverlaysBean overlay : overlays) {
//            AdInfo adInfo = new AdInfo();
//            adInfo.setActivityImg(overlay.getBorrowProduct().getlogoUrl());
//            adInfos.add(adInfo);
//        }
//        initAD();
    }

    /**
     * 设置四家必下栏
     *
     * @param middle
     */
    private void setMiddle(List<HomeBean.ObjectBean.MiddleBean> middle) {
        if (middle == null || middle.size() <= 0) {
//            Toast.makeText(getContext(), "网络出错哦", Toast.LENGTH_SHORT).show();
            return;
        }
        try {
            tv_change_app_one.setText(middle.get(0).getBorrowProduct().getName());
            tv_change_app_two.setText(middle.get(1).getBorrowProduct().getName());
            tv_change_app_three.setText(middle.get(2).getBorrowProduct().getName());
            tv_change_app_four.setText(middle.get(3).getBorrowProduct().getName());
            Glide.with(getContext()).load(middle.get(0).getBorrowProduct().getLogoUrl())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_change_app_one);
            Glide.with(getContext()).load(middle.get(1).getBorrowProduct().getLogoUrl())
                    .apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_change_app_two);
            Glide.with(getContext()).load(middle.get(2).getBorrowProduct().getLogoUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_change_app_three);
            Glide.with(getContext()).load(middle.get(3).getBorrowProduct().getLogoUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(iv_change_app_four);
            Log.e("logourl", middle.get(0).getBorrowProduct().getLogoUrl() + "  " + middle.get(2).getBorrowProduct().getLogoUrl());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 设置recyclerView数据
     *
     * @param list
     */
    private void setList(List<HomeBean.ObjectBean.ListBean> list) {
        homeAdapter.setNewData(list);
    }

    /**
     * 跳转甲方详情页
     *
     * @param type
     * @param data
     * @param position
     */
    public void openDetail(int type, BaseBean data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);
    }

    /**
     * 设置banner
     *
     * @param
     */
    private void setBanner(List<HomeBean.ObjectBean.BannerBean> mbanner) {
        ArrayList<String> images = new ArrayList<>();
        try {
            for (HomeBean.ObjectBean.BannerBean bannerBean : mbanner) {
                images.add(bannerBean.getImgUrl());
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), "服务器错误，稍后重试", Toast.LENGTH_SHORT).show();
        }
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置图片集合
        banner.setImages(images);
        //        //设置轮播时间
        banner.setDelayTime(4000);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                if (isLogin()) {
                    if (mHomeBean != null && mHomeBean.getObject() != null && mHomeBean.getObject().getBanner().size() > 0) {
                        HashMap<String, String> keyMap = new HashMap<>();
                        keyMap.put("product", mHomeBean.getObject().getBanner().get(position).getBorrowProduct().getName());
                        keyMap.put("positionValue", mHomeBean.getObject().getBanner().get(position).getPosition().getValue());
                        MobclickAgent.onEvent(getContext(), "banner", keyMap);

                        calculate(position, CusConstants.BANNER);
                        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
                        intent.putExtra(CusConstants.START_TYPE, CusConstants.BANNER);
                        intent.putExtra(CusConstants.PRODUCT_INFO, mHomeBean);
                        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
                        startActivity(intent);
                    }
                }

            }
        });
////设置banner样式
//        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
//        //设置图片加载器
//        banner.setImageLoader(new GlideImageLoader());
//        //设置图片集合
//        banner.setImages(images);
//        //设置banner动画效果
//        banner.setBannerAnimation(Transformer.DepthPage);
//        //设置标题集合（当banner样式有显示title时）
////        banner.setBannerTitles(titles);
//        //设置自动轮播，默认为true
//        banner.isAutoPlay(true);
//        //设置轮播时间
//        banner.setDelayTime(1500);
//        //设置指示器位置（当banner模式中有指示器时）
//        banner.setIndicatorGravity(BannerConfig.CENTER);
//        //banner设置方法全部调用完毕时最后调用
//        banner.start();
    }

    /**
     * 下拉刷新
     *
     * @param refreshLayout
     */
    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
//        new Handler().postDelayed(new Runnable() {
//            @Override
//            public void run() {
        mPresenter.getIndexInfo(true);
//            }
//        }, 1000);

    }

    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }


    private int index = 0;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_goodnews:
                if (isLogin()) {
                    if (mHomeBean.getObject() != null && mHomeBean.getObject().getPaymentReport().size() > 0) {
                        onItemClick(tv_goodnews.getPosition(), null);
                    } else {
                        Toast.makeText(getContext(), "暂无下款捷报！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.title_bar:
                if (isLogin()) {
                    MobclickAgent.onEvent(getContext(), "titlebar");

                    startActivity(new Intent(getActivity(), NewProductActivity.class));
                }
                break;
            case R.id.ll_operation_one:
                if (isLogin()) {
                    if (!TextUtils.isEmpty(mHomeBean.getObject().getTop().get(0).getShowType())) {
                        Log.e("zhuanti", mHomeBean.getObject().getTop().get(0).getShowType());
                        if (mHomeBean.getObject().getTop().get(0).getShowType().equals(CusConstants.HUODONG_TYPE) || mHomeBean.getObject().getTop().get(0).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                            calculate(0, CusConstants.ZHUANTI);
                            openDetail(CusConstants.ZHUANTI, mHomeBean, 0);
                        } else {
                            if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 0) {
                                calculate(0, CusConstants.TOP);
                                openDetail(CusConstants.TOP, mHomeBean, 0);
                            } else {
                                Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 0) {
                            calculate(0, CusConstants.TOP);
                            openDetail(CusConstants.TOP, mHomeBean, 0);
                        } else {
                            Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
            case R.id.ll_operation_two:
                if (isLogin()) {
                    if (!TextUtils.isEmpty(mHomeBean.getObject().getTop().get(1).getShowType())) {
                        if (mHomeBean.getObject().getTop().get(1).getShowType().equals(CusConstants.HUODONG_TYPE) || mHomeBean.getObject().getTop().get(1).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                            calculate(1, CusConstants.ZHUANTI);
                            openDetail(CusConstants.ZHUANTI, mHomeBean, 1);
                        } else {
                            if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 1) {
                                calculate(1, CusConstants.TOP);
                                openDetail(CusConstants.TOP, mHomeBean, 1);
                            } else {
                                Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 1) {
                            calculate(1, CusConstants.TOP);
                            openDetail(CusConstants.TOP, mHomeBean, 1);
                        } else {
                            Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
                break;
            case R.id.ll_operation_three:
                if (isLogin()) {
                    if (!TextUtils.isEmpty(mHomeBean.getObject().getTop().get(2).getShowType())) {
                        if (mHomeBean.getObject().getTop().get(2).getShowType().equals(CusConstants.HUODONG_TYPE) || mHomeBean.getObject().getTop().get(2).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                            calculate(2, CusConstants.ZHUANTI);
                            openDetail(CusConstants.ZHUANTI, mHomeBean, 2);
                        } else {
                            if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 2) {
                                calculate(2, CusConstants.TOP);
                                openDetail(CusConstants.TOP, mHomeBean, 2);
                            } else {
                                Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 2) {
                            calculate(2, CusConstants.TOP);
                            openDetail(CusConstants.TOP, mHomeBean, 2);
                        } else {
                            Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
                break;
            case R.id.ll_operation_four:

                if (isLogin()) {
                    if (!TextUtils.isEmpty(mHomeBean.getObject().getTop().get(3).getShowType())) {
                        if (mHomeBean.getObject().getTop().get(3).getShowType().equals(CusConstants.HUODONG_TYPE) || mHomeBean.getObject().getTop().get(3).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                            calculate(3, CusConstants.ZHUANTI);
                            openDetail(CusConstants.ZHUANTI, mHomeBean, 3);
                        } else {
                            //产品
                            if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 3) {
                                calculate(3, CusConstants.TOP);
                                openDetail(CusConstants.TOP, mHomeBean, 3);
                            } else {
                                Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } else {
                        //产品
                        if (mHomeBean.getObject() != null && mHomeBean.getObject().getTop().size() > 3) {
                            calculate(3, CusConstants.TOP);
                            openDetail(CusConstants.TOP, mHomeBean, 3);
                        } else {
                            Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                break;
            case R.id.ll_change_app_one:
                if (isLogin()) {
                    if (mHomeBean.getObject() != null && mHomeBean.getObject().getMiddle().size() > 0) {
                        calculate(0, CusConstants.MIDDLE);
                        openDetail(CusConstants.MIDDLE, mHomeBean, 0);
                    } else {
                        Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.ll_change_app_two:
                if (isLogin()) {
                    if (mHomeBean.getObject() != null && mHomeBean.getObject().getMiddle().size() > 1) {
                        calculate(1, CusConstants.MIDDLE);
                        openDetail(CusConstants.MIDDLE, mHomeBean, 1);
                    } else {
                        Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.ll_change_app_three:
                if (isLogin()) {

                    if (mHomeBean.getObject() != null && mHomeBean.getObject().getMiddle().size() > 2) {
                        calculate(2, CusConstants.MIDDLE);
                        openDetail(CusConstants.MIDDLE, mHomeBean, 2);
                    } else {
                        Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
            case R.id.ll_change_app_four:
                if (isLogin()) {
                    if (mHomeBean.getObject() != null && mHomeBean.getObject().getMiddle().size() > 3) {
                        calculate(3, CusConstants.MIDDLE);
                        openDetail(CusConstants.MIDDLE, mHomeBean, 3);
                    } else {
                        Toast.makeText(getContext(), "暂无该口子信息！", Toast.LENGTH_SHORT).show();
                    }

                }
                break;
            case R.id.tv_change:
                if (isLogin()) {
                    times += 1;
                    mPresenter.getChangeInfo(times);
                }
                break;
            case R.id.rl_foot_root:
                if (isLogin()) {
                    ((MainActivity) getActivity()).toMrket();
                }
                break;
            //浮窗
            case R.id.ll_floating_window:
                if (isLogin()) {
//                    if (index == mHomeBean.getObject().getPopUp().size() - 1) {
                    intentProduct();
//                    } else {
//                        intentProduct();
//
//                    }

                    Log.e("index", index + "()");

                }
                break;
            case R.id.iv_close_floating_window:
                imgCloseFloating.setVisibility(View.GONE);
                llFloatingWindow.setVisibility(View.GONE);
                sign = false;


                break;
        }
    }

    private void intentProduct() {
        calculate(index, CusConstants.POPUP);
        openDetail(CusConstants.POPUP, mHomeBean, index);
    }


    /**
     * item点击事件
     *
     * @param adapter
     * @param view
     * @param position
     */
    @Override
    public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
        if (isLogin()) {
            if (mHomeBean != null && mHomeBean.getObject() != null && mHomeBean.getObject().getList().size() > 0) {
                HashMap<String, String> keyMap = new HashMap<>();
                keyMap.put("product", mHomeBean.getObject().getList().get(position).getBorrowProduct().getName());
                keyMap.put("positionValue", mHomeBean.getObject().getList().get(position).getPosition().getValue());
                MobclickAgent.onEvent(getContext(), "homeList", keyMap);
                mPresenter.postUvData(mHomeBean, position, CusConstants.HOMEINFO);
                openDetail(CusConstants.HOMEINFO, mHomeBean, position);
            }


        }


    }

    /**
     * 跑马灯点击事件
     *
     * @param position
     * @param textView
     */
    @Override
    public void onItemClick(int position, TextView textView) {
        if (isLogin()) {
            if (mHomeBean != null && mHomeBean.getObject() != null && mHomeBean.getObject().getPaymentReport().size() > 0) {
                HashMap<String, String> keyMap = new HashMap<>();
                keyMap.put("product", mHomeBean.getObject().getPaymentReport().get(position).getBorrowProduct().getName());
                keyMap.put("positionValue", mHomeBean.getObject().getPaymentReport().get(position).getPosition().getValue());
                MobclickAgent.onEvent(getContext(), "payment", keyMap);

                calculate(position, CusConstants.REPORTMENT);
                openDetail(CusConstants.REPORTMENT, mHomeBean, position);
            }
        }

    }

    /**
     * 计算UV
     *
     * @param position
     * @param type
     */
    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postUvData(mHomeBean, position, type);
            }
        }.start();
    }

    private class ViewPagerDialogAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return overlays.size();
//            return 3;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {

            return view == o;
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
//            super.destroyItem(container, position, object);

            container.removeView((View) object);

        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            ImageView iv_one = new ImageView(getContext());

            iv_one.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (isLogin()) {
                        calculate(0, CusConstants.HOME_DIALOG);
                        openDetail(CusConstants.HOME_DIALOG, mHomeBean, position);
                    }

                }
            });
            if (overlays.size() > 0) {
                if (!TextUtils.isEmpty(overlays.get(viewPagePosition).getImgUrl())) {
                    Glide.with(getContext()).asBitmap().load(overlays.get(position).getImgUrl()).into(iv_one);
                } else {
                    Glide.with(getContext()).asBitmap().load(overlays.get(position).getBorrowProduct().getLogoUrl()).into(iv_one);
                }
            }
            container.addView(iv_one);
            return iv_one;
        }
    }
}
