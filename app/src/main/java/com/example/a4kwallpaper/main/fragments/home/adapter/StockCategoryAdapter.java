package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.MainActivity;

public class StockCategoryAdapter extends RecyclerView.Adapter<StockCategoryAdapter.ViewHolder>
{
    MainActivity mainActivity;
    int[] stockimage;

    public StockCategoryAdapter(MainActivity mainActivity, int[] stockimage) {
        this.mainActivity = mainActivity;
        this.stockimage = stockimage;
    }

    @NonNull
    @Override
    public StockCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mainActivity).inflate(R.layout.item_stock_category,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StockCategoryAdapter.ViewHolder holder, int position) {
        holder.imageView.setImageResource(stockimage[position]);
    }

    @Override
    public int getItemCount() {
        return stockimage.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.ivStockImage);
        }
    }
}
