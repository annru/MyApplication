package com.anzhixiang.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 测试startActivityForResult模式的跳转，深刻理解requestCode与resultCode之间的区别及使用场景
 *
 * @author 00224524
 * @date 2017-04-214
 */
public class MainActivity extends AppCompatActivity {


    @Bind(R.id.test1_btn)
    Button test1;

    @Bind(R.id.test2_btn)
    Button test2;

    @Bind(R.id.test_tv)
    TextView testTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.test1_btn, R.id.test2_btn})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.test1_btn:
                intent = new Intent(this, Test1Activity.class);
                startActivityForResult(intent, 1);
                break;
            case R.id.test2_btn:
                intent = new Intent(this, Test1Activity.class);
                startActivityForResult(intent, 2);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data == null) {
            return;
        }
        Log.i("onActivityResult", resultCode + "");
        switch (requestCode) {
            case 1:
                testTv.setText(data.getStringExtra("data") + "");
                break;
            case 2:
                testTv.setText(data.getStringExtra("data2") + "");
                break;
        }
    }
}
