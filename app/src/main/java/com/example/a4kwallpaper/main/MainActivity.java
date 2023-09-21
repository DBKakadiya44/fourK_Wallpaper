package com.example.a4kwallpaper.main;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ToggleButton;

import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a4kwallpaper.R;
import com.example.a4kwallpaper.api.Api_InterFace;
import com.example.a4kwallpaper.api.CallbackSettings;
import com.example.a4kwallpaper.data.RestAdapter;
import com.example.a4kwallpaper.databinding.ActivityMainBinding;
import com.example.a4kwallpaper.main.fragments.categories.CategoryFragment;
import com.example.a4kwallpaper.main.fragments.foryou.ForYouFragment;
import com.example.a4kwallpaper.main.fragments.four_k.FourKFragment;
import com.example.a4kwallpaper.main.fragments.home.HomeFragment;
import com.example.a4kwallpaper.main.fragments.live.LiveFragment;
import com.example.a4kwallpaper.main.fragments.parallax.ParallaxFragment;
import com.example.a4kwallpaper.main.fragments.premium.PremiumFragment;
import com.example.a4kwallpaper.main.fragments.quotes.QuotesFragment;
import com.example.a4kwallpaper.main.fragments.search.SearchActivity;
import com.example.a4kwallpaper.nav_fragments.apptour.AppTourActivity;
import com.example.a4kwallpaper.nav_fragments.autochange.AutoChangeActivity;
import com.example.a4kwallpaper.nav_fragments.downloads.DownloadsActivity;
import com.example.a4kwallpaper.nav_fragments.edgelight.EdgeLightActivity;
import com.example.a4kwallpaper.nav_fragments.myfavorite.MyFavoriteActivity;
import com.example.a4kwallpaper.nav_fragments.toppicks.TopPicksActivity;
import com.google.android.gms.ads.nativead.NativeAd;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int cnt=1;
    public static NativeAd nativeAd;
    private Call<CallbackSettings> callbackCall = null;

    public static ArrayList imageList = new ArrayList<>();

    CallbackSettings resp;
    String filter;
    String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        OnBackPressedDispatcher onBackPressedDispatcher = new OnBackPressedDispatcher();
        onBackPressedDispatcher.onBackPressed();


        Api_InterFace apiInterface = RestAdapter.createAPI("https://wallapp.patoliyaitsolution.com/");

        callbackCall = apiInterface.getSettings("com.example.a4kwallpaper");

        callbackCall.enqueue(new Callback<CallbackSettings>() {
            @Override
            public void onResponse(Call<CallbackSettings> call, Response<CallbackSettings> response) {
                if (response.isSuccessful()) {

                    resp = response.body();

                    Log.d("QQQ", "onResponse: sucess = "+response.raw());

                     filter = resp.menus.get(0).menu_filter;
                     order = resp.menus.get(0).menu_order;

                    Log.d("QQQ", "onResponse: f1 = "+filter);
                    Log.d("QQQ", "onResponse: f1 = "+order);

                    addFragment(new HomeFragment(MainActivity.this,filter,order));

                } else  {
                    Log.d("QQQ", "onResponse : Failed");
                }
            }

            @Override
            public void onFailure(Call<CallbackSettings> call, Throwable t) {
                Log.d("QQQ", "onFailure: " + t.getMessage());
            }
        });




        //binding.appBarMain.contentmain
        cnt=1;
        textviewenable();
        managevisibility(cnt);

        binding.appBarMain.SearchIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this , SearchActivity.class);
                startActivity(intent);
            }
        });

        binding.appBarMain.contentmain.tvMenu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(0).menu_filter;
                order = resp.menus.get(0).menu_order;

                textviewenable();
                cnt=1;
                managevisibility(cnt);
                addFragment(new HomeFragment(MainActivity.this, filter, order));
            }
        });
        binding.appBarMain.contentmain.tvMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(1).menu_filter;
                order = resp.menus.get(1).menu_order;

                textviewenable();
                cnt=2;
                managevisibility(cnt);
                addFragment(new PremiumFragment(MainActivity.this,filter,order));
            }
        });
        binding.appBarMain.contentmain.tvMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(2).menu_filter;
                order = resp.menus.get(2).menu_order;

                textviewenable();
                cnt=3;
                managevisibility(cnt);
                addFragment(new LiveFragment(MainActivity.this,filter,order));
            }
        });
        binding.appBarMain.contentmain.tvMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(3).menu_filter;
                order = resp.menus.get(3).menu_order;

                textviewenable();
                cnt=4;
                managevisibility(cnt);
                addFragment(new ParallaxFragment(MainActivity.this,filter,order));
            }
        });
        binding.appBarMain.contentmain.tvMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(4).menu_filter;
                order = resp.menus.get(4).menu_order;

                textviewenable();
                cnt=5;
                managevisibility(cnt);
                addFragment(new FourKFragment(MainActivity.this,filter,order));
            }
        });
        binding.appBarMain.contentmain.tvMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = resp.menus.get(5).menu_filter;
                order = resp.menus.get(5).menu_order;

                textviewenable();
                cnt=6;
                managevisibility(cnt);
                addFragment(new ForYouFragment(MainActivity.this,filter,order));
            }
        });
        binding.appBarMain.contentmain.tvMenu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                filter = "wallpaper";
                order = "random";

