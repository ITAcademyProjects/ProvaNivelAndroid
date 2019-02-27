package com.itacademy.restapiexample.rest;

import com.itacademy.restapiexample.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface MyService {
    @GET("posts/")
    Call<List<Post>> listPosts();

    @POST("posts/")
    Call<Post> savePost(@Body Post user);

}

