package com.example.alienware.englisherudition;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;


public class    MainActivity extends AppCompatActivity implements ChangeFrag{


    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    Login login;
    HomepageFrag homepageFrag;
    TheSessionKeeper theSessionKeeper;
    CoordinatorLayout coordinatorLayout;
    static FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        coordinatorLayout = (CoordinatorLayout)findViewById(R.id.mainCoordinator);
        frameLayout = (FrameLayout)findViewById(R.id.frame);
        fragmentManager = getSupportFragmentManager();
        login = new Login();
        homepageFrag = new HomepageFrag();
        theSessionKeeper = TheSessionKeeper.getInstance(getApplicationContext());
        if(theSessionKeeper.isFirstTime()){
            bringChange(new IntroSlider());
        }else{
            if (theSessionKeeper.isLoggedIn()) {
                //frag for login_success
                bringChange(homepageFrag);
            }
            else {
                //frag for login
                bringChange(login);
            }
        }

    }



    @Override
    public void bringChange(Fragment fragment) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(frameLayout.getId(), fragment);
        fragmentTransaction.commit();
    }
}

