package com.example.a4kwallpaper.nav_fragments.downloads;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import com.example.a4kwallpaper.databinding.ActivityDownloadsBinding;
public class DownloadsActivity extends AppCompatActivity {

    ActivityDownloadsBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDownloadsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


    }
}