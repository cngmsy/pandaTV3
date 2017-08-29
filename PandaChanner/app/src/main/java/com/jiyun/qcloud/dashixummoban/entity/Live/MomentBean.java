package com.jiyun.qcloud.dashixummoban.entity.Live;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lenovo on 2017/8/24.
 */

public class MomentBean  {

    /**
     * video : [{"em":"CM01","img":"http://p1.img.cctvpic.com/fmspic/2017/08/23/67c2e6ea9e0d493ab0b740ca0c1e376c-22.jpg?p=2&h=120","len":"00:00:38","order":"4743","ptime":"2017-08-23 13:30:04","t":"《精彩一刻》 20170823 幸福的\u201c煤炭\u201d一家~","url":"http://tv.cntv.cn/video/VSET100167216881/67c2e6ea9e0d493ab0b740ca0c1e376c","vid":"67c2e6ea9e0d493ab0b740ca0c1e376c","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p4.img.cctvpic.com/fmspic/2017/08/23/eef5043729b542f3abdd3abcc9379730-9.jpg?p=2&h=120","len":"00:00:19","order":"4744","ptime":"2017-08-23 13:28:19","t":"《精彩一刻》 20170823 这都是本女王圈下的粉丝~","url":"http://tv.cntv.cn/video/VSET100167216881/eef5043729b542f3abdd3abcc9379730","vid":"eef5043729b542f3abdd3abcc9379730","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p5.img.cctvpic.com/fmspic/2017/08/23/dea7aec8c4fc482ba8a6102e2985940f-9.jpg?p=2&h=120","len":"00:00:19","order":"4742","ptime":"2017-08-23 13:26:39","t":"《精彩一刻》20170823 奶爸~熊家还想再睡一会儿~","url":"http://tv.cntv.cn/video/VSET100167216881/dea7aec8c4fc482ba8a6102e2985940f","vid":"dea7aec8c4fc482ba8a6102e2985940f","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/23/6ef485f925b64e0e819ef2f1506f9db4-32.jpg?p=2&h=120","len":"00:00:45","order":"4741","ptime":"2017-08-23 13:22:06","t":"《精彩一刻》20170823 乔伊：奶爸，还要一个盆盆奶","url":"http://tv.cntv.cn/video/VSET100167216881/6ef485f925b64e0e819ef2f1506f9db4","vid":"6ef485f925b64e0e819ef2f1506f9db4","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p2.img.cctvpic.com/fmspic/2017/08/23/2e74a0a7801647128c05ebe1754c00ee-33.jpg?p=2&h=120","len":"00:00:46","order":"4740","ptime":"2017-08-23 11:01:34","t":"《精彩一刻》 20170823 隔着屏幕云吸\u201c奇一\u201d","url":"http://tv.cntv.cn/video/VSET100167216881/2e74a0a7801647128c05ebe1754c00ee","vid":"2e74a0a7801647128c05ebe1754c00ee","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/08/23/2d1e275e9b8046b596d295eeed2746bb-21.jpg?p=2&h=120","len":"00:00:34","order":"4739","ptime":"2017-08-23 11:00:36","t":"《精彩一刻》 20170823 hey!你的小宝贝在呼唤你呢","url":"http://tv.cntv.cn/video/VSET100167216881/2d1e275e9b8046b596d295eeed2746bb","vid":"2d1e275e9b8046b596d295eeed2746bb","vsid":"VSET100167216881"},{"em":"CM01","img":"http://p3.img.cctvpic.com/fmspic/2017/08/23/08afcbe3c6eb4a91935e424f3e9047b2-33.jpg?p=2&h=120","len":"00:00:47","order":"4738","ptime":"2017-08-23 10:59:28","t":"《精彩一刻》 20170823 原来\u201c嗯嗯\u201d叫声也可以这么用","url":"http://tv.cntv.cn/video/VSET100167216881/08afcbe3c6eb4a91935e424f3e9047b2","vid":"08afcbe3c6eb4a91935e424f3e9047b2","vsid":"VSET100167216881"}]
     * videoset : {"0":{"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""},"count":"4740"}
     */

    private VideosetBean videoset;
    private List<VideoBean> video;

    public VideosetBean getVideoset() {
        return videoset;
    }

    public void setVideoset(VideosetBean videoset) {
        this.videoset = videoset;
    }

    public List<VideoBean> getVideo() {
        return video;
    }

    public void setVideo(List<VideoBean> video) {
        this.video = video;
    }

    public static class VideosetBean {
        /**
         * 0 : {"bj":"","cd":"","desc":"精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。","dy":"","enname":"其他","fcl":"","fl":"","img":"http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg","js":"","name":"熊猫频道-精彩一刻","nf":"","playdesc":"","relvsid":"","sbpd":"其他","sbsj":"2013-05-01","url":"http://tv.cntv.cn/videoset/VSET100167216881","vsid":"VSET100167216881","yz":"","zcr":"","zy":""}
         * count : 4740
         */

