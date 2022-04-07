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

    String name;

    String ticketCost;

    String startSale;

    String endSale;

    boolean isFree;

    public Ticket()
    {
        //Empty constructor
    }

    public Ticket(JSONObject jsonObject) throws JSONException
    {
        name = jsonObject.getString("name");

        isFree = jsonObject.getBoolean("free");

        ticketCost = jsonObject.getString("cost");

        startSale = jsonObject.getString("sales_start");

        endSale = jsonObject.getString("sales_end");


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

    public String getName()
    {
        return name;
    }

    public String getTicketCost()
    {
        return ticketCost;
    }

    public String getStartSale()
    {
        return startSale;
    }

    public String getEndSale()
    {
        return endSale;
    }

    public boolean isFree()
    {
        return isFree;
    }


}
