package com.example.myapplication.fragment;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alipay.euler.andfix.patch.Patch;
import com.alipay.euler.andfix.util.FileUtil;
import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

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
//        showAgreementDialog("AndFix热修复测试，这是替换前的内容");
//        showAgreementDialog("AndFix热修复测试，这是替换后的内容，看到这个文字提示说明热修复测试成功");
    }


    private void showAgreementDialog(String desc) {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setPositiveButton("知道了", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        }).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setMessage(desc);
        alertDialog.show();
    }

}
