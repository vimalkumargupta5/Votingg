package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    private ImageView c1, c2, c3, c4, c5, ce, cf;
    private TextView p1, p2, p3, p4, p5, e1, f1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        c1 = (ImageView) findViewById(R.id.c1);
        c2 = (ImageView) findViewById(R.id.c2);
        c3 = (ImageView) findViewById(R.id.c3);
        c4 = (ImageView) findViewById(R.id.c4);
        c5 = (ImageView) findViewById(R.id.c5);
        ce = (ImageView) findViewById(R.id.ce);
        cf = (ImageView) findViewById(R.id.cf);
        p1 = (TextView) findViewById(R.id.p1);
        p2 = (TextView) findViewById(R.id.p2);
        p3 = (TextView) findViewById(R.id.p3);
        p4 = (TextView) findViewById(R.id.p4);
        p5 = (TextView) findViewById(R.id.p5);
        e1 = (TextView) findViewById(R.id.e1);
        f1 = (TextView) findViewById(R.id.f1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_one = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_one = ClipData.newPlainText("labelOne",p1.getText().toString());
                clipboard_one.setPrimaryClip(clip_one);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_two = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_two = ClipData.newPlainText("labelTwo",p2.getText().toString());
                clipboard_two.setPrimaryClip(clip_two);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_three = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_three = ClipData.newPlainText("labelThree",p3.getText().toString());
                clipboard_three.setPrimaryClip(clip_three);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_four = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_four = ClipData.newPlainText("labelFour",p4.getText().toString());
                clipboard_four.setPrimaryClip(clip_four);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        c5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_five = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_five = ClipData.newPlainText("labelFive",p5.getText().toString());
                clipboard_five.setPrimaryClip(clip_five);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_six = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_six = ClipData.newPlainText("labelSix",e1.getText().toString());
                clipboard_six.setPrimaryClip(clip_six);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        cf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_seven = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_seven = ClipData.newPlainText("labelSeven",f1.getText().toString());
                clipboard_seven.setPrimaryClip(clip_seven);
                Toast.makeText(Contact.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
