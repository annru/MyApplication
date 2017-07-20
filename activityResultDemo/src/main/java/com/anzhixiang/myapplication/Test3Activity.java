package com.anzhixiang.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class Test3Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test3);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.back_btn)
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_btn:
                Intent intent = new Intent();
                setResult(0, intent.putExtra("data", "测试"));
//                setResult(RESULT_OK, intent.putExtra("data2", "测试2"));
                finish();
                break;
        }
    }
}
