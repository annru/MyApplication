package com.example.myapplication.fragment;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;
import com.facebook.stetho.common.LogRedirector;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * A fragment with a Google +1 button.
 */
public class MainFragment extends BaseFragment {

    private final String TAG = getClass().getSimpleName();


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
        Log.i(TAG, "onResume");
//        CrashReport.testJavaCrash();
    }




}
