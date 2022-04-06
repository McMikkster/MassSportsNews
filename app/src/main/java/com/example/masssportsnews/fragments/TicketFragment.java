package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import android.widget.Button;
import android.widget.TextView;

import com.example.masssportsnews.R;


public class TicketFragment extends Fragment {

    private TextView eventName;
    private TextView ticketDate;
    private TextView ticketSeat;
    private TextView ticketView;
    private TextView ticketTotal;
    private Button ticketPayBttn;


    public TicketFragment()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        eventName = view.findViewById(R.id.eventName);
        ticketDate = view.findViewById(R.id.ticketDate);
        ticketSeat = view.findViewById(R.id.ticketSeat);
        ticketTotal = view.findViewById(R.id.ticketTotal);
        ticketView = view.findViewById(R.id.ticketView);
        ticketPayBttn = view.findViewById(R.id.ticketPayBttn);

        ticketPayBttn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {



            }
        });




    }
}