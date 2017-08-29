package com.jiyun.qcloud.dashixummoban.ui.live.network;


import com.jiyun.qcloud.dashixummoban.entity.Live.VedioBeans;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by lenovo on 2017/8/24.
 */

public class VedioPresenter implements VedioContract.Presenter {
    private VedioContract.View vedioView;
    private IPandaLiveModel liveModel;
     /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */

    public VedioPresenter(VedioContract.View vedioView) {
        this.vedioView = vedioView;
        vedioView.setPresenter(this);
        this.liveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {

    }

    @Override
    public void getData(String url) {
       liveModel.loadVedioList(url, new NetWorkCallBack<VedioBeans>() {
           @Override
           public void onSuccess(VedioBeans vedioBeans) {
               vedioView.showHomeListData(vedioBeans);
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
