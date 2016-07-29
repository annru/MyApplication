package com.example.myapplication.activity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.orhanobut.logger.Logger;

import butterknife.Bind;
import butterknife.ButterKnife;
import cn.lankton.flowlayout.FlowLayout;

public class HomeActivity extends BaseActivity {

//    @Bind(R.id.flow_layout)
    FlowLayout flowLayout;

    private String[] texts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        texts = getResources().getStringArray(R.array.home_tags);
        crateTagView();
        Logger.d("测试调试工具");
//        Logger.d(logmsg());
    }


    private String logmsg() {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < 500000; i++) {
            buffer.append("测试log信息哈哈这是测试信的框架啊你知道啊嘛" + i);
        }
        return buffer.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    private void crateTagView() {
        int ranHeight = dip2px(this, 30);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ranHeight);
        lp.setMargins(dip2px(this, 10), 0, dip2px(this, 10), 0);
        TextView tv = new TextView(this);
        tv.setPadding(dip2px(this, 15), 0, dip2px(this, 15), 0);
        tv.setTextColor(Color.parseColor("#FF3030"));
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        int index = (int) (Math.random() * texts.length);
        tv.setText(texts[index]);
        tv.setGravity(Gravity.CENTER_VERTICAL);
        tv.setLines(1);
//        tv.setBackgroundResource(R.drawable.bg_tag);
        flowLayout.addView(tv, lp);

    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
