package com.example.sipeka;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class UbahPasswordActivity extends AppCompatActivity {

    EditText edtpassword, edtpasswordbaru;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah_password);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtpassword = (EditText) findViewById(R.id.edtpassword);
        edtpasswordbaru = (EditText) findViewById(R.id.edtpasswordbaru);
    }
}
