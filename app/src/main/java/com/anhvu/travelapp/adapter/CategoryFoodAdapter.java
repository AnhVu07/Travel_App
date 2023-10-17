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

import com.anhvu.travelapp.food_activity.FillFoodActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.CategoryFood;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.util.ArrayList;

public class CategoryFoodAdapter extends RecyclerView.Adapter<CategoryFoodAdapter.ViewHolder> {

    ArrayList<CategoryFood> categoryFoods;

    public CategoryFoodAdapter(ArrayList<CategoryFood> categoryFoods) {
        this.categoryFoods = categoryFoods;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category_food,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(categoryFoods.get(position).getName());
        int drawableResourceId = holder.itemView.getResources()
        .getIdentifier(categoryFoods.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(50,50,50,50)).into(holder.imageViewCaFood);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), FillFoodActivity.class);
                intent.putExtra("FoodCategory",categoryFoods.get(position));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryFoods.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        ImageView imageViewCaFood;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTille = (TextView) itemView.findViewById(R.id.textViewCaFood) ;
            imageViewCaFood = (ImageView) itemView.findViewById(R.id.imageViewCaFood);
        }
    }
}
