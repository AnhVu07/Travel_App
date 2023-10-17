package com.anhvu.travelapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.MainActivity;
import com.anhvu.travelapp.R;

public class SettingFragment extends Fragment {
    LinearLayout log_out;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_fragment,container,false);
        log_out = (LinearLayout) view.findViewById(R.id.log_out);
        log_out.setOnClickListener(viw -> startActivity(new Intent(getActivity(), MainActivity.class)));
        return view;
    }
}
