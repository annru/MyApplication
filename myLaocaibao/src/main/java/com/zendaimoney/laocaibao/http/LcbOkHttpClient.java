package com.zendaimoney.laocaibao.http;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by 00224524 on 2015/11/11.
 * oKHttp网络请求封装类
 */
class LcbOkHttpClient {
    private static LcbOkHttpClient mInstance;
    private OkHttpClient mOkHttpClient = null;

    private LcbOkHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder().retryOnConnectionFailure(false)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    public static LcbOkHttpClient getInstance() {
        if (mInstance == null) {
            synchronized (LcbOkHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new LcbOkHttpClient();
                }
            }
        }
        return mInstance;
    }


    public void post(final CommonCallBack callBack, String url, String methodCode, String json) {
        RequestBody body = new FormBody.Builder().add("arg0", methodCode).add("arg1", json).build();
        Request request = new Request.Builder().url(url).post(body).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callBack.onResponse(response.body().string());
            }
        });
    }


}
