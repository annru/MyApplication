package com.example.myapplication.utils;

import android.content.Context;


/**
 * ------------------------- EncryptTools.java -------------------------
 * <p/>
 *
 * @author Created by zachary on 14-10-22 13:59.
 */
public class EncryptTools {


    static {
        System.loadLibrary("EncryptTools");
    }


    public static native String MD5(Context context, String[] text);

}
