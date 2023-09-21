package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.api.CallbackWallpaper;
import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.mobileimage.MobileImageActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockCategoryAdapter extends RecyclerView.Adapter<StockCategoryAdapter.ViewHolder>
{
    MainActivity mainActivity;
    int[] stockimage;
    String[] image = new String[5];
    private Call<CallbackWallpaper> callbackCall = null;

    public StockCategoryAdapter(MainActivity mainActivity, int[] stockimage) {
        this.mainActivity = mainActivity;
        this.stockimage = stockimage;
    }

    @NonNull
    @Override
    public StockCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_stock_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockCategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(stockimage[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCategoriesApi();

                Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

                if(position==0){
                    callbackCall = apiInterface.getWallpapers(1, 6, "both", "recent", "2");
                }
                if(position==1){
                    callbackCall = apiInterface.getWallpapers(1, 6, "both", "recent", "3");
                }
                if(position==2){
                    callbackCall = apiInterface.getWallpapers(1, 6, "both", "recent", "1");
                }
                if(position==3){
                    callbackCall = apiInterface.getWallpapers(1, 6, "both", "recent", "5");
                }
                if(position==4){
                    callbackCall = apiInterface.getWallpapers(1, 6, "both", "recent", "4");
                }

                callbackCall.enqueue(new Callback<CallbackWallpaper>() {
                    @Override
                    public void onResponse(@NonNull Call<CallbackWallpaper> call, @NonNull Response<CallbackWallpaper> response) {
                        CallbackWallpaper resp = response.body();

//                        Log.d("QQQ", "onResponse: api = "+resp.posts);

//                        Picasso.with(mainActivity)
//                                .load("https://wallapp.patoliyaitsolution.com/category/"+resp.categories.get(position).category_image)
//                                .into(holder.imageView);

                        image[0] = resp.posts.get(0).image_upload;
                        image[1] = resp.posts.get(1).image_upload;
                        image[2] = resp.posts.get(2).image_upload;
                        image[3] = resp.posts.get(3).image_upload;
                        image[4] = resp.posts.get(4).image_upload;

                        Log.d("QQQ", "onResponse: array = "+image[position]);

                            Intent intent = new Intent(mainActivity, MobileImageActivity.class);
                            intent.putExtra("image",image);
                            mainActivity.startActivity(intent);

                    }
                    @Override
                    public void onFailure(@NonNull Call<CallbackWallpaper> call, @NonNull Throwable t) {

                    }
                });
            }
        });
    }

    private void requestCategoriesApi() {

    }

    @Override
    public int getItemCount() {
        return stockimage.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivStockImage);
        }
    }
}
