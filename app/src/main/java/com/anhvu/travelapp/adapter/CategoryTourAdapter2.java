package com.anhvu.travelapp.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.tour_activity.TourActivity;
import com.anhvu.travelapp.model.CategoryTour;

import java.util.ArrayList;

public class CategoryTourAdapter2 extends RecyclerView.Adapter<CategoryTourAdapter2.ViewHolder> {

    ArrayList<CategoryTour> categoryTours;

    public CategoryTourAdapter2(ArrayList<CategoryTour> categoryTours) {
        this.categoryTours = categoryTours;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_tour,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(categoryTours.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(),TourActivity.class);
                intent.putExtra("TourCategory2",categoryTours.get(position).getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryTours.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTille = (TextView) itemView.findViewById(R.id.textViewTitleTour) ;
        }
    }
}
