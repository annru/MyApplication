package com.example.myapplication;

import android.databinding.BaseObservable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * Created on 2017/12/26.
 *
 * @author 00224524
 */

public class People extends BaseObservable {

//    public final ObservableField<String> name = new ObservableField<>();
//    public final ObservableField<String> gender = new ObservableField<>();
//    public final ObservableInt age = new ObservableInt();


    private String name;
    private int age;

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
