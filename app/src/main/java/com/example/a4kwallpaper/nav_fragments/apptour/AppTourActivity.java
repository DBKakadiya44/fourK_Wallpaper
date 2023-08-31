package com.example.a4kwallpaper.nav_fragments.apptour;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.ActivityAppTourBinding;
import com.example.a4kwallpaper.nav_fragments.apptour.adapter.AppTourAdapter;

public class AppTourActivity extends AppCompatActivity {
    ActivityAppTourBinding binding;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAppTourBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        AppTourAdapter pagerAdapter = new AppTourAdapter(AppTourActivity.this);
        binding.vpAppTour.setAdapter(pagerAdapter);

        binding.vpAppTour.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    binding.ivdot1.setBackgroundResource(R.drawable.dark_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.light_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.light_dot);
                }
                if (position == 1) {
                    binding.ivdot1.setBackgroundResource(R.drawable.light_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.dark_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.light_dot);
                }
                if (position == 2) {
                    binding.ivdot1.setBackgroundResource(R.drawable.light_dot);
                    binding.ivdot2.setBackgroundResource(R.drawable.light_dot);
                    binding.ivdot3.setBackgroundResource(R.drawable.dark_dot);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state)
            {
            }
        });
    }
}