package com.example.pivithuru.assignment3;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MasterDetailActivity extends AppCompatActivity implements MasterDetailFragment.OnButtonSelectedListener {

    private boolean mTwoPane=false;
   // private int movieID=0;
    private MovieData movieData;
    private MasterDetailFragment mFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.master_detail_layout);

        movieData=new MovieData();

        if( findViewById (R. id . detail_container ) != null ){
            mTwoPane = true ;
        }


        if (savedInstanceState!=null){

            mFragment = (MasterDetailFragment)getSupportFragmentManager().getFragment(savedInstanceState, "master");


        }
        else {

            mFragment = MasterDetailFragment.newInstance(R.id.master);



        }

        getSupportFragmentManager().beginTransaction().replace(R.id.master_container, mFragment).commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        getSupportFragmentManager().putFragment(outState, "master", mFragment);
    }


    @Override
    public void onButtonSelected(int id) {


        change_movieID(id);

        HashMap<String,?> movie=movieData.getItem(mFragment.value);

        final TextView solutionTextView=(TextView) findViewById(R.id.solutionTextView);
        solutionTextView.setText(Integer.toString(mFragment.value));

        if (mTwoPane) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.detail_container, MovieDataFragment.newInstance(movie)).addToBackStack(null)
                    .commit();
      }

        else{
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.master_container, MovieDataFragment.newInstance(movie)).addToBackStack(null)
                    .commit();

        }


    }

    public void change_movieID(int id){

        if(id==R.id.buttonPlus){

            if (mFragment.value<movieData.getSize()-1) {
                mFragment.value+=1;
            }


        }

        if(id==R.id.buttonMinus){

            if (mFragment.value>0) {
                mFragment.value -= 1;
            }


        }



    }


}
