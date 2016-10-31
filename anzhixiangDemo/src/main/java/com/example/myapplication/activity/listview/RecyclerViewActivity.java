package com.example.myapplication.activity.listview;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseActivity;
import com.example.myapplication.utils.MyDiffCallback;
import com.example.myapplication.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RecyclerViewActivity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener {

    @Bind(R.id.swipe_layout)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<DateModel> mData;
    private OnLoadMoreDataListener mOnLoadMoreDataListener;
    private MyRecyclerViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);
        initData();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new MyRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
//        adapter.setOnItemClickListener(new OnRecyclerViewItemClickListener() {
//            @Override
//            public void onItemClick(View view, DateModel data) {
//                Log.i("RecyclerViewActivity", "点击item" + mData.indexOf(data));
//            }
//        });
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout.setOnRefreshListener(this);
//        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//
//
//            boolean isSlidingToLast = false;
//
//            @Override
//            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
//                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
//                    int lastVisibleItem = linearLayoutManager.findLastCompletelyVisibleItemPosition();
//                    int totalItemCount = linearLayoutManager.getItemCount();
//                    if ((lastVisibleItem == totalItemCount - 1) && isSlidingToLast) {
//                        Log.i("onScrollStateChanged", "加载更多");
//                        mOnLoadMoreDataListener.onLoadMoreData();
//                    }
//                }
//            }
//
//            @Override
//            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                //dy>0表示正在想下滚动，小于或等于0在表示在向上滚动或者停止滚动
//                isSlidingToLast = dy > 0;
//                Log.i("dy", dy + "");
//            }
//        });
//
//        setOnLoadMoreDataListener(new OnLoadMoreDataListener() {
//            @Override
//            public void onLoadMoreData() {
//                Log.i("onLoadMoreData", "加载更多回调");
//                loadMoreData();
//            }
//        });
//        setFooterView(recyclerView, adapter);
    }

//    private void setFooterView(RecyclerView view, MyRecyclerViewAdapter adapter) {
//        View footerView = LayoutInflater.from(this).inflate(R.layout.recycler_view_footer, view, false);
//        adapter.setFooterView(footerView);
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                List<DateModel> newData = refreshData();
                DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MyDiffCallback(mData, newData), true);
                diffResult.dispatchUpdatesTo(adapter);

                mData = newData;
            }
        }, 6000);
    }


    class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> implements View.OnClickListener {
        private OnRecyclerViewItemClickListener mListener;
        public static final int TYPE_HEADER = 0;
        public static final int TYPE_ITEM = 1;
        public static final int TYPE_FOOTER = 2;
        private View headerView;
        private View footerView;


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = null;
            switch (viewType) {
                case TYPE_ITEM:
                    view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.recycler_view_item, parent, false);
                    view.setOnClickListener(this);
                    break;
                case TYPE_FOOTER:
                    view = LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.recycler_view_footer, parent, false);
                    view.setOnClickListener(this);
                    break;
            }
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            if (getItemViewType(position) == TYPE_HEADER) return;
            holder.titleTv.setText(mData.get(position).getTitle());
            holder.itemView.setTag(mData.get(position));
        }


        @Override
        public int getItemViewType(int position) {
            if (footerView == null)
                return TYPE_ITEM;
            if (position == 0)
                return TYPE_FOOTER;
            return TYPE_ITEM;
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }

        @Override
        public void onClick(View v) {
            if (mListener != null)
                mListener.onItemClick(v, (DateModel) v.getTag());
        }

        class MyViewHolder extends RecyclerView.ViewHolder {

            @Bind(R.id.title_tv)
            TextView titleTv;

            public MyViewHolder(View view) {
                super(view);
                ButterKnife.bind(this, view);
            }
        }


        public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
            this.mListener = listener;
        }


        public void setFooterView(View view) {
            footerView = view;
            notifyItemInserted(0);
        }

    }

    /**
     * item点击事件回调接口
     */
    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, DateModel data);
    }

    /**
     * 加载更多回调接口
     */
    public interface OnLoadMoreDataListener {
        void onLoadMoreData();
    }


    public void setOnLoadMoreDataListener(OnLoadMoreDataListener listener) {
        this.mOnLoadMoreDataListener = listener;
    }


    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DateModel dm = new DateModel();
            dm.setTitle("这是测试数据---" + i);
            mData.add(dm);
        }
    }

    private void loadMoreData() {
        for (int i = 0; i < 10; i++) {
            DateModel dm = new DateModel();
            dm.setTitle(i + "这是更多数据");
            mData.add(dm);
        }
        adapter.notifyDataSetChanged();
    }

    private List<DateModel> refreshData() {
        List<DateModel> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            DateModel dm = new DateModel();
            if (i / 2 == 0)
                dm.setTitle("这是差异数据---" + i);
            else
                dm.setTitle("这是测试数据---" + i);
            list.add(dm);
        }
        return list;
    }


    public class DateModel {
        private int id;
        private String title;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
