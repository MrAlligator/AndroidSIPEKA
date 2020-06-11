package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatPenduduk extends AppCompatActivity {
    EditText edtNik, edtNama, edttmptLahir;
    ApiInterface mApiInterface;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edtNik = (EditText) findViewById(R.id.txtNIK);
        edtNama = (EditText) findViewById(R.id.txtNama);
        edttmptLahir = (EditText) findViewById(R.id.txtTmptLahir);
        Intent mIntent = getIntent();
        edtNik.setText(mIntent.getStringExtra("NIK"));
        edtNik.setTag(edtNik.getKeyListener());
        edtNik.setKeyListener(null);
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edttmptLahir.setText(mIntent.getStringExtra("Tempat Lahir"));
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
