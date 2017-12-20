package com.example.pivithuru.hw2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.Queue;


/**
 * Created by pivithuru on 7/17/17.
 */

public class CalculatorActivity extends AppCompatActivity {


    private String mathFormula="";
    private String currentValue="";
    private Queue<Integer> number=new LinkedList<Integer>();
    private Queue<String> operator=new LinkedList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator_layout);

        addButtonFucntion();


    }


    private void addButtonFucntion(){

        final TextView solutionTextView=(TextView) findViewById(R.id.solutionTextView);

        final Button buttonOne = (Button) findViewById(R.id.buttonOne);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("1");
                currentValue=currentValue.concat("1");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonTwo= (Button) findViewById(R.id.buttonTwo);
        buttonTwo.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("2");

                currentValue=currentValue.concat("2");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonThree= (Button) findViewById(R.id.buttonThree);
        buttonThree.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("3");
                currentValue=currentValue.concat("3");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonFour= (Button) findViewById(R.id.buttonFour);
        buttonFour.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("4");
                currentValue=currentValue.concat("4");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonFive= (Button) findViewById(R.id.buttonFive);
        buttonFive.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("5");
                currentValue=currentValue.concat("5");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonSix= (Button) findViewById(R.id.buttonSix);
        buttonSix.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("6");
                currentValue=currentValue.concat("6");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonSeven= (Button) findViewById(R.id.buttonSeven);
        buttonSeven.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("7");
                currentValue=currentValue.concat("7");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonEight= (Button) findViewById(R.id.buttonEight);
        buttonEight.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("8");
                currentValue=currentValue.concat("8");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonNine= (Button) findViewById(R.id.buttonNine);
        buttonNine.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("9");
                currentValue=currentValue.concat("9");
                solutionTextView.setText(mathFormula);

            }
        });

        final Button buttonZero= (Button) findViewById(R.id.buttonZero);
        buttonZero.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("0");
                currentValue=currentValue.concat("0");
                solutionTextView.setText(mathFormula);

            }
        });


        final Button buttonPlus= (Button) findViewById(R.id.buttonPlus);
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("+");
                solutionTextView.setText(mathFormula);
                processString("+");



            }
        });

        final Button buttonMinus= (Button) findViewById(R.id.buttonMinus);
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("-");
                solutionTextView.setText(mathFormula);
                processString("-");


            }
        });


        final Button buttonMultiply= (Button) findViewById(R.id.buttonMultiply);
        buttonMultiply.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("*");
                solutionTextView.setText(mathFormula);
                processString("*");


            }
        });


        final Button buttonDivide= (Button) findViewById(R.id.buttonDivide);
        buttonDivide.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("/");
                solutionTextView.setText(mathFormula);
                processString("/");


            }
        });

        final Button buttonMod= (Button) findViewById(R.id.buttonMod);
        buttonMod.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mathFormula=mathFormula.concat("%");
                solutionTextView.setText(mathFormula);
                processString("%");


            }
        });

        final Button buttonEqual= (Button) findViewById(R.id.buttonEqual);
        buttonEqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                processString("=");

                displaySolution();
            }
        });


    }

    private void displaySolution(){

        final TextView solutionTextView=(TextView) findViewById(R.id.solutionTextView);

        String solution=getSolution();
        mathFormula="";

        solutionTextView.setText(solution);


    }

    private void processString(String op){

        if (currentValue!="") {

            number.add(Integer.valueOf(currentValue));
            currentValue = "";

            if (op != "=") {
                operator.add(op);
            }

        }

        else{
            final TextView solutionTextView=(TextView) findViewById(R.id.solutionTextView);
            solutionTextView.setText("ERROR");
            mathFormula="";
        }

    }

    private String getSolution(){
        int sol= number.poll();

        try {

            while (number.size() > 0) {


                int a = number.poll();

                char op = operator.poll().charAt(0);

                switch (op) {
                    case '+':
                        sol = sol + a;
                        break;
                    case '-':
                        sol = sol - a;
                        break;
                    case '*':
                        sol = sol * a;
                        break;
                    case '/':
                        sol = sol / a;
                        break;
                    case '%':
                        sol=sol%a;
                        break;

                }
            }
            return String.valueOf(sol);
        }

        catch (Exception e){
            return "ERROR";

        }


    }

    private String solveMathFormula(){

        return "E";
    }

}
