package com.sudaizhijia.ydjdq.bean;

import java.io.Serializable;

/**
 * Author: William Wang
 * Date:   On 2018/12/20
 */
public class MustProductBean extends BaseBean implements Serializable {
    /**
     * newLable : 1
     * sortIndex : 1
     * title :
     * validateDate : 1550642400000
     * id : 19214
     * borrowProduct : {"description":"10分钟审核 急速放款","linkedUrl":"http://year.yomill.cn/ajax/reg?x=ppd00291","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/daiguonian/daiguonian.png","name":"贷过年","id":1183,"maxAmount":3000}
     * productId : 1183
     * positionId : 73
     * position : BI_XIA
     */

    private int newLable;
    private int sortIndex;
    private String title;
    private long validateDate;
    private int id;
    private String showType;
    private BorrowProductBean borrowProduct;
    private int productId;
    private int positionId;
    private String position;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public int getNewLable() {
        return newLable;
    }

    public void setNewLable(int newLable) {
        this.newLable = newLable;
    }

    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getValidateDate() {
        return validateDate;
    }

    public void setValidateDate(long validateDate) {
        this.validateDate = validateDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BorrowProductBean getBorrowProduct() {
        return borrowProduct;
    }

    public void setBorrowProduct(BorrowProductBean borrowProduct) {
        this.borrowProduct = borrowProduct;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public static class BorrowProductBean implements Serializable{
        /**
         * description : 10分钟审核 急速放款
         * linkedUrl : http://year.yomill.cn/ajax/reg?x=ppd00291
         * logoUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/daiguonian/daiguonian.png
         * name : 贷过年
         * id : 1183
         * maxAmount : 3000
         */

        private String description;
        private String linkedUrl;
        private String logoUrl;
        private String name;
        private int id;
        private int maxAmount;
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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getMaxAmount() {
            return maxAmount;
        }

        public void setMaxAmount(int maxAmount) {
            this.maxAmount = maxAmount;
        }
    }
    //todo





//    /**
//     * borrowProduct : {"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"}
//     * id : 150
//     * newLable : 1
//     * position : {"value":"必下款","key":"BI_XIA"}
//     * productId : 12
//     * sortIndex : 5
//     * validateDate : 1544673050000
//     */
//
//    @SerializedName("borrowProduct")
//    private BorrowProductBean borrowProduct;
//    @SerializedName("id")
//    private int id;
//    @SerializedName("newLable")
//    private int newLable;
//    @SerializedName("position")
//    private PositionBean position;
//    @SerializedName("productId")
//    private int productId;
//    @SerializedName("sortIndex")
//    private int sortIndex;
//    @SerializedName("validateDate")
//    private long validateDate;
//
//    public BorrowProductBean getBorrowProduct() {
//        return borrowProduct;
//    }
//
//    public void setBorrowProduct(BorrowProductBean borrowProduct) {
//        this.borrowProduct = borrowProduct;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public int getNewLable() {
//        return newLable;
//    }
//
//    public void setNewLable(int newLable) {
//        this.newLable = newLable;
//    }
//
//    public PositionBean getPosition() {
//        return position;
//    }
//
//    public void setPosition(PositionBean position) {
//        this.position = position;
//    }
//
//    public int getProductId() {
//        return productId;
//    }
//
//    public void setProductId(int productId) {
//        this.productId = productId;
//    }
//
//    public int getSortIndex() {
//        return sortIndex;
//    }
//
//    public void setSortIndex(int sortIndex) {
//        this.sortIndex = sortIndex;
//    }
//
//    public long getValidateDate() {
//        return validateDate;
//    }
//
//    public void setValidateDate(long validateDate) {
//        this.validateDate = validateDate;
//    }
//
//    public static class BorrowProductBean implements Serializable {
//        /**
//         * description : sssss
//         * id : 12
//         * linkedUrl : http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj
//         * logoUrl : http://4.pic.paopaoche.net/up/2018-5/2018513101656.png
//         * maxAmount : 5000
//         * name : 钱周周
//         */
//
//        @SerializedName("description")
//        private String description;
//        @SerializedName("id")
//        private int id;
//        @SerializedName("linkedUrl")
//        private String linkedUrl;
//        @SerializedName("logoUrl")
//        private String logoUrl;
//        @SerializedName("maxAmount")
//        private int maxAmount;
//        @SerializedName("name")
//        private String name;
//
//        public String getDescription() {
//            return description;
//        }
//
//        public void setDescription(String description) {
//            this.description = description;
//        }
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public String getLinkedUrl() {
//            return linkedUrl;
//        }
//
//        public void setLinkedUrl(String linkedUrl) {
//            this.linkedUrl = linkedUrl;
//        }
//
//        public String getLogoUrl() {
//            return logoUrl;
//        }
//
//        public void setLogoUrl(String logoUrl) {
//            this.logoUrl = logoUrl;
//        }
//
//        public int getMaxAmount() {
//            return maxAmount;
//        }
//
//        public void setMaxAmount(int maxAmount) {
//            this.maxAmount = maxAmount;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//    }
//
//    public static class PositionBean implements Serializable {
//        /**
//         * value : 必下款
//         * key : BI_XIA
//         */
//
//        @SerializedName("value")
//        private String value;
//        @SerializedName("key")
//        private String key;
//
//        public String getValue() {
//            return value;
//        }
//
//        public void setValue(String value) {
//            this.value = value;
//        }
//
//        public String getKey() {
//            return key;
//        }
//
//        public void setKey(String key) {
//            this.key = key;
//        }
//    }
}
