package com.example.pivithuru.assignment06;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.CheckBox;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by pivithuru on 8/1/17.
 */

public class MovieListFragment extends Fragment {
    private RecyclerView moviesRV;

    private MovieAdapter mAdapter;

    List<HashMap<String,?>> mData;




    public MovieListFragment() {
        // Required empty public constructor
    }

    public void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState );

        setRetainInstance ( true );

        if (savedInstanceState!=null){

            mData= (List<HashMap<String,?>>) savedInstanceState.getSerializable("mdata");

        }


    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("mdata", (Serializable) mAdapter.mdata);

    }

    // TODO: Rename and change types and number of parameters
    public static MovieListFragment newInstance(String url) {
        MovieListFragment fragment = new MovieListFragment();

        Bundle args = new Bundle();
        args.putSerializable("DataURL", (Serializable) url);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment  call each fragment layout here based on selected option


        View rootView = null;
        rootView = inflater.inflate(R.layout.activity_movies, container, false);



        moviesRV = (RecyclerView) rootView.findViewById(R.id.rvContacts);
        SlideInUpAnimator animator = new SlideInUpAnimator(new OvershootInterpolator(1f));
        moviesRV.setItemAnimator(new SlideInLeftAnimator());


        // Create adapter passing in the sample user data


        mAdapter= new MovieAdapter(rootView.getContext(),new ArrayList<HashMap<String, ?>>());

        String url= (String) getArguments().getSerializable("DataURL");

        if (mData==null){
            MyDownloadDataHelper worker=new MyDownloadDataHelper(url,mAdapter);

            worker.execute();

        }

        else{
            mAdapter.mdata=mData;
            mAdapter.notifyDataSetChanged();
        }




        // Attach the adapter to the recyclerview to populate items
        //moviesRV.setAdapter(mAdapter);

        moviesRV.setAdapter(new AlphaInAnimationAdapter(mAdapter));
        // Set layout manager to position the items

        GridLayoutManager lLayout = new GridLayoutManager(rootView.getContext(), 1);

        moviesRV.setLayoutManager(lLayout);


        return rootView;


    }

    public void setMData(List<HashMap<String,?>> moviedata){

    }





}
