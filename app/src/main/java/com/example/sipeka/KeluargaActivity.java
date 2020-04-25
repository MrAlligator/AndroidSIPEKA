package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class KeluargaActivity extends AppCompatActivity {

    private Button tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tambah = findViewById(R.id.btnTambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KeluargaActivity.this, TambahKeluargaActivity.class));
            }
        });

    }
}
