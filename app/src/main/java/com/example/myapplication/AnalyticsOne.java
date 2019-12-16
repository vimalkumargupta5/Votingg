package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class AnalyticsOne extends AppCompatActivity {
    PDFView pdflok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analytics_one);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pdflok = (PDFView) findViewById(R.id.pdflok);
        pdflok.fromAsset("loksabha2019.pdf").load();
    }
}
