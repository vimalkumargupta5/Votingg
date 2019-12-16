package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {
    private EditText name, email, contact, message;
    private Button send;
    DatabaseReference databaseReference;
    private ProgressBar progressBar;
    RatingBar ratingBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        name = findViewById(R.id.sendername);
        email = findViewById(R.id.sendermail);
        contact = findViewById(R.id.sendercontact);
        message = findViewById(R.id.sendermessage);
        send = findViewById(R.id.sendtous);
        progressBar = findViewById(R.id.progressbar);
        ratingBar = findViewById(R.id.ratingBar);
        ratingBar.setNumStars(5);
        databaseReference = FirebaseDatabase.getInstance().getReference("Feedback");
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(Feedback.this, "Stars:" +(int)v, Toast.LENGTH_SHORT).show();
            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFeedback();
            }
        });
        progressBar.setVisibility(View.INVISIBLE);

    }

    private void addFeedback() {
        String Name = name.getText().toString().trim();
        String Email = email.getText().toString().trim();
        String Contact = contact.getText().toString().trim();
        String Message = message.getText().toString().trim();
        progressBar.setVisibility(View.VISIBLE);
        FeedbackAdapter feedbackAdapter = new FeedbackAdapter(Name,Email,Contact,Message);
        databaseReference.push().setValue(feedbackAdapter);
        progressBar.setVisibility(View.INVISIBLE);
        Toast.makeText(getApplicationContext(), "Thanks for your feedback!", Toast.LENGTH_SHORT).show();

    }
}