package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class MahAssembly extends AppCompatActivity {
    PDFView pdfmah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mah_assembly);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        pdfmah = (PDFView) findViewById(R.id.pdfmah);
        pdfmah.fromAsset("maharastra.pdf").load();
    }
}
