package com.jiyun.qcloud.dashixummoban.ui.home;


import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.base.IPresenter;

import com.jiyun.qcloud.dashixummoban.entity.ChinaBean;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;

/**
 * Created by dell on 2017/8/26.
 */

public interface ChinaContract {
    interface View extends IBaseView<Presenter>{
        void loadChinaList(ChinaBean chinaBean);
        void playVideo();
        void loadWebView();
    }
    interface Presenter extends IPresenter {}
}
