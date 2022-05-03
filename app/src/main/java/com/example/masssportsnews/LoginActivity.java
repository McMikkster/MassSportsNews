package com.example.masssportsnews;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity
{

    public static final String TAG = "LoginActivity";
    EditText tvUsername;
    EditText tvPassword;

    Button btnSignup;

    Button btnSignin;

    protected void onCreate(Bundle savedInstance)
    {
        super.onCreate(savedInstance);

        if(ParseUser.getCurrentUser() != null)
        {
            goMainActivity();
        }

        setContentView(R.layout.activity_login);

        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPasswordSignup);

        btnSignin = findViewById(R.id.btnSignin);

        btnSignup = findViewById(R.id.btnSignupActivity);

        btnSignup.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                goSignup();
            }
        });

        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();

                loginUser(username,password);

            }
        });
    }

    private void loginUser(String username, String password)
    {
        Log.i(TAG,"Attempting to login user: " + username);

        ParseUser.logInInBackground(username, password, new LogInCallback()
        {
            @Override
            public void done(ParseUser user, ParseException e)
            {
                if(e != null)
                {
                    Log.e(TAG,"Issue with Login",e);

                    Toast.makeText(LoginActivity.this,"Issue with login",Toast.LENGTH_SHORT).show();

                    return;
                }
                goMainActivity();
                Toast.makeText(LoginActivity.this,"Success",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void goMainActivity()
    {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
        finish();
    }

    private void goSignup()
    {
        Intent i = new Intent(this, SignupActivity.class);
        startActivity(i);
        finish();
    }

}
