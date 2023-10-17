package com.anhvu.travelapp.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.car_activity.CarSearchActivity;
import com.anhvu.travelapp.cruise_activity.CruiseSearchActivity;
import com.anhvu.travelapp.model.CategoryCar;

import java.util.ArrayList;

public class CategoryCarAdapter extends RecyclerView.Adapter<CategoryCarAdapter.ViewHolder> {

    ArrayList<CategoryCar> categoryCar;

    public CategoryCarAdapter(ArrayList<CategoryCar> categoryCruises) {
        this.categoryCar = categoryCruises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_tour,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(categoryCar.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), CarSearchActivity.class);
                intent.putExtra("idCategoryCar", categoryCar.get(position).getId());
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryCar.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTille = (TextView) itemView.findViewById(R.id.textViewTitleTour) ;
        }
    }
}