//                filter = resp.menus.get(7).menu_filter;
//                order = resp.menus.get(7).menu_order;

//                Log.d("QQQ", "onClick: filter = "+filter);
//                Log.d("QQQ", "onClick: filter = "+order);

                textviewenable();
                cnt=7;
                managevisibility(cnt);
                addFragment(new QuotesFragment(MainActivity.this,filter,order));
            }
        });

        /////////////////////////////////////////////////////////////////////////

        // call categories api

        binding.appBarMain.contentmain.tvMenu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                textviewenable();
                cnt=8;
                managevisibility(cnt);
                addFragment(new CategoryFragment(MainActivity.this));
            }
        });

        ///////////////////////////////////////////////////////////////////////////

        ToggleButton toggle = binding.appBarMain.toggleBtn;
        toggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    binding.drawerLayout.closeDrawer(GravityCompat.START);
                } else {
                    binding.drawerLayout.openDrawer(GravityCompat.START);
                }
            }
        });
////////////////////////////////////////////////////////////////
       binding.menus.navHome.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               allmenucolor();
               binding.menus.navHome.setBackgroundColor(getColor(R.color.white));
               binding.menus.t1.setTextColor(getColor(R.color.black));
               binding.menus.i1.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

               Intent intent = new Intent(MainActivity.this, MainActivity.class);
               startActivity(intent);
               binding.drawerLayout.close();
           }
       });
        binding.menus.navTopPicks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navTopPicks.setBackgroundColor(getColor(R.color.white));
                binding.menus.t2.setTextColor(getColor(R.color.black));
                binding.menus.i2.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, TopPicksActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navLightingWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navLightingWallpaper.setBackgroundColor(getColor(R.color.white));
                binding.menus.t3.setTextColor(getColor(R.color.black));
                binding.menus.i3.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, EdgeLightActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navFavorute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navFavorute.setBackgroundColor(getColor(R.color.white));
                binding.menus.t4.setTextColor(getColor(R.color.black));
                binding.menus.i4.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, MyFavoriteActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navMydownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navMydownload.setBackgroundColor(getColor(R.color.white));
                binding.menus.t5.setTextColor(getColor(R.color.black));
                binding.menus.i5.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, DownloadsActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navAutoChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navAutoChange.setBackgroundColor(getColor(R.color.white));
                binding.menus.t6.setTextColor(getColor(R.color.black));
                binding.menus.i6.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, AutoChangeActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navAppTour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navAppTour.setBackgroundColor(getColor(R.color.white));
                binding.menus.t7.setTextColor(getColor(R.color.black));
                binding.menus.i7.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                Intent intent = new Intent(MainActivity.this, AppTourActivity.class);
                startActivity(intent);
                binding.drawerLayout.close();
            }
        });
        binding.menus.navPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                allmenucolor();
                binding.menus.navPrivacyPolicy.setBackgroundColor(getColor(R.color.white));
                binding.menus.t8.setTextColor(getColor(R.color.black));
                binding.menus.i8.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                String url = "https://app.termly.io/dashboard/website/d7c33f4e-8968-4614-939c-12c1a93862fa/privacy-policy";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));

                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                binding.drawerLayout.close();
            }
        });
        binding.menus.navRateApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allmenucolor();
                binding.menus.navRateApp.setBackgroundColor(getColor(R.color.white));
                binding.menus.t9.setTextColor(getColor(R.color.black));
                binding.menus.i9.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                binding.drawerLayout.close();
            }
        });
        binding.menus.navShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allmenucolor();
                binding.menus.navShare.setBackgroundColor(getColor(R.color.white));
                binding.menus.t10.setTextColor(getColor(R.color.black));
                binding.menus.i10.setImageTintList(ColorStateList.valueOf(getColor(R.color.black)));

                binding.drawerLayout.close();
            }
        });

