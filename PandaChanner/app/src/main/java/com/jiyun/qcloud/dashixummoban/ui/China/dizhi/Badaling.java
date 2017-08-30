package com.jiyun.qcloud.dashixummoban.ui.China.dizhi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.BaAdapter;
import com.jiyun.qcloud.dashixummoban.adapter.BaAdapter2;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.ui.home.BadaContract;
import com.jiyun.qcloud.dashixummoban.ui.home.BadaPresenter;
import com.jiyun.qcloud.dashixummoban.ui.live.network.LivePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;

/**
 * Created by dell on 2017/8/26.
 */

public class Badaling extends BaseFragment implements BadaContract.View {


    @BindView(R.id.mylv)
    XRecyclerView mylv;
    Unbinder unbinder;
    private ArrayList<BadaBean.LiveBean> list = new ArrayList<>();

    private BaAdapter2 adapter;
    private BadaContract.Presenter presenter;
    private String url;
    private List<BadaBean.LiveBean> live;

    public Badaling(String url) {
        this.url = url;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.taishan;
    }

    @Override
    protected void initData() {
        IntentFilter filter=new IntentFilter();
        filter.addAction("axcv");
        getActivity().registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                show();
            }
        },filter);
    }

    private void show() {
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser){
            presenter = new BadaPresenter(this);
            presenter.start();
        }else {
            JCVideoPlayer.releaseAllVideos();
        }
    }

    @Override
    protected void initView(View view) {
        mylv.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                mylv.refreshComplete();
            }
            @Override
            public void onLoadMore() {
                mylv.loadMoreComplete();
            }
        });
    }

    @Override
    public void setBundle(Bundle bundle) {

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
    public void setPresenter(BadaContract.Presenter presenter) {
        this.presenter = presenter;
        presenter.getUrl(url);
    }

    @Override
    public void loadBaList(BadaBean movieBean) {
        live = movieBean.getLive();
        String title = live.get(0).getTitle();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mylv.setLayoutManager(linearLayoutManager);
        adapter = new BaAdapter2(getContext(), live);
        mylv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        JCVideoPlayer.releaseAllVideos();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
