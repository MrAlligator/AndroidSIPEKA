package com.example.sipeka;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
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

public class TambahKeluargaActivity extends AppCompatActivity {

    private static final String TAG = TambahKeluargaActivity.class.getSimpleName();
    BaseApiService mApiService;
    ApiInterface mApiInterface;
    ProgressDialog loading;
    Context mContext;
    Calendar calendar;
    Button btnSimpan;
    AutoCompleteTextView ACTVProv, ACTVKab, ACTVKec, ACTVKel, ACTVKodePos;
    Spinner SpKodeRT;
    EditText edtNama, edtAlamat, edtTanggal, edtNoKK;
    String kodert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mContext = this;
        calendar = Calendar.getInstance();
        btnSimpan = findViewById(R.id.button1);
        ACTVKab = findViewById(R.id.txtKab);
        ACTVKec = findViewById(R.id.txtKec);
        ACTVKel = findViewById(R.id.txtKel);
        ACTVKodePos = findViewById(R.id.txtKodePos);
        ACTVProv = findViewById(R.id.txtProv);
        SpKodeRT = findViewById(R.id.txtRTRW);
        edtAlamat = findViewById(R.id.txtAlamat);
        edtNama = findViewById(R.id.txtNama);
        edtNoKK = findViewById(R.id.txtNKK);
        edtTanggal = findViewById(R.id.txtTanggal);
        initSpinnerRT();

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<PostPutDelKk> postKontakCall = mApiInterface.postKk(
                        edtNoKK.getText().toString(),
                        edtNama.getText().toString(),
                        edtAlamat.getText().toString(),
                        ACTVKel.getText().toString(),
                        ACTVKec.getText().toString(),
                        ACTVKab.getText().toString(),
                        ACTVKodePos.getText().toString(),
                        ACTVProv.getText().toString(),
                        edtTanggal.getText().toString(),
                        kodert
                        );
                postKontakCall.enqueue(new Callback<PostPutDelKk>() {
                    @Override
                    public void onResponse(Call<PostPutDelKk> call, Response<PostPutDelKk> response) {
                        KeluargaActivity.ma.refresh();
                    }

                    @Override
                    public void onFailure(Call<PostPutDelKk> call, Throwable t) {

                    }
                });
            }
        });
            ;

            final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int day) {
                    calendar.set(Calendar.YEAR, year);
                    calendar.set(Calendar.MONTH, month);
                    calendar.set(Calendar.DAY_OF_MONTH, day);
                    updateLabel();
                }
            };

        edtTanggal.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick (View view){
                new DatePickerDialog(TambahKeluargaActivity.this, date,
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

    private void initSpinnerRT(){
        loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);

        mApiService.getSemuaRt().enqueue(new Callback<ResponseRt>() {

            @Override
            public void onResponse(Call<ResponseRt> call, Response<ResponseRt> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<ResultItem> Rt = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < Rt.size(); i++)
                        listSpinner.add("RT : "+Rt.get(i).getRt()+" / RW : "+Rt.get(i).getRw()
                        );
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    SpKodeRT.setAdapter(adapter);
                    SpKodeRT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            kodert = Rt.get(position).getKodeRt();
                            Log.e(TAG, "onItemSelected: "+kodert );
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });


                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFailure(Call<ResponseRt> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "BELUM BISA", Toast.LENGTH_SHORT).show();
            }
        });
    }
}


