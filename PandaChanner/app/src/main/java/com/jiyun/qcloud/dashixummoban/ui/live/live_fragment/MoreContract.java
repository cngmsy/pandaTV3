package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface MoreContract {
    interface View extends IBaseView<Presenter> {
        void showHomeListData(MoreBeans moreBeans);
    }

    interface Presenter extends IBasePresenter {
    }
}
