package com.example.myapplication.activity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.adapter.AnimalsHeadersAdapter;
import com.example.myapplication.adapter.DividerDecoration;
import com.jcodecraeer.xrecyclerview.ArrowRefreshHeader;
import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;
import com.timehop.stickyheadersrecyclerview.StickyRecyclerHeadersTouchListener;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

//import com.example.myapplication.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    XRecyclerView xRecyclerView;

    private ArrayList<String> listData;
    private int refreshTime = 0;
    private int times = 0;
//    private MyAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


//
//
//        listData = new ArrayList<>();
//        mAdapter = new MyAdapter(listData);
//        xRecyclerView.setAdapter(mAdapter);
//        xRecyclerView.refresh();


        // Set layout manager
//        int orientation = getLayoutManagerOrientation(getResources().getConfiguration().orientation);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, orientation, false);
//        xRecyclerView.setLayoutManager(layoutManager);

        // Set adapter populated with example dummy data
        final AnimalsHeadersAdapter adapter = new AnimalsHeadersAdapter();
//        adapter.add("Animals below!");
        adapter.addAll(getDummyDataSet());
        xRecyclerView.setAdapter(adapter);


//        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
//        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        xRecyclerView.setLayoutManager(layoutManager);
//        xRecyclerView.addHeaderView(getHeaderView());
//        xRecyclerView.addHeaderView(getHeaderView());
//        xRecyclerView.setRefreshHeader(new CustomRefreshHeader(this));

        int orientation = getLayoutManagerOrientation(getResources().getConfiguration().orientation);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this, orientation, false);
        xRecyclerView.setLayoutManager(layoutManager);


        // Add the sticky headers decoration
        final StickyRecyclerHeadersDecoration headersDecor = new StickyRecyclerHeadersDecoration(adapter);
        xRecyclerView.addItemDecoration(headersDecor);
        xRecyclerView.addItemDecoration(new DividerDecoration(this));

        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                headersDecor.invalidateHeaders();
            }
        });


        // 为RecyclerView添加普通Item的点击事件（点击Header无效）
        xRecyclerView.addOnItemTouchListener(new RecyclerItemClickListener(this, new
                RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, adapter.getItem(position) + " Clicked", Toast.LENGTH_SHORT)
                                .show();
                    }
                }));
        // 为RecyclerView添加Header的点击事件
        StickyRecyclerHeadersTouchListener touchListener = new StickyRecyclerHeadersTouchListener(xRecyclerView,
                headersDecor);
        touchListener.setOnHeaderClickListener(new StickyRecyclerHeadersTouchListener.OnHeaderClickListener() {
            @Override
            public void onHeaderClick(View header, int position, final long headerId) {
                Toast.makeText(MainActivity.this, "Header position: " + (position - 1) + ", id: " + headerId, Toast
                        .LENGTH_SHORT)
                        .show();
            }
        });
        xRecyclerView.addOnItemTouchListener(touchListener);


        xRecyclerView.setLoadingMoreEnabled(false);
        xRecyclerView.setRefreshProgressStyle(ProgressStyle.BallSpinFadeLoader);
        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                refreshTime++;
                times = 0;
                new Handler().postDelayed(new Runnable() {
                    public void run() {
//                        listData.clear();
//                        for (int i = 0; i < 15; i++) {
//                            listData.add("item" + i + "after " + refreshTime + " times of refresh");
//                        }
//                        mAdapter.notifyDataSetChanged();
                        xRecyclerView.refreshComplete();
                    }

                }, 1000);
            }

            @Override
            public void onLoadMore() {
                if (times < 2) {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 15; i++) {
                                listData.add("item" + (1 + listData.size()));
                            }
                            xRecyclerView.loadMoreComplete();
//                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                } else {
                    new Handler().postDelayed(new Runnable() {
                        public void run() {
                            for (int i = 0; i < 9; i++) {
                                listData.add("item" + (1 + listData.size()));
                            }
                            xRecyclerView.setNoMore(true);
//                            mAdapter.notifyDataSetChanged();
                        }
                    }, 1000);
                }
                times++;
            }
        });
    }

    private View getHeaderView() {
        ImageView view = new ImageView(this);
        view.setImageResource(R.mipmap.ic_launcher);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup
                .LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(lp);
        return view;
    }

    private String[] getDummyDataSet() {
        return getResources().getStringArray(R.array.animals);
    }

    private int getLayoutManagerOrientation(int activityOrientation) {
        if (activityOrientation == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            return LinearLayoutManager.VERTICAL;
        } else {
            return LinearLayoutManager.HORIZONTAL;
        }
    }
}
