package com.example.masssportsnews.fragments;

import static com.example.models.Profile.KEY_ADDRESS;
import static com.example.models.Profile.KEY_EMAIL;
import static com.example.models.Profile.KEY_FIRSTNAME;
import static com.example.models.Profile.KEY_LASTNAME;
import static com.example.models.Profile.KEY_PHONENUMBER;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.masssportsnews.adapter.ProfileAdapter;
import com.example.models.Profile;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masssportsnews.R;

import com.google.android.material.button.MaterialButton;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;

import java.util.ArrayList;
import java.util.List;


public class ProfileFragment extends Fragment {

    public static final String TAG = "ProfileFragment";

    private TextView tvProfile;
    private TextView viewFirstName;
    private TextView viewLastName;
    private TextView viewEmail;
    private TextView viewPhoneNumber;
    private TextView viewPassword;
    private TextView viewAddress;
    MaterialButton btnEditProfile;

    RecyclerView rvProfile;
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
        return inflater.inflate(R.layout.profile_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        viewFirstName = view.findViewById(R.id.viewFirstName);
//        viewLastName = view.findViewById(R.id.viewLastName);
//        viewEmail = view.findViewById(R.id.viewEmail);
//        viewPhoneNumber = view.findViewById(R.id.viewEmail);
//        viewAddress = view.findViewById(R.id.viewAddress);
        rvProfile = view.findViewById(R.id.rvprofile);
    profileList = new ArrayList<>();
    profileAdapter = new ProfileAdapter(getContext(), profileList);
    rvProfile.setAdapter(profileAdapter);
    rvProfile.setLayoutManager(new LinearLayoutManager(getContext()));

    queryProfile();

    }

    private void queryProfile() {

        ParseQuery<Profile> query = ParseQuery.getQuery(Profile.class);
        query.include(KEY_FIRSTNAME);
        query.include(KEY_LASTNAME);
        query.include(KEY_EMAIL);
        query.include (KEY_PHONENUMBER);
        query.include(KEY_ADDRESS);

        query.findInBackground(new FindCallback<Profile>() {
            @Override
            public void done(List<Profile>  profile, ParseException e) {
                if (e != null){
                    Log.e(TAG, "issue with profile", e);
                    return;
                }
//                for(Profile profile: profile){
//                    Log
//                }
//


                profileList.addAll(profile);
                profileAdapter.notifyDataSetChanged();


            }

        });




    }
}