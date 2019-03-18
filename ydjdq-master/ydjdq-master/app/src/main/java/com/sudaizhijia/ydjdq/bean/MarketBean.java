package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/13
 */
public class MarketBean extends BaseBean implements Serializable
{


    /**
     * object : {"hasNext":true,"daQuanShowList":[{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":15,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":1,"sortIndex":1},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":19,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":12,"sortIndex":1},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":154,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":1},{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":23,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":9,"sortIndex":1},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":27,"newLable":1,"position":{"value":"浮窗","key":"OVERLAYS"},"productId":3,"sortIndex":1},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":28,"newLable":1,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":1},{"borrowProduct":{"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":16,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":2,"sortIndex":2},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":153,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":2},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":20,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"sortIndex":2},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":24,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":10,"sortIndex":2},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":29,"newLable":1,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":2},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":17,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":3,"sortIndex":3},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":21,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"sortIndex":3},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":25,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":1,"sortIndex":3},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":152,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":3}]}
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
         * hasNext : true
         * daQuanShowList : [{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":15,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":1,"sortIndex":1},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":19,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":12,"sortIndex":1},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":154,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":1},{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":23,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":9,"sortIndex":1},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":27,"newLable":1,"position":{"value":"浮窗","key":"OVERLAYS"},"productId":3,"sortIndex":1},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":28,"newLable":1,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":1},{"borrowProduct":{"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":16,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":2,"sortIndex":2},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":153,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":2},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":20,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"sortIndex":2},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":24,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":10,"sortIndex":2},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":29,"newLable":1,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":2},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":17,"newLable":1,"position":{"value":"banner推荐","key":"BANNER"},"productId":3,"sortIndex":3},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":21,"newLable":1,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"sortIndex":3},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":25,"newLable":1,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":1,"sortIndex":3},{"borrowProduct":{"description":"sssss","id":12,"linkedUrl":"http://api.qianzhouzhou.com/app/v1/anon/h5/page?channel=zjkj","logoUrl":"http://4.pic.paopaoche.net/up/2018-5/2018513101656.png","maxAmount":5000,"name":"钱周周"},"id":152,"newLable":1,"position":{"value":"必下款","key":"BI_XIA"},"productId":12,"sortIndex":3}]
         */

        @SerializedName("hasNext")
        private boolean hasNext;
        @SerializedName("daQuanShowList")
        private List<DaQuanShowListBean> daQuanShowList;

        public boolean isHasNext() {
            return hasNext;
        }

        public void setHasNext(boolean hasNext) {
            this.hasNext = hasNext;
        }

        public List<DaQuanShowListBean> getDaQuanShowList() {
            return daQuanShowList;
        }

        public void setDaQuanShowList(List<DaQuanShowListBean> daQuanShowList) {
            this.daQuanShowList = daQuanShowList;
        }

        public static class DaQuanShowListBean implements Serializable{
            /**
             * borrowProduct : {"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"}
             * id : 15
             * newLable : 1
             * position : {"value":"banner推荐","key":"BANNER"}
             * productId : 1
             * sortIndex : 1
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
                 * description : 测试描述0
                 * id : 1
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg
                 * maxAmount : 3000.0
                 * name : 测试产品0
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
    }
}
