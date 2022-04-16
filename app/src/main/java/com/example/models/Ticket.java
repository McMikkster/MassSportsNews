package com.example.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Ticket
{

    String title;

    int ticketCost;

    String address;

    public Ticket()
    {
        //Empty constructor
    }

    public Ticket(JSONObject jsonObject) throws JSONException
    {
        title = jsonObject.getString("title");

        ticketCost = jsonObject.optInt("average_price");

        address = jsonObject.optString("address");

    }

    public static List<Ticket> fromJSONArray(JSONArray ticketJsonArray) throws JSONException
    {
        List<Ticket> ticketList = new ArrayList<>();
        for(int i = 0; i < ticketJsonArray.length(); i++)
        {
            ticketList.add(new Ticket(ticketJsonArray.getJSONObject(i)));
        }
        return ticketList;
    }

    public String getTitle()
    {
        return title;
    }

    public int getTicketCost()
    {
        return ticketCost;
    }

    public String getAddress() {
        return address;
    }


}
