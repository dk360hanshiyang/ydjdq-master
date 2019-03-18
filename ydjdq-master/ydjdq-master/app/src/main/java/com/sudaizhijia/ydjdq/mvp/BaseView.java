package com.sudaizhijia.ydjdq.mvp;

import android.content.Context;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public interface BaseView {
     Context getContext();
     int getLayoutId();
     void baseInit();
     void finishSelf();
}
