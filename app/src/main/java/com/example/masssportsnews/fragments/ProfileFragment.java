package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masssportsnews.R;


public class ProfileFragment extends Fragment {

    private TextView tvProfile;
    private TextView viewFirstName;
    private TextView viewLastName;
    private TextView viewEmail;
    private TextView viewPhoneNumber;
    private TextView viewPassword;
    private TextView viewAddress;
    private MaterialButton btnEditProfile;

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

        tvProfile = view.findViewById(R.id.tvProfile);
        viewFirstName = view.findViewById(R.id.viewFirstName);
        viewLastName = view.findViewById(R.id.viewLastName);
        viewEmail = view.findViewById(R.id.viewEmail);
        viewPhoneNumber = view.findViewById(R.id.viewPhoneNumber);
        viewPassword = view.findViewById(R.id.viewPassword);
        viewAddress = view.findViewById(R.id.viewAddress);
        btnEditProfile = view.findViewById(R.id.btnEditProfile);

        btnEditProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {


            }
        });
    }
}