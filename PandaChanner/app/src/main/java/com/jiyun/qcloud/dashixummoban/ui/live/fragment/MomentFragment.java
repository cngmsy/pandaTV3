package com.jiyun.qcloud.dashixummoban.ui.live.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Live.MomentBean;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.FragmentAdapter;
import com.jiyun.qcloud.dashixummoban.ui.live.network.MomentContract;
import com.jiyun.qcloud.dashixummoban.ui.live.network.MomentPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by lenovo on 2017/8/23.
 */

public class MomentFragment extends BaseFragment implements MomentContract.View {

    Unbinder unbinder;
    @BindView(R.id.xRecycler)
    XRecyclerView xRecycler;
    private MomentContract.Presenter presenter;
    private FragmentAdapter adapter;
    private List<MomentBean.VideoBean> list = new ArrayList<>();
    private int p = 1;
    private String id;


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    initData();
                    adapter.notifyDataSetChanged();
                    xRecycler.refreshComplete();
                    break;
                case 2:
                    xRecycler.loadMoreComplete();
                    p++;
                    initData();
                    xRecycler.refreshComplete();
                    break;
            }
        }
    };

    @Override
    protected int getLayoutRes() {
        return R.layout.moment_fragment;
    }

    @Override
    protected void initData() {
        Bundle arguments = getArguments();
        id = arguments.getString("vsid");
        presenter = new MomentPresenter(this, p, id);
        presenter.start();
    }

    @Override
    protected void initView(View view) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecycler.setLayoutManager(layoutManager);
        xRecycler.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecycler.setLoadingMoreProgressStyle(ProgressStyle.BallRotate);
        adapter = new FragmentAdapter(getContext(), list);
        xRecycler.setAdapter(adapter);
        xRecycler.setLoadingListener(new XRecyclerView.LoadingListener() {
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
    public void setPresenter(MomentContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void showHomeListData(MomentBean momentBean) {
        if (momentBean != null) {
            list.addAll(momentBean.getVideo());
            adapter.notifyDataSetChanged();
        }
    }
}