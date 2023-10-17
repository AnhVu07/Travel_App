package com.anhvu.travelapp.cruise_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Cruise;
import com.bumptech.glide.Glide;

public class CruiseDetailActivity extends AppCompatActivity {
    ImageView imageViewBack,imageViewAnhDetail;
    TextView textViewTitle,textViewLocation,textViewBedCruise,textViewFood,textViewWifi;
    TextView textViewTextDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruise_detail);

        mapping();
        setDataDetail();
        imageViewBack.setOnClickListener(view -> finish());
        buttonBook.setOnClickListener(view -> {
            Toast.makeText(this,"Book successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, IntroActivity.class));
        });
    }

    private void setDataDetail(){
        Cruise cruise = (Cruise) getIntent().getSerializableExtra("cruise");
        int drawableResourceId = getResources().getIdentifier(cruise.getPicture(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitle.setText(cruise.getName());
        textViewTextDetailD.setText(cruise.getDetail());
        textViewPriceD.setText("$"+cruise.getPrice());
        textViewScoreD.setText(cruise.getScore()+"");
        textViewLocation.setText(cruise.getLocation());
        if(cruise.getBed().equals("1")){
            textViewBedCruise.setText("Yes");
        } else {
            textViewBedCruise.setText("No");
        }

        if(cruise.getFood().equals("1")){
            textViewFood.setText("Yes");
        } else {
            textViewFood.setText("No");
        }

        if(cruise.getWifi().equals("1")){
            textViewWifi.setText("wifi");
        } else {
            textViewWifi.setText("No wifi");
        }

    }

    private void mapping() {
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackCruiseDetail);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgCruiseDetail);
        textViewTitle = (TextView) findViewById(R.id.textViewTitleDetailCruise);
        textViewLocation = (TextView) findViewById(R.id.textViewLocationCruiseDetail);
        textViewBedCruise = (TextView) findViewById(R.id.textViewBedCruiseDetail);
        textViewTextDetailD = (TextView) findViewById(R.id.textViewTextDetailCruise);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailCruise);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreCruiseDetail);
        textViewFood = (TextView) findViewById(R.id.textViewFoodCruise);
        textViewWifi = (TextView) findViewById(R.id.textViewWifiCruise);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookCruise);

    }
}