package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;


public class activity_signup extends AppCompatActivity {
    //public static final String TAG = "TAG";
    EditText Fullname, Username, Email, Phoneno, Password;
    Button Go;
    TextView Login;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Fullname = findViewById(R.id.tv_fullname);
        Username = findViewById(R.id.tv_username2);
        Email = findViewById(R.id.tv_email);
        Phoneno = findViewById(R.id.tv_phoneno);
        Password = findViewById(R.id.tv_password2);
        Go = findViewById(R.id.btn_go);
        Login = findViewById(R.id.tv_text3);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Go.setOnClickListener(v -> {
            String email = Email.getText().toString().trim();
            String password = Password.getText().toString().trim();

            if (TextUtils.isEmpty(email)) {
                Email.setError("Email is Required.");
                return;
            }

            if (TextUtils.isEmpty(password)) {
                Password.setError("Password is Required.");
                return;
            }

            if (password.length() < 8) {
                Password.setError("Password Must be >= 8 Characters");
                return;
            }

            fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(activity_signup.this, "User Created", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    } else {
                        Toast.makeText(activity_signup.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_login.class));
            }
        });
    }
}