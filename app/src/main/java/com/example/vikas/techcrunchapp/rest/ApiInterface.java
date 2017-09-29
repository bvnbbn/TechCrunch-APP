package com.example.vikas.techcrunchapp.rest;

/**
 * Created by vikas on 29/9/17.
 */

import com.example.vikas.techcrunchapp.model.PostsResponse;
import com.example.vikas.techcrunchapp.model.SelecetdPost;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("techcrunch.com/posts/")
    Call<PostsResponse> getNewPosts();

    @GET("techcrunch.com/posts/{id}")
    Call<SelecetdPost> getPostDetails(@Path("id") int id);

   /* @GET("movie/{id}/videos")
    Call<Movie> getMovieVideo(@Path("id") int id, @Query("api_key") String apiKey);*/


}