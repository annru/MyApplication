package com.example.myapplication.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.view_pager_btn)
    Button viewPagerBtn;

    @Bind(R.id.retrofit_btn)
    Button retrofitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        viewPagerBtn.setOnClickListener(this);
        retrofitBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.view_pager_btn:
                intent = new Intent(this, GuideActivity.class);
                startActivity(intent);
                break;
            case R.id.retrofit_btn:
                intent = new Intent(this, RetrofitActivity.class);
                startActivity(intent);
                break;
        }
    }
}
