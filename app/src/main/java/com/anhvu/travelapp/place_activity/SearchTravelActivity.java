package com.anhvu.travelapp.place_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.DomainAdapterFillCategory;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.Domains;

import java.util.ArrayList;

public class SearchTravelActivity extends AppCompatActivity {

    DomainAdapterFillCategory domainAdapterFillCategory;
    RecyclerView recyclerView;
    ImageView imageViewBack;
    TextView textViewSearch;
    DB_Sql db_sql;
    ArrayList<Domains> domains = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_travel);
        db_sql = new DB_Sql(this,"travel app1",null,1);
        String keyWord = getIntent().getStringExtra("keyWord");
        getDataBySearch(keyWord);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerViewSearch);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackPlaceSearch);
        textViewSearch = (TextView) findViewById(R.id.textViewTitlePlaceSearch);
        textViewSearch.setText(keyWord);
        imageViewBack.setOnClickListener(view -> finish());
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
        domainAdapterFillCategory = new DomainAdapterFillCategory(domains);
        recyclerView.setAdapter(domainAdapterFillCategory);

    }

    public void getDataBySearch(String keyWord){
        Cursor cursor = db_sql.getQueryData("SELECT * FROM `place` WHERE title LIKE '%"+keyWord+"%';");
        while (cursor.moveToNext()){
            Domains d = new Domains(cursor.getString(2),cursor.getString(3)
                    ,cursor.getString(5),cursor.getInt(4),
                    ((double) (cursor.getInt(6))),cursor.getExtras().getBoolean("wifi")+"",cursor.getExtras().getBoolean("guide")+""
                    ,cursor.getString(9),((double)(cursor.getFloat(10))));
            domains.add(d);
        }
    }


}