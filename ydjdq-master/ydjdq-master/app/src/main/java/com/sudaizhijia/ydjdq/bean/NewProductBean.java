package com.sudaizhijia.ydjdq.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;
import com.sudaizhijia.ydjdq.global.CusConstants;

import java.io.Serializable;
import java.util.List;

public class NewProductBean extends BaseBean implements Serializable{


    @SerializedName("object")
    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable{
        @SerializedName("totalCount")
        private int totalCount;
        @SerializedName("leftCount")
        private int leftCount;
        @SerializedName("tomorrowList")
        private List<TomorrowListBean> tomorrowList;
        @SerializedName("todayNewList")
        private List<TodayNewListBean> todayNewList;
        @SerializedName("pastDayList")
        private List<PastDayListBean> pastDayList;

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getLeftCount() {
            return leftCount;
        }

        public void setLeftCount(int leftCount) {
            this.leftCount = leftCount;
        }

        public List<TomorrowListBean> getTomorrowList() {
            return tomorrowList;
        }

        public void setTomorrowList(List<TomorrowListBean> tomorrowList) {
            this.tomorrowList = tomorrowList;
        }

        public List<TodayNewListBean> getTodayNewList() {
            return todayNewList;
        }

        public void setTodayNewList(List<TodayNewListBean> todayNewList) {
            this.todayNewList = todayNewList;
        }

        public List<PastDayListBean> getPastDayList() {
            return pastDayList;
        }

        public void setPastDayList(List<PastDayListBean> pastDayList) {
            this.pastDayList = pastDayList;
        }

        public static class TomorrowListBean implements Serializable{

            @SerializedName("countDown")
            private int countDown;
            @SerializedName("onFocus")
            private boolean onFocus;
            @SerializedName("title")
            private String title;
            @SerializedName("productShowList")
            private List<ProductShowListBean> productShowList;

            public int getCountDown() {
                return countDown;
            }

            public void setCountDown(int countDown) {
                this.countDown = countDown;
            }

            public boolean isOnFocus() {
                return onFocus;
            }

            public void setOnFocus(boolean onFocus) {
                this.onFocus = onFocus;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProductShowListBean> getProductShowList() {
                return productShowList;
            }

            public void setProductShowList(List<ProductShowListBean> productShowList) {
                this.productShowList = productShowList;
            }

            public static class ProductShowListBean implements Serializable,MultiItemEntity{
                /**
                 * borrowProduct : {"description":"****","logoUrl":"https://i1.hoopchina.com.cn/user/default_big.jpg","name":"****"}
                 */

                @SerializedName("borrowProduct")
                private BorrowProductBean borrowProduct;

                public BorrowProductBean getBorrowProduct() {
                    return borrowProduct;
                }

                public void setBorrowProduct(BorrowProductBean borrowProduct) {
                    this.borrowProduct = borrowProduct;
                }

                @Override
                public int getItemType() {
                    return CusConstants.TYPE_AFTER;
                }

                public static class BorrowProductBean implements Serializable{
                    /**
                     * description : ****
                     * logoUrl : https://i1.hoopchina.com.cn/user/default_big.jpg
                     * name : ****
                     */
                    private int newLable;
                    @SerializedName("description")
                    private String description;
                    @SerializedName("logoUrl")
                    private String logoUrl;
                    @SerializedName("name")
                    private String name;
                    @SerializedName("maxAmount")
                    private double maxAmount;
                    @SerializedName("linkedUrlTwo")
                    private String linkedUrlTwo;

                    public String getLinkedUrlTwo() {
                        return linkedUrlTwo;
                    }

                    public void setLinkedUrlTwo(String linkedUrlTwo) {
                        this.linkedUrlTwo = linkedUrlTwo;
                    }
                    public double getMaxAmount() {
                        return maxAmount;
                    }

                    public void setMaxAmount(double maxAmount) {
                        this.maxAmount = maxAmount;
                    }

                    public int getNewLable() {
                        return newLable;
                    }

                    public void setNewLable(int newLable) {
                        this.newLable = newLable;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
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
                }
            }
        }

        public static class TodayNewListBean implements Serializable{


            @SerializedName("countDown")
            private int countDown;
            @SerializedName("onFocus")
            private boolean onFocus;
            @SerializedName("title")
            private String title;
            @SerializedName("spread")
            private boolean spread;
            @SerializedName("productShowList")
            private List<ProductShowListBeanX> productShowList;

            public boolean isSpread() {
                return spread;
            }

            public void setSpread(boolean spread) {
                this.spread = spread;
            }

            @Override
            public String toString() {
                return "TodayNewListBean{" +
                        "countDown=" + countDown +
                        ", onFocus=" + onFocus +
                        ", title='" + title + '\'' +
                        ", spread=" + spread +
                        ", productShowList=" + productShowList +
                        '}';
            }

            public int getCountDown() {
                return countDown;
            }

            public void setCountDown(int countDown) {
                this.countDown = countDown;
            }

            public boolean isOnFocus() {
                return onFocus;
            }

            public void setOnFocus(boolean onFocus) {
                this.onFocus = onFocus;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProductShowListBeanX> getProductShowList() {
                return productShowList;
            }

            public void setProductShowList(List<ProductShowListBeanX> productShowList) {
                this.productShowList = productShowList;
            }

            public static class ProductShowListBeanX implements Serializable,MultiItemEntity{


                @SerializedName("borrowProduct")
                private BorrowProductBeanX borrowProduct;
                @SerializedName("id")
                private int id;
                @SerializedName("position")
                private PositionBean position;
                @SerializedName("productId")
                private int productId;
                @SerializedName("sortIndex")
                private int sortIndex;

                @Override
                public String toString() {
                    return "ProductShowListBeanX{" +
                            "borrowProduct=" + borrowProduct +
                            ", id=" + id +
                            ", position=" + position +
                            ", productId=" + productId +
                            ", sortIndex=" + sortIndex +
                            '}';
                }

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

                @Override
                public int getItemType() {
                    return CusConstants.TYPE_NEWPRODUCT;
                }

                public static class BorrowProductBeanX implements Serializable{

                    private int newLable;
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

                    @Override
                    public String toString() {
                        return "BorrowProductBeanX{" +
                                "newLable=" + newLable +
                                ", description='" + description + '\'' +
                                ", id=" + id +
                                ", linkedUrl='" + linkedUrl + '\'' +
                                ", logoUrl='" + logoUrl + '\'' +
                                ", maxAmount=" + maxAmount +
                                ", name='" + name + '\'' +
                                ", linkedUrlTwo='" + linkedUrlTwo + '\'' +
                                '}';
                    }

                    public String getLinkedUrlTwo() {
                        return linkedUrlTwo;
                    }

                    public void setLinkedUrlTwo(String linkedUrlTwo) {
                        this.linkedUrlTwo = linkedUrlTwo;
                    }

                    public int getNewLable() {
                        return newLable;
                    }

                    public void setNewLable(int newLable) {
                        this.newLable = newLable;
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
        }

        public static class PastDayListBean implements Serializable{

            @SerializedName("countDown")
            private int countDown;
            @SerializedName("onFocus")
            private boolean onFocus;
            @SerializedName("title")
            private String title;
            @SerializedName("productShowList")
            private List<ProductShowListBeanXX> productShowList;

            public int getCountDown() {
                return countDown;
            }

            public void setCountDown(int countDown) {
                this.countDown = countDown;
            }

            public boolean isOnFocus() {
                return onFocus;
            }

            public void setOnFocus(boolean onFocus) {
                this.onFocus = onFocus;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public List<ProductShowListBeanXX> getProductShowList() {
                return productShowList;
            }

            public void setProductShowList(List<ProductShowListBeanXX> productShowList) {
                this.productShowList = productShowList;
            }

            public static class ProductShowListBeanXX implements Serializable{


                @SerializedName("borrowProduct")
                private BorrowProductBeanXX borrowProduct;
                @SerializedName("id")
                private int id;
                @SerializedName("position")
                private PositionBeanX position;
                @SerializedName("productId")
                private int productId;
                @SerializedName("sortIndex")
                private int sortIndex;

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

                public static class BorrowProductBeanXX implements Serializable{

                    private int newLable;
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


                    public int getNewLable() {
                        return newLable;
                    }

                    public void setNewLable(int newLable) {
                        this.newLable = newLable;
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

                public static class PositionBeanX implements Serializable{
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
        }
    }
}