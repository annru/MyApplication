package com.zendaimoney.laocaibao.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.adapter.FragmentAdapter;
import com.zendaimoney.laocaibao.fragment.MainFragment;
import com.zendaimoney.laocaibao.fragment.MoreFragment;
import com.zendaimoney.laocaibao.fragment.MyCenterFragment;
import com.zendaimoney.laocaibao.fragment.ProductFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar bottomNavigationBar;

    private int[] resId = new int[]{R.mipmap.ic_launcher_round, R.mipmap.ic_launcher_round, R.mipmap
            .ic_launcher_round, R
            .mipmap.ic_launcher_round};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] titles = getResources().getStringArray(R.array.tab_title);
        ButterKnife.bind(this);
        List<Fragment> list = new ArrayList<>();
        list.add(MainFragment.newInstances());
        list.add(ProductFragment.newInstances());
        list.add(MyCenterFragment.newInstances());
        list.add(MoreFragment.newInstances());
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigationBar.selectTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationBar.addItem(new BottomNavigationItem(resId[0], titles[0]))
                .addItem(new BottomNavigationItem(resId[1], titles[1]))
                .addItem(new BottomNavigationItem(resId[2], titles[2]))
                .addItem(new BottomNavigationItem(resId[3], titles[3])).initialise();
        bottomNavigationBar.setTabSelectedListener(new BottomNavigationBar.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position) {
                viewPager.setCurrentItem(position);
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
