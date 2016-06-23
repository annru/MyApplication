package com.example.myapplication.base;

import android.app.Application;
import android.util.Log;

import com.example.myapplication.activity.gesture.AppForegroundStateManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

/**
 * Created by annru on 2016/4/26.
 * Description:
 */
public class MyApplication extends Application implements AppForegroundStateManager.OnAppForegroundStateChangeListener {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);

        //调试工具
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());

        AppForegroundStateManager.getInstance().addListener(this);
    }

    @Override
    public void onAppForegroundStateChange(AppForegroundStateManager.AppForegroundState newState) {
        if (AppForegroundStateManager.AppForegroundState.IN_FOREGROUND == newState) {
            // App just entered the foreground. Do something here!
            Log.i("MyApplication", "在前台");
        } else {
            // App just entered the background. Do something here!
            Log.i("MyApplication", "在后台");
        }
    }
}
