package com.example.myapplication;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.println("i=>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + i);
                }
            }
        });


        findViewById(R.id.test_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlert();
            }
        });
//        new MyThread().start();
    }


    private void showAlert() {
        AlertDialog dialog = new AlertDialog.Builder(this).setTitle("标题").setMessage("内容").create();
        dialog.show();
    }


    class MyThread extends Thread {

        Integer integer =Integer.valueOf(99);


        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 100; i++) {
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("i=" + i);
            }
        }
    }
}
