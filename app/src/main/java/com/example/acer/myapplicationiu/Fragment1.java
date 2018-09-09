package com.example.acer.myapplicationiu;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class Fragment1 extends AppCompatActivity {
    GridView griddView;
    Toolbar toolbar;
    BottomNavigationViewEx bottomNavigationViewEx;
    String[] values = {"Kontrollo simptomat",
            "Perkujto medikamentet",
            "Lista e medikamenteve",
            "Interaksionet",
            "Gjej doktor",
            "IMT"};

    int[] images = {R.drawable.symptomcheck,
            R.drawable.reminder,
            R.drawable.list,
            R.drawable.interac,
            R.drawable.finddoc,R.drawable.bmi };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer);
        griddView = (GridView) findViewById(R.id.gridVieew);
        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                                                             @Override
                                                             public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                                                                 return false;
                                                             }
                                                         });
                bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.main_nav);
        bottomNavigationViewEx.enableAnimation(false);
        bottomNavigationViewEx.enableItemShiftingMode(false);
        bottomNavigationViewEx.enableShiftingMode(false);
        griddView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (values[position] == "Kontrollo simptomat")
                {
                    startActivity(new Intent(Fragment1.this,CheckSyptomsActivity.class));
                }
                else if (values[position] == "Perkujto medikamentet")
                {
                    startActivity(new Intent(Fragment1.this,RememberDrugsActivity.class));
                }
                else if (values[position] == "Lista e medikamenteve")
                {
                    startActivity(new Intent(Fragment1.this,ListaMedikamenteveActivity.class));
                }
                else if (values[position] == "Gjej doktor")
                {
                    startActivity(new Intent(Fragment1.this,FindDoctorActivity.class));
                }
                else if (values[position] == "Interaksionet")
                {
                    startActivity(new Intent(Fragment1.this, Interactions.class));
                }
                else
                {
                    startActivity(new Intent(Fragment1.this, IMT.class));
                }
            }
        });
        GridAdapter gridAdapter = new GridAdapter(this, values, images);
        griddView.setAdapter(gridAdapter);
        BottomNavigationView mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainNav.setOnNavigationItemSelectedListener(navListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment selectedFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new Home_Fragment();
                    break;
                case R.id.nav_news:
                    selectedFragment = new News_Fragment();
                    break;
                case R.id.nav_community:
                    selectedFragment = new Community_Fragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            return true;
        }
    };

}

