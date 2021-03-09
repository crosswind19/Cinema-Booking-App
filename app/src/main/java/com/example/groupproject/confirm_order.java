package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Model.BookingData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class confirm_order extends AppCompatActivity {

    TextView movieTitle,time,date,seat,extra;
    Button btnConfirm, btnCancel;
    String title,sTime,sDate,sSeat,Extra, bookingtime, dateTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        movieTitle=findViewById(R.id.tv_movieTitle4);
        time=findViewById(R.id.tv_time4);
        date=findViewById(R.id.tv_date4);
        seat=findViewById(R.id.tv_seat4);
        extra=findViewById(R.id.tv_food2);
        btnConfirm = (Button)findViewById(R.id.btn_deleteorder);
        btnCancel = (Button)findViewById(R.id.btn_cancel);

        Intent gettime = getIntent();
        Calendar calendar = Calendar.getInstance();
        bookingtime = gettime.getStringExtra("time");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy ");
        dateTime = simpleDateFormat.format(calendar.getTime());
        date.setText("Date: " + dateTime);
        time.setText("Time: " + bookingtime);


        btnConfirm.setOnClickListener((view) -> {
            title=movieTitle.getText().toString();
            sTime=time.getText().toString();
            sDate=date.getText().toString();
            sSeat=seat.getText().toString();
            Extra=extra.getText().toString();
            sendOrderData();
            Intent intent = new Intent(confirm_order.this, payment.class);
            startActivity(intent);
        } );

        btnCancel.setOnClickListener((view) -> {
            Intent intent = new Intent(confirm_order.this, booking_food.class);
            startActivity(intent);
        } );

    }

    private void sendOrderData(){
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Booking Info").child(fAuth.getUid());
        BookingData bookingData = new BookingData(title,sTime,sDate,sSeat,Extra);
        myRef.setValue(bookingData);
    }


}