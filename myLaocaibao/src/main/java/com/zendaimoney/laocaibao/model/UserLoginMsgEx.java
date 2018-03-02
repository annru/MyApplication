package com.zendaimoney.laocaibao.model;

/**
 * 登录
 *
 * @author 00225075
 */
public class UserLoginMsgEx extends BaseMsgEx {

    private UserLoginInfoItem infos;

    public UserLoginInfoItem getInfos() {
        return infos;
    }

    public void setInfos(UserLoginInfoItem infos) {
        this.infos = infos;
    }

}
