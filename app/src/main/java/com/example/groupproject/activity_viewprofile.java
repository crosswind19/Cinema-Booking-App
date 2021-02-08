package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class activity_viewprofile extends AppCompatActivity {

    private ImageView ProfilePic;
    private TextView pName, pEmail, pPhone;
    private Button pChangeProfile, pChangePassword, pLogout;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewprofile);

        ProfilePic = findViewById(R.id.iv_profilePic);
        pName = findViewById(R.id.tv_ProfileName);
        pEmail = findViewById(R.id.tv_ProfileEmail);
        pPhone = findViewById(R.id.tv_ProfilePhone);
        pChangeProfile = findViewById(R.id.btn_changeprofile);
        pChangePassword = findViewById(R.id.btn_changepass);
        pLogout = findViewById(R.id.btn_edit);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String Email = snapshot.child("EmailAddress").getValue().toString();
                String Name = snapshot.child("Name").getValue().toString();
                String Phone = snapshot.child("Phone").getValue().toString();
                pName.setText(Name);
                pEmail.setText(Email);
                pPhone.setText(Phone);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(activity_viewprofile.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });

        pChangeProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_viewprofile.this, changeprofile.class));
            }
        });

        pChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_viewprofile.this, changepassword.class));
            }
        });

        pLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(activity_viewprofile.this, activity_login.class));
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