package com.example.myapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 2017/11/27.
 *
 * @author 00224524
 */

public class ListModel extends AndroidViewModel {
    private final LiveData<List<Person>> data;

    public ListModel(Application application) {
        super(application);
        data = getData();
    }

    LiveData<List<Person>> getItemAndPersonList() {
        return data;
    }


    LiveData<List<Person>> getData() {
        LiveData<List<Person>> list = new LiveData<ArrayList>();
        for (int i = 0; i < 30; i++) {
            Person p = new Person();
            p.setName("测试----" + i);
            list.add(p);
        }
        return list;
    }
}
