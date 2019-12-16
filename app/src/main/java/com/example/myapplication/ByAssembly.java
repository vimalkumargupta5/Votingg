package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class ByAssembly extends AppCompatActivity {
    PDFView pdfby;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_assembly);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pdfby = (PDFView) findViewById(R.id.pdfby);
        pdfby.fromAsset("By-polls2019.pdf").load();
    }
}
