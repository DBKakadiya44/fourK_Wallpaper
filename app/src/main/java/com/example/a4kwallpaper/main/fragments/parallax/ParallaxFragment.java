package com.example.a4kwallpaper.main.fragments.parallax;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentLiveBinding;
import com.example.a4kwallpaper.databinding.FragmentParallaxBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;


public class ParallaxFragment extends Fragment {

    FragmentParallaxBinding binding;
    MainActivity mainActivity;

    public ParallaxFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentParallaxBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.parallax);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rv3D.setLayoutManager(manager1);
        binding.rv3D.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}