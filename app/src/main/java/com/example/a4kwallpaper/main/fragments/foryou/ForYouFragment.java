package com.example.a4kwallpaper.main.fragments.foryou;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentForYouBinding;
import com.example.a4kwallpaper.databinding.FragmentFourKBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class ForYouFragment extends Fragment {

    FragmentForYouBinding binding;
    MainActivity mainActivity;

    public ForYouFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentForYouBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.for_you);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvForYou.setLayoutManager(manager1);
        binding.rvForYou.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}