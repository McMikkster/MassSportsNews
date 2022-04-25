package com.example.masssportsnews.adapter;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.masssportsnews.R;
import com.example.models.LiveScore;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.ViewHolder>
{
    @NonNull

    Context context;
    List<LiveScore> liveScoreList;

    public LiveAdapter(@NonNull Context context, List<LiveScore> liveScoreList) {
        this.context = context;
        this.liveScoreList = liveScoreList;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_live_score, parent, false);
        return new ViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onBindViewHolder(@NonNull LiveAdapter.ViewHolder holder, int position) {
        LiveScore liveScore = liveScoreList.get(position);
        holder.bind(liveScore);
    }

    @Override
    public int getItemCount() {
        return liveScoreList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvHomeTeamName;
        TextView tvAwayTeamName;
        TextView tvHomeScore;
        TextView tvAwayScore;
        TextView tvCommenceTime;
        TextView tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHomeTeamName = itemView.findViewById(R.id.tvHomeTeam);
            tvAwayTeamName = itemView.findViewById(R.id.tvAwayTeam);

            tvHomeScore = itemView.findViewById(R.id.tvHomeScore);
            tvAwayScore = itemView.findViewById(R.id.tvAwayScore);

            tvCommenceTime = itemView.findViewById(R.id.tvStartTime);
            tvStatus = itemView.findViewById(R.id.tvStatus);
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        public void bind(LiveScore liveScore)
        {
            SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cal = Calendar.getInstance();
            Date date = cal.getTime();
            String todaysDate = dtFormat.format(date);

            tvHomeTeamName.setText(liveScore.getHomeTeam());
            tvAwayTeamName.setText(liveScore.getAwayTeam());

            tvHomeScore.setText(liveScore.getHomeScore());
            tvAwayScore.setText(liveScore.getAwayScore());


            String gameDate = liveScore.getCommenceTime();
            if(todaysDate.compareTo(gameDate) >= 0)
                tvCommenceTime.setText("Started: " + gameDate);
            else
                tvCommenceTime.setText("Starts: " + gameDate);


            if(liveScore.getComplete())
            {
                tvStatus.setText("Status: Complete");
            }
            else if(liveScore.getComplete() && todaysDate.compareTo(gameDate) < 0)
            {
                tvStatus.setText("Status: In-Progress");
            }
            else{
                tvStatus.setText("Status: Not started");
            }

        }


    }
}
