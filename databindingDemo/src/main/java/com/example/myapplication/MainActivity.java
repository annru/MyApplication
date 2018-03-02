package com.example.myapplication;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.example.myapplication.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.rv.setLayoutManager(new LinearLayoutManager(this));
        PeopleAdapter adapter = new PeopleAdapter(this);
        binding.rv.setAdapter(adapter);

        adapter.getItems().add(new People("安志祥", 12));
        adapter.getItems().add(new People("安志祥", 18));
        adapter.getItems().add(new People("安志祥", 23));
    }


}
