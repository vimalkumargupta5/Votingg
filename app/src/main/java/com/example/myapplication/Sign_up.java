package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class Sign_up extends AppCompatActivity implements View.OnClickListener {
    private TextView signIn;
    private EditText userEmail,passwordOne,passwordTwo;
    private ProgressBar progressBar;
    private Button signup;
    private FirebaseAuth mAuth;
    private Intent HomeActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        userEmail = findViewById(R.id.userEmail);
        passwordOne = findViewById(R.id.regPass);
        passwordTwo = findViewById(R.id.regPassTwo);
        progressBar = findViewById(R.id.progressbar);
        signup = findViewById(R.id.signup);
        HomeActivity = new Intent(this,Sign_in.class);
        mAuth = FirebaseAuth.getInstance();
        signup.setOnClickListener(this);
        signIn = (TextView) findViewById(R.id.opensigninpage);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Sign_up.this, Sign_in.class);
                startActivity(myIntent);
            }
        });
    }

    private void registerUser() {
        String email = userEmail.getText().toString().trim();
        String passwordone = passwordOne.getText().toString().trim();
        String passwordtwo = passwordTwo.getText().toString().trim();
        if(email.isEmpty()){
            userEmail.setError("Email is required!");
            userEmail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userEmail.setError("Please enter a valid email!");
            userEmail.requestFocus();
            return;
        }

        if(passwordone.isEmpty()){
            passwordOne.setError("Password is required!");
            passwordOne.requestFocus();
            return;
        }
        if(passwordone.length()<6){
            passwordOne.setError("Minimium lenght should be 6 letters!");
            passwordOne.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);
        signup.setVisibility(View.INVISIBLE);
        mAuth.createUserWithEmailAndPassword(email,passwordone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.INVISIBLE);
                signup.setVisibility(View.VISIBLE);
                if(task.isSuccessful()){
                    finish();
                    startActivity(new Intent(Sign_up.this,Profile_page.class));
                }
                else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(getApplicationContext(), "This email already registered!", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.signup:
                registerUser();
                break;
        }
    }
}
