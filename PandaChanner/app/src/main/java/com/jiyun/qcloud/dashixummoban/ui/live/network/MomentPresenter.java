package com.jiyun.qcloud.dashixummoban.ui.live.network;

import com.jiyun.qcloud.dashixummoban.entity.Live.MomentBean;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.IPandaLiveModel;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.PandaLiveModelImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lenovo on 2017/8/24.
 */

public class MomentPresenter implements MomentContract.Presenter {
    private MomentContract.View momentView;
    private IPandaLiveModel liveModel;
    private String id;
    private int p;
     /*
       在构造方法里面做了什么事情;   初始化了HomeView  这时候的homeView相当于HomePageFragent
       同时在这个构造方法中有初始化了homeModel   HomeModel里面就是网络请求后从服务器返回的bean结果
     */

    public MomentPresenter(MomentContract.View momentView, int p, String id) {
        this.momentView = momentView;
        momentView.setPresenter(this);
        this.p = p;
        this.id = id;
        this.liveModel = new PandaLiveModelImpl();
    }

    @Override
    public void start() {
        momentView.showProgress();
        Map<String, String> params = new HashMap<>();
        params.put("vsid", id);
        params.put("n", "7");
        params.put("serviceId", "panda");
        params.put("o", "desc");
        params.put("p", p + "");
        liveModel.loadLiveMomentlist(params, new NetWorkCallBack<MomentBean>() {
            @Override
            public void onSuccess(MomentBean momentBean) {
                momentView.showHomeListData(momentBean);
                momentView.dimissProgress();
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                momentView.showMessage(errorMsg);
                momentView.dimissProgress();
            }

            @Override
            public void onFail(String netOff) {

            }
        });
    }
}
