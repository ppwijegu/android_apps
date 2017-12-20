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

public class MovieListActivityTaskThree extends AppCompatActivity {


    Fragment mContent;
    Toolbar mToolbar;
    ActionBar mActionBar;
    Toolbar mToolBarBottom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main_task3);

        mToolbar=(Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(mToolbar);

        mToolBarBottom=(Toolbar) findViewById(R.id.toolbar_bottom);


        mActionBar=getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setDisplayShowTitleEnabled(false);

        if(savedInstanceState==null) {
            mContent=MovieListFragmentTaskThree.newInstance();


        }

        else{
            mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");



        }

        if (mContent instanceof MovieListFragmentTaskThree) {
            mToolBarBottom=(Toolbar) findViewById(R.id.toolbar_bottom);
            mToolBarBottom.inflateMenu(R.menu.bottom_toolbar);
            setUpToolBarItemSelected();
        }

        TextView title=(TextView)findViewById(R.id.title);
        title.setText("Movie List");
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent).commit();




    }

    public void setUpToolBarItemSelected(){



        mToolBarBottom.setVisibility(View.VISIBLE);


        mToolBarBottom.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem item) {

                int id=item.getItemId();
                MovieAdapterTaskThree mAdapter=((MovieListFragmentTaskThree)mContent).mAdapter;
                switch (id){
                    case R.id.sort_name:


                        ((MovieListFragmentTaskThree)mContent).sortMovieData("by_name","bottom");

                        return true;

                    case R.id.sort_year:
                        ((MovieListFragmentTaskThree)mContent).sortMovieData("by_year","bottom");
                        return true;

                    default:
                        break;
                }
                return false;
            }
        });

        mToolBarBottom.setNavigationIcon(R.drawable.ic_arrow_downward_black_24dp);


        mToolBarBottom.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                mToolBarBottom.setVisibility(View.GONE);
            }
        });


    }



//    @Override
//    public boolean onCreateOptionsMenu ( Menu menu ) {
//
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//
//
//        return true;
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
//                Intent intent = new Intent(MovieListActivityTaskThree.this,MovieListActivity.class);
//                startActivity(intent);
//
//                // true ;
//                break;
//            case R . id . taskThreeTool :
//                intent = new Intent(MovieListActivityTaskThree.this,MovieListActivity.class);
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
//

    @Override
    public void onBackPressed()
    {
        if (mContent instanceof MovieDataFragment){
            mToolBarBottom.setVisibility(View.VISIBLE);
            TextView title=(TextView)findViewById(R.id.title);
            title.setText(String.valueOf("Movie List"));
        }
        super.onBackPressed();


    }

}



