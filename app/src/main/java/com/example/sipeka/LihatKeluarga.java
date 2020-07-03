package com.example.sipeka;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.Model.Kk.PostPutDelKk;
import com.example.sipeka.Model.Response.ResponseRt;
import com.example.sipeka.Model.Response.ResultItem;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;
import com.example.sipeka.Rest.Spinner.BaseApiService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatKeluarga extends AppCompatActivity {
    private static final String TAG = TambahKeluargaActivity.class.getSimpleName();
    BaseApiService mApiService;
    ProgressDialog loading;
    Context mContext;
    Calendar calendar;
    Button btnUpdate, btnDelete;
    AutoCompleteTextView ACTVProv, ACTVKab, ACTVKec, ACTVKel, ACTVKodePos;
    Spinner SpKodeRT;
    String anggota,kodert;
    int kodeRt;
    EditText edtNoKk, edtNamaKk, edtAlamatKK, edtTanggal;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    LihatKeluarga ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = this;
        calendar = Calendar.getInstance();
        btnUpdate = findViewById(R.id.Edit);
        btnDelete = findViewById(R.id.Hapus);
        ACTVKab = findViewById(R.id.txtKab);
        ACTVKec = findViewById(R.id.txtKec);
        ACTVKel = findViewById(R.id.txtKel);
        ACTVKodePos = findViewById(R.id.txtKodePos);
        ACTVProv = findViewById(R.id.txtProv);
        SpKodeRT = findViewById(R.id.txtRTRW);
        edtAlamatKK = findViewById(R.id.txtAlamat);
        edtTanggal = findViewById(R.id.txtTanggal);
        edtNoKk = (EditText) findViewById(R.id.txtNKK);
        edtNamaKk = (EditText) findViewById(R.id.txtNama);

        mRecyclerView = (RecyclerView) findViewById(R.id.listAnggota);

        Intent mIntent = getIntent();

        edtNoKk.setText(mIntent.getStringExtra("No KK"));
        edtNoKk.setTag(edtNoKk.getKeyListener());
        edtNoKk.setKeyListener(null);

        anggota = mIntent.getStringExtra("No KK");

        edtNamaKk.setText(mIntent.getStringExtra("Nama KK"));
        edtAlamatKK.setText(mIntent.getStringExtra("Alamat"));
        edtTanggal.setText(mIntent.getStringExtra("Tanggal"));
        ACTVKab.setText(mIntent.getStringExtra("Kabupaten"));
        ACTVProv.setText(mIntent.getStringExtra("Provinsi"));
        ACTVKec.setText(mIntent.getStringExtra("Kecamatan"));
        ACTVKel.setText(mIntent.getStringExtra("Kelurahan"));
        ACTVKodePos.setText(mIntent.getStringExtra("Kode Pos"));

        try {
            kodeRt = Integer.parseInt(mIntent.getStringExtra("Kode RT"));
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        mRecyclerView = (RecyclerView) findViewById(R.id.listAnggota);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
//        refresh();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateLabel();
            }
        };
        edtTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(LihatKeluarga.this, date,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtNoKk.getText().toString().trim().isEmpty()==false){
                    Call<PostPutDelKk> deleteKk = mApiInterface.deleteKk(edtNoKk.getText().toString());
                    deleteKk.enqueue(new Callback<PostPutDelKk>() {
                        @Override
                        public void onResponse(Call<PostPutDelKk> call, Response<PostPutDelKk> response) {
                            KeluargaActivity.ma.refresh();
                            finish();
                        }

                        @Override
                        public void onFailure(Call<PostPutDelKk> call, Throwable t) {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApiInterface.putKk(
                        edtNoKk.getText().toString(),
                        edtNamaKk.getText().toString(),
                        edtAlamatKK.getText().toString(),
                        ACTVKel.getText().toString(),
                        ACTVKec.getText().toString(),
                        ACTVKab.getText().toString(),
                        ACTVKodePos.getText().toString(),
                        ACTVProv.getText().toString(),
                        edtTanggal.getText().toString(),
                        kodert
                );
            }
        });

    }

    private void refresh(){
//        Call<GetAnggota> AnggotaCall = mApiInterface.Anggota(anggota);
//        AnggotaCall.enqueue(new Callback<GetAnggota>() {
//            @Override
//            public void onResponse(Call<GetAnggota> call, Response<GetAnggota> response) {
//                List<Anggota> AnggotaList = response.body().getListDataAnggota();
//                Log.d("Retrofit Get", "Jumlah data Ktp: " +
//                        String.valueOf(AnggotaList.size()));
//                mAdapter = new AnggotaAdapter(AnggotaList);
//                mRecyclerView.setAdapter(mAdapter);
//            }
//            @Override
//            public void onFailure(Call<GetAnggota> call, Throwable t) {
//
//            }
//        });
    }

    private void updateLabel() {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        edtTanggal.setText(sdf.format(calendar.getTime()));
    }
    private void initSpinner() {
        mApiService.getSemuaRt().enqueue(new Callback<ResponseRt>() {

            @Override
            public void onResponse(Call<ResponseRt> call, Response<ResponseRt> response) {
                if (response.isSuccessful()) {
                    List<ResultItem> semuadosenRt = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < semuadosenRt.size(); i++)
                        listSpinner.add("RT : " + semuadosenRt.get(i).getRt() + " / RW : " + semuadosenRt.get(i).getRw()
                        );
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    SpKodeRT.setAdapter(adapter);
                    SpKodeRT.setSelection(kodeRt - 1);
                    SpKodeRT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            kodert = semuadosenRt.get(position).getKodeRt();
                            Log.e(TAG, "onItemSelected: " + kodeRt);
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                        }

                    });


                } else {
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseRt> call, Throwable t) {
                Toast.makeText(mContext, "BELUM BISA", Toast.LENGTH_SHORT).show();
            }
        });
    }
}