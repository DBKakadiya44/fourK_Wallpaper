package com.example.a4kwallpaper.main.preview;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.a4kwallpaper.databinding.ActivityPreviewBinding;

public class PreviewActivity extends AppCompatActivity {

    ActivityPreviewBinding binding;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        image= getIntent().getIntExtra("image",0);

        binding.ivPreviewFullImage.setImageResource(image);

    }
}