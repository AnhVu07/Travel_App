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

import com.anhvu.travelapp.hotel_activity.DetailServiceActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Hotel;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {

    ArrayList<Hotel> services;
    DecimalFormat decimalFormat;

    public HotelAdapter(ArrayList<Hotel> services) {
        this.services = services;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_hoder_hotel,parent,false);
        return new HotelAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewLocation.setText(services.get(position).getLocation());
        holder.textViewTitle.setText(services.get(position).getName());
        holder.textViewScoreHotel.setText(services.get(position).getPoint()+"");
        holder.textViewPriceHotel.setText("$"+services.get(position).getPrice());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(services.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(10,10,10,10)).into(holder.imageViewHotel);

        holder.imageViewHotel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), DetailServiceActivity.class);
        intent.putExtra("hotel", (Serializable) services.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewHotel;
        TextView textViewScoreHotel,textViewTitle,textViewLocation,textViewPriceHotel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewHotel = (ImageView) itemView.findViewById(R.id.imageViewFoodInCa);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewNameFoodInCa);
            textViewScoreHotel = (TextView) itemView.findViewById(R.id.textViewScoreTour);
            textViewLocation = (TextView) itemView.findViewById(R.id.textViewPriceTour);
            textViewPriceHotel = (TextView) itemView.findViewById(R.id.textViewPriceFoodInCa);
        }
    }
}
