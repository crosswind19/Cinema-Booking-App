package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class changeprofile extends AppCompatActivity {

    private EditText newUserName, newUserEmail, newUserPhoneNumber;
    private Button save;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changeprofile);

        newUserName = findViewById(R.id.tv_newname);
        newUserEmail = findViewById(R.id.tv_newemail);
        newUserPhoneNumber = findViewById(R.id.tv_newnum);
        save = findViewById(R.id.btn_edit);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        final DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Email = snapshot.child("EmailAddress").getValue().toString();
                String Name = snapshot.child("Name").getValue().toString();
                String Phone = snapshot.child("Phone").getValue().toString();
                newUserName.setText(Name);
                newUserEmail.setText(Email);
                newUserPhoneNumber.setText(Phone);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(changeprofile.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = newUserName.getText().toString();
                String email = newUserEmail.getText().toString();
                String phonenum = newUserPhoneNumber.getText().toString();

                UserProfile userProfile = new UserProfile(email, name, phonenum);

                databaseReference.setValue(userProfile);

                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
}