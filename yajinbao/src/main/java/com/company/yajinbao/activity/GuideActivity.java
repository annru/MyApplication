package com.company.yajinbao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.company.yajinbao.BuildConfig;
import com.company.yajinbao.R;
import com.company.yajinbao.adapter.GuideViewPagerAdapter;
import com.company.yajinbao.utils.SPUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 引导页
 *
 * @author 00225075
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private final String PREFERENCE_CODE = "VERSION_NAME";

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    private int[] resIdArray = new int[]{R.layout.activity_guide_one, R.layout.activity_guide_two};
    private int mIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ButterKnife.bind(this);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        initViews();
    }

    @Override
    protected void onStart() {
        super.onStart();
        pageJump();
    }

    private void initViews() {
        LayoutInflater inflater = LayoutInflater.from(this);
        List<View> views = new ArrayList<>();
        final ViewGroup nullParent = null;
        for (int id : resIdArray) {
            View view = inflater.inflate(id, nullParent, false);
            views.add(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mIndex == resIdArray.length - 1) {
                        goHome();
                        setGuided();
                    }
                }
            });
        }
        GuideViewPagerAdapter adapter = new GuideViewPagerAdapter(views);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        mIndex = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }


    //跳转到首页
    private void goHome() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * 设置已经引导过了，下次启动不用再次引导
     */
    private void setGuided() {
        SPUtils.put(this, PREFERENCE_CODE, BuildConfig.VERSION_CODE);
    }

    /**
     * 页面跳转
     */
    private void pageJump() {
        Object object = SPUtils.get(this, PREFERENCE_CODE, 0);
        if (object != null) {
            int versionCode = (Integer) object;
            if (versionCode < BuildConfig.VERSION_CODE) {
                Log.i("versionCode:", versionCode + "");
            } else {
                goHome();
            }
        }
    }
}
