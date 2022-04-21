package com.example.models;

import android.util.Log;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

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

        for(int i = 0; i < jsonObject.length(); i++)
        {
            name = jsonObject.getJSONObject(String.valueOf(i)).getString("name");
        }

        int minimumPrice;

        String dates;

        JSONObject genre = jsonObject.getJSONArray("classifications").getJSONObject(0).getJSONObject("genre");

            if (!genre.getString("name").equals("Rock") && !genre.getString("name").equals("Fairs & Festivals")) {

                String name = events.getJSONObject(i).getString("name");

                if (events.getJSONObject(i).has("priceRanges")) {

//                                String name = events.getJSONObject(i).getString("name");
                    minimumPrice = events.getJSONObject(i).getJSONArray("priceRanges").getJSONObject(0).getInt("min");

                    dates = events.getJSONObject(i).getJSONObject("dates").getJSONObject("start").getString("localDate");

                    //Log.i(TAG, " [min: " + minimumPrice + "]");
                } else {
                    minimumPrice = 75;

                }
            }
        }

        ticketCost = jsonObject.getString("cost");

        startSale = jsonObject.getString("sales_start");

        endSale = jsonObject.getString("sales_end");


    }

    public static List<Ticket> fromJSONArray(JSONArray ticketList) throws JSONException
    {
        List<Ticket> tickets = new ArrayList<>();

        for(int i = 0; i < ticketList.length(); i++)
        {
            Ticket ticket = new Ticket(ticketList.getJSONObject(i));

        }

        return tickets;

//        List<Ticket> ticketList = new ArrayList<>();
//        for(int i = 0; i < ticketJsonArray.length(); i++)
//        {
//            ticketList.add(new Ticket(ticketJsonArray.getJSONObject(i)));
//        }
//        return ticketList;
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
