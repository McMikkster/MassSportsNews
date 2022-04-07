package com.example.masssportsnews.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masssportsnews.R;
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
    return null;
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


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView eventName;
        private TextView ticketDate;
        private TextView ticketSeat;
        private TextView ticketView;
        private TextView ticketTotal;
        private Button ticketPayBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            eventName = itemView.findViewById(R.id.eventName);
            ticketDate = itemView.findViewById(R.id.ticketDate);
            ticketSeat = itemView.findViewById(R.id.ticketSeat);
            ticketTotal = itemView.findViewById(R.id.ticketTotal);
            ticketView = itemView.findViewById(R.id.ticketView);
            ticketPayBtn = itemView.findViewById(R.id.ticketPayBttn);

            ticketPayBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {



                }
            });

        }
    }
}
