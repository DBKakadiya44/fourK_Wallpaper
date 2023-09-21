package com.example.a4kwallpaper.nav_fragments.myfavorite;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a4kwallpaper.databinding.ActivityMyFavoriteBinding;
import com.example.a4kwallpaper.main.fragments.home.adapter.CategoryAllAdapter;
import com.example.a4kwallpaper.main.preview.PreviewActivity;

public class MyFavoriteActivity extends AppCompatActivity {

    ActivityMyFavoriteBinding binding;

    String[] imageArray = new String[PreviewActivity.Favimage.size()];
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

        if(PreviewActivity.Favimage.size()==0){
            binding.textView.setText("No Favourite Wallpapers");
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

        for(int i=0; i< PreviewActivity.Favimage.size();i++){
            imageArray[i] = String.valueOf(PreviewActivity.Favimage.get(i));
        }

        binding.shimmerLayout.startShimmer();

        CategoryAllAdapter allImageAdapter = new CategoryAllAdapter(MyFavoriteActivity.this, imageArray, binding.shimmerLayout);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(MyFavoriteActivity.this, 3);
        binding.rvFavrite.setLayoutManager(manager1);
        binding.rvFavrite.setAdapter(allImageAdapter);
        binding.rvFavrite.setHasFixedSize(true);




//        if(!PreviewActivity.Favimage.equals(null)){
//            Toast.makeText(this, "Not Null", Toast.LENGTH_SHORT).show();
//
//            Picasso.with(MyFavoriteActivity.this)
//                    .load((String) PreviewActivity.Favimage.get(1))
//                    .into(binding.ivImage);
//
//        }

    }
}