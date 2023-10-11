package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.preview.PreviewActivity;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.squareup.picasso.Picasso;

public class CategoryAllAdapter extends RecyclerView.Adapter<CategoryAllAdapter.ViewHolder> {
    Context context;
    String[] resp;
    ShimmerFrameLayout shimmerLayout;

    public CategoryAllAdapter(Context context, String[] resp, ShimmerFrameLayout shimmerLayout) {
        this.context = context;
        this.resp = resp;
        this.shimmerLayout=shimmerLayout;
    }

    @NonNull
    @Override
    public CategoryAllAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_mobile,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAllAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.with(context)
                .load(resp[position])
                .into(holder.imageView);

        if(holder.imageView != null){
            shimmerLayout.stopShimmer();
            shimmerLayout.setVisibility(View.INVISIBLE);
        }else {
            shimmerLayout.setVisibility(View.VISIBLE);
            shimmerLayout.startShimmer();
        }

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String img = resp[position];

                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("img",img);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return resp.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivmobile);
        }
    }
}
