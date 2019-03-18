package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/8
 */
public class MessageBean extends BaseBean implements Serializable{


    /**
     * object : {"lastOpenTime":1544864406548,"messageList":[{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":63,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":9,"recommendWords":"再次推荐","sortIndex":2,"title":"1","validateDate":1543921203000},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":64,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":10,"recommendWords":"再次推荐","sortIndex":3,"title":"1","validateDate":1543921203000},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":65,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":1,"recommendWords":"再次推荐","sortIndex":4,"title":"1","validateDate":1543921203000}],"total":4}
     */

    @SerializedName("object")
    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable{
        /**
         * lastOpenTime : 1544864406548
         * messageList : [{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":63,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":9,"recommendWords":"再次推荐","sortIndex":2,"title":"1","validateDate":1543921203000},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":64,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":10,"recommendWords":"再次推荐","sortIndex":3,"title":"1","validateDate":1543921203000},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":65,"imgUrl":"https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg","newLable":1,"position":{"value":"消息推荐列表","key":"MESSAGE_LIST"},"productId":1,"recommendWords":"再次推荐","sortIndex":4,"title":"1","validateDate":1543921203000}]
         * total : 4
         */

        @SerializedName("lastOpenTime")
        private long lastOpenTime;
        @SerializedName("total")
        private int total;
        @SerializedName("messageList")
        private List<MessageListBean> messageList;

        public long getLastOpenTime() {
            return lastOpenTime;
        }

        public void setLastOpenTime(long lastOpenTime) {
            this.lastOpenTime = lastOpenTime;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<MessageListBean> getMessageList() {
            return messageList;
        }

        public void setMessageList(List<MessageListBean> messageList) {
            this.messageList = messageList;
        }

        public static class MessageListBean implements Serializable{
            /**
             * borrowProduct : {"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"}
             * id : 63
             * imgUrl : https://img1.doubanio.com/view/photo/l/public/p2459658549.jpg
             * newLable : 1
             * position : {"value":"消息推荐列表","key":"MESSAGE_LIST"}
             * productId : 9
             * recommendWords : 再次推荐
             * sortIndex : 2
             * title : 1
             * validateDate : 1543921203000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBean borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("imgUrl")
            private String imgUrl;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBean position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("recommendWords")
            private String recommendWords;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("title")
            private String title;
            @SerializedName("validateDate")
            private long validateDate;

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

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
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

            public String getRecommendWords() {
                return recommendWords;
            }

            public void setRecommendWords(String recommendWords) {
                this.recommendWords = recommendWords;
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

            public static class BorrowProductBean implements Serializable{
                /**
                 * description : 测试描述8
                 * id : 9
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png
                 * maxAmount : 3000
                 * name : 测试产品8
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
                private int maxAmount;
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

                public int getMaxAmount() {
                    return maxAmount;
                }

                public void setMaxAmount(int maxAmount) {
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
                 * value : 消息推荐列表
                 * key : MESSAGE_LIST
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
}
