package com.example.sabri.excursion.controller;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.Toast;

import com.example.sabri.excursion.R;
import com.example.sabri.excursion.model.TripDatabase;
import com.example.sabri.excursion.model.UserDatabase;

public class BookActivity extends AppCompatActivity {

    UserDatabase udb;
    TripDatabase tdb;

    private EditText mName, mSurname, mPhone, mEmail, mNbr_places;
    private Button mBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        mName = findViewById(R.id.activity_book_name);
        mSurname = findViewById(R.id.activity_book_surname);
        mPhone = findViewById(R.id.activity_book_phone);
        mEmail = findViewById(R.id.activity_book_email);
        mNbr_places =findViewById(R.id.activity_book_nbr_places);
        mBook =findViewById(R.id.activity_book_btn);

        mBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = mName.getText().toString();
                String surname = mSurname.getText().toString();
                Integer phone = mPhone.getInputType();
                String email = mEmail.getText().toString();
                Integer nbr_places = mNbr_places.getInputType();
                Integer id = 0;
                if(name.equals("") || surname.equals("")|| email.equals("") ){
                    Toast.makeText(getApplicationContext(), "You have to fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else { if(mNbr_places.toString().equals("0")){

                    Toast.makeText(getApplicationContext(), "Number of places should be greater than 0", Toast.LENGTH_SHORT).show();
                    }
                    else{
                        boolean insert = udb.insert(id, name, surname, phone, email);
                        if(insert){


                            Intent suggestionActivity = new Intent(BookActivity.this, SuggestionActivity.class);
                            startActivity(suggestionActivity);
                        }
                    }
                }
            }
        });




    }
}
