package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Sign_in extends AppCompatActivity implements View.OnClickListener {
    private EditText userMail, userPassword;
    private ProgressBar progressBar;
    private TextView signUp, forget_pass;
    private Button signin;
    private FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();
        userMail = findViewById(R.id.login_mail);
        userPassword = findViewById(R.id.login_password);
        forget_pass = findViewById(R.id.forget_pass);
        signin = findViewById(R.id.buttonLogin);
        signin.setOnClickListener(this);
        signUp = (TextView) findViewById(R.id.opensignuppage);
        progressBar = findViewById(R.id.progressbar);
        forget_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showRecoverPasswordDialog();
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(Sign_in.this, Sign_up.class);
                startActivity(myIntent);
            }
        });

        progressBar.setVisibility(View.INVISIBLE);

    }

    private void showRecoverPasswordDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Recover your Password");

        LinearLayout linearLayout = new LinearLayout(this);
        final EditText emailEt = new EditText(this);

        emailEt.setHint("Please enter your registered Email");
        emailEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);
        emailEt.setMinEms(16);
        linearLayout.addView(emailEt);
        linearLayout.setPadding(10,10,10,10);
        builder.setView(linearLayout);
        //button recover
        builder.setPositiveButton("Recover", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String email = emailEt.getText().toString().trim();
                beginRecovery(email);

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();

            }
        });
        builder.create().show();

    }

    private void beginRecovery(String email) {
        progressBar.setVisibility(View.VISIBLE);
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                progressBar.setVisibility(View.INVISIBLE);
                if(task.isSuccessful()){
                    Toast.makeText(Sign_in.this, "Email Sent check mail box..", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Sign_in.this, "Failed....", Toast.LENGTH_SHORT).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressBar.setVisibility(View.INVISIBLE);
                Toast.makeText(Sign_in.this, ""+e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLogin:
                userLogin();
                break;


        }
    }


    private void userLogin() {
        String email = userMail.getText().toString().trim();
        String passwordone = userPassword.getText().toString().trim();
        if(email.isEmpty()){
            userMail.setError("Email is required!");
            userMail.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            userMail.setError("Please enter a valid email!");
            userMail.requestFocus();
            return;
        }

        if(passwordone.isEmpty()){
            userPassword.setError("Password is required!");
            userPassword.requestFocus();
            return;
        }
        if(passwordone.length()<6){
            userPassword.setError("Minimium lenght should be 6 letters!");
            userPassword.requestFocus();
            return;

        }
        progressBar.setVisibility(View.VISIBLE);
        signin.setVisibility(View.INVISIBLE);
        mAuth.signInWithEmailAndPassword(email,passwordone).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.INVISIBLE);
                signin.setVisibility(View.VISIBLE);
                if(task.isSuccessful()){
                    finish();
                    Intent intent = new Intent(Sign_in.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);

                }
                else{
                    Toast.makeText(getApplicationContext(),task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mAuth.getCurrentUser() != null){
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}
