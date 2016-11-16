package com.example.myapplication;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

class RetrofitClient {

    private static RetrofitClient retrofitClient;
    private ApiService apiService;
    private final static String baseUrl = ApiService.Base_URL;


    static RetrofitClient getInstance() {
        if (retrofitClient == null) {
            retrofitClient = new RetrofitClient();
        }
        return retrofitClient;
    }

    private RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.client().setConnectTimeout(1, TimeUnit.MILLISECONDS);
        apiService = retrofit.create(ApiService.class);
    }

    public void getData(Subscriber<Response> subscriber, String ip) {
        apiService.getData(ip,new HashMap<String, String>())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
