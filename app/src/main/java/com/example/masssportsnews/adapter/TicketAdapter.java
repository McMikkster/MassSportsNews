package com.example.masssportsnews.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.masssportsnews.PaymentActivity;
import com.example.masssportsnews.R;
import com.example.masssportsnews.models.Ticket;

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
        Log.i("TEST", "view created");

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TicketAdapter.ViewHolder holder, int position)
    {
        Ticket ticket = ticketList.get(position);
        holder.bind(ticket);
        Log.i("TEST", "bound ticket: " + ticket.getName());
    }

    @Override
    public int getItemCount()
    {
        return ticketList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView eventName;
        private TextView tvGenre;
        private TextView tvDate;
        private TextView tvPrice;
        private ImageView sportsView;
        private Button ticketPayBtn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            eventName = itemView.findViewById(R.id.tvEventName);
            sportsView = itemView.findViewById(R.id.sportsView);
            tvGenre = itemView.findViewById(R.id.tvGenre);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            ticketPayBtn = itemView.findViewById(R.id.ticketPayBttn);

            ticketPayBtn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {

                    Intent i = new Intent(context, PaymentActivity.class);
                    context.startActivity(i);
                    ((AppCompatActivity)context).finish();


                }
            });

        }

        public void bind(Ticket ticket)
        {
            eventName.setText(ticket.getName());

            tvGenre.setText(ticket.getGenreName());

            tvDate.setText(ticket.getDates());

            Glide.with(context).load(ticket.getUrl()).into(sportsView);

            tvPrice.setText(ticket.getMinimumPrice() + "");

        }
    }
}
