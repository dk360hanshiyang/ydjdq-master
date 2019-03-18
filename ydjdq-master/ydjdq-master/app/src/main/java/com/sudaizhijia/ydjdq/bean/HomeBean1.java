package com.sudaizhijia.ydjdq.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Author: William Wang
 * Date:   On 2018/12/4
 */
public class HomeBean1 extends BaseBean implements Serializable {


    /**
     * object : {"newComeNum":"7","countDown":"32101","banner":[{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":18,"overdueDate":1545217199000,"position":{"value":"banner推荐","key":"BANNER"},"productId":4,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":17,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":3,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921198000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":16,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":2,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921198000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":15,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":1,"staffId":1,"updateTime":"2018-12-04 19:03:57","validateDate":1543921198000}],"list":[{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":114,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":0,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":113,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":1,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":112,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":2,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":111,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":3,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":110,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":4,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":109,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":5,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":108,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":6,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":107,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":7,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":106,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":8,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":105,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":9,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":104,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":10,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":103,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":11,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":102,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":12,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":101,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":13,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":100,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":14,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":99,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":15,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":98,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":16,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":97,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":17,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":96,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":18,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":95,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":19,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":94,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":20,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":93,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":21,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":92,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":22,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":91,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":23,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":90,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":24,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":89,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":25,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":88,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":26,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":87,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":27,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":86,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":28,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":85,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":29,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000}],"middle":[{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":26,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":2,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":25,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":1,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":24,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":10,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":23,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":9,"staffId":1,"updateTime":"2018-12-04 19:04:13","validateDate":1543921199000}],"overlays":[{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":27,"overdueDate":1545217199000,"position":{"value":"浮窗","key":"OVERLAYS"},"productId":3,"staffId":1,"updateTime":"2018-12-04 19:04:18","validateDate":1543921199000}],"paymentReport":[{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":22,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":8,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":21,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":20,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":19,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":5,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 20:01:18","validateDate":1543921199000}],"top":[{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":22,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":8,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":21,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":20,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":19,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":5,"staffId":1,"updateTime":"2018-12-04 20:01:18","validateDate":1543921199000}]}
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
         * newComeNum : 7
         * countDown : 32101
         * banner : [{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":18,"overdueDate":1545217199000,"position":{"value":"banner推荐","key":"BANNER"},"productId":4,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":17,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":3,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921198000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":16,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":2,"staffId":1,"updateTime":"2018-12-04 19:03:58","validateDate":1543921198000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 18:59:58","feeType":"asc","id":15,"overdueDate":1545217198000,"position":{"value":"banner推荐","key":"BANNER"},"productId":1,"staffId":1,"updateTime":"2018-12-04 19:03:57","validateDate":1543921198000}]
         * list : [{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":114,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":0,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":113,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":1,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":112,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":2,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":111,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":3,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:07","feeType":"asc","id":110,"overdueDate":1545217207000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":4,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921207000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":109,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":5,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":108,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":6,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":107,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":7,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":106,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":8,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":105,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":9,"staffId":1,"updateTime":"2018-12-04 19:03:51","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":104,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":10,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":103,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":11,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":102,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":12,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":101,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":13,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":100,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":14,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":99,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":15,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":98,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":16,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:06","feeType":"asc","id":97,"overdueDate":1545217206000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":17,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921206000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":96,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":18,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":95,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":19,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":94,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":10,"sortIndex":20,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":93,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":9,"sortIndex":21,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":92,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":8,"sortIndex":22,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":91,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":7,"sortIndex":23,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":90,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":6,"sortIndex":24,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":89,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":5,"sortIndex":25,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":88,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":4,"sortIndex":26,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":87,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":3,"sortIndex":27,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":86,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":2,"sortIndex":28,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 19:00:05","feeType":"asc","id":85,"overdueDate":1545217205000,"position":{"value":"首页推荐","key":"INDEX_LIST"},"productId":1,"sortIndex":29,"staffId":1,"updateTime":"2018-12-04 19:03:50","validateDate":1543921205000}]
         * middle : [{"borrowProduct":{"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":26,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":2,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述0","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2014-03-06/f75d8753c3b6463dfcbf65967abc5ffb.jpg","maxAmount":3000,"name":"测试产品0"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":25,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":1,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":24,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":10,"staffId":1,"updateTime":"2018-12-04 19:04:14","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述8","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-24/7643f24dc859dc916aa709aee92a6329.png","maxAmount":3000,"name":"测试产品8"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":23,"overdueDate":1545217199000,"position":{"value":"中层推荐","key":"MIDDLE"},"productId":9,"staffId":1,"updateTime":"2018-12-04 19:04:13","validateDate":1543921199000}]
         * overlays : [{"borrowProduct":{"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":27,"overdueDate":1545217199000,"position":{"value":"浮窗","key":"OVERLAYS"},"productId":3,"staffId":1,"updateTime":"2018-12-04 19:04:18","validateDate":1543921199000}]
         * paymentReport : [{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":22,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":8,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":21,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":20,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":19,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":5,"remark":"用户135****3088获得2000元下款","staffId":1,"updateTime":"2018-12-04 20:01:18","validateDate":1543921199000}]
         * top : [{"borrowProduct":{"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":22,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":8,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述6","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/a7f079a29b4a318f6878a59abf3e5180.png","maxAmount":3000,"name":"测试产品6"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":21,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":7,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述5","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-13/3fe7c416dbc43b108d0df2a684691231.png","maxAmount":3000,"name":"测试产品5"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":20,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":6,"staffId":1,"updateTime":"2018-12-04 19:04:07","validateDate":1543921199000},{"borrowProduct":{"description":"测试描述4","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/794ec1d7a7f23544950a3abef0824795.png","maxAmount":3000,"name":"测试产品4"},"createTime":"2018-12-04 18:59:59","feeType":"asc","id":19,"overdueDate":1545217199000,"position":{"value":"顶层推荐","key":"TOP"},"productId":5,"staffId":1,"updateTime":"2018-12-04 20:01:18","validateDate":1543921199000}]
         */
        private List<XinKouZi> xinkouzi;
        private String newComeNum;
        private String countDown;
        private List<BannerBean> banner;
        private List<ListBean> list;
        private List<MiddleBean> middle;
        private List<OverlaysBean> overlays;
        private List<PaymentReportBean> paymentReport;
        private List<TopBean> top;


