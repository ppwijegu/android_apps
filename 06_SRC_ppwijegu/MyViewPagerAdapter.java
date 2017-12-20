package com.example.pivithuru.assignment06;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

/**
 * Created by pivithuru on 8/8/17.
 */

public class MyViewPagerAdapter extends FragmentPagerAdapter implements Serializable {
    int count=4;
    MovieData movieData;
    String url;

    AppCompatActivity activity;

    Fragment[] fragments=new Fragment[4];
    String[] urls=new String[]{"http://api.themoviedb.org/3/movie/now_playing?api_key=888b99ea99e94c4bbbaade0d434b3cc5","http://api.themoviedb.org/3/movie/popular?api_key=888b99ea99e94c4bbbaade0d434b3cc5",

            "http://api.themoviedb.org/3/movie/top_rated?api_key=888b99ea99e94c4bbbaade0d434b3cc5","http://api.themoviedb.org/3/movie/upcoming?api_key=888b99ea99e94c4bbbaade0d434b3cc5"};

    public MyViewPagerAdapter(FragmentManager fm, View view){
        super(fm);
        this.activity=(AppCompatActivity)view.getContext();

        initializeFragments();




    }

    private void initializeFragments(){

        for(int i=0;i<count;i++){
            fragments[i]=((ViewPagerActivity)activity).startRecyclerView(urls[i]);
        }
    }

    @Override
    public Fragment getItem(int position) {

        Fragment currentFragment=null;

        switch (position){
            case 0:
                url="http://api.themoviedb.org/3/movie/now_playing?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
                currentFragment=fragments[0];

                break;
            case 1:
                currentFragment=fragments[1];
               url="http://api.themoviedb.org/3/movie/popular?api_key=888b99ea99e94c4bbbaade0d434b3cc5";


                break;
            case 2:
                currentFragment=fragments[2];
               url="http://api.themoviedb.org/3/movie/top_rated?api_key=888b99ea99e94c4bbbaade0d434b3cc5";

                break;
            case 3:

                currentFragment=fragments[3];
                url="http://api.themoviedb.org/3/movie/upcoming?api_key=888b99ea99e94c4bbbaade0d434b3cc5";

                break;



        }
        ViewPagerActivity act= (ViewPagerActivity) activity;
        //currentFragment=act.startRecyclerView(url);
        act.mcontent=currentFragment;

       // return act.startRecyclerView(url);

        return currentFragment;
    }

    @Override
    public int getCount() {
        return count;
    }

    public CharSequence getPageTitle(int position) {


//            HashMap<String,?> movie =(HashMap<String,?>) movieData.getItem(position);
//            String name=(String)movie.get("name");

        String name="";

        switch (position) {
            case 0:
                name="Now Playing";
                break;
            case 1:


                name= "Popular";
                break;
            case 2:

                name= "Top Rated";
                break;

            case 3:
                name= "Upcoming";
                break;

        }

        return name;

    }



}