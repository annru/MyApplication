package com.example.myapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 00224524 on 2016/11/3.
 * 数据适配器
 */

public class DataAdapter extends ListBaseAdapter<Entity> {
    private LayoutInflater mLayoutInflater;
    private List<ProductInfoItem> mData;
    private Context mContext;

    public DataAdapter(Context context, List<ProductInfoItem> list) {
        mLayoutInflater = LayoutInflater.from(context);
        mContext = context;
        this.mData = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(mLayoutInflater.inflate(R.layout.recycler_item, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        ProductInfoItem item = mData.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.textView.setText(item.getProductName());

    }

    private class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.content_tv);
        }
    }
}
