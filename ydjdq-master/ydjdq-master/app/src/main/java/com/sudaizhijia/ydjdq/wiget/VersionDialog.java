package com.sudaizhijia.ydjdq.wiget;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by WilliamWang on 2018/12/6
 */
public class VersionDialog extends Dialog {

    private static int default_width = 290; //默认宽度
    private static int default_height = 372;//默认高度

    public VersionDialog(Context context, View layout, int style) {
        this(context, default_width, default_height, layout, style);
    }

    public VersionDialog(Context context, int width, int height, View layout, int style) {
        super(context, style);
        setContentView(layout);

        Window window = getWindow();
        WindowManager.LayoutParams params = window.getAttributes();
        params.width=width;
        params.height=height;
        params.gravity = Gravity.CENTER;
        window.setAttributes(params);
    }

    
}
