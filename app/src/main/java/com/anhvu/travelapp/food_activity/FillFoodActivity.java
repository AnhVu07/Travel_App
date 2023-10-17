package com.anhvu.travelapp.food_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.FoodInCategoryAdapter;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.CategoryFood;
import com.anhvu.travelapp.model.Food;

import java.util.ArrayList;
import java.util.List;

public class FillFoodActivity extends AppCompatActivity {
    DB_Sql db_sql;
    ImageView imageViewBack;
    RecyclerView listFood;
    TextView textViewTitle;
    FoodInCategoryAdapter foodInCategoryAdapter;
    ArrayList<Food> foods;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_food);

        db_sql = new DB_Sql(this,"travel app1",null,1);
        foods = new ArrayList<>();
        mapping();
        CategoryFood categoryFood  = (CategoryFood) getIntent().getSerializableExtra("FoodCategory");
        System.out.println(categoryFood);
        getDataFoodInCategory(categoryFood.getId());
        foodInCategoryAdapter = new FoodInCategoryAdapter(foods);
        listFood.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));
        listFood.setAdapter(foodInCategoryAdapter);
        textViewTitle.setText(categoryFood.getName());
        imageViewBack.setOnClickListener(view->finish());
    }

    private void mapping() {
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackPlaceSearch);
        listFood = (RecyclerView)findViewById(R.id.listFoodInCAtegory);
        textViewTitle =(TextView) findViewById(R.id.textViewTitlePlaceSearch);
    }

    private List<Food> getDataFoodInCategory(int id) {
        Cursor cursor = db_sql.getQueryData("select * from food where idCategoryFood="+id);
        while (cursor.moveToNext()){
            Food food = new Food(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4)
                    ,cursor.getInt(5),cursor.getDouble(6),cursor.getDouble(7),cursor.getInt(8));
            foods.add(food);
        }

        return foods;
    }


}