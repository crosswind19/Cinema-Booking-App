package com.example.groupproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

public class payment extends AppCompatActivity {

    Button cash,card;
    EditText name, phoneNumber, email,cardNumber,date,ccv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        cash = (Button)findViewById(R.id.cash);
        card = (Button)findViewById(R.id.card);

        card.setEnabled(false);

        card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(payment.this,"Card payment is not available",Toast.LENGTH_SHORT).show();
            }
        });

//        card.setOnClickListener( new View.OnClickListener() {
//            public void onClick(View v) {
//                EditText userName = (EditText) findViewById(R.id.NAME);
//                EditText phoneNumber = (EditText) findViewById(R.id.phoneNumber);
//                EditText email = (EditText) findViewById(R.id.email);
//                EditText cardnumber = (EditText) findViewById(R.id.cardNumber);
//                EditText date = (EditText) findViewById(R.id.date);
//                EditText ccv = (EditText) findViewById(R.id.ccv);
//
//
//                if( TextUtils.isEmpty(userName.getText()) || TextUtils.isEmpty(phoneNumber.getText()) || TextUtils.isEmpty(email.getText()) ||
//                        TextUtils.isEmpty(cardnumber.getText()) || TextUtils.isEmpty(date.getText()) || TextUtils.isEmpty(ccv.getText())){
//                    /**
//                     *   You can Toast a message here that the Username is Empty
//                     **/
//                    userName.setError( "First name is required!" );
//
//                }else{
//                    Intent i = new Intent(payment.this, payCard.class);
//                    startActivity(i);
//                }
//            }
//
//        });

        cash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(payment.this, payCard.class);
                startActivity(intent);
                addNotification();
            }
        });

    }

    private void addNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this).setSmallIcon(android.R.drawable.stat_notify_more)
                .setContentTitle("Not Cinema App").setContentText("Thank you for the Purchase! \n You can check your movie info in Order List");

        Intent notificationIntent = new Intent(this, orderhistory.class);
        PendingIntent contentIntent = PendingIntent.getActivity(this ,0 , notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentIntent);
        NotificationManager manager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());

    }
}