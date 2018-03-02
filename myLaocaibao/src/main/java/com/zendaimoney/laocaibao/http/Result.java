package com.zendaimoney.laocaibao.http;

public class Result {
    public static final String CODE_OK = "0000";
    public static final String CODE_0111 = "0111";
    public static final String CODE_0112 = "0112";
    public static final String CODE_2100 = "2100";
    public static final String CODE_5100 = "5100";//此接口暂不可用
    public static final String CODE_5102 = "5102";//系统忙，请稍后
    public static final String CODE_5104 = "5104";//系统升级维护中，请稍后再试
    public static final String CODE_0102 = "0102";//系统异常,请联系管理员
    private String code;
    private MsgResult msgEx;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public MsgResult getMsgEx() {
        return msgEx;
    }

    public void setMsgEx(MsgResult msgEx) {
        this.msgEx = msgEx;
    }
}
