package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CalendarView;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyCalendarActivity extends AppCompatActivity {
    @Bind(R.id.my_calendar_view)
    CalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar);
        ButterKnife.bind(this);
        Long nowTime = calendarView.getDate();
        SimpleDateFormat f = new SimpleDateFormat("yyyy年MM月dd日hh:mm:ss");
        String time = f.format(nowTime);
        System.out.println("-------------" + time);
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView arg0, int arg1,
                                            int arg2, int arg3) {
                arg2 = arg2 + 1;
                System.out.println("-------------" + arg1 + "-" + arg2 + "-"
                        + arg3);
            }
        });
    }
}
