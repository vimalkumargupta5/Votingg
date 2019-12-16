package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Voter_verification extends AppCompatActivity {
    private ProgressBar progressBar;
    EditText phoneNumber, verifyCode;
    FirebaseAuth mAuth;
    String codeSent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voter_verification);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mAuth = FirebaseAuth.getInstance();
        phoneNumber = findViewById(R.id.pnone_number);
        verifyCode = findViewById(R.id.enter_pin);
        progressBar = findViewById(R.id.progressbar);
        findViewById(R.id.send_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendVerificationCode();

            }

        });
        findViewById(R.id.verfy_otp).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                verifyOtp();

            }
        });
        progressBar.setVisibility(View.INVISIBLE);
    }
    private void verifyOtp(){
        String code = verifyCode.getText().toString();
        if(code.isEmpty()){
            verifyCode.setError("OTP is Required!");
            verifyCode.requestFocus();
            return;
        }
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(codeSent, code);
        signInWithPhoneAuthCredential(credential);
    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        progressBar.setVisibility(View.VISIBLE);
        findViewById(R.id.verfy_otp).setVisibility(View.INVISIBLE);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.INVISIBLE);
                        findViewById(R.id.verfy_otp).setVisibility(View.VISIBLE);
                        if (task.isSuccessful()) {
                            startActivity(new Intent(Voter_verification.this,RegistrationPage.class));


                        } else {
                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                                // The verification code entered was invalid
                                Toast.makeText(getApplicationContext(), "Incorrect OTP Please check!!", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                });
    }

    private void sendVerificationCode() {

        String phone = phoneNumber.getText().toString();
        if(phone.isEmpty()){
            phoneNumber.setError("Phone Number is Required!");
            phoneNumber.requestFocus();
            return;
        }
        if(phone.length() <10){
            phoneNumber.setError("Enter Valid Phone Number!");
            phoneNumber.requestFocus();
            return;

        }
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                phone,        // Phone number to verify
                60,                 // Timeout duration
                TimeUnit.SECONDS,   // Unit of timeout
                this,               // Activity (for callback binding)
                mCallbacks);        // OnVerificationStateChangedCallbacks
        Toast.makeText(getApplicationContext(), "OTP Sent Successfully!", Toast.LENGTH_SHORT).show();

    }

    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {

        }

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            codeSent = s;
        }
    };
}
