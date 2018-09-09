package com.example.acer.myapplicationiu;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class DashboardActivity extends AppCompatActivity {
    String[] values = {"Kontrollo simptomat",
            "Perkujto medikamentet",
            "Lista e medikamenteve",
            "Identifiko medikamentet",
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
        setContentView(R.layout.activity_dashboard);
        BottomNavigationView mMainNav = (BottomNavigationView) findViewById(R.id.main_nav);
        mMainNav.setOnNavigationItemSelectedListener(navListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            android.support.v4.app.Fragment selectedFragment = null;
            switch (item.getItemId())
            {
                case R.id.nav_home:
                    selectedFragment = new Home_Fragment();
                    break;
                case R.id.nav_news:
                    selectedFragment = new News_Fragment();
                    break;
                case R.id.nav_community:
                    selectedFragment = new Community_Fragment();

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.gridVieew,selectedFragment).commit();
            return true;
        }
    };
}
