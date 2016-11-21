package com.example.myapplication.http;


import com.example.myapplication.bean.HealthCategoryBean;
import com.example.myapplication.bean.HealthInfoBean;
import com.example.myapplication.bean.Repo;
import com.example.myapplication.bean.ResponseEntity;

import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import rx.Observable;


/**
 * Created by 00224524 on 2016/11/16.
 * 接口服务
 */

interface ApiService {
    //    String Base_URL = "https://api.douban.com/v2/movie/";
//    String Base_URL = "http://www.weather.com.cn";
    String Base_URL = "http://japi.juhe.cn/";

    @GET("top250")
    Observable<String> getTopMovie(@Query("start") int start, @Query("count") int count);

    @GET("book/recommend.from/")
    Observable<ResponseEntity> getBook(@Query("key") String key, @Query("cat") int cat, @Query("ranks") int count);


    @GET("/data/cityinfo/101010100.html")
    Observable<Repo> getWeather();

    @POST("health_knowledge/categoryList")
    Observable<HealthCategoryBean> getHealthKnowledgeCategoryList(@Query("key") String key);

    @POST("health_knowledge/infoList")
    Observable<HealthInfoBean> getHealthKnowledgeInfoList(@Query("key") String key, @Query("page") String page, @Query("limit")
            String limit, @Query("id") String id);

}
