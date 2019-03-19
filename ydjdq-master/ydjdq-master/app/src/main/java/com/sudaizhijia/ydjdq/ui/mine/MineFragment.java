package com.sudaizhijia.ydjdq.ui.mine;


import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.sudaizhijia.ydjdq.IPActivity;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.MineBean;
import com.sudaizhijia.ydjdq.bean.MsgBean;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.global.UpdateManager;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.business.BusinessActivity;
import com.sudaizhijia.ydjdq.ui.message.MessageActivity;
import com.sudaizhijia.ydjdq.ui.moreprodct.MoreProdctActivity;
import com.sudaizhijia.ydjdq.ui.person.PersonActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.sudaizhijia.ydjdq.utils.ActivityUtils;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.umeng.analytics.MobclickAgent;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by WilliamWang on 2018/12/8
 * 我的界面
 */

public class MineFragment extends MVPBaseFragment<MineContract.View, MinePresenter> implements MineContract.View {
    private MineBean mBean;
    @BindView(R.id.ic_user_header)
    CircleImageView icUserHeader;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.iv_mine_login)
    ImageView ivMineLogin;
    @BindView(R.id.iv_message)
    ImageView ivMessage;
    @BindView(R.id.tv_msg_number)
    TextView tvMsgNumber;
    @BindView(R.id.rl_message)
    RelativeLayout rlMessage;
    @BindView(R.id.rl_mine_titlebar)
    RelativeLayout rlMineTitlebar;
    @BindView(R.id.iv_mine_go)
    ImageView ivMineGo;
    @BindView(R.id.ic_water_product4)
    CircleImageView icWaterProduct4;
    @BindView(R.id.ic_water_product3)
    CircleImageView icWaterProduct3;
    @BindView(R.id.ic_water_product2)
    CircleImageView icWaterProduct2;
    @BindView(R.id.ic_water_product1)
    CircleImageView icWaterProduct1;
    @BindView(R.id.ll_mine_new_product)
    RelativeLayout llMineNewProduct;
    @BindView(R.id.iv_mine_tab1)
    ImageView ivMineTab1;
    @BindView(R.id.tv_mine_tab_1)
    TextView tvMineTab1;
    @BindView(R.id.ll_mine_tab1)
    LinearLayout llMineTab1;
    @BindView(R.id.iv_mine_tab2)
    ImageView ivMineTab2;
    @BindView(R.id.tv_mine_tab_2)
    TextView tvMineTab2;
    @BindView(R.id.ll_mine_tab2)
    LinearLayout llMineTab2;
    @BindView(R.id.iv_mine_tab3)
    ImageView ivMineTab3;
    @BindView(R.id.tv_mine_tab_3)
    TextView tvMineTab3;
    @BindView(R.id.ll_mine_tab3)
    LinearLayout llMineTab3;
    @BindView(R.id.iv_mine_tab4)
    ImageView ivMineTab4;
    @BindView(R.id.tv_mine_tab_4)
    TextView tvMineTab4;
    @BindView(R.id.ll_mine_tab4)
    LinearLayout llMineTab4;
    @BindView(R.id.iv_mine_tab5)
    ImageView ivMineTab5;
    @BindView(R.id.tv_mine_tab_5)
    TextView tvMineTab5;
    @BindView(R.id.ll_mine_tab5)
    LinearLayout llMineTab5;
    @BindView(R.id.iv_mine_tab6)
    ImageView ivMineTab6;
    @BindView(R.id.tv_mine_tab_6)
    TextView tvMineTab6;
    @BindView(R.id.ll_mine_tab6)
    LinearLayout llMineTab6;
    @BindView(R.id.iv_mine_tab7)
    ImageView ivMineTab7;
    @BindView(R.id.tv_mine_tab_7)
    TextView tvMineTab7;
    @BindView(R.id.ll_mine_tab7)
    LinearLayout llMineTab7;
    @BindView(R.id.iv_mine_tab8)
    ImageView ivMineTab8;
    @BindView(R.id.tv_mine_tab_8)
    TextView tvMineTab8;
    @BindView(R.id.ll_mine_tab8)
    LinearLayout llMineTab8;
    @BindView(R.id.ll_mine_tab_root)
    LinearLayout llMineTabRoot;
    @BindView(R.id.iv_business_icon)
    ImageView ivBusinessIcon;
    @BindView(R.id.rl_business)
    RelativeLayout rlBusiness;
    @BindView(R.id.iv_version_icon)
    ImageView ivVersionIcon;
    @BindView(R.id.iv_version_go)
    ImageView ivVersionGo;
    @BindView(R.id.tv_versionname)
    TextView tvVersionname;
    @BindView(R.id.rl_version)
    RelativeLayout rlVersion;
    @BindView(R.id.iv_update)
    ImageView iv_update;
    private List<MineBean.ObjectBean.MyVoBean.AppBannerListBean> appBannerList;
    private List<MineBean.ObjectBean.MyVoBean.MyShowListBean> myShowList;
    private List<MineBean.ObjectBean.MyVoBean.XinKouZiBean> xinKouZi;
    private UpdateManager updateManager;

    @Override
    protected void init() {
        if (CusApplication.isUpdate) {
            iv_update.setVisibility(View.VISIBLE);
        }
        tvVersionname.setText("V" + AppInfoUtil.getVersionName(getActivity()));
        icUserHeader.setImageResource(R.mipmap.ic_mine_header);
    }

    @Override
    public void onStart() {
        super.onStart();
        String lastTime = SharedPreUtils.getString(getContext(), CusConstants.MSG_TIME, "");
        mPresenter.getUnReadMsg(lastTime + "");
        if (CusApplication.isLogin) {
            String string = SharedPreUtils.getString(getContext(), CusConstants.USERNAME, "******");
            tvUsername.setText(string);
        } else {
            icUserHeader.setImageResource(R.mipmap.ic_mine_header);
            tvUsername.setText("请登录");
        }
        mPresenter.getMineData();

    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("我的界面");

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("我的界面");

    }

    @OnClick({R.id.ic_user_header, R.id.tv_username, R.id.iv_mine_login, R.id.iv_message, R.id.tv_msg_number, R.id.rl_message,
            R.id.ll_mine_new_product, R.id.ll_mine_tab1, R.id.ll_mine_tab2, R.id.ll_mine_tab3, R.id.ll_mine_tab4,
            R.id.ll_mine_tab5, R.id.ll_mine_tab6, R.id.ll_mine_tab7, R.id.ll_mine_tab8,
            R.id.rl_business, R.id.rl_version})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            //登陆
            case R.id.ic_user_header:
                if (AppInfoUtil.checkLogin(getContext())) {
                    startActivity(new Intent(getContext(), PersonActivity.class));
                }

                break;
            case R.id.tv_username:
                if (AppInfoUtil.checkLogin(getContext())) {
                    startActivity(new Intent(getContext(), PersonActivity.class));
                }
                break;
            case R.id.iv_mine_login:
                if (AppInfoUtil.checkLogin(getContext())) {
                    startActivity(new Intent(getContext(), PersonActivity.class));
                }
                break;
            //消息
            case R.id.iv_message:
                if (AppInfoUtil.checkLogin(getContext())) {
                    ActivityUtils.startActivity(getContext(), MessageActivity.class);
                }
                break;
            case R.id.tv_msg_number:
                if (AppInfoUtil.checkLogin(getContext())) {
                    ActivityUtils.startActivity(getContext(), MessageActivity.class);
                }
                break;
            case R.id.rl_message:
                if (AppInfoUtil.checkLogin(getContext())) {
                    ActivityUtils.startActivity(getContext(), MessageActivity.class);
                }
                break;
            //辐条
            case R.id.ll_mine_new_product:
                if (AppInfoUtil.checkLogin(getContext())) {
                    ActivityUtils.startActivity(getContext(), MoreProdctActivity.class);
                }
                break;


            case R.id.ll_mine_tab1:
                //新用戶
                try {

                    if (AppInfoUtil.checkLogin(getContext())) {
                        if (!TextUtils.isEmpty(mBean.getObject().getMyVo().getMyShowList().get(0).getShowType())) {
                            if (mBean.getObject().getMyVo().getMyShowList().get(0).getShowType().equals(CusConstants.HUODONG_TYPE) || mBean.getObject().getMyVo().getMyShowList().get(0).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                                calculate(0, CusConstants.MINE_ZHUANTI);
                                openDetail(CusConstants.MINE_ZHUANTI, mBean, 0);
                            } else {
                                if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                    calculate(0, CusConstants.MINE_SHOW);
                                    openDetail(CusConstants.MINE_SHOW, mBean, 0);
                                }

                            }
                        } else {
                            if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                calculate(0, CusConstants.TOP);
                                openDetail(CusConstants.TOP, mBean, 0);
                            }
                        }

                    }
                } catch (Exception e) {

                }
                break;
            case R.id.ll_mine_tab2:
                try {

                    if (AppInfoUtil.checkLogin(getContext())) {
                        if (AppInfoUtil.checkLogin(getContext())) {
                            if (!TextUtils.isEmpty(mBean.getObject().getMyVo().getMyShowList().get(1).getShowType())) {
                                if (mBean.getObject().getMyVo().getMyShowList().get(1).getShowType().equals(CusConstants.HUODONG_TYPE) || mBean.getObject().getMyVo().getMyShowList().get(1).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                                    calculate(1, CusConstants.MINE_ZHUANTI);
                                    openDetail(CusConstants.MINE_ZHUANTI, mBean, 1);
                                } else {
                                    if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                        calculate(1, CusConstants.MINE_SHOW);
                                        openDetail(CusConstants.MINE_SHOW, mBean, 1);
                                    }

                                }
                            } else {
                                if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                    calculate(1, CusConstants.TOP);
                                    openDetail(CusConstants.TOP, mBean, 1);
                                }
                            }

                        }
                    }

                } catch (Exception e) {

                }
                break;
            case R.id.ll_mine_tab3:
                try {


                    if (AppInfoUtil.checkLogin(getContext())) {
                        if (AppInfoUtil.checkLogin(getContext())) {
                            if (!TextUtils.isEmpty(mBean.getObject().getMyVo().getMyShowList().get(2).getShowType())) {
                                if (mBean.getObject().getMyVo().getMyShowList().get(2).getShowType().equals(CusConstants.HUODONG_TYPE) || mBean.getObject().getMyVo().getMyShowList().get(2).getShowType().equals(CusConstants.ZHAUNTI_TYPE)) {
                                    calculate(2, CusConstants.MINE_ZHUANTI);
                                    openDetail(CusConstants.MINE_ZHUANTI, mBean, 2);
                                } else {
                                    if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                        calculate(2, CusConstants.MINE_SHOW);
                                        openDetail(CusConstants.MINE_SHOW, mBean, 2);
                                    }

                                }
                            } else {
                                if (mBean.getObject() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                    calculate(2, CusConstants.TOP);
                                    openDetail(CusConstants.TOP, mBean, 2);
                                }
                            }

                        }
                    }
                } catch (Exception e) {

                }
                break;
            case R.id.ll_mine_tab4:
                if (AppInfoUtil.checkLogin(getContext())) {
                    if (mBean != null) {
                        if (mBean.getObject() != null) {
                            if (mBean.getObject().getMyVo().getMyShowList() != null && mBean.getObject().getMyVo().getMyShowList().size() > 0) {
                                calculate(3, CusConstants.MINE_SHOW);
                                openDetail(CusConstants.MINE_SHOW, mBean, 3);
                            } else {
                                Toast.makeText(getContext(), "暂无该产品", Toast.LENGTH_LONG).show();
                            }
                        }

                    }

                }
                break;

            case R.id.ll_mine_tab5:
                if (AppInfoUtil.checkLogin(getContext())) {
                    if (appBannerList.get(0).getUrlType().equals("H5")) {
                        openDetail(CusConstants.MINE_BANNER, mBean, 0);
                    }
                }
