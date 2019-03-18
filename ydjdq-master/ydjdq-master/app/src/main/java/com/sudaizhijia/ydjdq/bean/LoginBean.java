package com.sudaizhijia.ydjdq.bean;

/**
 * Author: William Wang
 * Date:   On 2018/12/10
 */
public class LoginBean extends BaseBean {


    /**
     * object : {"idCardAuth":false,"maxLoanAmount":6000,"mobile":"18600758725","monthRate":1.12,"token":"EWY4A1Ia6t3wNrayk2Je6rfAWA9fqv%2B8ZpJdLAc1Ybg%3D","userId":62790}
     */

    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean {
        /**
         * idCardAuth : false
         * maxLoanAmount : 6000.0
         * mobile : 18600758725
         * monthRate : 1.12
         * token : EWY4A1Ia6t3wNrayk2Je6rfAWA9fqv%2B8ZpJdLAc1Ybg%3D
         * userId : 62790
         */
        private String username;
        private boolean idCardAuth;
        private double maxLoanAmount;
        private String mobile;
        private double monthRate;
        private String token;
        private int userId;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public boolean isIdCardAuth() {
            return idCardAuth;
        }

        public void setIdCardAuth(boolean idCardAuth) {
            this.idCardAuth = idCardAuth;
        }

        public double getMaxLoanAmount() {
            return maxLoanAmount;
        }

        public void setMaxLoanAmount(double maxLoanAmount) {
            this.maxLoanAmount = maxLoanAmount;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public double getMonthRate() {
            return monthRate;
        }

        public void setMonthRate(double monthRate) {
            this.monthRate = monthRate;
        }

        public String getToken() {
            return token;
        }

        public void setToken(String token) {
            this.token = token;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
