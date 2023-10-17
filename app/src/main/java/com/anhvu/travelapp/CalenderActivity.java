package com.anhvu.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import com.anhvu.travelapp.hotel_activity.ServiceActivity;

import java.util.Calendar;

public class CalenderActivity extends AppCompatActivity {
    CalendarView calendarViewFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);

        calendarViewFrom = (CalendarView) findViewById(R.id.calendarViewFrom);
        Calendar calendar = Calendar.getInstance();
        calendarViewFrom.setDate(calendar.getTimeInMillis());
        calendarViewFrom.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarViewSet, int i, int i1, int i2) {
               String dayFrom = i2+"/"+i1+"/"+i;
                Intent intent = new Intent(CalenderActivity.this, ServiceActivity.class);
                intent.putExtra("dayFrom",dayFrom);
                startActivity(intent);
            }
        });
    }
}