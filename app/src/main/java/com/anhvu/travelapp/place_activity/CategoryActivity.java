package com.anhvu.travelapp.place_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.anhvu.travelapp.R;
import com.anhvu.travelapp.adapter.DomainAdapterFillCategory;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.Domains;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CategoryActivity extends AppCompatActivity {
    DomainAdapterFillCategory domainAdapterFillCategory;
    RecyclerView recyclerView;
    ImageView imageViewBack;
    TextView textViewName;
    DB_Sql db_sql;
    ArrayList<Domains> domains = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        db_sql = new DB_Sql(this,"travel app1",null,1);
        int idCategory = getIntent().getIntExtra("idCategory", 2);
        String name = getIntent().getStringExtra("name");
        getPlaceByCategory(idCategory);
        recyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackPlaceSearch);
        textViewName = (TextView) findViewById(R.id.textViewTitlePlaceSearch);
        textViewName.setText(name);
        imageViewBack.setOnClickListener(view -> finish());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        domainAdapterFillCategory = new DomainAdapterFillCategory(domains);
        recyclerView.setAdapter(domainAdapterFillCategory);

    }


    public void getDataByCategory(String id) {
        String url = "http://192.168.1.2/travel/place/getListPlaceByIDCategory.php";
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.POST, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Toast.makeText(CategoryActivity.this, response.toString(), Toast.LENGTH_LONG).show();
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject jsonObject = response.getJSONObject(i);
                        domains.add((new Domains(jsonObject.getInt("id_place"), jsonObject.getInt("id_category"), jsonObject.getString("title"), jsonObject.getString("location")
                                , jsonObject.getString("description"), jsonObject.getInt("bed"), jsonObject.getDouble("score")
                                , jsonObject.getString("wifi"), jsonObject.getString("guide"), jsonObject.getString("picture")
                                , jsonObject.getInt("price"))));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                domainAdapterFillCategory.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(CategoryActivity.this, "Error", Toast.LENGTH_LONG).show();
                System.out.println(error);
            }
        }
        ) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> map = new HashMap<>();
                map.put("id_category",id);
                return map;
            }
        };
        requestQueue.add(jsonArrayRequest);
    }

    public void getPlaceByCategory(int id){
        String query = "select * from place where id_category='"+id+"'";
        Cursor cursor = db_sql.getQueryData(query);
        while (cursor.moveToNext()){
            Domains d = new Domains(cursor.getString(2),cursor.getString(3)
                    ,cursor.getString(5),cursor.getInt(4),
                    ((double) (cursor.getInt(6))),cursor.getExtras().getBoolean("wifi")+"",cursor.getExtras().getBoolean("guide")+""
                    ,cursor.getString(9),((double)(cursor.getFloat(10))));
            domains.add(d);
        }
        System.out.println(domains);
    }
}
