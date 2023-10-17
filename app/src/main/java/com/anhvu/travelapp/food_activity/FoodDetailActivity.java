package com.anhvu.travelapp.food_activity;

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
import com.bumptech.glide.Glide;

public class FoodDetailActivity extends AppCompatActivity {
    ImageView imageViewBack,imageViewAnhDetail;
    TextView textViewTitle,textViewLocation,textViewTable;
    TextView textViewDetailD, textViewPriceD,textViewScoreD;
    AppCompatButton buttonBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_detail);

        mapping();

        setDataDetail();
        imageViewBack.setOnClickListener(view -> finish());
        buttonBook.setOnClickListener(view->{
            Toast.makeText(this,"Book successfull",Toast.LENGTH_LONG).show();
            startActivity(new Intent(this, IntroActivity.class));
        });

    }

    private void setDataDetail(){
        Food food = (Food) getIntent().getSerializableExtra("food");
        int drawableResourceId = getResources().getIdentifier(food.getPicture(),"drawable",getPackageName());
        Glide.with(this).load(drawableResourceId).into(imageViewAnhDetail);
        textViewTitle.setText(food.getName());
        textViewLocation.setText(food.getRestaurant());
        textViewDetailD.setText(food.getDetail());
        textViewTable.setText(food.getTable()+"");
        textViewScoreD.setText(food.getDot()+"");
        textViewPriceD.setText("$"+food.getPrice());
    }

    private void mapping() {
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackTourDetail);
        imageViewAnhDetail = (ImageView) findViewById(R.id.imageViewImgDetaiFood);
        textViewTitle = (TextView) findViewById(R.id.textViewTitleDetailTour);
        textViewLocation = (TextView) findViewById(R.id.textViewLocationDetailTour);
        textViewTable = (TextView) findViewById(R.id.textViewTimeTour);
        textViewDetailD = (TextView) findViewById(R.id.textViewTextDetailTour);
        textViewPriceD = (TextView) findViewById(R.id.textViewPriceDetailTour);
        textViewScoreD = (TextView) findViewById(R.id.textViewScoreDetailTour);
        buttonBook = (AppCompatButton) findViewById(R.id.buttonBookTour);

    }
}