package com.example.myapplication;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/1/22.
 * description:
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> data;

    MyAdapter(List<String> list) {
        this.data = list;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textView.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    void setData(List<String> list) {
        this.data = list;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.text)
        TextView textView;

        MyViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
