package com.example.masssportsnews;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.masssportsnews.R;
import com.example.masssportsnews.fragments.HomeFragment;
import com.example.masssportsnews.fragments.LiveScoreFragment;
import com.example.masssportsnews.fragments.ProfileFragment;
import com.example.masssportsnews.fragments.TicketFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity
{


    final FragmentManager fragmentManager = getSupportFragmentManager();

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener()
        {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item)
            {
                Fragment fragment;

                switch(item.getItemId())
                {
                    case R.id.action_ticket:
                        Toast.makeText(MainActivity.this, "Tickets!",Toast.LENGTH_SHORT).show();
                        fragment = new TicketFragment();
                        break;
                    case R.id.action_live:
                        Toast.makeText(MainActivity.this, "Live!", Toast.LENGTH_SHORT).show();
                        fragment = new LiveScoreFragment();
                        break;

                    case R.id.action_profile:
                        Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                    default:
                        fragment = new HomeFragment();
                        break;
                }

                fragmentManager.beginTransaction().replace(R.id.flContainer,fragment).commit();

                return true;
            }
        });

    }



}