package com.example.alienware.englisherudition;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alienware on 01-02-2017.
 */

public class HomepageFrag extends Fragment {


    BottomNavigationView bottomNavigationView;
    HomeFrag homeFrag;
    TimelineFrag timelineFrag;
    ProfileFrag profileFrag;
    LoginSuccess loginSuccess;

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainview,container,false);

        homeFrag = new HomeFrag();
        timelineFrag = new TimelineFrag();
        profileFrag = new ProfileFrag();
        loginSuccess = new LoginSuccess();


        fragmentManager = getFragmentManager();
        changeFragment(homeFrag);
        bottomNavigationView = (BottomNavigationView)view.findViewById(R.id.bottom_nav);

        //final BottomNavigationView.OnNavigationItemSelectedListener bottomNavViewListener;
        //bottomNavigationView.getMenu().getItem(R.id.home).setEnabled(true);
        //bottomNavigationView.getMenu().getItem(R.id.home).setChecked(true);
        //bottomNavigationView.getMenu().performIdentifierAction(0,2);
        //onNavigationItemSelected(navigationView.getMenu().getItem(0));


        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.timeline:
                        changeFragment(timelineFrag);
                        return true;

                    case R.id.home:
                        changeFragment(homeFrag);
                        return true;

                    case R.id.profile:
                        changeFragment(loginSuccess);
                        return true;

                    default:
                        return true;
                }
            }
        });

        //bottomNavViewListener.onNavigationItemSelected(bottomNavigationView.getMenu().getItem(2));


        return view;
    }


    public void changeFragment(Fragment frag) {
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,frag);
        fragmentTransaction.commit();
    }

}
