package com.example.a4kwallpaper.nav_fragments.apptour.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.main.MainActivity;
import com.example.a4kwallpaper.nav_fragments.apptour.AppTourActivity;

public class AppTourAdapter extends PagerAdapter
{
    AppTourActivity appTourActivity;
    public AppTourAdapter(AppTourActivity appTourActivity)
    {
        this.appTourActivity=appTourActivity;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        View view = LayoutInflater.from(appTourActivity).inflate(R.layout.item_app_tour,container,false);
        container.addView(view);

        ImageView imageView = view.findViewById(R.id.ivapptoup);
        TextView title = view.findViewById(R.id.tvtitle);
        TextView desc = view.findViewById(R.id.tvDescription);
        TextView ok = view.findViewById(R.id.tvOK);

        if(position==0)
        {
            imageView.setImageResource(R.drawable.app_tour3);
            title.setText("4K Wallpaper");
            desc.setText("Cool Wallpaper are designed to fit your android mobile devices");
        }
        if(position==1)
        {
            imageView.setImageResource(R.drawable.app_tour2);
            title.setText("Live Wallpaper");
            desc.setText("Imagine having cool video effect as background on your home screen");
        }
        if (position==2)
        {
            ok.setVisibility(View.VISIBLE);
            ok.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(appTourActivity, MainActivity.class);
                    appTourActivity.startActivity(intent);
                }
            });
            imageView.setImageResource(R.drawable.app_tour1);
            title.setText("Category");
            desc.setText("Best 4K wallpaper across 31+ different categories");
        }
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }

}
