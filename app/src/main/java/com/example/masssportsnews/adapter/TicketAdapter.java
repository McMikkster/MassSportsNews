package com.example.masssportsnews.adapter;

import android.content.Context;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.models.Ticket;

import java.util.List;

public class TicketAdapter extends RecyclerView.Adapter<TicketAdapter.ViewHolder>
{

    @NonNull

    Context context;

    List<Ticket> ticketList;

    public TicketAdapter(@NonNull Context context, List<Ticket> ticketList)
    {
        this.context = context;
        this.ticketList = ticketList;
    }

    @Override
    public TicketAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position)
    {

    }

    @Override
    public int getItemCount()
    {
        return 0;
    }


}
