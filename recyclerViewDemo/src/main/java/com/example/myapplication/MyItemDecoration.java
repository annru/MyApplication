package com.example.myapplication;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created on 2018/1/2.
 *
 * @author 00224524
 */

public class MyItemDecoration extends RecyclerView.ItemDecoration {
    private Paint mPaint;
    private int mDividerHeight;


    public MyItemDecoration(Context context, int height) {
        mPaint = new Paint();
        mDividerHeight = height;
        mPaint.setColor(ContextCompat.getColor(context, R.color.colorPrimary));
    }


    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom = mDividerHeight;
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        int left = parent.getPaddingLeft();
        int right = parent.getWidth() - parent.getPaddingRight();
        for (int i = 0; i < childCount - 1; i++) {
            View view = parent.getChildAt(i);
            int top = view.getBottom();
            int bottom = top + mDividerHeight;
            c.drawRect(left, top, right, bottom, mPaint);
        }
    }
}
