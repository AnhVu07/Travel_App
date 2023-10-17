package com.anhvu.travelapp.hotel_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Hotel;
import com.bumptech.glide.Glide;

public class DetailServiceActivity extends AppCompatActivity {
    ImageView imageViewBack,imageViewAnhDetail;
    TextView textViewTitleD,textViewLocationD,textViewPool,textViewFood,textViewWifi;
    TextView textViewTextDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_service);

        mapping();
        setData();
        imageViewBack.setOnClickListener(view->finish());
        buttonBook.setOnClickListener(view -> {
            Toast.makeText(this,"Book successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, IntroActivity.class));
        });


    }

    private void setData(){
        Hotel service = (Hotel) getIntent().getSerializableExtra("hotel");
        int drawableResourceId = getResources().getIdentifier(service.getPicture(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitleD.setText(service.getName());
        textViewLocationD.setText(service.getLocation());
        textViewScoreD.setText(service.getPoint()+"");
        textViewTextDetailD.setText("Embark with Hotel des Arts Saigon, MGallery" +
                " on a journey back in time to Vietnam in 1930s to relive the romance of this bygone era w" +
                "hile luxuriating in all the comforts of the 21st century. Combining the classical charm of French In" +
                "dochina with a sense of timeless chic, the hotel is as much an art museum as a 5-star boutique hotel. ");
        textViewPriceD.setText("$"+service.getPrice());
        if(service.getPool().equals("1")){
            textViewPool.setText("Yes");
        } else {
            textViewPool.setText("No");
        }

        if(service.getFood().equals("1")){
            textViewFood.setText("Yes");
        } else {
            textViewFood.setText("No");
        }

        if(service.getWifi().equals("1")){
            textViewWifi.setText("Wifi");
        } else {
            textViewWifi.setText("No Wifi");
        }



    }

    private void mapping(){
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackTourDetail);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgDetaiTour);
        textViewTitleD = (TextView) findViewById(R.id.textViewTitleDetailTour);
        textViewLocationD = (TextView) findViewById(R.id.textViewLocationDetailTour);
        textViewTextDetailD = (TextView) findViewById(R.id.textViewTextDetailTour);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailTour);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreDetailTour);
        textViewPool = (TextView) findViewById(R.id.textViewPool);
        textViewFood = (TextView) findViewById(R.id.textViewFoodHotel);
        textViewWifi = (TextView) findViewById(R.id.textViewWifiHotel);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookTour);
    }
}