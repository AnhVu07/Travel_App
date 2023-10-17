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
import com.anhvu.travelapp.tour_activity.TourDetailActivity;
import com.anhvu.travelapp.model.Tour;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class TourAdapter extends RecyclerView.Adapter<TourAdapter.ViewHolder> {

    ArrayList<Tour> tours;
    DecimalFormat decimalFormat;

    public TourAdapter(ArrayList<Tour> tours) {
        this.tours = tours;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_tour,parent,false);
        return new TourAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewPrice.setText(tours.get(position).getPrice()+"");
        holder.textViewScore.setText(tours.get(position).getScore()+"");
        holder.textViewTitle.setText(tours.get(position).getName());


        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(tours.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(20,20,20,20)).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), TourDetailActivity.class);
        intent.putExtra("tour",tours.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return tours.size();
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
