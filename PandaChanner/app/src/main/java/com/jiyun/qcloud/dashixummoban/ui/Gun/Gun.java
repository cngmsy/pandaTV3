package com.jiyun.qcloud.dashixummoban.ui.Gun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiyun.qcloud.dashixummoban.R;
import com.jiyun.qcloud.dashixummoban.adapter.GunLvAdapter;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.jiyun.qcloud.dashixummoban.entity.gun.BigImgBean;
import com.jiyun.qcloud.dashixummoban.entity.gun.GunData;
import com.jiyun.qcloud.dashixummoban.entity.gun.ListBean;
import com.jiyun.qcloud.dashixummoban.ui.Gun.ivewgun.IViewGunPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/8/23 0023.
 */

public class Gun extends BaseFragment implements IViewGunPresenter.View{
    @BindView(R.id.lv_gun)
    ListView lvGun;
    Unbinder unbinder;

    private List<ListBean> list = new ArrayList<>();
    private GunLvAdapter lvAdapter;
    IViewGunPresenter.Presenter presenter;
    private ImageView photoImg;
    private TextView titlehead;

    @Override
    protected int getLayoutRes() {
        return R.layout.guo;
    }

    @Override
    protected void initData() {
        if (presenter != null) {
            presenter.start();
        }
    }

    @Override
    protected void initView(View view) {
        addHeaderView();
        lvAdapter = new GunLvAdapter(getActivity(), list);
        lvGun.setAdapter(lvAdapter);
    }

    /**
     * 添加一个头部
     */
    private void addHeaderView() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.item_lv_header, null);
        photoImg = view.findViewById(R.id.img_head_gun_photo);
        titlehead = view.findViewById(R.id.tv_head_gun_title);
        lvGun.addHeaderView(view);
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
    public void showHomeListData(GunData gunData) {
        List<BigImgBean> bigImg = gunData.getBigImg();
        BigImgBean bigImgBean = bigImg.get(0);
        String image = bigImgBean.getImage();
        Glide.with(getActivity()).load(image).into(photoImg);
        titlehead.setText(bigImgBean.getTitle());
        List<ListBean> list = gunData.getList();
       this.list.addAll(list);
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
    public void setPresenter(IViewGunPresenter.Presenter presenter) {
        this.presenter = presenter;
    }
}
