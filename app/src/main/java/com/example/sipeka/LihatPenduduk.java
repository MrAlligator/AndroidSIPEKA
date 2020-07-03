package com.example.sipeka;

import android.app.DatePickerDialog;
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

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Response.ResponseRt;
import com.example.sipeka.Model.Response.ResultItem;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;
import com.example.sipeka.Rest.Spinner.BaseApiService;
import com.example.sipeka.Rest.Spinner.UtilsApi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LihatPenduduk extends AppCompatActivity {
    Calendar calendar;
    Context mContext;
    EditText edttmptLahir, temp1, temp2, temp3, temp4, temp5, temp6, edtNik, edtNama, edtNoKK, edtTanggal, edtAlamat, edtPekerjaan, edtBerlaku;
    ApiInterface mApiInterface;
    AutoCompleteTextView  edtKelurahan, edtKecamatan, edtProv, edtKab;
    Button btDelete, btUpdate;
    Spinner edtJenkel, edtAgama, edtKodeRt, edtGoldar, edtStatus, edtKewarganegaraan;
    String  kodert;
    Integer kodeRt;
    BaseApiService mApiService;
    LihatPenduduk lp;
    private static final String TAG = LihatPenduduk.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        calendar = Calendar.getInstance();
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
        edtAgama = findViewById(R.id.txtAgama);
        edtKodeRt = (Spinner) findViewById(R.id.txtRT);
        edtGoldar = findViewById(R.id.txtGoldar);
        edtStatus = findViewById(R.id.txtStatus);
        edtKewarganegaraan = findViewById(R.id.txtKewarganegaraan);
        edttmptLahir = findViewById(R.id.txtKota);
        Intent mIntent = getIntent();

        mContext = this;
        mApiService = UtilsApi.getAPIService();
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        try {
            kodeRt = Integer.parseInt(mIntent.getStringExtra("Kode RT"));
        } catch(NumberFormatException nfe) {
            System.out.println("Could not parse " + nfe);
        }

        edtNik.setText(mIntent.getStringExtra("NIK"));
        edtNik.setTag(edtNik.getKeyListener());
        edtNik.setKeyListener(null);
        edtNoKK.setText(mIntent.getStringExtra("NIKK"));
        edtNama.setText(mIntent.getStringExtra("Nama"));
        edttmptLahir.setText(mIntent.getStringExtra("Tempat Lahir"));
        edtTanggal.setText(mIntent.getStringExtra("Tanggal Lahir"));
        edtAlamat.setText(mIntent.getStringExtra("Alamat"));
        edtKelurahan.setText(mIntent.getStringExtra("Kelurahan"));
        edtKecamatan.setText(mIntent.getStringExtra("Kecamatan"));
        edtPekerjaan.setText(mIntent.getStringExtra("Pekerjaan"));
        edtBerlaku.setText(mIntent.getStringExtra("Berlaku Hingga"));
        edtProv.setText(mIntent.getStringExtra("Prov"));
        edtKab.setText(mIntent.getStringExtra("Kab"));
        temp1.setText(mIntent.getStringExtra("Jenis Kelamin"));

        btUpdate = (Button) findViewById(R.id.Edit);
        btUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mApiInterface.putKtp(
                        edtProv.getText().toString(),
                        edtKab.getText().toString(),
                        edtNik.getText().toString(),
                        edtNama.getText().toString(),
                        edtNoKK.getText().toString(),
                        edttmptLahir.getText().toString(),
                        edtTanggal.getText().toString(),
                        edtJenkel.getSelectedItem().toString(),
                        edtGoldar.getSelectedItem().toString(),
                        edtAlamat.getText().toString(),
                        kodert,
                        edtKelurahan.getText().toString(),
                        edtKecamatan.getText().toString(),
                        edtAgama.getSelectedItem().toString(),
                        edtStatus.getSelectedItem().toString(),
                        edtPekerjaan.getText().toString(),
                        edtKewarganegaraan.getSelectedItem().toString(),
                        edtBerlaku.getText().toString()).enqueue(new Callback<PostPutDelKtp>() {
                    @Override
                    public void onResponse(Call<PostPutDelKtp> call, Response<PostPutDelKtp> response) {
                        PendudukActivity.ma.refresh();
                        finish();
                        Log.e(TAG, "onResponse: "+response );
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKtp> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });



        initSpinner();

        if (temp1.getText().toString().equals("Laki - Laki")) {
            Log.e(TAG, "Jalan po gak" );
            edtJenkel.setSelection(0);
        } else {
            Log.e(TAG, "Jo gak Su" );
            edtJenkel.setSelection(1);
        }

        temp2.setText(mIntent.getStringExtra("Agama"));
        if (temp2.getText().toString().equals("Islam")) {
            edtAgama.setSelection(0);
        } else if (temp2.getText().toString().equals("Kristen")) {
            edtAgama.setSelection(1);
        } else if (temp2.getText().toString().equals("Katolik")) {
            edtAgama.setSelection(2);
        } else if (temp2.getText().toString().equals("Hindu")) {
            edtAgama.setSelection(3);
        } else if (temp2.getText().toString().equals("Budha")) {
            edtAgama.setSelection(4);
        } else if (temp2.getText().toString().equals("Konghucu")) {
            edtAgama.setSelection(5);
        } else {}

        temp3.setText(mIntent.getStringExtra("Gol Darah"));
        if (temp3.getText().toString().equals("A")) {
            edtGoldar.setSelection(0);
        } else if (temp3.getText().toString().equals("B")) {
            edtGoldar.setSelection(1);
        } else if (temp3.getText().toString().equals("AB")) {
            edtGoldar.setSelection(2);
        } else if (temp3.getText().toString().equals("O")) {
            edtGoldar.setSelection(3);
        } else {}

        temp4.setText(mIntent.getStringExtra("Status Perkawinan"));
        if (temp4.getText().toString().equals("Kawin")) {
            edtStatus.setSelection(0);
        } else if (temp4.getText().toString().equals("Belum Kawin")) {
            edtStatus.setSelection(1);
        } else {}

        temp5.setText(mIntent.getStringExtra("Kewarganegaraan"));
        if (temp5.getText().toString().equals("WNI")) {
            edtKewarganegaraan.setSelection(0);
        } else if (temp5.getText().toString().equals("WNA")) {
            edtKewarganegaraan.setSelection(1);
        } else {}

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
                new DatePickerDialog(LihatPenduduk.this, date,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

    }

    private void updateLabel() {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        edtTanggal.setText(sdf.format(calendar.getTime()));
    }
    private void initSpinner(){
        mApiService.getSemuaRt().enqueue(new Callback<ResponseRt>() {

            @Override
            public void onResponse(Call<ResponseRt> call, Response<ResponseRt> response) {
                if (response.isSuccessful()) {
                    List<ResultItem> semuadosenRt = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < semuadosenRt.size(); i++)
                        listSpinner.add("RT : "+semuadosenRt.get(i).getRt()+" / RW : "+semuadosenRt.get(i).getRw()
                        );
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    edtKodeRt.setAdapter(adapter);
                    edtKodeRt.setSelection(kodeRt-1);
                    edtKodeRt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            kodert = semuadosenRt.get(position).getKodeRt();
                            Log.e(TAG, "onItemSelected: "+kodeRt );
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
