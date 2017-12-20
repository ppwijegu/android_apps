package com.example.pivithuru.assignment3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pivithuru on 7/24/17.
 */

public class FrontPageFragment extends Fragment implements View.OnClickListener {

    private static final String ARG_SECTION_NUMBER = "section_number";
    OnButtonSelectedListener mListener;


    public FrontPageFragment() {
        // Required empty public constructor
    }



    // TODO: Rename and change types and number of parameters
    public static FrontPageFragment newInstance(int sectionNumber) {
        FrontPageFragment fragment = new FrontPageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER,sectionNumber);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment  call each fragment layout here based on selected option



        View rootView=null;

        int option=getArguments().getInt(ARG_SECTION_NUMBER);

        try {
            mListener = (OnButtonSelectedListener) getContext();
        } catch (ClassCastException e) {
            throw new ClassCastException(
                    "Fragment interface not implemnted by the host");
        }


        switch (option){
            case R.id.cover:
                rootView=inflater.inflate(R.layout.front_page_layout, container, false);
                final Button taskOneButton = (Button) rootView.findViewById(R.id.taskOneButton);
                taskOneButton.setOnClickListener(this);

                final Button taskTwoButton = (Button) rootView.findViewById(R.id.taskTwoButton);
                taskTwoButton.setOnClickListener(this);

                final Button taskThreeButton = (Button) rootView.findViewById(R.id.taskThreeButton);
                taskThreeButton.setOnClickListener(this);

                break;
            case R.id.taskOneTool:
                rootView=inflater.inflate(R.layout.about_me_layout, container, false);
                break;


            case R.id.taskOneButton:
                rootView=inflater.inflate(R.layout.about_me_layout, container, false);
                break;



        }


        return rootView;
    }

    @Override
    public void onClick(View view) {

        int option=view.getId();


        mListener.onButtonSelected(option);


    }


    public interface OnButtonSelectedListener {
        public void onButtonSelected(int id);

    }




}
