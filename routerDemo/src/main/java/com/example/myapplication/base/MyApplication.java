package com.example.myapplication.base;

import android.app.Application;

import com.chenenyu.router.Router;
import com.example.myapplication.BuildConfig;

/**
 * Created by 00224524 on 2017/11/15.
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Router.setDebuggable(true);
        }
        Router.initialize(this);
    }
}
