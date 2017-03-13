package com.example.alienware.englisherudition;

import android.content.Context;
import android.content.SharedPreferences;


/**
 * Created by Alienware on 17-01-2017.
 */

public class TheSessionKeeper {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;
    private static TheSessionKeeper theSessionKeeper;
    private static final String file = "EnglishBoi";
    private static final String isFirstTime = "isFirstTime";
    private static final String isLoggedIn = "LoggedIn";
    private static final int mode =0; //private mode
    private static final String[] fields = {"uid","name","user_name","email","score","dateOfCreation"};

    public TheSessionKeeper(Context c){
        this.context = c;
        sharedPreferences = context.getSharedPreferences(file,mode);
    }
    public static synchronized TheSessionKeeper getInstance(Context context){
        if(theSessionKeeper==null) theSessionKeeper = new TheSessionKeeper(context);
        return theSessionKeeper;
    }

    public void setIsFirstTime(boolean bool){
        editor = sharedPreferences.edit();
        editor.putBoolean(isFirstTime,bool);
        editor.apply();
    }

    public void setIsLoggedIn(boolean loggedIn,String... info){
        editor = sharedPreferences.edit();
        editor.putBoolean(isLoggedIn,loggedIn);
        for (int i =0 ;i < info.length;i++){
            editor.putString(fields[i],info[i]);
            editor.apply();
        }
    }

    public void logOut(){
        editor = sharedPreferences.edit();
        editor.putBoolean(isLoggedIn,false);
        editor.apply();
    }

    public boolean isFirstTime(){
        return sharedPreferences.getBoolean(isFirstTime, true);

    }
    public boolean isLoggedIn(){
        return sharedPreferences.getBoolean(isLoggedIn, false);
    }


    public String get(String toGet){
        return sharedPreferences.getString(toGet,null);
    }

   public int getLevel(){
       return Integer.parseInt(sharedPreferences.getString("score","0"));

       //return HouseKeeping.calLevel(score);
   }

    public void incrementScore(int score){
        editor = sharedPreferences.edit();
        editor.putString("score",""+(Integer.parseInt(get("score"))+score));

        editor.apply();
    }

    /*public void bomb(){
        for (String holder:fields){
            editor.putString(holder,"");
        }

    }*/

}


