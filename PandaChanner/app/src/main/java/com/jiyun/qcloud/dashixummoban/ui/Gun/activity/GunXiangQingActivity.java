package com.jiyun.qcloud.dashixummoban.ui.Gun.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;


public class GunXiangQingActivity extends BaseActivity {

    @BindView(R.id.backImg)
    ImageView backImg;
    @BindView(R.id.titleTv)
    TextView titleTv;
    @BindView(R.id.tv_first_timer)
    TextView tvFirstTimer;
    @BindView(R.id.rbtn_collection_broad)
    CheckBox rbtnCollectionBroad;
    @BindView(R.id.img_share_broad)
    ImageView imgShareBroad;

    @Override
    protected void initData() {
        backImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        rbtnCollectionBroad.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b == true) {
                    Toast.makeText(GunXiangQingActivity.this, "已添加，请到我的收藏查看", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GunXiangQingActivity.this, "已取消收藏", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_gun_xiang_qing;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
