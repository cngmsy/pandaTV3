package com.jiyun.qcloud.dashixummoban.ui.home;

import com.jiyun.qcloud.dashixummoban.base.IBaseView;
import com.jiyun.qcloud.dashixummoban.base.IMp4Presenter;
import com.jiyun.qcloud.dashixummoban.entity.Mp4;

/**
 * Created by Administrator on 2017/8/28 0028.
 */

public class Mp4Contract  {
    public interface Mp4jpa extends IBaseView<Presenter> {
        void showHomeListData(Mp4 mp4);
        void playVideo();
        void loadWebView();
    }
    public interface Presenter extends IMp4Presenter {}
}
