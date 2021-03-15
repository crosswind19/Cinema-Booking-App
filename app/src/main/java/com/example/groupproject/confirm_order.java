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

import java.text.DecimalFormat;

public class confirm_order extends AppCompatActivity {

    TextView movieTitle,time,date,seat,extra,totalprice,movieCompany;
    Button btnConfirm, btnCancel;
    String title;
    String sTime;
    String sDate;
    String sSeat;
    String Extra;
    String Company;
    String bookingDate;
    String bookingTime;
    String Price;
    String movie_title;
    String company;
    double ttlprice;
    int p1,p2;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");

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
        movieCompany=findViewById(R.id.tv_company);
        btnConfirm = findViewById(R.id.btn_comfirmorder);
        btnCancel = findViewById(R.id.btn_cancel);

        fetchInfo();
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
            Company=movieCompany.getText().toString();
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
        BookingData bookingData = new BookingData(title,sDate,sTime,sSeat,Extra,Price,Company);
        myRef.setValue(bookingData);
    }

    private void fetchInfo(){
        Intent intent = getIntent();
        movie_title = intent.getStringExtra("movietitle");
        movieTitle.setText(movie_title);
        company = intent.getStringExtra("company");
        movieCompany.setText(company);
    }

    private void fetchDate(){
        Intent intent = getIntent();
        bookingTime = intent.getStringExtra("time");
        bookingDate = intent.getStringExtra("date");
        date.setText(bookingDate);
        time.setText(bookingTime);
    }

    private void fetchPrice(){
        Intent intent = getIntent();
        String price = intent.getStringExtra("price");
        int ticketNo = intent.getIntExtra("totalseat", 0);
        String foodp = intent.getStringExtra("foodprice");
        String food1 = intent.getStringExtra("food1");
        String food2 = intent.getStringExtra("food2");
        double ticketPrice = Double.parseDouble(price);
        double foodPrice = Double.parseDouble(foodp);
        int totalSeat = ticketNo;//Integer.parseInt(ticketNo);
        p1 = Integer.parseInt(food1)/(10);
        p2 = Integer.parseInt(food2)/(15);
        ttlprice = (totalSeat*ticketPrice)+foodPrice;
        totalprice.setText("RM " + decimalFormat.format(ttlprice));
        extra.setText("Combo A * " + p1 + " Combo B * " + p2);
    }

    private void fetchSeat(){
        Intent intent = getIntent();
        String st = intent.getStringExtra("seat");
        seat.setText(st);
    }
}