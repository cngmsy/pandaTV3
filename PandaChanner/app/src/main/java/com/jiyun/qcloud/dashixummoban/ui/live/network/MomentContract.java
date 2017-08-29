package com.jiyun.qcloud.dashixummoban.ui.live.network;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.MomentBean;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface MomentContract {
    interface View extends IBaseView<Presenter> {
        void showHomeListData(MomentBean momentBean);
    }

    interface Presenter extends IBasePresenter {

    }
}
