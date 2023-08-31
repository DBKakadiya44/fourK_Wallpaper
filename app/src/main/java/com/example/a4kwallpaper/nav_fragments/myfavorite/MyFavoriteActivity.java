package com.example.a4kwallpaper.nav_fragments.myfavorite;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.a4kwallpaper.databinding.ActivityMyFavoriteBinding;

public class MyFavoriteActivity extends AppCompatActivity {

    ActivityMyFavoriteBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMyFavoriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}