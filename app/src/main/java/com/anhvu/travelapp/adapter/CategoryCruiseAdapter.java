package com.anhvu.travelapp.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.cruise_activity.CruiseSearchActivity;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.CategoryCruise;
import com.anhvu.travelapp.model.CategoryTour;
import com.anhvu.travelapp.model.Cruise;
import com.anhvu.travelapp.tour_activity.TourActivity;

import java.util.ArrayList;

public class CategoryCruiseAdapter extends RecyclerView.Adapter<CategoryCruiseAdapter.ViewHolder> {

    ArrayList<CategoryCruise> categoryCruises;

    public CategoryCruiseAdapter(ArrayList<CategoryCruise> categoryCruises) {
        this.categoryCruises = categoryCruises;
    }

    public CategoryCruiseAdapter() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_tour,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(categoryCruises.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), CruiseSearchActivity.class);
                intent.putExtra("id",categoryCruises.get(position).getId());
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryCruises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTille = (TextView) itemView.findViewById(R.id.textViewTitleTour) ;
        }
    }



}
