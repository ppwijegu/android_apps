package com.example.pivithuru.hw2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final Button taskOneButton = (Button) findViewById(R.id.taskOneButton);
        taskOneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callTask(LayoutActivity.class);

            }
        });

        final Button taskTwoButton = (Button) findViewById(R.id.taskTwoButton);
        taskTwoButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callTask(CalculatorActivity.class);

            }
        });


        final Button taskThreeButton = (Button) findViewById(R.id.taskThreeButton);
        taskThreeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                callTask(MovieActivity.class);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public MainActivity() {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up my_number_button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.taskOneTool) {
            //Toast.makeText(MainActivity.this,"Task 1",Toast.LENGTH_LONG).show();
            //Snackbar.make(findViewById(R.id.toolbar),"Snack",Snackbar.LENGTH_LONG).show();
            callTask(LayoutActivity.class);

            return true;
        }

        if (id == R.id.taskTwoTool) {


            callTask(CalculatorActivity.class);
            return true;
        }

        if (id == R.id.taskThreeTool) {

            callTask(MovieActivity.class);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void callTask(Class activityClass){
        Intent intent = new Intent(this,activityClass);
        startActivity(intent);


    }

}
