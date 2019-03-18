package com.sudaizhijia.ydjdq.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.global.CusConstants;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class AfterProductBean implements MultiItemEntity{

    @Override
    public int getItemType() {
        return CusConstants.TYPE_AFTER;
    }

    private String url;
    private String name;
    private String des;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

}
