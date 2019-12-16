package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AnalyticsTwo extends AppCompatActivity {
    private Button haryana, maharashtra, byelection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_two);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        haryana = findViewById(R.id.har);
        maharashtra = findViewById(R.id.mah);
        byelection = findViewById(R.id.by);
        haryana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openHaryana();

            }
        });
        maharashtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMaharashtra();

            }
        });
        byelection.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBy();

            }
        });
    }

    private void openBy() {
        Intent intent = new Intent(this,ByAssembly.class);
        startActivity(intent);
    }

    private void openMaharashtra() {
        Intent intent = new Intent(this,MahAssembly.class);
        startActivity(intent);

    }

    private void openHaryana() {
        Intent intent = new Intent(this,HarAssembly.class);
        startActivity(intent);

    }
}
