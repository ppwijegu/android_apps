package com.example.pivithuru.assignment05;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by pivithuru on 7/24/17.
 */

public class FrontPageFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";


    public FrontPageFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FrontPageFragment newInstance(int sectionNumber) {
        FrontPageFragment fragment = new FrontPageFragment();

        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);


        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment  call each fragment layout here based on selected option


        View rootView = null;

        int option = getArguments().getInt(ARG_SECTION_NUMBER);


        rootView = inflater.inflate(R.layout.about_me_layout, container, false);


        switch (option) {
            case R.id.cover_page:
                rootView = inflater.inflate(R.layout.cover_layout, container, false);

                break;


            case R.id.about_me:
                rootView = inflater.inflate(R.layout.about_me_layout, container, false);
                break;



        }
        return rootView;


    }

}
