package com.zendaimoney.laocaibao.model;

/**
 * 请求网络返回数据的基类
 *
 * @author 00225075
 */
public class BaseMsgEx {
    public static final String STATUS_SUCCESS = "0";
    public static final String STATUS_FAILED = "-1";
    private String status;
    private String respDesc;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRespDesc() {
        return respDesc;
    }

    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }

}
