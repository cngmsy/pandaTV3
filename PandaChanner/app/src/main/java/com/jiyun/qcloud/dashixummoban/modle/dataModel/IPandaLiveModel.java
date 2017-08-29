package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.entity.Live.BiankanBianliaoBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.FasongBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.HuDongBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.LiveBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivePageBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.LivevedioBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.MomentBean;
import com.jiyun.qcloud.dashixummoban.entity.Live.MoreBeans;
import com.jiyun.qcloud.dashixummoban.entity.Live.VedioBeans;
import com.jiyun.qcloud.dashixummoban.entity.PandaHome;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public interface IPandaLiveModel extends BaseModel {
    void loadHomeList(NetWorkCallBack<PandaHome> callback);

    void loadLiveList(NetWorkCallBack<LiveBeans> callBack);

    void loadLiveMoreList(NetWorkCallBack<MoreBeans> callBack);

    void loadLiveMomentlist(Map<String, String> params, NetWorkCallBack<MomentBean> callBack);

    void loadPageList(NetWorkCallBack<LivePageBeans> callBack);

    void loadVedioList(String url, NetWorkCallBack<VedioBeans> callBack);

    void loadLiveVedio(String url, NetWorkCallBack<LivevedioBeans> callBack);
    void loadInteraction(NetWorkCallBack<HuDongBean> callBack);
    void getFasongData(String app, String author, String authorid, String data, String itemid, String message, NetWorkCallBack<FasongBean> callBack);
    void getBiankanBianliaoData(NetWorkCallBack<BiankanBianliaoBean> callBack);
}
