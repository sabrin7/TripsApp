package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.TripDatabase;

public class AddtripActivity extends AppCompatActivity {
    TripDatabase tdb;

    private EditText mDestination, mPlanning, mPrice, mMonth, mDay, mNbr_places;
    private Button mAdd_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtrip);
        mDestination = findViewById(R.id.activity_addtrip_destination);
        mMonth = findViewById(R.id.activity_addtrip_month);
        mDay = findViewById(R.id.activity_addtrip_day);
        mPlanning = findViewById(R.id.activity_addtrip_planning);
        mPrice = findViewById(R.id.activity_addtrip_price);
        mNbr_places= findViewById(R.id.activity_addtrip_nbr_places);
        mAdd_btn = findViewById(R.id.activity_addtrip_add_btn);
        final Integer id=0;
        mAdd_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String destination = mDestination.getText().toString();
                Integer month = mMonth.getInputType();
                Integer day = mDay.getInputType();
                String planning = mPlanning.getText().toString();
                Integer price = mPrice.getInputType();
                Integer nbr_places = mNbr_places.getInputType();
                String agency_name = "aa";

                tdb.insert(id, destination, month, day, agency_name, planning, nbr_places, price);

                Intent agencyspaceActivity = new Intent(AddtripActivity.this, AgencyspaceActivity.class);
                startActivity(agencyspaceActivity);
            }
        });
    }
}
