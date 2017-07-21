package com.zendaimoney.laocaibao.config;

import android.content.Context;
import android.text.TextUtils;

import com.zendaimoney.laocaibao.Constant.Constant;
import com.zendaimoney.laocaibao.model.UserLogin;
import com.zendaimoney.laocaibao.model.UserLoginInfoItem;


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
     * 存入手势密码
     *
     * @param context 上下文
     * @param mobile  手机号码
     */
    public static void putGesturepassword(Context context, String mobile,
                                          GestureMobile gestureMobile) {
        if (gestureMobile != null) {
            Gson gson = new Gson();
            SPUtils.put(context, mobile, gson.toJson(gestureMobile));
        }
    }

    /**
     * 通过手机号，取出手势密码
     */
    public static GestureMobile getGesturePassword(Context context,
                                                   String mobile) {
        String password = (String) SPUtils.get(context, mobile, "");
        if (!TextUtils.isEmpty(password)) {
            Gson gson = new Gson();
            return gson.fromJson(password, GestureMobile.class);
        }
        return null;
    }

    /**
     * 当前手势密码开发是否打开是否
     */
    public static boolean isStatue(Context context) {
        UserLogin userLogin = LoginPreferences.getLogin(context);
        if (userLogin != null) {
            GestureMobile gm = LoginPreferences.getGesturePassword(context, userLogin.getuInfoItem().getCmCellphone());
            if (gm != null) {
                return gm.isStatue();
            }
        }
        return false;
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
