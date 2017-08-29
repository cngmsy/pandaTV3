package com.jiyun.qcloud.dashixummoban.modle.gun;

import com.jiyun.qcloud.dashixummoban.config.Urls;
import com.jiyun.qcloud.dashixummoban.entity.gun.GunData;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/24.
 * 负责 全部
 * 团队 1人
 */

public class GunModuleImpl implements GunModule {
    @Override
    public void loadGunList(NetWorkCallBack<GunData> gunDataNetWorkCallBack) {
        iHttp.get(Urls.GUNHOME,null,gunDataNetWorkCallBack);
    }
}
