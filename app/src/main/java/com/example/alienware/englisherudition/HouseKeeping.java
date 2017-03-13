package com.example.alienware.englisherudition;

import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Enumeration;
import java.util.Vector;

/**
 * Created by Alienware on 05-02-2017.
 */

public class HouseKeeping {

//for creating Json from Strings
    JSONObject createJson(String... strings){
        JSONObject jsonObject = new JSONObject();
        int i =0;
        try {
            while (i<strings.length){
                jsonObject.put(strings[i],strings[i+1]);
                i+=2;
            }
            System.out.print("JSON->> "+jsonObject);
            return jsonObject;
        }catch (Exception e){e.printStackTrace();}
        return null;
    }


//to check if login and sign up fields are empty
    static boolean areFieldsEmpty(EditText... myStrings){
        for(EditText s: myStrings)
            if(s.getText().toString().equals(""))
                return true;
        return false;
    }


    static String passwordToSend(String user_name ,String password){
        StringBuilder result = new StringBuilder();
        int userLength = user_name.length();
        int mid = userLength/2;
        for (int i=0;i<userLength;i++){
            result.append(user_name.charAt(i));
            if(i==mid){
                for (int j = 0; j < password.length(); j++) result.append(password.charAt(j));
            }
        }
        result.append(password+user_name);
        String encode = user_name+password+result.toString();
        return sha256(encode);
        //return encode;
    }

    static String sha256(String toencode){
        String decoded=null;
        try {
            MessageDigest messageDigest =MessageDigest.getInstance("SHA-256");
            byte[] hash = messageDigest.digest(toencode.toString().getBytes());
            decoded = new BigInteger(1,hash).toString(16);
        }catch (NoSuchAlgorithmException e){e.printStackTrace();}

        return decoded;
    }

    static int calLevel(int score){
        int level=0;


        return level;

    }



    static public int getScoreByVector(JSONArray answers, Vector userAnswers){

        int i=0,score=0;

            //JSONArray correctAns = new JSONArray(jsonObject.getJSONArray("answers"));

            //Vector answers = QuizAdapter.getAnswers();
            if(userAnswers!=null){
                Enumeration e = userAnswers.elements();
                while (e.hasMoreElements()){
                    Object element = e.nextElement();
                    if(element!=null){

                        try {
                            System.out.println(element+"&&"+answers.get(i));
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                        try {
                            if(element.equals(answers.get(i++))){
                                score++;
                            }
                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                    }

                return score;
        }
          return 0;
    }




 //to encode and decode password

}
