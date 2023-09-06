package com.example.a4kwallpaper.main.fragments.home;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.data.DataList;
import com.example.a4kwallpaper.databinding.HomeFragmentBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;
import com.example.a4kwallpaper.main.fragments.home.adapter.StockCategoryAdapter;


public class HomeFragment extends Fragment {

    HomeFragmentBinding binding;
    MainActivity mainActivity;
    private int targetScrollX;
    public HomeFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater,container,false);

        //for left to right transaction

        targetScrollX = 1650;
        int animationDuration = 10000; // in milliseconds

        ValueAnimator animator = ValueAnimator.ofInt(0, targetScrollX);
        animator.setDuration(animationDuration);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int animatedValue = (int) valueAnimator.getAnimatedValue();
                binding.horiScroll.smoothScrollTo(animatedValue, 0);
            }
        });

        // Start the animation
        animator.start();

        StockCategoryAdapter stockCategoryAdapter = new StockCategoryAdapter(mainActivity, DataList.stockimage);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false);
        binding.rvStockCategory.setLayoutManager(manager);
        binding.rvStockCategory.setAdapter(stockCategoryAdapter);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.smily_image);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvAllImages.setLayoutManager(manager1);
        binding.rvAllImages.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}