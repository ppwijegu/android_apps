package com.example.pivithuru.assignment06;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MovieDataFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";


    public MovieDataFragment() {
        // Required empty public constructor
    }

    public void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState );
        // retain this fragment
        setRetainInstance ( true );
    }

    // TODO: Rename and change types and number of parameters
    public static MovieDataFragment newInstance(String movieID) {
        MovieDataFragment fragment = new MovieDataFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION_NUMBER, movieID);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.movie_layout, container, false);




       String movieID=(String) getArguments().getSerializable(ARG_SECTION_NUMBER);



        setMovieData(rootView,movieID);
        return rootView;


    }

    private void setMovieData(View view,String movieID){

        final ImageView movieImageView=(ImageView) view.findViewById(R.id.movieImage) ;
        final TextView movieName=(TextView)  view.findViewById(R.id.movieName);
        final TextView description=(TextView)  view.findViewById(R.id.description);
        final TextView length=(TextView)  view.findViewById(R.id.length);
        final TextView year=(TextView)  view.findViewById(R.id.year);
        final RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);
        final TextView director=(TextView)  view.findViewById(R.id.director);
        final TextView stars=(TextView)  view.findViewById(R.id.stars);



        MyMovieInformationHelper infoHelper=new MyMovieInformationHelper(movieImageView,movieName,description,length,year,director,stars,ratingBar);
        String url="http://api.themoviedb.org/3/movie/"+movieID+"?api_key=888b99ea99e94c4bbbaade0d434b3cc5";
        infoHelper.execute(url);










//        movieName.setText(String.valueOf(movie.get("name")));
//
//
//        description.setText(String.valueOf(movie.get("description")));
//
//
//        length.setText(String.valueOf(movie.get("length")));
//
//
//        year.setText(String.valueOf(movie.get("year")));
//
////        final TextView rating=(TextView)  view.findViewById(R.id.rating);
////
////        rating.setText(String.valueOf(movie.get("rating")));
//
//
//
//        float rating=Float.valueOf(String.valueOf(movie.get("rating")))/2;
//        ratingBar.setRating(rating);
//
//
//        director.setText(String.valueOf(movie.get("director")));
//
//
//        stars.setText(String.valueOf(movie.get("stars")));
//
////        final TextView url=(TextView)  view.findViewById(R.id.url);
////        url.setText(String.valueOf(movie.get("url")));




    }






}
