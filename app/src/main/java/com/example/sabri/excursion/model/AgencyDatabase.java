package com.example.sabri.excursion.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AgencyDatabase extends SQLiteOpenHelper {


    public AgencyDatabase(Context context) {
        super(context, "Signin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table agency(name text primary key, email text, phone number, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists agency");

    }

    public boolean insert(String name, String email, Integer phone, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("phone", phone);
        contentValues.put("password", password);
        long ins = db.insert("agency", null, contentValues);
        return ins != -1;
    }

    public boolean checkname(String name){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from agency where name=?", new String[]{name});
        if (cur.getCount()>0) { cur.close(); return false;}
        else {cur.close(); return true;}
    }

    public boolean checkemail(String email){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from agency where email=?", new String[]{email});
        if (cur.getCount()>0) {cur.close(); return false;}
        else return true;
    }
    public boolean checkpassword(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select password from agency where email=?", new String[]{email});
        if (cur.getString(0).equals(password)) {
            cur.close();
            return true;
        } else {
            cur.close();
            return false;
        }
    }

    public Cursor getName() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query("select name from agency", null, null, null, null, null, null);
    }
}
