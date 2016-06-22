package com.example.myapplication.activity.guide;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

import com.example.myapplication.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuideVideoActivity extends AppCompatActivity {

    @Bind(R.id.video_view)
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide_video);
        ButterKnife.bind(this);
        videoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.test2));
        videoView.start();
    }
}
