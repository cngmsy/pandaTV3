package com.jiyun.qcloud.dashixummoban.modle.dataModel;


import com.jiyun.qcloud.dashixummoban.config.Urls;
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
import com.jiyun.qcloud.dashixummoban.modle.net.HttpFactory;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xingge on 2017/7/26.
 */

public class PandaLiveModelImpl implements IPandaLiveModel {
    @Override
    public void loadHomeList(NetWorkCallBack<PandaHome> callback) {
        iHttp.get(Urls.PAGEINFOLIST, null, callback);
    }

    @Override
    public void loadLiveList(NetWorkCallBack<LiveBeans> callBack) {
        iHttp.get(Urls.PANDALIVE, null, callBack);
    }

    @Override
    public void loadLiveMoreList(NetWorkCallBack<MoreBeans> callBack) {
        iHttp.get(Urls.PANDAMORE, null, callBack);
    }

    @Override
    public void loadLiveMomentlist(Map<String, String> params, NetWorkCallBack<MomentBean> callBack) {
        iHttp.get(Urls.PANDAMOMENT, params, callBack);
    }

    @Override
    public void loadPageList(NetWorkCallBack<LivePageBeans> callBack) {
        iHttp.get(Urls.PANDALIVEPAGE, null, callBack);
    }


    @Override
    public void loadVedioList(String url, NetWorkCallBack<VedioBeans> callBack) {
        iHttp.get(url, null, callBack);
    }

    @Override
    public void loadLiveVedio(String url, NetWorkCallBack<LivevedioBeans> callBack) {
        iHttp.get(url, null, callBack);
    }

    @Override
    public void loadInteraction(NetWorkCallBack<HuDongBean> callBack) {
        iHttp.get(Urls.INTERACTION, null, callBack);
    }
    //边看边聊
    @Override
    public void getFasongData(String app, String author, String authorid, String data, String itemid, String message, NetWorkCallBack<FasongBean> callBack) {
        Map<String, String> map = new HashMap<>();
        map.put("app", app);
        map.put("author", author);
        map.put("authorid", authorid);
        map.put("data", data);
        map.put("itemid", itemid);
        map.put("message", message);
        HttpFactory.createOK().post("http://newcomment.cntv.cn/comment/post", map, callBack);
    }

    @Override
    public void getBiankanBianliaoData(NetWorkCallBack<BiankanBianliaoBean> myCallBack) {
        HttpFactory.createOK().get("http://newcomment.cntv.cn/comment/list?prepage=20&app=ipandaApp&itemid=zhiboye_chat&nature=1&page=1", null, myCallBack);
    }
}
