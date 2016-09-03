package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.tv)
    TextView tv;

    @Bind(R.id.guide_img)
    ImageView imageView;

    @Bind(R.id.jietu_ll)
    LinearLayout jietuLl;

    @Bind(R.id.root_rl)
    RelativeLayout rootRl;

    boolean isMeasured = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

//        jietuLl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
//                .OnGlobalLayoutListener() {
//
//
//            @Override
//            public void onGlobalLayout() {
//                if (!isMeasured) {
//                    isMeasured = true;
//                    test();
//                }
//            }
//        });


    }

    @OnClick({R.id.close_btn})
    public void onClick(View view) {
        rootRl.setVisibility(View.GONE);
    }

    public void test() {
        jietuLl.setDrawingCacheEnabled(true);
        jietuLl.buildDrawingCache();
        Bitmap bitmap = Bitmap.createBitmap(jietuLl.getDrawingCache());
        //创建一个DrawingCache的拷贝，因为DrawingCache得到的位图在禁用后会被回收
        System.out.println(bitmap);
//        Drawable drawable = new BitmapDrawable(getResources(), bitmap);
        imageView.setImageBitmap(bitmap);
        jietuLl.setDrawingCacheEnabled(false);


        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(jietuLl.getWidth(), jietuLl
                .getHeight());
//        System.out.println(tv.getWidth() + "," + tv.getHeight());
//        System.out.println(tv.getLeft());
//        System.out.println(tv.getTop());
//        System.out.println(tv.getRight());
//        System.out.println(tv.getBottom());
        lp.setMargins(jietuLl.getLeft(), jietuLl.getTop(), jietuLl.getRight(), jietuLl.getBottom());
        imageView.setLayoutParams(lp);
//        System.out.println(imageView.getWidth() + "," + imageView.getHeight());


        TextView tv = new TextView(this);


    }

    //    @TargetApi(17)
    public void create() {
        View view = new View(this);
        if (Build.VERSION.SDK_INT >= 17)
            view.setId(View.generateViewId());
        else
            view.setId(generateViewId());

        TypedValue.applyDimension(12, 14, new DisplayMetrics());
    }

    private static final AtomicInteger sNextGeneratedId = new AtomicInteger(1);

    public static int generateViewId() {
        for (; ; ) {
            final int result = sNextGeneratedId.get();
            // aapt-generated IDs have the high byte nonzero; clamp to the range under that.
            int newValue = result + 1;
            if (newValue > 0x00FFFFFF) newValue = 1; // Roll over to 1, not 0.
            if (sNextGeneratedId.compareAndSet(result, newValue)) {
                return result;
            }
        }
    }

    private static void testA() {
        int n = 0;
        for (; ; ) {
            n++;
            System.out.println(n);
            if (n == 15)
                return;
        }
    }

}
