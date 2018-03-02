package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.LazyLoadFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/6/13.
 * description:
 */

public class MoreFragment extends LazyLoadFragment {
    private boolean isPrepared;//初始化完成标识符


    public static MoreFragment newInstances() {
        MoreFragment myCenterFragment = new MoreFragment();
        return myCenterFragment;
    }

    public MoreFragment() {
        //需要默认的构造方法
    }

    @BindView(R.id.test_tv)
    TextView testTv;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        ButterKnife.bind(this, view);
        isPrepared = true;
        lazyLoad();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testTv.setText("更多");
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible) {
            return;
        }
        //填充数据
    }
}
