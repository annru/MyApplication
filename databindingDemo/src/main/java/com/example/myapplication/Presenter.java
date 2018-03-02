package com.example.myapplication;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

/**
 * Created on 2017/12/26.
 *
 * @author 00224524
 */

public class Presenter {
    private Context context;

    public Presenter(Context context) {
        this.context = context;
    }

    public void onClickExample(View view) {
        System.out.println("点击....");
        Toast.makeText(context, "点到了", Toast.LENGTH_SHORT).show();
    }

//    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        student.setName(s.toString());
//    }
//
//    public void onClickListenerBinding(Student student) {
//        Toast.makeText(MainActivity.this, student.getName(), Toast.LENGTH_SHORT).show();
//    }
}
