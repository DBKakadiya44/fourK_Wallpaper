package com.example.a4kwallpaper.main.fragments.categories;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.data.CallbackCategory;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.databinding.FragmentCategoryBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.categories.adapter.CatReadyAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;
    MainActivity mainActivity;

    private Call<CallbackCategory> callbackCall = null;

    public CategoryFragment(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCategoryBinding.inflate(inflater,container,false);

        Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

        callbackCall = apiInterface.getCategories();

        callbackCall.enqueue(new Callback<CallbackCategory>() {
            @Override
            public void onResponse(Call<CallbackCategory> call, Response<CallbackCategory> response) {
                if (response.isSuccessful()) {

                    CallbackCategory resp = response.body();

                    Log.d("AAA", "onResponse: categori  = "+response.raw());

                    String[] imageArray  = new String[resp.categories.size()];
                    for(int i=0;i<resp.categories.size();i++)
                    {
                        imageArray[i] = "https://wallapp.patoliyaitsolution.com/upload/category/"+resp.categories.get(i).category_image;
                    }

                    CatReadyAdapter allImageAdapter = new CatReadyAdapter(mainActivity, imageArray);
                    RecyclerView.LayoutManager manager1 = new LinearLayoutManager(mainActivity);
                    binding.rvCategory.setLayoutManager(manager1);
                    binding.rvCategory.setAdapter(allImageAdapter);


                } else {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }

            @Override
            public void onFailure(Call<CallbackCategory> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });







//        CatReadyAdapter adapter1 = new CatReadyAdapter(mainActivity, DataList.categoryimage);
//        RecyclerView.LayoutManager manager1 = new LinearLayoutManager(mainActivity);
//        binding.rvCategory.setLayoutManager(manager1);
//        binding.rvCategory.setAdapter(adapter1);

//        CategoryAdapter adapter = new CategoryAdapter(mainActivity, DataList.catimg1,DataList.catimg2,DataList.catimg3);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity);
//        binding.rvCategory.setLayoutManager(manager);
//        binding.rvCategory.setAdapter(adapter);

        return binding.getRoot();
    }
}