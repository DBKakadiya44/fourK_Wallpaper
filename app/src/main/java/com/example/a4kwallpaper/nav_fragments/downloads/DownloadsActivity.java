package com.example.a4kwallpaper.nav_fragments.downloads;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.databinding.ActivityDownloadsBinding;
import com.example.a4kwallpaper.main.fragments.home.adapter.CategoryAllAdapter;
import com.example.a4kwallpaper.main.preview.PreviewActivity;

public class DownloadsActivity extends AppCompatActivity {

    ActivityDownloadsBinding binding;
    String[] imageArray = new String[PreviewActivity.Downloadimage.size()];
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

        if(PreviewActivity.Downloadimage.size()==0){
            binding.textView.setText("No Downloaded Wallpapers");
            binding.textView.setVisibility(View.VISIBLE);
        }else {
            binding.textView.setVisibility(View.INVISIBLE);
        }

        if(binding.textView.getText().equals("ABC")){
            binding.shimmerLayout.setVisibility(View.INVISIBLE);
            binding.shimmerLayout.stopShimmer();
        }else {
            binding.shimmerLayout.setVisibility(View.VISIBLE);
            binding.shimmerLayout.startShimmer();
        }

        for(int i=0; i< PreviewActivity.Downloadimage.size();i++){
            imageArray[i] = String.valueOf(PreviewActivity.Downloadimage.get(i));
        }

        binding.shimmerLayout.startShimmer();

        CategoryAllAdapter allImageAdapter = new CategoryAllAdapter(DownloadsActivity.this, imageArray, binding.shimmerLayout);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(DownloadsActivity.this, 3);
        binding.rvFavrite.setLayoutManager(manager1);
        binding.rvFavrite.setAdapter(allImageAdapter);
        binding.rvFavrite.setHasFixedSize(true);

    }
}