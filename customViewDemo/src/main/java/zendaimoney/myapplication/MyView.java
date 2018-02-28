package zendaimoney.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by 00224524 on 2017/5/22.
 * description:
 */

public class MyView extends View {
    private Paint mPaint;

    public MyView(Context context) {
        super(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.myView);
        int textColor = a.getColor(R.styleable.myView_myTextColor, 003344);
        float textSize = a.getDimension(R.styleable.myView_myTextSize, 33);
        mPaint.setTextSize(textSize);
        mPaint.setColor(textColor);
        a.recycle();

        int attributeCount = attrs.getAttributeCount();
        Log.i("test123", "当前属性个数为：" + attributeCount);


        for (int i = 0; i < attributeCount; i++) {
            String attributeName = attrs.getAttributeName(i);
            Log.i("test123", String.format("当前属性索引为：%d,索引名为：%s", i, attributeName));
            if (attributeName.equals("style")) {
                String attributeValue = attrs.getAttributeValue(i);
                Log.i("test123", "当前属性值为：：" + attributeValue);


            }

        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("自定义View测试", 10, 50, mPaint);
    }
}
