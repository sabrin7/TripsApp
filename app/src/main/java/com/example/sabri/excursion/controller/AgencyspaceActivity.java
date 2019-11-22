package com.example.sabri.excursion.controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.CustomAgencyspaceAdaptor;
import com.example.sabri.excursion.model.TripDatabase;

public class AgencyspaceActivity extends AppCompatActivity {

    private ListView trip_list;
    CustomAgencyspaceAdaptor adaptor;
    SQLiteDatabase db;
    TripDatabase tdb;
    Integer i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agencyspace);
        trip_list = findViewById(R.id.activity_agencyspace_listview);
        tdb = new TripDatabase(getApplicationContext());
        db = tdb.getReadableDatabase();
        String agency_name = "aa";
        Cursor cur = tdb.getAgencytrip(db,agency_name);
        if(cur.moveToFirst()) {
            do {
                adaptor.getView(i,null, null);
                i = i+1;

            } while (cur.moveToNext());
        }
        trip_list.setAdapter(adaptor);

    }
}
