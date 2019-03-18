package com.sudaizhijia.ydjdq.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.sudaizhijia.ydjdq.adapter.SearchrAdapter;
import com.sudaizhijia.ydjdq.global.CusConstants;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class SearchBodyBean  {
    private String title;

    public SearchBodyBean(String title) {
        this.title = title;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
