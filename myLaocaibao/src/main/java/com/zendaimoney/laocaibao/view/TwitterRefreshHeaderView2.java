package com.zendaimoney.laocaibao.view;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.SwipeRefreshHeaderLayout;
import com.zendaimoney.laocaibao.R;


/**
 * Created by Aspsine on 2015/9/9.
 * 自定义下拉刷新视图
 */
public class TwitterRefreshHeaderView2 extends SwipeRefreshHeaderLayout {
    private AnimationDrawable animationDrawable;
    private ImageView rotateView;
    private ImageView ivSuccess;
    private TextView tvRefresh;
    private TextView successTv;
    private LinearLayout refreshLl;
    private int mHeaderHeight;
    private boolean rotated = false;

    public TwitterRefreshHeaderView2(Context context) {
        this(context, null);
    }

    public TwitterRefreshHeaderView2(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TwitterRefreshHeaderView2(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mHeaderHeight = getResources().getDimensionPixelOffset(R.dimen.refresh_header_height_twitter);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        rotateView = (ImageView) findViewById(R.id.rotate_view);
        successTv = (TextView) findViewById(R.id.success_tv);
        tvRefresh = (TextView) findViewById(R.id.tvRefresh);
        refreshLl = (LinearLayout) findViewById(R.id.refresh_ll);
        ivSuccess = (ImageView) findViewById(R.id.ivSuccess);
    }

    @Override
    public void onRefresh() {
        ivSuccess.setVisibility(GONE);
        startRotateAnimation();
        tvRefresh.setText("刷新中...");
    }

    @Override
    public void onPrepare() {
        Log.d("TwitterRefreshHeader", "onPrepare()");
    }

    @Override
    public void onMove(int y, boolean isComplete, boolean automatic) {
        Log.i("y:------>:", y + "");
        float scale = ((float) y) / mHeaderHeight;
        if (!isComplete) {
            refreshLl.setVisibility(View.VISIBLE);
            ivSuccess.setVisibility(GONE);
            successTv.setVisibility(GONE);
            if (y > mHeaderHeight) {
                tvRefresh.setText("松开可以刷新");
//                if (!rotated) {
////                    ivArrow.clearAnimation();
////                    ivArrow.startAnimation(rotateUp);
//                    scaleLogo(scale);
//                    rotated = true;
//                }
//                scaleLogo(scale);

            } else if (y < mHeaderHeight) {
//                if (rotated) {
////                    ivArrow.clearAnimation();
////                    ivArrow.startAnimation(rotateDown);
//                    scaleLogo(scale);
//                    rotated = false;
//                }
//                if (animationDrawable != null) {
//                    animationDrawable.stop();
//                }
                scaleLogo(scale);
                tvRefresh.setText("下拉即可刷新");
            }
        }
    }

    @Override
    public void onRelease() {
        Log.d("TwitterRefreshHeader", "onRelease()");
    }

    @Override
    public void onComplete() {
        rotated = false;
        ivSuccess.setVisibility(VISIBLE);
        refreshLl.setVisibility(GONE);
        successTv.setVisibility(View.VISIBLE);
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    @Override
    public void onReset() {
        rotated = false;
        ivSuccess.setVisibility(GONE);
    }

    private void scaleLogo(float scale) {
        if (scale < 1) {
            rotateView.setScaleX(scale);
            rotateView.setScaleY(scale);
        }

    }

    public void startRotateAnimation() {
        if (animationDrawable == null || !(animationDrawable.isRunning())) {
            rotateView.setBackgroundResource(R.drawable.loading);
            animationDrawable = (AnimationDrawable) rotateView.getBackground();
            animationDrawable.start();
        }
    }

}
