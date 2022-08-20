package com.ander.mystagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends AppCompatActivity {

    public static final String TAG = "FeedActivity";
    List<Post> posts;

    private RelativeLayout bottom;
    private ImageButton ibHome;
    private ImageButton ibCompose;
    private ImageButton ibProfile;
    RecyclerView rvFeed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        rvFeed = findViewById(R.id.rvFeed);
        ibCompose = findViewById(R.id.ibCompose);
        ibProfile = findViewById(R.id.ibProfile);

        ibCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Navigating to MainActivity");
                startActivity(new Intent(FeedActivity.this,MainActivity.class));
            }
        });

        ibProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(FeedActivity.this, "Sorry, this option is not yet fully implemented", Toast.LENGTH_SHORT).show();
                Log.i(TAG,"Navigating to ProfileActivity");
                startActivity(new Intent(FeedActivity.this,ProfileActivity.class));
            }
        });

        rvFeed = findViewById(R.id.rvFeed);

    }
}