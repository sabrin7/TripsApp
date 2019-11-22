package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

import com.example.sabri.excursion.R;

public class SuggestionActivity extends AppCompatActivity {
    private TextView mSuggestion;
    private EditText mDestination;
    private Button mConfirm_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suggestion);
        mSuggestion = findViewById(R.id.activity_suggestion_txt);
        mDestination = findViewById(R.id.activity_suggestion_destination);
        mConfirm_btn = findViewById(R.id.activity_suggestion_btn);
        mConfirm_btn.setEnabled(false);
        mDestination.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                mDestination.setEnabled(s.toString().length() != 0 );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });
        mDestination.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Thank you for your suggestion", Toast.LENGTH_SHORT).show();

                Intent userspaceActivity = new Intent(SuggestionActivity.this, UserspaceActivity.class);
                startActivity(userspaceActivity);
            }
        });



    }
}
