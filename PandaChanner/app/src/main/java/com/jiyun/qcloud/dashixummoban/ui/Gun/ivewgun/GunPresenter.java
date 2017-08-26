package com.jiyun.qcloud.dashixummoban.ui.Gun.ivewgun;

import android.util.Log;

import com.jiyun.qcloud.dashixummoban.BuildConfig;
import com.jiyun.qcloud.dashixummoban.base.IBasePresenter;
import com.jiyun.qcloud.dashixummoban.entity.gun.GunData;
import com.jiyun.qcloud.dashixummoban.modle.gun.GunModule;
import com.jiyun.qcloud.dashixummoban.modle.gun.GunModuleImpl;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/24.
 * 负责 全部
 * 团队 1人
 */

public class GunPresenter implements IViewGunPresenter.Presenter {
    private GunModule gunModule;
    private IViewGunPresenter.View view;

    public GunPresenter(IViewGunPresenter.View view) {
        this.view = view;
        view.setPresenter(this);
        gunModule = new GunModuleImpl();
    }

    @Override
    public void start() {
        gunModule.loadGunList(new NetWorkCallBack<GunData>() {
            @Override
            public void onSuccess(GunData gunData) {
                view.showHomeListData(gunData);
            }

            @Override
            public void onError(int errorCode, String errorMsg) {
                if (BuildConfig.DEBUG) Log.d("GunPresenter", errorMsg);
            }

            @Override
            public void onFail(String netOff) {
                if (BuildConfig.DEBUG) Log.d("GunPresenter", netOff);
            }
        });
    }
}
