package com.example.myapplication;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        AppUtils.setStatusBarColor(this, R.color.trans);
        ButterKnife.bind(this);
        BannerPagerAdapter adapter = new BannerPagerAdapter(this, getUrls());
        viewPager.setAdapter(adapter);
    }

    private List<String> getUrls() {
        List<String> list = new ArrayList<>();
        list.add("http://www.laocaibao.com/lcb/8a2f5a6a9b7427fa.png");
        list.add("http://www.laocaibao.com/lcb/1b7c3df96f7d65b8.png");
        list.add("http://www.laocaibao.com/lcb/d0c6e7ae90659c08.png");
        list.add("http://www.laocaibao.com/lcb/81bb19d607fbe5f8.png");
        return list;
    }
}
