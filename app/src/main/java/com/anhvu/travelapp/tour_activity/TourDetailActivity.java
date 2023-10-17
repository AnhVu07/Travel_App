package com.anhvu.travelapp.tour_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Food;
import com.anhvu.travelapp.model.Tour;
import com.bumptech.glide.Glide;

public class TourDetailActivity extends AppCompatActivity {
    ImageView imageViewBack,imageViewAnhDetail;
    TextView textViewTitle,textViewLocation,textViewTimeTour,textViewFood,textViewBed;
    TextView textViewDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour_detail);

        mapping();
        setDataDetail();
        imageViewBack.setOnClickListener(view -> finish());
        buttonBook.setOnClickListener(view -> {
            Toast.makeText(this,"Book successful",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, IntroActivity.class));
        });

    }

    private void setDataDetail(){
        Tour tour = (Tour) getIntent().getSerializableExtra("tour");
        int drawableResourceId = getResources().getIdentifier(tour.getPicture(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitle.setText(tour.getName());
        textViewLocation.setText(tour.getLocation());
        textViewDetailD.setText(tour.getDetail());
        textViewTimeTour.setText(tour.getHour()+"");
        textViewScoreD.setText(tour.getScore()+"");
        textViewPriceD.setText("$"+tour.getPrice());
        if(tour.getFood().equals("1")){
            textViewFood.setText("Yes");
        } else {
            textViewFood.setText("No");
        }

        if(tour.getBed().equals("1")){
            textViewBed.setText("Yes");
        } else {
            textViewBed.setText("No");
        }
    }

    private void mapping() {
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackTourDetail);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgDetaiTour);
        textViewTitle = (TextView) findViewById(R.id.textViewTitleDetailTour);
        textViewLocation = (TextView) findViewById(R.id.textViewLocationDetailTour);
        textViewTimeTour = (TextView) findViewById(R.id.textViewTimeTour);
        textViewDetailD = (TextView) findViewById(R.id.textViewTextDetailTour);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailTour);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreDetailTour);
        textViewFood = (TextView) findViewById(R.id.textViewFoodTour);
        textViewBed = (TextView) findViewById(R.id.textViewBedTour);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookTour);

    }
}