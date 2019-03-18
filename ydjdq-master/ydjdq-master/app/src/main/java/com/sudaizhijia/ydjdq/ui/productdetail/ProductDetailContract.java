package com.sudaizhijia.ydjdq.ui.productdetail;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

import com.gastudio.downloadloadding.library.GADownloadingView;
import com.sudaizhijia.ydjdq.bean.HomeBean;
import com.sudaizhijia.ydjdq.mvp.BasePresenter;
import com.sudaizhijia.ydjdq.mvp.BaseView;

import java.io.File;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class ProductDetailContract {
    interface View extends BaseView {
        void showDownLoadView(boolean isFinished);
        void calcuteDownload();
        void showDialog(HomeBean homeBean);
    }

    interface  Presenter extends BasePresenter<View> {
        void startDownLoad(String url, String productname, Activity activity,HomeBean homeBean);
        void postDownloadData(int productId,String random);
        void postRegisterData(int productId,String random);
        void postUvData(HomeBean homeBean, int currentPosi, int type);
    }
}
