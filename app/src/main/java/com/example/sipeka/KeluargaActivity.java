package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class KeluargaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
