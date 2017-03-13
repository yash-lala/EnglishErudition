package com.example.alienware.englisherudition;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Vector;

/**
 * Created by Alienware on 28-02-2017.
 */

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.TheViewHolder> {

    JSONObject jsonObject;
    List<JSONObject> jsonObjectList;
    static Vector vector ;
    int selectedColor = Color.parseColor("#960000");
    TheSessionKeeper theSessionKeeper;

    private Context context;


    JSONArray questions,opt,answers;
    public QuizAdapter(JSONObject jsonObject ,Context context){
        theSessionKeeper = TheSessionKeeper.getInstance(context);
        if(jsonObject!=null)
        System.out.println("from quiz adpatrer"+jsonObject.toString());
        this.jsonObject = jsonObject;
        this.initArr();
        this.context=context;
        QuizAdapter.vector= new Vector(10);
        vector.setSize(10);

        System.out.println("vectro size is "+vector.size());


    }
    private void initArr(){
        try {
            questions = jsonObject.getJSONArray("questions");
            opt = jsonObject.getJSONArray("options");
            answers = jsonObject.getJSONArray("answers");
        }catch (JSONException je){
            je.printStackTrace();
        }
    }
        //this.jsonObjectList = jsonObjectList;}


    public class TheViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView question;
        TextView[] option = new TextView[4];
        public TheViewHolder(View itemView) {
            super(itemView);
            question = (TextView)itemView.findViewById(R.id.question);
            option[0] = (TextView)itemView.findViewById(R.id.option1);
            option[1] = (TextView)itemView.findViewById(R.id.option2);
            option[2] = (TextView)itemView.findViewById(R.id.option3);
            option[3] = (TextView)itemView.findViewById(R.id.option4);

            for(int  i=0;i<4;i++)
                option[i].setOnClickListener(this);


        }
        public void onClick(View view) {
            System.out.println(vector);
            int p=getAdapterPosition();
            switch (view.getId()){
                case R.id.option1:
                    System.out.println("case 1");
                    selectFlipper(0,p);
                    return;
                case R.id.option2:
                    selectFlipper(1,p);
                    return;
                case R.id.option3:
                    selectFlipper(2,p);
                    return;
                case R.id.option4:
                    selectFlipper(3,p);
                    return;
            }
        }

        void selectFlipper(int index,int adapterPos){
            System.out.println(option[index].getText());
            if(vector.contains(option[index].getText())){
                System.out.println("in true ");
                option[index].setBackgroundColor(Color.TRANSPARENT);
                vector.remove(option[index].getText());
            }else {
                System.out.println(option[index].getText());
                option[index].setBackgroundColor(selectedColor);
                vector.add(adapterPos,option[index].getText());
            }
        }


    }


    @Override
    public TheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_card, parent, false);
        return new TheViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TheViewHolder holder, int position) {

        try {
            System.out.println("JSONOBJECT ADAPTER->"+jsonObject);
            //holder.option[0].setText("hello world");
            System.out.println("Questions->"+jsonObject.getString("questions"));
            holder.question.setText(questions.getString(position));
            //JSONArray jsonArrayOptions = jsonObject.getJSONArray("options").getJSONArray(position);
                for(int i=0;i<4;i++)
                holder.option[i].setText(opt.getJSONArray(position).getString(i));
                //holder.option[i].setText("hello");



        }catch (JSONException je){je.printStackTrace();}

    }

    @Override
    public int getItemCount() {

        return (questions!=null)?questions.length():0;
    }

    public static Vector getAnswers(){
        if(vector.size()!=0)
        return vector;
        else return null;
    }


    public void sendScore(){
        try {


            int score1 = HouseKeeping.getScoreByVector(answers, vector);
            if (score1 > 0) {
                JSONObject scoreInc = new JSONObject();
                scoreInc.put("score", score1);
                scoreInc.put("uid",theSessionKeeper.get("uid"));
                theSessionKeeper.incrementScore(score1);
                new AsyncConnect(this.context, this.context.getString(R.string.link_incrementScore), scoreInc, new AsyncConnect.AsyncRevert() {
                    @Override
                    public void getJsonResponse(JSONObject jsonObject) {
                        //do something maybe...idk

                    }
                }).execute();
            }

        }catch (JSONException jsonEx){
            jsonEx.printStackTrace();
        }
    }



}
