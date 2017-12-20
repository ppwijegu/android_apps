package com.example.pivithuru.assignment06;

import android.graphics.Bitmap;
import android.media.Image;
import android.os.AsyncTask;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.lang.ref.WeakReference;
import java.util.HashMap;

/**
 * Created by pivithuru on 8/8/17.
 */

public class MyMovieInformationHelper  extends AsyncTask<String, Void, HashMap> {

    private final WeakReference<ImageView> movieImageReference;
    private final WeakReference<TextView> movieNameReference;
    private final WeakReference<TextView> movieDescriptionReference;
    private final WeakReference<TextView> movieLengthReference;
    private final WeakReference<TextView> movieYearReference;
    private final WeakReference<TextView> movieStarsReference;
    private final WeakReference<TextView> movieDirectorReference;
    private final WeakReference<RatingBar> ratingBarReference;

    public MyMovieInformationHelper(ImageView movieImageView, TextView movieName, TextView description, TextView length, TextView year, TextView stars, TextView director, RatingBar ratingBar){

        movieImageReference=new WeakReference<ImageView>(movieImageView);
        movieNameReference=new WeakReference<TextView>(movieName);
        movieDescriptionReference=new WeakReference<TextView>(description);
        movieLengthReference=new WeakReference<TextView>(length);
        movieYearReference=new WeakReference<TextView>(year);
        movieStarsReference=new WeakReference<TextView>(stars);
        movieDirectorReference=new WeakReference<TextView>(director);
        ratingBarReference=new WeakReference<RatingBar>(ratingBar);



    }
    @Override
    protected HashMap doInBackground(String... urls) {

        HashMap movieInfo=new HashMap();

        for (String url:urls){

            String results=MyUtility.downloadJSONusingHTTPGetRequest(url);

            System.out.println(results);

            JSONObject movie= null;
            try {
                movie = new JSONObject(results);
                movieInfo.put("name",movie.getString("title"));
                String imageURL=" http://image.tmdb.org/t/p/w500/"+movie.getString("poster_path");
                Bitmap image=MyUtility.downloadImageusingHTTPGetRequest(imageURL);

                movieInfo.put("image",image);
                movieInfo.put("description",movie.getString("overview"));
                movieInfo.put("id",movie.getString("id"));
                movieInfo.put("rating",movie.getString("vote_average"));
                movieInfo.put("runTime",movie.getString("runtime")+"mins");
                movieInfo.put("release_date",movie.getString("release_date"));


            } catch (JSONException e) {
                e.printStackTrace();
            }




        }

        return movieInfo;
    }


    protected void onPostExecute(HashMap results){

        if (movieNameReference!=null){

            final TextView nameView=movieNameReference.get();
            if(nameView!=null){
                nameView.setText((String)results.get("name"));
            }

            final TextView description=movieDescriptionReference.get();
            if(description!=null){
                description.setText((String)results.get("description"));
            }

            final TextView stars=movieStarsReference.get();
            if(stars!=null){
                stars.setText((String)results.get("runTime"));
            }

            final TextView director=movieDirectorReference.get();
            if(director!=null){
                director.setText((String)results.get("release_date"));
            }

            final ImageView image=movieImageReference.get();
            if(image!=null){
                image.setImageBitmap((Bitmap) results.get("image"));
            }




            final RatingBar ratingbar=ratingBarReference.get();

                    if(ratingbar!=null) {
                        float rating = Float.valueOf(String.valueOf(results.get("rating"))) / 2;
                        ratingbar.setNumStars(5);
                        ratingbar.setRating(rating);
                    }

        }

    }

}
