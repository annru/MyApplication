package com.example.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.bean.HealthCategoryItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2016/11/21.
 * 健康资讯 数据适配器
 */

public class HealthAdapter extends RecyclerView.Adapter<HealthAdapter.MyViewHolder> implements View.OnClickListener {
    private List<HealthCategoryItem> mData;
    private LayoutInflater layoutInflater;
    private OnRecyclerViewItemClickListener mListener;

    public HealthAdapter(Context context, List<HealthCategoryItem> list) {
        this.mData = list;
        layoutInflater = LayoutInflater.from(context);
    }

    public void setList(List<HealthCategoryItem> list) {
        this.mData = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.recycler_view_item, parent, false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.nameTv.setText(mData.get(position).getName());
        holder.itemView.setTag(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onClick(View view) {
        if (mListener != null)
            mListener.onItemClick(view, (HealthCategoryItem) view.getTag());
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mListener = listener;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.name_tv)
        TextView nameTv;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, HealthCategoryItem item);
    }
}
