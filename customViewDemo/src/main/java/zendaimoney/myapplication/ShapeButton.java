package zendaimoney.myapplication;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Gravity;

/**
 * Created by 00224524 on 2017/5/22.
 * description:
 */

public class ShapeButton extends android.support.v7.widget.AppCompatTextView {
    private float radius;
    private float stroke;
    private ColorStateList colors;

    public ShapeButton(Context context) {
        super(context);
    }

    public ShapeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShapeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }


    void init(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ShapeButton);
        radius = a.getDimension(R.styleable.ShapeButton_radius, 0);
        stroke = a.getDimension(R.styleable.ShapeButton_stroke, 0);
        colors = a.getColorStateList(R.styleable.ShapeButton_buttonColor);

        StateListDrawable selector = getSelector();
        if (Build.VERSION.SDK_INT < 16) {
            setBackgroundDrawable(selector);
        } else {
            setBackground(selector);
        }
        setGravity(Gravity.CENTER);
        a.recycle();
    }

    public StateListDrawable getSelector() {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, getDrawable
                (android.R.attr.state_pressed));
        stateListDrawable.addState(new int[]{-android.R.attr.state_enabled}, getDrawable(-android.R.attr
                .state_enabled));
        stateListDrawable.addState(new int[]{}, getDrawable(android.R.attr.state_enabled));
        return stateListDrawable;
    }

    public GradientDrawable getDrawable(int state) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(GradientDrawable.RECTANGLE);

        int color_pressed = colors.getColorForState(new int[]{android.R.attr.state_pressed}, 0);
        int color_disable = colors.getColorForState(new int[]{-android.R.attr.state_enabled}, 0);
        int color_normal = colors.getColorForState(new int[]{android.R.attr.state_enabled}, 0);

        switch (state) {
            case android.R.attr.state_pressed:
                gradientDrawable.setColor(stroke == 0 ? color_pressed : Color.parseColor("#0C000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_pressed);//描边
                break;

            case -android.R.attr.state_enabled:
                gradientDrawable.setColor(stroke == 0 ? color_disable : Color.parseColor("#06000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_disable);//描边
                break;

            case android.R.attr.state_enabled:
                gradientDrawable.setColor(stroke == 0 ? color_normal : Color.parseColor("#00000000"));//设置颜色
                gradientDrawable.setStroke(dp2px(stroke), color_normal);//描边
                break;
        }
        gradientDrawable.setCornerRadius(dp2px(radius));//设置圆角的半径
        return gradientDrawable;
    }

    /**
     * dp转px
     *
     * @param dpValue dp值
     * @return px值
     */
    public int dp2px(float dpValue) {
        final float scale = getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
