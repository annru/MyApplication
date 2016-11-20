package com.example.myapplication;

import android.database.Observable;

import java.util.Map;

import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.QueryMap;

/**
 * Created by 00224524 on 2016/11/16.
 * 接口服务
 */

interface ApiService {
    String Base_URL = "http://japi.juhe.cn/";

    /**
     * 普通写法
     */
    @GET("book/recommend.from/")
    Observable<Response> getData(@Path("key") String key,
                                 @QueryMap Map<String, String> maps);


}
