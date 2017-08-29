package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.Live.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.FasongBean;
import com.jiyun.qcloud.dashixummoban.ui.live.adapter.XREAdapter;

import java.util.ArrayList;

/**
 * Created by lenovo on 2017/8/23.
 */

public class LookFragment extends BaseFragment implements BianLiveContract.BianLiveView, View.OnClickListener {
    private BianLiveContract.BianLivePresenter bianLivePresenter;
    private EditText biankan_ed;
    private Button biankan_button;
    private XRecyclerView biankan_xrecyclerview;
    private XREAdapter adapter;
    private SharedPreferences sp;
    private ArrayList<BiankanBianliaoBean.DataBean.ContentBean> list = new ArrayList<>();

    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){

                case 2:
                    initData();
                    biankan_xrecyclerview.refresh();
                    adapter.notifyDataSetChanged();
                    break;
                case 3:
                    biankan_xrecyclerview.loadMoreComplete();
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
    };
    @Override
    protected int getLayoutRes() {
        return R.layout.look_fragment;
    }

    @Override
    protected void initData() {
        bianLivePresenter = new BianLivePresenter(this);
        bianLivePresenter.start();
    }

    @Override
    protected void initView(View view) {
        biankan_ed = view.findViewById(R.id.biankan_ed);
        biankan_button = view.findViewById(R.id.biankan_button);
        biankan_xrecyclerview = view.findViewById(R.id.biankan_xrecyclerview);
        biankan_button.setOnClickListener(this);

        sp = getActivity().getSharedPreferences("test", Context.MODE_PRIVATE);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        biankan_xrecyclerview.setLayoutManager(layoutManager);
        biankan_xrecyclerview.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        biankan_xrecyclerview.setArrowImageView(R.drawable.iconfont_downgrey);
        biankan_xrecyclerview.setLoadingMoreProgressStyle(ProgressStyle.Pacman);

        biankan_xrecyclerview.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                handler.sendEmptyMessageDelayed(2,1500);
            }

            @Override
            public void onLoadMore() {
                handler.sendEmptyMessageDelayed(2,1500);
                initData();
            }
        });
        adapter = new XREAdapter(list, getActivity());
        biankan_xrecyclerview.setAdapter(adapter);
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
    public void setPresenter(BianLiveContract.BianLivePresenter bianLivePresenter) {
        bianLivePresenter=bianLivePresenter;
    }

    @Override
    public void setResultData(BiankanBianliaoBean resultData) {
        list.addAll(resultData.getData().getContent());
        Log.e("TG", list.get(0).getMessage());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setFasong(FasongBean fasong) {
        Toast.makeText(getActivity(), fasong.getMsg(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        String message = biankan_ed.getText().toString().trim();
        if (message.equals("")){
            Toast.makeText(getActivity(), "评论为空", Toast.LENGTH_SHORT).show();
        }else {
            bianLivePresenter.setFasong("ipandaApp",
                    "央视网友8l8z3x8y",
                    "54069357",
                    "dWlkPTU0MDY5MzU3JnRpbWU9MTUwMDcwNTUxOQ==",
                    "zhiboye_chat",message);
            biankan_ed.setText("");
        }
    }
}
