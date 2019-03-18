package com.sudaizhijia.ydjdq.ui.myweb;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import butterknife.BindView;

/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class MyWebActivity extends MVPBaseActivity<MyWebContract.View, MyWebPresenter> implements MyWebContract.View {
    @BindView(R.id.wv_webwiew)
    WebView webView;

    @Override
    protected void init() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String htmlUrl = bundle.getString("htmlUrl");
        WebSettings webSetting = webView.getSettings();
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
        webSetting.setAppCachePath(this.getDir("appcache", 0).getPath());
        webSetting.setDatabasePath(this.getDir("databases", 0).getPath());
        webSetting.setGeolocationDatabasePath(this.getDir("geolocation", 0)
                .getPath());
        // webSetting.setPageCacheCapacity(IX5WebSettings.DEFAULT_CACHE_CAPACITY);
        webSetting.setPluginState(WebSettings.PluginState.ON_DEMAND);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(htmlUrl);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_myweb;
    }
}
