package com.example.myapplication.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activity.LoginActivity;
import com.example.myapplication.activity.mvp.RetrofitActivity;
import com.example.myapplication.activity.mvp.UserActivity;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.mvvm.MvvmDemoActivity;

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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @OnClick({R.id.retrofit_btn, R.id.mvp_btn, R.id.mvp_btn2, R.id.mvvm_btn})
    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.retrofit_btn:
                intent = new Intent(getActivity(), RetrofitActivity.class);
                startActivity(intent);
                break;
            case R.id.mvp_btn:
                intent = new Intent(getActivity(), UserActivity.class);
                startActivity(intent);
                break;
            case R.id.mvvm_btn:
                intent = new Intent(getActivity(), MvvmDemoActivity.class);
                startActivity(intent);
                break;
        }

    }
}