        @SerializedName("0")
        private _$0Bean _$0;
        private String count;

        public _$0Bean get_$0() {
            return _$0;
        }

        public void set_$0(_$0Bean _$0) {
            this._$0 = _$0;
        }

        public String getCount() {
            return count;
        }

        public void setCount(String count) {
            this.count = count;
        }

        public static class _$0Bean {
            /**
             * bj :
             * cd :
             * desc : 精彩一刻栏目关注人气较高的熊猫个体，精选每日直播中最吸引人的画面，呈现熊猫生活中最精彩的状态。
             * dy :
             * enname : 其他
             * fcl :
             * fl :
             * img : http://p5.img.cctvpic.com/fmspic/vms/image/2013/06/21/VSET_1371809214479325.jpg
             * js :
             * name : 熊猫频道-精彩一刻
             * nf :
             * playdesc :
             * relvsid :
             * sbpd : 其他
             * sbsj : 2013-05-01
             * url : http://tv.cntv.cn/videoset/VSET100167216881
             * vsid : VSET100167216881
             * yz :
             * zcr :
             * zy :
             */

            private String bj;
            private String cd;
            private String desc;
            private String dy;
            private String enname;
            private String fcl;
            private String fl;
            private String img;
            private String js;
            private String name;
            private String nf;
            private String playdesc;
            private String relvsid;
            private String sbpd;
            private String sbsj;
            private String url;
            private String vsid;
            private String yz;
            private String zcr;
            private String zy;

            public String getBj() {
                return bj;
            }

            public void setBj(String bj) {
                this.bj = bj;
            }

            public String getCd() {
                return cd;
            }

            public void setCd(String cd) {
                this.cd = cd;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public String getDy() {
                return dy;
            }

            public void setDy(String dy) {
                this.dy = dy;
            }

            public String getEnname() {
                return enname;
            }

            public void setEnname(String enname) {
                this.enname = enname;
            }

            public String getFcl() {
                return fcl;
            }

            public void setFcl(String fcl) {
                this.fcl = fcl;
            }

            public String getFl() {
                return fl;
            }

            public void setFl(String fl) {
                this.fl = fl;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getJs() {
                return js;
            }

            public void setJs(String js) {
                this.js = js;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getNf() {
                return nf;
            }

            public void setNf(String nf) {
                this.nf = nf;
            }

            public String getPlaydesc() {
                return playdesc;
            }

            public void setPlaydesc(String playdesc) {
                this.playdesc = playdesc;
            }

            public String getRelvsid() {
                return relvsid;
            }

            public void setRelvsid(String relvsid) {
                this.relvsid = relvsid;
            }

            public String getSbpd() {
                return sbpd;
            }

            public void setSbpd(String sbpd) {
                this.sbpd = sbpd;
            }

            public String getSbsj() {
                return sbsj;
            }

            public void setSbsj(String sbsj) {
                this.sbsj = sbsj;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getVsid() {
                return vsid;
            }

            public void setVsid(String vsid) {
                this.vsid = vsid;
            }

            public String getYz() {
                return yz;
            }

            public void setYz(String yz) {
                this.yz = yz;
            }

            public String getZcr() {
                return zcr;
            }

            public void setZcr(String zcr) {
                this.zcr = zcr;
            }

            public String getZy() {
                return zy;
            }

            public void setZy(String zy) {
                this.zy = zy;
            }
        }
    }

    public static class VideoBean {
        /**
         * em : CM01
         * img : http://p1.img.cctvpic.com/fmspic/2017/08/23/67c2e6ea9e0d493ab0b740ca0c1e376c-22.jpg?p=2&h=120
         * len : 00:00:38
         * order : 4743
         * ptime : 2017-08-23 13:30:04
         * t : 《精彩一刻》 20170823 幸福的“煤炭”一家~
         * url : http://tv.cntv.cn/video/VSET100167216881/67c2e6ea9e0d493ab0b740ca0c1e376c
         * vid : 67c2e6ea9e0d493ab0b740ca0c1e376c
         * vsid : VSET100167216881
         */

        private String em;
        private String img;
        private String len;
        private String order;
        private String ptime;
        private String t;
        private String url;
        private String vid;
        private String vsid;

        public String getEm() {
            return em;
        }

        public void setEm(String em) {
            this.em = em;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getLen() {
            return len;
        }

        public void setLen(String len) {
            this.len = len;
        }

        public String getOrder() {
            return order;
        }

        public void setOrder(String order) {
            this.order = order;
        }

        public String getPtime() {
            return ptime;
        }

        public void setPtime(String ptime) {
            this.ptime = ptime;
        }

        public String getT() {
            return t;
        }

        public void setT(String t) {
            this.t = t;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getVid() {
            return vid;
        }

        public void setVid(String vid) {
            this.vid = vid;
        }

        public String getVsid() {
            return vsid;
        }

        public void setVsid(String vsid) {
            this.vsid = vsid;
        }
    }
}
