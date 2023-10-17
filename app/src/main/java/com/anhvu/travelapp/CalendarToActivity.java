package com.anhvu.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import com.anhvu.travelapp.hotel_activity.ServiceActivity;

import java.util.Calendar;

public class CalendarToActivity extends AppCompatActivity {
    CalendarView calendarViewTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar_to);

        calendarViewTo = (CalendarView) findViewById(R.id.calendarViewTo);
        Calendar calendar = Calendar.getInstance();
        calendarViewTo.setDate(calendar.getTimeInMillis());
        calendarViewTo.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarViewSet, int i, int i1, int i2) {
                String dayTo = i2+"/"+i1+"/"+i;
                Intent intent = new Intent(CalendarToActivity.this, ServiceActivity.class);
                intent.putExtra("dayTo",dayTo);
                startActivity(intent);
            }
        });
    }
}