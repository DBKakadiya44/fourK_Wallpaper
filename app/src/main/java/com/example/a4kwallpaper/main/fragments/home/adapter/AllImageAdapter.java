package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.databinding.ItemImagesBinding;
import com.example.a4kwallpaper.databinding.NativeAdLoadBinding;
import com.example.a4kwallpaper.main.preview.PreviewActivity;
import com.example.a4kwallpaper.nativead.NativeAds;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.nativead.NativeAd;
import com.squareup.picasso.Picasso;

public class AllImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    Context context;
    String[] image;
    ShimmerFrameLayout shimmerLayout;
    private static int ITEM_VIEW = 1;
    private static int AD_VIEW = 2;
    private static int ITEM_FEED_COUNT = 7;

    public AllImageAdapter(Context context, String[] image, ShimmerFrameLayout shimmerLayout) {
        this.context = context;
        this.image = image;
        this.shimmerLayout=shimmerLayout;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (viewType == ITEM_VIEW) {
            view = layoutInflater.inflate(R.layout.item_images, parent, false);
            return new MainViewHolder(view);
        } else if (viewType == AD_VIEW) {
            view = layoutInflater.inflate(R.layout.native_ad_load, parent, false);

            final ViewGroup.LayoutParams lp = view.getLayoutParams();
            if (lp instanceof StaggeredGridLayoutManager.LayoutParams) {
                StaggeredGridLayoutManager.LayoutParams sglp = (StaggeredGridLayoutManager.LayoutParams) lp;
                sglp.setFullSpan(true);
            }
            return new AdsViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder.getItemViewType() == ITEM_VIEW) {
            ((MainViewHolder) holder).bindData(image, position);

        } else if (holder.getItemViewType() == AD_VIEW) {
            ((AdsViewHolder) holder).bindAdData();
        }
    }

    @Override
    public int getItemViewType(int position) {

        if ((position + 1) % ITEM_FEED_COUNT == 0) {
            return AD_VIEW;
        } else {
            return ITEM_VIEW;
        }
    }

    @Override
    public int getItemCount() {
        return image.length;
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {

        ItemImagesBinding binding;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemImagesBinding.bind(itemView);
        }

        private void bindData(String[] image, int position) {
            Picasso.with(context)
                .load(image[position])
                .into(binding.ivImages);

        if(binding.ivImages != null){
            shimmerLayout.stopShimmer();
            shimmerLayout.setVisibility(View.INVISIBLE);
        }else {
            shimmerLayout.setVisibility(View.VISIBLE);
            shimmerLayout.startShimmer();
        }

        binding.ivImages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("img",image[position]);
                context.startActivity(intent);
            }
        });
        }
    }

    public class AdsViewHolder extends RecyclerView.ViewHolder {
        NativeAdLoadBinding binding;
        public AdsViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = NativeAdLoadBinding.bind(itemView);
        }
        private void bindAdData() {
            AdLoader.Builder builder = new AdLoader.Builder(context, "/6499/example/native").forNativeAd(new NativeAd.OnNativeAdLoadedListener() {
                @Override
                public void onNativeAdLoaded(@NonNull NativeAd nativeAd) {
                    NativeAds.refreshAd(context, binding.adsFrame);
                }
            });
            AdLoader adLoader = builder.withAdListener(new AdListener() {
                @Override
                public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                    super.onAdFailedToLoad(loadAdError);
                    NativeAds.refreshAd(context, binding.adsFrame);
                }
            }).build();
            adLoader.loadAd(new AdRequest.Builder().build());
        }
    }
}