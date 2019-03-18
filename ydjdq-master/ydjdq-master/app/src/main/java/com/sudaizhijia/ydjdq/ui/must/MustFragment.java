package com.sudaizhijia.ydjdq.ui.must;


import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieSyncManager;
import android.webkit.DownloadListener;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.http.API;
import com.sudaizhijia.ydjdq.mvp.MVPBaseFragment;
import com.sudaizhijia.ydjdq.wiget.BounceLoadingView;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.utils.TbsLog;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by WilliamWang on 2018/12/5
 */

public class MustFragment extends MVPBaseFragment<MustContract.View, MustPresenter> implements MustContract.View {

    @BindView(R.id.webview)
    WebView webview;
    @BindView(R.id.iv_neterr)
    ImageView ivNeterr;
    @BindView(R.id.tv_neterr)
    TextView tvNeterr;
    @BindView(R.id.tv_net_err_refresh)
    TextView tvNetErrRefresh;
    @BindView(R.id.progressBar1)
    ProgressBar progressBar1;
    @BindView(R.id.ll_net_err)
    LinearLayout llNetErr;
    @BindView(R.id.loadingView)
    BounceLoadingView loadingView;
    @BindView(R.id.ll_loading)
    LinearLayout llLoading;
    @BindView(R.id.rl_web)
    RelativeLayout rlweb;

    @Override
    protected void init() {
        startLoadingView();
        initWebView();
    }

    @Override
    public void onResume() {
        super.onResume();
        MobclickAgent.onPageStart("一键必下");

    }

    public void reload() {
        if (webview != null) {
            webview.reload(); //刷新
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd("一键必下");

    }


    private void initWebView() {
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (webview != null) {
                    webview.setVisibility(View.VISIBLE);
                }
                if (llNetErr != null) {
                    llNetErr.setVisibility(View.GONE);

                }
                if (llLoading != null) {
                    llLoading.setVisibility(View.GONE);

                }
//                if (Integer.parseInt(Build.VERSION.SDK) >= 16);
//                    changGoForwardButton(view);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
//                super.onReceivedError(view, request, error);
                rlweb.setVisibility(View.GONE);
                llNetErr.setVisibility(View.VISIBLE);
                llLoading.setVisibility(View.GONE);

            }

            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                super.onReceivedError(view, errorCode, description, failingUrl);
                //6.0以下执行
                rlweb.setVisibility(View.GONE);
                llLoading.setVisibility(View.GONE);
                llNetErr.setVisibility(View.VISIBLE);
            }

        });

        webview.setWebChromeClient(new WebChromeClient() {

            @Override
            public boolean onJsConfirm(WebView arg0, String arg1, String arg2,
                                       JsResult arg3) {
                return super.onJsConfirm(arg0, arg1, arg2, arg3);
            }

//            @Override
//            public void onProgressChanged(com.tencent.smtt.sdk.WebView webView, int i) {
////                super.onProgressChanged(webView, i);
//                if (i == 100) {
//                    progressBar1.setVisibility(View.GONE);//加载完网页进度条消失
//                } else {
//                    progressBar1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
//                    progressBar1.setProgress(i);//设置进度值
//                }
//
//            }

            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                if (title.contains("404")) {
                    webview.setVisibility(View.GONE);
                    llLoading.setVisibility(View.GONE);
                    llNetErr.setVisibility(View.VISIBLE);
                    Log.e("text1001232151", "onReceivedError: 2222222222");
                }
            }

            // /////////////////////////////////////////////////////////
            //
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    if (llLoading != null) {
                        llLoading.setVisibility(View.GONE);

                    }

                    if (newProgress == 100) {
                        if (progressBar1 != null) {
                            progressBar1.setVisibility(View.GONE);//加载完网页进度条消失
                        }
                    } else {
                        progressBar1.setVisibility(View.VISIBLE);//开始加载网页时显示进度条
                        progressBar1.setProgress(newProgress);//设置进度值
                    }
//                } else {
//                    llLoading.setVisibility(View.VISIBLE);
//                    llNetErr.setVisibility(View.GONE);
//                    webview.setVisibility(View.GONE);
//                    startLoadingView();
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
//                showDownload(arg0);
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
        webSetting.setDisplayZoomControls(false);
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
        webview.addJavascriptInterface(new AndroidtoJs(getActivity()), "app");//AndroidtoJS类对象映射到js的test对象
        webview.addJavascriptInterface(new AndroidtoJs(getActivity()), "app");//AndroidtoJS类对象映射到js的test对象


        webview.loadUrl(API.MUST);

        TbsLog.d("time-cost", "cost time: "
                + (System.currentTimeMillis() - time));
        CookieSyncManager.createInstance(getActivity());
        CookieSyncManager.getInstance().sync();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_must;
    }

    public void startLoadingView() {
        if (llLoading != null && loadingView != null) {
            llLoading.setVisibility(View.VISIBLE);
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
    }

    @OnClick(R.id.tv_net_err_refresh)
    public void onViewClicked() {
        webview.loadUrl(API.MUST);
        llNetErr.setVisibility(View.GONE);
        llLoading.setVisibility(View.VISIBLE);
        startLoadingView();
    }
}
