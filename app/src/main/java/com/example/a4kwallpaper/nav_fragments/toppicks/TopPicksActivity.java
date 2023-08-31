package com.example.a4kwallpaper.nav_fragments.toppicks;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import com.example.a4kwallpaper.databinding.ActivityTopPicksBinding;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class TopPicksActivity extends AppCompatActivity {

    ActivityTopPicksBinding binding;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTopPicksBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        AllImageAdapter allImageAdapter = new AllImageAdapter(TopPicksActivity.this,100);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(TopPicksActivity.this,3);
        binding.rvTopPicks.setLayoutManager(manager1);
        binding.rvTopPicks.setAdapter(allImageAdapter);

    }
}