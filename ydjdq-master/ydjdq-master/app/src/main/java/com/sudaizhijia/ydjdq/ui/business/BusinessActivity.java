package com.sudaizhijia.ydjdq.ui.business;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Html;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.bean.AboutBean;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.utils.StatusBarUtil;
import com.umeng.analytics.MobclickAgent;

import butterknife.BindView;
import butterknife.OnClick;

import static com.sudaizhijia.ydjdq.ui.login.LoginActivity.REQUEST_CALL_PERMISSION;


/**
 * MVPPlugin
 * 邮箱 784787081@qq.com
 */

public class BusinessActivity extends MVPBaseActivity<BusinessContract.View, BusinessPresenter> implements BusinessContract.View {

    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.rl_back)
    RelativeLayout rl_back;


    @Override
    protected void init() {
        StatusBarUtil.setRootViewFitsSystemWindows(this, false);
        mPresenter.getData();
        rl_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
//        String str = "恭喜您！您的手机跑分为<font color='#F50057'><big><big><big>888888分</big></big></big></font>，已经超过全国<font color='#00E676'><big><big><big>99%</big></big></big></font>的Android手机。";
//        tvEmail.setText(Html.fromHtml(str));

    }

    @OnClick({R.id.tv_phone, R.id.tv_email})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_email:
                Uri uri = Uri.parse(tvEmail.getText().toString());
                String[] email = {tvEmail.getText().toString()};
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_CC, email); // 抄送人
                intent.putExtra(Intent.EXTRA_SUBJECT, ""); // 主题
                intent.putExtra(Intent.EXTRA_TEXT, ""); // 正文
                startActivity(Intent.createChooser(intent, ""));
                break;
            case R.id.tv_phone:
                call("tel:" + tvPhone.getText().toString());
                break;
        }
    }

    /**
     * 拨打电话（直接拨打）
     *
     * @param telPhone 电话
     */
    public void call(String telPhone) {
        if (checkReadPermission(Manifest.permission.CALL_PHONE, REQUEST_CALL_PERMISSION)) {
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(telPhone));
            startActivity(intent);
        }
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_business;
    }

    public void onResume() {
        MobclickAgent.onPageStart("商务合作"); //手动统计页面("SplashScreen"为页面名称，可自定义)
        super.onResume();
    }

    public void onPause() {
        MobclickAgent.onPageEnd("商务合作"); //手动统计页面("SplashScreen"为页面名称，可自定义)，必须保证 onPageEnd 在 onPause 之前调用，因为SDK会在 onPause 中保存onPageEnd统计到的页面数据。
        super.onPause();
    }

    @Override
    public void showData(AboutBean bean) {
        tvEmail.setText(bean.getObject().getEmail());
        tvPhone.setText(bean.getObject().getTel());
    }

    public static final int REQUEST_CALL_PERMISSION = 10111; //拨号请求码

    /**
     * 判断是否有某项权限
     *
     * @param string_permission 权限
     * @param request_code      请求码
     * @return
     */
    public boolean checkReadPermission(String string_permission, int request_code) {
        boolean flag = false;
        if (ContextCompat.checkSelfPermission(this, string_permission) == PackageManager.PERMISSION_GRANTED) {//已有权限
            flag = true;
        } else {//申请权限
            ActivityCompat.requestPermissions(this, new String[]{string_permission}, request_code);
        }
        return flag;
    }

    /**
     * 检查权限后的回调
     *
     * @param requestCode  请求码
     * @param permissions  权限
     * @param grantResults 结果
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CALL_PERMISSION: //拨打电话
                if (permissions.length != 0 && grantResults[0] != PackageManager.PERMISSION_GRANTED) {//失败
                    Toast.makeText(this, "请允许拨号权限后再试", Toast.LENGTH_SHORT).show();
                } else {//成功

                }
                break;
        }
    }
}
