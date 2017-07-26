package com.zendaimoney.laocaibao.model;

/**
 * Created by 00224524 on 2016/12/30.
 * description:版本更新检查对象实体类
 */

public class VersionCheckInfoItem {
    private boolean success;
    private String code;//2100强制更新，5103非强制更新，0000无更新
    private String msg;//版本更新内容
    private String clientVersion;//最新客户端版本名称
    private String routeVersion;//服务版本

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getClientVersion() {
        return clientVersion;
    }

    public void setClientVersion(String clientVersion) {
        this.clientVersion = clientVersion;
    }

    public String getRouteVersion() {
        return routeVersion;
    }

    public void setRouteVersion(String routeVersion) {
        this.routeVersion = routeVersion;
    }
}
