package com.sudaizhijia.ydjdq.bean;

import android.widget.ImageView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.global.CusConstants;

/**
 * Author: William Wang
 * Date:   On 2018/12/5
 */
public class NewNowBean extends BaseBean implements MultiItemEntity {
    public NewNowBean(String name, String des) {
        this.name = name;
        this.des = des;
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

    @Override
    public int getItemType() {
        return CusConstants.TYPE_NEWPRODUCT;
    }
}
