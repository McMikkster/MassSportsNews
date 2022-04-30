package com.example.masssportsnews.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masssportsnews.LoginActivity;
import com.example.masssportsnews.R;

import static com.example.masssportsnews.models.Profile.KEY_ADDRESS;
import static com.example.masssportsnews.models.Profile.KEY_EMAIL;
import static com.example.masssportsnews.models.Profile.KEY_FIRSTNAME;
import static com.example.masssportsnews.models.Profile.KEY_LASTNAME;
import static com.example.masssportsnews.models.Profile.KEY_PHONENUMBER;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.widget.Button;
import android.widget.TextView;

import com.parse.ParseUser;


public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";



    TextView tvProfile;
    TextView viewFirstName;
    TextView viewLastName;
    TextView viewEmail;
    TextView viewPhoneNumber;
    TextView viewPassword;
    TextView viewAddress;
    Button btnLogout;
    Button btnEditProfile;

    public ProfileFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ParseUser currentUser = ParseUser.getCurrentUser();
        //profileList = new ArrayList<>();
        tvProfile = view.findViewById(R.id.tvProfile);
        viewFirstName = view.findViewById(R.id.viewFirstName);
        viewLastName = view.findViewById(R.id.viewLastName);
        viewEmail = view.findViewById(R.id.viewEmail);
        viewPhoneNumber = view.findViewById(R.id.viewPhoneNumber);
        viewPassword = view.findViewById(R.id.viewPassword);
        viewAddress = view.findViewById(R.id.viewAddress);



        viewFirstName.setText("First Name: " +currentUser.get(KEY_FIRSTNAME).toString());
        viewLastName.setText("Last Name: "+currentUser.get(KEY_LASTNAME).toString());
        viewEmail.setText("Email: " + currentUser.get(KEY_EMAIL));
        viewPhoneNumber.setText("Phone Number: " + currentUser.get(KEY_PHONENUMBER).toString());
        viewAddress.setText("Address : " + currentUser.get(KEY_ADDRESS).toString());

        //queryProfile();

        btnLogout = view.findViewById(R.id.btnLogout);

        btnLogout = view.findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseUser.logOut();
                ParseUser currentUser = ParseUser.getCurrentUser(); // this will now be null
                Intent i = new Intent(getContext(), LoginActivity.class);
                startActivity(i);
            }
        });

        btnEditProfile = view.findViewById(R.id.btnEditProfile);

    }

    protected void queryProfile() {

        ParseUser currentUser = ParseUser.getCurrentUser();
        currentUser.getUsername();
        currentUser.getEmail();
        currentUser.get(KEY_PHONENUMBER);
        currentUser.get(KEY_ADDRESS);




    }
}