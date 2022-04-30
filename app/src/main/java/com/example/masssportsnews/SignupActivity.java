package com.example.masssportsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.masssportsnews.models.Profile;
import com.google.android.material.textfield.TextInputEditText;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignupActivity extends AppCompatActivity {

    private Button btnSignInHere;
    private Button btnSignup;

    private EditText tvUsername;
    private EditText tvPassword;
    private TextInputEditText firstname;
    private TextInputEditText email;
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
        email = findViewById(R.id.tvEmail);
        address = findViewById(R.id.tvAddress);
        phone = findViewById(R.id.tvPhoneNumber);
        btnSignInHere = findViewById(R.id.btnSignInHere);
        btnSignup = findViewById(R.id.btnSignup);

        btnSignInHere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                startActivity(i);
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
                user.setEmail(email.getText().toString());
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
}