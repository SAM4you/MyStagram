package com.ander.mystagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.parse.ParseUser;

public class ProfileActivity extends AppCompatActivity {

    public static final String TAG = "ProfileActivity";

    ImageView ivProfile;
    TextView tvUsername;
    TextView tvEmail;
    Button btnLogout;
    private ImageButton ibHome;
    private ImageButton ibCompose;
    private ImageButton ibProfile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        ivProfile = findViewById(R.id.ivProfile);
        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);
        ibHome = findViewById(R.id.ibHome);
        ibCompose = findViewById(R.id.ibCompose);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick Logout button");
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Log.i(TAG,"Logout Success");
                startActivity(new Intent(ProfileActivity.this,LoginActivity.class));
                Toast.makeText(ProfileActivity.this, "Logout Success", Toast.LENGTH_SHORT).show();

            }
        });

        ibHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Navigating to FeedActivity");
                startActivity(new Intent(ProfileActivity.this,FeedActivity.class));
            }
        });
        ibCompose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"Navigating to MainActivity");
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
            }
        });





    }

}