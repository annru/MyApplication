package com.example.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activity.guide.GuideActivity;
import com.example.myapplication.activity.mvp.RetrofitActivity;
import com.example.myapplication.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 框架  架构等
 */
public class ArchitectureFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_architecture, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @OnClick(R.id.retrofit_btn)
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getActivity(), RetrofitActivity.class);
        startActivity(intent);
    }
}