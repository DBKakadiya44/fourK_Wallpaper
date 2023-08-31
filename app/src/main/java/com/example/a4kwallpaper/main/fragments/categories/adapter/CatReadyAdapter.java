package com.example.a4kwallpaper.main.fragments.categories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.MainActivity;

public class CatReadyAdapter extends RecyclerView.Adapter<CatReadyAdapter.ViewHolder>
{
    MainActivity mainActivity;
    int[] categoryimage;

    public CatReadyAdapter(MainActivity mainActivity, int[] categoryimage) {
        this.mainActivity = mainActivity;
        this.categoryimage = categoryimage;
    }

    @NonNull
    @Override
    public CatReadyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_category_ready,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatReadyAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(categoryimage[position]);
    }

    @Override
    public int getItemCount() {
        return categoryimage.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivCategoryimage);
        }
    }
}
