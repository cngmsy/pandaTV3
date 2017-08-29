package com.jiyun.qcloud.dashixummoban.config;

/**
 * Created by xingge on 2017/7/11.
 * 相关参数
 */

public class Urls {

    //服务器地址
    private static final String BASEURL = "http://www.ipanda.com/kehuduan/";
    //首页
    public static final String PANDAHOME = BASEURL+"shouye/index.json";
    public static final String MP4="http://115.182.35.91/api/getVideoInfoForCBox.do?pid=";
    //熊猫直播
    public static final String PANDALIVE = BASEURL+"PAGE14501769230331752/index.json";
    //列表
    public static final String PAGELIST = BASEURL+"PAGE14501786751053212/index.json";

    public static final String PAGEINFOLIST = "http://101.200.142.201/MyListLoadAuto/listload";
    //获取图片验证码
    public static final String IMGCODE = "http://reg.cntv.cn/simple/verificationCode.action";
    //邮箱注册
    public static final String EMAILREGISTER = "https://reg.cntv.cn/api/register.action";
//  滚滚视频  http://www.ipanda.com/kehuduan/video/index.json
    public static final String GUNHOME = "http://www.ipanda.com/kehuduan/video/index.json";

    //直播中国
    public static final String LIVECHINA = "http://www.ipanda.com/kehuduan/PAGE14501775094142282/index.json";
    public static final String BADALING = "http://www.ipanda.com/kehuduan/liebiao/badaling/index.json";

    //熊猫直播 多视角直播
    public static final String PANDAMORE = BASEURL + "PAGE14501769230331752/PAGE14501787896813312/index.json";
    //精彩一刻
    public static final String PANDAMOMENT = "http://api.cntv.cn/video/videolistById";
    //
    public static final String PANDALIVEPAGE = "http://www.ipanda.com/kehuduan/PAGE14501772263221982/index.json";
    //互动
    public static final String INTERACTION="http://www.ipanda.com/kehuduan/PAGE14501767715521482/index.json";

}
