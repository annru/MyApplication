package com.example.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;

/**
 * Created by annru on 2016/11/6.
 * Description:
 */

public class TagsLayout extends ViewGroup {

    private int childHorizontalSpace;
    private int childVerticalSpace;


    public TagsLayout(Context context) {
        super(context);
    }

    public TagsLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray attrArray = context.obtainStyledAttributes(attrs, R.styleable.TagsLayout);
        if (attrArray != null) {
            childHorizontalSpace = attrArray.getDimensionPixelSize(R.styleable
                    .TagsLayout_tagHorizontalSpace, 0);
            childVerticalSpace = attrArray.getDimensionPixelSize(R.styleable
                    .TagsLayout_tagVerticalSpace, 0);
            attrArray.recycle();
        }
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //http://www.cnblogs.com/whoislcj/p/5720202.html
    }

    @Override
    protected void onLayout(boolean b, int i, int i1, int i2, int i3) {

    }
}
