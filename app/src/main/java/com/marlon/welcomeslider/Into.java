package com.marlon.welcomeslider;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.marlon.welcomeslider.Fragments.AddFragment;
import com.marlon.welcomeslider.Fragments.HomeFrangment;
import com.marlon.welcomeslider.Fragments.ProfileFragment;
import com.marlon.welcomeslider.Fragments.SearchFragment;

import java.util.ArrayList;

public class Into extends AppCompatActivity {


    private static final String TAG = "Into";

   //Vars

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFrangment homeFrangment;
    private SearchFragment searchFragment;
    private ProfileFragment profileFragment;
    private AddFragment addFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_into);

        //getImages();

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView)findViewById(R.id.main_nav);



        homeFrangment = new HomeFrangment();
        searchFragment = new SearchFragment();
        profileFragment = new ProfileFragment();
        addFragment = new AddFragment();

        setFragment(homeFrangment);

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.nav_home :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(homeFrangment);
                        return true;

                    case R.id.nav_center :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(addFragment);
                        return true;

                    case R.id.nav_profile :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(profileFragment);
                        return true;

                    case R.id.nav_search :
                        mMainNav.setItemBackgroundResource(R.color.colorAccent);
                        setFragment(searchFragment);
                        return true;

                        default:
                            return false;
                }
            }


        });
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame,fragment);
        fragmentTransaction.commit();
    }

    private void getImages(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");


        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");


        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();

    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.RecycleView);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
    }
}
