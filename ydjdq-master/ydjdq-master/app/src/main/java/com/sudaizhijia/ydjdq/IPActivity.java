package com.sudaizhijia.ydjdq;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sudaizhijia.ydjdq.http.API;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IPActivity extends AppCompatActivity {

    @BindView(R.id.ip1)
    Button ip1;
    @BindView(R.id.ip2)
    Button ip2;
    @BindView(R.id.et)
    EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ip);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.ip1, R.id.ip2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ip1:
                String trim = et.getText().toString().trim();
                API.SERVER_URL = "http://"+trim+"/app/v1/";
                break;
            case R.id.ip2:
                Toast.makeText(this,  API.SERVER_URL +"", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
