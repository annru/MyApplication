package com.example.myapplication.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BannerActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Bind(R.id.ll_dot_group)
    LinearLayout ll;

    private List<ImageView> imagelist;
    private int preEnablePositon = 0; // 前一个被选中的点的索引位置 默认情况下为0
    private boolean isStop = false;  //是否停止子线程  不会停止
    private String[] urlArray = new String[]{"https://raw.githubusercontent.com/facebook/fresco/gh-pages/static/fresco-logo.png", "http://img5.imgtn.bdimg.com/it/u=1478257864,2882073929&fm=21&gp=0.jpg", "http://pic38.nipic.com/20140215/12359647_224250202132_2.jpg", "http://b.zol-img.com.cn/desk/bizhi/image/7/1920x1200/1457407066556.jpg"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        ButterKnife.bind(this);
        init();
        timer.start();
        // 开启线程无限自动移动
//        Thread myThread = new Thread(new Runnable() {
//
//            @Override
//            public void run() {
//                while (!isStop) {
//                    //每个两秒钟发一条消息到主线程，更新viewpager界面
//                    SystemClock.sleep(5000);
//                    runOnUiThread(new Runnable() {
//                        public void run() {
//                            // 此方法在主线程中执行
//                            int nextIndex = viewPager.getCurrentItem() + 1;
//                            viewPager.setCurrentItem(nextIndex);
//                        }
//                    });
//                }
//            }
//        });
//        myThread.start(); // 用来更细致的划分  比如页面失去焦点时候停止子线程恢复焦点时再开启
    }

    @Override
    protected void onDestroy() {
        isStop = true;
        super.onDestroy();
    }

    private void init() {


        imagelist = new ArrayList<>();
//        int[] imageIDs = {R.mipmap.a, R.mipmap.b, R.mipmap.c,
//                R.mipmap.d, R.mipmap.e,};

        ImageView iv;
        View view;
        LayoutParams params;
        for (String url : urlArray) {
            iv = new ImageView(this);
            Glide.with(this).load(url).placeholder(R.mipmap.ic_fill_bg).into(iv);
//            iv.setBackgroundResource(id);
            imagelist.add(iv);

            // 每循环一次添加一个点到现形布局中
            view = new View(this);
            view.setBackgroundResource(R.drawable.point_background);
            params = new LayoutParams(5, 5);
            params.leftMargin = 5;
            view.setEnabled(false);
            view.setLayoutParams(params);
            ll.addView(view); // 向线性布局中添加“点”
        }

        viewPager.setAdapter(new MyAdapter());
        viewPager.addOnPageChangeListener(this);

        // 初始化图片描述和哪一个点被选中
//        tv.setText(imagemiaoshu[0]);
        ll.getChildAt(0).setEnabled(true);

        // 初始化viewpager的默认position.MAX_value的一半
        int index = (Integer.MAX_VALUE / 2)
                - ((Integer.MAX_VALUE / 2) % imagelist.size());
        viewPager.setCurrentItem(index); // 设置当前viewpager选中的pager页
        // ，会触发OnPageChangeListener中的onPageSelected方法
        viewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.i("触摸事件", "event");
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        isStop = true;
                        if (timer != null)
                            timer.cancel();
                        break;
                    case MotionEvent.ACTION_UP:
                        isStop = false;
                        if (timer != null)
                            timer.start();
                        break;
                }
                return false;
            }
        });

    }

    class MyAdapter extends PagerAdapter {

        /**
         * 销毁对象
         *
         * @param position 将要被销毁对象的索引位置
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imagelist.get(position % imagelist.size()));
        }

        /**
         * 初始化一个对象
         *
         * @param position 将要被创建的对象的索引位置
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 先把对象添加到viewpager中，再返回当前对象
            container.addView(imagelist.get(position % imagelist.size()));
            return imagelist.get(position % imagelist.size());
        }

        @Override
        public int getCount() {
            return Integer.MAX_VALUE;
        }

        /**
         * 复用对象 true 复用对象 false 用的是object
         */
        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

    }

    @Override
    public void onPageScrollStateChanged(int arg0) {

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {

    }

    @Override
    public void onPageSelected(int position) {
        // 取余后的索引
        int newPositon = position % imagelist.size();

        // 根据索引设置图片的描述
//        tv.setText(imagemiaoshu[newPositon]);

        // 把上一个点设置为被选中
        ll.getChildAt(preEnablePositon).setEnabled(false);

        // 根据索引设置那个点被选中
        ll.getChildAt(newPositon).setEnabled(true);

        preEnablePositon = newPositon;

    }

    private CountDownTimer timer = new CountDownTimer(5000, 1000) {

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            myHandler.sendEmptyMessageAtTime(0, 0);
        }
    };


    private Handler myHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int nextIndex = viewPager.getCurrentItem() + 1;
            viewPager.setCurrentItem(nextIndex);
            timer.start();
        }
    };

}
