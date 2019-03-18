package com.sudaizhijia.ydjdq.ui.productdetail;


import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.StyleSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.webkit.JavascriptInterface;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.gastudio.downloadloadding.library.GADownloadingView;
import com.google.gson.Gson;
import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.BaseBean;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.bean.MarketBean;
import com.sudaizhijia.ydjdq.bean.MessageBean;
import com.sudaizhijia.ydjdq.bean.MineBean;
import com.sudaizhijia.ydjdq.bean.MoreProductBean;
import com.sudaizhijia.ydjdq.bean.MustProductBean;
import com.sudaizhijia.ydjdq.bean.NewProductBean;
import com.sudaizhijia.ydjdq.bean.SplashBean;
import com.sudaizhijia.ydjdq.event.MessageEvent;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.global.CusConstants;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.http.HttpCallback;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.login.LoginActivity;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.must.AndroidtoJs;
import com.sudaizhijia.ydjdq.ui.must.AndroidtoJsDetials;
import com.sudaizhijia.ydjdq.ui.newproduct.NewProductActivity;
import com.sudaizhijia.ydjdq.utils.ActivityUtils;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.utils.KeyUtils;
import com.sudaizhijia.ydjdq.utils.SharedPreUtils;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;
import com.sudaizhijia.ydjdq.wiget.CodeDialogView;
import com.sudaizhijia.ydjdq.wiget.MyDialog;
import com.sudaizhijia.ydjdq.wiget.RoundedImageView;
import com.sudaizhijia.ydjdq.wiget.SharePopwindow;
import com.sudaizhijia.ydjdq.wiget.StatusBarHeightView;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.utils.TbsLog;
import com.zhy.http.okhttp.OkHttpUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/**
 * Created by WilliamWang on 2018/12/7
 */
public class ProductDetailActivity extends MVPBaseActivity<ProductDetailContract.View, ProductDetailPresenter> implements ProductDetailContract.View
        , EasyPermissions.PermissionCallbacks, View.OnClickListener {
    @BindView(R.id.rl_more)
    RelativeLayout rlMore;
    //    @BindView(R.id.ll_request)
//    RelativeLayout llRequest;
//    @BindView(R.id.tv_more)
//    TextView tvMore;
    @BindView(R.id.profile_image1)
    CircleImageView profileImage1;
    @BindView(R.id.profile_image3)
    CircleImageView profileImage3;
    private SharePopwindow sharePopwindow;
    private BounceLoadingView view;
    @BindView(R.id.iv_back)
    ImageView ivBack;

    @BindView(R.id.iv_detail_share)
    ImageView ivDetailShare;
    @BindView(R.id.rl_detail_root)
    RelativeLayout rlDetailRoot;
    @BindView(R.id.iv_statu)
    ImageView iv_statu;
    @BindView(R.id.profile_image)
    CircleImageView profileImage;

    @BindView(R.id.profile_image2)
    CircleImageView profileImage2;
    @BindView(R.id.main)
    View main;
    //    @BindView(R.id.ll_detail_more)
//    LinearLayout llDetailMore;
    @BindView(R.id.ll_webview)
    RelativeLayout ll_webview;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;
    @BindView(R.id.btnBack1)
    ImageButton btnBack1;
    @BindView(R.id.errview)
    View errview;
    @BindView(R.id.btnForward1)
    ImageButton btnForward1;
    @BindView(R.id.btnMore)
    ImageButton btnMore;
    @BindView(R.id.btnHome1)
    ImageButton btnHome1;
    @BindView(R.id.btnExit1)
    ImageButton btnExit1;
    @BindView(R.id.toolbar1)
    LinearLayout toolbar1;
    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.iv_detail_icon)
    RoundedImageView iv_icon;
    @BindView(R.id.tv_product_title)
    TextView tv_product_title;
    @BindView(R.id.loadingView1)
    View loadingView1;
    @BindView(R.id.ll_select_bar)
    RelativeLayout ll_select_bar;
    private final int disable = 120;
    private final int enable = 255;
    private HomeBean homeBean;
    private String mHomeUrl;
    private int position;
    private String downLoadName;
    private HomeBean.ObjectBean.ListBean.BorrowProductBeanX list;
    private GADownloadingView gaDownloadingView;
    private Dialog dialog;
    private int height;
    private int type;
    private HomeBean.ObjectBean.BannerBean.BorrowProductBean banner;
    private HomeBean.ObjectBean.PaymentReportBean.BorrowProductBeanXXXX payment;
    private HomeBean.ObjectBean.MiddleBean.BorrowProductBeanXX middleBean;
    private HomeBean.ObjectBean.TopBean.BorrowProductBeanXXXXX topBean;
    private int productId;
    private TextView tv_retry;
    private NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX recentlyBean;
    private NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX.BorrowProductBeanXX borrowProduct;
    private NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX nowNewBean;
    private NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX.BorrowProductBeanX borrowProduct1;
    private MarketBean.ObjectBean.DaQuanShowListBean marketBean;
    private MarketBean.ObjectBean.DaQuanShowListBean.BorrowProductBean borrowProduct2;
    private SplashBean splashBean;
    private MoreProductBean moreProductBean;
    private MoreProductBean.ObjectBean moreProduct;
    private MoreProductBean.ObjectBean.BorrowProductBean borrowProduct3;
    private MessageBean.ObjectBean.MessageListBean messageListBean;
    private MessageBean.ObjectBean.MessageListBean.BorrowProductBean borrowProduct4;
    private MessageBean messageBean;
    private MineBean mineBean;
    private List<MineBean.ObjectBean.MyVoBean.MyShowListBean> myShowList;
    private MineBean.ObjectBean.MyVoBean.MyShowListBean.BorrowProductBean borrowProduct5;
    private List<MineBean.ObjectBean.MyVoBean.AppBannerListBean> appBannerList;
    private MustProductBean mustProductBean;
    private ArrayList<String> list1;
    private HomeBean.ObjectBean.OverlaysBean.BorrowProductBeanXXX borrowProduct6;
    private HomeBean.ObjectBean.DownLoadPreview.BorrowProductDown borrowProductDown;
    private HomeBean.ObjectBean.PopupBean.PupUpBorrowProductBean pupUpBorrowProductBean;
    private SplashBean.ObjectBean.ProductListBean.BorrowProductBean borrowProduct7;
    private String linkedUrl;
    private String linkedUrlTwo;
    private List<Integer> errorCode = new ArrayList<>();
    private String description;
    private MineBean.ObjectBean.MyVoBean.MyShowListBean myShowListBean;
    private String logoUrl;

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        gaDownloadingView.updateProgress(event.getProgress());
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
            EasyPermissions.requestPermissions(this, "您好，我们需要获取以下权限，仅用于产品下载。",
                    REQUEST_PERMISSION, PERMISSIONS);
        }

