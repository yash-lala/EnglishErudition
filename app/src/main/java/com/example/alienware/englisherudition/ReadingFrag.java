package com.example.alienware.englisherudition;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Alienware on 01-02-2017.
 */

public class ReadingFrag extends Fragment {
    ChangeFrag changeFrag;
    WritingFrag writingFrag;
    ListeningFrag listeningFrag;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    QuizAdapter adapter;
    JSONObject jsonObject;
    JSONObject tosend;
    TextView passage;
    JSONArray correctAns;
    FloatingActionButton floatingActionButton;
    static int score;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.reading,container,false);
        floatingActionButton = (FloatingActionButton)view.findViewById(R.id.reading_fab);
        passage = (TextView)view.findViewById(R.id.passage);

        recyclerView = (RecyclerView)view.findViewById(R.id.reading_recycler);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        jsonObject = new JSONObject();

        recyclerView.setLayoutManager(layoutManager);

        listeningFrag = new ListeningFrag();
        tosend = new JSONObject();
        try{
            tosend.put("key","1");
            tosend.put("tableToReadFrom","reading");
        }catch (JSONException je){je.printStackTrace();}
        getData();


        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ReadingFrag.this.adapter.sendScore();
                getData();
            }

        });

        return view;
    }

    private void getData(){
        new AsyncConnect(getContext(), getString(R.string.link_Reading), null, new AsyncConnect.AsyncRevert() {
            @Override
            public void getJsonResponse(JSONObject jsonObject) {
                try {
                    System.out.println("PASSAGE->"+jsonObject.getString("passage"));
                    passage.setText(jsonObject.getString("passage"));
                }catch (JSONException je){je.printStackTrace();}
                ReadingFrag.this.jsonObject = jsonObject;
                adapter = new QuizAdapter(jsonObject,getContext());
                recyclerView.setAdapter(adapter);


                adapter.notifyDataSetChanged();

                System.out.println("JSON->"+ReadingFrag.this.jsonObject);

            }
        }).execute();
    }
}
