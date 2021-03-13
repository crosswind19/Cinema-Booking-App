package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.groupproject.Fragment.NowPlayingFragment;
import com.example.groupproject.Fragment.UpComingFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class searchlist extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    ImageView home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchlist);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation2);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                    new NowPlayingFragment()).commit();
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                startActivity(new Intent(getApplicationContext(),activity_viewprofile.class));
                return true;
            case R.id.item2:
                startActivity(new Intent(getApplicationContext(),orderhistory.class));
                return true;
            case R.id.item3:
                startActivity(new Intent(getApplicationContext(),sendFeedback.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nowplaying:
                            selectedFragment = new NowPlayingFragment();
                            break;
                        case R.id.upcoming:
                            selectedFragment = new UpComingFragment();
                            break;
//                        case R.id.profile:
//                            Intent intent = new Intent(searchlist.this, activity_viewprofile.class);
//                            startActivity(intent);
//                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,
                            selectedFragment).commit();

                    return true;
                }
            };

}