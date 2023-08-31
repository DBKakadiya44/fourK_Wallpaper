package com.example.a4kwallpaper.intro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.ActivityIntroBinding;
import com.example.a4kwallpaper.intro.adapter.IntroPagerAdapter;
import com.example.a4kwallpaper.main.MainActivity;

public class IntroActivity extends AppCompatActivity {

    ActivityIntroBinding binding;
    int position =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityIntroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        IntroPagerAdapter pagerAdapter = new IntroPagerAdapter(IntroActivity.this);
        binding.viewPager.setAdapter(pagerAdapter);


        binding.ivnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = binding.viewPager.getCurrentItem();
                position++;
                binding.viewPager.setCurrentItem(position);
                if(position==3){
                    Intent intent = new Intent(IntroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}