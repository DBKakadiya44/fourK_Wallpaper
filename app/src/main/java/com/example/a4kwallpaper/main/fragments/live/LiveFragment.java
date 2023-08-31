package com.example.a4kwallpaper.main.fragments.live;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentLiveBinding;
import com.example.a4kwallpaper.databinding.HomeFragmentBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class LiveFragment extends Fragment {

    FragmentLiveBinding binding;
    MainActivity mainActivity;

    public LiveFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLiveBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.live_image);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvLive.setLayoutManager(manager1);
        binding.rvLive.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}