package com.example.groupproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class activity_login extends AppCompatActivity {

    private EditText Username;
    private EditText Password;
    private Button Login;
    private TextView ForgotPassword;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Username = (EditText)findViewById(R.id.tv_username);
        Password = (EditText)findViewById(R.id.tv_password);
        Login = (Button)findViewById(R.id.btn_login);
        ForgotPassword = (TextView)findViewById(R.id.tv_forgetpassword);

        
    }

    private void validate(String userName, String userPassword){
        if((userName == "Admin") && (userPassword == "1234")){
            Intent intent = new Intent(activity_login.this, MainActivity.class);
            startActivity(intent);
        }else{
            counter--;

            if(counter==0){
                Login.setEnabled(false);
            }
        }
    }
}