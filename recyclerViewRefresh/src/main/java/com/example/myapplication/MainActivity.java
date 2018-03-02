package com.example.myapplication;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    XRecyclerView xRecyclerView;

    private MyAdapter myAdapter;
    private int n = 0;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(layoutManager);
        mData = getInitData();
        myAdapter = new MyAdapter(mData);
        xRecyclerView.setAdapter(myAdapter);
        xRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.BallScale);
        xRecyclerView.setLoadingMoreEnabled(true);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        n = 0;
                        mData = getInitData();
                        myAdapter.setData(mData);
                        myAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }
                }, 3000);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        myAdapter.setData(loadMoreData());
                        myAdapter.notifyDataSetChanged();
                        n++;
                        xRecyclerView.loadMoreComplete();
                        if (mData.size() > 50)
                            xRecyclerView.setNoMore(true);
                    }
                }, 3000);
            }
        });
    }

    private List<String> getInitData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("这是初始化数据" + i);
        }
        return list;
    }

    private List<String> loadMoreData() {
        for (int i = 0; i < 10; i++) {
            mData.add("这是加载更多数据" + (i + n * 10));
        }
        Log.i("数量", mData.size() + "");
        return mData;
    }
}
