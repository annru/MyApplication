package com.zendaimoney.laocaibao.model;

/**
 * Created by 00224524 on 2016/12/30.
 * description:版本更新检查对象实体类
 */

public class MsgExInfo extends BaseMsgEx {
    private VersionCheckInfoItem infos;

    public VersionCheckInfoItem getInfos() {
        return infos;
    }

    public void setInfos(VersionCheckInfoItem infos) {
        this.infos = infos;
    }
}
