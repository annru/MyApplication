package com.zendaimoney.laocaibao.base;

import android.app.Application;
import android.widget.Toast;

import com.igexin.sdk.PushManager;
import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;
import com.zendaimoney.laocaibao.BuildConfig;

/**
 * Created by 00224524 on 2017/6/15.
 * description:
 */

public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        SophixManager.getInstance().setContext(this)
                .setAppVersion(BuildConfig.VERSION_NAME)
                .setAesKey(null)
                .setEnableDebug(true)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int
                            handlePatchVersion) {
                        // 补丁加载回调通知
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            // 表明补丁加载成功
                            Toast.makeText(getApplicationContext(), "补丁加载成功", Toast.LENGTH_LONG).show();
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 表明新补丁生效需要重启. 开发者可提示用户或者强制重启;
                            // 建议: 用户可以监听进入后台事件, 然后应用自杀
                            SophixManager.getInstance().killProcessSafely();
                            Toast.makeText(getApplicationContext(), "杀死进程", Toast.LENGTH_LONG).show();
                        } else if (code == PatchStatus.CODE_LOAD_FAIL) {
                            // 内部引擎异常, 推荐此时清空本地补丁, 防止失败补丁重复加载
                            // SophixManager.getInstance().cleanPatches();
                        } else {
                            // 其它错误信息, 查看PatchStatus类说明
                        }
                    }
                }).initialize();
        SophixManager.getInstance().queryAndLoadNewPatch();


        //个推sdk初始化
        PushManager.getInstance().initialize(this.getApplicationContext());
    }
}
