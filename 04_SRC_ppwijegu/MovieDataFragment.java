package com.example.pivithuru.assignment04;


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
    public static MovieDataFragment newInstance(HashMap<String,?> movie) {
        MovieDataFragment fragment = new MovieDataFragment();

        Bundle args = new Bundle();
        args.putSerializable(ARG_SECTION_NUMBER, movie);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View rootView = inflater.inflate(R.layout.move_layout_2, container, false);


        HashMap<String,?> movie=(HashMap<String,?>) getArguments().getSerializable(ARG_SECTION_NUMBER);



        setMovieData(rootView,movie);
        return rootView;


    }

    private void setMovieData(View view,HashMap<String,?> movie){



        int image=(Integer) movie.get("image");

        final ImageView movieImageView=(ImageView) view.findViewById(R.id.movieImage) ;

        movieImageView.setImageResource(image);



        final TextView movieName=(TextView)  view.findViewById(R.id.movieName);
        movieName.setText(String.valueOf(movie.get("name")));

        final TextView description=(TextView)  view.findViewById(R.id.description);
        description.setText(String.valueOf(movie.get("description")));

        final TextView length=(TextView)  view.findViewById(R.id.length);
        length.setText(String.valueOf(movie.get("length")));

        final TextView year=(TextView)  view.findViewById(R.id.year);
        year.setText(String.valueOf(movie.get("year")));

//        final TextView rating=(TextView)  view.findViewById(R.id.rating);
//
//        rating.setText(String.valueOf(movie.get("rating")));


        final RatingBar ratingBar = (RatingBar) view.findViewById(R.id.ratingbar);
        float rating=Float.valueOf(String.valueOf(movie.get("rating")))/2;
        ratingBar.setRating(rating);

        final TextView director=(TextView)  view.findViewById(R.id.director);
        director.setText(String.valueOf(movie.get("director")));

        final TextView stars=(TextView)  view.findViewById(R.id.stars);
        stars.setText(String.valueOf(movie.get("stars")));

//        final TextView url=(TextView)  view.findViewById(R.id.url);
//        url.setText(String.valueOf(movie.get("url")));




    }
}
