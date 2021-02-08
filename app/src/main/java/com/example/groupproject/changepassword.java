package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class changepassword extends AppCompatActivity {

    private Button reset;
    private EditText oldPassword, newPassword, reNewPassword;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepassword);

        reset = findViewById(R.id.btn_reset);
        oldPassword = findViewById(R.id.et_oldpass);
        newPassword = findViewById(R.id.et_newpass);
        reNewPassword = findViewById(R.id.et_renew);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!oldPassword.toString().equals("") || !newPassword.toString().equals("") || !reNewPassword.toString().equals("")) {
                    if (!oldPassword.equals(newPassword)) {
                        if (newPassword.length() >= 8 && newPassword.equals(reNewPassword)) {
                            String userPasswordNew = newPassword.getText().toString();
                            firebaseUser.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful())
                                        Toast.makeText(changepassword.this, "Password Changed", Toast.LENGTH_SHORT).show();
                                    else
                                        Toast.makeText(changepassword.this, "Password Update Failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                        } else {
                            newPassword.setError("Password does not match");
                            reNewPassword.setError("Password does not match");
                        }
                    } else
                        newPassword.setError("New Password can't be Old Password");
                } else {
                    if(oldPassword == null)
                        oldPassword.setError("This field cannot be left empty");
                    else if(newPassword == null)
                        newPassword.setError("This field cannot be left empty");
                    else if(reNewPassword == null)
                        reNewPassword.setError("This field cannot be left empty");
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
}