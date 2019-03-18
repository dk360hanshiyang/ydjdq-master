package com.sudaizhijia.ydjdq.ui.bbs;


import android.content.ClipData;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.webview.WebViewActivity;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.JsResult;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.CookieSyncManager;
import com.tencent.smtt.sdk.DownloadListener;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.tencent.smtt.utils.TbsLog;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BBSFragment extends MVPBaseFragment<BBSContract.View, BBSPresenter> implements BBSContract.View {

    @BindView(R.id.webview)
    com.tencent.smtt.sdk.WebView webview;
    @BindView(R.id.iv_neterr)
    ImageView ivNeterr;
    @BindView(R.id.errview)
    View errView;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;
    @BindView(R.id.tv_neterr)
    TextView tvNeterr;
    @BindView(R.id.tv_net_err_refresh)
    TextView tvNetErrRefresh;
    @BindView(R.id.ll_net_err)
    LinearLayout llNetErr;
    @BindView(R.id.loadingView1)
    View loadingView1;
    @BindView(R.id.loadingView)
    BounceLoadingView loadingView;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.ll_webview)
    RelativeLayout llWebview;
    //    private String mHomeUrl = API.BBS + CusApplication.object.getUserId() + "&" + CusApplication.object.getMobile();
    private String mHomeUrl = "https://m-stg2.tianxiaxinyong.com/cooperation/b-test.html";
    private ValueCallback<Uri> mSingleFileCallback;
    private ValueCallback<Uri[]> mMultiFileCallback;
    private Uri imageUri;
    private static final int REQUEST_LOAD_IMAGE_FROM_GALLERY = 0x10;

    @Override
    protected void init() {
        initWebView();

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_bbs;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_LOAD_IMAGE_FROM_GALLERY) {
            if (mSingleFileCallback == null && mMultiFileCallback == null) {
                return;
            }
            Uri tempUri = null;
            if (data != null) {
//                String url = CommonUtil.getPath(getActivity(), data.getData());
                File temp = new File("");
                tempUri = Uri.fromFile(temp);
            }

            if (mSingleFileCallback != null) { // 5.0以下处理方式
                if (data != null) {
                    mSingleFileCallback.onReceiveValue(tempUri);
                } else {
                    mSingleFileCallback.onReceiveValue(imageUri);
                }
                mSingleFileCallback = null;
            } else if (mMultiFileCallback != null) { // 5.0版本以上
                Uri[] uris = null;
                if (data == null) {
                    uris = new Uri[]{imageUri};
                } else {
                    // 多选图片[图片一定要压缩，转化为base网页加载很慢]
                    String dataString = data.getDataString();
                    ClipData clipData = data.getClipData();
                    if (clipData != null) {
                        int size = clipData.getItemCount();
                        uris = new Uri[size];
                        for (int i = 0; i < size; i++) {
                            // 将所选图片的 url保存到 uris数组中
                            uris[i] = clipData.getItemAt(i).getUri();
                        }
                    }
                    if (!TextUtils.isEmpty(dataString)) {
                        uris = new Uri[]{Uri.parse(dataString)};
                    }
                }

                if (uris == null) {
                    mMultiFileCallback.onReceiveValue(null);
                    mMultiFileCallback = null;
                } else {
                    if (uris[0] != null) {
                        mMultiFileCallback.onReceiveValue(uris);
                        mMultiFileCallback = null;
                    } else {
                        mMultiFileCallback.onReceiveValue(null);
                        mMultiFileCallback = null;
                    }


                }
            }
        }
    }


    @OnClick(R.id.tv_net_err_refresh)
    public void onViewClicked() {
    }

    private void openGallery() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, null);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_LOAD_IMAGE_FROM_GALLERY);
    }


    private void initWebView() {
//       webview.setWebChromeClient(new WebChromeClient());
       webview.setWebViewClient(new WebViewClient(){
           @Override
           public boolean shouldOverrideUrlLoading(WebView webView, String url) {
               if(url.startsWith("weixin://wap/pay?")){
                   Intent intent=new Intent();
                   intent.setAction(Intent.ACTION_VIEW);
                   intent.setData(Uri.parse(url));
                   startActivity(intent);
                   return true;
               }
               return super.shouldOverrideUrlLoading(webView, url);
           }
       });
        WebSettings webSetting = webview.getSettings();
        webSetting.setAllowFileAccess(true);
        //设置可以访问文件
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
        webSetting.setAppCachePath(getActivity().getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(getActivity().getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(getActivity().getDir("geolocation", 0)
                .getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        // webSetting.setRenderPriority(WebSettings.RenderPriority.HIGH);
        // webSetting.setPreFectch(true);
        long time = System.currentTimeMillis();

        //TODO url为空的情况
        if (mHomeUrl == null) {
//            if (CusApplication.isMock == 1) {
//                webview.loadUrl(CusApplication.MockUrl);
//            }else{
            webview.loadUrl(mHomeUrl);

//            }
        } else {
//            if (CusApplication.isMock == 1) {
//                webview.loadUrl(CusApplication.MockUrl);
//            }else
            webview.loadUrl(mHomeUrl);

//            }
        }
        TbsLog.d("time-cost", "cost time: "
                + (System.currentTimeMillis() - time));
        CookieSyncManager.createInstance(getActivity());
        CookieSyncManager.getInstance().sync();
    }

    public void goback() {
        webview.goBack();
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

    private void showErrorPage() {
        errView.setVisibility(View.VISIBLE);
        loadingView1.setVisibility(View.GONE);
        webview.setVisibility(View.INVISIBLE);
        View view = errView.findViewById(R.id.tv_net_err_refresh);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.loadUrl(mHomeUrl);
                errView.setVisibility(View.INVISIBLE);
                loadingView1.setVisibility(View.VISIBLE);
            }
        });

    }
}
