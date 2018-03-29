package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.ViewGroup;

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


        mRectWidth = (mMax - mMin) * mScaleMargin;
        mRectHeight = mScaleHeight * 8;
        mScaleMaxHeight = mScaleHeight * 2;
//         设置layoutParams
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(mRectWidth, mRectHeight);
        this.setLayoutParams(lp);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int height = MeasureSpec.makeMeasureSpec(mRectHeight, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, height);
        mScaleScrollViewRange = getMeasuredWidth();
        mTempScale = mScaleScrollViewRange / mScaleMargin / 2 + mMin;
        mMidCountScale = mScaleScrollViewRange / mScaleMargin / 2 + mMin;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        onDrawLine(canvas, mLinePaint);
        onDrawScale(canvas, mLinePaint);
        onDrawPointer(canvas, mLinePaint);
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
    protected void onDrawPointer(Canvas canvas, Paint paint) {
        paint.setColor(Color.RED);

        //每一屏幕刻度的个数/2
        int countScale = mScaleScrollViewRange / mScaleMargin / 2;
        //根据滑动的距离，计算指针的位置【指针始终位于屏幕中间】
        int finalX = mScroller.getFinalX();
        //滑动的刻度
        int tmpCountScale = (int) Math.rint((double) finalX / (double) mScaleMargin); //四舍五入取整
        //总刻度
        mCountScale = tmpCountScale + countScale + mMin;
        if (mScrollListener != null) { //回调方法
            mScrollListener.onScaleScroll(mCountScale);
        }
        canvas.drawLine(countScale * mScaleMargin + finalX, mRectHeight,
                countScale * mScaleMargin + finalX, mRectHeight - mScaleMaxHeight - mScaleHeight, paint);
    }

    @Override
    protected void onDrawScaleText(Canvas canvas, Paint paint) {

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (mScroller != null && !mScroller.isFinished()) {
                    mScroller.abortAnimation();
                }
                mScrollLastX = x;
                return true;
            case MotionEvent.ACTION_MOVE:
                int dataX = mScrollLastX - x;
                //向右边滑动
                if (mCountScale - mTempScale < 0) {
                    //禁止继续向右滑动
                    if (mCountScale <= mMin && dataX <= 0) {
                        return super.onTouchEvent(event);
                    }
                }
                //向左边滑动
                else if (mCountScale - mTempScale > 0) {
                    //禁止继续向左滑动
                    if (mCountScale >= mMax && dataX >= 0) {
                        return super.onTouchEvent(event);
                    }
                }
                smoothScrollBy(dataX, 0);
                mScrollLastX = x;
                postInvalidate();
                mTempScale = mCountScale;
                return true;
            case MotionEvent.ACTION_UP:
                if (mCountScale < mMin) {
                    mCountScale = mMin;
                }
                if (mCountScale > mMax) {
                    mCountScale = mMax;
                }
                int finalX = (mCountScale - mMidCountScale) * mScaleMargin;
                //纠正指针位置
                mScroller.setFinalX(finalX);
                postInvalidate();
                return true;

            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void scrollToScale(int val) {
        if (val < mMin || val > mMax) {
            return;
        }
        int dx = (val - mCountScale) * mScaleMargin;
        smoothScrollBy(dx, 0);
    }
}
