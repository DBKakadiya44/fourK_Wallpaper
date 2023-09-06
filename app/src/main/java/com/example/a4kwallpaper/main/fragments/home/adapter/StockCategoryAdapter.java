package com.example.a4kwallpaper.main.fragments.home.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.api.api_InterFace;
import com.example.a4kwallpaper.data.CallbackCategory;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.main.MainActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StockCategoryAdapter extends RecyclerView.Adapter<StockCategoryAdapter.ViewHolder>
{
    MainActivity mainActivity;
    int[] stockimage;
    private Call<CallbackCategory> callbackCall = null;

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
    public void onBindViewHolder(@NonNull StockCategoryAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.imageView.setImageResource(stockimage[position]);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requestCategoriesApi();

                api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");
                callbackCall = apiInterface.getCategories();
                callbackCall.enqueue(new Callback<CallbackCategory>() {
                    @Override
                    public void onResponse(@NonNull Call<CallbackCategory> call, @NonNull Response<CallbackCategory> response) {
                        CallbackCategory resp = response.body();
                        //Log.d("QQQ", "onResponse: api = "+resp.categories.get(position).category_image);

                        holder.imageView.setImageResource(Integer.parseInt(resp.categories.get(position).category_image));

//                        Picasso.with(mainActivity)
//                                .load(String.valueOf(resp.categories.get(position).category_image))
//                                .into(holder.imageView);

                    }
                    @Override
                    public void onFailure(@NonNull Call<CallbackCategory> call, @NonNull Throwable t) {

                    }
                });
            }
        });
    }

    private void requestCategoriesApi() {

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
