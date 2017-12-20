package com.example.pivithuru.assignment04;

import android.content.Context;
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

    List<Map<String,?>> mdata;
    private Context mContext;
    private int lastPosition = -1;
    ViewHolder viewHolder;
    boolean sorted;


    public MovieAdapter(Context context,List<Map<String,?>> movieData) {
        mdata=movieData;
        sorted=false;
        mContext = context;
    }

    private Context getContext() {
        return mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();



        View movieView;


        // Inflate the custom layout


                if(viewType==getItemCount()-1 ||viewType==getItemCount()-2 || viewType==getItemCount()-3 ){
                    LayoutInflater inflater = LayoutInflater.from(context);

                    movieView = inflater.inflate(R.layout.movie_card_layout_3, parent, false);


                }
                else if(viewType==0 ||viewType==1 || viewType==2  ) {
                    LayoutInflater inflater = LayoutInflater.from(context);
                    movieView = inflater.inflate(R.layout.movie_card_layout_2, parent, false);
                }
                else{
                    LayoutInflater inflater = LayoutInflater.from(context);
                    movieView = inflater.inflate(R.layout.movie_card_layout, parent, false);
                }


        // Return a new holder instance
        viewHolder = new ViewHolder(movieView);




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        HashMap movie =(HashMap) mdata.get(position);

        // Set item views based on your views and data model

        final ImageView movieImageView=holder.imageView;
        int image=(Integer) movie.get("image");
        movieImageView.setImageResource(image);



        final TextView movieName=holder.nameTextView;
        movieName.setText(String.valueOf(movie.get("name")));

        final TextView description=holder.descriptionTextView;
        description.setText(String.valueOf(movie.get("description")));

        final RatingBar ratingbar=holder.ratingBar;
        float rating=Float.valueOf(String.valueOf(movie.get("rating")))/2;
        ratingbar.setRating(rating);

        final CheckBox checkBox=holder.checkBox;
        checkBox.setChecked((Boolean)mdata.get(position).get("selection"));

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                ((HashMap) mdata.get(position)).put("selection",checkBox.isChecked());



            }
        });
        ;

        //setAnimation ( holder . imageView , position );

    }


    @Override
    public int getItemCount() {
        return mdata.size();
    }

    public void delete(){


        for( int i=mdata.size()-1;i>=0;i--){
            if ((Boolean)mdata.get(i).get("selection")) {

                mdata.remove(i);
                notifyItemRemoved(i);

            }

        }

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
            checkBox=(CheckBox) itemView.findViewById(R.id.checkBox);

            itemView.setOnLongClickListener(new View.OnLongClickListener () {

                @Override
                public boolean onLongClick(View view) {
                    if (getAdapterPosition() != RecyclerView.NO_POSITION) {

                        int position=getAdapterPosition();

                        HashMap movie=(HashMap)mdata.get(position);

                        HashMap mCopy=createMovie(movie);

                        mdata.add(position+1,mCopy);

                        notifyItemInserted(position+1);
                    }

                    return true;

                }});
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {

                    AppCompatActivity activity = (AppCompatActivity) view.getContext();
                    int position=getAdapterPosition();
                    HashMap movie=(HashMap)mdata.get(position);

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, MovieDataFragment.newInstance(movie)).addToBackStack(null).commit();



                }
            });

        }


    }

    public List<Map<String,?>> sortMovieData(){
        List<Map<String,?>> sortedMData=new ArrayList<>();


        for(Map<String,?> movie: mdata ){
            int movieYear=Integer.valueOf((String)movie.get("year"));


                int index=0;

                    while ((index<sortedMData.size()) && (Integer.valueOf((String) sortedMData.get(index).get("year")) > movieYear)) {
                        index += 1;
                    }
                    if (index>sortedMData.size()){
                        sortedMData.add(movie);
                    }
                    else {
                        sortedMData.add(index, movie);
                    }



        }
        return sortedMData;

    }

    @Override
    public int getItemViewType ( int position ) {
        if (sorted) {
            return position;
        }
        else{
            return Integer.MAX_VALUE;
        }
    }

    private HashMap createMovie(HashMap oldmovie) {
        HashMap movie = new HashMap();
        movie.put("image",oldmovie.get("image"));
        movie.put("name", oldmovie.get("name"));
        movie.put("description", oldmovie.get("description"));
        movie.put("year", oldmovie.get("year"));
        movie.put("length",oldmovie.get("length"));
        movie.put("rating",oldmovie.get("rating"));
        movie.put("director",oldmovie.get("director"));
        movie.put("stars",oldmovie.get("stars"));
        movie.put("url",oldmovie.get("url"));
        movie.put("selection",false);
        return movie;
    }

}