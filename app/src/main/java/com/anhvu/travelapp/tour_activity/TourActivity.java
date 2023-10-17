package com.anhvu.travelapp.tour_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.SelectPlaceActivity;
import com.anhvu.travelapp.adapter.CategoryTourAdapter;
import com.anhvu.travelapp.adapter.CategoryTourAdapter2;
import com.anhvu.travelapp.adapter.TourAdapter;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.CategoryFood;
import com.anhvu.travelapp.model.CategoryTour;
import com.anhvu.travelapp.model.Tour;

import java.util.ArrayList;

public class TourActivity extends AppCompatActivity {
    CategoryTourAdapter categoryTourAdapter;
    CategoryTourAdapter2 categoryTourAdapter2;
    ImageView imageViewBackSearchTour;
    RecyclerView recyclerViewCaTour,recyclerViewCaTour2,recyclerViewTour,recyclerViewTour2;
    TextView textViewTour;
    TextView editTextSelect;
    DB_Sql db_sql;
    TourAdapter tourAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);

        db_sql = new DB_Sql(this,"travel app1",null,1);
        textViewTour = (TextView) findViewById(R.id.textViewNameServiceTour) ;
        imageViewBackSearchTour = (ImageView) findViewById(R.id.imageViewBackSearchTour);
        editTextSelect = (TextView) findViewById(R.id.editTextSearchTour);
        String namePlace = getIntent().getStringExtra("namePlace");
        if(namePlace!=null){
            editTextSelect.setText(namePlace);
        }
        editTextSelect.setOnClickListener(view -> startActivity(new Intent(this, SelectPlaceActivity.class)));
        imageViewBackSearchTour.setOnClickListener(view -> startActivity(new Intent(this, IntroActivity.class)));
        String name = getIntent().getStringExtra("nameService");
        textViewTour.setText(name);
        getDataCategoryTour();
        fillTourByCategory();
        fillTourByCategory2();

    }

    private void fillTourByCategory(){
        int id = getIntent().getIntExtra("TourCategory",1);
            ArrayList<Tour> tours = new ArrayList<>();
            String query = "select * from tour where idCategoryTour='" + id + "'";
            Cursor cursor = db_sql.getQueryData(query);
            while (cursor.moveToNext()) {
                Tour tour = new Tour(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)
                        , cursor.getString(4), cursor.getString(5), cursor.getDouble(6), cursor.getDouble(7)
                        , cursor.getString(8), cursor.getString(9), cursor.getString(10));
                tours.add(tour);
            }
            recyclerViewTour = (RecyclerView) findViewById(R.id.listTour);
            recyclerViewTour.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            tourAdapter = new TourAdapter(tours);
            recyclerViewTour.setAdapter(tourAdapter);


    }

    private void fillTourByCategory2(){
        int id = getIntent().getIntExtra("TourCategory2",5);
            ArrayList<Tour> tours2 = new ArrayList<>();
            String query = "select * from tour where idCategoryTour='" + id + "'";
            Cursor cursor = db_sql.getQueryData(query);
            while (cursor.moveToNext()) {
                Tour tour = new Tour(cursor.getInt(0), cursor.getInt(1), cursor.getString(2), cursor.getString(3)
                        , cursor.getString(4), cursor.getString(5), cursor.getDouble(6), cursor.getDouble(7)
                        , cursor.getString(8), cursor.getString(9), cursor.getString(10));
                tours2.add(tour);
            }
            recyclerViewTour2 = (RecyclerView) findViewById(R.id.listTour2);
            recyclerViewTour2.setLayoutManager(new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false));
            tourAdapter = new TourAdapter(tours2);
            recyclerViewTour2.setAdapter(tourAdapter);
    }

    private void getDataCategoryTour() {
        ArrayList<CategoryTour> categoryTours = new ArrayList<>();
        categoryTours.add(new CategoryTour(1,"Phú Quốc"));
        categoryTours.add(new CategoryTour(2,"Đà Nẵng"));
        categoryTours.add(new CategoryTour(3,"Đà Lạt"));
        categoryTours.add(new CategoryTour(4,"Vịnh Hạ Long"));
        recyclerViewCaTour = (RecyclerView) findViewById(R.id.listCatogoryTour);
        recyclerViewCaTour.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryTourAdapter = new CategoryTourAdapter(categoryTours);
        recyclerViewCaTour.setAdapter(categoryTourAdapter);

        ArrayList<CategoryTour> categoryTours2 = new ArrayList<>();
        categoryTours2.add(new CategoryTour(5,"Hàn Quốc"));
        categoryTours2.add(new CategoryTour(6,"Nhật Bản"));
        categoryTours2.add(new CategoryTour(7,"Thái Lan"));
        categoryTours2.add(new CategoryTour(8,"Singapore"));
        recyclerViewCaTour2 = (RecyclerView) findViewById(R.id.listCatogoryTour2);
        recyclerViewCaTour2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryTourAdapter2 = new CategoryTourAdapter2(categoryTours2);
        recyclerViewCaTour2.setAdapter(categoryTourAdapter2);
    }




}