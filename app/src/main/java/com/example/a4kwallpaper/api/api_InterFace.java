package com.example.a4kwallpaper.api;

import com.example.a4kwallpaper.data.CallbackCategory;

import retrofit2.Call;
import retrofit2.http.GET;

public interface api_InterFace
{
    @GET("api.php?get_categories")
    Call<CallbackCategory> getCategories();



}
