package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created on 2018/2/28.
 * 刻度尺自定义视图基础类
 *
 * @author 00224524
 */

public abstract class BaseView extends View {

    public static final int[] ATTR = {
            R.attr.lf_scale_view_min,
            R.attr.lf_scale_view_max,
            R.attr.lf_scale_view_margin,
            R.attr.lf_scale_view_height,
    };

    public static final @StyleableRes
    int LF_SCALE_MIN = 0;
    public static final @StyleableRes
    int LF_SCALE_MAX = 1;
    public static final @StyleableRes
    int LF_SCALE_MARGIN = 2;
    public static final @StyleableRes
    int LF_SCALE_HEIGHT = 3;

    /**
     * 最大刻度
     */
    protected int mMax;
    /**
     * 最小刻度
     */
    protected int mMin;
    /**
     * 刻度间距
     */
    protected int mScaleMargin;
    /**
     * 刻度线的高度
     */
    protected int mScaleHeight;
    /**
     * 整刻度线高度
     */
    protected int mScaleMaxHeight;

    public BaseView(Context context) {
        super(context);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
    }


    private void init(AttributeSet attr) {
        TypedArray array = getContext().obtainStyledAttributes(attr, ATTR);
        mMin = array.getInteger(LF_SCALE_MIN, 0);
        mMax = array.getInteger(LF_SCALE_MAX, 0);
        mScaleMargin = array.getDimensionPixelOffset(LF_SCALE_MARGIN, 15);
        mScaleHeight = array.getDimensionPixelOffset(LF_SCALE_HEIGHT, 20);
        array.recycle();

        initVal();
    }


    /**
     * 子类初始化
     */
    protected abstract void initVal();

    /**
     * 画线
     *
     * @param canvas
     * @param paint
     */
    protected abstract void onDrawLine(Canvas canvas, Paint paint);


    /**
     * 画刻度
     *
     * @param canvas
     * @param paint
     */
    protected abstract void onDrawScale(Canvas canvas, Paint paint);

}
