package com.example.myapplication;

import android.animation.LayoutTransition;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button addBtn;
    private ListView container;
    private View header;
    private List<String> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBtn = (Button) findViewById(R.id.add_btn);

        container = findViewById(R.id.container);
//        LayoutTransition mTransition = new LayoutTransition();
//        container.setLayoutTransition(mTransition);
        init();
        MyAdapter adapter = new MyAdapter();
        container.setAdapter(adapter);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                header = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_header, container, false);
//                Button button = new Button(MainActivity.this);
//                button.setText("添加按钮默认动画");
                container.addHeaderView(header);
            }
        });
    }

    private void init() {
        mData = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            mData.add("测试数据");
        }
    }

    public class MyAdapter extends BaseAdapter {
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
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.view_header, parent, false);
                holder = new MyViewHolder(convertView);
                convertView.setTag(holder);
            } else {
                holder = (MyViewHolder) convertView.getTag();
            }
            holder.textView.setText(mData.get(position));
            return convertView;
        }
    }


    public class MyViewHolder {
        private TextView textView;

        public MyViewHolder(View view) {
            textView = view.findViewById(R.id.tv);
        }
    }
}
