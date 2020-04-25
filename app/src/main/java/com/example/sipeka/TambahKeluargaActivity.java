package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class TambahKeluargaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keluarga);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
}
