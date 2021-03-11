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

    //private final static int requestcode1 = 1, requestcode2 = 2, requestcode3 = 3, requestcode4 = 4, requestcode5 = 5, requestcode6 = 6, requestcode7 = 7;

    ToggleButton a1,a2,a3,a4,a5,a6,a7,a8,b1,b2,b3,b4,b5,b6,b7,b8,c1,c2,c3,c4,c5,c6,c7,c8,d1,d2,d3,d4,d5,d6,d7,d8,e1,e2,e3,e4,e5,e6,e7,e8,f1,f2,f3,f4,f5,f6,f7,f8;
    //ToggleButton buttons [][] = new ToggleButton [6][8];

    String time, dateTime, price, seat="", tempseat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_seat);

        exit = findViewById(R.id.exit);
        confirm= findViewById(R.id.confirm);
        value = findViewById(R.id.value);
        clear = findViewById(R.id.clear);

        a1 = findViewById(R.id.button_01);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A1 ";
                seat += tempseat;
            }
        });
        a2 = findViewById(R.id.button_02);
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A2 ";
                seat += tempseat;
            }
        });
        a3 = findViewById(R.id.button_03);
        a3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A3 ";
                seat += tempseat;
            }
        });
        a4 = findViewById(R.id.button_04);
        a4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A4 ";
                seat += tempseat;
            }
        });
        a5 = findViewById(R.id.button_05);
        a5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A5 ";
                seat += tempseat;
            }
        });
        a6 = findViewById(R.id.button_06);
        a6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A6 ";
                seat += tempseat;
            }
        });
        a7 = findViewById(R.id.button_07);
        a7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A7 ";
                seat += tempseat;
            }
        });
        a8 = findViewById(R.id.button_08);
        a8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "A8 ";
                seat += tempseat;
            }
        });

        b1 = findViewById(R.id.button_11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B1 ";
                seat += tempseat;
            }
        });
        b2 = findViewById(R.id.button_12);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B2 ";
                seat += tempseat;
            }
        });
        b3 = findViewById(R.id.button_13);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B3 ";
                seat += tempseat;
            }
        });
        b4 = findViewById(R.id.button_14);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B4 ";
                seat += tempseat;
            }
        });
        b5 = findViewById(R.id.button_15);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B5 ";
                seat += tempseat;
            }
        });
        b6 = findViewById(R.id.button_16);
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B6 ";
                seat += tempseat;
            }
        });
        b7 = findViewById(R.id.button_17);
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B7 ";
                seat += tempseat;
            }
        });
        b8 = findViewById(R.id.button_18);
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "B8 ";
                seat += tempseat;
            }
        });

        c1 = findViewById(R.id.button_21);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C1 ";
                seat += tempseat;
            }
        });
        c2 = findViewById(R.id.button_22);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C2 ";
                seat += tempseat;
            }
        });
        c3 = findViewById(R.id.button_23);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C3 ";
                seat += tempseat;
            }
        });
        c4 = findViewById(R.id.button_24);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C4 ";
                seat += tempseat;
            }
        });
        c5 = findViewById(R.id.button_25);
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C5 ";
                seat += tempseat;
            }
        });
        c6 = findViewById(R.id.button_26);
        c6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C6 ";
                seat += tempseat;
            }
        });
        c7 = findViewById(R.id.button_27);
        c7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C7 ";
                seat += tempseat;
            }
        });
        c8 = findViewById(R.id.button_28);
        c8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "C8 ";
                seat += tempseat;
            }
        });

        d1 = findViewById(R.id.button_31);
        d1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D1 ";
                seat += tempseat;
            }
        });
        d2 = findViewById(R.id.button_32);
        d2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D2 ";
                seat += tempseat;
            }
        });
        d3 = findViewById(R.id.button_33);
        d3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D3 ";
                seat += tempseat;
            }
        });
        d4 = findViewById(R.id.button_34);
        d4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D4 ";
                seat += tempseat;
            }
        });
        d5 = findViewById(R.id.button_35);
        d5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D5 ";
                seat += tempseat;
            }
        });
        d6 = findViewById(R.id.button_36);
        d6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D6 ";
                seat += tempseat;
            }
        });
        d7 = findViewById(R.id.button_37);
        d7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D7 ";
                seat += tempseat;
            }
        });
        d8 = findViewById(R.id.button_38);
        d8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "D8 ";
                seat += tempseat;
            }
        });


        e1 = findViewById(R.id.button_41);
        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E1 ";
                seat += tempseat;
            }
        });
        e2 = findViewById(R.id.button_42);
        e2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E2 ";
                seat += tempseat;
            }
        });
        e3 = findViewById(R.id.button_43);
        e3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E3 ";
                seat += tempseat;
            }
        });
        e4 = findViewById(R.id.button_44);
        e4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E4 ";
                seat += tempseat;
            }
        });
        e5 = findViewById(R.id.button_45);
        e5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E5 ";
                seat += tempseat;
            }
        });
        e6 = findViewById(R.id.button_46);
        e6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E6 ";
                seat += tempseat;
            }
        });
        e7 = findViewById(R.id.button_47);
        e7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E7 ";
                seat += tempseat;
            }
        });
        e8 = findViewById(R.id.button_48);
        e8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "E8 ";
                seat += tempseat;
            }
        });

        f1 = findViewById(R.id.button_51);
        f1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F1 ";
                seat += tempseat;
            }
        });
        f2 = findViewById(R.id.button_52);
        f2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F2 ";
                seat += tempseat;
            }
        });
        f3 = findViewById(R.id.button_53);
        f3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F3 ";
                seat += tempseat;
            }
        });
        f4 = findViewById(R.id.button_54);
        f4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F4 ";
                seat += tempseat;
            }
        });
        f5 = findViewById(R.id.button_55);
        f5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F5 ";
                seat += tempseat;
            }
        });
        f6 = findViewById(R.id.button_56);
        f6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F6 ";
                seat += tempseat;
            }
        });
        f7 = findViewById(R.id.button_57);
        f7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F7 ";
                seat += tempseat;
            }
        });
        f8 = findViewById(R.id.button_58);
        f8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tempseat = "F8 ";
                seat += tempseat;
            }
        });

        /*for(int i=0;i<6;i++){
            for(int j=0;j<9;j++){
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener((View.OnClickListener) this);
            }
        }

        for(int i=0;i<6;i++){
            for(int j=0;j<9;j++){
                int x = 0;
                seat[x] = buttons[i][j].getText().toString();
                x++;
            }
        }*/

        fetchDateAndTime();

        exit.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, DetailedFragment.class);
            startActivity(intent);
        }));

        confirm.setOnClickListener((v -> {
            Intent intent = new Intent(booking_seat.this, booking_food.class);
            intent.putExtra("time", time);
            intent.putExtra("price", price);
            intent.putExtra("seat", seat);
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

    public void fetchDateAndTime(){
        TextView date = findViewById(R.id.tvDate);
        Intent intent = getIntent();
        Calendar calendar = Calendar.getInstance();
        time = intent.getStringExtra("bookingtime");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy ");
        dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText(dateTime + time);
        price = intent.getStringExtra("price");
    }
}