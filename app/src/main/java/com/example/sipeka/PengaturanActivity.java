package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;

public class PengaturanActivity extends AppCompatActivity {

    SwitchCompat switchCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            //setTheme(R.style.DarkTheme);
        //}
        //else
            //setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pengaturan);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        switchCompat = findViewById(R.id.switch_dark_mode);

        //if(AppCompatDelegate.getDefaultNightMode()==AppCompatDelegate.MODE_NIGHT_YES) {
            //switchCompat.setChecked(true);
        //}
        //switchCompat.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            //@Override
            //public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //if (isChecked) {
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    //restartApp();
                //}
                //else {
                    //AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    //restartApp();
                //}
            //}
        //});

    }

    //public void restartApp () {
        //Intent intent = new Intent(getApplicationContext(),PengaturanActivity.class);
        //startActivity(intent);
        //finish();
    //}
}
