package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;

/**
 * Created on 2018/2/28.
 *
 * @author 00224524
 */

public class ScaleView extends BaseView {
    private Paint mLinePaint;

    public ScaleView(Context context) {
        super(context);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStrokeWidth(2);
        mLinePaint.setAntiAlias(true);
        Log.i("初始化init", "..............");

    }

    @Override
    protected void initVal() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        init();
        Log.i("canvas对象", ".............." + canvas);
        onDrawLine(canvas, mLinePaint);
        onDrawScale(canvas, mLinePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onDrawLine(Canvas canvas, Paint paint) {
        canvas.drawLine(120, 350, 840, 350, paint);
    }

    @Override
    protected void onDrawScale(Canvas canvas, Paint paint) {
        int temp = 840 - 120;
        int len = temp / mScaleMargin;

        for (int i = 0; i <= len; i++) {
            if (i % 10 == 0) {
                canvas.drawLine(mMin + i * mScaleMargin, 300, mMin + (i * mScaleMargin), 350, paint);
            } else {
                canvas.drawLine(mMin + i * mScaleMargin, 320, mMin + (i * mScaleMargin), 350, paint);
            }

        }

    }
}
