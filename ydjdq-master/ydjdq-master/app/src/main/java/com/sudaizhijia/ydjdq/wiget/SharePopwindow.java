package com.sudaizhijia.ydjdq.wiget;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;


import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.productdetail.ProductDetailActivity;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;


/**
 * 分享的popupWindow
 * Created by admin on 2016/5/24.
 */

public class SharePopwindow implements View.OnClickListener {
    private Activity context;
    private PopupWindow popupWindow;
    private PopupWindow ewmPopupWindow;
    /**
     * 朋友圈分享
     */
    private TextView tv_friend;
    /**
     * 微信分享
     */
    private TextView tv_weixin;
    /**
     * qq分享
     */
    private TextView tv_qq;
//    /** 二维码分享 */
//    private TextView tv_erweima;
    /**
     * 短信分享
     */
    private TextView tv_ems;
    /**
     * 分享pop
     */
    private View invitePopView;
    //    /** 二维码pop */
//    private View EWMePopView;
    private TextView bt_cancel;
//    /**二维码中的布局*/
//    private Button bt_register;
//    private ImageView iv_close;
//    private ImageView iv_erweima;
    /**
     * 分享的标题
     */
    private String shareTitle = "标题";//app_name
    /**
     * 分享的内容
     */
    private String shareDescription = "";
    /**
     * 分享点击的链接
     */
    private String shareLink = CusApplication.shareUrl;
    /**
     * 短信分享文案
     */
//    private String emsShare="我通过有袋借了好多钱，老铁，666";
//    /**二维码链接*/
//    private String ewmUrl;
//    private String imagePath = KeyNamePro.filePath+"new_icon.jpg";

    private View view;
    private WindowManager.LayoutParams lp;
    private String logoUrl;
    ProductDetailActivity activity;

    // 初始化PopWindow 并显示
    public SharePopwindow(Activity context, View view, String name, String shareDescription, ProductDetailActivity activity, String logoUrl) {
        this.logoUrl = logoUrl;
        this.activity = activity;
        this.shareTitle = name;
        this.context = context;
        this.shareDescription = shareDescription;
//        shareTitle = context.getResources().getString(R.string.app_name);
//        shareDescription = "我通过" + name + "借了好多钱" + shareDescription;
        saveIcon();
        invitePopView = LayoutInflater.from(context).inflate(R.layout.invite_pop_window, null);
        tv_friend = (TextView) invitePopView.findViewById(R.id.tv_pengyouquan);
        tv_weixin = (TextView) invitePopView.findViewById(R.id.tv_wx);
//        tv_qq = (TextView) invitePopView.findViewById(R.id.tv_qq);
//        tv_erweima = (TextView) invitePopView.findViewById(R.id.tv_erweima);
        tv_ems = (TextView) invitePopView.findViewById(R.id.tv_shortmessage);
        bt_cancel = (TextView) invitePopView.findViewById(R.id.bt_cancle);
//        EWMePopView = LayoutInflater.from(context).inflate(R.layout.share_erweima, null);
//        iv_erweima = (ImageView) EWMePopView.findViewById(R.id.iv_erweima);
//        bt_register = (Button) EWMePopView.findViewById(R.id.bt_register);
//        iv_close = (ImageView) EWMePopView.findViewById(R.id.close);
        this.view = view;
//        emsShare = entity.obj.copyUrl+entity.obj.sendmsgUrl;
//        shareTitle = entity.obj.wechatShareVo.title;
//        shareDescription = entity.obj.wechatShareVo.description;
//        shareLink = entity.obj.wechatShareVo.href;
//        ewmUrl = entity.obj.qrCodeHref;
//        try {
//            Glide.with(context).load(entity.obj.qrCodeHref + "?" + Math.random() * 100).diskCacheStrategy(DiskCacheStrategy.NONE).into(iv_erweima);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        initPopWindow();
        registerListener();
    }

    public void showSharePop(View view) {
        popupWindow.showAtLocation(view, Gravity.BOTTOM, 0, 0);
        makeWindowBlack();
    }

