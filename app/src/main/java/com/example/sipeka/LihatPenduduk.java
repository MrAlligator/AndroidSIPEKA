package com.example.sipeka;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatPenduduk extends AppCompatActivity {
    EditText temp1, temp2, temp3, temp4, temp5, temp6, edtNik, edtNama, edtNoKK, edtTanggal, edtAlamat, edtPekerjaan, edtBerlaku, edtGoldar, edtKode, edtRw, edtRt, edtStatus, edtKewarganegaraan;
    ApiInterface mApiInterface;
    AutoCompleteTextView  edtKelurahan, edtKecamatan, edtProv, edtKab;
    Button btDelete, btUpdate;
    Spinner edttmptLahir, edtJenkel, edtAgama;
    private static final String TAG = LihatPenduduk.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        temp1 = findViewById(R.id.temp1);
        temp2 = findViewById(R.id.temp2);
        temp3 = findViewById(R.id.temp3);
        temp4 = findViewById(R.id.temp4);
        temp5 = findViewById(R.id.temp5);
        temp6 = findViewById(R.id.temp6);
        edtNik = (EditText) findViewById(R.id.txtNIK);
        edtNama = (EditText) findViewById(R.id.txtNama);
        edtNoKK = (EditText) findViewById(R.id.txtNoKK);
        edtTanggal = findViewById(R.id.txtTanggal);
        edtAlamat = findViewById(R.id.txtAlamat);
        edtPekerjaan = findViewById(R.id.txtPekerjaan);
        edtBerlaku = findViewById(R.id.txtBerlaku);
        edtKelurahan = findViewById(R.id.txtKelurahan);
        edtKecamatan = findViewById(R.id.txtKecamatan);
        edtKab = findViewById(R.id.txtKab);
        edtProv = findViewById(R.id.txtProv);
        edtJenkel = findViewById(R.id.txtJenkel);
//        edtAgama = findViewById(R.id.txtAgama);
//        edtGoldar = findViewById(R.id.txtGoldar);
//        edtKode = findViewById(R.id.txtRT);
//        edtRt = findViewById(R.id.txtRT1);
//        edtRw = findViewById(R.id.txtRT2);
//        edtStatus = findViewById(R.id.txtStatus);
//        edtKewarganegaraan = findViewById(R.id.txtKewarganegaraan);
        edttmptLahir = (Spinner) findViewById(R.id.txtKota);
        Intent mIntent = getIntent();
        edtNik.setText(mIntent.getStringExtra("NIK"));
        edtNik.setTag(edtNik.getKeyListener());
        edtNik.setKeyListener(null);
        edtNoKK.setText(mIntent.getStringExtra("NIKK"));
        edtNama.setText(mIntent.getStringExtra("Nama"));
        //edttmptLahir.setText(mIntent.getStringExtra("Tempat Lahir"));
        edtTanggal.setText(mIntent.getStringExtra("Tanggal Lahir"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        edtKelurahan.setText(mIntent.getStringExtra("Kelurahan"));
        edtKecamatan.setText(mIntent.getStringExtra("Kecamatan"));
        edtPekerjaan.setText(mIntent.getStringExtra("Pekerjaan"));
        edtBerlaku.setText(mIntent.getStringExtra("Berlaku Hingga"));
        edtProv.setText(mIntent.getStringExtra("Prov"));
        edtKab.setText(mIntent.getStringExtra("Kab"));
        temp1.setText(mIntent.getStringExtra("Jenis Kelamin"));
//        edtJenkel.setSelection(1);
        if (temp1.getText().toString() == "Perempuan") {
            Log.e(TAG, "Jalan po gak" );
            edtJenkel.setSelection(1);
        } else {
            edtJenkel.setSelection(0);
        }
        temp2.setText(temp1.getText().toString());
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btDelete = (Button) findViewById(R.id.Hapus);
        btDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNik.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelKtp> deleteKtp = mApiInterface.deleteKtp(edtNik.getText().toString());
                    deleteKtp.enqueue(new Callback<PostPutDelKtp>() {
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
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