//                calculate(0,CusConstants.MINE_BANNER);

                break;

            case R.id.ll_mine_tab6:
                if (AppInfoUtil.checkLogin(getContext())) {
                    if (appBannerList.get(1).getUrlType().equals("H5")) {
                        openDetail(CusConstants.MINE_BANNER, mBean, 1);
                    }
                }

//                calculate(1,CusConstants.MINE_BANNER);
                break;

            case R.id.ll_mine_tab7:
                if (AppInfoUtil.checkLogin(getContext())) {
                    if (appBannerList.get(2).getUrlType().equals("H5")) {
//                        openDetail(CusConstants.MINE_BANNER, mBean, 2);
                        IWXAPI api = WXAPIFactory.createWXAPI(getContext(), CusConstants.APPID);

                        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                        req.userName = "gh_84f06fbaa705"; // 填小程序原始id
//                        req.path = path;                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
                        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
                        api.sendReq(req);
                    } else {

                    }
                }
//                calculate(2, CusConstants.MINE_BANNER);

                break;

            case R.id.ll_mine_tab8:
                if (AppInfoUtil.checkLogin(getContext())) {
                    if (appBannerList.get(3).getUrlType().equals("H5")) {
//                        openDetail(CusConstants.MINE_BANNER, mBean, 3);
                        IWXAPI api = WXAPIFactory.createWXAPI(getContext(), CusConstants.APPID);
                        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
                        req.userName = "gh_3bde01ceba6a"; // 填小程序原始id
                        //req.path = "pages/index/index";                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
                        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
                        api.sendReq(req);
                    }
                }
