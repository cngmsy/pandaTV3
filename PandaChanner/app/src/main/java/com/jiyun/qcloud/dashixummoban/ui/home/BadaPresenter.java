package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaHomeModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaHomeModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by dell on 2017/8/29.
 */

public class BadaPresenter implements BadaContract.Presenter {
    private BadaContract.View view;
    private IPandaHomeModel iPandaHomeModel;
    private String url;

    public BadaPresenter(BadaContract.View view) {
        this.view = view;
        view.setPresenter(this);
        iPandaHomeModel=new PandaHomeModelImpl();

    }

    @Override
    public void start() {
        view.showProgress();
        iPandaHomeModel.loadBaList(url, new NetWorkCallBack<BadaBean>() {
            @Override
            public void onSuccess(BadaBean badaBean) {
                view.loadBaList(badaBean);
                view.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                view.showMessage(errorMsg);
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public String getUrl(String url) {
        this.url=url;
        return url;
    }
}
