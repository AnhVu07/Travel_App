package com.anhvu.travelapp.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.anhvu.travelapp.R;
import com.anhvu.travelapp.cruise_activity.CruiseDetailActivity;
import com.anhvu.travelapp.model.Cruise;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CruiseAdapter extends RecyclerView.Adapter<CruiseAdapter.ViewHolder> {

    ArrayList<Cruise> cruises;
    DecimalFormat decimalFormat;

    public CruiseAdapter(ArrayList<Cruise> tours) {
        this.cruises = tours;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    public CruiseAdapter() {

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_tour,parent,false);
        return new CruiseAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewPrice.setText(cruises.get(position).getPrice()+"");
        holder.textViewScore.setText(cruises.get(position).getScore()+"");
        holder.textViewTitle.setText(cruises.get(position).getName());


        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(cruises.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(20,20,20,20)).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       Intent intent = new Intent(holder.itemView.getContext(), CruiseDetailActivity.class);
       intent.putExtra("cruise",cruises.get(position));
        holder.itemView.getContext().startActivity(intent);

    }
});

    }

    @Override
    public int getItemCount() {
        return cruises.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewScore,textViewTitle,textViewPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewImgTour);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewNameTour);
            textViewScore = (TextView) itemView.findViewById(R.id.textViewScoreTour);
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPriceTour);
        }
    }


}
