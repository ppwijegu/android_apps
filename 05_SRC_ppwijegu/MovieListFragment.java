package com.example.pivithuru.assignment05;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    MovieAdapter mAdapter;
    private List<Map<String,?>> movieData;
    private MovieData allMData=new MovieData();


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

        setHasOptionsMenu(true);
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




        return rootView;


    }





    @Override
    public void onClick(View view) {
        int id=view.getId();
        CheckBox cb;

//        switch(id){
//            case R.id.selectALl:
////                Intent intent = new Intent(FrontPageActivity.this,ViewPagerActivity.class);
////                startActivity(intent);
//
//                for (int i = 0; i < mAdapter.mdata.size(); i++) {
//                    ((HashMap) mAdapter.mdata.get(i)).put("selection",true);
//                }
//
//                mAdapter.notifyDataSetChanged();
//
//                break;
//            case R.id.clearAll:
//                for (int i = 0; i < mAdapter.mdata.size(); i++) {
//                ((HashMap) mAdapter.mdata.get(i)).put("selection",false);
//        }
//
//            mAdapter.notifyDataSetChanged();
//                break;
//            case R.id.delete:
//
//
//                        mAdapter.delete();
//                        //mAdapter.notifyItemRemoved(i);
//
//                break;
//
//            case R.id.sort:
//                mAdapter.sorted=true;
//                movieData=mAdapter.sortMovieData();
//                mAdapter.mdata=movieData;
//                mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());;
//                break;
//
//        }


    }

//    public void sortMovieData(String type,String toolBar){
//
//        MovieListActivityTaskThree movieListActivity=(MovieListActivityTaskThree) getActivity();
//        Menu toolBottom=movieListActivity.mToolBarBottom.getMenu();
//        Menu toolTop=movieListActivity.mToolbar.getMenu();
//
//        MenuItem nameItemBottom=toolBottom.findItem(R.id.sort_name);
//        MenuItem yearItemBottom=toolBottom.findItem(R.id.sort_year);
//
//        MenuItem nameItemTop=toolTop.findItem(R.id.sort_name);
//        MenuItem yearItemTop=toolTop.findItem(R.id.sort_year);
//
//        if(type.equals("by_year")){
//                //mAdapter.sorted=true;
//
//
//
//
//            if(toolBar=="top"){
//                yearItemTop.setVisible(true);
//                nameItemTop.setVisible(true);
//
//                yearItemBottom.setVisible(false);
//                nameItemBottom.setVisible(true);
//            }
//            if(toolBar=="bottom"){
//                yearItemTop.setVisible(false);
//                nameItemTop.setVisible(true);
//
//                yearItemBottom.setVisible(true);
//                nameItemBottom.setVisible(true);
//            }
//
//
//                movieData=mAdapter.sortMovieDataByYear();
//                mAdapter.mdata=movieData;
//                mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());
//        }
//
//        else{
//            //mAdapter.sorted=true;
//
//            if(toolBar=="top"){
//                yearItemTop.setVisible(true);
//                nameItemTop.setVisible(true);
//
//                yearItemBottom.setVisible(true);
//                nameItemBottom.setVisible(false);
//            }
//            if(toolBar=="bottom"){
//                yearItemTop.setVisible(true);
//                nameItemTop.setVisible(false);
//
//                yearItemBottom.setVisible(true);
//                nameItemBottom.setVisible(true);
//            }
//
//            movieData=mAdapter.sortMovieDataByName();
//            mAdapter.mdata=movieData;
//            mAdapter.notifyItemRangeChanged(0, mAdapter.getItemCount());;
//        }
//
//    }

    @Override
    public void onCreateOptionsMenu (Menu menu, MenuInflater inflater) {
        if (menu.findItem(R.id.search)==null) {
            inflater.inflate(R.menu.movie_list_menu, menu);

        }
        SearchView search=(SearchView) menu.findItem(R.id.search).getActionView();
        if(search!=null){
            search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    int position=allMData.findFirst(query);
                    if (position>0){
                        moviesRV.scrollToPosition(position);
                    }
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    return false;
                }
            });
        }

//        MenuItem sort_name=menu.findItem(R.id.sort_name);
//        MenuItem sort_year=menu.findItem(R.id.sort_year);
//
//        if (sort_name!=null){
//            sort_name.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                @Override
//                public boolean onMenuItemClick(MenuItem menuItem) {
//
//                    sortMovieData("by_name","top");
//                    return true;
//                }
//            });
//        }
//
//
//        if (sort_year!=null){
//            sort_year.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
//                @Override
//                public boolean onMenuItemClick(MenuItem menuItem) {
//
//                    sortMovieData("by_year","top");
//                    return true;
//                }
//            });
//        }
        super.onCreateOptionsMenu(menu,inflater);

    }


}
