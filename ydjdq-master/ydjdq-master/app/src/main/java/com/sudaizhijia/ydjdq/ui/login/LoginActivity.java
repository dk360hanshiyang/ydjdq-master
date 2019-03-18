package com.sudaizhijia.ydjdq.ui.login;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.R;
import com.sudaizhijia.ydjdq.event.LoginEvent;
import com.sudaizhijia.ydjdq.global.CusApplication;
import com.sudaizhijia.ydjdq.mvp.MVPBaseActivity;
import com.sudaizhijia.ydjdq.ui.main.MainActivity;
import com.sudaizhijia.ydjdq.ui.webview.WebViewActivity;
import com.sudaizhijia.ydjdq.utils.ActivityUtils;
import com.sudaizhijia.ydjdq.utils.AppInfoUtil;
import com.sudaizhijia.ydjdq.wiget.CodeDialogView;
import com.sudaizhijia.ydjdq.wiget.MyDialog;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * Created by WilliamWang on 2018/12/8
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    @BindView(R.id.iv_back)
    ImageView ivBack;
    @BindView(R.id.et_user_phone)
    EditText etUserPhone;
    @BindView(R.id.rl_user_phone)
    RelativeLayout rlUserPhone;
    @BindView(R.id.et_user_password)
    EditText etUserPassword;
    @BindView(R.id.tv_code)
    TextView tvCode;
    @BindView(R.id.rl_password)
    RelativeLayout rlPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_user_agreement)
    TextView tvUserAgreement;
    @BindView(R.id.iv_clear)
    ImageView iv_clear;
    @BindView(R.id.iv_clear_or_code)
    ImageView iv_clear_or_code;
    @BindView(R.id.rl_code_err)
    RelativeLayout rlCodeErr;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.ll_clear)
    RelativeLayout llClear;

    private MyCount myCount;
    private MyDialog dialog;
    private int height;

    @Override
    protected void init() {
        etUserPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    iv_clear.setVisibility(View.VISIBLE);
                } else {
                    iv_clear.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        etUserPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length() > 0) {
                    iv_clear_or_code.setVisibility(View.VISIBLE);
                } else {
                    iv_clear_or_code.setVisibility(View.GONE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
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
                    mPresenter.getServiceNubler();
                }
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

    @OnClick({R.id.ll_clear, R.id.iv_clear_or_code, R.id.rl_code_err, R.id.rl_back, R.id.et_user_phone, R.id.rl_user_phone, R.id.et_user_password, R.id.tv_code, R.id.rl_password, R.id.btn_login, R.id.tv_user_agreement})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rl_code_err:
                mPresenter.getServiceNubler();

                break;
            case R.id.ll_clear:
                etUserPhone.setText("");
                etUserPhone.requestFocus();
                iv_clear.setVisibility(View.GONE);
                break;
            case R.id.iv_clear_or_code:
                etUserPassword.setText("");
                etUserPassword.requestFocus();
                iv_clear_or_code.setVisibility(View.GONE);
                break;
            case R.id.rl_back:
                finish();
                break;
            case R.id.tv_code:
                String phone = etUserPhone.getText().toString().trim();
                boolean mobile = AppInfoUtil.isMobile(phone);
                if (!mobile) {
                    etUserPhone.setText("");
                    Toast.makeText(LoginActivity.this, "请输入正确的手机号码", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    showTime(true);
                    mPresenter.getCode(phone);
                    etUserPassword.requestFocus();
                    rlCodeErr.setVisibility(View.VISIBLE);
                }

                break;
            case R.id.btn_login:
                String username = etUserPhone.getText().toString().trim();
                String password = etUserPassword.getText().toString().trim();
                if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
                    Toast.makeText(this, "手机号和验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                mPresenter.login(username, password);
                break;
            case R.id.tv_user_agreement:
                ActivityUtils.startActivity(getContext(), WebViewActivity.class);
                break;
        }
    }

    private void showCodeDialog(String servicePhone) {
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_code, null);
        TextView txtCallService = (TextView) dialogView.findViewById(R.id.txt_call_service);
        TextView txtDescribe = dialogView.findViewById(R.id.txt_describe);
        txtDescribe.setText("如果您长时间未收到验证码，可反馈给我们或者联系客服" + servicePhone + "，我们会尽快为你解决。");
        TextView txtFeedback = dialogView.findViewById(R.id.txt_feedback);
        CodeDialogView mMyDialog = new CodeDialogView(this, 0, 0, dialogView, R.style.DialogTheme);
        txtCallService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                call("tel:" + servicePhone);
                mMyDialog.dismiss();
//                call("tel:17610310022");
            }
        });
        txtFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMyDialog.dismiss();
            }
        });

        mMyDialog.setCancelable(true);
        mMyDialog.show();
    }

    @Override
    public void showTime(boolean isShow) {
        if (isShow) {
            myCount = new MyCount(60 * 1000, 1000);
            myCount.start();
        } else if (isShow) {
            myCount.cancel();
            myCount = null;
            tvCode.setTextColor(Color.parseColor("#FF5A00"));
            tvCode.setText("发送验证码");
            Toast.makeText(this, "发送短信失败，请重试", Toast.LENGTH_SHORT).show();
            tvCode.setEnabled(true);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (myCount != null) {
            myCount.cancel();
        }
    }

    @Override
    public void loginSuccess() {
        ActivityUtils.startActivityFroTask(getContext(), MainActivity.class);
        finish();
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
        EventBus.getDefault().post(new LoginEvent());
        if (myCount != null) {
            myCount.cancel();
            myCount = null;
        }
        Toast.makeText(this, CusApplication.object.getUsername() + "，欢迎您回来", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErr() {
        if (dialog != null) {
            dialog.dismiss();
            dialog = null;
        }
        etUserPhone.requestFocus();
        etUserPassword.setText("");

    }

    public void getScreen() {
        WindowManager wm = (WindowManager) this.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;         // 屏幕宽度（像素）
        // 屏幕高度（像素）
        height = dm.heightPixels;
    }

    @Override
    public void showLoading() {
        getScreen();
        View view = LayoutInflater.from(getContext()).inflate(R.layout.layout_loading, null);
        dialog = new MyDialog(getContext(), AppInfoUtil.dip2px(getContext(), 250), height / 3, view, R.style.lock_dialog);
        dialog.show();
    }


    @Override
    public void getPhone(String servicePhone) {
        showCodeDialog(servicePhone);


    }

    public class MyCount extends CountDownTimer {


        public MyCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            tvCode.setTextColor(Color.parseColor("#FF5A00"));
            tvCode.setEnabled(true);
            tvCode.setText("发送验证码");
        }

        @Override
        public void onTick(long millisUntilFinished) {
            long l = millisUntilFinished / 1000;
            tvCode.setEnabled(false);
            tvCode.setTextColor(Color.parseColor("#FF5A00"));
            tvCode.setText(l + "s后重发");
        }
    }
}
