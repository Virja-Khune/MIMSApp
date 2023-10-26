package com.virja.mimsapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.virja.mimsapp.DATA.DataClass;
import com.virja.mimsapp.DATA.memeInterface;
import com.virja.mimsapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

        ActivityMainBinding binding;
        Context context;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            //setContentView(R.layout.activity_main);
            binding = ActivityMainBinding.inflate(getLayoutInflater());
            setContentView(binding.getRoot());
            context = this;
            RecyclerView recyclerView = binding.recyclerview;
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(
                    this, LinearLayoutManager.VERTICAL, false
            );
            recyclerView.setLayoutManager(linearLayoutManager);

            //code for retrofit

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://api.memegen.link/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            memeInterface inter = retrofit.create(memeInterface.class);
            try {
                Call<ArrayList<DataClass>> data = inter.getMemes();

                data.enqueue(new Callback<ArrayList<DataClass>>() {
                    @Override
                    public void onResponse(Call<ArrayList<DataClass>> call, Response<ArrayList<DataClass>> response) {
                        Log.d("dps", response.body().get(0).getUrl());
                        RecyclerView.Adapter adapter = new memeAdapter(response.body(), context);

                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<ArrayList<DataClass>> call, Throwable t) {
                        Log.e("dps", "onFailure: " );
                    }
                });



            } catch (Exception e) {
                e.printStackTrace();
            }


        }

}