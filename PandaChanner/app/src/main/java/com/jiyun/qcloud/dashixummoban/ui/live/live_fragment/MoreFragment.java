package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.MygrildAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/8/23.
 */

public class MoreFragment extends BaseFragment implements MoreContract.View {
    @BindView(R.id.live_more_gridview)
    GridView liveMoreGridview;
    Unbinder unbinder;
    private MygrildAdapter adapter;
    private MoreContract.Presenter presenter;
    private String id;

    @Override
    protected int getLayoutRes() {
        return R.layout.more_fragment;
    }

    @Override
    protected void initData() {
        presenter = new MorePresenter(this);
        presenter.start();
    }

    @Override
    protected void initView(View view) {

    }

    @Override
    public void setBundle(Bundle bundle) {

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
    public void setPresenter(MoreContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHomeListData(MoreBeans moreBeans) {
        final List<MoreBeans.ListBean> list = new ArrayList<>();
        list.addAll(moreBeans.getList());
        adapter = new MygrildAdapter(getContext(), list);
        liveMoreGridview.setAdapter(adapter);
        liveMoreGridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent();
                intent.putExtra("listBean", list.get(i));
                intent.setAction("hc");
                getActivity().sendBroadcast(intent);
            }
        });
    }
}
