package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Complaint extends AppCompatActivity {
    private EditText email,subject,message;
    private Button Send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complaint);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        email=findViewById(R.id.email1);
        subject=findViewById(R.id.subject1);
        message=findViewById(R.id.message1);
        Send = (Button) findViewById(R.id.btn_send1);
        Send.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String[] mail = Email.split(",");
                String Subject=subject.getText().toString();
                String Message=message.getText().toString();
                Intent Send = new Intent(Intent.ACTION_SEND);
                Send.putExtra(Intent.EXTRA_EMAIL,mail);
                Send.putExtra(Intent.EXTRA_SUBJECT,Subject);
                Send.putExtra(Intent.EXTRA_TEXT,Message);
                Send.setType("message/rfc822");
                startActivity(Send);
            }
        });
    }
}
