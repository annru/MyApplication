package com.example.annru.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.igexin.sdk.PushManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Bind(R.id.title_tv)
    TextView titleTv;

    @Bind(R.id.test_btn)
    Button testBtn;


    @Bind(R.id.test2_btn)
    Button test2Btn;

    @OnClick(R.id.test2_btn)
    public void showsdd(){
//        Toast.makeText(MainActivity.this,"你好帅啊",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,SecondActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        PushManager.getInstance().initialize(this.getApplicationContext());
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
