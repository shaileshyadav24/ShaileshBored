package com.example.shaileshbored.network;

import com.example.shaileshbored.model.Bored;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL = "https://www.boredapi.com/api/activity/";

    @GET(".")
    Call<Bored> retrieveResponse();
}
