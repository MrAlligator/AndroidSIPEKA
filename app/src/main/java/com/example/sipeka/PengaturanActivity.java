package com.example.sipeka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class PengaturanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        setTheme(R.style.DarkTheme);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
