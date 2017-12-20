package com.example.pivithuru.assignment04;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.CheckBox;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;
import jp.wasabeef.recyclerview.animators.SlideInUpAnimator;

/**
 * Created by pivithuru on 8/1/17.
 */

public class MovieListFragment extends Fragment implements View.OnClickListener{
    private RecyclerView moviesRV;

    private MovieAdapter mAdapter;
    private List<Map<String,?>> movieData;

    public MovieListFragment() {
        // Required empty public constructor
    }

    public void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState );
        // retain this fragment
        setRetainInstance ( true );

        if (savedInstanceState!=null){

                movieData=(List<Map<String,?>>)savedInstanceState.getSerializable("mdata");

        }
    }

    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putSerializable("mdata", (Serializable) mAdapter.mdata);
        outState.putSerializable("sorted",mAdapter.sorted);

    }

    // TODO: Rename and change types and number of parameters
    public static MovieListFragment newInstance() {
        MovieListFragment fragment = new MovieListFragment();


//        Bundle args = new Bundle();
//        args.putSerializable(ARG_SECTION_NUMBER, movie);
//        fragment.setArguments(args);
//

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
        if (movieData==null){
            movieData=new MovieData().getMoviesList();
        }
        mAdapter= new MovieAdapter(rootView.getContext(),movieData);

        // Attach the adapter to the recyclerview to populate items
        //moviesRV.setAdapter(mAdapter);

        moviesRV.setAdapter(new AlphaInAnimationAdapter(mAdapter));
        // Set layout manager to position the items

        GridLayoutManager lLayout = new GridLayoutManager(rootView.getContext(), 1);

        moviesRV.setLayoutManager(lLayout);

        Button selectAll=(Button) rootView.findViewById(R.id.selectALl);
        selectAll.setOnClickListener(this);

        Button clearAll=(Button) rootView.findViewById(R.id.clearAll);
        clearAll.setOnClickListener(this);

        Button delete=(Button) rootView.findViewById(R.id.delete);
        delete.setOnClickListener(this);

        Button sort=(Button) rootView.findViewById(R.id.sort);
        sort.setOnClickListener(this);

        return rootView;


    }


    @Override
    public void onClick(View view) {
        int id=view.getId();
        CheckBox cb;

        switch(id){
            case R.id.selectALl:
//                Intent intent = new Intent(FrontPageActivity.this,ViewPagerActivity.class);
//                startActivity(intent);

                for (int i = 0; i < mAdapter.mdata.size(); i++) {
                    ((HashMap) mAdapter.mdata.get(i)).put("selection",true);
                }

                mAdapter.notifyDataSetChanged();

                break;
            case R.id.clearAll:
                for (int i = 0; i < mAdapter.mdata.size(); i++) {
                ((HashMap) mAdapter.mdata.get(i)).put("selection",false);
        }

            mAdapter.notifyDataSetChanged();
                break;
            case R.id.delete:


                        mAdapter.delete();
                        //mAdapter.notifyItemRemoved(i);

                break;

            case R.id.sort:
                mAdapter.sorted=true;
                movieData=mAdapter.sortMovieData();
                mAdapter.mdata=movieData;
                mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());;
                break;

        }


    }




}
