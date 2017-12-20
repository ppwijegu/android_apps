package com.example.pivithuru.assignment06;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by pivithuru on 7/25/17.
 */

public class ViewPagerActivity extends AppCompatActivity {

    Fragment mcontent;
    //List<HashMap>[] viewPagerData=new ArrayList<HashMap<String,?>>[4];



    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpager_helper_layout);




        if (savedInstanceState==null) {
            mcontent=ViewPagerFragment.newInstance();

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.view_pager_helper, mcontent).commit();
        }

        else{
            mcontent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.view_pager_helper, mcontent).commit();
        }

    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"mContent",mcontent);

    }

    public void startMovieFragment(String movieID){


       mcontent=MovieDataFragment.newInstance(movieID);


        getSupportFragmentManager().beginTransaction().replace(R.id.view_pager_helper, mcontent).addToBackStack(null).commit();

    }

public Fragment startRecyclerView(String url){






    return MovieListFragment.newInstance(url);

}
//    ViewPager mViewPager;
//    MovieData movieData;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState){
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.activity_view_pager);
//        movieData=new MovieData();
//
//        //movieData=new MovieData();
//        mViewPager=(ViewPager) findViewById(R.id.pager);
//        final TabLayout tabLayout=(TabLayout) findViewById(R.id.tab_layout);
//        mViewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager(),movieData.getSize(),movieData));
//        mViewPager.setCurrentItem(1);
//
//
//
//        tabLayout.setupWithViewPager(mViewPager);
//
//
//
//
//        mViewPager.setPageTransformer(false,new ViewPager.PageTransformer(){
//
//            @Override
//            public void transformPage(View page, float position) {
//                final float normalizedPosition=Math.abs(Math.abs(position)-1);
//                page.setScaleX(normalizedPosition/2+0.5f);
//                page.setScaleY(normalizedPosition/2+0.5f);
//            }
//        });
//
//
//
//
//
//
//    }
//
//

//    private class MyViewPagerAdapter extends FragmentStatePagerAdapter {
//        int count=4;
//        MovieData movieData;
//        String url;
//
//
//        public MyViewPagerAdapter(FragmentManager fm, int size,MovieData movieInfo){
//            super(fm);
//            count=size;
//            movieData=movieInfo;
//
//        }
//        @Override
//        public Fragment getItem(int position) {
//
//            switch (position){
//                case 1:
//                    url="http://api.themoviedb.org/3/movie/now_playing?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
//
//
//                    break;
//                case 2:
//
//                    url="http://api.themoviedb.org/3/movie/popular?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
//
//
//                    break;
//                case 3:
//                    url="http://api.themoviedb.org/3/movie/top_rated?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
//
//
//                    break;
//                case 4:
//                    url="http://api.themoviedb.org/3/movie/upcoming?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
//
//                    break;
//
//
//
//            }
//
//            return MovieListFragment.newInstance(url);
//        }
//
//        @Override
//        public int getCount() {
//            return count;
//        }
//
//        public CharSequence getPageTitle(int position) {
//
//
////            HashMap<String,?> movie =(HashMap<String,?>) movieData.getItem(position);
////            String name=(String)movie.get("name");
//
//            String name="";
//
//            switch (position) {
//                case 1:
//                    name="Now Playing";
//                    break;
//                case 2:
//
//
//                    name= "Popular";
//                    break;
//                case 3:
//
//                    name= "Top Rated";
//                    break;
//
//                case 4:
//                    name= "Upcoming";
//                    break;
//
//            }
//
//            return name;
//
//        }
//
//
//
//    }


}
