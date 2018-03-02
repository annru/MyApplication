package com.zendaimoney.laocaibao.http;

/**
 * Created by 00224524 on 2017/7/26.
 * description:
 */

public class MsgResult<T> extends Result {
    private String status;
    private String respDesc;
    private T infos;

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

    public T getInfos() {
        return infos;
    }

    public void setInfos(T infos) {
        this.infos = infos;
    }
}
