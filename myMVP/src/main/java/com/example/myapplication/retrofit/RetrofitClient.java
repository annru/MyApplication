package com.example.myapplication.retrofit;

import android.util.Log;

import com.example.myapplication.base.SubscriberCallback;
import com.example.myapplication.bean.HealthCategoryBean;
import com.example.myapplication.bean.HealthInfoBean;
import com.example.myapplication.bean.Repo;
import com.example.myapplication.bean.ResponseEntity;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class RetrofitClient {

    private ApiService apiService;
    private final static String baseUrl = ApiService.Base_URL;


    public static RetrofitClient getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private RetrofitClient() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(15, TimeUnit.SECONDS);
        Retrofit retrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    private static class SingletonHolder {
        private static final RetrofitClient INSTANCE = new RetrofitClient();
    }

    public void getTopMovie(Subscriber<String> subscriber, int start, int
            count) {
        apiService.getTopMovie(start, count)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


    public void getBook(Subscriber<ResponseEntity> subscriber, String key,
                        int cat, int ranks) {
        Log.i("getBook", "请求小说大全");
        apiService.getBook(key, cat, ranks)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public void getWeather(Subscriber<Repo> subscriber) {
        apiService.getWeather()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 健康知识分类列表
     *
     * @param subscriber
     * @param key
     */
    public void getHealthKnowledgeCategoryList(Subscriber<HealthCategoryBean>
                                                       subscriber, String key) {
        apiService.getHealthKnowledgeCategoryList(key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    /**
     * 健康知识信息列表
     *
     * @param subscriber
     * @param key
     */
//    public void getHealthKnowledgeInfoList(SubscriberCallback<HealthInfoBean>
//                                                   subscriber, String key,
//                                           String page, String
//                                                   limit, String
//                                                   id) {
//        apiService.getHealthKnowledgeInfoList(key, page, limit, id)
//                .subscribeOn(Schedulers.io())
//                .unsubscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(subscriber);
//    }

    public void getTrainTimeList(Subscriber<Object> subscriber, String key,
                                 String name) {
        apiService.getTrainTimeList(name, key)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
