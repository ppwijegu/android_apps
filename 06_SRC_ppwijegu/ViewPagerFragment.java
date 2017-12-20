package com.example.pivithuru.assignment06;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by pivithuru on 8/8/17.
 */

public class ViewPagerFragment extends Fragment {


    ViewPager mViewPager;
    MovieData movieData;






    public ViewPagerFragment() {
        // Required empty public constructor
    }

    public void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState );
        // retain this fragment
        setRetainInstance ( true );


    }


    // TODO: Rename and change types and number of parameters
    public static ViewPagerFragment newInstance() {
        ViewPagerFragment fragment = new ViewPagerFragment();


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment  call each fragment layout here based on selected option


        View rootView = null;
        rootView = inflater.inflate(R.layout.activity_view_pager, container, false);


        movieData=new MovieData();

        //movieData=new MovieData();
        mViewPager=(ViewPager) rootView.findViewById(R.id.pager);
        final TabLayout tabLayout=(TabLayout) rootView.findViewById(R.id.tab_layout);
//        MyViewPagerAdapter adapter= (MyViewPagerAdapter) getArguments().getSerializable("Adapter");
//        mViewPager.setAdapter(adapter);
        mViewPager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager(),rootView));
        mViewPager.setCurrentItem(1);



        tabLayout.setupWithViewPager(mViewPager);




        mViewPager.setPageTransformer(false,new ViewPager.PageTransformer(){

            @Override
            public void transformPage(View page, float position) {
                final float normalizedPosition=Math.abs(Math.abs(position)-1);
                page.setScaleX(normalizedPosition/2+0.5f);
                page.setScaleY(normalizedPosition/2+0.5f);
            }
        });







        return rootView;


    }



}
