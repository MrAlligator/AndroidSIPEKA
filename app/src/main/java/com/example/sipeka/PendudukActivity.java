package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PendudukActivity extends AppCompatActivity {

    private Button buat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buat = findViewById(R.id.btnTambah);

        buat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PendudukActivity.this, TambahActivity.class));
            }
        });

    }
}
