package com.example.pivithuru.assignment07; //change the package name to your project's package name

import android.app.Fragment;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

import java.util.HashMap;

public class MyFirebaseRecylerAdapter extends FirebaseRecyclerAdapter<Movie, MyFirebaseRecylerAdapter.MovieViewHolder> {

    private Context mContext;

    static  MovieListFragment fragment;


    public MyFirebaseRecylerAdapter(Class<Movie> modelClass, int modelLayout,
                                    Class<MovieViewHolder> holder, DatabaseReference ref, Context context,MovieListFragment mFragment) {
        super(modelClass, modelLayout, holder, ref);
        this.mContext = context;
        this.fragment=mFragment;


//        LayoutInflater inflater = LayoutInflater.from(context);
//        movieView = inflater.inflate(R.layout.movie_card_layout, parent, false);
    }


    @Override
    protected void populateViewHolder(MovieViewHolder movieViewHolder, Movie movie, int i) {

        //TODO: Populate viewHolder by setting the movie attributes to cardview fields
        //movieViewHolder.nameTV.setText(movie.getName());



        // Set item views based on your views and data model

//
//        int image=(Integer) movie.get("image");
//        movieImageView.setImageResource(image);



        final TextView movieName=movieViewHolder.nameTextView;
        movieName.setText(String.valueOf(movie.getName()));

        final TextView description=movieViewHolder.descriptionTextView;
        description.setText(String.valueOf(movie.getDescription()));

        final RatingBar ratingbar=movieViewHolder.ratingBar;
        float rating=Float.valueOf(String.valueOf(movie.getRating()))/2;
        ratingbar.setRating(rating);

        System.out.println(movie.getImage());

        final ImageView movieImageView=movieViewHolder.imageView;
        MyUpdateImageHelper imageUpdate=new MyUpdateImageHelper(movieImageView);
        imageUpdate.execute(movie.getUrl());



    }

    //TODO: Populate ViewHolder and add listeners.
    public  static class MovieViewHolder extends RecyclerView.ViewHolder {

        public  TextView nameTextView;
        public ImageView imageView;
        public TextView descriptionTextView;
        public RatingBar ratingBar;
        public ImageView vMenu;

        public View v;

        public MovieViewHolder( View v) {
            super(v);

            nameTextView = (TextView) itemView.findViewById(R.id.movieName);
            imageView = (ImageView) itemView.findViewById(R.id.movieImage);
            descriptionTextView = (TextView) itemView.findViewById(R.id.description);
            ratingBar = (RatingBar) itemView.findViewById(R.id.ratingbar);
            vMenu = (ImageView) itemView.findViewById(R.id.overflow);
            this.v=v;


            if(vMenu!=null) {
                vMenu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(final View view) {
                        PopupMenu popUp = new PopupMenu(view.getContext(), view);

                        popUp.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {

//
//
                            @Override
                            public boolean onMenuItemClick(MenuItem item) {
                                int position = getAdapterPosition();
//                                View currentView=item.getActionView();
//                                AppCompatActivity ac= (AppCompatActivity) currentView.getContext();
//                                MovieListFragment movieListFrag=(MovieListFragment)ac.getSupportFragmentManager().findFragmentByTag("MovieListFragment");

                                switch (item.getItemId()) {
                                    case R.id.delete:
                                       fragment.delete(getAdapterPosition());
//
                                        return true;

                                    case R.id.copy:
                                        fragment.copy(getAdapterPosition());

                                        return true;

                                    default:
                                        return true;
                                }
                            }
                        });

                        MenuInflater inflator = popUp.getMenuInflater();
                        inflator.inflate(R.menu.contextual_menu, popUp.getMenu());
                        popUp.show();

                    }
                });
        }

        }

    }









    }


