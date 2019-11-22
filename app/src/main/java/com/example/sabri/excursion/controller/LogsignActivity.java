package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.sabri.excursion.R;

public class LogsignActivity extends AppCompatActivity {

    private Button mLogsign_log_btn;
    private Button mLogsign_sing_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logsign);
        mLogsign_log_btn = findViewById(R.id.activity_logsign_log_btn);
        mLogsign_sing_btn = findViewById(R.id.activity_logsign_sign_btn);
        mLogsign_sing_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signActivity = new Intent(LogsignActivity.this, SignActivity.class);
                startActivity(signActivity);

            }
        });
        mLogsign_log_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent logActivity = new Intent(LogsignActivity.this, LogActivity.class);
                startActivity(logActivity);

            }
        });
    }
}
