package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.entity.Mp4;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class Mp4Ptresenter implements Mp4Contract.Presenter {

    private  Mp4Contract.Mp4jpa mp4jpa;
    private IPandaHomeModel homeModel;

    public Mp4Ptresenter(Mp4Contract.Mp4jpa mp4jpa) {
        this.mp4jpa=mp4jpa;
        mp4jpa.setPresenter(this);
        homeModel = new PandaHomeModelImpl();
    }


    @Override
    public void Mp4(String url) {
        mp4jpa.showProgress();
        homeModel.Mp4Uri(new NetWorkCallBack<Mp4>() {
            @Override
            public void onSuccess(Mp4 mp4) {
                mp4jpa.showHomeListData(mp4);
                mp4jpa.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                mp4jpa.showMessage(errorMsg);
                mp4jpa.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        },url);
    }
}
