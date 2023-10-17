package com.anhvu.travelapp.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

import com.anhvu.travelapp.model.User;

public class DB_Sql extends SQLiteOpenHelper {
    public DB_Sql(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    public void createQuery(String query){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(query);
    }

    public void addUser(String email,String password,String phone,String name,String role){
        SQLiteDatabase database = getWritableDatabase();
        String query = "INSERT INTO `user`(`id`,`email`, `password`, `role`,`phone`,`name`) VALUES (3,?,?,?,?,?)";
        SQLiteStatement statement = database.compileStatement(query);
        statement.clearBindings();
        statement.bindString(1,email);
        statement.bindString(2,password);
        statement.bindString(3,role);
        statement.bindString(4,phone);
        statement.bindString(5,name);
        statement.executeInsert();
    }

    public Cursor getQueryData(String query){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(query,null);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
