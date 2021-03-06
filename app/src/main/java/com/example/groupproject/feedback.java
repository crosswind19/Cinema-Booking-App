package com.example.groupproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.groupproject.Model.Feedbacks;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class feedback extends AppCompatActivity {

    EditText txtusername, txtfeedback;
    //String username, message;
    Button btnsubmit;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    FirebaseStorage firebaseStorage;
    private StorageReference storageReference;
    FirebaseDatabase firebaseDatabase;

    DatabaseReference myRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);


        txtusername = findViewById(R.id.txtusername);
        txtfeedback = findViewById(R.id.txtfeedback);
        btnsubmit = (Button)findViewById(R.id.btnsubmit);

        myRef = FirebaseDatabase.getInstance().getReference().child("Feedback");

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendFeedback();
            }
        });

    }//onCreate Method End


    public void sendFeedback(){
        String username = txtusername.getText().toString();
        String message = txtfeedback.getText().toString();

        Feedbacks feedback = new Feedbacks(username, message);
        myRef.push().setValue(feedback);
    }
}