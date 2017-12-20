package com.example.pivithuru.assignment07;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by pivithuru on 7/25/17.
 */


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MovieListActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    Fragment mContent;
    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_main);



        mDrawerLayout = ( DrawerLayout )
                findViewById (R. id.drawer_layout );
        NavigationView navigationView = ( NavigationView ) findViewById (R. id . nav_view );
        navigationView . setNavigationItemSelectedListener ( this );


        if(savedInstanceState==null) {
            mContent=MovieListFragment.newInstance();


        }

        else{
            mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");

        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, mContent).commit();



    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        getSupportFragmentManager().putFragment(outState,"mContent",mContent);

    }

    public void onBackPressed () {
        DrawerLayout drawer = ( DrawerLayout )
                findViewById (R. id . drawer_layout );
        if ( drawer . isDrawerOpen ( GravityCompat . START )) {
            drawer . closeDrawer ( GravityCompat . START ) ;
        } else {
            super . onBackPressed () ;
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item . getItemId () ;
        switch ( id ){
            case R . id . about_me :
                mContent=FrontPageFragment.newInstance(R.id.about_me_fragment);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, mContent)
                        .addToBackStack(null).commit();
                // true ;
                break;

            case R . id . taskTwoTool :
                mContent=MovieListFragment.newInstance();
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, mContent).commit();



                // true ;
                break;

            case R . id . taskThreeTool :
                FirebaseAuth auth = FirebaseAuth.getInstance();
                auth.signOut();
                Intent intent = new Intent(MovieListActivity.this,LoginActivity.class);
                startActivity(intent);
//
//                // true ;
//                break;
//            case R . id . action_compose :
//                Toast . makeText ( getApplicationContext () ," Action Email
//                        Compose " , Toast . LENGTH_SHORT ). show () ;
//                return true ;
//            case R . id . action_help :
//                Toast . makeText ( getApplicationContext () ," Action
//                        Help " , Toast . LENGTH_SHORT ) . show () ;
//                return true ;
//            case R . id . action_activity :
//                Toast . makeText ( getApplicationContext () ," Action
//                        Activity " , Toast . LENGTH_SHORT ). show () ;
//                return true ;

        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
        //return super . onOptionsItemSelected ( item );
    }


}



