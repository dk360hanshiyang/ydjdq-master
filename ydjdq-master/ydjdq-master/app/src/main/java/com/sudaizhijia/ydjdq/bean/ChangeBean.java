package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/20
 */
public class ChangeBean extends BaseBean implements Serializable{


    /**
     * object : {"middleShowList":[{"borrowProduct":{"description":"快速审核极速放款","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":153,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":2,"validateDate":1544673050000,"imgUrl":"1","positionId":42,"recommendWords":"1","title":"1"},{"borrowProduct":{"description":"快速审核极速放款","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":154,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":1,"validateDate":1544673050000},{"borrowProduct":{"description":"快速审核极速放款","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":15,"imgUrl":"1","newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"positionId":42,"productId":1,"recommendWords":"1","sortIndex":2,"title":"1","validateDate":1543921198000},{"borrowProduct":{"description":"快速审核极速放款","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":16,"imgUrl":"1","newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"positionId":41,"productId":2,"recommendWords":"1","sortIndex":1,"title":"1","validateDate":1543921198000}],"hasNext":true}
     */

    @SerializedName("object")
    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable {
        /**
         * middleShowList : [{"borrowProduct":{"description":"快速审核极速放款","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":153,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":2,"validateDate":1544673050000},{"borrowProduct":{"description":"快速审核极速放款","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":154,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":1,"validateDate":1544673050000},{"borrowProduct":{"description":"快速审核极速放款","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":15,"imgUrl":"1","newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"positionId":42,"productId":1,"recommendWords":"1","sortIndex":2,"title":"1","validateDate":1543921198000},{"borrowProduct":{"description":"快速审核极速放款","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":16,"imgUrl":"1","newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"positionId":41,"productId":2,"recommendWords":"1","sortIndex":1,"title":"1","validateDate":1543921198000}]
         * hasNext : true
         */

        @SerializedName("hasNext")
        private boolean hasNext;
        @SerializedName("middleShowList")
        private List<HomeBean.ObjectBean.MiddleBean> middleShowList;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<HomeBean.ObjectBean.MiddleBean> getMiddleShowList() {
            return middleShowList;
        }

        public void setMiddleShowList(List<HomeBean.ObjectBean.MiddleBean> middleShowList) {
            this.middleShowList = middleShowList;
        }
    }

       /* public static class MiddleShowListBean implements Serializable{
            *//**
             * borrowProduct : {"description":"快速审核极速放款","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"}
             * id : 153
             * newLable : 1
             * position : {"value":"必下款","key":"BI_XIA"}
             * productId : 12
             * sortIndex : 2
             * validateDate : 1544673050000
             * imgUrl : 1
             * positionId : 42
             * recommendWords : 1
             * title : 1
             *//*

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
            @SerializedName("validateDate")
            private long validateDate;
            @SerializedName("imgUrl")
            private String imgUrl;
            @SerializedName("positionId")
            private int positionId;
            @SerializedName("recommendWords")
            private String recommendWords;
            @SerializedName("title")
            private String title;

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

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public int getPositionId() {
                return positionId;
            }

            public void setPositionId(int positionId) {
                this.positionId = positionId;
            }

            public String getRecommendWords() {
                return recommendWords;
            }

            public void setRecommendWords(String recommendWords) {
                this.recommendWords = recommendWords;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public static class BorrowProductBean implements Serializable{
                *//**
                 * description : 快速审核极速放款
                 * id : 12
                 * linkedUrl : http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj
                 * logoUrl : http://4.pic.paopaoche.net/up/2018-5/2018513101656.png
                 * maxAmount : 5000.0
                 * name : 钱周周
                 *//*

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
                *//**
                 * value : 必下款
                 * key : BI_XIA
                 *//*

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
    }*/
}
