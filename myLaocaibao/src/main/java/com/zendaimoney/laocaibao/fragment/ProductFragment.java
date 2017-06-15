package com.zendaimoney.laocaibao.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zendaimoney.laocaibao.R;
import com.zendaimoney.laocaibao.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/6/13.
 * description:
 */

public class ProductFragment extends BaseFragment {

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
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        testTv.setText("这是热修复之后的的新包NEW");
    }
}
