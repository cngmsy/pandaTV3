package com.jiyun.qcloud.dashixummoban.ui.live;


import com.jiyun.qcloud.dashixummoban.entity.Live.LivePageBeans;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by lenovo on 2017/8/24.
 */

public class LivepagePresenter implements LivepageContract.Presenter {
    private LivepageContract.View pageView;
    private IPandaLiveModel liveModel;
     /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */
    public LivepagePresenter(LivepageContract.View pageView) {
        this.pageView = pageView;
        pageView.setPresenter(this);
        this.liveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {
        pageView.showProgress();
        liveModel.loadPageList(new NetWorkCallBack<LivePageBeans>() {
            @Override
            public void onSuccess(LivePageBeans livePageBeans) {
                pageView.showHomeListData(livePageBeans);
                pageView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                pageView.showMessage(errorMsg);
                pageView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
