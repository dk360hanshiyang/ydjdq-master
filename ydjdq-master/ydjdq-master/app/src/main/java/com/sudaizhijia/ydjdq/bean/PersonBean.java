package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Author: William Wang
 * Date:   On 2018/12/17
 */
public class PersonBean extends BaseBean {


    /**
     * object : {"mobile":"18600758725","useName":"yjx_gLBlfPZN36","iconUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg"}
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
         * mobile : 18600758725
         * useName : yjx_gLBlfPZN36
         * iconUrl : http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg
         */

        @SerializedName("mobile")
        private String mobile;
        @SerializedName("useName")
        private String useName;
        @SerializedName("iconUrl")
        private String iconUrl;

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getUseName() {
            return useName;
        }

        public void setUseName(String useName) {
            this.useName = useName;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }
    }
}
