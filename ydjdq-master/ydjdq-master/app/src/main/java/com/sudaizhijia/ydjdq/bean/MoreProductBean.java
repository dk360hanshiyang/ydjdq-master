package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/8
 */
public class MoreProductBean extends BaseBean implements Serializable{


    @SerializedName("object")
    private List<ObjectBean> object;

    public List<ObjectBean> getObject() {
        return object;
    }

    public void setObject(List<ObjectBean> object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable{
        /**
         * borrowProduct : {"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"}
         * id : 37
         * newLable : 1
         * position : {"value":"新口子","key":"XIN_KOU_ZI"}
         * productId : 3
         * sortIndex : 10
         */

        @SerializedName("borrowProduct")
        private BorrowProductBean borrowProduct;
        @SerializedName("id")
        private int id;
        @SerializedName("newLable")
        private int newLable;
        @SerializedName("position")
        private PositionBean position;
        @SerializedName("productId")
        private int productId;
        @SerializedName("sortIndex")
        private int sortIndex;

        public BorrowProductBean getBorrowProduct() {
            return borrowProduct;
        }

        public void setBorrowProduct(BorrowProductBean borrowProduct) {
            this.borrowProduct = borrowProduct;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNewLable() {
            return newLable;
        }

        public void setNewLable(int newLable) {
            this.newLable = newLable;
        }

        public PositionBean getPosition() {
            return position;
        }

        public void setPosition(PositionBean position) {
            this.position = position;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getSortIndex() {
            return sortIndex;
        }

        public void setSortIndex(int sortIndex) {
            this.sortIndex = sortIndex;
        }

        public static class BorrowProductBean implements Serializable{
            /**
             * description : 测试描述2
             * id : 3
             * linkedUrl : https://www.baidu.com/
             * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png
             * maxAmount : 3000.0
             * name : 测试产品2
             */

            @SerializedName("description")
            private String description;
            @SerializedName("id")
            private int id;
            @SerializedName("linkedUrl")
            private String linkedUrl;
            @SerializedName("logoUrl")
            private String logoUrl;
            @SerializedName("maxAmount")
            private double maxAmount;
            @SerializedName("name")
            private String name;
            @SerializedName("linkedUrlTwo")
            private String linkedUrlTwo;

            public String getLinkedUrlTwo() {
                return linkedUrlTwo;
            }

            public void setLinkedUrlTwo(String linkedUrlTwo) {
                this.linkedUrlTwo = linkedUrlTwo;
            }
            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getLinkedUrl() {
                return linkedUrl;
            }

            public void setLinkedUrl(String linkedUrl) {
                this.linkedUrl = linkedUrl;
            }

            public String getLogoUrl() {
                return logoUrl;
            }

            public void setLogoUrl(String logoUrl) {
                this.logoUrl = logoUrl;
            }

            public double getMaxAmount() {
                return maxAmount;
            }

            public void setMaxAmount(double maxAmount) {
                this.maxAmount = maxAmount;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class PositionBean implements Serializable{
            /**
             * value : 新口子
             * key : XIN_KOU_ZI
             */

            @SerializedName("value")
            private String value;
            @SerializedName("key")
            private String key;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public String getKey() {
                return key;
            }

            public void setKey(String key) {
                this.key = key;
            }
        }
    }
}
