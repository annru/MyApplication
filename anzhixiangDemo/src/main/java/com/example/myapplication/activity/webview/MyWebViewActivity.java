package com.example.myapplication.activity.webview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.R;
import com.tencent.smtt.sdk.WebSettings;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyWebViewActivity extends AppCompatActivity {
    @Bind(R.id.forum_context)
    com.tencent.smtt.sdk.WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);//支持js
//        String url = "http://cnblogs.sinaapp.com/demo/audio.html";
        String url = "http://172.16.72.47:9080/lottery-web/commonAction?resultPage=front/childrenDay&typeNo=1017&sessionToken=blhUN0UvZ0tBbHFYKzh0WkJldXVMQ3lqbi9iU1JodmU";
//        String url = "http://www.sunnyzhen.com/demo/audio/index.html";
        webView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }
}
