package com.example.myapplication.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by 00224524 on 2016/6/23.
 * 描述：对话框
 */
public class DialogFragment extends BaseFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dialog, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


    @OnClick(R.id.dialog_btn)
    public void setOnClickEvent() {
        showDialog();
    }

    private void showDialog() {
        AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).create();
        alertDialog.setTitle("标题");
        alertDialog.setMessage("正文:这是测试AlertDialog对话框的使用，导入android.support.v7.app.AlertDialog包可以在5.0以下系统使用material design风格的对话框，而不要使用android.app.AlertDialog包");
        alertDialog.show();
    }
}
