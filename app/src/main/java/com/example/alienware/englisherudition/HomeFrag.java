package com.example.alienware.englisherudition;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Alienware on 01-02-2017.
 */

public class HomeFrag extends Fragment {
    ReadingFrag readingFrag;
    ListeningFrag listeningFrag;
    WritingFrag writingFrag;
    TabLayout tabLayout;
    View view;
    ViewPager viewPager;
    ChangeFrag tc;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home,container,false);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
        tc = (ChangeFrag)getActivity();
        readingFrag = new ReadingFrag();
        writingFrag = new WritingFrag();
        listeningFrag = new ListeningFrag();
        if(viewPager!=null) setViewPager(viewPager);
        tabLayout = (TabLayout)view.findViewById(R.id.tab);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.writing);
        tabLayout.getTabAt(1).setIcon(R.drawable.reading);
        tabLayout.getTabAt(2).setIcon(R.drawable.listening);

        return view;
    }

    void setViewPager(ViewPager viewPager){
        ThePager thePager = new ThePager(getFragmentManager());
        thePager.addFragment(writingFrag, getString(R.string.writing));
        thePager.addFragment(readingFrag, getString(R.string.reading));
        thePager.addFragment(listeningFrag, getString(R.string.listening));
        viewPager.setAdapter(thePager);
    }

}
