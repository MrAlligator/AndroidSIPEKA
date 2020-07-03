package com.example.sipeka;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.SharedPref.SharedPrefManager;

public class AboutActivity extends AppCompatActivity {
SharedPrefManager sharedPrefManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sharedPrefManager = new SharedPrefManager(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
    }
}
