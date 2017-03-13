package com.example.alienware.englisherudition;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Vector;

/**
 * Created by Alienware on 28-02-2017.
 */

public class LeaderboardAdapter extends RecyclerView.Adapter<LeaderboardAdapter.TheViewHolder>{
    private List<JSONObject> userList;

    public LeaderboardAdapter(List<JSONObject> userList) {
        this.userList = userList;
    }

    public class TheViewHolder extends RecyclerView.ViewHolder {
        public TextView name, user_name,score;
        public TheViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.Leaderboard_name);
            user_name = (TextView) view.findViewById(R.id.Leaderboard_username);
            score = (TextView)view.findViewById(R.id.Leaderboard_score);

        }
    }




    @Override
    public TheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leader_card, parent, false);
        return new TheViewHolder(view);
    }


    @Override
    public void onBindViewHolder(TheViewHolder holder, int position) {
        JSONObject jsonObject = userList.get(position);
        try {
            holder.name.setText(jsonObject.getString("nameOfUser"));
            holder.user_name.setText(jsonObject.getString("user_name"));
            holder.score.setText(jsonObject.getString("score"));
        }catch (JSONException je){je.printStackTrace();}

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}
