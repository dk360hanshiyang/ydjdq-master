package com.sudaizhijia.ydjdq.bean;

/**
 * Created by WangYu on 2017/7/24.
 */

public class UpDateBean extends BaseBean {

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    private ObjectBean object;
    public class ObjectBean {
        public String getVersionName() {
            return versionName;
        }

        public void setVersionName(String versionName) {
            this.versionName = versionName;
        }

        private String versionName;
        private String updateDetail;
        private String downloadUrl;
        private int forcedUpdateNo;

        public int getNormalUpdateNo() {
            return normalUpdateNo;
        }

        public void setNormalUpdateNo(int normalUpdateNo) {
            this.normalUpdateNo = normalUpdateNo;
        }

        public int getForcedUpdateNo() {
            return forcedUpdateNo;
        }

        public void setForcedUpdateNo(int forcedUpdateNo) {
            this.forcedUpdateNo = forcedUpdateNo;
        }

        private int normalUpdateNo;

        public String getUpdateDetail() {
            return updateDetail;
        }

        public void setUpdateDetail(String updateDetail) {
            this.updateDetail = updateDetail;
        }

        public String getDownloadUrl() {
            return downloadUrl;
        }

        public void setDownloadUrl(String downloadUrl) {
            this.downloadUrl = downloadUrl;
        }

    }

}
