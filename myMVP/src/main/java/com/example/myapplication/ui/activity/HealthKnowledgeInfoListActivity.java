package com.example.myapplication.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.HealthKnowledgeInfoListAdapter;
import com.example.myapplication.bean.HealthInfoDataItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 健康知识信息列表
 */
public class HealthKnowledgeInfoListActivity extends AppCompatActivity {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_knowledge_info_list);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        List<HealthInfoDataItem> data = intent.getParcelableArrayListExtra("items");
        HealthKnowledgeInfoListAdapter adapter = new HealthKnowledgeInfoListAdapter(this, data);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
    }
}
