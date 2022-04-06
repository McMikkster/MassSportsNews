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

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

//        ImageView ivHomeTeam;
//        ImageView ivAwayTeam;

        TextView tvHomeTeamName;
        TextView tvAwayTeamName;
        TextView tvHomeScore;
        TextView tvAwayScore;
        TextView tvCommenceTime;
        TextView tvStatus;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

//        ivHomeTeam = itemView.findViewById(R.id.ivHomeTeam);
//        ivAwayTeam = itemView.findViewById(R.id.ivAwayTeam);

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
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            tvHomeTeamName.setText(liveScore.getHomeTeam());
            tvAwayTeamName.setText(liveScore.getAwayTeam());

            tvHomeScore.setText(liveScore.getHomeScore());
            tvAwayScore.setText(liveScore.getAwayScore());

            if(liveScore.getCommenceTime().compareTo(dtf.format(now)) > 0 )
            {
                tvCommenceTime.setText("Starts " + liveScore.getCommenceTime());
            }
            else{
                tvCommenceTime.setText("Started " + liveScore.getCommenceTime());
            }



            //in progress
            //not started
            //finished
            if(liveScore.getComplete() == true)
            {
                tvStatus.setText("Status: In-Progress");
            }
            else{
                tvStatus.setText("Status: Not started");
            }

        }
    }
}
