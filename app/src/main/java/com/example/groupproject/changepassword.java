package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
    private String oldpass, newpass, renew;
    private Boolean result = false;

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

        oldpass = oldPassword.getText().toString();
        newpass = newPassword.getText().toString();
        renew = reNewPassword.getText().toString();


        /*if (TextUtils.isEmpty(oldpass)) {
            oldPassword.setError("Old Password can't be empty.");
        }

        else if (TextUtils.isEmpty(newpass)) {
            newPassword.setError("New Password can't be empty.");
        }

        else if (newpass.length() < 8) {
            newPassword.setError("New Password must be more than 7 Characters");
        }

        else if (TextUtils.isEmpty(renew)){
            reNewPassword.setError("This field can't be empty.");
        }

        else if (!TextUtils.equals(newpass, renew)){
            newPassword.setError("Password does not match.");
            reNewPassword.setError("Password does not match.");
        }else
            result = true;*/

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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