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
import com.anhvu.travelapp.cruise_activity.CruiseSearchActivity;
import com.anhvu.travelapp.model.SelectPlace;
import com.anhvu.travelapp.tour_activity.TourActivity;

import java.util.ArrayList;

public class SelectPlaceAdapter extends RecyclerView.Adapter<SelectPlaceAdapter.ViewHolder> {

    ArrayList<SelectPlace> selectPlaces;

    public SelectPlaceAdapter(ArrayList<SelectPlace> categoryCruises) {
        this.selectPlaces = categoryCruises;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_select_place,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(selectPlaces.get(position).getName());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), TourActivity.class);
                intent.putExtra("namePlace", selectPlaces.get(position).getName());
                holder.itemView.getContext().startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return selectPlaces.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTille = (TextView) itemView.findViewById(R.id.textViewNameSelectPlace) ;
        }
    }



}
