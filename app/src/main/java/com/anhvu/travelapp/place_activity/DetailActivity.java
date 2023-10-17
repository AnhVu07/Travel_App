package com.anhvu.travelapp.place_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Domains;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    ImageView imageViewBack,imageViewAnhDetail,imageViewLike;
    TextView textViewTitleD,textViewLocationD,textViewBedD,textViewGuideD;
    TextView textViewWifi,textViewDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;
    boolean check = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mapping();
        setContent();

        imageViewBack.setOnClickListener(view -> finish());
        imageViewLike.setOnClickListener(view -> {
            if(check==true){
                imageViewLike.setImageResource(R.drawable.bottom_btn3);
                check=false;
            } else {
                imageViewLike.setImageResource(R.drawable.fav);
                check=true;
            }
        });
        buttonBook.setOnClickListener(view ->
                {
                    Toast.makeText(this,"Book successful",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(this, IntroActivity.class));
                }
        );

    }

    private void setContent(){
        Domains domains = (Domains) getIntent().getSerializableExtra("domain");
        int drawableResourceId = getResources().getIdentifier(domains.getPic(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitleD.setText(domains.getTitle());
        textViewLocationD.setText(domains.getLocation());
        textViewScoreD.setText(domains.getScore()+"");
        textViewBedD.setText(domains.getBed()+"");
        if(domains.isGuide().equals("1")){
        textViewGuideD.setText("Yes");
        } else {
        textViewGuideD.setText("No");
        }
        if(domains.isWifi().equals("1")){
            textViewWifi.setText("Wifi");
        } else {
            textViewWifi.setText("No Wifi");
        }

        textViewDetailD.setText(domains.getDescription());
        textViewPriceD.setText("$"+domains.getPrice());


    }

    private void mapping(){
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackTourDetail);
        imageViewLike = (ImageView) findViewById(R.id.imageViewLike);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgDetaiTour);
        textViewTitleD = (TextView) findViewById(R.id.textViewTitleDetailTour);
        textViewLocationD = (TextView) findViewById(R.id.textViewLocationDetailTour);
        textViewBedD = (TextView) findViewById(R.id.textViewTimeTour);
        textViewGuideD = (TextView) findViewById(R.id.textViewFoodTour);
        textViewWifi = (TextView) findViewById(R.id.textViewBedTour);
        textViewDetailD = (TextView) findViewById(R.id.textViewTextDetailTour);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailTour);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreDetailTour);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookTour);

    }
}