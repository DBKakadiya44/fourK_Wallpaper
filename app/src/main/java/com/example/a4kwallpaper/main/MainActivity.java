package com.example.a4kwallpaper.main;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.a4kwallpaper.R;
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
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    int cnt=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        addFragment(new HomeFragment(MainActivity.this));

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
                textviewenable();
                cnt=1;
                managevisibility(cnt);
                addFragment(new HomeFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=2;
                managevisibility(cnt);
                addFragment(new PremiumFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=3;
                managevisibility(cnt);
                addFragment(new LiveFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=4;
                managevisibility(cnt);
                addFragment(new ParallaxFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=5;
                managevisibility(cnt);
                addFragment(new FourKFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=6;
                managevisibility(cnt);
                addFragment(new ForYouFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=7;
                managevisibility(cnt);
                addFragment(new QuotesFragment(MainActivity.this));
            }
        });
        binding.appBarMain.contentmain.tvMenu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textviewenable();
                cnt=8;
                managevisibility(cnt);
                addFragment(new CategoryFragment(MainActivity.this));
            }
        });


        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        setSupportActionBar(binding.appBarMain.toolbar);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(MainActivity.this,drawer,binding.appBarMain.toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()== R.id.nav_home)
                {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()==R.id.nav_top_picks)
                {
                    Intent intent = new Intent(MainActivity.this, TopPicksActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()==R.id.nav_lighting_wallpaper)
                {
                    Intent intent = new Intent(MainActivity.this, EdgeLightActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_favorute)
                {
                    Intent intent = new Intent(MainActivity.this, MyFavoriteActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_mydownload)
                {
                    Intent intent = new Intent(MainActivity.this, DownloadsActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_auto_change)
                {
                    Intent intent = new Intent(MainActivity.this, AutoChangeActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_app_tour)
                {
                    Intent intent = new Intent(MainActivity.this, AppTourActivity.class);
                    startActivity(intent);
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_privacy_policy)
                {
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_rate_app)
                {
                    drawer.close();
                }
                if(item.getItemId()== R.id.nav_share)
                {
                    drawer.close();
                }
                return true;
            }
        });
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