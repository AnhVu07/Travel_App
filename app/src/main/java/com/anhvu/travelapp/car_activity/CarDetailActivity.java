package com.anhvu.travelapp.car_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Car;
import com.anhvu.travelapp.model.Cruise;
import com.bumptech.glide.Glide;

public class CarDetailActivity extends AppCompatActivity {
    ImageView imageViewBack,imageViewAnhDetail;
    TextView textViewTitle,textViewLocation,textViewSeatCruise,textViewVali,textViewDoor;
    TextView textViewTextDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detail);

        mapping();
        imageViewBack.setOnClickListener(view -> finish());
        buttonBook.setOnClickListener(view -> {
            Toast.makeText(this,"Book successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, IntroActivity.class));
        });
        setDataDetail();

    }


    private void setDataDetail(){
        Car car = (Car) getIntent().getSerializableExtra("car");
        int drawableResourceId = getResources().getIdentifier(car.getPicture(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitle.setText(car.getName());
        textViewTextDetailD.setText(car.getDetail());
        textViewPriceD.setText("$"+car.getPrice());
        textViewScoreD.setText(car.getScore()+"");
        textViewLocation.setText(car.getLocation());
        textViewSeatCruise.setText(car.getSeats());
        textViewDoor.setText(car.getDoor());
        textViewVali.setText(car.getLuggages());


    }


    private void mapping() {
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackCruiseDetail);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgCruiseDetail);
        textViewTitle = (TextView) findViewById(R.id.textViewTitleDetailCruise);
        textViewLocation = (TextView) findViewById(R.id.textViewLocationCruiseDetail);
        textViewSeatCruise = (TextView) findViewById(R.id.textViewBedCruiseDetail);
        textViewTextDetailD = (TextView) findViewById(R.id.textViewTextDetailCruise);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailCruise);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreCruiseDetail);
        textViewVali = (TextView) findViewById(R.id.textViewFoodCruise);
        textViewDoor = (TextView) findViewById(R.id.textViewWifiCruise);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookCruise);

    }
}