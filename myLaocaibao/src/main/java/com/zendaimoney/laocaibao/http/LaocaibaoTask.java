package com.zendaimoney.laocaibao.http;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.zendaimoney.laocaibao.BuildConfig;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * 网络请求线程
 *
 * @author 00225075
 */
public class LaocaibaoTask {
    private static final String TAG = "LaocaibaoTask";
    private Activity mContext;
    private JSONObject mJsonObject;
    private String arg0;
    private String arg1;
    private CommonCallBack mCallBackListener;

    public LaocaibaoTask(Activity context, JSONObject params, String methodCode,
                         CommonCallBack callback) {
        this.mContext = context;
        this.mJsonObject = params;
        this.arg0 = methodCode;
        this.mCallBackListener = callback;
    }


    public void send(Class<?> c) {
        String baseUrl = BuildConfig.BASE_URL;
        RequestParam requestParam = new RequestParam();
        arg1 = requestParam.getRequestParams(mContext, mJsonObject);
        LcbOkHttpClient.getInstance().post(mCallBackListener, baseUrl, arg0, arg1, c);
    }

    private <T> T getJsonFromNet(Class<T> c) {

        RequestParam requestParam = new RequestParam();
        arg1 = requestParam.getRequestParams(mContext, mJsonObject);

        String result = "";
        try {
//            result = LcbOkHttpClient.getInstance().post(baseUrl, arg0, arg1);
        } catch (Exception e) {
            e.printStackTrace();
        }


//        AppLog.i("服务端返回数据" + "【" + arg0 + "】", result + "");
        if (!TextUtils.isEmpty(result)) {
            String code = getCode(result);
            try {
                if (code != null) {
                    if (code.equals(Result.CODE_OK)) {
                        String msg = getJsonMsg(result);
                        if (!TextUtils.isEmpty(msg)) {
                            Gson gson = new Gson();
                            return gson.fromJson(msg, c);
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
    public String getCode(String result) {
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
