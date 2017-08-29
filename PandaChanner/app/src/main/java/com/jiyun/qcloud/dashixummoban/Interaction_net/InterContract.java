package com.jiyun.qcloud.dashixummoban.Interaction_net;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.HuDongBean;

/**
 * Created by lenovo on 2017/8/24.
 */

public interface InterContract {

    interface View extends IBaseView<Presenter> {
        void loadInteraction(HuDongBean bean);
    }

    interface Presenter extends IBasePresenter {
    }
}
