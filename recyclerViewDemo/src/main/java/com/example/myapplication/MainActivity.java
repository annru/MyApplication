package com.example.myapplication;

import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    private List<String> mData;
    private List<String> list = new ArrayList<>();
    private GroupTestAdapter groupTestAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        mData = getData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);

        MyItemDecoration itemDecoration = new MyItemDecoration(this, 1);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setLayoutManager(manager);
//        recyclerView.setAdapter(new MyAdapter(this, mData));

        initData();
    }


    private List<String> getData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add("测试数据" + i);
        }
        return mData;
    }

    private void initData() {
        for (int i = 0; i < 30; i++) {
            list.add(i + 1 + "");
        }

        groupTestAdapter = new GroupTestAdapter(this, list);
        recyclerView.setAdapter(groupTestAdapter);

        //开始使用GroupItemDecoration
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View view = layoutInflater.inflate(R.layout.activity_main_item, null);
        GroupItemDecoration groupItemDecoration = new GroupItemDecoration(this, view, new GroupItemDecoration.DecorationCallback() {
            @Override
            public void setGroup(List<GroupItem> groupList) {
                //设置分组，例如：
                GroupItem groupItem;
                int startPosition = 0;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).equals("10")) {
                        groupItem = new GroupItem(0);
                        groupItem.setData("name", "1-10");
                        groupList.add(groupItem);
                        startPosition = i + 1;
                    } else if (list.get(i).equals("20")) {
                        groupItem = new GroupItem(startPosition);
                        groupItem.setData("name", "11-20");
                        groupItem.setData("imgId", R.drawable.ic_launcher_background);
                        groupList.add(groupItem);
                        startPosition = i + 1;
                    } else if (list.get(i).equals("30")) {
                        groupItem = new GroupItem(startPosition);
                        groupItem.setData("name", "21-30");
                        groupList.add(groupItem);
                    }
                }
            }

            @Override
            public void buildGroupView(View groupView, GroupItem groupItem) {
                //构建GroupView，通过view.findViewById找到内部控件，例如
                TextView textName = (TextView) groupView.findViewById(R.id.text_name);

                Rect mRect = (Rect) groupItem.getData(GroupItemDecoration.KEY_RECT);
                textName.setText(groupItem.getData("name").toString());

                ImageView imageView = (ImageView) groupView.findViewById(R.id.img);
                if (groupItem.getData("name").equals("11-20")) {
                    imageView.setImageDrawable(getResources().getDrawable((int) groupItem.getData("imgId")));
                } else {
                    imageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
                }
            }
        });
        recyclerView.addItemDecoration(groupItemDecoration);

        recyclerView.addOnItemTouchListener(new ItemClickListener(recyclerView, new ItemClickListener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
//                Log.e("test","is:"+position);
                Toast.makeText(MainActivity.this, "点击了item:"+(position+1), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
//                Log.e("test","il:"+position);
                Toast.makeText(MainActivity.this, "长按了item:"+(position+1), Toast.LENGTH_SHORT).show();
            }
        }));

        recyclerView.addOnItemTouchListener(new GroupItemClickListener(groupItemDecoration, new GroupItemClickListener.OnGroupItemClickListener() {
            @Override
            public void onGroupItemClick(GroupItem groupItem) {
                Toast.makeText(MainActivity.this, "点击了Group:" + groupItem.getData("name"), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onGroupItemLongClick(GroupItem groupItem) {
                Toast.makeText(MainActivity.this, "长按了Group:" + groupItem.getData("name"), Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
