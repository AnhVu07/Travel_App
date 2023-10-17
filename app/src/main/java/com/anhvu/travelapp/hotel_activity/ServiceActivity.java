package com.anhvu.travelapp.hotel_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.CalendarToActivity;
import com.anhvu.travelapp.CalenderActivity;
import com.anhvu.travelapp.R;

public class ServiceActivity extends AppCompatActivity {
    TextView textViewName;
    TextView textFrom,textTo;
    EditText editTextSearhHotel;
    ImageView imageViewBack,imageViewDN;
    AppCompatButton buttonSearchHotel;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        mapping();
        sharedPreferences = getSharedPreferences("saveDate",MODE_PRIVATE);
        String name = getIntent().getStringExtra("nameService");
        textViewName.setText(name);
        textFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceActivity.this, CalenderActivity.class));
            }
        });
        textTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ServiceActivity.this, CalendarToActivity.class));
            }
        });

        String dayTo = getIntent().getStringExtra("dayTo");
        String dayFrom = getIntent().getStringExtra("dayFrom");
        textTo.setText(dayTo);
        textFrom.setText(dayFrom);

        buttonSearchHotel.setOnClickListener(view ->
                {
                    String search = editTextSearhHotel.getText().toString();
                    Intent intent = new Intent(this,HotelActivity.class);
                    intent.putExtra("search",search);
                    startActivity(intent);
                }
                );
        imageViewBack.setOnClickListener(view->finish());


    }

    private void mapping() {
        textViewName = (TextView) findViewById(R.id.textViewTitlePlaceSearch);
        textFrom = (TextView) findViewById(R.id.TextDateFrom);
        textTo = (TextView) findViewById(R.id.TextDateTo);
        editTextSearhHotel = (EditText) findViewById(R.id.editTextSearchHotel);
        buttonSearchHotel = (AppCompatButton) findViewById(R.id.buttonSearchCruise);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackSearchTour);
        imageViewDN = (ImageView) findViewById(R.id.imageViewDN);
    }


}