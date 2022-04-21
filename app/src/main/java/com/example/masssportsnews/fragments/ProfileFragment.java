package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.masssportsnews.adapter.ProfileAdapter;
import com.example.models.Profile;

import androidx.fragment.app.Fragment;

import com.example.masssportsnews.R;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    //private TextView tvProfile;
    //private TextView viewFirstName;
    //private TextView viewLastName;
    //private TextView viewEmail;
    //private TextView viewPhoneNumber;
    //private TextView viewPassword;
    //private TextView viewAddress;
    //private MaterialButton btnEditProfile;

    ProfileAdapter profileAdapter;
    List<Profile> profileList;

    public ProfileFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.item_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    profileList = new ArrayList<>();
    profileAdapter = new ProfileAdapter(getContext(), profileList);





    }
}