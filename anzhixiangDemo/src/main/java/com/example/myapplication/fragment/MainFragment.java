package com.example.myapplication.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

/**
 * A fragment with a Google +1 button.
 */
public class MainFragment extends BaseFragment {


    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        testCrash();
    }

    private void testCrash() {
        for (int i = 5; i <= 0; i--) {
            System.out.println("打印:"+5 / i);
        }
    }


}
