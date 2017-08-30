package com.jiyun.qcloud.dashixummoban.app;

import com.jiyun.qcloud.dashixummoban.base.BaseActivity;
import com.jiyun.qcloud.dashixummoban.base.BaseFragment;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by chj on 2017/8/20.
 */

public class App extends  BaseApplication implements Thread.UncaughtExceptionHandler{

    public static BaseActivity mBaseActivity;
    public static BaseFragment lastfragment;


    @Override
    public void onCreate() {
        super.onCreate();
        UMShareAPI.get(this);
    }
    {

        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad", "http://sns.whalecloud.com");
    }
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.setDefaultUncaughtExceptionHandler(this);

    }
}
