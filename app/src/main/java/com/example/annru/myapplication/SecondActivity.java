package com.example.annru.myapplication;

import android.os.Bundle;
import android.view.View;

public class SecondActivity extends BaseActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
    }

    @Override
    public void onClick(View v) {

    }
}
