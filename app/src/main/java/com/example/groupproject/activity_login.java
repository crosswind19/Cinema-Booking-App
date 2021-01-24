package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
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

public class activity_login extends AppCompatActivity {

    EditText Email,Password;
    Button Login;
    TextView ForgotPassword,Reg;
    private int counter = 5;

    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Email = findViewById(R.id.tv_Email);
        Password = findViewById(R.id.tv_password);
        Login = findViewById(R.id.btn_login);
        ForgotPassword = findViewById(R.id.tv_forgetpassword);
        Reg = findViewById(R.id.tv_Reg);
        fAuth = FirebaseAuth.getInstance();

        Login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String email = Email.getText().toString().trim();
                String password = Password.getText().toString().trim();

                if (TextUtils.isEmpty(email)){
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

                fAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(activity_login.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        } else {
                            Toast.makeText(activity_login.this, "Error !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            counter--;

                            if(counter==0){
                                Login.setEnabled(false);
                            }
                        }
                    }
                });
            }
        });

        Reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_signup.class));
            }
        });

        ForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_forgotpassword.class));
            }
        });
    }

  /*  private void validate(String userName, String userPassword){
        if((userName == "Admin") && (userPassword == "1234")){
            Intent intent = new Intent(activity_login.this, MainActivity.class);
            startActivity(intent);
        }else{
            counter--;

            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }*/
}