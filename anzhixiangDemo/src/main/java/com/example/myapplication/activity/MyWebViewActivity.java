package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.example.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyWebViewActivity extends AppCompatActivity {
    @Bind(R.id.webview)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_view);
        ButterKnife.bind(this);
        WebSettings setting = webView.getSettings();
        setting.setAllowFileAccess(true);
        setting.setAllowFileAccessFromFileURLs(true);
        setting.setJavaScriptEnabled(true);//支持js
        String url = "http://cnblogs.sinaapp.com/demo/audio.html";
//        String url = "http://www.sunnyzhen.com/demo/audio/index.html";
        webView.loadUrl(url);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.destroy();
    }
}
