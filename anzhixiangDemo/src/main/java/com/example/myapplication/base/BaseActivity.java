package com.example.myapplication.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.activity.gesture.AppForegroundStateManager;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        AppForegroundStateManager.getInstance().onActivityVisible(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        AppForegroundStateManager.getInstance().onActivityNotVisible(this);
    }
}
