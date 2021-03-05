package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class showingmovie extends AppCompatActivity {

    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showingmovie);

        next = (Button)findViewById(R.id.button5);

        next.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            startActivity(intent);
        } );
    }
}