package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class confirm_order extends AppCompatActivity {

    String movieTitle;
    Button btnConfirm, btnCancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        btnConfirm = (Button)findViewById(R.id.btn_confim);
        btnCancel = (Button)findViewById(R.id.btn_cancel);

        btnConfirm.setOnClickListener((view) -> {
            Intent intent = new Intent(confirm_order.this, payment.class);
            startActivity(intent);
        } );

        btnCancel.setOnClickListener((view) -> {
            Intent intent = new Intent(confirm_order.this, booking_food.class);
            startActivity(intent);
        } );

    }


}