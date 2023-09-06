package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.data.DataList;
import com.example.a4kwallpaper.main.preview.PreviewActivity;

public class AllImageAdapter extends RecyclerView.Adapter<AllImageAdapter.ImageHolder>
{
    Context context;
    int image;

    public AllImageAdapter(Context context, int image) {
        this.context = context;
        this.image = image;
    }

    @NonNull
    @Override
    public AllImageAdapter.ImageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_images,parent,false);
        ImageHolder holder = new ImageHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AllImageAdapter.ImageHolder holder, int position) {

        if(image == 100){
            holder.imageView.setImageResource(DataList.catimg1[position]);
        }
        else {
            holder.imageView.setImageResource(image);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PreviewActivity.class);
                intent.putExtra("image",image);
                context.startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return 12;
    }
    public class ImageHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ImageHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.ivImages);
        }
    }
}