//        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
//            boolean isGranted = true;
//            for (String permission : PERMISSIONS) {
//                int result = ActivityCompat.checkSelfPermission(this, permission);
//                if (result != PackageManager.PERMISSION_GRANTED) {
//                    isGranted = false;
//                    break;
//                }
//            }
//
//            if (!isGranted) {
//                // 还没有的话，去申请权限
//                ActivityCompat.requestPermissions(this, PERMISSIONS, REQUEST_PERMISSION);
//            }
//        }
    }

    /*  @Override
      public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
          super.onRequestPermissionsResult(requestCode, permissions, grantResults);

          if (requestCode == REQUEST_PERMISSION) {
              boolean granted = true;
              for (int result : grantResults) {
                  granted = result == PackageManager.PERMISSION_GRANTED;
                  if (!granted) {
                      break;
                  }
              }

              if (!granted) {
                  // 没有赋予权限

              } else {
                  // 已经赋予过权限了

              }
          }
      }*/

    @Override
    protected void init() {
        mHandler.sendEmptyMessageDelayed(0, 1000);
//        KeyUtils.autoScrollView(main, webview);
//        errorCode.add();
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
//        sharePopwindow = new SharePopwindow(this, webview);
        try {
            if (CusApplication.list != null && CusApplication.list.size() > 0) {
                list1 = CusApplication.list;
                Glide.with(getContext()).load(list1.get(0)).into(profileImage);
                Glide.with(getContext()).load(list1.get(1)).into(profileImage1);
                Glide.with(getContext()).load(list1.get(2)).into(profileImage2);
                Glide.with(getContext()).load(list1.get(3)).into(profileImage3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        initPermission();
        EventBus.getDefault().register(this);
        type = getIntent().getIntExtra(CusConstants.START_TYPE, 0);
        if (type == CusConstants.HOMEINFO) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            list = homeBean.getObject().getList().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(list.getLinkedUrlTwo())) {
                linkedUrlTwo = list.getLinkedUrlTwo();
            }

            productId = homeBean.getObject().getList().get(position).getProductId();
            Glide.with(getContext()).load(list.getLogoUrl()).into(iv_icon);
            description = homeBean.getObject().getList().get(position).getBorrowProduct().getDescription();
            tv_product_title.setText(list.getName());
            downLoadName = list.getName();
            mHomeUrl = list.getLinkedUrl();
            logoUrl = list.getLogoUrl();
        } else if (type == CusConstants.MINE_ZHUANTI) {
            iv_statu.setVisibility(View.GONE);
            rlDetailRoot.setVisibility(View.GONE);
            ll_select_bar.setVisibility(View.GONE);
            mineBean = (MineBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            myShowListBean = mineBean.getObject().getMyVo().getMyShowList().get(position);
            description = myShowListBean.getBorrowProduct().getDescription();
            productId = myShowListBean.getProductId();
            downLoadName = myShowListBean.getTitle();
            Log.e("title", downLoadName + " ");
            if (!TextUtils.isEmpty(myShowListBean.getBorrowProduct().getLinkedUrlTwo())) {
                linkedUrlTwo = myShowListBean.getBorrowProduct().getLinkedUrlTwo();
            }
            logoUrl = myShowListBean.getImgUrl();
            mHomeUrl = myShowListBean.getBorrowProduct().getLinkedUrl();
//            mHomeUrl = API.SERVER_URL + mHomeUrl;
        } else if (type == CusConstants.ZHUANTI) {
            iv_statu.setVisibility(View.GONE);
            rlDetailRoot.setVisibility(View.GONE);
            ll_select_bar.setVisibility(View.GONE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            HomeBean.ObjectBean.TopBean.BorrowProductBeanXXXXX borrowProduct = homeBean.getObject().getTop().get(position).getBorrowProduct();
            productId = homeBean.getObject().getTop().get(position).getProductId();
            description = homeBean.getObject().getTop().get(position).getBorrowProduct().getDescription();
//            Glide.with(getContext()).load(list.getLogoUrl()).into(iv_icon);
//            tv_product_title.setText(list.getName());
//            downLoadName = list.getName();
            if (!TextUtils.isEmpty(borrowProduct.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct.getLinkedUrlTwo();
            }
            logoUrl = borrowProduct.getLogoUrl();
            mHomeUrl = borrowProduct.getLinkedUrl();
//            mHomeUrl = API.SERVER_URL + mHomeUrl;
        } else if (type == CusConstants.BANNER) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            banner = homeBean.getObject().getBanner().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(banner.getLinkedUrlTwo())) {
                linkedUrlTwo = banner.getLinkedUrlTwo();
            }
            description = homeBean.getObject().getBanner().get(position).getBorrowProduct().getDescription();
            mHomeUrl = banner.getLinkedUrl();
            productId = homeBean.getObject().getBanner().get(position).getProductId();
            Glide.with(getContext()).load(banner.getLogoUrl()).into(iv_icon);
            downLoadName = banner.getName();
            logoUrl = homeBean.getObject().getBanner().get(position).getBorrowProduct().getLogoUrl();
            tv_product_title.setText(banner.getName());
        } else if (type == CusConstants.HOME_DIALOG) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct6 = homeBean.getObject().getOverlays().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct6.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct6.getLinkedUrlTwo();
            }
            description = homeBean.getObject().getOverlays().get(position).getBorrowProduct().getDescription();
            mHomeUrl = borrowProduct6.getLinkedUrl();
            productId = homeBean.getObject().getOverlays().get(position).getProductId();
            Glide.with(getContext()).load(borrowProduct6.getLogoUrl()).into(iv_icon);
            downLoadName = borrowProduct6.getName();
            logoUrl = homeBean.getObject().getOverlays().get(position).getBorrowProduct().getLogoUrl();
            tv_product_title.setText(borrowProduct6.getName());
        } else if (type == CusConstants.REPORTMENT) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            payment = homeBean.getObject().getPaymentReport().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(payment.getLinkedUrlTwo())) {
                linkedUrlTwo = payment.getLinkedUrlTwo();
            }
            description = homeBean.getObject().getPaymentReport().get(position).getBorrowProduct().getDescription();
            mHomeUrl = payment.getLinkedUrl();
            productId = homeBean.getObject().getPaymentReport().get(position).getProductId();
            Glide.with(getContext()).load(payment.getLogoUrl()).into(iv_icon);
            downLoadName = payment.getName();
            logoUrl = homeBean.getObject().getPaymentReport().get(position).getBorrowProduct().getLogoUrl();
            tv_product_title.setText(payment.getName());
        } else if (type == CusConstants.MIDDLE) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            if (homeBean.getObject().getMiddle().size() <= 0) {
                return;
            }
            description = homeBean.getObject().getMiddle().get(position).getBorrowProduct().getDescription();
            middleBean = homeBean.getObject().getMiddle().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(middleBean.getLinkedUrlTwo())) {
                linkedUrlTwo = middleBean.getLinkedUrlTwo();
            }
            logoUrl = homeBean.getObject().getMiddle().get(position).getBorrowProduct().getLogoUrl();
            mHomeUrl = middleBean.getLinkedUrl();
            downLoadName = middleBean.getName();
            Glide.with(getContext()).load(middleBean.getLogoUrl()).into(iv_icon);
            productId = homeBean.getObject().getMiddle().get(position).getProductId();
            tv_product_title.setText(middleBean.getName());
        } else if (type == CusConstants.TOP) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = homeBean.getObject().getTop().get(position).getProductId();

            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            topBean = homeBean.getObject().getTop().get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(topBean.getLinkedUrlTwo())) {
                linkedUrlTwo = topBean.getLinkedUrlTwo();
            }
            logoUrl = homeBean.getObject().getTop().get(position).getBorrowProduct().getLogoUrl();
            description = homeBean.getObject().getTop().get(position).getBorrowProduct().getDescription();
            Glide.with(getContext()).load(topBean.getLogoUrl()).into(iv_icon);
            mHomeUrl = topBean.getLinkedUrl();
            downLoadName = topBean.getName();
            tv_product_title.setText(topBean.getName());
        } else if (type == CusConstants.RECENTLY) {
            iv_statu.setVisibility(View.VISIBLE);
            recentlyBean = (NewProductBean.ObjectBean.PastDayListBean.ProductShowListBeanXX) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = recentlyBean.getProductId();
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct = recentlyBean.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct.getLinkedUrlTwo();
            }
            description = recentlyBean.getBorrowProduct().getDescription();
            Glide.with(getContext()).load(borrowProduct.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct.getLinkedUrl();
            logoUrl = borrowProduct.getLogoUrl();
            downLoadName = borrowProduct.getName();
            tv_product_title.setText(borrowProduct.getName());
        } else if (type == CusConstants.NOW_NEWPRODUCT) {
            iv_statu.setVisibility(View.VISIBLE);
            nowNewBean = (NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = nowNewBean.getProductId();
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct1 = nowNewBean.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct1.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct1.getLinkedUrlTwo();
            }
            description = nowNewBean.getBorrowProduct().getDescription();
            Glide.with(getContext()).load(borrowProduct1.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct1.getLinkedUrl();
            downLoadName = borrowProduct1.getName();
            logoUrl = borrowProduct1.getLogoUrl();
            tv_product_title.setText(borrowProduct1.getName());
        } else if (type == CusConstants.MARKET_DATA) {
            iv_statu.setVisibility(View.VISIBLE);
            marketBean = (MarketBean.ObjectBean.DaQuanShowListBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = marketBean.getProductId();
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct2 = marketBean.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct2.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct2.getLinkedUrlTwo();
            }
            description = marketBean.getBorrowProduct().getDescription();
            Glide.with(getContext()).load(borrowProduct2.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct2.getLinkedUrl();
            downLoadName = borrowProduct2.getName();
            logoUrl = borrowProduct2.getLogoUrl();
            tv_product_title.setText(borrowProduct2.getName());
        } else if (type == CusConstants.SPLASH_TYPE) {

            iv_statu.setVisibility(View.VISIBLE);
            splashBean = (SplashBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            borrowProduct7 = splashBean.getObject().getProductList().get(0).getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct7.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct7.getLinkedUrlTwo();
            }
            if (splashBean.getObject().getProductList().size() <= 0) {
                return;
            }
            if (splashBean.getObject().getProductList().get(position).getShowType().equals(CusConstants.ZHAUNTI_TYPE) || splashBean.getObject().getProductList().get(0).getShowType().equals(CusConstants.HUODONG_TYPE)) {
                mHomeUrl = borrowProduct7.getLinkedUrl();
                iv_statu.setVisibility(View.GONE);
                rlDetailRoot.setVisibility(View.GONE);
                ll_select_bar.setVisibility(View.GONE);
                logoUrl = borrowProduct7.getLogoUrl();
//                mHomeUrl = API.SERVER_URL + mHomeUrl;
            } else {
                productId = splashBean.getObject().getProductList().get(0).getProductId();
                position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
                Glide.with(getContext()).load(borrowProduct7.getLogoUrl()).into(iv_icon);
                mHomeUrl = borrowProduct7.getLinkedUrl();
                logoUrl = borrowProduct7.getLogoUrl();
                downLoadName = borrowProduct7.getName();
                tv_product_title.setText(borrowProduct7.getName());
                iv_statu.setVisibility(View.VISIBLE);
                rlDetailRoot.setVisibility(View.VISIBLE);
                ll_select_bar.setVisibility(View.VISIBLE);
            }

        } else if (type == CusConstants.MOREPRODUCT) {
            iv_statu.setVisibility(View.VISIBLE);
            moreProduct = (MoreProductBean.ObjectBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = moreProduct.getProductId();
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct3 = moreProduct.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct3.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct3.getLinkedUrlTwo();
            }
            logoUrl = borrowProduct3.getLogoUrl();
            description = moreProduct.getBorrowProduct().getDescription();
            Glide.with(getContext()).load(borrowProduct3.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct3.getLinkedUrl();
            downLoadName = borrowProduct3.getName();
            tv_product_title.setText(borrowProduct3.getName());
        } else if (type == CusConstants.MESSAGE_MSG) {
            iv_statu.setVisibility(View.VISIBLE);
            messageListBean = (MessageBean.ObjectBean.MessageListBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            productId = messageListBean.getProductId();
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProduct4 = messageListBean.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct4.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct4.getLinkedUrlTwo();
            }
            logoUrl = borrowProduct4.getLogoUrl();
            description = messageListBean.getBorrowProduct().getDescription();
            Glide.with(getContext()).load(borrowProduct4.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct4.getLinkedUrl();
            downLoadName = borrowProduct4.getName();
            tv_product_title.setText(borrowProduct4.getName());
        } else if (type == CusConstants.MINE_SHOW) {
            iv_statu.setVisibility(View.VISIBLE);
            mineBean = (MineBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            myShowList = mineBean.getObject().getMyVo().getMyShowList();

            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            productId = myShowList.get(position).getProductId();
            borrowProduct5 = myShowList.get(position).getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct5.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct5.getLinkedUrlTwo();
            }
            logoUrl = borrowProduct5.getLogoUrl();
            description = borrowProduct5.getDescription();
            Glide.with(getContext()).load(borrowProduct5.getLogoUrl()).into(iv_icon);
            mHomeUrl = borrowProduct5.getLinkedUrl();
            downLoadName = borrowProduct5.getName();
            tv_product_title.setText(borrowProduct5.getName());
        } else if (type == CusConstants.MINE_BANNER) {
            iv_statu.setVisibility(View.VISIBLE);
            mineBean = (MineBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            appBannerList = mineBean.getObject().getMyVo().getAppBannerList();

            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            productId = 0;
//            borrowProduct5 = appBannerList.get(position).getBorrowProduct();//备注
            Glide.with(getContext()).load(appBannerList.get(position).getImageUrl()).into(iv_icon);
            mHomeUrl = appBannerList.get(position).getHtmlUrl();
            logoUrl = appBannerList.get(position).getImageUrl();
            downLoadName = appBannerList.get(position).getHtmlTitle();
            tv_product_title.setText(downLoadName);
        } else if (type == CusConstants.MUST) {
            iv_statu.setVisibility(View.VISIBLE);
            mustProductBean = (MustProductBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
//            appBannerList = mineBean.getObject().getMyVo().getAppBannerList();
            MustProductBean.BorrowProductBean borrowProduct = mustProductBean.getBorrowProduct();
            if (!TextUtils.isEmpty(borrowProduct.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProduct.getLinkedUrlTwo();
            }
            description = borrowProduct.getDescription();
            logoUrl = borrowProduct.getLogoUrl();
//            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            productId = mustProductBean.getProductId();
            if (!TextUtils.isEmpty(mustProductBean.getShowType()) || !TextUtils.isEmpty(mustProductBean.getShowType())) {
                if (mustProductBean.getShowType().equals(CusConstants.ZHAUNTI_TYPE) || mustProductBean.getShowType().equals(CusConstants.HUODONG_TYPE)) {
                    mHomeUrl = mustProductBean.getBorrowProduct().getLinkedUrl();
                    iv_statu.setVisibility(View.GONE);
                    rlDetailRoot.setVisibility(View.GONE);
                    ll_select_bar.setVisibility(View.GONE);
                    logoUrl = mustProductBean.getBorrowProduct().getLogoUrl();
//                    mHomeUrl = API.SERVER_URL + mHomeUrl;
                } else {
                    Glide.with(getContext()).load(mustProductBean.getBorrowProduct().getLogoUrl()).into(iv_icon);
                    mHomeUrl = mustProductBean.getBorrowProduct().getLinkedUrl();
                    downLoadName = mustProductBean.getBorrowProduct().getName();
                    tv_product_title.setText(downLoadName);
                    iv_statu.setVisibility(View.VISIBLE);
                    rlDetailRoot.setVisibility(View.VISIBLE);
                    ll_select_bar.setVisibility(View.VISIBLE);
                    logoUrl = mustProductBean.getBorrowProduct().getLogoUrl();
                }
                description = mustProductBean.getBorrowProduct().getDescription();
            } else {
                Glide.with(getContext()).load(mustProductBean.getBorrowProduct().getLogoUrl()).into(iv_icon);
                mHomeUrl = mustProductBean.getBorrowProduct().getLinkedUrl();
                downLoadName = mustProductBean.getBorrowProduct().getName();
                logoUrl = mustProductBean.getBorrowProduct().getLogoUrl();
                tv_product_title.setText(downLoadName);
                iv_statu.setVisibility(View.VISIBLE);
                rlDetailRoot.setVisibility(View.VISIBLE);
                ll_select_bar.setVisibility(View.VISIBLE);
            }
//            Log.e("mHomeUrl", mHomeUrl);
        } else if (type == CusConstants.DUWNLOAD) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            borrowProductDown = homeBean.getObject().getDownLoadPreview().get(position).getBorrowProductDown();
            if (!TextUtils.isEmpty(borrowProductDown.getLinkedUrlTwo())) {
                linkedUrlTwo = borrowProductDown.getLinkedUrlTwo();
            }
            description = borrowProductDown.getDescription();
            productId = homeBean.getObject().getDownLoadPreview().get(position).getProductId();
            Glide.with(getContext()).load(borrowProductDown.getLogoUrl()).into(iv_icon);
            tv_product_title.setText(borrowProductDown.getName());
            logoUrl = borrowProductDown.getLogoUrl();
            downLoadName = borrowProductDown.getName();
            mHomeUrl = borrowProductDown.getLinkedUrl();
        } else if (type == CusConstants.POPUP) {
            iv_statu.setVisibility(View.VISIBLE);
            homeBean = (HomeBean) getIntent().getSerializableExtra(CusConstants.PRODUCT_INFO);
            position = (Integer) getIntent().getIntExtra(CusConstants.PRODUCT_POSITION, 0);
            pupUpBorrowProductBean = homeBean.getObject().getPopUp().get(position).getPupUpBorrowProductBean();
            if (!TextUtils.isEmpty(pupUpBorrowProductBean.getLinkedUrlTwo())) {
                linkedUrlTwo = pupUpBorrowProductBean.getLinkedUrlTwo();
            }
            logoUrl = pupUpBorrowProductBean.getLogoUrl();
            description = pupUpBorrowProductBean.getDescription();
            productId = homeBean.getObject().getPopUp().get(position).getProductId();
            Glide.with(getContext()).load(pupUpBorrowProductBean.getLogoUrl()).into(iv_icon);
            tv_product_title.setText(pupUpBorrowProductBean.getName());
            downLoadName = pupUpBorrowProductBean.getName();
            mHomeUrl = pupUpBorrowProductBean.getLinkedUrl();

        }
//        if(mineBean !=null){
//            if (mineBean.getObject() != null) {
//                if (!TextUtils.isEmpty(mineBean.getObject().getShareUrl())) {
//                    SharedPreUtils.putString(getContext(), "shareUrl", mineBean.getObject().getShareUrl());
//                    if (!TextUtils.isEmpty(SharedPreUtils.getString(getContext(), "shareUrl", ""))) {
//                        String shareUrl = SharedPreUtils.getString(getContext(), "shareUrl", "");
//                        //微信分享
//                        CusApplication.shareUrl = shareUrl + "?productId=" + productId;
//                    }
//                    Log.e("shareUrl", CusApplication.shareUrl);
//                }
//            }
//        }
        if (homeBean != null) {
            if (homeBean.getObject() != null) {
                if (!TextUtils.isEmpty(homeBean.getObject().getShareUrl())) {
                    SharedPreUtils.putString(getContext(), "shareUrl", homeBean.getObject().getShareUrl());
                    if (!TextUtils.isEmpty(SharedPreUtils.getString(getContext(), "shareUrl", ""))) {
                        String shareUrl = SharedPreUtils.getString(getContext(), "shareUrl", "");
                        //微信分享
                        CusApplication.shareUrl = shareUrl + "?productId=" + productId;
                    }

                } else {

                }
            }
        } else {
            String shareUrl = SharedPreUtils.getString(getContext(), "shareUrl", "");
            //微信分享
            CusApplication.shareUrl = shareUrl + "?productId=" + productId;
        }
        Log.e("url", "mHomeUrl-> " + mHomeUrl + "     linkedUrlTwo->" + linkedUrlTwo);

        initOther();
        initWebView();
    }

    private void initOther() {

    }


    private void changGoForwardButton(WebView view) {
        if (view.canGoBack())
            btnBack1.setAlpha(enable);
        else
            btnBack1.setAlpha(disable);
        if (view.canGoForward())
            btnForward1.setAlpha(enable);
        else
            btnForward1.setAlpha(disable);
        if (view.getUrl() != null && view.getUrl().equalsIgnoreCase(mHomeUrl)) {  //TODO homeurl   && view.getUrl().equalsIgnoreCase(mHomeUrl)
            btnHome1.setAlpha(disable);
            btnHome1.setEnabled(false);
        } else {
            btnHome1.setAlpha(enable);
            btnHome1.setEnabled(true);
        }
    }

    private int timer = 0;
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                timer++;
                mHandler.sendEmptyMessageDelayed(0, 1000);
            }
        }
    };
    boolean sgin = true;

    private void initWebView() {
        Log.e("timer", timer + " ");
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("text11111111", "mHomeUrl ====: " + mHomeUrl + "===url=====" + url + "===linekdurl=====" + linkedUrlTwo);
                if (!TextUtils.isEmpty(linkedUrlTwo)) {
                    if (!TextUtils.equals(mHomeUrl, url)) {
//                        if (!linkedUrlTwo.equals(url)) {
                        if (sgin) {
                            //注册
                            calcuteRegister();
                            sgin = false;

                        } else {
                            mHandler.removeMessages(0);
                        }

                    }

                } else {
                    if (!TextUtils.equals(mHomeUrl, url) || linkedUrlTwo.equals(url)) {
//                        if (!linkedUrlTwo.equals(url)) {
                        if (sgin) {
                            //注册
                            calcuteRegister();
                            sgin = false;

                        } else {
                            mHandler.removeMessages(0);
                        }

                    }
                }


                if (CusApplication.isMock == 1) {
//                        Log.e("Mock", "CusApplication.isMock" + CusApplication.isMock + "CusApplication.MockUrl" + CusApplication.MockUrl);
                    webview.loadUrl(CusApplication.MockUrl);
                }
                return false;
            }

            @Override
            public void onPageStarted(WebView webView, String s, Bitmap bitmap) {
                super.onPageStarted(webView, s, bitmap);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                if (Integer.parseInt(Build.VERSION.SDK) >= 16)
                    changGoForwardButton(view);
            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                //6.0以下执行
                //网络未连接
                showErrorPage();
            }

            //处理网页加载失败时
            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
                int errorCode = error.getErrorCode();
//                Log.e("WebResourceError", error.getErrorCode() + "" + error.getDescription().toString());
//                if (errorCode == 404) {
//                    //6.0以上执行
//                    showErrorPage();//显示错误页面
//                }

            }

            @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view,
                                                              WebResourceRequest request) {
                if (!request.isForMainFrame() && request.getUrl().getPath().endsWith("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null,
                                new BufferedInputStream(view.getContext().getAssets().open("empty_favicon.ico")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
                if (url.toLowerCase().contains("/favicon.ico")) {
                    try {
                        return new WebResourceResponse("image/png", null,
                                new BufferedInputStream(view.getContext().getAssets().open("empty_favicon.ico")));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }

            @Override
            public void onReceivedHttpError(WebView webView, WebResourceRequest request, WebResourceResponse errorResponse) {
                if (!request.isForMainFrame() && request.getUrl().getPath().endsWith("/favicon.ico")) {
//                    Log.e("onReceivedHttpError", "favicon.ico 请求错误" + errorResponse.getStatusCode() + errorResponse.getReasonPhrase());

                } else {
                    // TODO:  具体可根据返回状态码做相应处理
//                    Toast.makeText(getApplicationContext(), errorResponse.getReasonPhrase(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        webview.setWebChromeClient(new WebChromeClient() {


            @Override
            public void onProgressChanged(WebView webView, int i) {
//                super.onProgressChanged(webView, i);
                if (i == 100) {


                    progressBar1.setVisibility(View.GONE);//加载完网页进度条消失
                    loadingView1.setVisibility(View.GONE);
                } else {
                    progressBar1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                    progressBar1.setProgress(i);//设置进度值
                    loadingView1.setVisibility(View.VISIBLE);
                    view = loadingView1.findViewById(R.id.loadingView);
                    startLoadingView();
                }

            }


            @Override
            public boolean onJsConfirm(WebView arg0, String arg1, String arg2,
                                       JsResult arg3) {
                return super.onJsConfirm(arg0, arg1, arg2, arg3);
            }

            View myVideoView;
            View myNormalView;
            IX5WebChromeClient.CustomViewCallback callback;

            // /////////////////////////////////////////////////////////
            //

            /**
             * 全屏播放配置
             */
            @Override
            public void onShowCustomView(View view,
                                         IX5WebChromeClient.CustomViewCallback customViewCallback) {
//                FrameLayout normalView = (FrameLayout) findViewById(R.id.web_filechooser);
//                ViewGroup viewGroup = (ViewGroup) normalView.getParent();
//                viewGroup.removeView(normalView);
//                viewGroup.addView(view);
//                myVideoView = view;
//                myNormalView = normalView;
//                callback = customViewCallback;
            }

            @Override
            public void onHideCustomView() {
                if (callback != null) {
                    callback.onCustomViewHidden();
                    callback = null;
                }
                if (myVideoView != null) {
                    ViewGroup viewGroup = (ViewGroup) myVideoView.getParent();
                    viewGroup.removeView(myVideoView);
                    viewGroup.addView(myNormalView);
                }
            }

            @Override
            public boolean onJsAlert(WebView arg0, String arg1, String arg2,
                                     JsResult arg3) {
                /**
                 * 这里写入你自定义的window alert
                 */
                return super.onJsAlert(null, arg1, arg2, arg3);
            }
        });

        webview.setDownloadListener(new DownloadListener() {


            @Override
            public void onDownloadStart(String arg0, String arg1, String arg2,
                                        String arg3, long arg4) {

                if (CusApplication.isMock == 1) {
                    Log.e("MockDown", "CusApplication.isMock" + CusApplication.isMock + "CusApplication.MockUrl" + CusApplication.MockUrl);
                    webview.loadUrl(CusApplication.MockUrl);
                } else {
                    showDownload(arg0);

                }
            }
        });

        WebSettings webSetting = webview.getSettings();
        webSetting.setAllowFileAccess(true);
        webSetting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        webSetting.setSupportZoom(true);
        webSetting.setBuiltInZoomControls(true);
        webSetting.setUseWideViewPort(true);
        webSetting.setSupportMultipleWindows(false);
        // webSetting.setLoadWithOverviewMode(true);
        webSetting.setAppCacheEnabled(true);
        // webSetting.setDatabaseEnabled(true);
        webSetting.setDomStorageEnabled(true);
        webSetting.setJavaScriptEnabled(true);
        webSetting.setGeolocationEnabled(true);
        webSetting.setAppCacheMaxSize(Long.MAX_VALUE);
        webSetting.setCacheMode(WebSettings.LOAD_DEFAULT);  //设置 缓存模式
        webSetting.setAppCacheEnabled(true);//开启 Application Caches 功能
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
                .getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);
        long time = System.currentTimeMillis();
        webview.addJavascriptInterface(new orudctDetail(), "appDetals");
//        webview.addJavascriptInterface(new AndroidtoJs(getContext(),this), "app");
        webview.addJavascriptInterface(new ThisFinish(), "app");
        webview.addJavascriptInterface(new Share(), "appShare");

        //TODO url为空的情况
        if (mHomeUrl == null) {
            webview.loadUrl(mHomeUrl);
        } else {
            webview.loadUrl(mHomeUrl);
            Log.i("webUrl", mHomeUrl);

        }
        TbsLog.d("time-cost", "cost time: "
                + (System.currentTimeMillis() - time));
        CookieSyncManager.createInstance(this);
        CookieSyncManager.getInstance().sync();
    }

    private void calcuteRegister() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postRegisterData(productId, CusApplication.random);
            }
        }.start();
    }

    /**
     * 等待页动画
     */
    private void startLoadingView() {
        view.addBitmap(R.mipmap.v4);
        view.addBitmap(R.mipmap.v5);
        view.addBitmap(R.mipmap.v6);
        view.addBitmap(R.mipmap.v7);
        view.addBitmap(R.mipmap.v8);
        view.addBitmap(R.mipmap.v9);
        view.setShadowColor(Color.LTGRAY);
        view.setDuration(700);
        view.start();
    }

    private void showErrorPage() {
        errview.setVisibility(View.VISIBLE);
        loadingView1.setVisibility(View.GONE);
        webview.setVisibility(View.INVISIBLE);
        View view = errview.findViewById(R.id.tv_net_err_refresh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.loadUrl(mHomeUrl);
                errview.setVisibility(View.INVISIBLE);
                loadingView1.setVisibility(View.VISIBLE);
            }
        });

    }


    public void getScreen() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        // 屏幕高度（像素）
        height = dm.heightPixels;
    }

    private String url;

    private void showDownload(String url) {
        this.url = url;
        getScreen();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_download_view, null);
