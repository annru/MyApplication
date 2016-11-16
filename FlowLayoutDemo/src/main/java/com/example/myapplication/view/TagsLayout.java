package com.example.myapplication.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.model.Location;

/**
 * Created by annru on 2016/11/6.
 * Description:
 */

public class TagsLayout extends ViewGroup {

    private static final String LOG_TAG = TagsLayout.class.getSimpleName();

    private int childHorizontalSpace;
    private int childVerticalSpace;


    public TagsLayout(Context context) {
        super(context);
    }

    public TagsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.TagsLayout);
        if (attrArray != null) {
            childHorizontalSpace = attrArray.getDimensionPixelSize(R.styleable.TagsLayout_tagHorizontalSpace, 0);
            childVerticalSpace = attrArray.getDimensionPixelSize(R.styleable.TagsLayout_tagVerticalSpace, 0);
            attrArray.recycle();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);//去掉左右两边的margin，剩余的宽度
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
//        Log.i(LOG_TAG + "_sizeWidth", sizeWidth + "");
//        Log.i(LOG_TAG + "_sizeHeight", sizeHeight + "");
//        Log.i(LOG_TAG + "_modeWidth", modeWidth + "");
//        Log.i(LOG_TAG + "_modeHeight", modeHeight + "");
//        Log.i(LOG_TAG, "=============================我是华丽的分割线==========================");


        // 如果是warp_content情况下，记录宽和高
        int width = 0;
        int height = 0;

        int lineWidth = 0;//行宽
        int lineHeight = 0;//行高

        int count = getChildCount();
        int left = getPaddingLeft();
        int top = getPaddingTop();


        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE)
                continue;
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            //当前子控件实际占据的宽度
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin + childHorizontalSpace;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin + childVerticalSpace;
//            Log.i(LOG_TAG, "childWidth_" + childWidth);
//            Log.i(LOG_TAG, "childHeight_" + childHeight);
            Log.i("lineWidth", lineWidth + "");
            Log.i("childWidth", childWidth + "");
            if (lineWidth + childWidth > sizeWidth - getPaddingLeft() - getPaddingRight()) {

                width = Math.max(lineWidth, childWidth);
                lineWidth = childWidth;
//                Log.i(LOG_TAG, lineWidth + "");
                height += lineHeight;//开启记录下一行的高度
                child.setTag(new Location(left, top + height, childWidth + left - childHorizontalSpace, height + child
                        .getMeasuredHeight() + top));
            } else {
                child.setTag(new Location(lineWidth + left, top + height, lineWidth + childWidth -
                        childHorizontalSpace + left, height + child.getMeasuredHeight() + top));
                lineWidth += childWidth;
                lineHeight = Math.max(lineHeight, childHeight);
            }
        }
        width = Math.max(width, lineWidth) + getPaddingLeft() + getPaddingRight();
        height += lineHeight;
        sizeHeight += getPaddingTop() + getPaddingBottom();
        height += getPaddingTop() + getPaddingBottom();
        setMeasuredDimension((modeWidth == MeasureSpec.EXACTLY) ? sizeWidth : width, (modeHeight
                == MeasureSpec.EXACTLY) ? sizeHeight : height);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            if (child.getVisibility() == GONE)
                continue;
            Location location = (Location) child.getTag();
            child.layout(location.left, location.top, location.right, location.bottom);
        }
    }


}
