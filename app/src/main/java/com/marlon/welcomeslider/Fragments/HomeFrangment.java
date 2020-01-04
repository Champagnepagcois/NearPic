package com.marlon.welcomeslider.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marlon.welcomeslider.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFrangment extends Fragment {


    public HomeFrangment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_frangment, container, false);
    }

}
