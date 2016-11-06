package com.example.myapplication.base;

import android.app.Application;
import android.util.Log;

import com.alipay.euler.andfix.patch.PatchManager;
import com.example.myapplication.activity.gesture.AppForegroundStateManager;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.stetho.Stetho;

/**
 * Created by annru on 2016/4/26.
 * Description:
 */
public class MyApplication extends Application implements AppForegroundStateManager
        .OnAppForegroundStateChangeListener {
    private static final String APP_ID = "6da26e01e9";//腾讯bugly AppId

    private static final String TAG = "euler";

    private static final String APATCH_PATH = "/out.apatch";

    private static final String DIR = "apatch";//补丁文件夹
    /**
     * patch manager
     */
    private PatchManager mPatchManager;

    @Override
    public void onCreate() {
        super.onCreate();
//        Fresco.initialize(this);

        //调试工具
//        Stetho.initialize(
//                Stetho.newInitializerBuilder(this)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                        .build());
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
//        CrashReport.initCrashReport(getApplicationContext(), APP_ID, true);
//        CrashReport.initCrashReport(getApplicationContext());

        //AndFix热修复
        // initialize
//        mPatchManager = new PatchManager(this);
//        mPatchManager.init("1.0");
//        Log.d(TAG, "inited.");

        // load patch
//        mPatchManager.loadPatch();
//        Log.d(TAG, "apatch loaded.");

        // add patch at runtime
//        try {
//            // .apatch file path
//            String patchFileString = Environment.getExternalStorageDirectory()
//                    .getAbsolutePath() + APATCH_PATH;
//            mPatchManager.addPatch(patchFileString);
//            Log.d(TAG, "apatch:" + patchFileString + " added.");
//
//            //复制且加载补丁成功后，删除下载的补丁
//            File f = new File(this.getFilesDir(), DIR + APATCH_PATH);
//            if (f.exists()) {
//                boolean result = new File(patchFileString).delete();
//                if (!result)
//                    Log.e(TAG, patchFileString + " delete fail");
//            }
//        } catch (IOException e) {
//            Log.e(TAG, "", e);
//        }


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
