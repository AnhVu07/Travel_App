package com.anhvu.travelapp.cruise_activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.CategoryCruiseAdapter;
import com.anhvu.travelapp.model.CategoryCruise;
import com.anhvu.travelapp.fragment.FragmentA;

import java.util.ArrayList;

public class CruiseSearchActivity extends AppCompatActivity {
    ImageView imageViewBackSearchCruise;
    RecyclerView recyclerViewCruise;
    CategoryCruiseAdapter categoryCruiseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cruise_search);

        getDataCategoryCruise();
        imageViewBackSearchCruise = (ImageView) findViewById(R.id.imageViewBackSearchCruise);
        imageViewBackSearchCruise.setOnClickListener(view-> startActivity(new Intent(this, IntroActivity.class)));
        addFragment();
    }

    private void getDataCategoryCruise(){
        ArrayList<CategoryCruise> categoryCruises = new ArrayList<>();
        categoryCruises.add(new CategoryCruise(1,"Du thuyền"));
        categoryCruises.add(new CategoryCruise(2,"Phà"));
        recyclerViewCruise = (RecyclerView) findViewById(R.id.listCruiseSearch);
        recyclerViewCruise.setLayoutManager(new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false));
        categoryCruiseAdapter = new CategoryCruiseAdapter(categoryCruises);
        recyclerViewCruise.setAdapter(categoryCruiseAdapter);
    }

    private void addFragment(){
        int id =  getIntent().getIntExtra("id",1);
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        FragmentA fragmentA = new FragmentA();
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        fragmentA.setArguments(bundle);
        fragmentTransaction.replace(R.id.layoutFrame,fragmentA);
        fragmentTransaction.commit();

    }
}