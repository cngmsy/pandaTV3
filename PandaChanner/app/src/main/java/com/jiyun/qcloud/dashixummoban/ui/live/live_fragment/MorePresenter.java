package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by lenovo on 2017/8/24.
 */

public class MorePresenter implements MoreContract.Presenter {
    private MoreContract.View moreView;
    private IPandaLiveModel homeModel;

    /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */
    public MorePresenter(MoreContract.View moreView) {
        this.moreView = moreView;
        moreView.setPresenter(this);
        this.homeModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {
        moreView.showProgress();
        homeModel.loadLiveMoreList(new NetWorkCallBack<MoreBeans>() {
            @Override
            public void onSuccess(MoreBeans moreBeans) {
                moreView.showHomeListData(moreBeans);
                moreView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                moreView.showMessage(errorMsg);
                moreView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}