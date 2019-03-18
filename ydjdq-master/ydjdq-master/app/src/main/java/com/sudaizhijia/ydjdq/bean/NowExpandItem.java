package com.sudaizhijia.ydjdq.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.global.CusConstants;

/**
 * Author: William Wang
 * Date:   On 2018/12/5
 */
public class NowExpandItem extends AbstractExpandableItem<NewProductBean.ObjectBean.TodayNewListBean.ProductShowListBeanX> implements MultiItemEntity {

    private String time;
    private String number;
    private String action;
    private int nowTime;
    private int position;
    private boolean isCountDown;

    public boolean isCountDown() {
        return isCountDown;
    }

    public void setCountDown(boolean countDown) {
        isCountDown = countDown;
    }

    private int onFocus;
    private int coutDown;

    public int getNowTime() {
        return nowTime;
    }

    public void setNowTime(int nowTime) {
        this.nowTime = nowTime;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public NowExpandItem(String time, String number, int position, boolean isCountDown, int nowTime) {
        this.time = time;
        this.number = number;
        this.position = position;
        this.isCountDown = isCountDown;
        this.nowTime = nowTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public int getLevel() {
        return 0;
    }


    @Override
    public int getItemType() {
        return CusConstants.TYPE_NEWNOW_1;
    }
}
