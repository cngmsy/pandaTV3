package com.jiyun.qcloud.dashixummoban.ui.live.live_fragment;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.Live.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.FasongBean;


public interface BianLiveContract {

    interface BianLiveView extends IBaseView<BianLivePresenter> {
        void setResultData(BiankanBianliaoBean resultData);
        void setFasong(FasongBean fasong);

    }

    interface BianLivePresenter extends IBasePresenter {
        void setFasong(String app, String author, String authorid, String data, String itemid, String message);

    }
}
