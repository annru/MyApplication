package com.example.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgView=(ImageView)findViewById(R.id.net_img);

        //网络图片地址
        String imgUrl = "http://pic.mmfile.net/2015/11/15t01.jpg";

        //for test
        AsyncImageLoader loader = new AsyncImageLoader(getApplicationContext());

        //将图片缓存至外部文件中
        loader.setCache2File(true); //false
        //设置外部缓存文件夹
        loader.setCachedDir("sdcards/pic/");

        //下载图片，第二个参数是否缓存至内存中
        loader.downloadImage(imgUrl, true/*false*/, new AsyncImageLoader.ImageCallback() {
            @Override
            public void onImageLoaded(Bitmap bitmap, String imageUrl) {
                if(bitmap != null){
                    imgView.setImageBitmap(bitmap);
                }else{
                    //下载失败，设置默认图片
                }
            }
        });
    }



}
