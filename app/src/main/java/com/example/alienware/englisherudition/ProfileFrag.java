package com.example.alienware.englisherudition;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Alienware on 01-02-2017.
 */

public class ProfileFrag extends Fragment {
    TextView name,user_name,score,email,date;
    TheSessionKeeper theSessionKeeper;
    FloatingActionButton logout;
    ChangeFrag tc;
    CoordinatorLayout coordinatorLayout;
    JSONObject jsonObject;
    String errorMessage = "beeepboooppp! errrr!!!! Looks like you're trapped here for Ever :{) ";
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        tc = (ChangeFrag)getActivity();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile,container,false);

        theSessionKeeper = TheSessionKeeper.getInstance(getContext());
        coordinatorLayout = (CoordinatorLayout)view.findViewById(R.id.profile_coordinator);
        name = (TextView)view.findViewById(R.id.profile_name);
        user_name = (TextView)view.findViewById(R.id.profile_username);
        score = (TextView)view.findViewById(R.id.profile_score);
        email = (TextView)view.findViewById(R.id.profile_email);
        date = (TextView)view.findViewById(R.id.profile_date);

        name.setText(theSessionKeeper.get("name"));
        user_name.setText(theSessionKeeper.get("user_name"));
        score.setText(theSessionKeeper.get("score"));
        email.setText(theSessionKeeper.get("email"));
        date.setText(theSessionKeeper.get("dateOfCreation"));

        logout = (FloatingActionButton)view.findViewById(R.id.logout);
        logout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        //frag for login
                        try {
                            jsonObject = new JSONObject();
                            jsonObject.put("uid", theSessionKeeper.get("uid"));
                        }catch (JSONException e){e.printStackTrace();}

                        new AsyncConnect(getContext(),getString(R.string.link_logOut),jsonObject, new AsyncConnect.AsyncRevert() {
                            @Override
                            public void getJsonResponse(JSONObject jsonObject) {
                                try {
                                    if (jsonObject.getBoolean("error")) {
                                        Snackbar.make(coordinatorLayout, errorMessage, Snackbar.LENGTH_SHORT).show();
                                    }else {
                                        theSessionKeeper.logOut();
                                        tc.bringChange(new Login());
                                    }
                                }catch (JSONException e){e.printStackTrace();}

                            }
                        }).execute();

                        return true;
                }
                return true;
            }
        });
        return view;
    }
}
