package com.example.myapplication.wxapi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by annru on 2016/3/16.
 */
public class WXEntryActivity extends Activity   {

    private static String TAG = "WXEntryActivity";


    // 是否有新的认证请求
    public static boolean hasNewAuth = false;
    private TextView mTvCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

}
