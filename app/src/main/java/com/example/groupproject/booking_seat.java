package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Fragment.DetailedFragment;

public class booking_seat extends AppCompatActivity {

    TextView tvTitle,tvDesc,tvRating,tvReleaseDate;
    Button exit,confirm;
    ImageView movieImage;
    public String movieTitle,movieRating,movieReleaseDate,movieDesc,movieImagePath;

    public String getMovieTitle(){
        return movieTitle;
    }


    Button clear;

    TextView value;

    int counter = 0;

//    ToggleButton a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,d1,d2,d3,d4,d5,d6,e1,e2,e3,e4,e5,e6,f1,f2,f3,f4,f5,f6,g1,g2,g3,g4,g5,g6,h1,h2,h3,h4,h5,h6;
      ToggleButton buttons [][] = new ToggleButton [6][8];

      public ToggleButton[][] toggleButton(){
        return buttons;
      }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_seat);

        exit = findViewById(R.id.exit);
        confirm= findViewById(R.id.confirm);
        value = findViewById(R.id.value);
        clear = findViewById(R.id.clear);

//        a1 = findViewById(R.id.a);
//        b1 = findViewById(R.id.b);
//        c1 = findViewById(R.id.c);
//        d1 = findViewById(R.id.d);
//        e1 = findViewById(R.id.e);
//        g1 = findViewById(R.id.f);
//        h1 = findViewById(R.id.h);
//
//        a2 = findViewById(R.id.a2);
//        b2 = findViewById(R.id.b2);
//        c2 = findViewById(R.id.c2);
//        d2 = findViewById(R.id.d2);
//        e2 = findViewById(R.id.e2);
//        g2 = findViewById(R.id.f2);
//        h2 = findViewById(R.id.h2);
//
//        a3 = findViewById(R.id.a3);
//        b3 = findViewById(R.id.b3);
//        c3 = findViewById(R.id.c3);
//        d3 = findViewById(R.id.d3);
//        e3 = findViewById(R.id.e3);
//        g3 = findViewById(R.id.g3);
//        h3 = findViewById(R.id.h3);
//
//        a4 = findViewById(R.id.a4);
//        b4 = findViewById(R.id.b4);
//        c4 = findViewById(R.id.c4);
//        d4 = findViewById(R.id.d4);
//        e4 = findViewById(R.id.e4);
//        g4 = findViewById(R.id.f4);
//        h4 = findViewById(R.id.h4);
//
//
//        a5 = findViewById(R.id.a5);
//        b5 = findViewById(R.id.b5);
//        c5 = findViewById(R.id.c5);
//        d5 = findViewById(R.id.d5);
//        e5 = findViewById(R.id.e5);
//        g5 = findViewById(R.id.f5);
//        h5 = findViewById(R.id.h5);
//
//        a6 = findViewById(R.id.a6);
//        b6 = findViewById(R.id.b6);
//        c6 = findViewById(R.id.c6);
//        d6 = findViewById(R.id.d6);
//        e6 = findViewById(R.id.e6);
//        g6 = findViewById(R.id.f6);
//        h6 = findViewById(R.id.h6);

        for(int i=0;i<6;i++){
            for(int j=0;j<8;j++){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener((View.OnClickListener) this);

            }
        }

        exit.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, DetailedFragment.class);
            startActivity(intent);
        }));

        confirm.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, booking_seat.class);
            startActivity(intent);
        }));
    }

    public void countIN(View view){
        ++counter;
        value.setText(Integer.toString(counter));
    }

    public void countClear(View view){
        counter = 0;
        value.setText(String.valueOf(counter));
    }

}