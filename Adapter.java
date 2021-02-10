package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private Context context;
    private List<profileDetails> data;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater=LayoutInflater.from(context);
        v=inflater.inflate(R.layout.profile_item,parent,false);
        return new MyViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(data.get(position).getName());
        holder.email.setText(data.get(position).getEmail());
        Glide.with(context)
                .load(data.get(position).getImageUrl())
                .into(holder.img);




    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        TextView email;
        ImageView img;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name= itemView.findViewById(R.id.name);
            email= itemView.findViewById(R.id.email);
            img= itemView.findViewById(R.id.image);

        }
    }


}
