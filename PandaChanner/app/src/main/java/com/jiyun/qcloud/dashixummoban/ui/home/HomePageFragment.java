package com.jiyun.qcloud.dashixummoban.ui.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.HomeAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by chj on 2017/8/20.
 */

public class HomePageFragment extends BaseFragment implements Home2Contract.View,Home2Contract.Home,Home2Contract.HomeG{
    @BindView(R.id.home_list)
    XRecyclerView homeList;
    Unbinder unbinder;
    private Home2Contract.Presenter presenter;
    private PandaHome.DataBean data;
    private PandaHome pandaHome;
    private Home2 home2;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initData() {
        presenter.start();
    }

    @Override
    protected void initView(View view) {
        homeList.setLoadingMoreEnabled(false);
        homeList.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                presenter.start();
                homeList.refreshComplete();
            }

            @Override
            public void onLoadMore() {

            }
        });
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void showHomeListData(PandaHome pandaHome) {
        this.pandaHome=pandaHome;
        data = pandaHome.getData();
        presenter.HomeG(data.getList().get(0).getListUrl());
        presenter.Home(data.getCctv().getListurl());

    }
    @Override
    public void showHomeListData(Home2 home2) {
        this.home2=home2;
    }
    @Override
    public void showHomeListData(Home3 home3) {
        if (home2!=null&&pandaHome!=null&&home3!=null) {
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            homeList.setLayoutManager(layoutManager);
            homeList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            homeList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
            //ArrayList<String> listData = new ArrayList<String>();
            HomeAdapter mAdapter = new HomeAdapter(pandaHome.getData(), home2, home3);
            homeList.setAdapter(mAdapter);
        }else {
            if (home2==null){
                presenter.Home(data.getCctv().getListurl());
                presenter.HomeG(data.getList().get(0).getListUrl());
            }else if (pandaHome==null){
                presenter.start();
                presenter.HomeG(data.getList().get(0).getListUrl());
            }else if (home3==null){
                presenter.HomeG(data.getList().get(0).getListUrl());
            }
            LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
            layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            homeList.setLayoutManager(layoutManager);
            homeList.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
            homeList.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
            //ArrayList<String> listData = new ArrayList<String>();
            HomeAdapter mAdapter = new HomeAdapter(pandaHome.getData(), home2, home3);
            homeList.setAdapter(mAdapter);

        }
    }


    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

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
    public void setPresenter(Home2Contract.Presenter presenter) {
        this.presenter=presenter;
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
