package com.example.a4kwallpaper.main.fragments.home;

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
import com.example.a4kwallpaper.databinding.HomeFragmentBinding;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.main.fragments.home.adapter.AllImageAdapter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HomeFragment extends Fragment {

    HomeFragmentBinding binding;
    MainActivity mainActivity;
    private int targetScrollX;
    String filter;
    String order;
    private Call<CallbackWallpaper> callbackCall = null;

    public HomeFragment(MainActivity mainActivity, String filter, String order) {
        this.mainActivity=mainActivity;
        this.filter=filter;
        this.order=order;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = HomeFragmentBinding.inflate(inflater,container,false);

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
//                    binding.rvAllImages.setLayoutManager(manager1);
//                    binding.rvAllImages.setAdapter(allImageAdapter);
//                    binding.rvAllImages.setHasFixedSize(true);

                    AllImageAdapter adapter = new AllImageAdapter(mainActivity, imageArray, binding.shimmerLayout);
                    StaggeredGridLayoutManager lm = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
                    binding.rvAllImages.setLayoutManager(lm);
                    binding.rvAllImages.setItemAnimator(new DefaultItemAnimator());
                    binding.rvAllImages.setAdapter(adapter);



                } else {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }

            @Override
            public void onFailure(Call<CallbackWallpaper> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });



//        binding.Shimmer.setVisibility(View.VISIBLE);
//        binding.Shimmer.startShimmer();

//        //for left to right transaction
//
//        targetScrollX = 1650;
//        int animationDuration = 5000; // in milliseconds
//
//        ValueAnimator animator = ValueAnimator.ofInt(0, targetScrollX);
//        animator.setDuration(animationDuration);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator valueAnimator) {
//                int animatedValue = (int) valueAnimator.getAnimatedValue();
//                binding.horiScroll.smoothScrollTo(animatedValue, 0);
//            }
//        });
//
//        // Start the animation
//        animator.start();
//
//        runnable = new Runnable() {
//            @Override
//            public void run() {
//
//                targetScrollX = 0;
//                int animationDuration1 = 5000; // in milliseconds
//
//                ValueAnimator animator1 = ValueAnimator.ofInt(1650, targetScrollX);
//                animator1.setDuration(animationDuration1);
//                animator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                    @Override
//                    public void onAnimationUpdate(ValueAnimator valueAnimator1) {
//                        int animatedValue1 = (int) valueAnimator1.getAnimatedValue();
//                        binding.horiScroll.smoothScrollTo(animatedValue1, 0);
//                    }
//                });
//                // Start the animation
//                animator1.start();
//            }
//        };
//        Handler handler = new Handler();
//        handler.postDelayed(runnable,5000);

//        TagListAdapter tagListAdapter = new TagListAdapter(mainActivity, SplashScreenActivity.ApiTags,binding.tvTagName,binding.rvAllImages,binding.Shimmer);
//        RecyclerView.LayoutManager manager2 = new LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false);
//        binding.rvTagsList.setLayoutManager(manager2);
//        binding.rvTagsList.setAdapter(tagListAdapter);
//
//        StockCategoryAdapter stockCategoryAdapter = new StockCategoryAdapter(mainActivity, DataList.stockimage);
//        RecyclerView.LayoutManager manager = new LinearLayoutManager(mainActivity,RecyclerView.HORIZONTAL,false);
//        binding.rvStockCategory.setLayoutManager(manager);
//        binding.rvStockCategory.setAdapter(stockCategoryAdapter);

//        AllImageAdapter allImageAdapter = new AllImageAdapter(mainActivity, R.drawable.smily_image);
//        RecyclerView.LayoutManager manager1 = new GridLayoutManager(mainActivity,3);
//        binding.rvAllImages.setLayoutManager(manager1);
//        binding.rvAllImages.setAdapter(allImageAdapter);

        return binding.getRoot();

    }
}