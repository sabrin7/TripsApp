package com.example.sabri.excursion.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDatabase extends SQLiteOpenHelper {
    public UserDatabase(Context context) {
        super(context, "addtrip.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(trip_id number, name text, surname, phone number, email text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

        onCreate(db);
    }

    public boolean insert(Integer trip_id, String name, String surname, Integer phone, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("trip_id", trip_id);
        contentValues.put("name", name);
        contentValues.put("surname", surname);
        contentValues.put("phone", phone);
        contentValues.put("email", email);

        long ins = db.insert("user", null, contentValues);
        return ins != -1;
    }
}
