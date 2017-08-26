package com.jiyun.qcloud.dashixummoban.ui.Gun.ivewgun;

import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.entity.gun.GunData;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/24.
 * 负责 全部
 * 团队 1人
 */

public class IViewGunPresenter {
    public interface View extends IBaseView<Presenter> {
        void showHomeListData(GunData gunData);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IBasePresenter {
    }

}
