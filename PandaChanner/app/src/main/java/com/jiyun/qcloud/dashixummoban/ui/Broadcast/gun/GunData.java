package com.jiyun.qcloud.dashixummoban.ui.Broadcast.gun;

import com.google.gson.Gson;

import java.io.Serializable;
import java.util.List;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/23.
 * 负责 全部
 * 团队 1人
 */

public class GunData implements Serializable {
    private List<BigImgBean> bigImg;
    private List<ListBean> list;

    public static GunData objectFromData(String str) {

        return new Gson().fromJson(str, GunData.class);
    }

    public List<BigImgBean> getBigImg() {
        return bigImg;
    }

    public void setBigImg(List<BigImgBean> bigImg) {
        this.bigImg = bigImg;
    }

    public List<ListBean> getList() {
        return list;
    }

    public void setList(List<ListBean> list) {
        this.list = list;
    }
}
