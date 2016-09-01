package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

        jietuLl.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver
                .OnGlobalLayoutListener() {


            @Override
            public void onGlobalLayout() {
                if (!isMeasured) {
                    isMeasured = true;
                    test();
                }
            }
        });


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
    }
}
