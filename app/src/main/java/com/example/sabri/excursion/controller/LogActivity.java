package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.AgencyDatabase;

public class LogActivity extends AppCompatActivity {

    AgencyDatabase db;
    private EditText mEmail, mPassword;
    private Button mLog_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        mEmail = findViewById(R.id.activity_log_agency_name);
        mPassword = findViewById(R.id.activity_log_password);
        mLog_btn = findViewById(R.id.activity_log_btn);
        mLog_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                boolean checkemail = db.checkemail(email);
                if (checkemail) {
                    boolean checkpassword = db.checkpassword(email, password);
                    if (checkpassword) {
                        Intent addtripActivity = new Intent(LogActivity.this, AddtripActivity.class);
                        startActivity(addtripActivity);
                    } else {
                        Toast.makeText(getApplicationContext(), "Wrong password", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "You don't have an account, you have to sign up", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}