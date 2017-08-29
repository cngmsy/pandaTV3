package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import com.jiyun.qcloud.dashixummoban.entity.Live.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.FasongBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by w1565 on 2017/7/21.
 */

public class BianLivePresenter implements BianLiveContract.BianLivePresenter {
    private BianLiveContract.BianLiveView bianLiveView;
    private PandaLiveModelImpl modelImp;

    public BianLivePresenter(BianLiveContract.BianLiveView bianLiveView) {
        this.bianLiveView = bianLiveView;
        modelImp = new PandaLiveModelImpl();
        bianLiveView.setPresenter(this);
    }

    @Override
    public void start() {
        modelImp.getBiankanBianliaoData(new NetWorkCallBack<BiankanBianliaoBean>() {
            @Override
            public void onSuccess(BiankanBianliaoBean biankanBianliaoBean) {
                bianLiveView.setResultData(biankanBianliaoBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }

    @Override
    public void setFasong(String app, String author, String authorid, String data, String itemid, String message) {
        modelImp.getFasongData(app, author, authorid, data, itemid, message, new NetWorkCallBack<FasongBean>() {
            @Override
            public void onSuccess(FasongBean fasongBean) {
                bianLiveView.setFasong(fasongBean);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {

            }

            @Override
            public void onFail(String netOff) {

            }
        });

    }
}
