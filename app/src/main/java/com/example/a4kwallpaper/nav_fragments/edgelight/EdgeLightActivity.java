package com.example.a4kwallpaper.nav_fragments.edgelight;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.a4kwallpaper.databinding.ActivityEdgeLightBinding;
import com.example.a4kwallpaper.main.MainActivity;

public class EdgeLightActivity extends AppCompatActivity {
    ActivityEdgeLightBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEdgeLightBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.tvSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EdgeLightActivity.this , MainActivity.class);
                startActivity(intent);
            }
        });

    }
}