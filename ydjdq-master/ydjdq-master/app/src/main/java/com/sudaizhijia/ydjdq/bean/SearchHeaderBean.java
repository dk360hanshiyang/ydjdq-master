package com.sudaizhijia.ydjdq.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * Author: William Wang
 * Date:   On 2018/12/6
 */
public class SearchHeaderBean extends SectionEntity<SearchBodyBean> {
    private String url;
    private String title;

    public SearchHeaderBean(boolean isHeader, String header, String title) {
        super(isHeader, header);
        this.title = title;
    }
    public SearchHeaderBean(SearchBodyBean t) {
        super(t);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