    /**
     * 屏幕变暗
     */
    private void makeWindowBlack() {
        WindowManager.LayoutParams lp = ((Activity) context).getWindow().getAttributes();
        lp.alpha = 0.6f;
        ((Activity) context).getWindow().setAttributes(lp);
        ((Activity) context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
    }

    private void registerListener() {
        tv_friend.setOnClickListener(this);
        tv_weixin.setOnClickListener(this);
//        tv_qq.setOnClickListener(this);
//        tv_erweima.setOnClickListener(this);
//        tv_ems.setOnClickListener(this);
//        iv_close.setOnClickListener(this);
//        bt_register.setOnClickListener(this);
        bt_cancel.setOnClickListener(this);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                lp = activity.getWindow().getAttributes();
                lp.alpha = 1f;
                try {
                    activity.getWindow().setAttributes(lp);
                    activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                }catch (Exception e){

                }

            }
        }
    };

    @SuppressLint("WrongConstant")
    private void initPopWindow() {
        popupWindow = new PopupWindow(invitePopView, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable());
        popupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
        popupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
        popupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        popupWindow.setOnDismissListener(() -> {

            Message message = Message.obtain();
            message.what = 0;
            handler.sendMessage(message);

        });
        // popup 消失时 设置背景变亮
//        ewmPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
//                lp.alpha = 1f;
//                ((Activity)context).getWindow().setAttributes(lp);
//            }
//        });
    }

    //    private void initEWMPopWindow() {
//        ewmPopupWindow = new PopupWindow(EWMePopView, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
//        ewmPopupWindow.setOutsideTouchable(true);
//        ewmPopupWindow.setFocusable(true);
//        ewmPopupWindow.setBackgroundDrawable(new ColorDrawable());
//        ewmPopupWindow.setAnimationStyle(R.style.mypopwindow_anim_style);
//        ewmPopupWindow.setSoftInputMode(PopupWindow.INPUT_METHOD_NEEDED);
//        ewmPopupWindow.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
//        ewmPopupWindow.showAsDropDown(view);
//        WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
//        lp.alpha = 0.2f;
//        ((Activity)context).getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
//        ewmPopupWindow.showAtLocation(bt_register, Gravity.BOTTOM, 0, 0);
//        // popup 消失时 设置背景变亮
//        ewmPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
//
//            @Override
//            public void onDismiss() {
//                WindowManager.LayoutParams lp = ((Activity)context).getWindow().getAttributes();
//                lp.alpha = 1f;
//                ((Activity)context).getWindow().setAttributes(lp);
//            }
//        });
//    }
    @Override
    public void onClick(View v) {
        popupWindow.dismiss();
        switch (v.getId()) {
            case R.id.tv_pengyouquan:
                shareToWeChatMoment();
                break;
            case R.id.tv_wx:
                shareToWechat();
                break;
            case R.id.tv_qq:
                shareToQQ();
                break;
//            case R.id.tv_erweima:
//                initEWMPopWindow();
//                break;
            case R.id.tv_shortmessage:
                shareToMsg();
//                context.startActivity(new Intent(context, LinkmanActivity.class).putExtra("data", emsShare));
                break;
//            case R.id.close:
//                ewmPopupWindow.dismiss();
//                break;
//            case bt_register:
//                shareEWMToWeChat();
//                break;
            case R.id.bt_cancle:
                popupWindow.dismiss();
                break;
            default:
                break;
        }
    }

    private void shareToMsg() {
 /*       ShareSDK.initSDK(context);
        ShortMessage.ShareParams sp = new ShortMessage.ShareParams();
        sp.setTitle(shareTitle);
        sp.setText(shareDescription);
//        sp.setImagePath(imagePath);
//        sp.setTitleUrl(shareLink);
        Platform shortMessge = ShareSDK.getPlatform(ShortMessage.NAME);
        shortMessge.setPlatformActionListener(platformActionListener);
        shortMessge.share(sp);*/
    }

    /**
     * 分享到qq
     */
    private void shareToQQ() {
     /*   ShareSDK.initSDK(context);
        cn.sharesdk.tencent.qq.QQ.ShareParams sp = new cn.sharesdk.tencent.qq.QQ.ShareParams();
        sp.setTitle(shareTitle);
        sp.setText(shareDescription);
        sp.setImagePath(imagePath);
        sp.setTitleUrl(shareLink);
        Platform qq = ShareSDK.getPlatform(QQ.NAME);
        qq.setPlatformActionListener(platformActionListener);
        qq.share(sp);*/
    }

    /**
     * 微信朋友圈
     */
    private void shareToWeChatMoment() {
        UMImage umImage = new UMImage(context, logoUrl);
        UMWeb web = new UMWeb(CusApplication.shareUrl);
        web.setDescription(shareDescription);//描述
        web.setThumb(umImage);
        web.setTitle(shareTitle);
        new ShareAction(context)
                .setPlatform(SHARE_MEDIA.WEIXIN_CIRCLE)//传入平台
                .withMedia(web)//分享内容
                .setCallback(shareListener)//回调监听器
                .share();

  /*      ShareSDK.initSDK(context);
        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setShareType(Platform.SHARE_WEBPAGE); //非常重要：一定要设置分享属性
        sp.setTitle(shareTitle);  //分享标题
        sp.setText(shareDescription);   //分享文本
        sp.setImageData(BitmapFactory.decodeResource(context.getResources(), R.mipmap.icon));
        sp.setUrl(shareLink);   //网友点进链接后，可以看到分享的详情
        //3、非常重要：获取平台对象
        Platform wechatMoments = ShareSDK.getPlatform(WechatMoments.NAME);
        wechatMoments.setPlatformActionListener(platformActionListener);
        // 设置分享事件回调
        // 执行分享
        wechatMoments.share(sp);*/
    }


    /**
     * 微信好友
     */
    private void shareToWechat() {
        UMImage umImage = new UMImage(context, logoUrl);
        UMWeb web = new UMWeb(CusApplication.shareUrl);
        web.setTitle(shareTitle);
        web.setDescription(shareDescription);//描述
        web.setThumb(umImage);
        new ShareAction(context)
                .setPlatform(SHARE_MEDIA.WEIXIN)//传入平台
                .withMedia(web)//分享内容
                .setCallback(shareListener)//回调监听器
                .share();


     /*   ShareSDK.initSDK(context);
        Platform.ShareParams sp = new Platform.ShareParams();
        sp.setShareType(Platform.SHARE_WEBPAGE);//非常重要：一定要设置分享属性
        sp.setTitle(shareTitle);  //分享标题
        sp.setText(shareDescription);   //分享文本
        sp.setImageData(BitmapFactory.decodeResource(context.getResources(),  R.mipmap.icon));
        sp.setUrl(shareLink);   //网友点进链接后，可以看到分享的详情
        //3、非常重要：获取平台对象
        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
        wechat.setPlatformActionListener(platformActionListener);
        // 执行分享
        wechat.share(sp);*/
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
//            toas.showToast(context, "分享成功");
            Toast.makeText(context, "分享成功", Toast.LENGTH_SHORT).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Log.i("zhang_xin", "SharePopwindow====>分享失败" + t.getMessage() + "原因：" + t.getCause());
            Toast.makeText(context, "分享失败，请稍后重试", Toast.LENGTH_SHORT).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {

//            Toast.makeText(getActivity(),"取消了",Toast.LENGTH_LONG).show();
            Toast.makeText(context, "取消分享", Toast.LENGTH_SHORT).show();

        }
    };

    //    private void shareEWMToWeChat(){
