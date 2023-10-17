package com.anhvu.travelapp.food_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.CategoryFoodAdapter;
import com.anhvu.travelapp.adapter.FoodAdapter;
import com.anhvu.travelapp.model.CategoryFood;
import com.anhvu.travelapp.model.Food;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

public class FoodSearchActivity extends AppCompatActivity {
    TextView textViewTitleFood,textViewRestaurant,textViewRestaurant2,textViewRestaurant3,textViewRestaurant4,textViewRestaurant5;
    ImageView imageViewPizza,imageViewBackFood;
    RecyclerView recyclerViewCaFood1,recyclerViewCaFood2,
            recyclerViewFood,recyclerViewFood2,recyclerViewFood3,recyclerViewFood4,recyclerViewFood5;
    CategoryFoodAdapter categoryFoodAdapter;
    FoodAdapter foodAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_search);

        mapping();
        imageViewBackFood.setOnClickListener(view->startActivity(new Intent(this, IntroActivity.class)));
        int idResourceDrawable = getResources().getIdentifier("food1","drawable",getPackageName());
        Glide.with(this).load(idResourceDrawable)
                .transform(new CenterCrop(),new GranularRoundedCorners(10,10,10,10))
                .into(imageViewPizza);
        String name = getIntent().getStringExtra("nameService");
        textViewTitleFood.setText(name);
        getDataCategoryFood();
        getDataFood();
    }

    private void mapping() {
        recyclerViewCaFood1 = (RecyclerView) findViewById(R.id.listCatogoryFood1);
        recyclerViewCaFood2 = (RecyclerView) findViewById(R.id.listCategoryFood2);
        textViewTitleFood = (TextView) findViewById(R.id.textViewNameServiceFood);
        imageViewPizza = (ImageView) findViewById(R.id.imageViewPizza);
        recyclerViewFood = (RecyclerView) findViewById(R.id.listView_Food1);
        recyclerViewFood2 = (RecyclerView) findViewById(R.id.listView_Food2);
        recyclerViewFood3 = (RecyclerView) findViewById(R.id.listView_Food3);
        recyclerViewFood4 = (RecyclerView) findViewById(R.id.listView_Food4);
        recyclerViewFood5 = (RecyclerView) findViewById(R.id.listView_Food5);
        textViewRestaurant = (TextView) findViewById(R.id.textViewRestaurant);
        textViewRestaurant2 = (TextView) findViewById(R.id.textViewRestaurant2);
        textViewRestaurant3 = (TextView) findViewById(R.id.textViewRestaurant3);
        textViewRestaurant4 = (TextView) findViewById(R.id.textViewRestaurant4);
        textViewRestaurant5 = (TextView) findViewById(R.id.textViewRestaurant5);
        imageViewBackFood = (ImageView) findViewById(R.id.imageViewBackSearchTour);
    }

    private void getDataCategoryFood() {
        ArrayList<CategoryFood> categoryFoods1 = new ArrayList<>();
        categoryFoods1.add(new CategoryFood(1,"Hamburger","food3"));
        categoryFoods1.add(new CategoryFood(2,"Beef","food8"));
        categoryFoods1.add(new CategoryFood(3,"Rice Noodle","food10"));
        categoryFoods1.add(new CategoryFood(4,"Rice","food12"));

        recyclerViewCaFood1.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryFoodAdapter = new CategoryFoodAdapter(categoryFoods1);
        recyclerViewCaFood1.setAdapter(categoryFoodAdapter);

        ArrayList<CategoryFood> categoryFoods2 = new ArrayList<>();
        categoryFoods2.add(new CategoryFood(5,"Porridge","food15"));
        categoryFoods2.add(new CategoryFood(6,"Chicken","food5"));
        categoryFoods2.add(new CategoryFood(7,"Pizza","food18"));
        categoryFoods2.add(new CategoryFood(8,"Bread","food17"));
        recyclerViewCaFood2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryFoodAdapter = new CategoryFoodAdapter(categoryFoods2);
        recyclerViewCaFood2.setAdapter(categoryFoodAdapter);
    }

    private void getDataFood(){
        ArrayList<Food> foods = new ArrayList<>();
        foods.add(new Food(1,"Buffer Lạp Xưởng","food22","Nhà hàng Hải Sản ở LOTTE","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. " +
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n"+
                               "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm",2,2100,4.5,1));
        foods.add(new Food(2,"Beef Bread","food17","Nhà hàng Hải Sản ở LOTTE","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. "+
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n"+
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm",1,2100,4.5,8));
        foods.add(new Food(3,"Vegetable Pizza","food18","Nhà hàng Hải Sản ở LOTTE","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. "+
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n"+
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm",2,2500,5.0,7));
        foods.add(new Food(4,"Pork Porridge","food15","Nhà hàng Hải Sản ở LOTTE","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00. "+
                "Nhà hàng Hải Sản ở LOTTE: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n"+
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm",3,2100,4.5,5));
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        foodAdapter = new FoodAdapter(foods);
        recyclerViewFood.setAdapter(foodAdapter);
        textViewRestaurant.setText(foods.get(1).getRestaurant());

        ArrayList<Food> foods2 = new ArrayList<>();
        foods2.add(new Food(1,"Beef Porridge","food14","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",5,2800,5.0,5));
        foods2.add(new Food(2,"Pork Bread","food16","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",4,2500,4.0,8));
        foods2.add(new Food(3,"Family Rice","food13","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",1,2200,5.0,4));
        foods2.add(new Food(4,"Beef Noodle Rice","food11","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",2,2100,4.5,1));
        recyclerViewFood2.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        foodAdapter = new FoodAdapter(foods2);
        recyclerViewFood2.setAdapter(foodAdapter);
        textViewRestaurant2.setText(foods2.get(1).getRestaurant());

        ArrayList<Food> foods3 = new ArrayList<>();
        foods3.add(new Food(1,"Beef Porridge","food7","Nhà hàng Vị Ngon","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00.\n" +
                " Nhà hàng Vị Ngon: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm.",10,2800,5.0,5));
        foods3.add(new Food(2,"Pork Bread","food8","Nhà hàng Vị Ngon","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00." +
                " Nhà hàng Vị Ngon: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12." +
               "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm.\"",4,2500,4.0,8));
        foods3.add(new Food(3,"Family Rice","food12","Nhà hàng Vị Ngon","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00." +
                " Nhà hàng Vị Ngon: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                       "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm.",3,2200,5.0,4));
        foods3.add(new Food(4,"Beef Noodle Rice","food10","Nhà hàng Vị Ngon","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00." +
                " Nhà hàng Vị Ngon: địa chỉ 18A đường Đồng Tiến, phường TMT, quận 12.\n" +
                              "Đầu bếp nhà hàng đến từ khắp mọi vùng miền với kinh nghiệm nấu ăn đa dạng các món trên 10 năm.",6,2100,4.5,1));
        recyclerViewFood3.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        foodAdapter = new FoodAdapter(foods3);
        recyclerViewFood3.setAdapter(foodAdapter);
        textViewRestaurant3.setText(foods3.get(1).getRestaurant());

        ArrayList<Food> foods4 = new ArrayList<>();
        foods4.add(new Food(1,"Beef Porridge","food9","Nhà hàng Sea Food 02","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",3,2800,5.0,5));
        foods4.add(new Food(2,"Pork Bread","food6","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",15,2500,4.0,8));
        foods4.add(new Food(3,"Family Rice","food4","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",20,2200,5.0,4));
        foods4.add(new Food(4,"Beef Noodle Rice","food5","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",8,2100,4.5,1));
        recyclerViewFood4.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        foodAdapter = new FoodAdapter(foods4);
        recyclerViewFood4.setAdapter(foodAdapter);
        textViewRestaurant4.setText(foods4.get(0).getRestaurant());

        ArrayList<Food> foods5 = new ArrayList<>();
        foods5.add(new Food(1,"Beef Porridge","food3","Nhà hàng Pork 365","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",13,2800,5.0,5));
        foods5.add(new Food(2,"Pork Bread","food16","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",5,2500,4.0,8));
        foods5.add(new Food(3,"Family Rice","food1","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",24,2200,5.0,4));
        foods5.add(new Food(4,"Beef Noodle Rice","food11","Nhà hàng Market 39","Giờ hoạt động: Thứ Hai đến Chủ Nhật từ 18:00 đến 22:00",12,2100,4.5,1));
        recyclerViewFood5.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        foodAdapter = new FoodAdapter(foods5);
        recyclerViewFood5.setAdapter(foodAdapter);
        textViewRestaurant5.setText(foods5.get(0).getRestaurant());



    }
}