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

import com.anhvu.travelapp.place_activity.CategoryActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Category;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    ArrayList<Category> categories;

    public CategoryAdapter(ArrayList<Category> categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_category,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewTille.setText(categories.get(position).getTitle());
        int drawableResourceId = holder.itemView.getResources()
        .getIdentifier(categories.get(position).getPicPath(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageViewCate);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), CategoryActivity.class);
                intent.putExtra("idCategory",categories.get(position).getId());
                intent.putExtra("name",categories.get(position).getTitle());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTille;
        ImageView imageViewCate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTille = (TextView) itemView.findViewById(R.id.textViewCaFood) ;
            imageViewCate = (ImageView) itemView.findViewById(R.id.imageViewCaFood);
        }
    }
}
