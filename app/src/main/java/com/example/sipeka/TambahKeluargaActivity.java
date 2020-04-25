package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.Calendar;

public class TambahKeluargaActivity extends AppCompatActivity {

    private Button btnPilih, btnCamera;
    private ImageView preview;
    private static final String TAG = TambahActivity.class.getSimpleName();
    private static int cameraCode = 1;
    private static int galeryCode = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCamera = findViewById(R.id.btnCamera);
        btnPilih = findViewById(R.id.btnPilih);
        preview = findViewById(R.id.preview);

        btnPilih.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentGalery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intentGalery, galeryCode);
            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent photoCaptureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(photoCaptureIntent, cameraCode);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(this.cameraCode == requestCode && resultCode == RESULT_OK){
            Bitmap bitmap = (Bitmap)data.getExtras().get("data");
            preview.setImageBitmap(bitmap);
        }
    }

}
