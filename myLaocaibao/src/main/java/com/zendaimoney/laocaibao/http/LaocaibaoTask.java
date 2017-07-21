package com.zendaimoney.laocaibao.http;

import android.app.Activity;
import android.text.TextUtils;

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
    public String arg0;
    public String arg1;
    private CommonCallBack mCallBackListener;
    public int taskDataType;
//    private static String baseUrl = "";

    public LaocaibaoTask(Activity context, JSONObject params, String methodCode,
                         CommonCallBack callback) {
        this.mContext = context;
        this.mJsonObject = params;
        this.arg0 = methodCode;
        this.mCallBackListener = callback;

    }


    public void send() {
        String baseUrl;

        baseUrl = BuildConfig.VERSION_UPDATE_URL;

//        AppLog.i("请求的接口地址", baseUrl);
        RequestParam requestParam = new RequestParam();
        arg1 = requestParam.getRequestParams(mContext, mJsonObject);
        LcbOkHttpClient.getInstance().post(mCallBackListener, baseUrl, arg0, arg1);
    }


//    @Override
//    protected Object doInBackground(Class<?>... params) {
//        return getJsonFromNet(params[0]);
//    }

//    @Override
//    protected void onPostExecute(Object result) {
//        super.onPostExecute(result);
//        if (!mContext.isFinishing()) {
//            mCallBackListener.response(result, this);
//        }
//    }

    private <T> T getJsonFromNet(Class<T> c) {
        String baseUrl;
        if (arg0.equals(MethodCode.VERSION_UPDATE)) {
            baseUrl = BuildConfig.VERSION_UPDATE_URL;
        } else {
            baseUrl = IpConfigActivity.sBaseUrl;
        }
//        AppLog.i("请求的接口地址", baseUrl);
        RequestParam requestParam = new RequestParam();
        arg1 = requestParam.getRequestParams(mContext, mJsonObject);

//        AppLog.i("请求参数" + "【" + arg0 + "】", arg1);
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
                AppLog.i(TAG, e.getLocalizedMessage());
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
