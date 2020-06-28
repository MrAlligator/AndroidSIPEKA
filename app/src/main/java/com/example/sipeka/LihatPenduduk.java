package com.example.sipeka;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

public class LihatPenduduk extends AppCompatActivity {
    EditText edtNik, edtNama, edtNoKK, edtTanggal, edtAlamat, edtPekerjaan, edtBerlaku;
    ApiInterface mApiInterface;
    AutoCompleteTextView edttmptLahir, edtKelurahan, edtKecamatan;
    Spinner edtJenkel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNik = (EditText) findViewById(R.id.txtNIK);
        edtNama = (EditText) findViewById(R.id.txtNama);
        edtNoKK = (EditText) findViewById(R.id.txtNoKK);
        edtTanggal = findViewById(R.id.txtTanggal);
        edtAlamat = findViewById(R.id.txtAlamat);
        edtPekerjaan = findViewById(R.id.txtPekerjaan);
        edtBerlaku = findViewById(R.id.txtBerlaku);
        edtKelurahan = findViewById(R.id.txtKelurahan);
        edtKecamatan = findViewById(R.id.txtKecamatan);
        edtJenkel = findViewById(R.id.txtJenkel);
        edttmptLahir = (AutoCompleteTextView) findViewById(R.id.txtTmptLahir);
        Intent mIntent = getIntent();
        edtNik.setText(mIntent.getStringExtra("NIK"));
        edtNik.setTag(edtNik.getKeyListener());
        edtNik.setKeyListener(null);
        edtNoKK.setText(mIntent.getStringExtra("No KK"));
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edttmptLahir.setText(mIntent.getStringExtra("Tempat Lahir"));
        edtTanggal.setText(mIntent.getStringExtra("Tanggal Lahir"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        edtKelurahan.setText(mIntent.getStringExtra("Kelurahan"));
        edtKecamatan.setText(mIntent.getStringExtra("Kecamatan"));
        edtPekerjaan.setText(mIntent.getStringExtra("Pekerjaan"));
        edtBerlaku.setText(mIntent.getStringExtra("Berlaku Hingga"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
//        btUpdate = (Button) findViewById(R.id.btUpdate2);
//        btUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Call<PostPutDelKtp> updateKtpCall = mApiInterface.putKtp(
//                        edtNik.getText().toString(),
//                        edtNama.getText().toString(),
//                        edtrw.getText().toString());
//                ((Call) updateKtpCall).enqueue(new Callback<PostPutDelKtp>() {
//                    @Override
//                    public void onResponse(Call<PostPutDelKtp> call, Response<PostPutDelKtp> response) {
//                        MainActivity.ma.refresh();
//                        finish();
//                    }
//
//                    @Override
//                    public void onFailure(Call<PostPutDelKtp> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });
//        btDelete = (Button) findViewById(R.id.btDelete2);
//        btDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (edtNik.getText().toString().trim().isEmpty()==false){
//                    Call<PostPutDelKtp> deleteKtp = mApiInterface.deleteKtp(edtNik.getText().toString());
//                    deleteKtp.enqueue(new Callback<PostPutDelKtp>() {
//                        @Override
//                        public void onResponse(Call<PostPutDelKtp> call, Response<PostPutDelKtp> response) {
//                            MainActivity.ma.refresh();
//                            finish();
//                        }
//
//                        @Override
//                        public void onFailure(Call<PostPutDelKtp> call, Throwable t) {
//                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                        }
//                    });
//                }else{
//                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
//                }
//            }
//        });
//        btBack = (Button) findViewById(R.id.btBackGo);
//        btBack.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MainActivity.ma.refresh();
//                finish();
//            }
//        });
//    }
    }
}
