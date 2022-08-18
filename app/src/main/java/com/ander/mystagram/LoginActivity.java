package com.ander.mystagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity {
    public static final String TAG = "LoginActivity";
    private TextView tvWelcome;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;
    private TextView tvSUp;
    private Button btnSUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        if (ParseUser.getCurrentUser() !=null) {
            goMainActivity();

        }

        tvWelcome =  findViewById(R.id.tvWelcome);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvSUp =  findViewById(R.id.tvSUp);
        btnSUp = findViewById(R.id.btnSUp);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick Login button");
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();
                loginUser(username,password);

            }
        });
        btnSUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG,"onClick SignUp button");
                //String username = etUsername.getText().toString();
                //String password = etPassword.getText().toString();
                //loginUser(username,password);

            }
        });
        getSupportActionBar().hide();

    }

    private void loginUser(String username, String password) {
        Log.i(TAG,"Attempting to login user"+username);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (e != null){
                    Log.e(TAG, "Issue with Login",e);
                    return;
                }
                //TODO: Navigate to main activity if the user is signed in properly
                goMainActivity();
                Toast.makeText(LoginActivity.this, "Login Success!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}