//        dialog = new MyDialog(getContext(), AppInfoUtil.dip2px(getContext(), 250), height / 3, view, R.style.lock_dialog);
        dialog = new MyDialog(getContext(), AppInfoUtil.dip2px(getContext(), 250), height / 3, view, R.style.CustomDialogStyle);
        gaDownloadingView = view.findViewById(R.id.ga_downloading);
//        CircleImageView civ = view.findViewById(R.id.ic_product);
        tv_retry = view.findViewById(R.id.tv_retry);
        tv_retry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDownload(url);
            }
        });
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false);
//        if (!dialog.isShowing()) {
//            dialog.show();
//        }
        gaDownloadingView.releaseAnimation();
        gaDownloadingView.performAnimation();
        gaDownloadingView.updateProgress(0);
        mPresenter.startDownLoad(url, downLoadName, this, homeBean);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview != null && webview.canGoBack()) {
                webview.goBack();
                if (Integer.parseInt(Build.VERSION.SDK) >= 16)
                    changGoForwardButton(webview);
                return true;
            } else
                return super.onKeyDown(keyCode, event);
        }
        return super.onKeyDown(keyCode, event);
    }


    @Override
    public int getLayoutId() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        return R.layout.activity_product_detail;
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //TODO  问题
//        if (intent == null || webview == null || intent.getData() == null)
//            return;
//        webview.loadUrl(intent.getData().toString());
    }

    @Override
    protected void onDestroy() {
//        if (mTestHandler != null)
//            mTestHandler.removeCallbacksAndMessages(null);
        EventBus.getDefault().unregister(this);
        if (webview != null)
            webview.destroy();
        super.onDestroy();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        // Forward results to EasyPermissions
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @OnClick({R.id.rl_more, R.id.rl_back, R.id.iv_detail_share, R.id.rl_detail_root, R.id.progressBar1, R.id.btnBack1, R.id.btnForward1, R.id.btnMore, R.id.btnHome1, R.id.btnExit1, R.id.toolbar1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_more:
                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
                break;
            case R.id.rl_back:
                if (!TextUtils.isEmpty(getIntent().getStringExtra("tag"))) {
                    if (getIntent().getStringExtra("tag").equals("arr")) {
                        Intent mIntent = new Intent(ProductDetailActivity.this, MainActivity.class);
                        startActivity(mIntent);
                        finish();
                    }
                } else {
                    finish();
                }
                break;
            case R.id.iv_detail_share:

                sharePopwindow = new SharePopwindow(ProductDetailActivity.this, webview, downLoadName, description, ProductDetailActivity.this, logoUrl);
                sharePopwindow.showSharePop(webview);
                break;
            case R.id.rl_detail_root:
                break;
//            case R.id.ll_request:
//                break;
//            case R.id.tv_more:
//                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
//                break;
//            case R.id.profile_image:
//                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
//                break;
//            case R.id.profile_image1:
//                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
//                break;
//            case R.id.profile_image2:
//                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
//                break;
//            case R.id.profile_image3:
//                ActivityUtils.startActivity(getContext(), NewProductActivity.class);
//                break;
//            case R.id.ll_detail_more:
//                break;
//            case R.id.ll_select_bar:
//                break;
            case R.id.progressBar1:
                break;
            case R.id.btnBack1:
                if (webview != null && webview.canGoBack())
                    webview.goBack();
                break;
            case R.id.btnForward1:
                if (webview != null && webview.canGoForward()) {
                    webview.goForward();
                }
                break;
            case R.id.btnMore:
                break;
            case R.id.btnHome1:
                if (webview != null) {
                    //TODO  homeURL
                    webview.loadUrl(mHomeUrl);
                }
                break;
            case R.id.btnExit1:
                Process.killProcess(Process.myPid());
                break;
            case R.id.toolbar1:
                break;
        }
    }


    @Override
    public void showDownLoadView(boolean isFinished) {
        if (isFinished && dialog != null) {
            dialog.dismiss();
        } else {
            gaDownloadingView.onFail();
            tv_retry.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void showDialog(HomeBean homeBean2) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_recommend, null);
        TextView txtRecommend = dialogView.findViewById(R.id.txt_recommend_advertisement);
        TextView txtRecommend2 = dialogView.findViewById(R.id.txt_recommend_advertisement2);
        TextView txtRecommend3 = dialogView.findViewById(R.id.txt_recommend_advertisement3);
        TextView txtRecommend4 = dialogView.findViewById(R.id.txt_recommend_advertisement4);
        SpannableString spanString = new SpannableString("您目前申请了" + downLoadName + "，预计");
        StyleSpan span = new StyleSpan(Typeface.BOLD);
        spanString.setSpan(span, 6, 6 + downLoadName.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtRecommend.setText(spanString);


        SpannableString spanString2 = new SpannableString("下款率为10%，经数据分析显");
        StyleSpan span2 = new StyleSpan(Typeface.BOLD);
        spanString2.setSpan(span2, 4, 7, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtRecommend2.setText(spanString2);


        SpannableString spanString4 = new SpannableString("率可达80%！");
        StyleSpan span4 = new StyleSpan(Typeface.BOLD);
        spanString4.setSpan(span4, 3, 6, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        txtRecommend4.setText(spanString4);


        RelativeLayout rlRecommendProduct = dialogView.findViewById(R.id.rl_recommend_product1);
        ImageView imgRecommendLog = dialogView.findViewById(R.id.img_recommend_log);
        TextView txtRecommendLog = dialogView.findViewById(R.id.txt_recommend_log);
        TextView txtRecommendDescribe = dialogView.findViewById(R.id.txt_recommend_describe);
        if (homeBean2 != null) {
            if (homeBean2.getObject().getDownLoadPreview() != null) {
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getLogoUrl())) {
                    Glide.with(getContext()).load(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getLogoUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imgRecommendLog);
                }
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getName())) {
                    txtRecommendLog.setText(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getName());
                }
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getDescription())) {
                    txtRecommendDescribe.setText(homeBean2.getObject().getDownLoadPreview().get(0).getBorrowProductDown().getDescription());
                }
            }
        }
        RelativeLayout rlRecommendProduct2 = dialogView.findViewById(R.id.rl_recommend_product2);
        ImageView imgRecommendLog2 = dialogView.findViewById(R.id.img_recommend_log2);
        TextView txtRecommendLog2 = dialogView.findViewById(R.id.txt_recommend_log2);
        TextView txtRecommendDescribe2 = dialogView.findViewById(R.id.txt_recommend_describe2);
        if (homeBean2 != null) {
            if (homeBean2.getObject().getDownLoadPreview() != null) {
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getLogoUrl())) {
                    Glide.with(getContext()).load(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getLogoUrl()).apply(RequestOptions.bitmapTransform(new CircleCrop())).into(imgRecommendLog2);
                }
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getName())) {
                    txtRecommendLog2.setText(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getName());
                }
                if (!TextUtils.isEmpty(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getDescription())) {
                    txtRecommendDescribe2.setText(homeBean2.getObject().getDownLoadPreview().get(1).getBorrowProductDown().getDescription());
                }
            }
        }

        rlRecommendProduct.setOnClickListener(this);
        rlRecommendProduct2.setOnClickListener(this);
        CodeDialogView mMyDialog = new CodeDialogView(this, 0, 0, dialogView, R.style.DialogTheme);
        mMyDialog.setCancelable(true);
        mMyDialog.show();
    }

    @Override
    public void calcuteDownload() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                mPresenter.postDownloadData(productId, CusApplication.random);
            }
        }.start();
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


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_recommend_product1:
                calculate(0, CusConstants.DUWNLOAD);
                openDetail(CusConstants.DUWNLOAD, homeBean, 0);
                finish();
                break;
            case R.id.rl_recommend_product2:
                calculate(1, CusConstants.DUWNLOAD);
                openDetail(CusConstants.DUWNLOAD, homeBean, 1);
                finish();
                break;

        }
    }

    public void openDetail(int type, BaseBean data, int position) {
        Intent intent = new Intent(getContext(), ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, position);
        startActivity(intent);
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
                mPresenter.postUvData(homeBean, position, type);
            }
        }.start();
    }

    /**
     * 分享
     */
    public class Share {
        @JavascriptInterface
        public void getShare() {
            Log.e("shareUrlZHUANTI", CusApplication.shareUrl);
            sharePopwindow = new SharePopwindow(ProductDetailActivity.this, webview, downLoadName, description, ProductDetailActivity.this, logoUrl);
            sharePopwindow.showSharePop(webview);

        }
    }

    public class ThisFinish {
        @JavascriptInterface
        public void JsFinish() {
            if (!TextUtils.isEmpty(getIntent().getStringExtra("tag"))) {
                if (getIntent().getStringExtra("tag").equals("arr")) {
                    Intent mIntent = new Intent(ProductDetailActivity.this, MainActivity.class);
                    startActivity(mIntent);
                    finish();
                }

            } else {
                finish();
            }


        }

    }

    public class orudctDetail {
        @JavascriptInterface
        public void productDetials(String msg) {
            if (isLogin()) {
                Log.e("productDetialsMsg", msg);
                mustProductBean = new Gson().fromJson(msg, MustProductBean.class);
                if (mustProductBean != null) {

                    String showType = mustProductBean.getShowType();
                    if (!TextUtils.isEmpty(showType)) {
                        if (showType.equals(CusConstants.HUODONG_TYPE) || showType.equals(CusConstants.ZHAUNTI_TYPE)) {
                            calculate();
                            openDetail(CusConstants.MUST, mustProductBean);
                            finish();
                        } else {
                            calculate();
                            openDetail(CusConstants.MUST, mustProductBean);
                        }
                    } else {
                        calculate();
                        openDetail(CusConstants.MUST, mustProductBean);
                    }
                }
            }

        }
    }

    public boolean isLogin() {
        if (!CusApplication.isLogin) {
            this.startActivity(new Intent(this, LoginActivity.class));
            return false;
        }
        return true;
    }

    public void openDetail(int type, BaseBean data) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra(CusConstants.START_TYPE, type);
        intent.putExtra(CusConstants.PRODUCT_INFO, data);
        intent.putExtra(CusConstants.PRODUCT_POSITION, 999);
        this.startActivity(intent);
    }

    public void calculate() {
        new Thread() {
            @Override
            public void run() {
                super.run();
                postUvData(mustProductBean);
            }
        }.start();
    }

    public void postUvData(MustProductBean homeBean) {
        CusApplication.random = AppInfoUtil.getNowTime();
        int productShowId = 0;
        String position = "";
        int sortIndex = 0;
        int id = 0;

        productShowId = homeBean.getProductId();
//        position = homeBean.getPosition().getKey();
        position = homeBean.getPosition();
        sortIndex = homeBean.getSortIndex();
        id = homeBean.getBorrowProduct().getId();

        OkHttpUtils
                .post()
                .url(API.UV)
                .addParams("productShowId", productShowId + "")
                .addParams("position", position)
                .addParams("sortIndex", sortIndex + "")
                .addParams("iemi", AppInfoUtil.getIMEI(getContext()))
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
    }
}
