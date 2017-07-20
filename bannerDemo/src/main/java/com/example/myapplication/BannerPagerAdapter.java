package com.example.myapplication;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 00224524 on 2016/12/20.
 * description:banner图片适配器
 */

class BannerPagerAdapter extends PagerAdapter {
    private List<String> mUrls;
    private Context mContext;
    private List<ImageView> mImageList = new ArrayList<>();

    BannerPagerAdapter(Context context, List<String> urls) {
        this.mContext = context;
        this.mUrls = urls;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        final ImageView imageView = new ImageView(mContext);
        Glide.with(mContext).load(mUrls.get(position)).into(imageView);
        container.addView(imageView);
        mImageList.add(imageView);
        return imageView;
    }

    @Override
    public int getCount() {
        return mUrls.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mImageList.get(position));
    }
}
