package com.example.sipeka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TambahActivity extends AppCompatActivity {

    private Button btnPilih, btnCamera;
    private ImageView preview;
    private static final String TAG = TambahActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;
    private static final int cameraCode = 1;
    private static final int galleryCode = 100;
    private Calendar calendar;
    private EditText txtTanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendar = Calendar.getInstance();
        txtTanggal = findViewById(R.id.txtTanggal);
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
        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        txtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(TambahActivity.this, date,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
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
                    Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 1366, 768, true);
                    preview.setImageBitmap(bitmapScaled);
                    break;
            }
        }
    }

    private void updateLabel() {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtTanggal.setText(sdf.format(calendar.getTime()));
    }

}