//                calculate(3,CusConstants.MINE_BANNER);

                break;
            case R.id.rl_business:
                if (CusConstants.isDebug) {

                    startActivity(new Intent(getActivity(), IPActivity.class));
                } else {
                    startActivity(new Intent(getContext(), BusinessActivity.class));

                }
                break;
            case R.id.rl_version:
                updateManager = new UpdateManager(getActivity());
                updateManager.fetchUpdate(false);//备注
                break;
        }
    }


    @Override
    public void setMsgCout(MsgBean bean) {
        if (bean.getObject().getTotal() <= 0) {
            tvMsgNumber.setVisibility(View.GONE);
        } else {
            tvMsgNumber.setVisibility(View.VISIBLE);
            tvMsgNumber.setText(bean.getObject().getTotal() + "");

        }
    }


    public void calculate(int position, int type) {
        new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    if (mBean != null) {
                        if (mBean.getObject() != null) {
                            mPresenter.postUvData(mBean, position, type);
                        }
                    }

                } catch (Exception e) {

                }

            }
        }.start();
    }

    public void openDetail(int type, BaseBean data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);

    }


    @Override
    public void setData(MineBean bean) {
        mBean = bean;
        appBannerList = bean.getObject().getMyVo().getAppBannerList();
        myShowList = bean.getObject().getMyVo().getMyShowList();
        xinKouZi = bean.getObject().getMyVo().getXinKouZi();
        Glide.with(getContext()).load(mBean.getObject().getIconUrl()).into(icUserHeader);
        setImgs();
        setBanner();
        setShow();
    }

    private void setShow() {
        Glide.with(getContext()).load(appBannerList.get(0).getImageUrl()).into(ivMineTab5);
        Glide.with(getContext()).load(appBannerList.get(1).getImageUrl()).into(ivMineTab6);
        Glide.with(getContext()).load(appBannerList.get(2).getImageUrl()).into(ivMineTab7);
        Glide.with(getContext()).load(appBannerList.get(3).getImageUrl()).into(ivMineTab8);
        tvMineTab5.setText(appBannerList.get(0).getName());
        tvMineTab6.setText(appBannerList.get(1).getName());
        tvMineTab7.setText(appBannerList.get(2).getName());
        tvMineTab8.setText(appBannerList.get(3).getName());
    }

    private void setBanner() {
        try {
            Glide.with(getContext()).load(myShowList.get(0).getImgUrl()).into(ivMineTab1);
            Glide.with(getContext()).load(myShowList.get(1).getImgUrl()).into(ivMineTab2);
            Glide.with(getContext()).load(myShowList.get(2).getImgUrl()).into(ivMineTab3);
            Glide.with(getContext()).load(myShowList.get(3).getImgUrl()).into(ivMineTab4);
            tvMineTab1.setText(myShowList.get(0).getTitle());
            tvMineTab2.setText(myShowList.get(1).getTitle());
            tvMineTab3.setText(myShowList.get(2).getTitle());
            tvMineTab4.setText(myShowList.get(3).getTitle());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void setImgs() {
        if (xinKouZi.size() <= 0) {
            return;
        }
        try {
            Glide.with(getContext()).load(xinKouZi.get(0).getBorrowProduct().getLogoUrl()).into(icWaterProduct1);
            Glide.with(getContext()).load(xinKouZi.get(1).getBorrowProduct().getLogoUrl()).into(icWaterProduct2);
            Glide.with(getContext()).load(xinKouZi.get(2).getBorrowProduct().getLogoUrl()).into(icWaterProduct3);
            Glide.with(getContext()).load(xinKouZi.get(3).getBorrowProduct().getLogoUrl()).into(icWaterProduct4);
        } catch (Exception e) {
//            Toast.makeText(getContext() , "", Toast.LENGTH_SHORT).show();
        }

    }
//    private void WXTest() {
//        String appId = "wx5b0fbaf4a1723a55"; // 填应用AppId
//        IWXAPI api = WXAPIFactory.createWXAPI(getActivity(), appId);
//
//        WXLaunchMiniProgram.Req req = new WXLaunchMiniProgram.Req();
//        req.userName = "gh_c0e5e4738265"; // 填小程序原始id
////        req.path = "";                  //拉起小程序页面的可带参路径，不填默认拉起小程序首页
//        req.miniprogramType = WXLaunchMiniProgram.Req.MINIPTOGRAM_TYPE_RELEASE;// 可选打开 开发版，体验版和正式版
//        api.sendReq(req);
//    }
}

