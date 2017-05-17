package com.example.myapplication.bean;

import java.util.List;

/**
 * Created by 00224524 on 2016/11/21.
 */

public class HealthInfoData {

    private int total;
    private List<HealthInfoDataItem> data;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<HealthInfoDataItem> getData() {
        return data;
    }

    public void setData(List<HealthInfoDataItem> data) {
        this.data = data;
    }
}
