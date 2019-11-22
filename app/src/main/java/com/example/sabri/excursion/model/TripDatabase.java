package com.example.sabri.excursion.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class TripDatabase extends SQLiteOpenHelper{
    private static final String DATABASE_NAME = "trip.db";
    private static final Integer Tid = 0;
    private static final String Tdestination = "destination";
    private static final String Tagency_name = "agency_name";
    private static final String Tplanning = "planning";
    private static final Integer Tmonth = 0;
    private static final Integer Tday = 0;
    private static final Integer Tnbr_places = 0;
    private static final Integer Tprice = 0;




    public TripDatabase(Context context) {
        super(context, "trip.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table trip(" + Tid.toString() + " number primary key, " + Tdestination + " text," + Tagency_name + " text," + Tplanning + "text," +  Tmonth + "number," + Tday + " number, " + Tnbr_places + "number," + Tprice + "number )");    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists trip");
        onCreate(db);

    }

    public boolean insert(Integer id, String destination, Integer month, Integer day, String agency_name, String planning, Integer nbr_places, Integer price){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Tid.toString(), id);
        contentValues.put(Tdestination, destination);
        contentValues.put(Tmonth.toString(), month);
        contentValues.put(Tday.toString(), day);
        contentValues.put(Tagency_name, agency_name);
        contentValues.put(Tplanning, planning);
        contentValues.put(Tnbr_places.toString(), nbr_places);
        contentValues.put(Tprice.toString(), price);

        long ins = db.insert("trip", null, contentValues);
        return ins != -1;
    }


    public Cursor getTrip(SQLiteDatabase db) {
        String[] req = {Tdestination, Tmonth.toString(), Tday.toString(), Tagency_name, Tplanning, Tnbr_places.toString(), Tprice.toString()};
        return db.query(DATABASE_NAME, req, null, null, null, null, null);

    }

    public Cursor getAgencytrip(SQLiteDatabase db, String agency_name) {
        String[] req = {Tdestination, Tmonth.toString(), Tday.toString(), Tplanning, Tnbr_places.toString(), Tprice.toString()};
        return db.query( DATABASE_NAME, req, Tagency_name + "=?", new String[] {String.valueOf(agency_name)}, null, null, null );

    }

    public boolean checkid(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cur = db.rawQuery("select * from trip where id=?", new String[]{id});
        if (cur.getCount()>0) {cur.close(); return false;}
        else {cur.close(); return true;}
    }

}
