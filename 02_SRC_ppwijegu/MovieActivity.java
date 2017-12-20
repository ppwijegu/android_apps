package com.example.pivithuru.hw2;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pivithuru on 7/17/17.
 */

public class MovieActivity extends AppCompatActivity {

    private MovieData mv=new MovieData();

    private List<Map<String,?>> moviesList=mv.getMoviesList();

    private GestureDetectorCompat gDetector;

    private int currentImageId=0;

    private LinearLayout layout;

    public boolean onTouchEvent(MotionEvent event){

        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_layout);

        final SeekBar seekbar = (SeekBar) findViewById(R.id.seekBar);

        final ImageView movieImage=(ImageView) findViewById(R.id.movieImage) ;

        layout = (LinearLayout) findViewById(R.id.linearLayout);
        setMovieData();


        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener(){

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ViewGroup.LayoutParams params=movieImage.getLayoutParams();

                if (i>0) {
                    params.width = i * 8;
                    params.height = i * 8;

                }
                movieImage.setLayoutParams(params);


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        seekbar.setProgress(50);




        gDetector=new GestureDetectorCompat(MovieActivity.this,new GestureDetector.SimpleOnGestureListener(){


            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {


                float diffX = e2.getX() - e1.getX();

                if ( Math . abs ( diffX ) > 40) {

                    if (diffX > 0) {
                       // Toast.makeText(MovieActivity.this, " Right", Toast.LENGTH_LONG).show();

                        if (currentImageId < mv.getSize() - 1) {
                            currentImageId += 1;
                        }
                    }
                    if (diffX < 0) {
                        //Toast.makeText(MovieActivity.this, " Left", Toast.LENGTH_LONG).show();

                        if (currentImageId > 0) {

                            currentImageId -= 1;
                        }

                    }

                }

                setMovieData();

                return true;
            }

            public void onLongPress(MotionEvent e) {


                //Toast.makeText(MovieActivity.this,"Task 3",Toast.LENGTH_LONG).show();

                seekbar.setProgress(50);

            }

            public boolean onSingleTapUp(MotionEvent e) {
                HashMap<String,?> movie = (HashMap)moviesList.get(currentImageId);
                Toast.makeText(MovieActivity.this,String.valueOf(movie.get("name")),Toast.LENGTH_LONG).show();
                Snackbar. make (layout, String.valueOf(movie.get("name")) , Snackbar . LENGTH_LONG ) . show () ;

                return true;
            }

        });



    }


    private void setMovieData(){

        HashMap<String,?> movie = (HashMap)moviesList.get(currentImageId);

        int image=(Integer) movie.get("image");

        final ImageView movieImageView=(ImageView) findViewById(R.id.movieImage) ;

        movieImageView.setImageResource(image);



        final TextView movieName=(TextView)  findViewById(R.id.movieName);
        movieName.setText(String.valueOf(movie.get("name")));

        final TextView description=(TextView)  findViewById(R.id.description);
        description.setText(String.valueOf(movie.get("description")));

        final TextView length=(TextView)  findViewById(R.id.length);
        length.setText(String.valueOf(movie.get("length")));

        final TextView year=(TextView)  findViewById(R.id.year);
        year.setText(String.valueOf(movie.get("year")));

        final TextView rating=(TextView)  findViewById(R.id.rating);
        rating.setText(String.valueOf(movie.get("rating")));

        final TextView director=(TextView)  findViewById(R.id.director);
        director.setText(String.valueOf(movie.get("director")));

        final TextView stars=(TextView)  findViewById(R.id.stars);
        stars.setText(String.valueOf(movie.get("stars")));

        final TextView url=(TextView)  findViewById(R.id.url);
        url.setText(String.valueOf(movie.get("url")));




    }
}
