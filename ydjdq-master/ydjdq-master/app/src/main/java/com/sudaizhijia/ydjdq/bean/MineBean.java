package com.sudaizhijia.ydjdq.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/17
 */
public class MineBean extends BaseBean implements Serializable {
    /**
     * object : {"myVo":{"appBannerList":[{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"现金串串","htmlUrl":"http://cash.ninexinchain.cn/ajax/regist?s=xianjin561","id":1,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/bankaquxian.png","name":"产品信息","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:17:20","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"一米用钱","htmlUrl":"http://onem.qiulinb.cn/ajax/regist?s=yimi376","id":2,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/xinyongkajiance.png","name":"信用检测","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:20","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"速借分期","htmlUrl":"https://sufen.xijingsuo.com/sufen/inborrow/redirectindex?cid=268477607#&amp;/sufen/passport/register?cid=268477607","id":3,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/zhangdanguanli.png","name":"账单管理","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:10","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"金多宝","htmlUrl":"http://goldb.lsyaoji.cn/tui/reg?channel=dkgj392","id":4,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/tie.png","name":"提额必备","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:15","urlType":"H5","version":1}],"myShowList":[{"borrowProduct":{"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"},"id":19088,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/fangshuikouzi.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":81,"productId":1161,"sortIndex":1,"title":"放水口子","validateDate":1550023200000},{"borrowProduct":{"description":"审核快  申请即下款","id":1057,"linkedUrl":"https://xin.geziqianbao.com/xin/inborrow/redirectindex?cid=268482015#&amp;/xin/passport/register?cid=268482015","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/tiantianjie/jie.png","maxAmount":20000,"name":"天天借"},"id":19001,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/xinyonghuwenxia.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":82,"productId":1057,"sortIndex":2,"title":"新用户稳下","validateDate":1548748800000},{"borrowProduct":{"description":"极速审批 2小时放款","id":1042,"linkedUrl":"https://yifu.ruiyitv.com/yifu/inborrow/redirectindex?cid=268478651#&amp;/yifu/passport/register?cid=268478651","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/yifufenqi/100像素*易富分期.png","maxAmount":20000,"name":"易富分期"},"id":19174,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/jisudaozhang.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":83,"productId":1042,"sortIndex":3,"title":"极速到账","validateDate":1550476800000}],"xinKouZi":[{"borrowProduct":{"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"},"id":19089,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":77,"productId":1161,"sortIndex":1,"title":"","validateDate":1550023200000},{"borrowProduct":{"description":"快速审核 急速放款","id":1158,"linkedUrl":"https://beiyong.ruiyitv.com/beiyong/inborrow/redirectindex?cid=268480327#&amp;/beiyong/passport/register?cid=268480327","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/beiyongjin/beiyongjin.png","maxAmount":20000,"name":"呗用金"},"id":19155,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":78,"productId":1158,"sortIndex":2,"title":"","validateDate":1550404800000},{"borrowProduct":{"description":"门槛低  极速到账","id":1167,"linkedUrl":"https://h5.gouzikeji.com/v1/home?source=zhaozhiyuan","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/jisujie/jisujie.png","maxAmount":5000,"name":"极速借"},"id":19139,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":79,"productId":1167,"sortIndex":3,"title":"","validateDate":1550217600000},{"borrowProduct":{"description":"极速审批 2小时放款","id":1042,"linkedUrl":"https://yifu.ruiyitv.com/yifu/inborrow/redirectindex?cid=268478651#&amp;/yifu/passport/register?cid=268478651","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/yifufenqi/100像素*易富分期.png","maxAmount":20000,"name":"易富分期"},"id":19165,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":80,"productId":1042,"sortIndex":4,"title":"","validateDate":1550469600000},{"borrowProduct":{"description":"无视黑白 闪电放款","id":1146,"linkedUrl":"http://www.youxinsign.com:13083/youka/regist-page/forward?code=871","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/shandaiyouqian/ic_logo-100.png","maxAmount":10000,"name":"闪贷有钱"},"id":1283,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":1538,"productId":1146,"sortIndex":5,"title":"","validateDate":1548316800000}]},"iconUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/userIcon/1.0.png"}
     */

    private ObjectBean object;

    public ObjectBean getObject() {
        return object;
    }

    public void setObject(ObjectBean object) {
        this.object = object;
    }

