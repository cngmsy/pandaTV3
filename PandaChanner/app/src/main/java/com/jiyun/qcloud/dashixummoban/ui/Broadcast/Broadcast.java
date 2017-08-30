package com.jiyun.qcloud.dashixummoban.ui.Broadcast;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.BuildConfig;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.BroadLVAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.broadcast.BigImgBean;
import com.jiyun.qcloud.dashixummoban.entity.broadcast.BroadCastBean;
import com.jiyun.qcloud.dashixummoban.entity.broadcast.DataBean;
import com.jiyun.qcloud.dashixummoban.entity.broadcast.listbody.BroadListBodyBean;
import com.jiyun.qcloud.dashixummoban.entity.broadcast.listbody.ListBean;
import com.jiyun.qcloud.dashixummoban.main.MainActivity;
import com.jiyun.qcloud.dashixummoban.modle.net.OkBaseHttpImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;
import com.jiyun.qcloud.dashixummoban.ui.Broadcast.activity.BroadcastXiangQingActivity;
import com.jiyun.qcloud.dashixummoban.ui.Broadcast.activity.PlayerVideoActivity;
import com.jiyun.qcloud.dashixummoban.ui.Broadcast.iview.IviewBroadcast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import in.srain.cube.views.ptr.PtrClassicDefaultHeader;
import in.srain.cube.views.ptr.PtrClassicFrameLayout;
import in.srain.cube.views.ptr.PtrDefaultHandler2;
import in.srain.cube.views.ptr.PtrFrameLayout;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class Broadcast extends BaseFragment implements IviewBroadcast.View {
    @BindView(R.id.lv_home_broadcast)
    ListView lvHomeBroadcast;
    Unbinder unbinder;
    @BindView(R.id.ptr_layout)
    PtrClassicFrameLayout ptrLayout;

    private BroadLVAdapter adapter;
    private TextView titleTv;
    IviewBroadcast.Presenter presenter;
    private List<ListBean> listBody = new ArrayList<>();
    private ImageView photoImg;
    private List<BigImgBean> bigImg;
    private ProgressDialog dialog;
    private List<ListBean> list;

    @Override
    protected int getLayoutRes() {
        return R.layout.base_fragment;
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.start();
        }
        lvHomeBroadcast.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), BroadcastXiangQingActivity.class);
                ListBean listBean = listBody.get(i);
                intent.putExtra("listBean", listBean);
                startActivity(intent);
            }
        });

        photoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(), IjkFullsclenActivity.class);
//                BigImgBean bigImgBean = bigImg.get(0);
//                intent.putExtra("mp4",bigImgBean.getPid());
//                intent.putExtra("name",bigImgBean.getTitle());
//                startActivity(intent);
            }
        });
    }

    @Override
    protected void initView(View view) {
        unbinder = ButterKnife.bind(this, view);
        addHeadView();
        setListener();
        adapter = new BroadLVAdapter(getActivity(), listBody);
        lvHomeBroadcast.setAdapter(adapter);
    }

    private void setListener() {
        // 为布局设置下拉刷新和上拉加载的回调事件
        ptrLayout.setPtrHandler(new PtrDefaultHandler2() {
            @Override
            public void onLoadMoreBegin(PtrFrameLayout frame) { // 上拉加载的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < 10; i++) {
                            listBody.add(list.get(i));
                        }
                        adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onRefreshBegin(PtrFrameLayout frame) { // 下拉刷新的回调方法
                frame.postDelayed(new Runnable() {
                    @Override
                    public void run() {
//                        dataSource.add(0, "New Top List Item");
                        listBody.clear();
                        for (int i = 0; i < 10; i++) {
                            listBody.add(list.get(i));
                        }
                        adapter.notifyDataSetChanged();
                        ptrLayout.refreshComplete();
//                        lv.smoothScrollToPosition(0);
                    }
                }, 1000);
            }
        });
    }

    private void addHeadView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_lv_header, null);
        titleTv = view.findViewById(R.id.tv_head_gun_title);
        photoImg = view.findViewById(R.id.img_head_gun_photo);
        lvHomeBroadcast.addHeaderView(view);
    }

    @Override
    public void setBundle(Bundle bundle) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void showHomeListData(BroadCastBean broadCastBean) {
        DataBean data = broadCastBean.getData();
        bigImg = data.getBigImg();
        BigImgBean bigImgBean = bigImg.get(0);
        titleTv.setText(bigImgBean.getTitle());
        String image = bigImgBean.getImage();
        Glide.with(getActivity()).load(image).into(photoImg);
        getNetListBody(data);
        adapter.notifyDataSetChanged();
    }

    private void getNetListBody(DataBean data) {
        String listurl = data.getListurl();
        OkBaseHttpImpl instance = OkBaseHttpImpl.getInstance();
        ProgressDialog dialog = new ProgressDialog(getActivity());
        dialog.show();
        instance.get(listurl, null, new NetWorkCallBack<BroadListBodyBean>() {

            @Override
            public void onSuccess(BroadListBodyBean broadListBodyBean) {
                list = broadListBodyBean.getList();
                for (int i = 0; i < 10; i++) {
                    listBody.add(list.get(i));
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                if (BuildConfig.DEBUG) Log.d("Broadcast", errorMsg);
            }

            @Override
            public void onFail(String netOff) {
                if (BuildConfig.DEBUG) Log.d("Broadcast", netOff);
            }
        });
        dialog.dismiss();
    }

    @Override
    public void playVideo() {

    }

    @Override
    public void loadWebView() {

    }

    @Override
    public void showProgress() {
        dialog = new ProgressDialog(getActivity());
        dialog.show();
    }

    @Override
    public void dimissProgress() {
        dialog.dismiss();
    }

    @Override
    public void showMessage(String msg) {
    }

    @Override
    public void setPresenter(IviewBroadcast.Presenter presenter) {
        this.presenter = presenter;
    }




}
