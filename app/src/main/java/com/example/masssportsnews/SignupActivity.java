package com.example.masssportsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.masssportsnews.models.Profile;
import com.google.android.material.textfield.TextInputEditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private TextView tvSignInHere;
    private Button btnSignup;

    private EditText tvUsername;
    private EditText tvPassword;
    private TextInputEditText firstname;
    private TextInputEditText lastname;
    private TextInputEditText address;
    private TextInputEditText phone;


    public static final String TAG = "Signed up!";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        tvUsername = findViewById(R.id.tvUsername);
        tvPassword = findViewById(R.id.tvPassword);
        firstname = findViewById(R.id.tvFirstName);
        lastname = findViewById(R.id.tvLastName);
        address = findViewById(R.id.tvAddress);
        phone = findViewById(R.id.tvPhoneNumber);
        tvSignInHere = findViewById(R.id.tvSignInHere);
        btnSignup = findViewById(R.id.btnSignup);

        tvSignInHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username = tvUsername.getText().toString();
                String password = tvPassword.getText().toString();
                registration(username, password);
                finish();
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                ParseUser user = new ParseUser();

                user.setUsername(tvUsername.getText().toString());
                user.setPassword(tvPassword.getText().toString());
                user.put(Profile.KEY_FIRSTNAME, firstname.getText().toString());
                user.put(Profile.KEY_LASTNAME, lastname.getText().toString());
                user.put(Profile.KEY_ADDRESS, address.getText().toString());
                user.put(Profile.KEY_PHONENUMBER, phone.getText().toString());

                user.signUpInBackground(new SignUpCallback()
                {
                    @Override
                    public void done(ParseException e)
                    {
                        if(e == null)
                        {
                            Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();
                            Log.i(TAG,"Successfully signed up!");
                        } else {
                            Log.e(TAG, "Not successful sign up!",e);
                            ParseUser.logOut();
                            Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }

    private void registration(String userName, String passWord)
    {
        ParseUser user = new ParseUser();

        user.setUsername(userName);

        user.setPassword(passWord);

        user.signUpInBackground(new SignUpCallback()
        {
            @Override
            public void done(ParseException e)
            {
                if(e == null)
                {
                    Log.i(TAG,"Successfully signed up!");
                    Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
                    intent.putExtra("username", userName);
                    startActivity(intent);
                } else {
                    Log.i(TAG, "Not successful sign up!");
                    ParseUser.logOut();
                    Toast.makeText(SignupActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }


}