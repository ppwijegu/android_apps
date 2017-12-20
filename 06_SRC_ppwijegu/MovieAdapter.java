package com.example.pivithuru.assignment06;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    List<HashMap<String,?>> mdata;
    private Context mContext;
    private int lastPosition = -1;
    ViewHolder viewHolder;


    public MovieAdapter(Context context,List<HashMap<String,?>> movieData) {
        mdata=movieData;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();



        View movieView;


        LayoutInflater inflater = LayoutInflater.from(context);
        movieView = inflater.inflate(R.layout.movie_card_layout, parent, false);

        // Return a new holder instance
        viewHolder = new ViewHolder(movieView);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        HashMap movie =(HashMap) mdata.get(position);

        // Set item views based on your views and data model

        final ImageView movieImageView=holder.imageView;
        String posterPath=(String)movie.get("image");

        String imageUrl=" http://image.tmdb.org/t/p/w185/"+posterPath;

        System.out.println(imageUrl);

        MyUpdateImageHelper imageUpdate=new MyUpdateImageHelper(movieImageView);
        imageUpdate.execute(imageUrl);
        //int image=(Integer) movie.get("image");
        //movieImageView.setImageResource(image);



        final TextView movieName=holder.nameTextView;
        movieName.setText(String.valueOf(movie.get("name")));

        final TextView description=holder.descriptionTextView;
        description.setText(String.valueOf(movie.get("description")));

        final RatingBar ratingbar=holder.ratingBar;
        float rating=Float.valueOf(String.valueOf(movie.get("rating")))/2;
        ratingbar.setRating(rating);


        //setAnimation ( holder . imageView , position );

    }


    @Override
    public int getItemCount() {
        return mdata.size();
    }



    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView nameTextView;
        public ImageView imageView;
        public TextView descriptionTextView;
        public RatingBar ratingBar;
        public CheckBox checkBox;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            nameTextView = (TextView) itemView.findViewById(R.id.movieName);
            imageView = (ImageView) itemView.findViewById(R.id.movieImage);
            descriptionTextView=(TextView) itemView.findViewById(R.id.description);
            ratingBar=(RatingBar) itemView.findViewById(R.id.ratingbar);


            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    ViewPagerActivity activity = (ViewPagerActivity) view.getContext();

                    int position=getAdapterPosition();
                    HashMap movie=(HashMap)mdata.get(position);

                    activity.startMovieFragment((String)movie.get("id"));

                }
            });

        }


    }





}