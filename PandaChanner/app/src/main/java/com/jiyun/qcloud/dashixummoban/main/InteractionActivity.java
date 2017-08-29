package com.jiyun.qcloud.dashixummoban.main;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.Interaction_net.InterContract;
import com.jiyun.qcloud.dashixummoban.Interaction_net.InteractionPresenter;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.InterAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.entity.Live.HuDongBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InteractionActivity extends BaseActivity implements InterContract.View {

    @BindView(R.id.inter_back)
    ImageView interBack;
    private InterContract.Presenter presenter;
    private InterAdapter adapter;
    private XRecyclerView recyclerView;
    private List<HuDongBean.InteractiveBean> list = new ArrayList<>();
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initData();
                    adapter.notifyDataSetChanged();
                    recyclerView.refreshComplete();
                    break;
                case 2:
                    recyclerView.loadMoreComplete();
                    break;
            }
        }
    };

    @Override
    protected void initData() {
        presenter = new InteractionPresenter(this);
        presenter.start();
    }

    @Override
    protected void initView() {
        recyclerView = (XRecyclerView) this.findViewById(R.id.interaction_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(InteractionActivity.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        recyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        adapter = new InterAdapter(InteractionActivity.this, list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(1, 500);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(2, 3000);
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_interaction;
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
    public void setPresenter(InterContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void loadInteraction(HuDongBean bean) {
        if (bean != null) {
            list.addAll(bean.getInteractive());
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.inter_back)
    public void onViewClicked() {
        finish();
    }
}

