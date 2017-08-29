package com.jiyun.qcloud.dashixummoban.modle.dataModel;



import com.jiyun.qcloud.dashixummoban.entity.BadaBean;
import com.jiyun.qcloud.dashixummoban.entity.ChinaBean;

import com.jiyun.qcloud.dashixummoban.entity.Home2;
import com.jiyun.qcloud.dashixummoban.entity.Home3;
import com.jiyun.qcloud.dashixummoban.entity.Mp4;

import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaHomeModel extends BaseModel {
    void loadHomeList(NetWorkCallBack<PandaHome> callback);
    void loadChinaList(NetWorkCallBack<ChinaBean> callback);
    void loadBaList(String url,NetWorkCallBack<BadaBean> callBack);

    void HomeUri(NetWorkCallBack<Home2> callback, String uri);
    void Home3Uri(NetWorkCallBack<Home3> callback, String uri);
    void Mp4Uri(NetWorkCallBack<Mp4> callback, String uri);

}
