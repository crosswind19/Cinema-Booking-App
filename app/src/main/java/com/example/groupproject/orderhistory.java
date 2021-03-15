package com.example.groupproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Model.BookingData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class orderhistory extends AppCompatActivity {

    private Button delete,printReceipt;
    private TextView title,date,time,seat,food,price,company;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference,databaseref;
    private String username,totalPrice,movieTitle;
    SimpleDateFormat datePatternFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm a");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderhistory);
        delete=findViewById(R.id.btn_deleteorder);
        printReceipt=findViewById(R.id.btn_printreceipt);
        title=findViewById(R.id.tv_movieTitle4);
        date=findViewById(R.id.tv_date4);
        time=findViewById(R.id.tv_time4);
        seat=findViewById(R.id.tv_seat4);
        food=findViewById(R.id.tv_food2);
        price=findViewById(R.id.tv_totalprice);
        company=findViewById(R.id.tv_company2);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Booking Info").child(firebaseAuth.getUid());
        databaseref = firebaseDatabase.getReference("User Info").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    BookingData classBookingData = snapshot.getValue(BookingData.class);
                    title.setText("Movie Title : \n" + classBookingData.getMovieTitle());
                    date.setText("Date : " + classBookingData.getShowingDate());
                    time.setText("Time : " + classBookingData.getShowingTime());
                    seat.setText("Seat : " + classBookingData.getSeatNumber());
                    food.setText("Food and Beverage : " + classBookingData.getFoodAndBeverage());
                    price.setText("Total Price : " + classBookingData.getPrice());
                    company.setText("Company : " + classBookingData.getCompany());
                    totalPrice=classBookingData.getPrice();
                    movieTitle=classBookingData.getMovieTitle();
                }else{
                    startActivity(new Intent(orderhistory.this, MainActivity.class));
                    Toast.makeText(orderhistory.this,"Booking data still empty",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(orderhistory.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(v.getContext());
                alert.setMessage("Are you sure to delete the booking?");

                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot snapshot) {
                                databaseReference.removeValue();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError error) {
                                Toast.makeText(orderhistory.this, error.getCode(), Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                });
                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.create().show();
            }
        });

        databaseref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile classUserProfile = snapshot.getValue(UserProfile.class);
                username=classUserProfile.getName();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        printReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 printPDF();
                AlertDialog.Builder builder = new AlertDialog.Builder(orderhistory.this);
                builder.setCancelable(true);
                builder.setTitle("Receipt printed!");
                builder.setMessage("Printed receipt at Android/data/com.example.groupproject/files");
                builder.show();
            }
        });

    }

    private void printPDF() {
        PdfDocument myPdfDocument = new PdfDocument();
        Paint paint = new Paint();
        Paint forLinePaint = new Paint();
        PdfDocument.PageInfo myPageInfo = new PdfDocument.PageInfo.Builder(250,350,1).create();
        PdfDocument.Page myPage = myPdfDocument.startPage(myPageInfo);
        Canvas canvas = myPage.getCanvas();

        paint.setTextSize(15.5f);
        paint.setColor(Color.rgb(0,50,250));
        canvas.drawText("Not Cinema App",20,20,paint);
        paint.setTextSize(8.5f);
        forLinePaint.setStyle(Paint.Style.STROKE);
        forLinePaint.setPathEffect(new DashPathEffect(new float[]{5,5},0));
        forLinePaint.setStrokeWidth(2);
        canvas.drawLine(20,65,230,65,forLinePaint);

        canvas.drawText("Username : " + username,20,80,paint);
        canvas.drawLine(20,90,230,90,forLinePaint);

        canvas.drawText("Order:",20,105,paint);
        //details here
        canvas.drawText(company.getText().toString(),20,125,paint);
        canvas.drawText(title.getText().toString(),20,135,paint);
        canvas.drawText(date.getText().toString(),20,145,paint);
        canvas.drawText(time.getText().toString(),20,155,paint);
        canvas.drawText(seat.getText().toString(),20,165,paint);
        canvas.drawText(food.getText().toString(),20,175,paint);

        canvas.drawLine(20,200,230,200,forLinePaint);

        paint.setTextSize(10f);
        canvas.drawText("Total",120,225,paint);
        paint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText(totalPrice,230,225,paint);

        paint.setTextAlign(Paint.Align.LEFT);
        paint.setTextSize(8.5f);

        canvas.drawText("Date "+datePatternFormat.format(new Date().getTime()),20,260,paint);
        canvas.drawText("Payment Method : Cash",20,275,paint);

        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(12f);
        canvas.drawText("Thank You",canvas.getWidth()/2,320,paint);

        myPdfDocument.finishPage(myPage);
        File file = new File(this.getExternalFilesDir("/"),"Not Cinema App Receipt.pdf");
        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        myPdfDocument.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item10:
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}