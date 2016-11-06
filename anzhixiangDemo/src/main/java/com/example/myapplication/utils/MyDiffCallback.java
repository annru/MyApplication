package com.example.myapplication.utils;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;

import com.example.myapplication.activity.listview.RecyclerViewActivity;

import java.util.List;

/**
 * Created by 00224524 on 2016/10/26.
 * 数据差异拆分工具类
 */

public class MyDiffCallback extends DiffUtil.Callback {
    private final static String KEY_TITLE = "KEY_TITLE";
    private List<RecyclerViewActivity.DateModel> mOldList;
    private List<RecyclerViewActivity.DateModel> mNewList;

    public MyDiffCallback(List<RecyclerViewActivity.DateModel> oldList, List<RecyclerViewActivity.DateModel> newList) {
        this.mOldList = oldList;
        this.mNewList = newList;
    }

    @Override
    public int getOldListSize() {
        return mOldList.size();
    }

    @Override
    public int getNewListSize() {
        return mNewList.size();
    }

    @Override
    public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).getId() == mNewList.get(newItemPosition).getId();
    }

    @Override
    public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
        return mOldList.get(oldItemPosition).equals(mNewList.get(newItemPosition));
    }

    @Nullable
    @Override
    public Object getChangePayload(int oldItemPosition, int newItemPosition) {
        RecyclerViewActivity.DateModel oldItem = mOldList.get(oldItemPosition);
        RecyclerViewActivity.DateModel newItem = mNewList.get(newItemPosition);
        Bundle diffBundle = new Bundle();
        if (!newItem.getTitle().equals(oldItem.getTitle())) {
            diffBundle.putString(KEY_TITLE, newItem.getTitle());
        }
        if(diffBundle.size() == 0)
            return null;
        return diffBundle;
    }
}
