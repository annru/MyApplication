package zendaimoney.myapplication;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText("自定义View测试", 10, 50, mPaint);
    }
}
