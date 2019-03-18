package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Author: William Wang
 * Date:   On 2018/12/17
 */
public class AboutBean extends BaseBean {


    /**
     * object : {"tel":"642648818","email":"1510911825@qq.com","url":"www.qianzhouzhou.com","jieshao":"钱周周是山西野豹金融服务外包有限公司开发的一款互联网短期资金周转类APP。钱周周通过大数据风控引擎，实时评估借款人的信用状况，给出科学的用户等级，根据等级可借款不同授信额度，等级可根据历史借款情况逐步提高，等级越高，授信额度越大，借款利率越低。钱周周实现在线申请、自动审批、快速放款，授信额度大，为用户提供优质的借贷服务"}
     */

    @SerializedName("object")
    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * tel : 642648818
         * email : 1510911825@qq.com
         * url : www.qianzhouzhou.com
         * jieshao : 钱周周是山西野豹金融服务外包有限公司开发的一款互联网短期资金周转类APP。钱周周通过大数据风控引擎，实时评估借款人的信用状况，给出科学的用户等级，根据等级可借款不同授信额度，等级可根据历史借款情况逐步提高，等级越高，授信额度越大，借款利率越低。钱周周实现在线申请、自动审批、快速放款，授信额度大，为用户提供优质的借贷服务
         */

        @SerializedName("tel")
        private String tel;
        @SerializedName("email")
        private String email;
        @SerializedName("url")
        private String url;
        @SerializedName("jieshao")
        private String jieshao;

        public String getTel() {
            return tel;
        }

        public void setTel(String tel) {
            this.tel = tel;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getJieshao() {
            return jieshao;
        }

        public void setJieshao(String jieshao) {
            this.jieshao = jieshao;
        }
    }
}
