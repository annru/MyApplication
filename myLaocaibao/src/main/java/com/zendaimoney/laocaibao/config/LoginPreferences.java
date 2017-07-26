package com.zendaimoney.laocaibao.config;

import android.content.Context;

import com.google.gson.Gson;
import com.zendaimoney.laocaibao.Constant.Constant;
import com.zendaimoney.laocaibao.model.UserLogin;
import com.zendaimoney.laocaibao.model.UserLoginInfoItem;
import com.zendaimoney.laocaibao.utils.SPUtils;


/**
 * 登录的信息
 *
 * @author 00225075
 */
public class LoginPreferences {

    /**
     * 取出登录的信息
     */
    public static String getUserLogin(Context context) {
        String loginStr = (String) SPUtils.get(context, Constant.logged, "");
        return loginStr;
    }

    /**
     * 存入登录的信息
     */
    public static void putUserLogin(Context context, UserLogin login) {
        if (login != null) {
            Gson gson = new Gson();
            SPUtils.put(context, Constant.logged, gson.toJson(login));
        }
    }

    /**
     * 存入登录的信息(客户详细信息)
     */
    public static void putUserLoginInfoItem(Context context, UserLoginInfoItem userLoginInfoItem) {
        if (userLoginInfoItem != null) {
            Gson gson = new Gson();
            SPUtils.put(context, Constant.logged, gson.toJson(userLoginInfoItem));
        }
    }

    /**
     * 取出登录对象
     *
     * @param context 上下文
     */
    public static UserLogin getLogin(Context context) {
        String loggedJson = getUserLogin(context);
//        AppLog.i("用户信息:", loggedJson);
        if (!loggedJson.equals("")) {
            Gson gson = new Gson();
            return gson.fromJson(loggedJson, UserLogin.class);
        }
        return null;
    }


    /**
     * 清除登录信息
     */
    public static void clearLoginInfo(Context context) {
        SPUtils.remove(context, Constant.logged);
    }

    /**
     * 移除手势密码
     */
    public static void removeGesturePassword(Context context, String mobile) {
        SPUtils.remove(context, mobile);
    }
}
