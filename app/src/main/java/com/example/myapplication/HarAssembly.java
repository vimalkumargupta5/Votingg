package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class HarAssembly extends AppCompatActivity {
    PDFView pdfhar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_har_assembly);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pdfhar = (PDFView) findViewById(R.id.pdfhar);
        pdfhar.fromAsset("haryana.pdf").load();
    }
}
