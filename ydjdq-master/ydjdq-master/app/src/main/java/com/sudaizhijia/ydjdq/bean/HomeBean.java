package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/4
 */
public class HomeBean extends BaseBean implements Serializable {


    @SerializedName("object")
    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable {


        @SerializedName("countDown")
        private int countDown;
        @SerializedName("newComeNum")
        private int newComeNum;
        @SerializedName("shareUrl")
        private String shareUrl;
        @SerializedName("banner")
        private List<BannerBean> banner;
        @SerializedName("downLoadPreview")
        private List<DownLoadPreview> downLoadPreview;
        @SerializedName("list")
        private List<ListBean> list;
        @SerializedName("middle")
        private List<MiddleBean> middle;
        @SerializedName("overlays")
        private List<OverlaysBean> overlays;
        @SerializedName("popUp")
        private List<PopupBean> popUp;
        @SerializedName("paymentReport")
        private List<PaymentReportBean> paymentReport;
        @SerializedName("top")
        private List<TopBean> top;
        @SerializedName("xinKouzi")
        private List<XinKouziBean> xinKouzi;
        @SerializedName("isMock")
        private int isMock;
        @SerializedName("mockUrl")
        private String mockUrl;

//        @SerializedName("xinKouzi")
//        private List<XinKouziBean> xinKouzi;


        public List<DownLoadPreview> getDownLoadPreview() {
            return downLoadPreview;
        }

        public void setDownLoadPreview(List<DownLoadPreview> downLoadPreview) {
            this.downLoadPreview = downLoadPreview;
        }

        public List<PopupBean> getPopUp() {
            return popUp;
        }

        public void setPopUp(List<PopupBean> popUp) {
            this.popUp = popUp;
        }

        @Override
        public String toString() {
            return "ObjectBean{" +
                    "countDown=" + countDown +
                    ", newComeNum=" + newComeNum +
                    ", shareUrl='" + shareUrl + '\'' +
                    ", banner=" + banner +
                    ", list=" + list +
                    ", middle=" + middle +
                    ", overlays=" + overlays +
                    ", popUp=" + popUp +
                    ", paymentReport=" + paymentReport +
                    ", top=" + top +
                    ", xinKouzi=" + xinKouzi +
                    ", isMock=" + isMock +
                    ", mockUrl='" + mockUrl + '\'' +
                    ", popUp=" + popUp +
                    '}';
        }

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public int getIsMock() {
            return isMock;
        }

        public void setIsMock(int isMock) {
            this.isMock = isMock;
        }

        public String getMockUrl() {
            return mockUrl;
        }

        public void setMockUrl(String mockUrl) {
            this.mockUrl = mockUrl;
        }

        public int getCountDown() {
            return countDown;
        }

        public void setCountDown(int countDown) {
            this.countDown = countDown;
        }

        public int getNewComeNum() {
            return newComeNum;
        }

        public void setNewComeNum(int newComeNum) {
            this.newComeNum = newComeNum;
        }

        public List<BannerBean> getBanner() {
            return banner;
        }

        public void setBanner(List<BannerBean> banner) {
            this.banner = banner;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public List<MiddleBean> getMiddle() {
            return middle;
        }

        public void setMiddle(List<MiddleBean> middle) {
            this.middle = middle;
        }

        public List<OverlaysBean> getOverlays() {
            return overlays;
        }

        public void setOverlays(List<OverlaysBean> overlays) {
            this.overlays = overlays;
        }

        public List<PaymentReportBean> getPaymentReport() {
            return paymentReport;
        }

        public void setPaymentReport(List<PaymentReportBean> paymentReport) {
            this.paymentReport = paymentReport;
        }

        public List<TopBean> getTop() {
            return top;
        }

        public void setTop(List<TopBean> top) {
            this.top = top;
        }

        public List<XinKouziBean> getXinKouzi() {
            return xinKouzi;
        }

        public void setXinKouzi(List<XinKouziBean> xinKouzi) {
            this.xinKouzi = xinKouzi;
        }

        public static class BannerBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"}
             * id : 16
             * imgUrl : 1
             * newLable : 1
             * position : {"value":"banner推荐","key":"BANNER"}
             * positionId : 41
             * productId : 2
             * recommendWords : 1
             * sortIndex : 1
             * title : 1
             * validateDate : 1543921198000
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
            @SerializedName("positionId")
            private int positionId;
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

            public static class BorrowProductBean implements Serializable {
                /**
                 * description : 测试描述1
                 * id : 2
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png
                 * maxAmount : 3000.0
                 * name : 测试产品1
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

            public static class PositionBean implements Serializable {
                /**
                 * value : banner推荐
                 * key : BANNER
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

        public static class PopupBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"}
             * id : 16
             * imgUrl : 1
             * newLable : 1
             * position : {"value":"banner推荐","key":"BANNER"}
             * positionId : 41
             * productId : 2
             * recommendWords : 1
             * sortIndex : 1
             * title : 1
             * validateDate : 1543921198000
             */

            @SerializedName("borrowProduct")
            private PupUpBorrowProductBean pupUpBorrowProductBean;
            @SerializedName("id")
            private int id;
            @SerializedName("imgUrl")
            private String imgUrl;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBean position;
            @SerializedName("positionId")
            private int positionId;
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

            public PupUpBorrowProductBean getPupUpBorrowProductBean() {
                return pupUpBorrowProductBean;
            }

            public void setPupUpBorrowProductBean(PupUpBorrowProductBean pupUpBorrowProductBean) {
                this.pupUpBorrowProductBean = pupUpBorrowProductBean;
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

            public static class BorrowProductBean implements Serializable {
                /**
                 * description : 测试描述1
                 * id : 2
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png
                 * maxAmount : 3000.0
                 * name : 测试产品1
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

            public static class PupUpBorrowProductBean implements Serializable {
                /**
                 * description : 测试描述1
                 * id : 2
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png
                 * maxAmount : 3000.0
                 * name : 测试产品1
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

            public static class PositionBean implements Serializable {
                /**
                 * value : banner推荐
                 * key : BANNER
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

        public static class DownLoadPreview implements Serializable {
            /**
             * borrowProduct : {"description":"快速审核极速放款","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"}
             * id : 28
             * newLable : 1
             * position : {"value":"首页推荐","key":"INDEX_LIST"}
             * productId : 4
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductDown borrowProductDown;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanX position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;

            public BorrowProductDown getBorrowProductDown() {
                return borrowProductDown;
            }

            public void setBorrowProductDown(BorrowProductDown borrowProductDown) {
                this.borrowProductDown = borrowProductDown;
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

            public PositionBeanX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanX position) {
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

            public static class BorrowProductBeanX implements Serializable {
                /**
                 * description : 快速审核极速放款
                 * id : 4
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png
                 * maxAmount : 3000.0
                 * name : 测试产品3
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

            public static class BorrowProductDown implements Serializable {
                /**
                 * description : 快速审核极速放款
                 * id : 4
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png
                 * maxAmount : 3000.0
                 * name : 测试产品3
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

            public static class PositionBeanX implements Serializable {
                /**
                 * value : 首页推荐
                 * key : INDEX_LIST
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

        public static class ListBean implements Serializable {
            /**
             * borrowProduct : {"description":"快速审核极速放款","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"}
             * id : 28
             * newLable : 1
             * position : {"value":"首页推荐","key":"INDEX_LIST"}
             * productId : 4
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanX position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;

            public BorrowProductBeanX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanX borrowProduct) {
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

            public PositionBeanX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanX position) {
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

            public static class BorrowProductBeanX implements Serializable {
                /**
                 * description : 快速审核极速放款
                 * id : 4
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png
                 * maxAmount : 3000.0
                 * name : 测试产品3
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

            public static class PositionBeanX implements Serializable {
                /**
                 * value : 首页推荐
                 * key : INDEX_LIST
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

        public static class MiddleBean extends BaseBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"}
             * id : 23
             * newLable : 1
             * position : {"value":"中层推荐","key":"MIDDLE"}
             * productId : 9
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanXX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanXX position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;

            public BorrowProductBeanXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXX borrowProduct) {
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

            public PositionBeanXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXX position) {
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

            public static class BorrowProductBeanXX implements Serializable {
                /**
                 * description : 测试描述8
                 * id : 9
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png
                 * maxAmount : 3000.0
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

            public static class PositionBeanXX implements Serializable {
                /**
                 * value : 中层推荐
                 * key : MIDDLE
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

        public static class OverlaysBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"}
             * id : 27
             * newLable : 1
             * position : {"value":"浮窗","key":"OVERLAYS"}
             * productId : 3
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanXXX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanXXX position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;
            @SerializedName("imgUrl")
            private String imgUrl;

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public BorrowProductBeanXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXX borrowProduct) {
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

            public PositionBeanXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXX position) {
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

            public static class BorrowProductBeanXXX implements Serializable {
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

            public static class PositionBeanXXX implements Serializable {
                /**
                 * value : 浮窗
                 * key : OVERLAYS
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

        public static class PaymentReportBean implements Serializable {
            /**
             * borrowProduct : {"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"}
             * id : 19
             * newLable : 1
             * position : {"value":"顶层推荐","key":"TOP"}
             * positionId : 4
             * productId : 12
             * remark : 用户135****3088获得2000元下款
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanXXXX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanXXXX position;
            @SerializedName("positionId")
            private int positionId;
            @SerializedName("productId")
            private int productId;
            @SerializedName("remark")
            private String remark;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;

            public BorrowProductBeanXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXX borrowProduct) {
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

            public PositionBeanXXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXXX position) {
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

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
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

            public static class BorrowProductBeanXXXX implements Serializable {
                /**
                 * description : sssss
                 * id : 12
                 * linkedUrl : http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj
                 * logoUrl : http://4.pic.paopaoche.net/up/2018-5/2018513101656.png
                 * maxAmount : 5000.0
                 * name : 钱周周
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

            public static class PositionBeanXXXX implements Serializable {
                /**
                 * value : 顶层推荐
                 * key : TOP
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

        public static class TopBean implements Serializable {
            /**
             * borrowProduct : {"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"}
             * id : 19
             * newLable : 1
             * position : {"value":"顶层推荐","key":"TOP"}
             * positionId : 4
             * productId : 12
             * sortIndex : 1
             * validateDate : 1543921199000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanXXXXX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanXXXXX position;
            @SerializedName("positionId")
            private int positionId;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;
            @SerializedName("title")
            private String title;
            @SerializedName("imgUrl")
            private String imgUrl;
            @SerializedName("showType")
            private String showType;

            public String getShowType() {
                return showType;
            }

            public void setShowType(String showType) {
                this.showType = showType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getImgUrl() {
                return imgUrl;
            }

            public void setImgUrl(String imgUrl) {
                this.imgUrl = imgUrl;
            }

            public BorrowProductBeanXXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXXX borrowProduct) {
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

            public PositionBeanXXXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXXXX position) {
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

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBeanXXXXX implements Serializable {
                /**
                 * description : sssss
                 * id : 12
                 * linkedUrl : http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj
                 * logoUrl : http://4.pic.paopaoche.net/up/2018-5/2018513101656.png
                 * maxAmount : 5000.0
                 * name : 钱周周
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

            public static class PositionBeanXXXXX implements Serializable {
                /**
                 * value : 顶层推荐
                 * key : TOP
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

        public static class XinKouziBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"}
             * id : 37
             * newLable : 1
             * position : {"value":"新口子","key":"XIN_KOU_ZI"}
             * productId : 3
             * sortIndex : 1
             * validateDate : 1543921200000
             */

            @SerializedName("borrowProduct")
            private BorrowProductBeanXXXXXX borrowProduct;
            @SerializedName("id")
            private int id;
            @SerializedName("newLable")
            private int newLable;
            @SerializedName("position")
            private PositionBeanXXXXXX position;
            @SerializedName("productId")
            private int productId;
            @SerializedName("sortIndex")
            private int sortIndex;
            @SerializedName("validateDate")
            private long validateDate;

            public BorrowProductBeanXXXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXXXX borrowProduct) {
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

            public PositionBeanXXXXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXXXXX position) {
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

            public static class BorrowProductBeanXXXXXX implements Serializable {
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

            public static class PositionBeanXXXXXX implements Serializable {
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
}