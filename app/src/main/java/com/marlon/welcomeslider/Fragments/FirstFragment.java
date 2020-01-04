package com.marlon.welcomeslider.Fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marlon.welcomeslider.Login;
import com.marlon.welcomeslider.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    TextView next,exit;
    ViewPager viewPager;


    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_first, container, false);

        //Inicializa ViewPager desde MainActivity
        viewPager = getActivity().findViewById(R.id.viewPager);

        next = view.findViewById(R.id.SliderOneNext);
        exit = view.findViewById(R.id.exit_slayer1);

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goLogin = new Intent(getActivity(), Login.class);
                startActivity(goLogin);
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });

        return view;
    }

}
