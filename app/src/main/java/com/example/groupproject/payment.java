package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class payment extends AppCompatActivity {

    Button cash,card;
    EditText name, phoneNumber, email,cardNumber,date,ccv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cash = (Button)findViewById(R.id.cash);
        card = (Button)findViewById(R.id.pay);

        card.setOnClickListener( new View.OnClickListener() {
            public void onClick(View v) {
                EditText userName = (EditText) findViewById(R.id.NAME);
                EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
                EditText email = (EditText) findViewById(R.id.email);
                EditText cardnumber = (EditText) findViewById(R.id.cardNumber);
                EditText date = (EditText) findViewById(R.id.date);
                EditText ccv = (EditText) findViewById(R.id.ccv);


                if( TextUtils.isEmpty(userName.getText()) || TextUtils.isEmpty(phoneNumber.getText()) || TextUtils.isEmpty(email.getText()) ||
                        TextUtils.isEmpty(cardnumber.getText()) || TextUtils.isEmpty(date.getText()) || TextUtils.isEmpty(ccv.getText())){
                    /**
                     *   You can Toast a message here that the Username is Empty
                     **/
                    userName.setError( "First name is required!" );

                }else{
                    Intent i = new Intent(payment.this, payCard.class);
                    startActivity(i);
                }
            }

        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment.this, payCard.class);
                startActivity(intent);
            }
        });

    }
}