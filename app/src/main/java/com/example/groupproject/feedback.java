package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.groupproject.Model.Feedbacks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    EditText txtusername, txtfeedback;
    Button btnsubmit;
    DatabaseReference reff;
    Feedbacks feedbacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        txtusername=(EditText)findViewById(R.id.txtusername);
        txtfeedback=(EditText)findViewById(R.id.txtfeedback);
        btnsubmit=(Button)findViewById(R.id.btnsubmit);
        feedbacks=new Feedbacks();
        reff= FirebaseDatabase.getInstance().getReference().child("Feedbacks");
        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                feedbacks.setUsername(txtusername.getText().toString().trim());
                feedbacks.getFeedback(txtfeedback.getText().toString().trim());
                reff.push().setValue(feedbacks);
                //Toast.makeText(datainsert.this, "data inserted sucessfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}