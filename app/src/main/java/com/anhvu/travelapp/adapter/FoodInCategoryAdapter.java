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

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class FoodInCategoryAdapter extends RecyclerView.Adapter<FoodInCategoryAdapter.ViewHolder> {

    ArrayList<Food> foods;
    DecimalFormat decimalFormat;

    public FoodInCategoryAdapter(ArrayList<Food> foods) {
        this.foods = foods;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_food_in_category,parent,false);
        return new FoodInCategoryAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewLocation.setText(foods.get(position).getRestaurant());
        holder.textViewTitle.setText(foods.get(position).getName());
        holder.textViewScoreFood.setText(foods.get(position).getDot()+"");
        holder.textViewPriceFood.setText("$"+foods.get(position).getPrice());

        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(foods.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(10,10,10,10)).into(holder.imageViewFood);

        holder.imageViewFood.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), FoodDetailActivity.class);
        intent.putExtra("food", (Serializable) foods.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return foods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageViewFood;
        TextView textViewScoreFood,textViewTitle,textViewLocation,textViewPriceFood;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewFood = (ImageView) itemView.findViewById(R.id.imageViewFoodInCa);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewNameFoodInCa);
            textViewScoreFood = (TextView) itemView.findViewById(R.id.textViewScoreTour);
            textViewLocation = (TextView) itemView.findViewById(R.id.textViewPriceTour);
            textViewPriceFood = (TextView) itemView.findViewById(R.id.textViewPriceFoodInCa);
        }
    }
}
