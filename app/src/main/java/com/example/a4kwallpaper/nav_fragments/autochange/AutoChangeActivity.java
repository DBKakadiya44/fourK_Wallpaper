package com.example.a4kwallpaper.nav_fragments.autochange;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.ActivityAutoChangeBinding;
import com.example.a4kwallpaper.main.MainActivity;

public class AutoChangeActivity extends AppCompatActivity {

    ActivityAutoChangeBinding binding;
    int cnt=1;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAutoChangeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        clearall();
        selected(cnt);

        binding.t1.setOnClickListener(view -> {
            clearall();
            cnt=1;
            selected(cnt);
        });
        binding.t2.setOnClickListener(view -> {
            clearall();
            cnt=2;
            selected(cnt);
        });
        binding.t3.setOnClickListener(view -> {
            clearall();
            cnt=3;
            selected(cnt);
        });
        binding.t4.setOnClickListener(view -> {
            clearall();
            cnt=4;
            selected(cnt);
        });
        binding.t5.setOnClickListener(view -> {
            clearall();
            cnt=5;
            selected(cnt);
        });
        binding.t6.setOnClickListener(view -> {
            clearall();
            cnt=6;
            selected(cnt);
        });
        binding.t7.setOnClickListener(view -> {
            clearall();
            cnt=7;
            selected(cnt);
        });
        binding.t8.setOnClickListener(view -> {
            clearall();
            cnt=8;
            selected(cnt);
        });

        binding.tvApplyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AutoChangeActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void selected(int cnt)
    {
        if(cnt==1){
            binding.t1.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==2){
            binding.t2.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==3){
            binding.t3.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==4){
            binding.t4.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==5){
            binding.t5.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==6){
            binding.t6.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==7){
            binding.t7.setBackgroundResource(R.drawable.round_time_blue);
        }
        if(cnt==8){
            binding.t8.setBackgroundResource(R.drawable.round_time_blue);
        }
    }

    private void clearall()
    {
        binding.t1.setBackgroundResource(R.drawable.round_time_grey);
        binding.t2.setBackgroundResource(R.drawable.round_time_grey);
        binding.t3.setBackgroundResource(R.drawable.round_time_grey);
        binding.t4.setBackgroundResource(R.drawable.round_time_grey);
        binding.t5.setBackgroundResource(R.drawable.round_time_grey);
        binding.t6.setBackgroundResource(R.drawable.round_time_grey);
        binding.t7.setBackgroundResource(R.drawable.round_time_grey);
        binding.t8.setBackgroundResource(R.drawable.round_time_grey);
    }
}