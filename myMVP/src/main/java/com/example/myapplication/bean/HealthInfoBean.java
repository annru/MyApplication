package com.example.myapplication.bean;

/**
 * Created by 00224524 on 2016/11/21.
 */

public class HealthInfoBean extends BaseResult {
    private HealthInfoData result;

    public HealthInfoData getResult() {
        return result;
    }

    public void setResult(HealthInfoData result) {
        this.result = result;
    }
}
