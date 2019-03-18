package com.sudaizhijia.ydjdq.bean;

public class ServiceNuberBean extends BaseBean{

    /**
     * code : 1
     * message : 公司信息查询成功
     * object : {"createTime":"2017-08-16 13:52:39","description":"关于我们公司客服电话","enable":true,"id":22,"keyName":"ABOUT_US_TEL","updateTime":"2019-01-12 14:32:38","value":"17610310022","version":1}
     */

    private ObjectBean object;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * createTime : 2017-08-16 13:52:39
         * description : 关于我们公司客服电话
         * enable : true
         * id : 22
         * keyName : ABOUT_US_TEL
         * updateTime : 2019-01-12 14:32:38
         * value : 17610310022
         * version : 1
         */

        private String createTime;
        private String description;
        private boolean enable;
        private int id;
        private String keyName;
        private String updateTime;
        private String value;
        private int version;

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public boolean isEnable() {
            return enable;
        }

        public void setEnable(boolean enable) {
            this.enable = enable;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getKeyName() {
            return keyName;
        }

        public void setKeyName(String keyName) {
            this.keyName = keyName;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public int getVersion() {
            return version;
        }

        public void setVersion(int version) {
            this.version = version;
        }
    }
}
