package com.example.pivithuru.assignment04;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.ArrayList;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MovieListActivity extends AppCompatActivity {


//    private RecyclerView moviesRV;
//
//    private MovieAdapter mAdapter;
    Fragment mContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main);


        if(savedInstanceState==null) {
            mContent=MovieListFragment.newInstance();


        }

        else{
            mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");

        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent).commit();



    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"mContent",mContent);

    }


}



