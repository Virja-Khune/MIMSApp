package com.virja.mimsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.virja.mimsapp.DATA.DataClass;

import java.util.ArrayList;

public class memeAdapter extends RecyclerView.Adapter<memeAdapter.viewHolder> {
    ArrayList<DataClass>  data;
    Context context;

    public memeAdapter(ArrayList<DataClass> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.memelayout,parent,false);
        return new viewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Picasso.get()
               .load(data.get(position).getUrl())
                .into(holder.imageView);
       Log.d("dps" ,  data.get(position).getUrl());

    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView2);
        }
    }
}
