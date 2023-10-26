package com.virja.mimsapp.DATA;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface memeInterface {
    @GET("images/")
    Call<ArrayList<DataClass>> getMemes();
}
