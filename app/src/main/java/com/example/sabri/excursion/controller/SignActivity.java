package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.AgencyDatabase;

public class SignActivity extends AppCompatActivity {

    AgencyDatabase db;
    private EditText mAgencyName, mEmail, mPhone, mPassword, mConfirmPassword;
    private Button mSignIn_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign);

        db = new AgencyDatabase(this);


        mAgencyName = findViewById(R.id.activity_sign_agency_name);
        mPhone = findViewById(R.id.activity_sign_phone);
        mEmail = findViewById(R.id.activity_sign_email);
        mPassword = findViewById(R.id.activity_sign_password);
        mConfirmPassword = findViewById(R.id.activity_sign_confirm_password);
        mSignIn_btn = findViewById(R.id.activity_sign_sign_btn);

        mSignIn_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mAgencyName.getText().toString();
                Integer phone = mPhone.getInputType();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();
                String confirmpassword = mConfirmPassword.getText().toString();
                if(name.equals("") ||phone.longValue()==0 || email.equals("") || password.equals("") || confirmpassword.equals("")){
                    Toast.makeText(getApplicationContext(), "You have to fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else { if(password.equals(confirmpassword)){
                            Boolean checkname = db.checkname(name);
                            if(checkname){
                                Boolean checkmail = db.checkemail(email);
                                if(checkmail) {
                                    boolean insert = db.insert(name, email, phone, password);
                                    if (insert) {

                                        Intent logActivity = new Intent(SignActivity.this, LogActivity.class);
                                        startActivity(logActivity);
                                    }
                                }
                                else {
                                    Toast.makeText(getApplicationContext(), "email already exists", Toast.LENGTH_SHORT).show();

                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Name Already exists", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                    Toast.makeText(getApplicationContext(), "Password do not match", Toast.LENGTH_SHORT).show();
                }

                }
                }

        });
    }
}
