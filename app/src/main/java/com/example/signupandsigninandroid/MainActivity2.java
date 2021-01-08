package com.example.signupandsigninandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragement = null;
            switch (item.getItemId()){
                case R.id.nav_home:
//                    Toast.makeText(MainActivity2.this, "Home", Toast.LENGTH_SHORT).show();
                    selectedFragement = new HomeFragment();
                    break;
                case R.id.nav_notification:
//                    Intent myIntent = new Intent(getApplicationContext(), NotificationFragment.class);
//                    startActivity(myIntent);
//                    overridePendingTransition(0, 0);
                    selectedFragement = new NotificationFragment();
                    break;
                case R.id.nav_user:
//                    Intent myIntent1 = new Intent(getApplicationContext(), UserFragment.class);
//                    startActivity(myIntent1);
//                    overridePendingTransition(0, 0);
                    selectedFragement = new UserFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragement).commit();
            return true;
        }
    };
}