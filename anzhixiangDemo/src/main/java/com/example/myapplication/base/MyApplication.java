package com.example.myapplication.base;

import android.app.Application;
import android.util.Log;

import com.example.myapplication.activity.gesture.AppForegroundStateManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by annru on 2016/4/26.
 * Description:
 */
public class MyApplication extends Application implements AppForegroundStateManager
        .OnAppForegroundStateChangeListener {
    private static final String APP_ID = "6da26e01e9";//腾讯bugly AppId

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
        //程序前台后台
        AppForegroundStateManager.getInstance().addListener(this);

        //bugly异常上报平台
        /**
         第三个参数为SDK调试模式开关，调试模式的行为特性如下：
         ● 输出详细的Bugly SDK的Log；
         ● 每一条Crash都会被立即上报；
         ● 自定义日志将会在Logcat中输出。
         建议在测试阶段建议设置成true，发布时设置为false。
         */
        CrashReport.initCrashReport(getApplicationContext(), APP_ID, true);
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
