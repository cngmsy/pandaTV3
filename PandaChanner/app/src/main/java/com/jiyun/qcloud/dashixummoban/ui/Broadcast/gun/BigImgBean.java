package com.jiyun.qcloud.dashixummoban.ui.Broadcast.gun;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/23.
 * 负责 全部
 * 团队 1人
 */
public class BigImgBean implements Serializable{
    /**
     * url : http://live.ipanda.com/2017/08/21/VIDEkIyralrrjjG4oF2fqmiI170821.shtml
     * image : http://p1.img.cctvpic.com/photoAlbum/page/performance/img/2017/8/22/1503391960164_396.jpg
     * title : 300a718a732bTOP699c300b4e008d7760f976847978ff0c59b959b980cc9ed19505
     * id : TITE1503391965561415
     * type : 2\
     * stype :
     * pid : 8ff497729f7e4d9881d643f41f90d378
     * vid :
     * order : 1
     */

    private String url;
    private String image;
    private String title;
    private String id;
    private String type;
    private String stype;
    private String pid;
    private String vid;
    private String order;

    public static BigImgBean objectFromData(String str) {

        return new Gson().fromJson(str, BigImgBean.class);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStype() {
        return stype;
    }

    public void setStype(String stype) {
        this.stype = stype;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
