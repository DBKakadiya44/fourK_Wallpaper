package com.example.a4kwallpaper.api;

import com.example.a4kwallpaper.data.CallbackCategory;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api_InterFace
{

    @GET("api.php?get_new_wallpapers")
    Call<CallbackWallpaper> getWallpapers(
            @Query("page") int page,
            @Query("count") int count,
            @Query("filter") String filter,
            @Query("order") String order,
            @Query("category") String category
    );

    @GET("api.php?get_wallpaper_details")
    Call<CallbackWallpaper> getWallpaperDetails(
            @Query("id") String id
    );

    @GET("api.php?get_settings")
    Call<CallbackSettings> getSettings(
            @Query("package_name") String package_name
    );

    @GET("api.php?get_categories")
    Call<CallbackCategory> getCategories();

    @FormUrlEncoded
    @POST("api.php?update_view")
    Call<Wallpaper> updateView(
            @Field("image_id") String image_id
    );

    @FormUrlEncoded
    @POST("api.php?update_download")
    Call<Wallpaper> updateDownload(
            @Field("image_id") String image_id
    );

}
