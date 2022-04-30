package com.example.masssportsnews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.masssportsnews.models.Profile;
import com.google.android.material.textfield.TextInputEditText;
import com.parse.ParseUser;

public class EditProfileActivity extends AppCompatActivity {

    private TextInputEditText editFirst;
    private EditText editPassword;
    private TextInputEditText editEmail;
    private TextInputEditText editLast;
    private TextInputEditText editAddress;
    private TextInputEditText editPhoneNumber;
    private Button btnConfirm;
    private Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        ParseUser currentUser = ParseUser.getCurrentUser();
        editFirst = findViewById(R.id.editFirst);
        editPassword = findViewById(R.id.editPassword);
        editEmail = findViewById(R.id.editEmail);
        editLast = findViewById(R.id.editLast);
        editAddress = findViewById(R.id.editAddress);
        editPhoneNumber = findViewById(R.id.editPhoneNumber);
        btnConfirm = findViewById(R.id.btnConfirm);
        btnBack = findViewById(R.id.btnBack);

        btnConfirm.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                currentUser.setPassword(editPassword.getText().toString());
                currentUser.setEmail(editEmail.getText().toString());
                currentUser.put(Profile.KEY_FIRSTNAME, editFirst.getText().toString());
                currentUser.put(Profile.KEY_LASTNAME, editLast.getText().toString());
                currentUser.put(Profile.KEY_ADDRESS, editAddress.getText().toString());
                currentUser.put(Profile.KEY_PHONENUMBER, editPhoneNumber.getText().toString());
                Intent i = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent i = new Intent(EditProfileActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        });


    }
}