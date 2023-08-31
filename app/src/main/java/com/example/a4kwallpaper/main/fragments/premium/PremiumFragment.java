package com.example.a4kwallpaper.main.fragments.premium;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentPremiumBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class PremiumFragment extends Fragment {

    FragmentPremiumBinding binding;
    MainActivity mainActivity;

    public PremiumFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPremiumBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.premium_image);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvPremium.setLayoutManager(manager1);
        binding.rvPremium.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}