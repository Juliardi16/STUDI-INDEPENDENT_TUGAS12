package com.example.moviedb.rest;

import com.example.moviedb.model.UpResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieApi {
    @GET("movie/upcoming")
    Call<UpResponse>getMovieUpcoming(@Query("api_key")String apikey);
}
