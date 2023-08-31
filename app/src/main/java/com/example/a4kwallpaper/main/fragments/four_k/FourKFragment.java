package com.example.a4kwallpaper.main.fragments.four_k;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentFourKBinding;
import com.example.a4kwallpaper.databinding.FragmentLiveBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class FourKFragment extends Fragment {

    FragmentFourKBinding binding;
    MainActivity mainActivity;

    public FourKFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentFourKBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.fourk);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvFourK.setLayoutManager(manager1);
        binding.rvFourK.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}