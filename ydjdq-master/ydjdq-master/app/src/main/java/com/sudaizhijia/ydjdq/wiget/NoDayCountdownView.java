package com.sudaizhijia.ydjdq.wiget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;

import cn.iwgang.countdownview.CountdownView;

public class NoDayCountdownView extends CountdownView {
    public NoDayCountdownView(Context context) {
        super(context);
    }

    public NoDayCountdownView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoDayCountdownView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public int getHour() {
        int day = getDay();
        int hour = super.getHour();

        return day * 24 + hour;
    }
}
