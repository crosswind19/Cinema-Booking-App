package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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
    private Button pChangeProfile;
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

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserProfile userProfile = snapshot.getValue(UserProfile.class);
                pName.setText(userProfile.getName());
                pEmail.setText(userProfile.getEmailAddress());
                pPhone.setText(userProfile.getPhone());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(activity_viewprofile.this, error.getCode(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}