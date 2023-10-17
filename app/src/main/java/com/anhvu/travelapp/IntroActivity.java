package com.anhvu.travelapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

import com.anhvu.travelapp.fragment.HomeFragment;
import com.anhvu.travelapp.fragment.LoveFragment;
import com.anhvu.travelapp.fragment.PersonalFragment;
import com.anhvu.travelapp.fragment.SettingFragment;


public class IntroActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addFragmentHome();

    }

    public void addFragmentHome(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,new HomeFragment(),"fragmentHome");
        fragmentTransaction.addToBackStack("home");
        fragmentTransaction.commit();
    }

    public void addFragmentHome(){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,new HomeFragment(),"fragmentHome");
        fragmentTransaction.addToBackStack("home");
        fragmentTransaction.commit();
    }

    public void addFragmentPersonal(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,new PersonalFragment(),"fragmentPersonal");
        fragmentTransaction.addToBackStack("personal");
        fragmentTransaction.commit();
    }

    public void addFragmentSetting(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,new SettingFragment(),"fragmentSetting");
        fragmentTransaction.addToBackStack("personal");
        fragmentTransaction.commit();
    }

    public void addFragmentLove(View view){
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_content,new LoveFragment(),"fragmentLove");
        fragmentTransaction.addToBackStack("love");
        fragmentTransaction.commit();
    }

    public void Comeback(View view){
        getFragmentManager().popBackStack();
    }

    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount()>0){
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
        }
    }
}
