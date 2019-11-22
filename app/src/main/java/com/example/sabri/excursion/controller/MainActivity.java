package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sabri.excursion.R;

public class MainActivity extends AppCompatActivity {
    private Button mUserButton;
    private  Button mAgencyButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUserButton = findViewById(R.id.activity_main_user_button);
        mAgencyButton = findViewById(R.id.activity_main_agency_button);
        mUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent userspaceActivity = new Intent(MainActivity.this, UserspaceActivity.class);
                startActivity(userspaceActivity);


            }
        });
        mAgencyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logsignActivity = new Intent(MainActivity.this, LogsignActivity.class);
                startActivity(logsignActivity);

            }
        });
    }
}
