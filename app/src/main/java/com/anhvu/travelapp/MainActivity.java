package com.anhvu.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.anhvu.travelapp.adapter.CategoryAdapter;
import com.anhvu.travelapp.adapter.DomainAdapter;
import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.Category;
import com.anhvu.travelapp.model.Domains;

import org.mindrot.jbcrypt.BCrypt;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ConstraintLayout constraintLayoutStart;
    DB_Sql db_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        db_sql = new DB_Sql(this,"travel app1",null,1);
        //db_sql.createQuery("");
        constraintLayoutStart = (ConstraintLayout) findViewById(R.id.ConstraintLayoutStart);
        constraintLayoutStart.setOnClickListener(view ->
                {
                startActivity(new Intent(MainActivity.this, IntroActivity.class));
               // System.out.println("Code: "+ BCrypt.hashpw("101001@haha",BCrypt.gensalt(12)));
                }

        );
    }

}



