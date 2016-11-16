package com.example.myapplication.model;

import retrofit.Call;
import retrofit.http.GET;

/**
 * Created by 00224524 on 2016/3/14.
 * 接口服务
 */
public interface APIService {
    @GET("/data/cityinfo/101010100.html")
    Call<Repo> loadRepo();
}
