package com.example.a4kwallpaper.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.a4kwallpaper.intro.IntroActivity;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.R;

public class SplashScreenActivity extends AppCompatActivity {

    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        runnable = new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this , IntroActivity.class);
                startActivity(intent);
            }
        };
        Handler handler = new Handler();
        handler.postDelayed(runnable,3000);

    }
}