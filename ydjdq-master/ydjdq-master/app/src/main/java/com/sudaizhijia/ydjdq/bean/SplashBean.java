package com.sudaizhijia.ydjdq.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/14
 */
public class SplashBean extends BaseBean implements Serializable{


    /**
     * object : {"FOURCE_REDIRECT":"true","productList":[{"borrowProduct":{"description":"1分钟放款","id":1232,"linkedUrl":"http://wonderpurse.minfujr.cn/h5/register/register_hmg.html?invent_id=&amp;channel_id=diandianqianbao","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/miaoshouqiandai/miaoshou.png","maxAmount":5000,"name":"妙手钱袋"},"id":19655,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/miaoshouqiandai/YllxMnFzJZOpfJk_1597511413.png","newLable":1,"position":{"value":"开屏页推荐","key":"START_PAGE"},"positionId":1682,"productId":1232,"sortIndex":1,"title":"","validateDate":1552269600000}]}
     */

    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable{
        /**
         * FOURCE_REDIRECT : true
         * productList : [{"borrowProduct":{"description":"1分钟放款","id":1232,"linkedUrl":"http://wonderpurse.minfujr.cn/h5/register/register_hmg.html?invent_id=&amp;channel_id=diandianqianbao","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/miaoshouqiandai/miaoshou.png","maxAmount":5000,"name":"妙手钱袋"},"id":19655,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/miaoshouqiandai/YllxMnFzJZOpfJk_1597511413.png","newLable":1,"position":{"value":"开屏页推荐","key":"START_PAGE"},"positionId":1682,"productId":1232,"sortIndex":1,"title":"","validateDate":1552269600000}]
         */

        private String FOURCE_REDIRECT;
        private List<ProductListBean> productList;

        public String getFOURCE_REDIRECT() {
            return FOURCE_REDIRECT;
        }

        public void setFOURCE_REDIRECT(String FOURCE_REDIRECT) {
            this.FOURCE_REDIRECT = FOURCE_REDIRECT;
        }

        public List<ProductListBean> getProductList() {
            return productList;
        }

        public void setProductList(List<ProductListBean> productList) {
            this.productList = productList;
        }

        public static class ProductListBean implements Serializable{
            /**
             * borrowProduct : {"description":"1分钟放款","id":1232,"linkedUrl":"http://wonderpurse.minfujr.cn/h5/register/register_hmg.html?invent_id=&amp;channel_id=diandianqianbao","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/miaoshouqiandai/miaoshou.png","maxAmount":5000,"name":"妙手钱袋"}
             * id : 19655
             * imgUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/miaoshouqiandai/YllxMnFzJZOpfJk_1597511413.png
             * newLable : 1
             * position : {"value":"开屏页推荐","key":"START_PAGE"}
             * positionId : 1682
             * productId : 1232
             * sortIndex : 1
             * title :
             * validateDate : 1552269600000
             */

            private BorrowProductBean borrowProduct;
            private int id;
            private String imgUrl;
            private int newLable;
            private PositionBean position;
            private int positionId;
            private int productId;
            private int sortIndex;
            private String title;
            private long validateDate;
            private String showType;

            public String getShowType() {
                return showType;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

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

            public int getPositionId() {
                return positionId;
            }

            public void setPositionId(int positionId) {
                this.positionId = positionId;
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
                 * description : 1分钟放款
                 * id : 1232
                 * linkedUrl : http://wonderpurse.minfujr.cn/h5/register/register_hmg.html?invent_id=&amp;channel_id=diandianqianbao
                 * logoUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/miaoshouqiandai/miaoshou.png
                 * maxAmount : 5000
                 * name : 妙手钱袋
                 */

                private String description;
                private int id;
                private String linkedUrl;
                private String logoUrl;
                private int maxAmount;
                private String name;
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
                 * value : 开屏页推荐
                 * key : START_PAGE
                 */

                private String value;
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
