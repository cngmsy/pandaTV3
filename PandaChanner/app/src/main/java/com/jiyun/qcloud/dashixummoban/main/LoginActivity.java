package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.WideAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jude.rollviewpager.RollPagerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity {
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
        }
    };
    @BindView(R.id.wide)
    RollPagerView wide;
    @BindView(R.id.imag_login)
    ImageView imagLogin;
    @BindView(R.id.Text_long)
    TextView TextLong;

    @Override
    protected void initData() {

        SharedPreferences preferences = getSharedPreferences("nam", MODE_PRIVATE);
        final SharedPreferences.Editor edit = preferences.edit();
        boolean wed = preferences.getBoolean("wed", false);
        if (wed) {
            imagLogin.setVisibility(View.VISIBLE);
            wide.setVisibility(View.GONE);
            handler.sendEmptyMessageDelayed(0, 5000);
        } else {
            imagLogin.setVisibility(View.GONE);
            wide.setVisibility(View.VISIBLE);
            WideAdapter adapter = new WideAdapter();
            wide.setAdapter(adapter);
            TextLong.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    edit.putBoolean("wed", true);
                    edit.commit();
                }
            });
        }
    }
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
