package com.example.masssportsnews.fragments;

import android.nfc.Tag;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.TextView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.masssportsnews.R;
import com.example.masssportsnews.adapter.TicketAdapter;
import com.example.models.Ticket;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class TicketFragment extends Fragment {

    RecyclerView rvTicket;
    public static final String API_KEY = "https://www.eventbrite.com/api/v3/events/EVENT_ID/ticket_classes/?token=S6F7DYK72CI7DVZUBBSY";
    public static final String TAG = "TicketFragment";

    TicketAdapter ticketAdapter;

    List<Ticket> ticketList;

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

        ticketList = new ArrayList<>();

        rvTicket = view.findViewById(R.id.rvTicket);

        ticketAdapter = new TicketAdapter(getContext(), ticketList);

        rvTicket.setAdapter(ticketAdapter);

        rvTicket.setLayoutManager(new LinearLayoutManager(getContext()));

        AsyncHttpClient client = new AsyncHttpClient();

        client.get(API_KEY, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Headers headers, JSON json)
            {
                Log.d(TAG,"Onsucess");

                JSONArray results = json.jsonArray;

                try {
                    Log.i(TAG,"Results: " + results.toString());
                    ticketList.addAll(Ticket.fromJSONArray(results));
                    ticketAdapter.notifyDataSetChanged();
                    Log.i(TAG,"TicketList : " + ticketList.size());

                } catch (JSONException e)
                {
                    Log.e(TAG,"Hit json exception",e);
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Headers headers, String response, Throwable throwable)
            {
                Log.d(TAG,"OnFailure");
            }
        });



    }


}