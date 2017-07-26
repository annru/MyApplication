package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.BaseFragment;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/7/24.
 * description:
 */

public class ProductTabTwoFragment extends LazyLoadFragment implements OnRefreshListener, OnLoadMoreListener {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<String> mData;

    public static ProductTabTwoFragment newInstance() {
        return new ProductTabTwoFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_tab_two, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getData();
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new MyRecyclerViewAdapter());

    }

    @Override
    protected void lazyLoad() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    private void sendRequest() {

    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "--------------------------");
        }
        return list;
    }

    private class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity())
                    .inflate(R.layout.fragment_product_tab_one_item, parent, false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.testTv.setText(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


    class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.test_tv)
        TextView testTv;


        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
