package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class activity_forgotpassword extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        passwordEmail = (EditText)findViewById(R.id.tv_sendemailtoresetpass);
        resetPassword = (Button)findViewById(R.id.btn_reset);
        firebaseAuth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String useremail = passwordEmail.getText().toString().trim();

                if(useremail.equals("")) {
                    Toast.makeText(activity_forgotpassword.this, "Please enter your registered email ID.", Toast.LENGTH_LONG).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(useremail).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if(task.isSuccessful()){
                                //user enters a registered email
                                Toast.makeText(activity_forgotpassword.this, "Password reset email sent.", Toast.LENGTH_LONG).show();
                                finish();
                                startActivity(new Intent(activity_forgotpassword.this, activity_login.class));
                            } else {
                                //if user enters a not registered email.
                                Toast.makeText(activity_forgotpassword.this, "Error in sending reset password email.", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }
            }
        });
    }
}