    public static class ObjectBean implements Serializable {
        /**
         * myVo : {"appBannerList":[{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"现金串串","htmlUrl":"http://cash.ninexinchain.cn/ajax/regist?s=xianjin561","id":1,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/bankaquxian.png","name":"产品信息","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:17:20","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"一米用钱","htmlUrl":"http://onem.qiulinb.cn/ajax/regist?s=yimi376","id":2,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/xinyongkajiance.png","name":"信用检测","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:20","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"速借分期","htmlUrl":"https://sufen.xijingsuo.com/sufen/inborrow/redirectindex?cid=268477607#&amp;/sufen/passport/register?cid=268477607","id":3,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/zhangdanguanli.png","name":"账单管理","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:10","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"金多宝","htmlUrl":"http://goldb.lsyaoji.cn/tui/reg?channel=dkgj392","id":4,"imageUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/tie.png","name":"提额必备","osType":"IOS_ANDROID","updateTime":"2019-01-24 17:19:15","urlType":"H5","version":1}],"myShowList":[{"borrowProduct":{"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"},"id":19088,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/fangshuikouzi.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":81,"productId":1161,"sortIndex":1,"title":"放水口子","validateDate":1550023200000},{"borrowProduct":{"description":"审核快  申请即下款","id":1057,"linkedUrl":"https://xin.geziqianbao.com/xin/inborrow/redirectindex?cid=268482015#&amp;/xin/passport/register?cid=268482015","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/tiantianjie/jie.png","maxAmount":20000,"name":"天天借"},"id":19001,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/xinyonghuwenxia.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":82,"productId":1057,"sortIndex":2,"title":"新用户稳下","validateDate":1548748800000},{"borrowProduct":{"description":"极速审批 2小时放款","id":1042,"linkedUrl":"https://yifu.ruiyitv.com/yifu/inborrow/redirectindex?cid=268478651#&amp;/yifu/passport/register?cid=268478651","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/yifufenqi/100像素*易富分期.png","maxAmount":20000,"name":"易富分期"},"id":19174,"imgUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/jisudaozhang.png","newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"positionId":83,"productId":1042,"sortIndex":3,"title":"极速到账","validateDate":1550476800000}],"xinKouZi":[{"borrowProduct":{"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"},"id":19089,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":77,"productId":1161,"sortIndex":1,"title":"","validateDate":1550023200000},{"borrowProduct":{"description":"快速审核 急速放款","id":1158,"linkedUrl":"https://beiyong.ruiyitv.com/beiyong/inborrow/redirectindex?cid=268480327#&amp;/beiyong/passport/register?cid=268480327","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/beiyongjin/beiyongjin.png","maxAmount":20000,"name":"呗用金"},"id":19155,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":78,"productId":1158,"sortIndex":2,"title":"","validateDate":1550404800000},{"borrowProduct":{"description":"门槛低  极速到账","id":1167,"linkedUrl":"https://h5.gouzikeji.com/v1/home?source=zhaozhiyuan","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/jisujie/jisujie.png","maxAmount":5000,"name":"极速借"},"id":19139,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":79,"productId":1167,"sortIndex":3,"title":"","validateDate":1550217600000},{"borrowProduct":{"description":"极速审批 2小时放款","id":1042,"linkedUrl":"https://yifu.ruiyitv.com/yifu/inborrow/redirectindex?cid=268478651#&amp;/yifu/passport/register?cid=268478651","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/yifufenqi/100像素*易富分期.png","maxAmount":20000,"name":"易富分期"},"id":19165,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":80,"productId":1042,"sortIndex":4,"title":"","validateDate":1550469600000},{"borrowProduct":{"description":"无视黑白 闪电放款","id":1146,"linkedUrl":"http://www.youxinsign.com:13083/youka/regist-page/forward?code=871","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/shandaiyouqian/ic_logo-100.png","maxAmount":10000,"name":"闪贷有钱"},"id":1283,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"positionId":1538,"productId":1146,"sortIndex":5,"title":"","validateDate":1548316800000}]}
         * iconUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/userIcon/1.0.png
         */

        private MyVoBean myVo;
        private String shareUrl;
        private String iconUrl;

        public String getShareUrl() {
            return shareUrl;
        }

        public void setShareUrl(String shareUrl) {
            this.shareUrl = shareUrl;
        }

        public MyVoBean getMyVo() {
            return myVo;
        }

        public void setMyVo(MyVoBean myVo) {
            this.myVo = myVo;
        }

