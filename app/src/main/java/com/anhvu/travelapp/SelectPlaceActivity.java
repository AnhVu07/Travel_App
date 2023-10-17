package com.anhvu.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.anhvu.travelapp.adapter.SelectPlaceAdapter;
import com.anhvu.travelapp.model.SelectPlace;

import java.util.ArrayList;

public class SelectPlaceActivity extends AppCompatActivity {
    SelectPlaceAdapter selectPlaceAdapter;
    RecyclerView listVietNam,listHanQuoc,listNhatBan,listSingapore,listThaiLan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_place);

        getDataSelectPlace();
    }

    private void getDataSelectPlace(){
        ArrayList<SelectPlace> selectPlaces = new ArrayList<>();
        selectPlaces.add(new SelectPlace(1,"Phú Quốc"));
        selectPlaces.add(new SelectPlace(2,"Đà Nẵng"));
        selectPlaces.add(new SelectPlace(3,"Đà Lạt"));
        selectPlaces.add(new SelectPlace(4,"Ninh Binh - Hạ Long"));
        listVietNam = (RecyclerView) findViewById(R.id.listVietNam);
        listVietNam.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        selectPlaceAdapter = new SelectPlaceAdapter(selectPlaces);
        listVietNam.setAdapter(selectPlaceAdapter);

        ArrayList<SelectPlace> selectPlaces2 = new ArrayList<>();
        selectPlaces2.add(new SelectPlace(5,"Leju"));
        selectPlaces2.add(new SelectPlace(6,"Seoul"));
        selectPlaces2.add(new SelectPlace(7,"Busan"));
        selectPlaces2.add(new SelectPlace(8,"Incheon"));
        listHanQuoc = (RecyclerView) findViewById(R.id.listHanQuoc);
        listHanQuoc.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        selectPlaceAdapter = new SelectPlaceAdapter(selectPlaces2);
        listHanQuoc.setAdapter(selectPlaceAdapter);

        ArrayList<SelectPlace> selectPlaces3 = new ArrayList<>();
        selectPlaces3.add(new SelectPlace(9,"Tokyo"));
        selectPlaces3.add(new SelectPlace(10,"Osaka"));
        selectPlaces3.add(new SelectPlace(11,"Nagoya"));
        selectPlaces3.add(new SelectPlace(12,"Hiroshima"));
        listNhatBan = (RecyclerView) findViewById(R.id.listNhatBan);
        listNhatBan.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        selectPlaceAdapter = new SelectPlaceAdapter(selectPlaces3);
        listNhatBan.setAdapter(selectPlaceAdapter);

        ArrayList<SelectPlace> selectPlaces4 = new ArrayList<>();
        selectPlaces4.add(new SelectPlace(9,"Bangkok"));
        selectPlaces4.add(new SelectPlace(10,"Hua Hin"));
        selectPlaces4.add(new SelectPlace(11,"Phuket"));
        selectPlaces4.add(new SelectPlace(12,"Chiang Mai"));
        listThaiLan = (RecyclerView) findViewById(R.id.listTháiLan);
        listThaiLan.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        selectPlaceAdapter = new SelectPlaceAdapter(selectPlaces4);
        listThaiLan.setAdapter(selectPlaceAdapter);

        ArrayList<SelectPlace> selectPlaces5 = new ArrayList<>();
        selectPlaces5.add(new SelectPlace(9,"Singapore"));
        listSingapore = (RecyclerView) findViewById(R.id.listSingapore);
        listSingapore.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        selectPlaceAdapter = new SelectPlaceAdapter(selectPlaces5);
        listSingapore.setAdapter(selectPlaceAdapter);

    }
}