package com.example.alienware.englisherudition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alienware on 01-02-2017.
 */

public class Leaderboard extends Fragment {
    ChangeFrag changeFrag;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    HomeFrag homeFrag;
    List<JSONObject> jsonObjectList = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.leaderboard,container,false);
        recyclerView = (RecyclerView)view.findViewById(R.id.Leaderboard_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        adapter = new LeaderboardAdapter(jsonObjectList);
        recyclerView.setAdapter(adapter);

        new AsyncConnect(getContext(),getString(R.string.link_leaderboard),null, new AsyncConnect.AsyncRevert() {
            @Override
            public void getJsonResponse(JSONObject jsonObject) {
                try {

                    JSONArray jsonArray = new JSONArray(jsonObject.getString("list"));
                    for(int i=0;i<jsonArray.length();i++){
                        jsonObjectList.add(jsonArray.getJSONObject(i));
                        System.out.println(jsonObjectList.get(i));
                    }
                    adapter.notifyDataSetChanged();
                }catch (JSONException e){e.printStackTrace();}

            }
        }).execute();

        return view;
    }
}
