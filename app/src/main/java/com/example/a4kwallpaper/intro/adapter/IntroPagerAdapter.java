package com.example.a4kwallpaper.intro.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.intro.IntroActivity;

public class IntroPagerAdapter extends PagerAdapter
{
    IntroActivity introActivity;

    public IntroPagerAdapter(IntroActivity introActivity) {
        this.introActivity = introActivity;
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

        View view = LayoutInflater.from(introActivity).inflate(R.layout.item_intro,container,false);
        container.addView(view);

        ImageView imageView = view.findViewById(R.id.ivMain);
        TextView title = view.findViewById(R.id.tvHeading);
        TextView desc = view.findViewById(R.id.tvDescription);

        if(position==0)
        {
            imageView.setImageResource(R.drawable.intro_bg_3);
            title.setText("4K Wallpaper");
            desc.setText("The Best Customization for your phone");
        }
        else if(position==1)
        {
            imageView.setImageResource(R.drawable.intro_bg_2);
            title.setText("4K Wallpaper");
            desc.setText("Exclusive Live Wallpapers");
        }
        else if (position==2)
        {
            imageView.setImageResource(R.drawable.intro_bg_1);
            title.setText("HD Wallpaper");
            desc.setText("Download and use all our\n" +
                    "Live Wallpapers");
        }

        return view;
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        View view = (View) object;
        container.removeView(view);
    }
}
