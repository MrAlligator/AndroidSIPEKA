package com.example.sipeka;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatPenduduk extends AppCompatActivity {
    EditText edtNik, edtNama, edtNoKK, edtTanggal, edtAlamat, edtPekerjaan, edtBerlaku, edtJenkel, edtGoldar, edtKode, edtRw, edtRt, edtAgama, edtStatus, edtKewarganegaraan;
    ApiInterface mApiInterface;
    AutoCompleteTextView edttmptLahir, edtKelurahan, edtKecamatan;
    Button btDelete, btUpdate;


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
        edtAgama = findViewById(R.id.txtAgama);
        edtGoldar = findViewById(R.id.txtGoldar);
        edtKode = findViewById(R.id.txtRT);
        edtRt = findViewById(R.id.txtRT1);
        edtRw = findViewById(R.id.txtRT2);
        edtStatus = findViewById(R.id.txtStatus);
        edtKewarganegaraan = findViewById(R.id.txtKewarganegaraan);
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
        edtJenkel.setText(mIntent.getStringExtra("Jenis Kelamin"));
        edtAgama.setText(mIntent.getStringExtra("Agama"));
        edtGoldar.setText(mIntent.getStringExtra("Gol Darah"));
        edtKode.setText(mIntent.getStringExtra("KodeRT"));
        edtStatus.setText(mIntent.getStringExtra("Status Perkawinan"));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        btUpdate = (Button) findViewById(R.id.Edit);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LihatPenduduk.this, EditPendActivity.class));
            }
        });
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
