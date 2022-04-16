package com.example.masssportsnews.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.masssportsnews.R;
import com.example.masssportsnews.adapter.TicketAdapter;
import com.example.models.Ticket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class TicketFragment extends Fragment {

    public static final String API_KEY = "https://api.seatgeek.com/2/events?client_id=MjY1MjI4NzV8MTY0OTc3NDc3OS4yNDY4NjIy";
    public static final String TAG = "TicketFragment";

    RecyclerView rvTicket;
    TicketAdapter ticketAdapter;
    List<Ticket> ticketList;

    public TicketFragment()
    {
        // Required empty public constructor
    }

    public static TicketFragment newInstance(String param1, String param2) {
        TicketFragment fragment = new TicketFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ticket, container, false);
    }

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
                JSONObject jsonObject = json.jsonObject;

                try {
                    JSONArray event = jsonObject.getJSONArray("events");
                    for(int i = 0; i < event.length(); i++){
                        JSONObject stats = event.getJSONObject(i);
                        JSONObject venue = event.getJSONObject(i);
                        
                        int average_price = stats.optInt("average_price");
                        String address = venue.optString("address");
                    }
                    Log.i(TAG, "Event" + event.toString());
                    ticketList = Ticket.fromJSONArray(event);
                    Log.i(TAG, "Ticket : " + ticketList.size());

                    ticketList.addAll(Ticket.fromJSONArray(event));
                    ticketAdapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    Log.e(TAG, "Hit Json Exception", e);
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