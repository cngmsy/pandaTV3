package com.jiyun.qcloud.dashixummoban.ui.live.video;

import android.content.Intent;
import android.os.Bundle;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Live.VedioBeans;
import com.jiyun.qcloud.dashixummoban.ui.live.network.VedioContract;
import com.jiyun.qcloud.dashixummoban.ui.live.network.VedioPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

public class VedioActivity extends BaseActivity implements VedioContract.View {

    @BindView(R.id.videocontroller)
    JCVideoPlayer videocontroller;
    private String video_url;
    private VedioContract.Presenter presenter;

    @Override
    protected void initData() {
        presenter = new VedioPresenter(this);
        presenter.getData(video_url);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        video_url = intent.getStringExtra("url");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_vedio;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        JCVideoPlayer.releaseAllVideos();
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
    public void setPresenter(VedioContract.Presenter presenter) {
        this.presenter=presenter;
    }

    @Override
    public void showHomeListData(VedioBeans vedioBeans) {
        String url = vedioBeans.getVideo().getChapters().get(0).getUrl();
        String title = vedioBeans.getTitle();
        videocontroller.setUp(url,title);
    }
}
