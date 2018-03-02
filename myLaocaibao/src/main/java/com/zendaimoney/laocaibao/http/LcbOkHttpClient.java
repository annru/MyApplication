package com.zendaimoney.laocaibao.http;


import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

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
    private final String TAG = LcbOkHttpClient.class.getSimpleName();
    private static LcbOkHttpClient mInstance;
    private OkHttpClient mOkHttpClient = null;

    private LcbOkHttpClient() {
        mOkHttpClient = new OkHttpClient.Builder().retryOnConnectionFailure(false)
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .build();
    }

    static LcbOkHttpClient getInstance() {
        if (mInstance == null) {
            synchronized (LcbOkHttpClient.class) {
                if (mInstance == null) {
                    mInstance = new LcbOkHttpClient();
                }
            }
        }
        return mInstance;
    }


    public void post(final CommonCallBack callBack, String url, String methodCode, String json, final Class<?> c) {
        RequestBody body = new FormBody.Builder().add("arg0", methodCode).add("arg1", json).build();
        Request request = new Request.Builder().url(url).post(body).build();
        mOkHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                callBack.onFail();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                callBack.onResponse(parseResponse(result, c));
            }
        });
    }

    private <T> T parseResponse(String result, Class<T> clazz) {
        if (!TextUtils.isEmpty(result)) {
            String code = getCode(result);
            try {
                if (code != null) {
                    if (code.equals(Result.CODE_OK)) {
                        String msg = getJsonMsg(result);
                        if (!TextUtils.isEmpty(msg)) {
                            Gson gson = new Gson();
                            return gson.fromJson(msg, clazz);
                        }
                    } else {
                        Gson gson = new Gson();
                        return gson.fromJson(result, new TypeToken<Result>() {
                        }.getType());
                    }
                }
            } catch (JsonSyntaxException e) {
                Log.i(TAG, e.getLocalizedMessage());
            }
        }
        return null;
    }

    /**
     * 解析msg里面包含的数据
     */
    private String getJsonMsg(String result) {
        String jsonMsg = "";
        JSONObject object;
        try {
            object = new JSONObject(result);
            String msg = object.getString("msgEx");
            if (!TextUtils.isEmpty(msg)) {
                jsonMsg = msg;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonMsg;
    }

    /**
     * 解析返回数据最外层的code状态码
     */
    private String getCode(String result) {
        String code = "";
        JSONObject object;
        try {
            object = new JSONObject(result);
            code = object.getString("code");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return code;
    }


}
