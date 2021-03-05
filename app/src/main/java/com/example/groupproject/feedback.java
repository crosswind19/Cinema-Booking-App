package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Model.Feedbacks;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {

    EditText txtusername, txtfeedback;
    String username,message;
    Button btnsubmit;
    Feedbacks feedbacks;
    FirebaseDatabase rootNode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rootNode = FirebaseDatabase.getInstance();
                reference = rootNode.getReference("Feedback");

                reference.setValue("Username");



                //Toast.makeText(datainsert.this, "data inserted sucessfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(feedback.this, searchlist.class);
                startActivity(intent);
            }
        });


    }
}