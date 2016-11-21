package com.example.myapplication.bean;

/**
 * Created by 00224524 on 2016/11/21.
 */

public class BaseResult {
    private int error_code;
    private String reason;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
