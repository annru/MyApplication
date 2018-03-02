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
    /**
     * 刻度尺的宽度
     */
    private int mScaleWidth;

    private Paint mLinePaint;

    private int lineY = 350;

    public ScaleView(Context context) {
        super(context);
        Log.i("子类构造函数", "1");
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
        Log.i("子类构造函数", "2");
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Log.i("子类构造函数", "3");
    }

    public ScaleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
        Log.i("子类构造函数", "4");
    }

    private void init() {
        mLinePaint = new Paint();
        mLinePaint.setColor(Color.RED);
        mLinePaint.setStrokeWidth(2);
        mLinePaint.setAntiAlias(true);
    }

    @Override
    protected void initVal() {
        mScaleWidth = mMax - mMin;
        Log.i("刻度尺宽度", mScaleWidth + "");

    }

    @Override
    protected void onDraw(Canvas canvas) {
        onDrawLine(canvas, mLinePaint);
        onDrawScale(canvas, mLinePaint);
        super.onDraw(canvas);
    }

    @Override
    protected void onDrawLine(Canvas canvas, Paint paint) {
        canvas.drawLine(mMin, lineY, mMax, lineY, paint);
    }

    @Override
    protected void onDrawScale(Canvas canvas, Paint paint) {
        //刻多少个刻度
        int len = mScaleWidth / mScaleMargin;
        for (int i = 0, k = 0; i <= len; i++) {
            //画线x坐标起点
            int startX = mMin + (i * mScaleMargin);
            //画线x坐标终点
            int stopX = mMin + (i * mScaleMargin);

            if (i % 10 == 0) {
                mScaleHeight = mScaleMaxHeight;
                paint.setTextSize(36);
                canvas.drawText(String.valueOf(k), startX, lineY - mScaleHeight, paint);
                k += 10;
            } else {
                mScaleHeight = mScaleMaxHeight / 2;
            }

            //画线y坐标起点
            int startY = lineY - mScaleHeight;
            int stopY = lineY;
            canvas.drawLine(startX, startY, stopX, stopY, paint);
        }
    }

    @Override
    protected void onDrawScaleText(Canvas canvas, Paint paint) {

    }
}
