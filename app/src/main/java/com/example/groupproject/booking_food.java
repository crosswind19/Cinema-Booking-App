package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class booking_food extends AppCompatActivity {
    static int food1;
    static int food2;
    static int foodtotal1;
    static int foodtotal2;
    static int alltotal;
    Button btnbuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking_food);
        btnbuy = (Button)findViewById(R.id.btn_buy);
        totalcal();

        btnbuy.setOnClickListener((view) -> {
            Intent intent = new Intent(booking_food.this, MainActivity.class);
            startActivity(intent);
        });
    }

    public void food1_inc(View view){
        food1 = inc(food1);
        TextView tv = (TextView)findViewById(R.id.qty1);
        tv.setText("" + food1);
        totalcal();
    }

    public void food1_dec(View view){
        food1 = dec(food1);
        TextView tv = (TextView)findViewById(R.id.qty1);
        if(food1 > 0)
            tv.setText("" + food1);
        else
            tv.setText("");
        totalcal();
    }

    public void food2_inc(View view){
        food2 = inc(food2);
        TextView tv = (TextView)findViewById(R.id.qty2);
        tv.setText("" + food2);
        totalcal();
    }

    public void food2_dec(View view){
        food2 = dec(food2);
        TextView tv = (TextView)findViewById(R.id.qty2);
        if(food2 > 0)
            tv.setText("" + food2);
        else
            tv.setText("");
        totalcal();
    }

    public int dec(int x){
        if(x > 0){
            x--;
            return x;
        }
        else
            return 0;
    }

    public int inc(int x){
        x++;
        return x;
    }

    public void totalcal(){
        foodtotal1 = food1 * (10);
        foodtotal2 = food2 * (15);
        alltotal = foodtotal1 + foodtotal2;
        if(alltotal > 0){
            TextView tv = (TextView)findViewById(R.id.totalfood);
            tv.setText("RM" + alltotal);
        }
        else{
            TextView tv = (TextView)findViewById(R.id.totalfood);
            tv.setText("");
        }
    }
}