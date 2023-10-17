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

import com.anhvu.travelapp.car_activity.CarSearchActivity;
import com.anhvu.travelapp.cruise_activity.CruiseSearchActivity;
import com.anhvu.travelapp.food_activity.FoodSearchActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.hotel_activity.ServiceActivity;
import com.anhvu.travelapp.tour_activity.TourActivity;
import com.anhvu.travelapp.model.ServiceCategory;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ServiceAdapter extends RecyclerView.Adapter<ServiceAdapter.ViewHolder> {

    ArrayList<ServiceCategory> services;

    public ServiceAdapter(ArrayList<ServiceCategory> services) {
        this.services = services;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_service,parent,false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewNameService.setText(services.get(position).getName());
        int drawableResourceId = holder.itemView.getResources()
        .getIdentifier(services.get(position).getPicture(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.imageViewService);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String choose = services.get(position).getName();
                Intent intent;
                switch (choose){
                    case "Hotel":
                        intent = new Intent(holder.itemView.getContext(), ServiceActivity.class);
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    case "Food":
                        intent = new Intent(holder.itemView.getContext(), FoodSearchActivity.class);
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    case "Tour":
                        intent = new Intent(holder.itemView.getContext(), TourActivity.class);
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    case "Move":
                        intent = new Intent(holder.itemView.getContext(), CarSearchActivity.class);
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    case "Yacht":
                        intent = new Intent(holder.itemView.getContext(), CruiseSearchActivity.class);
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;
                    default :
                        intent = new Intent(holder.itemView.getContext(), ServiceActivity.class);
                        intent.putExtra("idService",services.get(position).getId());
                        intent.putExtra("nameService",services.get(position).getName());
                        holder.itemView.getContext().startActivity(intent);
                        break;


                }


            }
        });
    }

    @Override
    public int getItemCount() {
        return services.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewNameService;
        ImageView imageViewService;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNameService = (TextView) itemView.findViewById(R.id.textViewService) ;
            imageViewService = (ImageView) itemView.findViewById(R.id.imageViewService);
        }
    }
}
