package com.example.masssportsnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.masssportsnews.fragments.NewsFragment;
import com.example.masssportsnews.fragments.LiveScoreFragment;
import com.example.masssportsnews.fragments.ProfileFragment;
import com.example.masssportsnews.fragments.ScannerFragment;
import com.example.masssportsnews.fragments.TicketFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{


    final FragmentManager fragmentManager = getSupportFragmentManager();
    Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment fragment;


                switch(item.getItemId())
                {
                    case R.id.action_ticket:
                        fragment = new TicketFragment();
                        break;
                    case R.id.action_live:
                        fragment = new LiveScoreFragment();
                        break;
                    case R.id.action_profile:
                        fragment = new ProfileFragment();
                        break;
                    case R.id.action_scanner:
                        fragment = new ScannerFragment();
                        break;
                    default:
                        fragment = new NewsFragment();
                        break;
                }

                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();
                return true;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.action_ticket);
    }



}