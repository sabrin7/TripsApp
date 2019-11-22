package com.example.sabri.excursion.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.CustomUserspaceAdaptor;
import com.example.sabri.excursion.model.TripDatabase;

public class UserspaceActivity extends AppCompatActivity {

    private ListView all_trip_list;
    CustomUserspaceAdaptor adaptor;
    SQLiteDatabase db;
    TripDatabase tdb;
    Integer i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userspace);

        all_trip_list = findViewById(R.id.activity_userspace_all_trip_list);
        tdb = new TripDatabase(getApplicationContext());
        db = tdb.getReadableDatabase();
        Cursor cur = tdb.getTrip(db);
        if(cur.moveToFirst()) {
            do {
                adaptor.getView(i,null, null);
                i = i+1;

            } while (cur.moveToNext());
        }
        all_trip_list.setAdapter(adaptor);
    }
}
