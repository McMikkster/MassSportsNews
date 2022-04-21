package com.example.masssportsnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masssportsnews.R;
import com.example.models.Profile;

import java.util.List;

public class ProfileAdapter extends RecyclerView.Adapter<ProfileAdapter.ViewHolder>{
    @NonNull
    Context context;
    List<Profile> profileList;

    public ProfileAdapter( Context context, List<Profile> profileList) {
        this.context = context;
        this.profileList = profileList;
    }

    @Override
    public ProfileAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_profile, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileAdapter.ViewHolder holder, int position) {
        Profile profile = profileList.get(position);
        holder.bind(profile);
    }

    @Override
    public int getItemCount() {
        return profileList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

       private TextView firstname;
       private TextView lastname;
       private TextView email;
       private TextView phoneNumber;
       private TextView address;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            firstname = itemView.findViewById(R.id.viewFirstName);
            lastname = itemView.findViewById(R.id.viewLastName);
            email = itemView.findViewById(R.id.viewEmail);
            phoneNumber = itemView.findViewById(R.id.viewPhoneNumber);
            address = itemView.findViewById(R.id.viewAddress);


        }


        public void bind(Profile profile) {
            firstname.setText(profile.getKeyFirstname());
            lastname.setText(profile.getKeyLastname());
            email.setText(profile.getKeyEmail());
            phoneNumber.setText(profile.getKeyPhoneNumber());
            address.setText(profile.getKeyAddress());

        }
    }
}


