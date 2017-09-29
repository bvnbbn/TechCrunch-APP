package com.example.vikas.techcrunchapp.rest;

/**
 * Created by vikas on 29/9/17.
 */

import com.example.vikas.techcrunchapp.model.PostsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("techcrunch.com/posts/")
    Call<PostsResponse> getNewPosts();
/*
    @GET("movie/{id}")
    Call<Movie> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);

    @GET("movie/{id}/videos")
    Call<Movie> getMovieVideo(@Path("id") int id, @Query("api_key") String apiKey);*/


}