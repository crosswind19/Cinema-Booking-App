package com.example.groupproject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.groupproject.Model.UserProfile;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;


public class activity_signup extends AppCompatActivity {
    EditText Fullname, Username, Email, Phoneno, Password;
    Button Go;
    TextView Login;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String email,name,phone,password;
    private ImageView userProfilePic;
    FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    private StorageReference storageReference;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                userProfilePic.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
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
        userProfilePic = findViewById(R.id.iv_userProfile);

        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        userProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select image"), PICK_IMAGE);
            }
        });

        if (fAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        Go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    String user_email = Email.getText().toString().trim();
                    String user_password = Password.getText().toString().trim();
                    fAuth.createUserWithEmailAndPassword(user_email, user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                sendEmailVerification();
                            }else{
                                Toast.makeText(activity_signup.this, "Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });


        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),activity_login.class));
            }
        });
    }


    private Boolean validate(){
        Boolean result = false;

        name = Username.getText().toString();
        password = Password.getText().toString();
        email = Email.getText().toString();
        phone = Phoneno.getText().toString();


        if (TextUtils.isEmpty(email)) {
            Email.setError("Email is Required.");
        }

        else if (TextUtils.isEmpty(password)) {
            Password.setError("Password is Required.");
        }

        else if (password.length() < 8) {
            Password.setError("Password Must be >= 8 Characters");
        }

        else if (TextUtils.isEmpty(name)){
            Username.setError("Username is Required.");
        }

        else if (TextUtils.isEmpty(phone)){
            Phoneno.setError("Phone Number is Required.");

        }else{
            result = true;
        }

        return result;
    }

    private void sendEmailVerification(){
        FirebaseUser fuser = fAuth.getCurrentUser();
        if(fuser!=null){
            fuser.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(activity_signup.this, "User register complete,verification link has been sent.", Toast.LENGTH_LONG).show();
                        sendUserData();
                        fAuth.signOut();
                        finish();
                        startActivity(new Intent(getApplicationContext(), activity_login.class));
                    }else {
                        Toast.makeText(activity_signup.this, "Verification link has not been sent.", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    private void sendUserData(){
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference myRef = firebaseDatabase.getReference("User Info").child(fAuth.getUid());
        StorageReference imageReference = storageReference.child(fAuth.getUid()).child("Images").child("Profile Pic");

        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(activity_signup.this, "Upload failed", Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(activity_signup.this, "Upload successful", Toast.LENGTH_SHORT).show();
            }
        });
        UserProfile userProfile = new UserProfile(email,name,phone);
        myRef.setValue(userProfile);
    }

}