        public String getIconUrl() {
            return iconUrl;
        }

        public void setIconUrl(String iconUrl) {
            this.iconUrl = iconUrl;
        }

        public static class MyVoBean implements Serializable {
            private List<AppBannerListBean> appBannerList;
            private List<MyShowListBean> myShowList;
            private List<XinKouZiBean> xinKouZi;

            public List<AppBannerListBean> getAppBannerList() {
                return appBannerList;
            }

            public void setAppBannerList(List<AppBannerListBean> appBannerList) {
                this.appBannerList = appBannerList;
            }

            public List<MyShowListBean> getMyShowList() {
                return myShowList;
            }

            public void setMyShowList(List<MyShowListBean> myShowList) {
                this.myShowList = myShowList;
            }

            public List<XinKouZiBean> getXinKouZi() {
                return xinKouZi;
            }

            public void setXinKouZi(List<XinKouZiBean> xinKouZi) {
                this.xinKouZi = xinKouZi;
            }

            public static class AppBannerListBean implements Serializable {
                /**
                 * createTime : 2018-12-17 14:17:30
                 * enable : true
                 * htmlTitle : 现金串串
                 * htmlUrl : http://cash.ninexinchain.cn/ajax/regist?s=xianjin561
                 * id : 1
                 * imageUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/innerTools/bankaquxian.png
                 * name : 产品信息
                 * osType : IOS_ANDROID
                 * updateTime : 2019-01-24 17:17:20
                 * urlType : H5
                 * version : 1
                 */

                private String createTime;
                private boolean enable;
                private String htmlTitle;
                private String htmlUrl;
                private int id;
                private String imageUrl;
                private String name;
                private String osType;
                private String updateTime;
                private String urlType;
                private int version;

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public boolean isEnable() {
                    return enable;
                }

                public void setEnable(boolean enable) {
                    this.enable = enable;
                }

                public String getHtmlTitle() {
                    return htmlTitle;
                }

                public void setHtmlTitle(String htmlTitle) {
                    this.htmlTitle = htmlTitle;
                }

                public String getHtmlUrl() {
                    return htmlUrl;
                }

