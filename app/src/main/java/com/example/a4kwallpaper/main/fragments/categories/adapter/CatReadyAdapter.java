package com.example.a4kwallpaper.main.fragments.categories.adapter;

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
import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.data.CallbackCategory;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.mobileimage.MobileImageActivity;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CatReadyAdapter extends RecyclerView.Adapter<CatReadyAdapter.ViewHolder>
{
    MainActivity mainActivity;
    String[] imageArray;

    private Call<CallbackCategory> callbackCall = null;
    CallbackCategory resp;

    public CatReadyAdapter(MainActivity mainActivity, String[] imageArray) {
        this.mainActivity = mainActivity;
        this.imageArray=imageArray;
    }

    @NonNull
    @Override
    public CatReadyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_category_ready,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatReadyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.with(mainActivity)
                .load(imageArray[position])
                .into(holder.imageView);

        Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

        callbackCall = apiInterface.getCategories();

        callbackCall.enqueue(new Callback<CallbackCategory>() {
            @Override
            public void onResponse(Call<CallbackCategory> call, Response<CallbackCategory> response) {
                if (response.isSuccessful()) {

                    resp = response.body();

                    //Log.d("QQQ", "onResponse: categori  = "+resp.categories.get(position).);

                } else {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }

            @Override
            public void onFailure(Call<CallbackCategory> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String category = resp.categories.get(position).category_id;
                String name = resp.categories.get(position).category_name;

                Intent intent = new Intent(mainActivity , MobileImageActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("category",category);
                mainActivity.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return imageArray.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivCategoryimage);
        }
    }
}
