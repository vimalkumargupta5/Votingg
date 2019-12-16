package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Result extends AppCompatActivity {
    private Button ResultLok,ResultVidhan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ResultLok = (Button) findViewById(R.id.buttonResultLok);
        ResultVidhan = (Button) findViewById(R.id.buttonResultVidhan);
        ResultLok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResultOneLok();
            }
        });
        ResultVidhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openResultTwoVidhan();
            }
        });
    }

    private void openResultTwoVidhan() {
        Intent intent = new Intent(this,ResultTwoVidhan.class);
        startActivity(intent);
    }

    private void openResultOneLok() {
        Intent intent = new Intent(this,ResultOneLok.class);
        startActivity(intent);

    }
}
