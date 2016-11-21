package com.example.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HealthAdapter;
import com.example.myapplication.bean.HealthCategoryBean;
import com.example.myapplication.bean.HealthCategoryItem;
import com.example.myapplication.bean.HealthInfoBean;
import com.example.myapplication.bean.HealthInfoData;
import com.example.myapplication.bean.HealthInfoDataItem;
import com.example.myapplication.bean.Repo;
import com.example.myapplication.bean.ResponseEntity;
import com.example.myapplication.http.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Subscriber;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener, HealthAdapter
        .OnRecyclerViewItemClickListener {
    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;
    private HealthAdapter mAdapter;
    private ProgressDialog mProgressDialog;

    private static final String KEY = "51908d58976e4131f3869e98c1877405";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        toolbar.setTitle("健康知识分组");
        swipeRefreshLayout.setOnRefreshListener(this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        swipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(true);
                requestHealthCategoryList(KEY);
            }
        });
    }

    @Override
    public void onItemClick(View view, HealthCategoryItem item) {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.show();
        mProgressDialog.setMessage("正在加载数据...");
        requestHealthInfoList(KEY, "1", "10", String.valueOf(item.getId()));
    }

    private void requestData() {
        Subscriber<String> subscriber = new Subscriber<String>() {
            @Override
            public void onCompleted() {
                Log.i("top250", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i("top250", e.getLocalizedMessage() + "");
            }

            @Override
            public void onNext(String s) {
                Log.i("top250", s);
            }
        };
        RetrofitClient.getInstance().getTopMovie(subscriber, 0, 10);
    }

    private void requestBook() {
        Subscriber<ResponseEntity> subscriber = new Subscriber<ResponseEntity>() {
            @Override
            public void onCompleted() {
                Log.i("requestBook", "onCompleted");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ResponseEntity responseEntity) {
                System.out.println(responseEntity.getError_code() + "<---code");
            }
        };
        RetrofitClient.getInstance().getBook(subscriber, "cc5b749a5c43aec496248477ecd54bb5", 1, 2);
    }

    private void requestWeather() {
//        Subscriber<Repo> subscriber = new Subscriber<Repo>() {
//            @Override
//            public void onCompleted() {
//
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(Repo repo) {
//                System.out.println(repo.getWeatherinfo().getCity());
//            }
//        };
        Subscriber<Repo> subscriber = new Subscriber<Repo>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Repo repo) {

            }
        };
        RetrofitClient.getInstance().getWeather(subscriber);
    }

    /**
     * 获取健康知识分类列表
     *
     * @param key
     */
    private void requestHealthCategoryList(String key) {
        Subscriber<HealthCategoryBean> subscriber = new Subscriber<HealthCategoryBean>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthCategoryBean healthInfo) {
                List<HealthCategoryItem> items = healthInfo.getResult();
                if (mAdapter == null) {
                    mAdapter = new HealthAdapter(MainActivity.this, items);
                    mAdapter.setOnItemClickListener(MainActivity.this);
                    recyclerView.setAdapter(mAdapter);
                } else {
                    mAdapter.setList(items);
                    mAdapter.notifyDataSetChanged();
                }
            }
        };
        RetrofitClient.getInstance().getHealthKnowledgeCategoryList(subscriber, key);
    }

    /**
     * 获取健康知识信息列表
     *
     * @param key
     */
    private void requestHealthInfoList(String key, String page, String limit, String id) {
        Subscriber<HealthInfoBean> subscriber = new Subscriber<HealthInfoBean>() {
            @Override
            public void onCompleted() {
                System.out.println("完成");
                if (mProgressDialog != null && mProgressDialog.isShowing())
                    mProgressDialog.dismiss();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(HealthInfoBean healthInfo) {
                HealthInfoData healthInfoData = healthInfo.getResult();
                List<HealthInfoDataItem> items = healthInfoData.getData();
                Intent intent = new Intent(MainActivity.this, HealthKnowledgeInfoListActivity.class);
                intent.putParcelableArrayListExtra("items", (ArrayList<? extends Parcelable>) items);
                startActivity(intent);
            }
        };
        RetrofitClient.getInstance().getHealthKnowledgeInfoList(subscriber, key, page, limit, id);
    }

    @Override
    public void onRefresh() {
        requestHealthCategoryList(KEY);
    }
}
