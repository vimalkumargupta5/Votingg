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

public class Center_info extends AppCompatActivity {
    private ImageView copy1, copy2, copy3, copy4;
    private TextView booth1, booth2, booth3, booth4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_center_info);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        copy1 = (ImageView) findViewById(R.id.copy1);
        copy2 = (ImageView) findViewById(R.id.copy2);
        copy3 = (ImageView) findViewById(R.id.copy3);
        copy4 = (ImageView) findViewById(R.id.copy4);
        booth1 = (TextView) findViewById(R.id.booth1);
        booth2 = (TextView) findViewById(R.id.booth2);
        booth3 = (TextView) findViewById(R.id.booth3);
        booth4 = (TextView) findViewById(R.id.booth4);
        copy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_one = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_one = ClipData.newPlainText("labelOne",booth1.getText().toString());
                clipboard_one.setPrimaryClip(clip_one);
                Toast.makeText(Center_info.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        copy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_two = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_two = ClipData.newPlainText("labelTwo",booth2.getText().toString());
                clipboard_two.setPrimaryClip(clip_two);
                Toast.makeText(Center_info.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        copy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_three = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_three = ClipData.newPlainText("labelThree",booth3.getText().toString());
                clipboard_three.setPrimaryClip(clip_three);
                Toast.makeText(Center_info.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
        copy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ClipboardManager clipboard_four = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                ClipData clip_four = ClipData.newPlainText("labelFour",booth4.getText().toString());
                clipboard_four.setPrimaryClip(clip_four);
                Toast.makeText(Center_info.this, "Copied to Clipboard!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
