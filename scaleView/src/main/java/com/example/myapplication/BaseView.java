package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.annotation.StyleableRes;
import android.util.AttributeSet;
import android.util.Log;
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
    protected int mScaleMaxHeight = 100;

    public BaseView(Context context) {
        super(context);
        init(null);
        Log.i("构造函数", "1");
    }

    public BaseView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
        Log.i("构造函数", "2");
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs);
        Log.i("构造函数", "3");
    }

    public BaseView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(attrs);
        Log.i("构造函数", "4");
    }


    private void init(AttributeSet attr) {
        TypedArray array = getContext().obtainStyledAttributes(attr, R.styleable.ScaleView);
        mMin = array.getInteger(R.styleable.ScaleView_lf_scale_view_min, 0);
        mMax = array.getInteger(R.styleable.ScaleView_lf_scale_view_max, 100);
        Log.i("刻度尺宽度Min", mMin + "");
        Log.i("刻度尺宽度Max", mMax + "");
        mScaleMargin = array.getDimensionPixelOffset(LF_SCALE_MARGIN, 15);
        mScaleHeight = array.getDimensionPixelOffset(LF_SCALE_HEIGHT, 20);
        Log.i("刻度尺间距", mScaleMargin + "");
        Log.i("刻度尺高度", mScaleHeight + "");
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


    /**
     * 画刻度数文本
     *
     * @param canvas
     * @param paint
     */
    protected abstract void onDrawScaleText(Canvas canvas, Paint paint);

}
