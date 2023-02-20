package com.example.apinavigationdrawer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("/posts")
        // this is present in free api website url
    Call<List<ApiRecyModel>> getApiREcyModels();


}
