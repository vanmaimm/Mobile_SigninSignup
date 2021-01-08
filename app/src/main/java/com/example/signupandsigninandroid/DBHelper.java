package com.example.signupandsigninandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String NAME = "Mian.db";

    public DBHelper(Context context) {
        super(context, "Mian.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase myDB) {
        myDB.execSQL("create Table users(username TEXT primary key, password TEXT )");
//        myDB.execSQL("create Table products(id INT primary key, productName Text, productImage BLOB, description TEXT, quatity INT, price INT)");
    }


    @Override
    public void onUpgrade(SQLiteDatabase myDB, int i, int i1) {
        myDB.execSQL("drop Table if exists users");
//        myDB.execSQL("drop Table if exists products");
    }

    public Boolean insertData(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username",username);
        contentValues.put("password", password);
        long result = MyDB.insert("users", null, contentValues);
        if(result==-1){
            return false;
        }else {
            return true;
        }
    }
    // gdsjkgkjdsfgnsfdjknsfdhrthrthr
//    public void insertData(int id, String name, int quatity, int price){
//
//    }
    public Boolean checkUsername(String username){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username =?", new String[]{username});
        if(cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
    public Boolean checkUsernamePassword(String username, String password){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from users where username=? and password=?", new String[]{username, password});
        if (cursor.getCount()>0){
            return true;
        }else {
            return false;
        }
    }
}
