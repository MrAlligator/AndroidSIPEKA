package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView menu1, menu2, menu3, menu4, menu5, menu6, logout;
    TextView penduduk, keluarga, domisili, grafik, pengaturan, about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu1 = findViewById(R.id.menu1);
        menu2 = findViewById(R.id.menu2);
        menu3 = findViewById(R.id.menu3);
        menu4 = findViewById(R.id.menu4);
        menu5 = findViewById(R.id.menu5);
        menu6 = findViewById(R.id.menu6);
        logout = findViewById(R.id.logout);
        penduduk = findViewById(R.id.penduduk);
        keluarga = findViewById(R.id.keluarga);
        domisili = findViewById(R.id.domisili);
        grafik = findViewById(R.id.grafik);
        pengaturan = findViewById(R.id.pengaturan);
        about = findViewById(R.id.about);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences=getSharedPreferences("remember",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();

                finish();
            }
        });
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PendudukActivity.class));
            }
        });
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeluargaActivity.class));
            }
        });
        //menu3.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DomisiliActivity.class));
            //}
        //});
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GrafikActivity.class));
            }
        });
        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PengaturanActivity.class));
            }
        });
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
        penduduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PendudukActivity.class));
            }
        });
        keluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeluargaActivity.class));
            }
        });
        //domisili.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View v) {
                //startActivity(new Intent(MainActivity.this, DomisiliActivity.class));
            //}
        //});
        grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GrafikActivity.class));
            }
        });
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PengaturanActivity.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });

    }
}
