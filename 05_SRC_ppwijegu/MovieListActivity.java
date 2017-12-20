package com.example.pivithuru.assignment05;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MovieListActivity extends AppCompatActivity {


    Fragment mContent;
    Toolbar mToolbar;
    ActionBar mActionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main);

        mToolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);


        mActionBar=getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);

        if(savedInstanceState==null) {
            mContent=MovieListFragment.newInstance();


        }

        else{
            mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");



        }



        TextView title=(TextView)findViewById(R.id.title);
        title.setText("Movie List");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent).commit();




    }



//
//    @Override
//    public boolean onCreateOptionsMenu ( Menu menu ) {
//
//            getMenuInflater().inflate(R.menu.menu_main, menu);
//
//
//            return true;
//    }
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"mContent",mContent);

    }

//    public boolean onOptionsItemSelected(MenuItem item){
//
//        int id = item . getItemId () ;
//        switch ( id ){
//            case R . id . about_me :
//                mContent=FrontPageFragment.newInstance(R.id.about_me_fragment);
//                getSupportFragmentManager().beginTransaction()
//                        .replace(R.id.container, mContent)
//                        .addToBackStack(null).commit();
//                // true ;
//                break;
//
//            case R . id . taskTwoTool :
//                Intent intent = new Intent(MovieListActivity.this,MovieListActivity.class);
//                startActivity(intent);
//
//                // true ;
//                break;
//            case R . id . taskThreeTool :
//                intent = new Intent(MovieListActivity.this,MovieListActivity.class);
//                startActivity(intent);
//
//                // true ;
//                break;
////
//        }
//
//
//        return super . onOptionsItemSelected ( item );
//    }

    @Override
    public void onBackPressed()
    {
        if (mContent instanceof MovieDataFragment){
            TextView title=(TextView)findViewById(R.id.title);
            title.setText(String.valueOf("Movie List"));
        }
        super.onBackPressed();


    }


}



