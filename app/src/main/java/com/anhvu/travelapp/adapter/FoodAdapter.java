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

import com.anhvu.travelapp.food_activity.FoodDetailActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Food;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    ArrayList<Food> foods;
    DecimalFormat decimalFormat;

    public FoodAdapter(ArrayList<Food> foods) {
        this.foods = foods;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_food,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTitle.setText(foods.get(position).getName());
        holder.textViewScore.setText(foods.get(position).getDot()+"");
        holder.textViewPrice.setText(""+foods.get(position).getPrice());
        int drawableResourceId = holder.itemView.getResources()
        .getIdentifier(foods.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(20,20,20,20)).into(holder.imageView);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), FoodDetailActivity.class);
                intent.putExtra("food",foods.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewScore,textViewTitle,textViewPrice;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewScore = (TextView) itemView.findViewById(R.id.textViewScoreTour) ;
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewNameTour) ;
            textViewPrice = (TextView) itemView.findViewById(R.id.textViewPriceTour) ;
            imageView = (ImageView) itemView.findViewById(R.id.imageViewFood);
        }
    }
}
