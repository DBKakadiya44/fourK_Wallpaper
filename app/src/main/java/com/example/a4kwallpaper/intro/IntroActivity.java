package com.example.a4kwallpaper.intro;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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

        binding.viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    binding.ivdot1.setBackgroundResource(R.drawable.dark_bule_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.blue_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.blue_dot);
                }
                if (position == 1) {
                    binding.ivdot1.setBackgroundResource(R.drawable.blue_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.dark_bule_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.blue_dot);
                }
                if (position == 2) {
                    binding.ivdot1.setBackgroundResource(R.drawable.blue_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.blue_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.dark_bule_dot);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
            }
        });


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