package com.example.alienware.englisherudition;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alienware on 01-02-2017.
 */

public class ProfileFrag extends Fragment {
    ChangeFrag changeFrag;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.profile,container,false);
        return view;
    }
}