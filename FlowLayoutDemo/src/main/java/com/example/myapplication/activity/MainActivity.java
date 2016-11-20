package com.example.myapplication.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.view.TagsLayout;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.tags_layout)
    TagsLayout tagsLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ViewGroup.MarginLayoutParams lp = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        String[] tags = {"今天中午吃什么呢", "好烦啊", "好烦啊", "这边吃的太少了", "不喜欢订外卖", "啊啊啊啊"};
        for (String tag : tags) {
            TextView textView = new TextView(this);
            textView.setText(tag);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundResource(R.drawable.flag_01);
            tagsLayout.addView(textView, lp);
        }
    }
}
