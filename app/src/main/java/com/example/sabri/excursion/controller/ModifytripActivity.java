package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.sabri.excursion.R;

public class ModifytripActivity extends AppCompatActivity {

    private EditText mDestination, mPlanning, mPrice, mMonth, mDay, mNbr_places;
    private Button mModify_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifytrip);
        mDestination = findViewById(R.id.activity_modifytrip_destination);
        mMonth = findViewById(R.id.activity_modifytrip_month);
        mDay = findViewById(R.id.activity_modifytrip_day);
        mPlanning = findViewById(R.id.activity_modifytrip_planning);
        mPrice = findViewById(R.id.activity_modifytrip_price);
        mNbr_places= findViewById(R.id.activity_modifytrip_nbr_places);
        mModify_btn = findViewById(R.id.activity_modifytrip_btn);
        mModify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent agencyspaceActivity = new Intent(ModifytripActivity.this, AgencyspaceActivity.class);
                startActivity(agencyspaceActivity);
            }
        });

    }
}
