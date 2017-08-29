package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.entity.ChinaBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by dell on 2017/8/26.
 */

public class ChinaPresenter implements ChinaContract.Presenter {

    private ChinaContract.View chinaview;
    private IPandaHomeModel homeModel;

    public ChinaPresenter(ChinaContract.View chinaview) {
        this.chinaview = chinaview;
        chinaview.setPresenter(this);
        this.homeModel=new PandaHomeModelImpl();
    }

    @Override
    public void start() {
        chinaview.showProgress();
        homeModel.loadChinaList(new NetWorkCallBack<ChinaBean>() {
            @Override
            public void onSuccess(ChinaBean chinaBean) {
                chinaview.loadChinaList(chinaBean);
                chinaview.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                chinaview.showMessage(errorMsg);
                chinaview.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }



}
