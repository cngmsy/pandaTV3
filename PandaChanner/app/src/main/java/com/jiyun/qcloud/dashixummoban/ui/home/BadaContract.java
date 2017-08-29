package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.BadaBean;

/**
 * Created by dell on 2017/8/29.
 */

public interface BadaContract{
    interface View extends IBaseView<Presenter> {
        void loadBaList(BadaBean movieBean);


    }

    interface Presenter extends IBasePresenter {
        String getUrl(String url);
    }
}
