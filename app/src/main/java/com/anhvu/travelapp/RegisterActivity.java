package com.anhvu.travelapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.anhvu.travelapp.database.DB_Sql;
import com.anhvu.travelapp.model.User;

import org.mindrot.jbcrypt.BCrypt;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageViewBack;
    TextView textViewLogin;
    EditText editTextEmail,editTextPhone,editTextFullname,editTextPassword,editTextConfirm;
    CheckBox checkBox;
    AppCompatButton buttonRegister;
    DB_Sql db_sql;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db_sql = new DB_Sql(this,"travel app1",null,1);

        mapping();
        imageViewBack.setOnClickListener(view -> finish());
        textViewLogin.setOnClickListener(view -> startActivity(new Intent(this,LoginActivity.class)));

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName= editTextFullname.getText().toString().trim();
                String email= editTextEmail.getText().toString();
                String phone= editTextPhone.getText().toString().trim();
                String password= editTextPassword.getText().toString();
                String confrim= editTextConfirm.getText().toString();

                if(checkBox.isChecked()&&!password.isEmpty()&&!email.isEmpty()&&!confrim.isEmpty()){
                    if(!password.equals(confrim)){
                        Toast.makeText(RegisterActivity.this, "Re-entered password is incorrect", Toast.LENGTH_LONG).show();
                    } else {
                        User user1 = getUserByEmail(email);
                        if(user1==null){
                            String encode = BCrypt.hashpw(password,BCrypt.gensalt(12));
                                db_sql.addUser(email,encode,phone,fullName,"customer");
                                Toast.makeText(RegisterActivity.this, "Sign Up Success", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                        } else {
                            Toast.makeText(RegisterActivity.this,"Email already exists",Toast.LENGTH_LONG).show();
                        }
                    }
                } else {
                    Toast.makeText(RegisterActivity.this,"Please enter the complete information",Toast.LENGTH_LONG).show();
                }
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
        imageViewBack = (ImageView) findViewById(R.id.imageViewBackRegister);
        textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        editTextEmail = (EditText) findViewById(R.id.editTextTEmailReg);
        editTextPhone = (EditText) findViewById(R.id.editTextPhoneReg);
        editTextFullname = (EditText) findViewById(R.id.editTextTfullNameReg);
        editTextPassword = (EditText) findViewById(R.id.editTextTPasswordReg);
        editTextConfirm = (EditText) findViewById(R.id.editTextConfirmReg);
        checkBox = (CheckBox) findViewById(R.id.checkBox);
        buttonRegister = (AppCompatButton) findViewById(R.id.buttonRegister);

    }
}