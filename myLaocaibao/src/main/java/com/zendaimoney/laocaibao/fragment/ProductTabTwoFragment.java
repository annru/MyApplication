package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/7/24.
 * description:
 */

public class ProductTabTwoFragment extends LazyLoadFragment implements OnRefreshListener, OnLoadMoreListener {


    @BindView(R.id.sanbiao_tv)
    TextView sanbiaoTv;


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
        sanbiaoTv.setText("散标");
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

}
