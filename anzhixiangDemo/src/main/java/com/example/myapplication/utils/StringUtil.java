package com.example.myapplication.utils;

import com.example.myapplication.mvvm.User;

/**
 * Created by 00224524 on 2016/6/30.
 * 描述：
 */
public class StringUtil {

    public static String appendStr(String str, User user) {
        String result;
        if (user.getFirstName().equals("an"))
            result = "安的姓名" + str;
        else
            result = "他的姓名" + str;
        return result;
    }
}
