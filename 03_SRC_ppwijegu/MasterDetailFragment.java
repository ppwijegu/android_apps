package com.example.pivithuru.assignment3;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by pivithuru on 7/25/17.
 */

public class MasterDetailFragment extends Fragment implements View.OnClickListener {


    int value=0;
    public interface OnButtonSelectedListener {
        public void onButtonSelected(int id);

    }

    private static final String ARG_SECTION_NUMBER = "section_number";
    MasterDetailFragment.OnButtonSelectedListener mListener;


    public MasterDetailFragment() {
        // Required empty public constructor

    }



    // TODO: Rename and change types and number of parameters
    public static MasterDetailFragment newInstance(int sectionNumber) {
        MasterDetailFragment fragment = new MasterDetailFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);


        return fragment;
    }


    @Override
    public void onCreate ( Bundle savedInstanceState ) {
        super . onCreate ( savedInstanceState );
        setRetainInstance ( true );

        if (savedInstanceState!=null){
            value=(Integer)savedInstanceState.getSerializable("value");

        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("value",value);
//        TextView number=(TextView) getView().findViewById(R.id.solutionTextView);
//        System.out.println(number.getText()+"shfihfoih");
//        outState.putCharSequence("value",number.getText());

        //Save the fragment's state here
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment  call each fragment layout here based on selected option



        View rootView=null;

        int option=getArguments().getInt(ARG_SECTION_NUMBER);

        try {
            mListener = (MasterDetailFragment.OnButtonSelectedListener) getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "Fragment interface not implemnted by the host");


        }

        switch (option) {

            case R.id.master:

                rootView = inflater.inflate(R.layout.master_fragment_layout, container, false);
                final Button buttonPlus = (Button) rootView.findViewById(R.id.buttonPlus);
                buttonPlus.setOnClickListener(this);

                final Button buttonMinus = (Button) rootView.findViewById(R.id.buttonMinus);
                buttonMinus.setOnClickListener(this);

                TextView number=(TextView) rootView.findViewById(R.id.solutionTextView);

                number.setText(String.valueOf(value));

                break;


            case R.id.movie_layout:
                rootView = inflater.inflate(R.layout.movie_fragment_layout, container, false);

                break;

        }





        return rootView;
    }

    @Override
    public void onClick(View view) {

        int option=view.getId();


        mListener.onButtonSelected(option);


    }






}
