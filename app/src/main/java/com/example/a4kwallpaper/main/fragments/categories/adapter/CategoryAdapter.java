package com.example.a4kwallpaper.main.fragments.categories.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.MainActivity;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder>
{
    MainActivity mainActivity;
    int[] catimg1;
    int[] catimg2;
    int[] catimg3;

    public CategoryAdapter(MainActivity mainActivity, int[] catimg1, int[] catimg2, int[] catimg3) {
        this.mainActivity = mainActivity;
        this.catimg1 = catimg1;
        this.catimg2 = catimg2;
        this.catimg3 = catimg3;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mainActivity).inflate(R.layout.item_category,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position)
    {
        holder.imageView1.setImageResource(catimg1[position]);
        holder.imageView2.setImageResource(catimg2[position]);
        holder.imageView3.setImageResource(catimg3[position]);
    }

    @Override
    public int getItemCount() {
        return 27;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView1,imageView2,imageView3;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView1 = itemView.findViewById(R.id.imageView1);
            imageView2 = itemView.findViewById(R.id.imageView2);
            imageView3 = itemView.findViewById(R.id.imageView3);
        }
    }
}

