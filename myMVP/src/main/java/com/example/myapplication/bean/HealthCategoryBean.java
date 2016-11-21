package com.example.myapplication.bean;

import java.util.List;

/**
 * Created by 00224524 on 2016/11/21.
 * 健康知识分类列表
 */

public class HealthCategoryBean extends BaseResult {

    private List<HealthCategoryItem> result;

    public List<HealthCategoryItem> getResult() {
        return result;
    }

    public void setResult(List<HealthCategoryItem> result) {
        this.result = result;
    }
}
