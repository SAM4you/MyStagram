package com.ander.mystagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;

import com.ander.mystagram.fragments.MyAccountFragment;
import com.ander.mystagram.fragments.ComposeFragment;
import com.ander.mystagram.fragments.FeedFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    final FragmentManager fragmentManager = getSupportFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);


       bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {
               Fragment fragment;

               switch (item.getItemId()) {
                   case R.id.action_home:
                   default:
                      // Toast.makeText(MainActivity.this, "Feed", Toast.LENGTH_SHORT).show();
                       fragment = new FeedFragment();
                        break;

                   case R.id.action_compose:
                       // Something Happens
                      // Toast.makeText(MainActivity.this, "Compose", Toast.LENGTH_SHORT).show();
                       fragment = new ComposeFragment();
                       break;

                   case R.id.action_profile:
                      // Toast.makeText(MainActivity.this, "Profile", Toast.LENGTH_SHORT).show();
                       fragment = new MyAccountFragment();
                       break;
               }
               fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
               return true;
           }
       });


    }


}