package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.BaseFragment;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/6/13.
 * description:
 */

public class ProductFragment extends LazyLoadFragment implements ViewPager.OnPageChangeListener, TabLayout
        .OnTabSelectedListener {
    private boolean isPrepared;//初始化完成标识符


    public static ProductFragment newInstances() {
        ProductFragment productFragment = new ProductFragment();
        return productFragment;
    }

    public ProductFragment() {
        //需要默认的构造方法
    }

    @BindView(R.id.tab)
    TabLayout tabLayout;

    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private List<BaseFragment> list = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("onActivityCreated", "初始化");
        list.clear();
        list.add(ProductTabOneFragment.newInstance());
        list.add(ProductTabTwoFragment.newInstance());
        list.add(ProductTabThreeFragment.newInstance());
        FragmentManager fm = getChildFragmentManager();
        viewPager.setAdapter(new MyViewPagerAdapter(fm));
        viewPager.addOnPageChangeListener(this);
        String[] tabsTitle = getActivity().getResources().getStringArray(R.array.tab_title2);
        tabLayout.addTab(tabLayout.newTab().setText(tabsTitle[0]));
        tabLayout.addTab(tabLayout.newTab().setText(tabsTitle[1]));
        tabLayout.addTab(tabLayout.newTab().setText(tabsTitle[2]));
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        //填充数据
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabLayout.setScrollPosition(position, 0, false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        Log.i("onTabSelected", tab.getPosition() + "");
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }

    private class MyViewPagerAdapter extends FragmentPagerAdapter {

        MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }
}
