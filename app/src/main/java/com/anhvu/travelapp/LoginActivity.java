package com.anhvu.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.User;

import org.mindrot.jbcrypt.BCrypt;

public class LoginActivity extends AppCompatActivity {

    ImageView imageViewBackLogin;
    EditText editTextEmail,editTextPassword;
    TextView textViewForget,textViewRegister;
    AppCompatButton buttonLogin;

    DB_Sql db_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        db_sql = new DB_Sql(this,"travel app1",null,1);

        mapping();
        imageViewBackLogin.setOnClickListener(view->finish());
        textViewRegister.setOnClickListener(view -> startActivity(new Intent(LoginActivity.this,RegisterActivity.class)));

        buttonLogin.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            if(!email.isEmpty()&&!password.isEmpty()){
                User user = getUserByEmail(email);
                if(user!=null){
                    boolean check = BCrypt.checkpw(password,user.getPassword());
                    if(check) {
                        Intent intent = new Intent(LoginActivity.this, IntroActivity.class);
                        intent.putExtra("userLogin", user);
                        startActivity(intent);
                    } else {
                        Toast.makeText(LoginActivity.this,"Password is incorrect",Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(LoginActivity.this,"Login information is incorrect",Toast.LENGTH_LONG).show();
                }
            } else {
                Toast.makeText(LoginActivity.this,"Please enter the complete information",Toast.LENGTH_LONG).show();
            }
        });
    }

    private User getUserByEmail(String email){
       Cursor cursor = db_sql.getQueryData("SELECT * FROM `user` WHERE email ='"+email+"'");
       while (cursor.moveToNext()){
          return new User(cursor.getInt(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4),cursor.getString(5));
       }
       return null;
    }

    private void mapping() {
        imageViewBackLogin = (ImageView) findViewById(R.id.imageViewBackRegister);
        editTextEmail = (EditText) findViewById(R.id.editTextTPasswordReg);
        editTextPassword = (EditText) findViewById(R.id.editTextConfirmReg);
        textViewForget = (TextView) findViewById(R.id.textViewForget);
        textViewRegister = (TextView) findViewById(R.id.textViewRegister);
        buttonLogin = (AppCompatButton) findViewById(R.id.buttonRegister);

    }
}