package com.company.yajinbao.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by 00224524 on 2017/5/22.
 * description:欢迎引导页适配器类
 */

public class GuideViewPagerAdapter extends PagerAdapter {
    private List<View> mList;

    public GuideViewPagerAdapter(List<View> list) {
        this.mList = list;
    }


    @Override
    public int getCount() {
        if (mList != null) {
            return mList.size();
        }
        return 0;
    }

    /**
     * 初始化position位置的界面
     */
    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        view.addView(mList.get(position), 0);
        return mList.get(position);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    /**
     * 销毁position位置的界面
     */
    @Override
    public void destroyItem(ViewGroup view, int position, Object arg2) {
        view.removeView(mList.get(position));
    }
}
