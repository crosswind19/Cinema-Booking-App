package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class payCard extends AppCompatActivity {

    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_card);

        done = (Button)findViewById(R.id.btn_done);

        done.setOnClickListener((view) -> {
            Intent intent = new Intent(payCard.this, searchlist.class);
            startActivity(intent);
        } );

    }
}