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

import com.anhvu.travelapp.place_activity.DetailActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.model.Domains;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class DomainAdapter extends RecyclerView.Adapter<DomainAdapter.ViewHolder> {

    ArrayList<Domains> domains;
    DecimalFormat decimalFormat;

    public DomainAdapter(ArrayList<Domains> domains) {
        this.domains = domains;
        decimalFormat = new DecimalFormat("###,###,###,###");
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_holder_domain,parent,false);
        return new DomainAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.textViewLocation.setText(domains.get(position).getLocation());
        holder.textViewScore.setText(domains.get(position).getScore()+"");
        holder.textViewTitle.setText(domains.get(position).getTitle());


        int drawableResourceId = holder.itemView.getResources()
                .getIdentifier(domains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId)
                .transform(new CenterCrop(),new GranularRoundedCorners(20,20,20,20)).into(holder.imageView);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
        intent.putExtra("domain",domains.get(position));
        holder.itemView.getContext().startActivity(intent);
    }
});

    }

    @Override
    public int getItemCount() {
        return domains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textViewScore,textViewTitle,textViewLocation;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewImgTour);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewNameTour);
            textViewScore = (TextView) itemView.findViewById(R.id.textViewScoreTour);
            textViewLocation = (TextView) itemView.findViewById(R.id.textViewPriceTour);
        }
    }
}
