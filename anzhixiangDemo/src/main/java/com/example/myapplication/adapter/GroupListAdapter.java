package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.myapplication.model.ProductItem;

import java.util.List;

/**
 * Created by annru on 2016/5/19.
 * Description:
 */
public class GroupListAdapter extends BaseAdapter {
    private List<ProductItem> mData = null;

    public GroupListAdapter(Context context, List<ProductItem> data) {
//        super(context, 0);
        this.mData = data;
    }


    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
