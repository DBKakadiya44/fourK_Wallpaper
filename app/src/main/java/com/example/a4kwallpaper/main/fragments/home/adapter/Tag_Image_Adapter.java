package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Tag_Image_Adapter extends RecyclerView.Adapter<Tag_Image_Adapter.ViewHolder> {
    MainActivity mainActivity;
    ArrayList image;


    public Tag_Image_Adapter(MainActivity mainActivity, ArrayList image) {
        this.mainActivity = mainActivity;
        this.image = image;
    }

    @NonNull
    @Override
    public Tag_Image_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_images,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Tag_Image_Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

        Picasso.with(mainActivity)
                .load(String.valueOf(image.get(position)))
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return image.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivImages);
        }
    }
}
