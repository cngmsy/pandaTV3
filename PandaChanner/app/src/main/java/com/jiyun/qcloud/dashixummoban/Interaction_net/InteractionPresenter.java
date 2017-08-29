package com.jiyun.qcloud.dashixummoban.Interaction_net;

import com.jiyun.qcloud.dashixummoban.entity.Live.HuDongBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by lenovo on 2017/8/24.
 */

public class InteractionPresenter implements InterContract.Presenter {
    private InterContract.View view;
    private IPandaLiveModel liveModel;
    private String id;
    private int p;
     /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */

    public InteractionPresenter(InterContract.View view) {
        this.view = view;
        view.setPresenter(this);
        this.liveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {
        liveModel.loadInteraction(new NetWorkCallBack<HuDongBean>() {
            @Override
            public void onSuccess(HuDongBean bean) {
                view.loadInteraction(bean);
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
