package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

/**
 * Author: William Wang
 * Date:   On 2018/12/17
 */
public class MsgBean extends BaseBean {

    /**
     * object : {"total":4}
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
         * total : 4
         */

        @SerializedName("total")
        private int total;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }
    }
}
