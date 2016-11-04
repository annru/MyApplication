package com.example.myapplication;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.github.jdsjlzx.progressindicator.AVLoadingIndicatorView;
import com.github.jdsjlzx.view.ArrowRefreshHeader;
import com.github.jdsjlzx.view.SimpleViewSwitcher;

import java.util.Date;

/**
 * Created by 00224524 on 2016/11/3.
 */

public class MyRefreshHeader extends LinearLayout implements BaseRefreshHeader {
    private LinearLayout mContainer;
    private ImageView mArrowImageView;
    private SimpleViewSwitcher mProgressBar;
    private TextView mStatusTextView;
    private int mState = 0;
    private TextView mHeaderTimeView;
    private Animation mRotateUpAnim;
    private Animation mRotateDownAnim;
    private static final int ROTATE_ANIM_DURATION = 180;
    public int mMeasuredHeight;
    private Context mContext;

    public MyRefreshHeader(Context context) {
        super(context);
        this.initView();
    }

    public MyRefreshHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.initView();
    }

    private void initView() {
        this.mContext = this.getContext();
        this.mContainer = (LinearLayout) LayoutInflater.from(this.getContext()).inflate(com.github.jdsjlzx.R.layout.listview_header, (ViewGroup) null);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2);
        lp.setMargins(0, 0, 0, 0);
        this.setLayoutParams(lp);
        this.setPadding(0, 0, 0, 0);
        this.addView(this.mContainer, new LinearLayout.LayoutParams(-1, 0));
        this.setGravity(80);
        this.mArrowImageView = (ImageView) this.findViewById(com.github.jdsjlzx.R.id.listview_header_arrow);
        this.mStatusTextView = (TextView) this.findViewById(com.github.jdsjlzx.R.id.refresh_status_textview);
        this.mProgressBar = (SimpleViewSwitcher) this.findViewById(com.github.jdsjlzx.R.id.listview_header_progressbar);
        AVLoadingIndicatorView progressView = new AVLoadingIndicatorView(this.getContext());
        progressView.setIndicatorColor(-4868683);
        progressView.setIndicatorId(22);
        this.mProgressBar.setView(progressView);
        this.mRotateUpAnim = new RotateAnimation(0.0F, -180.0F, 1, 0.5F, 1, 0.5F);
        this.mRotateUpAnim.setDuration(180L);
        this.mRotateUpAnim.setFillAfter(true);
        this.mRotateDownAnim = new RotateAnimation(-180.0F, 0.0F, 1, 0.5F, 1, 0.5F);
        this.mRotateDownAnim.setDuration(180L);
        this.mRotateDownAnim.setFillAfter(true);
        this.mHeaderTimeView = (TextView) this.findViewById(com.github.jdsjlzx.R.id.last_refresh_time);
        this.measure(-2, -2);
        this.mMeasuredHeight = this.getMeasuredHeight();
    }

    public void setProgressStyle(int style) {
        if (style == -1) {
            this.mProgressBar.setView(new ProgressBar(this.getContext(), (AttributeSet) null, 16842871));
        } else {
            AVLoadingIndicatorView progressView = new AVLoadingIndicatorView(this.getContext());
            progressView.setIndicatorColor(-4868683);
            progressView.setIndicatorId(style);
            this.mProgressBar.setView(progressView);
        }

    }

    public void setArrowImageView(int resid) {
        this.mArrowImageView.setImageResource(resid);
    }

    public void setState(int state) {
        if (state != this.mState) {
            if (state == 2) {
                this.mArrowImageView.clearAnimation();
                this.mArrowImageView.setVisibility(View.INVISIBLE);//4
                this.mProgressBar.setVisibility(View.VISIBLE);//0
            } else if (state == 3) {
                this.mArrowImageView.setVisibility(View.INVISIBLE);//4
                this.mProgressBar.setVisibility(View.INVISIBLE);//4
            } else {
                this.mArrowImageView.setVisibility(View.VISIBLE);//0
                this.mProgressBar.setVisibility(View.INVISIBLE);//4
            }

            switch (state) {
                case 0:
                    if (this.mState == 1) {
                        this.mArrowImageView.startAnimation(this.mRotateDownAnim);
                    }

                    if (this.mState == 2) {
                        this.mArrowImageView.clearAnimation();
                    }

                    this.mStatusTextView.setText(com.github.jdsjlzx.R.string.listview_header_hint_normal);
                    break;
                case 1:
                    if (this.mState != 1) {
                        this.mArrowImageView.clearAnimation();
                        this.mArrowImageView.startAnimation(this.mRotateUpAnim);
                        this.mStatusTextView.setText(com.github.jdsjlzx.R.string.listview_header_hint_release);
                    }
                    break;
                case 2:
                    this.mStatusTextView.setText(com.github.jdsjlzx.R.string.refreshing);
                    break;
                case 3:
                    this.mStatusTextView.setText(com.github.jdsjlzx.R.string.refresh_done);
            }

            this.mState = state;
        }
    }

    public int getState() {
        return this.mState;
    }

    public void refreshComplete() {
        this.mHeaderTimeView.setText(this.friendlyTime(new Date()));
        this.setState(3);
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                MyRefreshHeader.this.reset();
            }
        }, 200L);
    }

    public void setVisibleHeight(int height) {
        if (height < 0) {
            height = 0;
        }

        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        lp.height = height;
        this.mContainer.setLayoutParams(lp);
    }

    public int getVisibleHeight() {
        LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mContainer.getLayoutParams();
        return lp.height;
    }

    public void onMove(float delta) {
        if (this.getVisibleHeight() > 0 || delta > 0.0F) {
            this.setVisibleHeight((int) delta + this.getVisibleHeight());
            if (this.mState <= 1) {
                if (this.getVisibleHeight() > this.mMeasuredHeight) {
                    this.setState(1);
                } else {
                    this.setState(0);
                }
            }
        }

    }

    public boolean releaseAction() {
        boolean isOnRefresh = false;
        int height = this.getVisibleHeight();
        if (height == 0) {
            isOnRefresh = false;
        }

        if (this.getVisibleHeight() > this.mMeasuredHeight && this.mState < 2) {
            this.setState(2);
            isOnRefresh = true;
        }

        if (this.mState == 2 && height <= this.mMeasuredHeight) {
            ;
        }

        int destHeight = 0;
        if (this.mState == 2) {
            destHeight = this.mMeasuredHeight;
        }

        this.smoothScrollTo(destHeight);
        return isOnRefresh;
    }

    public void reset() {
        this.smoothScrollTo(0);
        (new Handler()).postDelayed(new Runnable() {
            public void run() {
                MyRefreshHeader.this.setState(0);
            }
        }, 500L);
    }

    private void smoothScrollTo(int destHeight) {
        ValueAnimator animator = ValueAnimator.ofInt(new int[]{this.getVisibleHeight(), destHeight});
        animator.setDuration(300L).start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator animation) {
                MyRefreshHeader.this.setVisibleHeight(((Integer) animation.getAnimatedValue()).intValue());
            }
        });
        animator.start();
    }

    public String friendlyTime(Date time) {
        int ct = (int) ((System.currentTimeMillis() - time.getTime()) / 1000L);
        if (ct == 0) {
            return this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_just);
        } else if (ct > 0 && ct < 60) {
            return ct + this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_seconds_ago);
        } else if (ct >= 60 && ct < 3600) {
            return Math.max(ct / 60, 1) + this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_minute_ago);
        } else if (ct >= 3600 && ct < 86400) {
            return ct / 3600 + this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_hour_ago);
        } else if (ct >= 86400 && ct < 2592000) {
            int day = ct / 86400;
            return day + this.getContext().getResources().getString(com.github.jdsjlzx.R.string.text_day_ago);
        } else {
            return ct >= 2592000 && ct < 31104000 ? ct / 2592000 + this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_month_ago) : ct / 31104000 + this.mContext.getResources().getString(com.github.jdsjlzx.R.string.text_year_ago);
        }
    }
}
