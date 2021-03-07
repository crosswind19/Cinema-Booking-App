package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class showingmovie extends AppCompatActivity {

    Button next1, next2, next3, next4, next5, next6, next7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showingmovie);

        next1 = findViewById(R.id.button);
        next2 = findViewById(R.id.button2);
        next3 = findViewById(R.id.button3);
        next4 = findViewById(R.id.button6);
        next5 = findViewById(R.id.button7);
        next6 = findViewById(R.id.button5);
        next7 = findViewById(R.id.button8);

        next1.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime" , "8.15 AM");
            startActivity(intent);
        } );

        next2.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "2.45 PM");
            startActivity(intent);
        } );

        next3.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "4.55 PM");
            startActivity(intent);
        } );

        next4.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "1.05 PM");
            startActivity(intent);
        } );

        next5.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "3.05 PM");
            startActivity(intent);
        } );

        next6.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "5.45 PM");
            startActivity(intent);
        } );

        next7.setOnClickListener((view) -> {
            Intent intent = new Intent(showingmovie.this, booking_seat.class);
            intent.putExtra("bookingtime", "8.25 PM");
            startActivity(intent);
        } );
    }
}