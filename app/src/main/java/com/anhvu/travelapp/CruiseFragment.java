package com.anhvu.travelapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.anhvu.travelapp.adapter.CruiseAdapter;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.Cruise;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class CruiseFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */


    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static CruiseFragment newInstance(int columnCount) {
        CruiseFragment fragment = new CruiseFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @RequiresApi(api = 33)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ArrayList<Cruise> cruises = new ArrayList<>();
        CruiseAdapter cruiseAdapter;
        DB_Sql db_sql;

        View view = inflater.inflate(R.layout.fragment_cruise_list, container, false);
        db_sql = new DB_Sql(getContext(),"travel app1",null,1);
        Bundle bundle = getArguments();
        if(bundle!=null){
            Cruise cruise = bundle.getSerializable("cruise",Cruise.class);
            System.out.println(cruise);
            int id = cruise.getId();
            Cursor cursor = db_sql.getQueryData("select * from cruise where idCategoryCruise='"+id+"'");
            while (cursor.moveToNext()){
                Cruise cruise1 = new Cruise(cursor.getInt(0),cursor.getInt(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),
                        cursor.getDouble(5),cursor.getDouble(6),cursor.getString(7),cursor.getString(8)
                        ,cursor.getString(9),cursor.getString(10));
                cruises.add(cruise1);
            }
        }

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listFragment);
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            cruiseAdapter = new CruiseAdapter(cruises);
            recyclerView.setAdapter(cruiseAdapter);
        }
        return view;
    }
}