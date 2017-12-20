package com.example.pivithuru.assignment3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.HashMap;

public class FrontPageActivity extends AppCompatActivity implements FrontPageFragment.OnButtonSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState==null) {

            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, FrontPageFragment.newInstance(R.id.cover))
                    .commit();

        }


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public FrontPageActivity() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up my_number_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch(id){
            case R.id.taskTwoTool:
                Intent intent = new Intent(FrontPageActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                return true;
                //break;
            case R.id.taskThreeTool:
                intent = new Intent(FrontPageActivity.this,MasterDetailActivity.class);
                startActivity(intent);
                return true;
               // break;

            default:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,FrontPageFragment.newInstance(id)).addToBackStack(null)
                        .commit();
                return super.onOptionsItemSelected(item);
                //break;
        }

//        getSupportFragmentManager().beginTransaction()
//                    .replace(R.id.container,FrontPageFragment.newInstance(id)).addToBackStack(null)
//                    .commit();



    }

    private void callTask(Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);


    }

    @Override
    public void onButtonSelected(int id) {


        switch(id){
            case R.id.taskTwoButton:
                Intent intent = new Intent(FrontPageActivity.this,ViewPagerActivity.class);
                startActivity(intent);
                break;
            case R.id.taskThreeButton:
                intent = new Intent(FrontPageActivity.this,MasterDetailActivity.class);
                startActivity(intent);
                break;

            default:
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container,FrontPageFragment.newInstance(id)).addToBackStack(null)
                        .commit();
                break;
        }



    }
}
