package com.example.a4kwallpaper.main.fragments.quotes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.FragmentLiveBinding;
import com.example.a4kwallpaper.databinding.FragmentQuotesBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

public class QuotesFragment extends Fragment {

    FragmentQuotesBinding binding;
    MainActivity mainActivity;

    public QuotesFragment(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentQuotesBinding.inflate(inflater,container,false);

        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.quotes);
        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
        binding.rvQuotes.setLayoutManager(manager1);
        binding.rvQuotes.setAdapter(allImageAdapter);

        return binding.getRoot();
    }
}