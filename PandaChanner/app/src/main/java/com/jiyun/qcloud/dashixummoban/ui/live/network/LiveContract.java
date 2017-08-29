package com.jiyun.qcloud.dashixummoban.ui.live.network;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.LiveBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivevedioBeans;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface LiveContract {

    interface View extends IBaseView<Presenter> {
        void showHomeListData(LiveBeans liveBeans);

        void showVedioList(LivevedioBeans livevedioBeans);
    }

    interface Presenter extends IBasePresenter {
        void getVedio(String url);
    }
}
