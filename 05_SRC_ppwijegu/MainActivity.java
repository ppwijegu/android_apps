package com.example.pivithuru.assignment05;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{


    private DrawerLayout mDrawerLayout;
    private Toolbar mToolbar;
    Fragment mContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar=(Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mDrawerLayout = ( DrawerLayout )
                findViewById (R. id.drawer_layout );
        NavigationView navigationView = ( NavigationView ) findViewById (R. id . nav_view );
        navigationView . setNavigationItemSelectedListener ( this );

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle (
                this , mDrawerLayout , mToolbar ,R.string.open_drawer,R.string.close_drawer);
//        {
//                public void onDrawerOpened(View drawerView){
//                    super.onDrawerOpened(drawerView);
//                }
//            public void onDrawerClosed(View drawerView){
//                super.onDrawerClosed(drawerView);
//            }
//
//                };

        mDrawerLayout . setDrawerListener ( toggle );
        toggle . syncState () ;

        if(savedInstanceState==null) {

            mContent=FrontPageFragment.newInstance(R.id.cover_page);





        }


        if (savedInstanceState!=null){
            mContent=getSupportFragmentManager().getFragment(savedInstanceState,"mContent");

        }
//

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

//    @Override
//    public boolean onCreateOptionsMenu ( Menu menu ) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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
                Intent intent = new Intent(MainActivity.this,MovieListActivity.class);
                startActivity(intent);

                // true ;
                break;
            case R . id . taskThreeTool :
                intent = new Intent(MainActivity.this,MovieListActivityTaskThree.class);
                startActivity(intent);

                // true ;
                break;
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

//    public boolean onOptionsItemSelected(MenuItem item){
//
//            int id = item . getItemId () ;
//            switch ( id ){
//                case R . id . about_me :
//                    mContent=FrontPageFragment.newInstance(R.id.about_me_fragment);
//                    getSupportFragmentManager().beginTransaction()
//                            .replace(R.id.container, mContent)
//                            .addToBackStack(null).commit();
//                    // true ;
//                    break;
//
//                case R . id . taskTwoTool :
//                    Intent intent = new Intent(MainActivity.this,MovieListActivity.class);
//                    startActivity(intent);
//
//                    // true ;
//                    break;
//                case R . id . taskThreeTool :
//                    intent = new Intent(MainActivity.this,MovieListActivity.class);
//                    startActivity(intent);
//
//                    // true ;
//                    break;
////            case R . id . action_compose :
////                Toast . makeText ( getApplicationContext () ," Action Email
////                        Compose " , Toast . LENGTH_SHORT ). show () ;
////                return true ;
////            case R . id . action_help :
////                Toast . makeText ( getApplicationContext () ," Action
////                        Help " , Toast . LENGTH_SHORT ) . show () ;
////                return true ;
////            case R . id . action_activity :
////                Toast . makeText ( getApplicationContext () ," Action
////                        Activity " , Toast . LENGTH_SHORT ). show () ;
////                return true ;
//
//            }
//
//            return true;
//            //return super . onOptionsItemSelected ( item );
//        }

}
