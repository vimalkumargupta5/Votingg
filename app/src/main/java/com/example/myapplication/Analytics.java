package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Analytics extends AppCompatActivity {
    private Button AnalyticsLok,AnalyticsVidhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        AnalyticsLok = (Button) findViewById(R.id.buttonAnalyticsLok);
        AnalyticsVidhan = (Button) findViewById(R.id.buttonAnalyticsVidhan);
        AnalyticsLok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnalyticsOne();
            }
        });
        AnalyticsVidhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAnalyticsTwo();
            }
        });
    }

    private void openAnalyticsTwo() {
        Intent intent = new Intent(this,AnalyticsTwo.class);
        startActivity(intent);
    }

    private void openAnalyticsOne() {
        Intent intent = new Intent(this,AnalyticsOne.class);
        startActivity(intent);
    }
}
