package com.example.a4kwallpaper.main.fragments.live;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.api.CallbackWallpaper;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.databinding.FragmentLiveBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LiveFragment extends Fragment {

    FragmentLiveBinding binding;
    MainActivity mainActivity;
    String filter;
    String order;
    private Call<CallbackWallpaper> callbackCall = null;
    public LiveFragment(MainActivity mainActivity, String filter, String order) {
        this.mainActivity = mainActivity;
        this.filter=filter;
        this.order=order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLiveBinding.inflate(inflater,container,false);

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

//                    AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, imageArray, binding.shimmerLayout);
//                    RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity, 3);
//                    binding.rvLive.setLayoutManager(manager1);
//                    binding.rvLive.setAdapter(allImageAdapter);
//                    binding.rvLive.setHasFixedSize(true);

                    AllImageAdapter adapter = new AllImageAdapter(mainActivity, imageArray, binding.shimmerLayout);
                    StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    binding.rvLive.setLayoutManager(lm);
                    binding.rvLive.setItemAnimator(new DefaultItemAnimator());
                    binding.rvLive.setAdapter(adapter);

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