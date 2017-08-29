package com.jiyun.qcloud.dashixummoban.ui.live.network;


import com.jiyun.qcloud.dashixummoban.entity.Live.LiveBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivevedioBeans;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by lenovo on 2017/8/24.
 */

public class LivePresenter implements LiveContract.Presenter {
    private LiveContract.View liveView;
    private IPandaLiveModel liveModel;
     /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */

    public LivePresenter(LiveContract.View liveView) {
        this.liveView = liveView;
        liveView.setPresenter(this);
        this.liveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {
        liveModel.loadLiveList(new NetWorkCallBack<LiveBeans>() {
            @Override
            public void onSuccess(LiveBeans liveBeans) {
                liveView.showHomeListData(liveBeans);
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
    public void getVedio(String url) {
        liveModel.loadLiveVedio(url, new NetWorkCallBack<LivevedioBeans>() {
            @Override
            public void onSuccess(LivevedioBeans livevedioBeans) {
                liveView.showVedioList(livevedioBeans);
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
