package com.anhvu.travelapp.fragment;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;

public class PersonalFragment extends Fragment {
    LinearLayout set_up;
    IntroActivity introActivity;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.persional_fragment,container,false);
        set_up = (LinearLayout) view.findViewById(R.id.set_up);
        set_up.setOnClickListener(view1 ->{
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            SettingFragment settingFragment = new SettingFragment();
            fragmentTransaction.replace(R.id.fragment_content,settingFragment);
            fragmentTransaction.commit();
        });
        return view;
    }
}
