package com.jiyun.qcloud.dashixummoban.modle.gun;

import com.jiyun.qcloud.dashixummoban.entity.gun.GunData;
import com.jiyun.qcloud.dashixummoban.modle.dataModel.BaseModel;
import com.jiyun.qcloud.dashixummoban.modle.net.callback.NetWorkCallBack;

/**
 * 项目负责人：李强
 * 创建时间 2017/8/24.
 * 负责 全部
 * 团队 1人
 */

public interface GunModule extends BaseModel{
    void loadGunList(NetWorkCallBack<GunData> gunDataNetWorkCallBack);
}
