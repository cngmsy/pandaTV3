package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.Mp4;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaHomeModelImpl implements IPandaHomeModel {
    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PANDAHOME,null,callback);
    }

    @Override
    public void HomeUri(NetWorkCallBack<Home2> callback, String uri) {
        iHttp.get(uri,null,callback);
    }

    @Override
    public void Home3Uri(NetWorkCallBack<Home3> callback, String uri) {
        iHttp.get(uri,null,callback);
    }

    @Override
    public void Mp4Uri(NetWorkCallBack<Mp4> callback, String uri) {
        iHttp.get(Urls.MP4+uri,null,callback);
    }
}
