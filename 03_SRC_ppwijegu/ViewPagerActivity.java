package com.example.pivithuru.assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.support.design.widget.TabLayout;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Locale;


/**
 * Created by pivithuru on 7/25/17.
 */

public class ViewPagerActivity extends AppCompatActivity {

    ViewPager mViewPager;
    MovieData movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_pager);
        movieData=new MovieData();

        //movieData=new MovieData();
        mViewPager=(ViewPager) findViewById(R.id.pager);
        final TabLayout tabLayout=(TabLayout) findViewById(R.id.tab_layout);
        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),movieData.getSize(),movieData));
        mViewPager.setCurrentItem(3);


//        mViewPager.addOnPageChangeListener(
//                new TabLayout.TabLayoutOnPageChangeListener(tabLayout)
//        );
//        tabLayout.post(new Runnable() {
//            @Override
//            public void run() {
//                tabLayout.setupWithViewPager(mViewPager);
//            }
//        });
        tabLayout.setupWithViewPager(mViewPager);




        mViewPager.setPageTransformer(false,new ViewPager.PageTransformer(){

            @Override
            public void transformPage(View page, float position) {
                final float normalizedPosition=Math.abs(Math.abs(position)-1);
                page.setScaleX(normalizedPosition/2+0.5f);
                page.setScaleY(normalizedPosition/2+0.5f);
            }
        });






    }



    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
        int count;
        MovieData movieData;

        public MyViewPagerAdapter(FragmentManager fm, int size,MovieData movieInfo){
            super(fm);
            count=size;
            movieData=movieInfo;

        }
        @Override
        public Fragment getItem(int position) {

            return MovieDataFragment.newInstance((HashMap<String,?>) movieData.getItem(position));
        }

        @Override
        public int getCount() {
            return count;
        }

        public CharSequence getPageTitle(int position){


            HashMap<String,?> movie =(HashMap<String,?>) movieData.getItem(position);
            String name=(String)movie.get("name");



            return name;



        }
    }

}
