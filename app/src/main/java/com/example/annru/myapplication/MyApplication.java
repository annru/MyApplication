package com.example.annru.myapplication;

import android.app.Application;
import android.util.Log;

/**
 * Created by annru on 2015/10/31.
 */
public class MyApplication extends Application implements AppForegroundStateManager.OnAppForegroundStateChangeListener {
    @Override
    public void onCreate() {
        super.onCreate();
        AppForegroundStateManager.getInstance().addListener(this);
    }

    @Override
    public void onAppForegroundStateChange(AppForegroundStateManager.AppForegroundState newState) {
        if (AppForegroundStateManager.AppForegroundState.IN_FOREGROUND == newState) {
            // App just entered the foreground. Do something here!
                    Log.i("MyApplication","在前台");
        } else {
            // App just entered the background. Do something here!
            Log.i("MyApplication","在后台");
        }
    }


}
