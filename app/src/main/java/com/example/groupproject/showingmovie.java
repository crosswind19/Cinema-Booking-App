package com.example.groupproject;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class showingmovie extends AppCompatActivity{

    String[] moviename;
    Button next1, next2, next3, next4, next5, next6, next7;
    String movieTitle,date;
    ImageView moviePoster;
    TextView datePicker;
    int index;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showingmovie);

        moviename = getResources().getStringArray(R.array.movieTitle);
        Spinner s1 = findViewById(R.id.spinner1);
        datePicker = findViewById(R.id.tv_date);
        moviePoster = findViewById(R.id.iv_poster2);
        next1 = findViewById(R.id.button);
        next2 = findViewById(R.id.button2);
        next3 = findViewById(R.id.button3);
        next4 = findViewById(R.id.button6);
        next5 = findViewById(R.id.button7);
        next6 = findViewById(R.id.button5);
        next7 = findViewById(R.id.button8);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_single_choice, moviename);
        s1.setAdapter(adapter);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                index = arg0.getSelectedItemPosition();
                movieTitle = getMovieTitle(index);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {

            }
        });

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy ");
        datePicker.setText(simpleDateFormat.format(calendar.getTime()));
        date=datePicker.getText().toString();

        datePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(showingmovie.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                               datePicker.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                               date=datePicker.getText().toString();
                            }
                        }, year, month, day);
                picker.show();
            }
        });

            next1.setOnClickListener((view) -> {
                if(index == 1 || index == 6)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company","GSC");
                    intent.putExtra("movietitle",movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime" , "8.15 AM");
                    intent.putExtra("price", "18.90");
                    startActivity(intent);
                }
            } );

            next2.setOnClickListener((view) -> {
                if(index == 1 || index == 6)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "GSC");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "2.45 PM");
                    intent.putExtra("price", "18.90");
                    startActivity(intent);
                }
            } );

            next3.setOnClickListener((view) -> {
                if(index == 1 || index == 6)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "GSC");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "4.55 PM");
                    intent.putExtra("price", "18.90");
                    startActivity(intent);
                }
            } );

            next4.setOnClickListener((view) -> {
                if(index == 0 || index == 2 || index == 4 || index == 8 || index == 9)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "TGV");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "1.05 PM");
                    intent.putExtra("price", "17.20");
                    startActivity(intent);
                }
            } );

            next5.setOnClickListener((view) -> {
                if(index == 0 || index == 2 || index == 4 || index == 8 || index == 9)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "TGV");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "3.05 PM");
                    intent.putExtra("price", "17.20");
                    startActivity(intent);
                }
            } );

            next6.setOnClickListener((view) -> {
                if(index == 0 || index == 2 || index == 4 || index == 8 || index == 9)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "TGV");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "5.45 PM");
                    intent.putExtra("price", "17.20");
                    startActivity(intent);
                }
            } );

            next7.setOnClickListener((view) -> {
                if(index == 0 || index == 2 || index == 4 || index == 8 || index == 9)
                    Toast.makeText(showingmovie.this,"Not available for this selection",Toast.LENGTH_SHORT).show();
                else{
                    Intent intent = new Intent(showingmovie.this, booking_seat.class);
                    intent.putExtra("company", "TGV");
                    intent.putExtra("movietitle", movieTitle);
                    intent.putExtra("date",date);
                    intent.putExtra("bookingtime", "8.25 PM");
                    intent.putExtra("price", "17.20");
                    startActivity(intent);
                }
            } );
    }

    public String getMovieTitle(int movieIndex){
        switch (movieIndex){
            case 0:
                moviePoster.setImageResource(R.drawable.awritersodyssey00_450);
                return "A Writer's Odyssey";
            case 1:
                moviePoster.setImageResource(R.drawable.calls00_450);
                return "Calls";
            case 2:
                moviePoster.setImageResource(R.drawable.demonslayer00_450);
                return "Demon Slayer - Kimetsu No Yaiba The Movie: Mugen Train";
            case 3:
                moviePoster.setImageResource(R.drawable.detectivechinatown300_450);
                return "Detective Chinatown 3";//both
            case 4:
                moviePoster.setImageResource(R.drawable.endgame00_450);
                return "Endgame";
            case 5:
                moviePoster.setImageResource(R.drawable.monsterhunter00_450);
                return "Monster Hunter";
            case 6:
                moviePoster.setImageResource(R.drawable.nenjam00_450);
                return "Nenjam Marappathillai";
            case 7:
                moviePoster.setImageResource(R.drawable.rayalastdragon00_450);
                return "Raya And The Last Dragon";
            case 8:
                moviePoster.setImageResource(R.drawable.selamatharixjadi00_450);
                return "Selamat Hari X Jadi";
            case 9:
                moviePoster.setImageResource(R.drawable.doraemon202100_450);
                return "Stand By Me Doraemon 2";
            case 10:
                moviePoster.setImageResource(R.drawable.conheartist00_450);
                return "The Con-Heartist";
            case 11:
                moviePoster.setImageResource(R.drawable.wonderwoman8400_450);
                return "Wonder Woman 1984";
            default:
                return "";
        }
    }

}