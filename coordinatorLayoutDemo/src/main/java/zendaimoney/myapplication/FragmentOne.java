package zendaimoney.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by 00224524 on 2017/7/11.
 * description:
 */

public class FragmentOne extends Fragment {

    @BindView(R.id.coordinator_layout)
    CoordinatorLayout parent;

    @BindView(R.id.list_view)
    ListView listView;

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<String> mData;

    public static FragmentOne newInstance(int index) {
        FragmentOne f = new FragmentOne();
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mData = getData();
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        listView.setAdapter(new MyListViewAdapter());
//        recyclerView.setAdapter(new MyRecyclerViewAdapter());
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            listView.setNestedScrollingEnabled(true);
        }
    }

    private List<String> getData() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            list.add(i + "");
        }
        return list;
    }

    public class MyListViewAdapter extends BaseAdapter {


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
            MyViewHolder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one_item, parent, false);
                holder = new MyViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (MyViewHolder) convertView.getTag();
            }
            holder.contentTv.setText(mData.get(position));
            return convertView;
        }
    }


    public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {
        @Override
        public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_one_item, parent, false);
            return new MyRecyclerViewHolder(view);
        }

        @Override
        public void onBindViewHolder(MyRecyclerViewHolder holder, final int position) {
            holder.contentTv.setText(mData.get(position));
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar snackbar = Snackbar.make(parent, mData.get(position) + "", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return mData.size();
        }
    }


    class MyViewHolder {

        @BindView(R.id.content_tv)
        TextView contentTv;

        MyViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    class MyRecyclerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.content_tv)
        TextView contentTv;

        MyRecyclerViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }

    }
}
