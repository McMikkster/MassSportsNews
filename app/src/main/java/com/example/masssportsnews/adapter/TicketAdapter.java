package com.example.masssportsnews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
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
        View view = LayoutInflater.from(context).inflate(R.layout.item_ticket, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position)
    {
        Ticket ticket = ticketList.get(position);
        holder.bind(ticket);
    }

    @Override
    public int getItemCount()
    {
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView eventTitle;
        private TextView ticketAddress;
        private TextView ticketTotal;
        private Button ticketPayBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            eventTitle = itemView.findViewById(R.id.eventTitle);
            ticketAddress = itemView.findViewById(R.id.ticketAddress);
            ticketTotal = itemView.findViewById(R.id.ticketTotal);
            ticketPayBtn = itemView.findViewById(R.id.ticketPayBttn);

            ticketPayBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {



                }
            });

        }

        public void bind(Ticket ticket)
        {
            eventTitle.setText(ticket.getTitle());

            ticketAddress.setText(ticket.getAddress());

            ticketTotal.setText(ticket.getTicketCost());

        }
    }
}
