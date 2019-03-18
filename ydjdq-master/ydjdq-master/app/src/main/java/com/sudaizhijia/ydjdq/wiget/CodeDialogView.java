package com.sudaizhijia.ydjdq.wiget;

import android.app.Dialog;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.sudaizhijia.ydjdq.ui.home.HomeFragment;

public class CodeDialogView extends Dialog {
    //    style引用style样式
    public CodeDialogView(Context context, int width, int height, View layout, int style) {

        super(context, style);

        setContentView(layout);

        Window window = getWindow();

        WindowManager.LayoutParams params = window.getAttributes();

        params.gravity = Gravity.CENTER;

        window.setAttributes(params);
    }

}
