package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Fragment.DetailedFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class booking_seat extends AppCompatActivity {

//    TextView tvTitle,tvDesc,tvRating,tvReleaseDate;
    Button exit,confirm;
//    ImageView movieImage;
//    public String movieTitle,movieRating,movieReleaseDate,movieDesc,movieImagePath;

    Button clear;

    TextView value;

    int counter = 0;

    private final static int requestcode1 = 1, requestcode2 = 2, requestcode3 = 3, requestcode4 = 4,
            requestcode5 = 5, requestcode6 = 6, requestcode7 = 7;

    ToggleButton a1,a2,a3,a4,a5,a6,b1,b2,b3,b4,b5,b6,c1,c2,c3,c4,c5,c6,d1,d2,d3,d4,d5,d6,e1,e2,e3,e4,e5,e6,f1,f2,f3,f4,f5,f6,g1,g2,g3,g4,g5,g6,h1,h2,h3,h4,h5,h6;
//      ToggleButton buttons [][] = new ToggleButton [6][8];

    String time, dateTime, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_seat);

        exit = findViewById(R.id.exit);
        confirm= findViewById(R.id.confirm);
        value = findViewById(R.id.value);
        clear = findViewById(R.id.clear);

        a1 = findViewById(R.id.button_01);
        b1 = findViewById(R.id.button_02);
        c1 = findViewById(R.id.button_03);
        d1 = findViewById(R.id.button_04);
        e1 = findViewById(R.id.button_05);
        f1 = findViewById(R.id.button_06);
        g1 = findViewById(R.id.button_07);
        h1 = findViewById(R.id.button_08);

        a2 = findViewById(R.id.button_11);
        b2 = findViewById(R.id.button_12);
        c2 = findViewById(R.id.button_13);
        d2 = findViewById(R.id.button_14);
        e2 = findViewById(R.id.button_15);
        f2 = findViewById(R.id.button_16);
        g2 = findViewById(R.id.button_17);
        h2 = findViewById(R.id.button_18);

        a3 = findViewById(R.id.button_21);
        b3 = findViewById(R.id.button_22);
        c3 = findViewById(R.id.button_23);
        d3 = findViewById(R.id.button_24);
        e3 = findViewById(R.id.button_25);
        f3 = findViewById(R.id.button_26);
        g3 = findViewById(R.id.button_27);
        h3 = findViewById(R.id.button_28);

        a4 = findViewById(R.id.button_31);
        b4 = findViewById(R.id.button_32);
        c4 = findViewById(R.id.button_33);
        d4 = findViewById(R.id.button_34);
        e4 = findViewById(R.id.button_35);
        f4 = findViewById(R.id.button_36);
        g4 = findViewById(R.id.button_37);
        h4 = findViewById(R.id.button_38);


        a5 = findViewById(R.id.button_41);
        b5 = findViewById(R.id.button_42);
        c5 = findViewById(R.id.button_43);
        d5 = findViewById(R.id.button_44);
        e5 = findViewById(R.id.button_45);
        f5 = findViewById(R.id.button_46);
        g5 = findViewById(R.id.button_47);
        h5 = findViewById(R.id.button_48);

        a6 = findViewById(R.id.button_51);
        b6 = findViewById(R.id.button_52);
        c6 = findViewById(R.id.button_53);
        d6 = findViewById(R.id.button_54);
        e6 = findViewById(R.id.button_55);
        f6 = findViewById(R.id.button_56);
        g6 = findViewById(R.id.button_57);
        h6 = findViewById(R.id.button_58);

//        for(int i=0;i<6;i++){
//            for(int j=0;j<8;j++){
//                String buttonID = "button_" + i + j;
//                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
//                buttons[i][j] = findViewById(resID);
//                buttons[i][j].setOnClickListener((View.OnClickListener) this);
//
//            }
//        }

        TextView date = findViewById(R.id.tvDate);
        Intent intent2 = getIntent();
        Calendar calendar = Calendar.getInstance();
        time = intent2.getStringExtra("bookingtime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy ");
        dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText(dateTime + time);
        price = intent2.getStringExtra("price");

        exit.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, DetailedFragment.class);
            startActivity(intent);
        }));

        confirm.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, booking_food.class);
            intent.putExtra("time", time);
            intent.putExtra("price", price);
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