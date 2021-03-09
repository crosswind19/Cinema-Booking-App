package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupproject.Model.BookingData;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class orderhistory extends AppCompatActivity {

    private Button delete;
    private TextView title,date,time,seat,food;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderhistory);
        delete=findViewById(R.id.btn_deleteorder);
        title=findViewById(R.id.tv_movieTitle4);
        date=findViewById(R.id.tv_date4);
        time=findViewById(R.id.tv_time4);
        seat=findViewById(R.id.tv_seat4);
        food=findViewById(R.id.tv_food2);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        databaseReference = firebaseDatabase.getReference("Booking Info").child(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    BookingData classBookingData = snapshot.getValue(BookingData.class);
                    title.setText("Movie Title : " + classBookingData.getMovieTitle());
                    date.setText("Date : " + classBookingData.getShowingDate());
                    time.setText("Time : " + classBookingData.getShowingTime());
                    seat.setText("Seat : " + classBookingData.getSeatNumber());
                    food.setText("Food and Beverage : " + classBookingData.getFoodAndBeverage());
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

    }
}