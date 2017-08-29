package com.jiyun.qcloud.dashixummoban.ui.live;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivePageBeans;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface LivepageContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(LivePageBeans livePageBeans);
    }

    interface Presenter extends IBasePresenter {

    }
}
