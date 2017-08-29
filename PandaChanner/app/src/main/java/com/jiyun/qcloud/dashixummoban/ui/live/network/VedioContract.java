package com.jiyun.qcloud.dashixummoban.ui.live.network;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.VedioBeans;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface VedioContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(VedioBeans vedioBeans);
    }

    interface Presenter extends IBasePresenter {
        void getData(String url);
    }
}