//        ShareSDK.initSDK(context);
//        Platform.ShareParams sp = new Platform.ShareParams();
//        sp.setShareType(Platform.SHARE_IMAGE);//非常重要：一定要设置分享属性
//        sp.setImageUrl(ewmUrl);
//        //3、非常重要：获取平台对象
//        Platform wechat = ShareSDK.getPlatform(Wechat.NAME);
//        wechat.setPlatformActionListener(platformActionListener); // 设置分享事件回调
//        // 执行分享
//        wechat.share(sp);
//    }
    private void saveIcon() {
    /*    InputStream in = null;
        FileOutputStream fileOutputStream = null;
        try{
            File file = new File(imagePath);
            if (!file.exists()) {
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                in = context.getResources().getAssets().open("icon.png");
                fileOutputStream = new FileOutputStream(file);
                byte[] buffer = new byte[1024];
                while (-1 != in.read(buffer)) {
                    fileOutputStream.write(buffer);
                }
                in.close();
                fileOutputStream.close();
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    PlatformActionListener platformActionListener=  new PlatformActionListener() {

        @Override
        public void onError(Platform arg0, int arg1, Throwable arg2) {
            ToastUtils.showToast(context,"数据异常，请稍后再试");
        }

        @Override
        public void onComplete(Platform arg0, int arg1, HashMap<String, Object> arg2) {
            ToastUtils.showToast(context,"分享成功");
        }

        @Override
        public void onCancel(Platform arg0, int arg1) {
            ToastUtils.showToast(context,"分享取消");
        }
    };*/
    }
}
