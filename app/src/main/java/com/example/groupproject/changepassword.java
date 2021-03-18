package com.example.groupproject;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changepassword extends AppCompatActivity {

    private Button reset;
    private EditText newPassword;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        reset = findViewById(R.id.btn_reset);
        newPassword = findViewById(R.id.et_newpass);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fieldCheck()==true){
                    String userPasswordNew = newPassword.getText().toString();
                    firebaseUser.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            if (task.isSuccessful()){
                                Toast.makeText(changepassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(changepassword.this, activity_viewprofile.class));
                            }
                            else {
                                Toast.makeText(changepassword.this, "Password Update Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
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

    private boolean fieldCheck(){
        if (TextUtils.isEmpty(newPassword.getText().toString())) {
            newPassword.setError("Password is Required.");
            return false;
        }
        else if (newPassword.getText().toString().length() < 8) {
            newPassword.setError("Password Must be >= 8 Characters");
            return false;
        }
        else
        {
            return true;
        }
    }
}