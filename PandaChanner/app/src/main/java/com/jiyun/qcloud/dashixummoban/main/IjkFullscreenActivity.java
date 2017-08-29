package com.jiyun.qcloud.dashixummoban.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.bumptech.glide.Glide;
import com.dl7.player.media.IjkPlayerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Mp4;
import com.jiyun.qcloud.dashixummoban.ui.home.Mp4Contract;
import com.jiyun.qcloud.dashixummoban.ui.home.Mp4Ptresenter;
import com.orhanobut.logger.Logger;

import butterknife.BindView;
import butterknife.ButterKnife;

public class IjkFullscreenActivity extends BaseActivity implements Mp4Contract.Mp4jpa {

    @BindView(R.id.play)
    IjkPlayerView play;
    private Mp4Contract.Presenter presenter;
    private String name;

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String mp4 = intent.getStringExtra("mp4");
        name = intent.getStringExtra("name");
        Glide.with(this).load(R.drawable._row1).into(play.mPlayerThumb);
        if (mp4!=null){
            new Mp4Ptresenter(this);
            presenter.Mp4(mp4);
        }else {
            play.init().setTitle(name).alwaysFullScreen().setVideoPath("http://vod.cntv.lxdns.com/flash/mp4video61/TMS/2017/08/27/26bb0b9e822a42f9959aa450cfa2fc47_h264418000nero_aac32.mp4").start();
        }

    }

    @Override
    protected void initView() {

    }
    @Override
    protected void onResume() {
        super.onResume();
        play.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        play.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        play.onDestroy();
    }
    @Override
    protected int getLayoutId() {
        return R.layout.activity_ijk_fullscreen;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void dimissProgress() {

    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void setPresenter(Mp4Contract.Presenter presenter) {
                this.presenter=presenter;
    }

    @Override
    public void showHomeListData(Mp4 mp4) {
            play.init().setTitle(name).alwaysFullScreen().setVideoPath(mp4.getVideo().getChapters().get(0).getUrl()).start();
    }
    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }
}
