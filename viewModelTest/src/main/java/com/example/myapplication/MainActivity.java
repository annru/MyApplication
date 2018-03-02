package com.example.myapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * ViewModel架构Demo测试
 *
 * @author 00224524
 */
public class MainActivity extends AppCompatActivity {

    private ListModel listModel;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        listModel = ViewModelProviders.of(this).get(ListModel.class);
        recyclerView.setAdapter(new MyAdapter(this, listModel.getData()));
        listModel.getData().observeForever();
    }
}
