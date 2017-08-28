package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/26 0026.
 */

public class Home2Ptresenter implements Home2Contract.Presenter {
    private final Home2Contract.HomeG homeG;
    private Home2Contract.View home2View;
    private Home2Contract.Home home;
    private IPandaHomeModel homeModel;

    public Home2Ptresenter(Home2Contract.View home2View,Home2Contract.Home home,Home2Contract.HomeG homeG) {
             this.home2View=home2View;
        this.home=home;
        this.homeG=homeG;
        home2View.setPresenter(this);
        this.homeModel=new PandaHomeModelImpl();
    }
    @Override
    public void start() {
        home2View.showProgress();
        homeModel.loadHomeList(new NetWorkCallBack<PandaHome>() {
            @Override
            public void onSuccess(PandaHome pandaHome) {
                home2View.showHomeListData(pandaHome);
                home2View.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                home2View.showMessage(errorMsg);
                home2View.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void Home(String uri) {
        home.showProgress();
        homeModel.HomeUri(new NetWorkCallBack<Home2>() {
            @Override
            public void onSuccess(Home2 home2) {
                home.showHomeListData(home2);
                home.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                home.showMessage(errorMsg);
                home.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },uri);
    }

    @Override
    public void HomeG(String uri) {
        homeG.showProgress();;
        homeModel.Home3Uri(new NetWorkCallBack<Home3>() {
            @Override
            public void onSuccess(Home3 home3) {
                homeG.showHomeListData(home3);
                home.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                homeG.showMessage(errorMsg);
                homeG.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },uri);
    }

}
