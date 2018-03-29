package com.example.myapplication;

/**
 * Created on 2018/3/26.
 *
 * @author 00224524
 */

public class JniUtils {

    /**
     * 将用C++代码实现，在android代码中调用的方法：获取一段文字
     */
    public static native String getStrFromC();


    static {
        System.loadLibrary("myLib");
    }

}
