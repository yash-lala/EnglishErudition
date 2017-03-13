package com.example.alienware.englisherudition;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.os.EnvironmentCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Vector;

/**
 * Created by Alienware on 01-02-2017.
 */

public class ListeningFrag extends Fragment implements View.OnClickListener{
    ChangeFrag changeFrag;
    ReadingFrag readingFrag;
    WritingFrag writingFrag;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private QuizAdapter quizAdapter;
    private Button button;
    private MediaPlayer mediaPlayer;
    private FloatingActionButton fab;
    private JSONObject json;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.listening,container,false);


        this.recyclerView=(RecyclerView)view.findViewById(R.id.lisetning_recycler);
        this.layoutManager=new LinearLayoutManager(getContext());
        this.button=(Button)view.findViewById(R.id.playButton);
        this.recyclerView.setHasFixedSize(true);
        this.fab=(FloatingActionButton)view.findViewById(R.id.listeningFab);
        this.fab.setOnClickListener(this);
        this.recyclerView.setLayoutManager(this.layoutManager);
        this.initMediaPlayer();
        getData();


        button.setOnClickListener(this);


        return view;
    }






    @Override
    public void onClick(View view){

        switch (view.getId()){
            case R.id.playButton:

                if (this.mediaPlayer.isPlaying())
                    this.mediaPlayer.pause();
                else
                    this.mediaPlayer.start();
                return;
            case R.id.listeningFab:
                this.quizAdapter.sendScore();
                getData();
                return;

        }
                //this.mediaPlayer.prepareAsync();






    }

    private void initMediaPlayer(){
        try {

            String path = Environment.getExternalStorageDirectory().getPath() + "/EnglishErudition /test17.mp3";
            System.out.println(path);


            FileInputStream fin = new FileInputStream(path);

            this.mediaPlayer = new MediaPlayer();
            this.mediaPlayer.setDataSource(fin.getFD());
            this.mediaPlayer.prepare();
        }catch(IOException ieo){
            ieo.printStackTrace();
        }
    }

    private void getData(){
        new AsyncConnect(getContext(), getString(R.string.link_Listening), null, new AsyncConnect.AsyncRevert() {
            @Override
            public void getJsonResponse(JSONObject jsonObject) {
                ListeningFrag.this.json=jsonObject;
                ListeningFrag.this.quizAdapter=new QuizAdapter(jsonObject,getContext());

                ListeningFrag.this.recyclerView.setAdapter(ListeningFrag.this.quizAdapter);
            }
        }).execute();
    }





}
