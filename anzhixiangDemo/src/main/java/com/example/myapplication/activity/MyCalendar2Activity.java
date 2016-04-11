package com.example.myapplication.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.myapplication.R;
import com.imanoweb.calendarview.CalendarListener;
import com.imanoweb.calendarview.CustomCalendarView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MyCalendar2Activity extends AppCompatActivity {
    @Bind(R.id.calendar_view)
    CustomCalendarView calendarView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_calendar2);
        ButterKnife.bind(this);
//       //Initialize calendar with date
        Calendar currentCalendar = Calendar.getInstance(Locale.getDefault());

//Show Monday as first date of week
        calendarView.setFirstDayOfWeek(Calendar.MONDAY);

//Show/hide overflow days of a month
        calendarView.setShowOverflowDate(false);

//call refreshCalendar to update calendar the view
        calendarView.refreshCalendar(currentCalendar);

//Handling custom calendar events
        calendarView.setCalendarListener(new CalendarListener() {
            @Override
            public void onDateSelected(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                Toast.makeText(MyCalendar2Activity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onMonthChanged(Date date) {
                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
                Toast.makeText(MyCalendar2Activity.this, df.format(date), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
