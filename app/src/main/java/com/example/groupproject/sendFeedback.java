package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Model.Feedbacks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class sendFeedback extends AppCompatActivity {

    EditText username, feedback;
    Button send;

    DatabaseReference feedbackdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_feedback);

        username = findViewById(R.id.susername);
        feedback = findViewById(R.id.sfeedback);
        send = findViewById(R.id.btn_sfeedback);

        feedbackdb = FirebaseDatabase.getInstance().getReference().child("Feedback");

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertfeedbackdata();

                Intent intent = new Intent(sendFeedback.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void insertfeedbackdata(){
        String name = username.getText().toString();
        String message = feedback.getText().toString();

        Feedbacks feedback = new Feedbacks(name,message);

        feedbackdb.push().setValue(feedback);
        Toast.makeText(this, "Feedback sent",Toast.LENGTH_SHORT).show();
    }
}