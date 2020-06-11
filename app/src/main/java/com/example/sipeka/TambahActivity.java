package com.example.sipeka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Rt.GetRt;
import com.example.sipeka.Model.Rt.Rt;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {

    Context mContext;
    private Button btnPilih, btnCamera, btnSimpan;
    private ImageView preview;
    private static final String TAG = TambahActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;
    private static final int cameraCode = 1;
    private static final int galleryCode = 100;
    private Calendar calendar;
    private EditText txtTanggal, txtNama, txtNIK, txtNoKK, txtAlamat, txtRT, txtRW, txtPekerjaan, txtBerlaku;
    private Spinner SpKota, SpJenKel, SpGoldar, SpKodeRT, SpKelurahan, SpKecamatan, SpAgama, SpStatus, SpKewarganegaraan;
    ApiInterface mApiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = this;
        calendar = Calendar.getInstance();
        txtTanggal = findViewById(R.id.txtTanggal);
        btnCamera = findViewById(R.id.btnCamera);
        btnPilih = findViewById(R.id.btnPilih);
        btnSimpan = findViewById(R.id.button1);
        preview = findViewById(R.id.preview);
        txtNama = findViewById(R.id.txtNama);
        txtNIK = findViewById(R.id.txtNIK);
        txtNoKK = findViewById(R.id.txtNoKK);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtRT = findViewById(R.id.txtRT1);
        txtRW = findViewById(R.id.txtRT2);
        txtPekerjaan = findViewById(R.id.txtPekerjaan);
        txtBerlaku = findViewById(R.id.txtBerlaku);
        SpKota = findViewById(R.id.txtKota);
        SpJenKel = findViewById(R.id.txtJenkel);
        SpGoldar = findViewById(R.id.txtGoldar);
        SpKodeRT = findViewById(R.id.txtRT);
        SpKelurahan = findViewById(R.id.txtKelurahan);
        SpKecamatan = findViewById(R.id.txtKecamatan);
        SpAgama = findViewById(R.id.txtAgama);
        SpStatus = findViewById(R.id.txtStatus);
        SpKewarganegaraan = findViewById(R.id.txtKewarganegaraan);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKtp> postKontakCall = mApiInterface.postKtp(txtNIK.getText().toString(), txtNoKK.getText().toString(), txtNama.getText().toString(), SpKota.getSelectedItem().toString(), txtTanggal.getText().toString(), SpJenKel.getSelectedItem().toString(), SpGoldar.getSelectedItem().toString(), txtAlamat.getText().toString(), SpKodeRT.getSelectedItem().toString(), SpKelurahan.getSelectedItem().toString(), SpKecamatan.getSelectedItem().toString(), SpAgama.getSelectedItem().toString(), SpStatus.getSelectedItem().toString(), txtPekerjaan.getText().toString(), SpKewarganegaraan.getSelectedItem().toString(), txtBerlaku.getText().toString());
                postKontakCall.enqueue(new Callback<PostPutDelKtp>() {
                    @Override
                    public void onResponse(Call<PostPutDelKtp> call, Response<PostPutDelKtp> response) {
                        PendudukActivity.ma.refresh();
                        finish();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKtp> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

        SpKodeRT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedName = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

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

    private void initSpKodeRT(){
        mApiInterface.getRt().enqueue(new Callback<GetRt>() {
            @Override
            public void onResponse(Call<GetRt> call, Response<GetRt> response) {
                if(response.isSuccessful()) {
                    List<Rt> Rt = response.body().getListDataRt();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < Rt.size(); i++){
                        listSpinner.add(Rt.get(i).getKodeRt());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_dropdown_item);
                    SpKodeRT.setAdapter(adapter);
                } else {
                    Toast.makeText(mContext, "Gagal mengambil kode RT", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<GetRt> call, Throwable t) {
                Toast.makeText(mContext, "Koneksi Dengan Database Bermasalah", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
