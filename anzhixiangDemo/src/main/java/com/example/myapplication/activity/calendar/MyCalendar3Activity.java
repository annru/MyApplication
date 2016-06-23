package com.example.myapplication.activity.calendar;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.view.MyMonthDateView;

import java.util.ArrayList;
import java.util.List;

public class MyCalendar3Activity extends AppCompatActivity {
//    @Bind(R.id.calendarView)
//    MonthDateView calendarView;

    private ImageView iv_left;
    private ImageView iv_right;
    private TextView tv_date;
    private TextView tv_week;
    private TextView tv_today;
    private MyMonthDateView monthDateView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_my_calendar3);
//        ButterKnife.bind(this);
        //视图一
        /**
         List<DayAndPrice> list = new ArrayList<DayAndPrice>();
         DayAndPrice dAndPrice = new DayAndPrice("¥3900起", 2016, 2, 20);
         DayAndPrice dAndPrice1 = new DayAndPrice("¥3900起", 2016, 2, 10);
         DayAndPrice dAndPrice2 = new DayAndPrice("¥3900起", 2016, 2, 18);
         DayAndPrice dAndPrice3 = new DayAndPrice("¥3900起", 2016, 2, 25);
         DayAndPrice dAndPrice4 = new DayAndPrice("¥3900起", 2016, 3, 5);
         DayAndPrice dAndPrice5 = new DayAndPrice("¥3900起", 2016, 3, 11);
         DayAndPrice dAndPrice6 = new DayAndPrice("¥3900起", 2016, 3, 15);
         DayAndPrice dAndPrice7 = new DayAndPrice("¥3900起", 2016, 4, 25);
         DayAndPrice dAndPrice8 = new DayAndPrice("¥3900起", 2016, 4, 1);
         DayAndPrice dAndPrice9 = new DayAndPrice("¥3900起", 2016, 4, 13);
         DayAndPrice dAndPrice10 = new DayAndPrice("¥3900起", 2016, 5, 16);
         DayAndPrice dAndPrice11 = new DayAndPrice("¥3900起", 2016, 5, 2);
         DayAndPrice dAndPrice12 = new DayAndPrice("¥3900起", 2016, 5, 4);
         DayAndPrice dAndPrice13 = new DayAndPrice("¥3900起", 2016, 5, 25);
         list.add(dAndPrice);
         list.add(dAndPrice1);
         list.add(dAndPrice2);
         list.add(dAndPrice3);
         list.add(dAndPrice4);
         list.add(dAndPrice5);
         list.add(dAndPrice6);
         list.add(dAndPrice7);
         list.add(dAndPrice8);
         list.add(dAndPrice9);
         list.add(dAndPrice10);
         list.add(dAndPrice11);
         list.add(dAndPrice12);
         list.add(dAndPrice13);
         List<WorkOrRelax> listDate = new ArrayList<WorkOrRelax>();
         WorkOrRelax workOrRelax = new WorkOrRelax(2016, 2, 6, 0);
         WorkOrRelax workOrRelax1 = new WorkOrRelax(2016, 2, 7, 1);
         WorkOrRelax workOrRelax2 = new WorkOrRelax(2016, 2, 8, 1);
         WorkOrRelax workOrRelax3 = new WorkOrRelax(2016, 2, 9, 1);
         WorkOrRelax workOrRelax4 = new WorkOrRelax(2016, 2, 10, 1);
         WorkOrRelax workOrRelax5 = new WorkOrRelax(2016, 2, 11, 1);
         WorkOrRelax workOrRelax6 = new WorkOrRelax(2016, 2, 12, 1);
         WorkOrRelax workOrRelax7 = new WorkOrRelax(2016, 2, 13, 1);
         WorkOrRelax workOrRelax8 = new WorkOrRelax(2016, 2, 14, 1);
         listDate.add(workOrRelax);
         listDate.add(workOrRelax1);
         listDate.add(workOrRelax2);
         listDate.add(workOrRelax3);
         listDate.add(workOrRelax4);
         listDate.add(workOrRelax5);
         listDate.add(workOrRelax6);
         listDate.add(workOrRelax7);
         listDate.add(workOrRelax8);
         setContentView(R.layout.activity_my_calendar3);
         final CalendarView calendarView = (CalendarView) findViewById(R.id.calendarView);
         calendarView.setListDayAndPrice(list);
         //        calendarView.setListWorkOrRelax(listDate);
         calendarView.setDateViewClick(new CalendarView.DateViewClick() {

        @Override public void dateClick() {
        Toast.makeText(getApplication(), "点击了：" + calendarView.getSelectMonth(), Toast.LENGTH_SHORT).show();
        }
        });

         **/

        //视图二
        List<Integer> list = new ArrayList<Integer>();
        list.add(10);
        list.add(12);
        list.add(15);
        list.add(16);
        setContentView(R.layout.activity_date_my);
        iv_left = (ImageView) findViewById(R.id.iv_left);
        iv_right = (ImageView) findViewById(R.id.iv_right);
        monthDateView = (MyMonthDateView) findViewById(R.id.monthDateView);
        tv_date = (TextView) findViewById(R.id.date_text);
        tv_week = (TextView) findViewById(R.id.week_text);
        tv_today = (TextView) findViewById(R.id.tv_today);
        monthDateView.setTextView(tv_date, tv_week);
        monthDateView.setDaysHasThingList(list);
        monthDateView.setDateClick(new MyMonthDateView.DateClick() {

            @Override
            public void onClickOnDate() {
                Toast.makeText(getApplication(), "点击了：" + monthDateView.getmSelDay(), Toast.LENGTH_SHORT).show();
            }
        });
        setOnlistener();
    }

    private void setOnlistener() {
        iv_left.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.onLeftClick();
            }
        });

        iv_right.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.onRightClick();
            }
        });

        tv_today.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                monthDateView.setTodayToView();
            }
        });
    }
}
