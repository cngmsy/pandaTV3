package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.base.IHomePresenter;
import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;

/**
 * Created by chj on 2017/8/21.
 * 这是难点
 */

public class Home2Contract {
    public interface View extends IBaseView<Presenter> {
        void showHomeListData(PandaHome pandaHome);
        void playVideo();
        void loadWebView();
    }
    public interface Home extends IBaseView<Presenter> {
        void showHomeListData(Home2 home2);
        void playVideo();
        void loadWebView();
    }
   public interface HomeG extends IBaseView<Presenter> {
        void showHomeListData(Home3 home3);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IHomePresenter {}
}
