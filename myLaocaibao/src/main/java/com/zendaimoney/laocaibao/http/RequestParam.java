package com.zendaimoney.laocaibao.http;


import android.content.Context;


import com.igexin.sdk.PushManager;
import com.zendaimoney.laocaibao.BuildConfig;
import com.zendaimoney.laocaibao.constant.Constant;
import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.config.LoginPreferences;
import com.zendaimoney.laocaibao.model.UserLogin;
import com.zendaimoney.laocaibao.utils.AppUtils;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * Created by 00224524 on 2015/12/14.
 * 请求参数类
 */

public class RequestParam {

    /**
     * 请求参数
     *
     * @ param context 上下文
     * @ param params 接口参数
     * @ return
     */

    public String getRequestParams(Context context, JSONObject reqParams) {
        JSONObject json = new JSONObject();
        String projectNo = Constant.PROGECT_NO;
        String sn = projectNo + createSn();
        JSONObject headParam = getHeadParams(context);
        String param[] = {projectNo + "|", sn + "|"};
        try {
            json.put(Constant.PROPERTY_PROGECT_NO, projectNo);
            json.put(Constant.PROPERTY_REQ_RUL, "");
            json.put(Constant.PROPERTY_REQ_PARAM, reqParams);
            json.put(Constant.PROPERTY_REQ_HEAD_PARAM, headParam);
            json.put(Constant.PROPERTY_REQ_TIMESTAMP, "");
            json.put(Constant.PROPERTY_SN, sn);
//            json.put(Constant.PROPERTY_SIGN, EncryptTools.MD5(context, param));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json.toString();
    }

    /**
     * 请求头参数
     *
     * @ param context
     * @ return
     */
    private JSONObject getHeadParams(Context context) {
        String sessionToken = "";
        String clientId = "";
        UserLogin userLogin = LoginPreferences.getLogin(context);
        if (userLogin != null) {
            sessionToken = userLogin.getuInfoItem().getSessionToken();
        }
        JSONObject json = new JSONObject();
        String versionName = BuildConfig.VERSION_NAME;
        String appName = context.getResources().getString(R.string.app_name);
        String systemName = "Android";
        String model = android.os.Build.MODEL;// 设备型号
        String sysVersion = android.os.Build.VERSION.RELEASE;// 系统版本号
        try {
            json.put(Constant.PROPERTY_SESSIONTOKEN, sessionToken);
            json.put(Constant.PROPERTY_APP_VERSION, versionName);
            if (PushManager.getInstance().getClientid(context) != null) {
                clientId = PushManager.getInstance().getClientid(context);
            }
            json.put(Constant.PROPERTY_MECHANISM, "证大");
            json.put(Constant.PROPERTY_PLATFORM, "App");
            json.put(Constant.PROPERTY_TOGATHERTYPE, "证大无线");
            json.put(Constant.PROPERTY_OPENCHANNEL, AppUtils.getAppMetaData(context, Constant.PROPERTY_UMENG_CHANNEL));
            json.put(Constant.PROPERTY_TOKEN, clientId);
            json.put(Constant.PROPERTY_USERAGENT, appName + versionName + "("
                    + systemName + ";" + sysVersion + ";" + model + ")");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 生成流水号
     *
     * @ return
     */
    private String createSn() {
        return AppUtils.getCurrentDateTime("yyyyMMddHHmmss") + AppUtils.createFiveDigitRandom();
    }

}
