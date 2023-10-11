package com.example.a4kwallpaper.main.mobileimage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.api.CallbackWallpaper;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.databinding.ActivityMobileImageBinding;
import com.example.a4kwallpaper.main.fragments.home.adapter.NewAdAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MobileImageActivity extends AppCompatActivity {

    ActivityMobileImageBinding binding;
    private Call<CallbackWallpaper> callbackCall = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMobileImageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.shimmerLayout.startShimmer();

        String category = getIntent().getStringExtra("category");
        String name = getIntent().getStringExtra("name");

        binding.tvTagName.setText(name+" Wallpapers");

        Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

        callbackCall = apiInterface.getWallpapers(1,80,"both","recent",category);
        callbackCall.enqueue(new Callback<CallbackWallpaper>() {
            @Override
            public void onResponse(Call<CallbackWallpaper> call, Response<CallbackWallpaper> response) {
                if (response.isSuccessful()) {

                    CallbackWallpaper resp = response.body();

                    OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
                    onBackPressedDispatcher.onBackPressed();

//                    Log.d("QQQ", "onResponse: sucess = "+response.body().posts.get(0).image_upload);

                    String[] imageArray  = new String[resp.posts.size()];
                    for(int i=0;i<resp.posts.size();i++)
                    {
                        imageArray[i] = "https://wallapp.patoliyaitsolution.com/upload/"+resp.posts.get(i).image_upload;
                    }

//                    CategoryAllAdapter allImageAdapter = new CategoryAllAdapter(MobileImageActivity.this, imageArray, binding.shimmerLayout);
//                    RecyclerView.LayoutManager manager1 = new GridLayoutManager(MobileImageActivity.this, 3);
//                    binding.rvMobile.setLayoutManager(manager1);
//                    binding.rvMobile.setAdapter(allImageAdapter);
//                    binding.rvMobile.setHasFixedSize(true);

                    NewAdAdapter allImageAdapter = new NewAdAdapter(MobileImageActivity.this, imageArray, binding.shimmerLayout);
                    RecyclerView.LayoutManager manager1 = new GridLayoutManager(MobileImageActivity.this, 2);
                    binding.rvMobile.setLayoutManager(manager1);
                    binding.rvMobile.setAdapter(allImageAdapter);

                } else {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }
            @Override
            public void onFailure(Call<CallbackWallpaper> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.tvTitle.setText(""+name);

        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
        onBackPressedDispatcher.onBackPressed();
    }
}