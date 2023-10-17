package com.anhvu.travelapp.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.anhvu.travelapp.IntroActivity;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.CategoryAdapter;
import com.anhvu.travelapp.adapter.DomainAdapter;
import com.anhvu.travelapp.adapter.ServiceAdapter;
import com.anhvu.travelapp.model.Category;
import com.anhvu.travelapp.model.Domains;
import com.anhvu.travelapp.model.ServiceCategory;
import com.anhvu.travelapp.model.User;
import com.anhvu.travelapp.place_activity.SearchTravelActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    RecyclerView.Adapter adapterDomain,adapterCategory,adapterService;
    RecyclerView recyclerViewDomain,recyclerViewCatego,recyclerViewService;
    EditText editTextSeacrh;
    TextView textViewUser;
    ImageView imageViewSetting;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment,container,false);
        innit(view);
        editTextSeacrh = (EditText) view.findViewById(R.id.editTextSearch);
        imageViewSetting = (ImageView) view.findViewById(R.id.imageViewSetting);
        textViewUser = (TextView) view.findViewById(R.id.textViewUser);

//        User user = (User) getActivity().getIntent().getSerializableExtra("userLogin");
//        textViewUser.setText(user.getName());
        editTextSeacrh.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Intent intent = new Intent(getActivity(), SearchTravelActivity.class);
                intent.putExtra("keyWord", editTextSeacrh.getText().toString());
                startActivity(intent);
                return false;
            }
        });
        return view;
    }

    private void innit(View view) {
        ArrayList<Domains> domains = new ArrayList<>();
        recyclerViewDomain = (RecyclerView) view.findViewById(R.id.listView_Pop);
        recyclerViewDomain.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false));
        adapterDomain = new DomainAdapter(domains);
        recyclerViewDomain.setAdapter(adapterDomain);
        String url = "http://192.168.1.2/travel/place/getListPlace.php";
        RequestQueue requestQueue = Volley.newRequestQueue(getActivity());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        domains.add(new Domains(jsonObject.getInt("id_place"),jsonObject.getInt("id_category"),jsonObject.getString("title"),jsonObject.getString("location")
                                ,jsonObject.getString("description"),jsonObject.getInt("bed"),jsonObject.getDouble("score")
                                ,jsonObject.getString("wifi"),jsonObject.getString("guide"),jsonObject.getString("picture")
                                ,jsonObject.getInt("price")));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                adapterDomain.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getActivity(),"Error",Toast.LENGTH_LONG).show();
                System.out.println(error);
            }
        });
        requestQueue.add(jsonArrayRequest);


        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Beaches","cat1"));
        categories.add(new Category(2,"Camps","cat2"));
        categories.add(new Category(3,"Forest","cat3"));
        categories.add(new Category(4,"Desert","cat4"));
        categories.add(new Category(5,"Mountain","cat5"));
        recyclerViewCatego = (RecyclerView) view.findViewById(R.id.listView_Catego);
        recyclerViewCatego.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapterCategory = new CategoryAdapter(categories);
        recyclerViewCatego.setAdapter(adapterCategory);

        ArrayList<ServiceCategory> services = new ArrayList<>();
        services.add(new ServiceCategory(1,"Hotel","hotel"));
        services.add(new ServiceCategory(2,"Yacht","duthuyen"));
        services.add(new ServiceCategory(3,"Move","car_service"));
        services.add(new ServiceCategory(4,"Tour","tour"));
        services.add(new ServiceCategory(5,"Food","food_service1234"));
        services.add(new ServiceCategory(6,"Distraction","game"));
        recyclerViewService = (RecyclerView) view.findViewById(R.id.listView_Service);
        recyclerViewService.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        adapterService = new ServiceAdapter(services);
        recyclerViewService.setAdapter(adapterService);
    }

}
