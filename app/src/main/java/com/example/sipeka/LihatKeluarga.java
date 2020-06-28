package com.example.sipeka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

public class LihatKeluarga extends AppCompatActivity {
    EditText edtNoKk, edtNamaKk;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNoKk = (EditText) findViewById(R.id.edtNoKk);
        edtNamaKk = (EditText) findViewById(R.id.edtNamaKk);

        Intent mIntent = getIntent();

        edtNoKk.setText(mIntent.getStringExtra("No KK"));
        edtNoKk.setTag(edtNoKk.getKeyListener());
        edtNoKk.setKeyListener(null);

        edtNamaKk.setText(mIntent.getStringExtra("Nama KK"));

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
    }
}