//        binding.navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//                if(item.getItemId()== R.id.nav_home)
//                {
//                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()==R.id.nav_top_picks)
//                {
//                    Intent intent = new Intent(MainActivity.this, TopPicksActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()==R.id.nav_lighting_wallpaper)
//                {
//                    Intent intent = new Intent(MainActivity.this, EdgeLightActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_favorute)
//                {
//                    Intent intent = new Intent(MainActivity.this, MyFavoriteActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_mydownload)
//                {
//                    Intent intent = new Intent(MainActivity.this, DownloadsActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_auto_change)
//                {
//                    Intent intent = new Intent(MainActivity.this, AutoChangeActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_app_tour)
//                {
//                    Intent intent = new Intent(MainActivity.this, AppTourActivity.class);
//                    startActivity(intent);
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_privacy_policy)
//                {
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_rate_app)
//                {
//                    binding.drawerLayout.close();
//                }
//                if(item.getItemId()== R.id.nav_share)
//                {
//                    binding.drawerLayout.close();
//                }
//                return true;
//            }
//        });
    }

    private void allmenucolor()
    {
        binding.menus.navHome.setBackgroundColor(getColor(R.color.black));
        binding.menus.t1.setTextColor(getColor(R.color.white));
        binding.menus.i1.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navTopPicks.setBackgroundColor(getColor(R.color.black));
        binding.menus.t2.setTextColor(getColor(R.color.white));
        binding.menus.i2.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navLightingWallpaper.setBackgroundColor(getColor(R.color.black));
        binding.menus.t3.setTextColor(getColor(R.color.white));
        binding.menus.i3.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navFavorute.setBackgroundColor(getColor(R.color.black));
        binding.menus.t4.setTextColor(getColor(R.color.white));
        binding.menus.i4.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navMydownload.setBackgroundColor(getColor(R.color.black));
        binding.menus.t5.setTextColor(getColor(R.color.white));
        binding.menus.i5.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navAutoChange.setBackgroundColor(getColor(R.color.black));
        binding.menus.t6.setTextColor(getColor(R.color.white));
        binding.menus.i6.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));

        binding.menus.navAppTour.setBackgroundColor(getColor(R.color.black));
        binding.menus.t7.setTextColor(getColor(R.color.white));
        binding.menus.i7.setImageTintList(ColorStateList.valueOf(getColor(R.color.white)));
    }

    private void addFragment(Fragment fragment)
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.FrameMain,fragment);
        transaction.commit();
    }

    private void textviewenable()
    {
        binding.appBarMain.contentmain.ivmenu1.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu2.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu3.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu4.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu5.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu6.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu7.setVisibility(View.GONE);
        binding.appBarMain.contentmain.ivmenu8.setVisibility(View.GONE);

        binding.appBarMain.contentmain.tvMenu1.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu2.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu3.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu4.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu5.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu6.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu7.setVisibility(View.VISIBLE);
        binding.appBarMain.contentmain.tvMenu8.setVisibility(View.VISIBLE);
    }

    private void managevisibility(int cnt)
    {
        if(cnt==1){
            binding.appBarMain.contentmain.tvMenu1.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu1.setVisibility(View.VISIBLE);
        }
        else if (cnt==2) {
            binding.appBarMain.contentmain.tvMenu2.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu2.setVisibility(View.VISIBLE);
        }
        else if (cnt==3) {
            binding.appBarMain.contentmain.tvMenu3.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu3.setVisibility(View.VISIBLE);
        }
        else if (cnt==4) {
            binding.appBarMain.contentmain.tvMenu4.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu4.setVisibility(View.VISIBLE);
        }
        else if (cnt==5) {
            binding.appBarMain.contentmain.tvMenu5.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu5.setVisibility(View.VISIBLE);
        }
        else if (cnt==6) {
            binding.appBarMain.contentmain.tvMenu6.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu6.setVisibility(View.VISIBLE);
        }
        else if (cnt==7) {
            binding.appBarMain.contentmain.tvMenu7.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu7.setVisibility(View.VISIBLE);
        }
        else if (cnt==8) {
            binding.appBarMain.contentmain.tvMenu8.setVisibility(View.GONE);
            binding.appBarMain.contentmain.ivmenu8.setVisibility(View.VISIBLE);
        }
    }
}