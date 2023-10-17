package com.anhvu.travelapp.hotel_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.HotelAdapter;
import com.anhvu.travelapp.model.Hotel;

import java.util.ArrayList;

public class HotelActivity extends AppCompatActivity {
    RecyclerView recyclerViewHotel;
    HotelAdapter hotelAdapter;
    TextView textViewName;
    ImageView imageViewBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        recyclerViewHotel = findViewById(R.id.listFoodInCAtegory);
        textViewName = (TextView) findViewById(R.id.textViewTitlePlaceSearch);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackPlaceSearch);
        getDataHotel();
        String search = getIntent().getStringExtra("search");
        textViewName.setText(search);
        imageViewBack.setOnClickListener(view->finish());

    }

    private void getDataHotel(){
        ArrayList<Hotel> services = new ArrayList<>();
        services.add(new Hotel(1,1,"DALAT EDENSEE Lake Resort and Spa","hotel2","Đà Lạt",5.0,150.2,"1","1","1"));
        services.add(new Hotel(2,1,"VUNGTAU EDENSEE Lake Holtel and Spa","hotel3","Vũng Tàu",4.0,120.7,"0","0","1"));
        services.add(new Hotel(3,1,"NHATRANG Resort and Spa","hotel4","Nha Trang",5.0,250.5,"1","1","1"));
        services.add(new Hotel(4,1,"HANOI EDENSEE Lake Resort and Holtel","hotel5","Hà Nội",4.5,320.6,"1","0","1"));
        services.add(new Hotel(5,1,"HUE Lake Resort and Spa","hotel6","Huế",5.0,450.8,"1","1","1"));
        services.add(new Hotel(6,1,"DANANG Lake Holtel and Spa","hotel7","Đà Nẵng",4.8,450.4,"1","0","1"));
        services.add(new Hotel(7,1,"BINHDINH Lake Resort and Spa","hotel8","Bình Định",5.0,250.2,"0","1","1"));
        services.add(new Hotel(8,1,"Hollywood Lake Holtel and Spa","hotel9","Hollywood",4.0,550.1,"1","0","1"));
        services.add(new Hotel(9,1,"Los Angeles Holtel and Spa","hotel10","Los Angeles",4.5,4.503,"1","1","1"));
        recyclerViewHotel.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        hotelAdapter = new HotelAdapter(services);
        recyclerViewHotel.setAdapter(hotelAdapter);
    }
}