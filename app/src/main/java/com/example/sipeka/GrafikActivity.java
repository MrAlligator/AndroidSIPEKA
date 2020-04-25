package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class GrafikActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafik);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
