package com.jintou.shyumi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.jintou.shyumi.R;

import java.lang.ref.WeakReference;

public class SplashActivity extends AppCompatActivity {
    private MyHandler mMyHandler = new MyHandler(SplashActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().setBackgroundDrawableResource(R.mipmap.ic_splash_bg);
        mMyHandler.sendEmptyMessageDelayed(0, 3000);
    }

    static class MyHandler extends Handler {
        WeakReference<SplashActivity> mActivity;

        MyHandler(SplashActivity activity) {
            mActivity = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            SplashActivity activity = mActivity.get();
            if (activity != null) {
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        }
    }

    @Override
    public void onBackPressed() {

    }
}
