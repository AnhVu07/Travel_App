package com.anhvu.travelapp.car_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.CarAdapter;
import com.anhvu.travelapp.adapter.CategoryCarAdapter;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.Car;
import com.anhvu.travelapp.model.CategoryCar;

import java.util.ArrayList;

public class CarSearchActivity extends AppCompatActivity {
    ImageView imageViewBackSearchCar;
    RecyclerView listCategoryCarPageSearch,listCarPageSearch;
    CategoryCarAdapter categoryCarAdapter;
    CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_search);

        imageViewBackSearchCar = (ImageView) findViewById(R.id.imageViewBackSearchCar);
        imageViewBackSearchCar.setOnClickListener(view ->startActivity(new Intent(this, IntroActivity.class)));
        getListCategoryCar();
        int id = (int) getIntent().getIntExtra("idCategoryCar",1);
        getDataCar(id);
    }

    private void getListCategoryCar(){
        ArrayList<CategoryCar> categoryCars = new ArrayList<>();
        categoryCars.add(new CategoryCar(1,"Xe máy"));
        categoryCars.add(new CategoryCar(2,"Xe Taxi"));
        categoryCars.add(new CategoryCar(3,"Xe đạp"));
        listCategoryCarPageSearch = (RecyclerView) findViewById(R.id.listCategoryCarPageSearch);
        listCategoryCarPageSearch.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryCarAdapter = new CategoryCarAdapter(categoryCars);
        listCategoryCarPageSearch.setAdapter(categoryCarAdapter);
    }

    public void getDataCar(int id){
        ArrayList<Car> cars = new ArrayList<>();
        DB_Sql db_sql = new DB_Sql(this,"travel app1",null,1);
        Cursor cursor = db_sql.getQueryData("select * from car where idCategoryCar='"+id+"'");
        while (cursor.moveToNext()){
            Car car = new Car(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                    cursor.getDouble(5),cursor.getDouble(6),cursor.getString(7),cursor.getString(8)
                    ,cursor.getString(9),cursor.getString(10));
            cars.add(car);
        }
        listCarPageSearch=(RecyclerView) findViewById(R.id.listCarPageSearch);
        listCarPageSearch.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        carAdapter = new CarAdapter(cars);
        listCarPageSearch.setAdapter(carAdapter);

    }
}