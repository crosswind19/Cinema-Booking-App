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

    TextView movieTitle,time,date,seat,extra,totalprice;
    Button btnConfirm, btnCancel;
    String title;
    String sTime;
    String sDate;
    String sSeat;
    String Extra;
    String bookingDate;
    String bookingTime;
    String Price;
    double ttlprice;
    int p1,p2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);
        movieTitle=findViewById(R.id.tv_movieTitle4);
        time=findViewById(R.id.tv_time4);
        date=findViewById(R.id.tv_date4);
        seat=findViewById(R.id.tv_seat4);
        extra=findViewById(R.id.tv_food2);
        totalprice=findViewById(R.id.priceview3);
        btnConfirm = findViewById(R.id.btn_deleteorder);
        btnCancel = findViewById(R.id.btn_cancel);

        fetchDate();
        fetchPrice();
        fetchSeat();

        btnConfirm.setOnClickListener((view) -> {
            title=movieTitle.getText().toString();
            sTime=time.getText().toString();
            sDate=date.getText().toString();
            sSeat=seat.getText().toString();
            Extra=extra.getText().toString();
            Price=totalprice.getText().toString();
            sendOrderData();
            Intent intent = new Intent(confirm_order.this, payment.class);
            startActivity(intent);
        } );

        btnCancel.setOnClickListener((view) -> {
            Intent intent = new Intent(confirm_order.this, showingmovie.class);
            startActivity(intent);
        } );

    }

    private void sendOrderData(){
        FirebaseAuth fAuth = FirebaseAuth.getInstance();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("Booking Info").child(fAuth.getUid());
        BookingData bookingData = new BookingData(title,sDate,sTime,sSeat,Extra,Price);
        myRef.setValue(bookingData);
    }

    private void fetchDate(){
        Intent intent = getIntent();
        Calendar calendar = Calendar.getInstance();
        bookingTime = intent.getStringExtra("time");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE, dd-MMM-yyyy ");
        bookingDate = simpleDateFormat.format(calendar.getTime());
        date.setText(bookingDate);
        time.setText(bookingTime);
    }

    private void fetchPrice(){
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        String ticketNo = intent.getStringExtra("totalseat");
        String foodp = intent.getStringExtra("foodprice");
        String food1 = intent.getStringExtra("food1");
        String food2 = intent.getStringExtra("food2");
        double ticketPrice = Double.parseDouble(price);
        double foodPrice = Double.parseDouble(foodp);
        int totalSeat = Integer.parseInt(ticketNo);
        p1 = Integer.parseInt(food1)/(10);
        p2 = Integer.parseInt(food2)/(15);
        ttlprice = (totalSeat*ticketPrice)+foodPrice;
        totalprice.setText("RM " + ttlprice);
        extra.setText("Combo A * " + p1 + " Combo B * " + p2);
    }

    private void fetchSeat(){
        Intent intent = getIntent();
        String st = intent.getStringExtra("seat");
        seat.setText(st);
    }

}