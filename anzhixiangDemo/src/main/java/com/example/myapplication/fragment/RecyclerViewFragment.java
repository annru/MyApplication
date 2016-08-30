package com.example.myapplication.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.activity.listview.RecyclerView2Activity;
import com.example.myapplication.activity.listview.RecyclerViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by annru on 2016/4/6.
 * Description:理财专区
 */
public class RecyclerViewFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ButterKnife.bind(this, getView());
    }

    @OnClick({R.id.recycler_view_test_one_btn, R.id.recycler_view_test_two_btn})
    public void setOnClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.recycler_view_test_one_btn:
                intent = new Intent(getActivity(), RecyclerViewActivity.class);
                startActivity(intent);
                break;
            case R.id.recycler_view_test_two_btn:
                intent = new Intent(getActivity(), RecyclerView2Activity.class);
                startActivity(intent);
                break;
        }
    }
}
