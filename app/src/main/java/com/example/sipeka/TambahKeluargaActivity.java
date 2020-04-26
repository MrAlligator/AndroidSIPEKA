package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
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
    private static final int cameraCode = 1;
    private static final int galleryCode = 100;

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
                Intent intentGalery = new Intent(Intent.ACTION_PICK);
                intentGalery.setType("image/*");
                String[] mimeTypes = {"image/jpeg", "image/png"};
                intentGalery.putExtra(Intent.EXTRA_MIME_TYPES, mimeTypes);
                startActivityForResult(intentGalery, galleryCode);
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
        if(resultCode == Activity.RESULT_OK){
            switch (requestCode) {
                case galleryCode:
                    Uri imageUri = data.getData();
                    preview.setImageURI(imageUri);
                    break;
                case cameraCode:
                    Bitmap bitmap = (Bitmap) data.getExtras().get("data");
                    preview.setImageBitmap(bitmap);
                    break;
            }
        }
    }

}
