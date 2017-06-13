package com.zendaimoney.laocaibao.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zendaimoney.laocaibao.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private int[] resId = new int[]{R.drawable.ic_tab_one_on, R.drawable.ic_tab_two_on, R.drawable.ic_tab_3_on, R
            .drawable.ic_tab_4_on};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titles = getResources().getStringArray(R.array.tab_title);
        ButterKnife.bind(this);
//        viewPager.setAdapter();
        bottomNavigationBar.addItem(new BottomNavigationItem(resId[0], titles[0]))
                .addItem(new BottomNavigationItem(resId[1], titles[1]))
                .addItem(new BottomNavigationItem(resId[2], titles[2]))
                .addItem(new BottomNavigationItem(resId[3], titles[3])).initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {

            }

            @Override
            public void onTabUnselected(int position) {

            }

            @Override
            public void onTabReselected(int position) {

            }
        });
    }
}