        public List<XinKouZi> getXinkouzi() {
            return xinkouzi;
        }

        public void setXinkouzi(List<XinKouZi> xinkouzi) {
            this.xinkouzi = xinkouzi;
        }

        public String getNewComeNum() {
            return newComeNum;
        }

        public void setNewComeNum(String newComeNum) {
            this.newComeNum = newComeNum;
        }

        public String getCountDown() {
            return countDown;
        }

        public void setCountDown(String countDown) {
            this.countDown = countDown;
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

        public static class BannerBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述3","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png","maxAmount":3000,"name":"测试产品3"}
             * createTime : 2018-12-04 18:59:59
             * feeType : asc
             * id : 18
             * overdueDate : 1545217199000
             * position : {"value":"banner推荐","key":"BANNER"}
             * productId : 4
             * staffId : 1
             * updateTime : 2018-12-04 19:03:58
             * validateDate : 1543921199000
             */
            private int sortIndex;
            private BorrowProductBean borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBean position;
            private int productId;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public BorrowProductBean getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBean borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public int getSortIndex() {
                return sortIndex;
            }

            public void setSortIndex(int sortIndex) {
                this.sortIndex = sortIndex;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBean implements Serializable {
                /**
                 * description : 测试描述3
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-23/08b77676cbc598f260f6a41b0a87f304.png
                 * maxAmount : 3000.0
                 * name : 测试产品3
                 */
                private int id;
                private String description;
                private String linkedUrl;
                private String logoUrl;
                private double maxAmount;
                private String name;
                private int newLable;
                private String linkedUrlTwo;

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

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class ListBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述9","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png","maxAmount":3000,"name":"测试产品9"}
             * createTime : 2018-12-04 19:00:07
             * feeType : asc
             * id : 114
             * overdueDate : 1545217207000
             * position : {"value":"首页推荐","key":"INDEX_LIST"}
             * productId : 10
             * sortIndex : 0
             * staffId : 1
             * updateTime : 2018-12-04 19:03:51
             * validateDate : 1543921207000
             */
            private int newLable;
            private BorrowProductBeanX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanX position;
            private int productId;
            private int sortIndex;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public int getNewLable() {
                return newLable;
            }

            public void setNewLable(int newLable) {
                this.newLable = newLable;
            }

            public BorrowProductBeanX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBeanX implements Serializable {
                /**
                 * description : 测试描述9
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-10-31/121bddead1e3333b90960a2381e9b4ff.png
                 * maxAmount : 3000.0
                 * name : 测试产品9
                 */
                private int id;
                private String description;
                private String linkedUrl;
                private String logoUrl;
                private double maxAmount;
                private String name;
                private int newLable;
                private String linkedUrlTwo;

                public String getLinkedUrlTwo() {
                    return linkedUrlTwo;
                }

                public void setLinkedUrlTwo(String linkedUrlTwo) {
                    this.linkedUrlTwo = linkedUrlTwo;
                }
                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class MiddleBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述1","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png","maxAmount":3000,"name":"测试产品1"}
             * createTime : 2018-12-04 18:59:59
             * feeType : asc
             * id : 26
             * overdueDate : 1545217199000
             * position : {"value":"中层推荐","key":"MIDDLE"}
             * productId : 2
             * staffId : 1
             * updateTime : 2018-12-04 19:04:14
             * validateDate : 1543921199000
             */
            private int sortIndex;
            private BorrowProductBeanXX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanXX position;
            private int productId;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public int getSortIndex() {
                return sortIndex;
            }

            public void setSortIndex(int sortIndex) {
                this.sortIndex = sortIndex;
            }

            public BorrowProductBeanXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBeanXX implements Serializable {
                /**
                 * description : 测试描述1
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-20/fd6e6e29d13e82e091b724396c129934.png
                 * maxAmount : 3000.0
                 * name : 测试产品1
                 */
                private int newLable;

                private int id;
                private String description;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class OverlaysBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述2","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png","maxAmount":3000,"name":"测试产品2"}
             * createTime : 2018-12-04 18:59:59
             * feeType : asc
             * id : 27
             * overdueDate : 1545217199000
             * position : {"value":"浮窗","key":"OVERLAYS"}
             * productId : 3
             * staffId : 1
             * updateTime : 2018-12-04 19:04:18
             * validateDate : 1543921199000
             */

            private BorrowProductBeanXXX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanXXX position;
            private int productId;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public BorrowProductBeanXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
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
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-23/1c442204818b284bbb958a4ae4104498.png
                 * maxAmount : 3000.0
                 * name : 测试产品2
                 */
                private int newLable;
                private String description;
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

                public String getLinkedUrl() {
                    return linkedUrl;
                }

                public void setLinkedUrl(String linkedUrl) {
                    this.linkedUrl = linkedUrl;
                }

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class PaymentReportBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"}
             * createTime : 2018-12-04 18:59:59
             * feeType : asc
             * id : 22
             * overdueDate : 1545217199000
             * position : {"value":"顶层推荐","key":"TOP"}
             * productId : 8
             * remark : 用户135****3088获得2000元下款
             * staffId : 1
             * updateTime : 2018-12-04 19:04:07
             * validateDate : 1543921199000
             */
            private int sortIndex;
            private BorrowProductBeanXXXX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanXXXX position;
            private int productId;
            private String remark;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public int getSortIndex() {
                return sortIndex;
            }

            public void setSortIndex(int sortIndex) {
                this.sortIndex = sortIndex;
            }

            public BorrowProductBeanXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
            }

            public PositionBeanXXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXXX position) {
                this.position = position;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBeanXXXX implements Serializable {
                /**
                 * description : 测试描述7
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png
                 * maxAmount : 3000.0
                 * name : 测试产品7
                 */
                private int newLable;
                private int id;
                private String description;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class TopBean implements Serializable {
            /**
             * borrowProduct : {"description":"测试描述7","linkedUrl":"https://www.baidu.com/","logoUrl":"http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png","maxAmount":3000,"name":"测试产品7"}
             * createTime : 2018-12-04 18:59:59
             * feeType : asc
             * id : 22
             * overdueDate : 1545217199000
             * position : {"value":"顶层推荐","key":"TOP"}
             * productId : 8
             * staffId : 1
             * updateTime : 2018-12-04 19:04:07
             * validateDate : 1543921199000
             */
            private int sortIndex;
            private BorrowProductBeanXXXXX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanXXXXX position;
            private int productId;
            private int staffId;
            private String updateTime;
            private long validateDate;

            public int getSortIndex() {
                return sortIndex;
            }

            public void setSortIndex(int sortIndex) {
                this.sortIndex = sortIndex;
            }

            public BorrowProductBeanXXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXXX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
            }

            public PositionBeanXXXXX getPosition() {
                return position;
            }

            public void setPosition(PositionBeanXXXXX position) {
                this.position = position;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }

            public static class BorrowProductBeanXXXXX implements Serializable {
                /**
                 * description : 测试描述7
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png
                 * maxAmount : 3000.0
                 * name : 测试产品7
                 */
                private int newLable;
                private int id;
                private String description;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

        public static class XinKouZi implements Serializable {
            private int sortIndex;
            private BorrowProductBeanXXXXXX borrowProduct;
            private String createTime;
            private String feeType;
            private int id;
            private long overdueDate;
            private PositionBeanXXXXXX position;
            private int productId;
            private int staffId;
            private String updateTime;
            private long validateDate;


            public int getSortIndex() {
                return sortIndex;
            }

            public void setSortIndex(int sortIndex) {
                this.sortIndex = sortIndex;
            }

            public BorrowProductBeanXXXXXX getBorrowProduct() {
                return borrowProduct;
            }

            public void setBorrowProduct(BorrowProductBeanXXXXXX borrowProduct) {
                this.borrowProduct = borrowProduct;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public String getFeeType() {
                return feeType;
            }

            public void setFeeType(String feeType) {
                this.feeType = feeType;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public long getOverdueDate() {
                return overdueDate;
            }

            public void setOverdueDate(long overdueDate) {
                this.overdueDate = overdueDate;
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

            public int getStaffId() {
                return staffId;
            }

            public void setStaffId(int staffId) {
                this.staffId = staffId;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public long getValidateDate() {
                return validateDate;
            }

            public void setValidateDate(long validateDate) {
                this.validateDate = validateDate;
            }
        }

            public static class BorrowProductBeanXXXXXX implements Serializable {
                /**
                 * description : 测试描述7
                 * linkedUrl : https://www.baidu.com/
                 * logoUrl : http://www.cnlogoo8.com/d/file/2018-11-04/3481100d1a5455c45c2f908027fbe619.png
                 * maxAmount : 3000.0
                 * name : 测试产品7
                 */
                private int newLable;
                private int id;
                private String description;
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

                public String getlogoUrl() {
                    return logoUrl;
                }

                public void setlogoUrl(String logoUrl) {
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

