package com.example.myapplication;

import java.util.List;

/**
 * Created by 00224524 on 2016/11/16.
 * 数据模型
 */

public class Response {
    private int error_code;
    private String reason;
    private ResponseInfo result;

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

    public ResponseInfo getResult() {
        return result;
    }

    public void setResult(ResponseInfo result) {
        this.result = result;
    }

    private class ResponseInfo {
        private List<ResponseInfoItem> data;

        public List<ResponseInfoItem> getData() {
            return data;
        }

        public void setData(List<ResponseInfoItem> data) {
            this.data = data;
        }
    }

    private class ResponseInfoItem {
        private String title;
        private String code;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }
}