                public void setHtmlUrl(String htmlUrl) {
                    this.htmlUrl = htmlUrl;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getImageUrl() {
                    return imageUrl;
                }

                public void setImageUrl(String imageUrl) {
                    this.imageUrl = imageUrl;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getOsType() {
                    return osType;
                }

                public void setOsType(String osType) {
                    this.osType = osType;
                }

                public String getUpdateTime() {
                    return updateTime;
                }

                public void setUpdateTime(String updateTime) {
                    this.updateTime = updateTime;
                }

                public String getUrlType() {
                    return urlType;
                }

                public void setUrlType(String urlType) {
                    this.urlType = urlType;
                }

                public int getVersion() {
                    return version;
                }

                public void setVersion(int version) {
                    this.version = version;
                }
            }

            public static class MyShowListBean implements Serializable {
                /**
                 * borrowProduct : {"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"}
                 * id : 19088
                 * imgUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/fixedIcon/my/fangshuikouzi.png
                 * newLable : 1
                 * position : {"value":"我的界面推荐列表","key":"MY_SHOW_LIST"}
                 * positionId : 81
                 * productId : 1161
                 * sortIndex : 1
                 * title : 放水口子
                 * validateDate : 1550023200000
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

                public static class BorrowProductBean implements Serializable {
                    /**
                     * description : 1分钟  拿钱
                     * id : 1161
                     * linkedUrl : http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754
                     * logoUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png
                     * maxAmount : 3000.0
                     * name : 优品钱包
                     */

                    private String description;
                    private int id;
                    private String linkedUrl;
                    private String logoUrl;
                    private double maxAmount;
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
                     * value : 我的界面推荐列表
                     * key : MY_SHOW_LIST
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

            public static class XinKouZiBean implements Serializable {
                /**
                 * borrowProduct : {"description":"1分钟  拿钱","id":1161,"linkedUrl":"http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754","logoUrl":"http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png","maxAmount":3000,"name":"优品钱包"}
                 * id : 19089
                 * newLable : 1
                 * position : {"value":"新口子","key":"XIN_KOU_ZI"}
                 * positionId : 77
                 * productId : 1161
                 * sortIndex : 1
                 * title :
                 * validateDate : 1550023200000
                 */

                private BorrowProductBeanX borrowProduct;
                private int id;
                private int newLable;
                private PositionBeanX position;
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

                public static class BorrowProductBeanX implements Serializable {
                    /**
                     * description : 1分钟  拿钱
                     * id : 1161
                     * linkedUrl : http://payday-sc1.lkdjhls.cn/static/download.html?show=1&amp;agentid=30870754
                     * logoUrl : http://yijianbixia.oss-cn-zhangjiakou.aliyuncs.com/product/youpinqianbao/youpin.png
                     * maxAmount : 3000.0
                     * name : 优品钱包
                     */

                    private String description;
                    private int id;
                    private String linkedUrl;
                    private String logoUrl;
                    private double maxAmount;
                    private String name;
                    private String linkedUrlTwo;
                    private String showType;

                    public String getShowType() {
                        return showType;
                    }

                    public void setShowType(String showType) {
                        this.showType = showType;
                    }

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
                     * value : 新口子
                     * key : XIN_KOU_ZI
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

//    /**
//     * object : {"myVo":{"appBannerList":[{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":1,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":2,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":3,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":4,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1}],"myShowList":[{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":68,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":4,"sortIndex":1,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":69,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":5,"sortIndex":2,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":70,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":6,"sortIndex":3,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":71,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":7,"sortIndex":4,"validateDate":1543921204000}],"xinKouZi":[{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":37,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":3,"sortIndex":1,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":38,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":4,"sortIndex":2,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":39,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":5,"sortIndex":3,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":40,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":6,"sortIndex":4,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":41,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":7,"sortIndex":5,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述7","id":8,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"id":42,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":8,"sortIndex":6,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":43,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":9,"sortIndex":7,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":44,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":10,"sortIndex":8,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":45,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":1,"sortIndex":9,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":46,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":2,"sortIndex":10,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":47,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":3,"sortIndex":11,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":48,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":4,"sortIndex":12,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":49,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":5,"sortIndex":13,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":50,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":6,"sortIndex":14,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":51,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":7,"sortIndex":15,"validateDate":1543921201000}]}}
//     */
//
//    @SerializedName("object")
//    private ObjectBean object;
//
//    public ObjectBean getObject() {
//        return object;
//    }
//
//    public void setObject(ObjectBean object) {
//        this.object = object;
//    }
//
//    public static class ObjectBean implements Serializable{
//        /**
//         * myVo : {"appBannerList":[{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":1,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":2,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":3,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1},{"createTime":"2018-12-17 14:17:30","enable":true,"htmlTitle":"1","htmlUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","id":4,"imageUrl":"http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg","name":"1","osType":"ANDROID","updateTime":"2018-12-17 14:17:38","urlType":"H5","version":1}],"myShowList":[{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":68,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":4,"sortIndex":1,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":69,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":5,"sortIndex":2,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":70,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":6,"sortIndex":3,"validateDate":1543921203000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":71,"newLable":1,"position":{"value":"我的界面推荐列表","key":"MY_SHOW_LIST"},"productId":7,"sortIndex":4,"validateDate":1543921204000}],"xinKouZi":[{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":37,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":3,"sortIndex":1,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":38,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":4,"sortIndex":2,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":39,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":5,"sortIndex":3,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":40,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":6,"sortIndex":4,"validateDate":1543921200000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":41,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":7,"sortIndex":5,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述7","id":8,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"id":42,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":8,"sortIndex":6,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述8","id":9,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"id":43,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":9,"sortIndex":7,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述9","id":10,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"id":44,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":10,"sortIndex":8,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述0","id":1,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"id":45,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":1,"sortIndex":9,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述1","id":2,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"id":46,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":2,"sortIndex":10,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"id":47,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":3,"sortIndex":11,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"id":48,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":4,"sortIndex":12,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述4","id":5,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"id":49,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":5,"sortIndex":13,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述5","id":6,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"id":50,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":6,"sortIndex":14,"validateDate":1543921201000},{"borrowProduct":{"description":"测试描述6","id":7,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"id":51,"newLable":1,"position":{"value":"新口子","key":"XIN_KOU_ZI"},"productId":7,"sortIndex":15,"validateDate":1543921201000}]}
//         */
//
//        @SerializedName("myVo")
//        private MyVoBean myVo;
//        @SerializedName("iconUrl")
//        private String iconUrl;
//        public MyVoBean getMyVo() {
//            return myVo;
//        }
//
//        public String getIconUrl() {
//            return iconUrl;
//        }
//
//        public void setIconUrl(String iconUrl) {
//            this.iconUrl = iconUrl;
//        }
//
//        public void setMyVo(MyVoBean myVo) {
//            this.myVo = myVo;
//        }
//
//        public static class MyVoBean implements Serializable{
//            @SerializedName("appBannerList")
//            private List<AppBannerListBean> appBannerList;
//            @SerializedName("myShowList")
//            private List<MyShowListBean> myShowList;
//            @SerializedName("xinKouZi")
//            private List<XinKouZiBean> xinKouZi;
//
//            public List<AppBannerListBean> getAppBannerList() {
//                return appBannerList;
//            }
//
//            public void setAppBannerList(List<AppBannerListBean> appBannerList) {
//                this.appBannerList = appBannerList;
//            }
//
//            public List<MyShowListBean> getMyShowList() {
//                return myShowList;
//            }
//
//            public void setMyShowList(List<MyShowListBean> myShowList) {
//                this.myShowList = myShowList;
//            }
//
//            public List<XinKouZiBean> getXinKouZi() {
//                return xinKouZi;
//            }
//
//            public void setXinKouZi(List<XinKouZiBean> xinKouZi) {
//                this.xinKouZi = xinKouZi;
//            }
//
//            public static class AppBannerListBean implements Serializable{
//                /**
//                 * createTime : 2018-12-17 14:17:30
//                 * enable : true
//                 * htmlTitle : 1
//                 * htmlUrl : http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg
//                 * id : 1
//                 * imageUrl : http://www.cnlogo8.com/d/file/2018-09-07/1d9cf06d067083a7b3587c9174368da2.jpeg
//                 * name : 1
//                 * osType : ANDROID
//                 * updateTime : 2018-12-17 14:17:38
//                 * urlType : H5
//                 * version : 1
//                 */
//
//                @SerializedName("createTime")
//                private String createTime;
//                @SerializedName("enable")
//                private boolean enable;
//                @SerializedName("htmlTitle")
//                private String htmlTitle;
//                @SerializedName("htmlUrl")
//                private String htmlUrl;
//                @SerializedName("id")
//                private int id;
//                @SerializedName("imageUrl")
//                private String imageUrl;
//                @SerializedName("name")
//                private String name;
//                @SerializedName("osType")
//                private String osType;
//                @SerializedName("updateTime")
//                private String updateTime;
//                @SerializedName("urlType")
//                private String urlType;
//                @SerializedName("version")
//                private int version;
//
//                public String getCreateTime() {
//                    return createTime;
//                }
//
//                public void setCreateTime(String createTime) {
//                    this.createTime = createTime;
//                }
//
//                public boolean isEnable() {
//                    return enable;
//                }
//
//                public void setEnable(boolean enable) {
//                    this.enable = enable;
//                }
//
//                public String getHtmlTitle() {
//                    return htmlTitle;
//                }
//
//                public void setHtmlTitle(String htmlTitle) {
//                    this.htmlTitle = htmlTitle;
//                }
//
//                public String getHtmlUrl() {
//                    return htmlUrl;
//                }
//
//                public void setHtmlUrl(String htmlUrl) {
//                    this.htmlUrl = htmlUrl;
//                }
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public String getImageUrl() {
//                    return imageUrl;
//                }
//
//                public void setImageUrl(String imageUrl) {
//                    this.imageUrl = imageUrl;
//                }
//
//                public String getName() {
//                    return name;
//                }
//
//                public void setName(String name) {
//                    this.name = name;
//                }
//
//                public String getOsType() {
//                    return osType;
//                }
//
//                public void setOsType(String osType) {
//                    this.osType = osType;
//                }
//
//                public String getUpdateTime() {
//                    return updateTime;
//                }
//
//                public void setUpdateTime(String updateTime) {
//                    this.updateTime = updateTime;
//                }
//
//                public String getUrlType() {
//                    return urlType;
//                }
//
//                public void setUrlType(String urlType) {
//                    this.urlType = urlType;
//                }
//
//                public int getVersion() {
//                    return version;
//                }
//
//                public void setVersion(int version) {
//                    this.version = version;
//                }
//            }
//
//            public static class MyShowListBean implements Serializable{
//                /**
//                 * borrowProduct : {"description":"测试描述3","id":4,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"}
//                 * id : 68
//                 * newLable : 1
//                 * position : {"value":"我的界面推荐列表","key":"MY_SHOW_LIST"}
//                 * productId : 4
//                 * sortIndex : 1
//                 * validateDate : 1543921203000
//                 */
//
//                @SerializedName("borrowProduct")
//                private BorrowProductBean borrowProduct;
//                @SerializedName("id")
//                private int id;
//                @SerializedName("newLable")
//                private int newLable;
//                @SerializedName("position")
//                private PositionBean position;
//                @SerializedName("productId")
//                private int productId;
//                @SerializedName("sortIndex")
//                private int sortIndex;
//                @SerializedName("validateDate")
//                private long validateDate;
//                @SerializedName("title")
//                private String title;
//                @SerializedName("imgUrl")
//                private String imgUrl;
//
//                public String getTitle() {
//                    return title;
//                }
//
//                public void setTitle(String title) {
//                    this.title = title;
//                }
//
//                public String getImgUrl() {
//                    return imgUrl;
//                }
//
//                public void setImgUrl(String imgUrl) {
//                    this.imgUrl = imgUrl;
//                }
//
//                public BorrowProductBean getBorrowProduct() {
//                    return borrowProduct;
//                }
//
//                public void setBorrowProduct(BorrowProductBean borrowProduct) {
//                    this.borrowProduct = borrowProduct;
//                }
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public int getNewLable() {
//                    return newLable;
//                }
//
//                public void setNewLable(int newLable) {
//                    this.newLable = newLable;
//                }
//
//                public PositionBean getPosition() {
//                    return position;
//                }
//
//                public void setPosition(PositionBean position) {
//                    this.position = position;
//                }
//
//                public int getProductId() {
//                    return productId;
//                }
//
//                public void setProductId(int productId) {
//                    this.productId = productId;
//                }
//
//                public int getSortIndex() {
//                    return sortIndex;
//                }
//
//                public void setSortIndex(int sortIndex) {
//                    this.sortIndex = sortIndex;
//                }
//
//                public long getValidateDate() {
//                    return validateDate;
//                }
//
//                public void setValidateDate(long validateDate) {
//                    this.validateDate = validateDate;
//                }
//
//                public static class BorrowProductBean implements Serializable{
//                    /**
//                     * description : 测试描述3
//                     * id : 4
//                     * linkedUrl : https://www.baidu.com/
//                     * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png
//                     * maxAmount : 3000.0
//                     * name : 测试产品3
//                     */
//
//                    @SerializedName("description")
//                    private String description;
//                    @SerializedName("id")
//                    private int id;
//                    @SerializedName("linkedUrl")
//                    private String linkedUrl;
//                    @SerializedName("logoUrl")
//                    private String logoUrl;
//                    @SerializedName("maxAmount")
//                    private double maxAmount;
//                    @SerializedName("name")
//                    private String name;
//
//                    public String getDescription() {
//                        return description;
//                    }
//
//                    public void setDescription(String description) {
//                        this.description = description;
//                    }
//
//                    public int getId() {
//                        return id;
//                    }
//
//                    public void setId(int id) {
//                        this.id = id;
//                    }
//
//                    public String getLinkedUrl() {
//                        return linkedUrl;
//                    }
//
//                    public void setLinkedUrl(String linkedUrl) {
//                        this.linkedUrl = linkedUrl;
//                    }
//
//                    public String getLogoUrl() {
//                        return logoUrl;
//                    }
//
//                    public void setLogoUrl(String logoUrl) {
//                        this.logoUrl = logoUrl;
//                    }
//
//                    public double getMaxAmount() {
//                        return maxAmount;
//                    }
//
//                    public void setMaxAmount(double maxAmount) {
//                        this.maxAmount = maxAmount;
//                    }
//
//                    public String getName() {
//                        return name;
//                    }
//
//                    public void setName(String name) {
//                        this.name = name;
//                    }
//                }
//
//                public static class PositionBean implements Serializable{
//                    /**
//                     * value : 我的界面推荐列表
//                     * key : MY_SHOW_LIST
//                     */
//
//                    @SerializedName("value")
//                    private String value;
//                    @SerializedName("key")
//                    private String key;
//
//                    public String getValue() {
//                        return value;
//                    }
//
//                    public void setValue(String value) {
//                        this.value = value;
//                    }
//
//                    public String getKey() {
//                        return key;
//                    }
//
//                    public void setKey(String key) {
//                        this.key = key;
//                    }
//                }
//            }
//
//            public static class XinKouZiBean implements Serializable{
//                /**
//                 * borrowProduct : {"description":"测试描述2","id":3,"linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"}
//                 * id : 37
//                 * newLable : 1
//                 * position : {"value":"新口子","key":"XIN_KOU_ZI"}
//                 * productId : 3
//                 * sortIndex : 1
//                 * validateDate : 1543921200000
//                 */
//
//                @SerializedName("borrowProduct")
//                private BorrowProductBeanX borrowProduct;
//                @SerializedName("id")
//                private int id;
//                @SerializedName("newLable")
//                private int newLable;
//                @SerializedName("position")
//                private PositionBeanX position;
//                @SerializedName("productId")
//                private int productId;
//                @SerializedName("sortIndex")
//                private int sortIndex;
//                @SerializedName("validateDate")
//                private long validateDate;
//
//                public BorrowProductBeanX getBorrowProduct() {
//                    return borrowProduct;
//                }
//
//                public void setBorrowProduct(BorrowProductBeanX borrowProduct) {
//                    this.borrowProduct = borrowProduct;
//                }
//
//                public int getId() {
//                    return id;
//                }
//
//                public void setId(int id) {
//                    this.id = id;
//                }
//
//                public int getNewLable() {
//                    return newLable;
//                }
//
//                public void setNewLable(int newLable) {
//                    this.newLable = newLable;
//                }
//
//                public PositionBeanX getPosition() {
//                    return position;
//                }
//
//                public void setPosition(PositionBeanX position) {
//                    this.position = position;
//                }
//
//                public int getProductId() {
//                    return productId;
//                }
//
//                public void setProductId(int productId) {
//                    this.productId = productId;
//                }
//
//                public int getSortIndex() {
//                    return sortIndex;
//                }
//
//                public void setSortIndex(int sortIndex) {
//                    this.sortIndex = sortIndex;
//                }
//
//                public long getValidateDate() {
//                    return validateDate;
//                }
//
//                public void setValidateDate(long validateDate) {
//                    this.validateDate = validateDate;
//                }
//
//                public static class BorrowProductBeanX implements Serializable{
//                    /**
//                     * description : 测试描述2
//                     * id : 3
//                     * linkedUrl : https://www.baidu.com/
//                     * logoUrl : http://www.cnlogo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png
//                     * maxAmount : 3000.0
//                     * name : 测试产品2
//                     */
//
//                    @SerializedName("description")
//                    private String description;
//                    @SerializedName("id")
//                    private int id;
//                    @SerializedName("linkedUrl")
//                    private String linkedUrl;
//                    @SerializedName("logoUrl")
//                    private String logoUrl;
//                    @SerializedName("maxAmount")
//                    private double maxAmount;
//                    @SerializedName("name")
//                    private String name;
//
//                    public String getDescription() {
//                        return description;
//                    }
//
//                    public void setDescription(String description) {
//                        this.description = description;
//                    }
//
//                    public int getId() {
//                        return id;
//                    }
//
//                    public void setId(int id) {
//                        this.id = id;
//                    }
//
//                    public String getLinkedUrl() {
//                        return linkedUrl;
//                    }
//
//                    public void setLinkedUrl(String linkedUrl) {
//                        this.linkedUrl = linkedUrl;
//                    }
//
//                    public String getLogoUrl() {
//                        return logoUrl;
//                    }
//
//                    public void setLogoUrl(String logoUrl) {
//                        this.logoUrl = logoUrl;
//                    }
//
//                    public double getMaxAmount() {
//                        return maxAmount;
//                    }
//
//                    public void setMaxAmount(double maxAmount) {
//                        this.maxAmount = maxAmount;
//                    }
//
//                    public String getName() {
//                        return name;
//                    }
//
//                    public void setName(String name) {
//                        this.name = name;
//                    }
//                }
//
//                public static class PositionBeanX implements Serializable{
//                    /**
//                     * value : 新口子
//                     * key : XIN_KOU_ZI
//                     */
//
//                    @SerializedName("value")
//                    private String value;
//                    @SerializedName("key")
//                    private String key;
//
//                    public String getValue() {
//                        return value;
//                    }
//
//                    public void setValue(String value) {
//                        this.value = value;
//                    }
//
//                    public String getKey() {
//                        return key;
//                    }
//
//                    public void setKey(String key) {
//                        this.key = key;
//                    }
//                }
//            }
//        }
//    }
}