package com.example.a4kwallpaper.main.fragments.categories;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.data.DataList;
import com.example.a4kwallpaper.databinding.FragmentCategoryBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.categories.adapter.CatReadyAdapter;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;
    MainActivity mainActivity;
    public CategoryFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);

        CatReadyAdapter adapter1 = new CatReadyAdapter(mainActivity, DataList.categoryimage);
        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(mainActivity);
        binding.rvCategory.setLayoutManager(manager1);
        binding.rvCategory.setAdapter(adapter1);

//        CategoryAdapter adapter = new CategoryAdapter(mainActivity, DataList.catimg1,DataList.catimg2,DataList.catimg3);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity);
//        binding.rvCategory.setLayoutManager(manager);
//        binding.rvCategory.setAdapter(adapter);

        return binding.getRoot();
    }
}