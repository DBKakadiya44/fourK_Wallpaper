package com.example.a4kwallpaper.main.fragments.premium;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.api.CallbackWallpaper;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.databinding.FragmentPremiumBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.NewAdAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PremiumFragment extends Fragment {

    FragmentPremiumBinding binding;
    MainActivity mainActivity;
    String filter;
    String order;
    private Call<CallbackWallpaper> callbackCall = null;
    public PremiumFragment(MainActivity mainActivity, String filter, String order) {
        this.mainActivity = mainActivity;
        this.filter=filter;
        this.order=order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPremiumBinding.inflate(inflater,container,false);

        binding.shimmerLayout.setVisibility(View.VISIBLE);
        binding.shimmerLayout.startShimmer();

        Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

        callbackCall = apiInterface.getWallpapers(1,50,filter,order,"0");

        callbackCall.enqueue(new Callback<CallbackWallpaper>() {
            @Override
            public void onResponse(Call<CallbackWallpaper> call, Response<CallbackWallpaper> response) {
                if (response.isSuccessful()) {

                    CallbackWallpaper resp = response.body();

//                    Log.d("QQQ", "onResponse: sucess = "+response.body().posts.get(0).image_upload);

                    String[] imageArray  = new String[resp.posts.size()];
                    for(int i=0;i<resp.posts.size();i++)
                    {
                        imageArray[i] = "https://wallapp.patoliyaitsolution.com/upload/"+resp.posts.get(i).image_upload;
                    }

                    NewAdAdapter allImageAdapter = new NewAdAdapter(mainActivity, imageArray, binding.shimmerLayout);
                    RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity, 2);
                    binding.rvPremium.setLayoutManager(manager1);
                    binding.rvPremium.setAdapter(allImageAdapter);

//                    AllImageAdapter adapter = new AllImageAdapter(mainActivity, imageArray, binding.shimmerLayout);
//                    StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
//                    binding.rvPremium.setLayoutManager(lm);
//                    binding.rvPremium.setItemAnimator(new DefaultItemAnimator());
//                    binding.rvPremium.setAdapter(adapter);

                } else {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }

            @Override
            public void onFailure(Call<CallbackWallpaper> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });

        return binding.getRoot();
    }
}