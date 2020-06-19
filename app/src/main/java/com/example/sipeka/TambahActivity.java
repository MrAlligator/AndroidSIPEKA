package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Response.ResponseKab;
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

import butterknife.BindView;
import butterknife.ButterKnife;
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
    private Spinner  SpJenKel, SpGoldar, SpKodeRT, SpKelurahan, SpKecamatan, SpAgama, SpStatus, SpKewarganegaraan;
    ApiInterface mApiInterface;
    @BindView(R.id.txtKota)
    Spinner SpKota;
    ProgressDialog loading;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();

        initSpinnerDosen();
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

//        fetchJSON();

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


//    private void fetchJSON(){
//
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(ApiClient.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        ApiInterface api = retrofit.create(ApiInterface.class);
//
//        Call<String> call = api.getRt();
//
//        call.enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//                Log.i("Responsestring", response.body().toString());
//                //Toast.makeText()
//                if (response.isSuccessful()) {
//                    if (response.body() != null) {
//                        Log.i("onSuccess", response.body().toString());
//
//                        String jsonresponse = response.body().toString();
//                        spinJSON(jsonresponse);
//
//                    } else {
//                        Log.i("onEmptyResponse", "Returned empty response");//Toast.makeText(getContext(),"Nothing returned",Toast.LENGTH_LONG).show();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });
//    }

//    private void spinJSON(String response){
//
//        try {
//
//            JSONObject obj = new JSONObject(response);
//            if(obj.optString("status").equals("true")){
//
//                goodModelArrayList = new ArrayList<>();
//                JSONArray dataArray  = obj.getJSONArray("data");
//
//                for (int i = 0; i < dataArray.length(); i++) {
//
//                    Rt spinnerModel = new Rt();
//                    JSONObject dataobj = dataArray.getJSONObject(i);
//
//                    spinnerModel.setKodeRt(dataobj.getString("name"));
//                    spinnerModel.setRt(dataobj.getString("country"));
//                    spinnerModel.setRw(dataobj.getString("city"));
//
//                    goodModelArrayList.add(spinnerModel);
//
//                }
//
//                for (int i = 0; i < goodModelArrayList.size(); i++){
//                    playerNames.add(goodModelArrayList.get(i).getKodeRt().toString());
//                }
//
//                ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(TambahActivity.this, simple_spinner_item, playerNames);
//                spinnerArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
//                SpKodeRT.setAdapter(spinnerArrayAdapter);
//
//            }
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//
//    }


    private void initSpinnerDosen(){
        loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);

        mApiService.getSemuaKabupaten().enqueue(new Callback<ResponseKab>() {
            @Override
            public void onResponse(Call<ResponseKab> call, Response<ResponseKab> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<ResultItem> semuadosenItems = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < semuadosenItems.size(); i++){
                        listSpinner.add(semuadosenItems.get(i).getNama_kabkot());
//                            tv2.setText(semuadosenItems.get(i).getRw());
                    }

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    SpKota.setAdapter(adapter);
                } else {
                    loading.dismiss();
                    Toast.makeText(mContext, "Gagal mengambil data dosen", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseKab> call, Throwable t) {
                loading.dismiss();
                Toast.makeText(mContext, "BELUM BISA", Toast.LENGTH_SHORT).show();
            }

        });
    }

}
