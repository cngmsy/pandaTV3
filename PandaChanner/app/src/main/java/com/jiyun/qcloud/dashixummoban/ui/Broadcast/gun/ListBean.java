package com.jiyun.qcloud.dashixummoban.ui.Broadcast.gun;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/23.
 * 负责 全部
 * 团队 1人
 */
public class ListBean implements Serializable{
    /**
     * url : http://live.ipanda.com/2017/08/14/VIDE9RBeSMXnQrCQfJ2HOx4N170814.shtml
     * image : http://p1.img.cctvpic.com/photoworkspace/2017/08/14/2017081413321088989.jpg
     * title : 300a718a732bTOP699c300b
     * brief : 7b2c4e8c5b637b2c5341671fff1a6eda6eda4eec76845e78798f751f6d3b
     * type : 2
     * videoLength : 04:03
     * id : VSET100284428835
     * order : 1
     */

    private String url;
    private String image;
    private String title;
    private String brief;
    private String type;
    private String videoLength;
    private String id;
    private String order;

    public static ListBean objectFromData(String str) {

        return new Gson().fromJson(str, ListBean.class);
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVideoLength() {
        return videoLength;
    }

    public void setVideoLength(String videoLength) {
        this.videoLength = videoLength;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
