package com.example.sipeka;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Response.ResponseRt;
import com.example.sipeka.Model.Response.ResultItem;
import com.example.sipeka.Model.Response.UploadImage;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;
import com.example.sipeka.Rest.Spinner.BaseApiService;
import com.example.sipeka.Rest.Spinner.UtilsApi;
import com.example.sipeka.Util.JsonParse;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import butterknife.ButterKnife;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TambahActivity extends AppCompatActivity {
    Context mContext;
    private Button btnPilih, btnSimpan;
    private ImageView preview;
    private static final String TAG = TambahActivity.class.getSimpleName();
    private static final int CAMERA_REQUEST_CODE = 7777;
    private static final int cameraCode = 1;
    private static final int galleryCode = 100;
    private Calendar calendar;
    private EditText txtKota, txtTanggal, txtNama, txtNIK, txtNoKK, txtAlamat, txtRT, txtRW, txtPekerjaan, txtBerlaku;
    private Spinner SpJenKel, SpGoldar, SpKodeRT, SpAgama, SpStatus, SpKewarganegaraan;
    private AutoCompleteTextView ACTVProv, ACTVKab, ACTVKec, ACTVKel;
    private JsonParse jsonParse;
    ApiInterface mApiInterface;
    ProgressDialog loading;
    BaseApiService mApiService;
    private AlertDialog.Builder alert;
    private AlertDialog ad;
    public String kodeProv;
    String kodert, mediaPath;
    TextView photo_name;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        ButterKnife.bind(this);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        jsonParse = new JsonParse(this);

        initSpinnerRt();
        mContext = this;
        calendar = Calendar.getInstance();
        txtTanggal = findViewById(R.id.txtTanggal);
        btnPilih = findViewById(R.id.btnPilih);
        btnSimpan = findViewById(R.id.button1);
        preview = findViewById(R.id.preview);
        txtNama = findViewById(R.id.txtNama);
        txtNIK = findViewById(R.id.txtNIK);
        txtNoKK = findViewById(R.id.txtNoKK);
        txtAlamat = findViewById(R.id.txtAlamat);
        txtPekerjaan = findViewById(R.id.txtPekerjaan);
        txtBerlaku = findViewById(R.id.txtBerlaku);
        txtKota = findViewById(R.id.txtKota);
        SpJenKel = findViewById(R.id.txtJenkel);
        SpGoldar = findViewById(R.id.txtGoldar);
        SpKodeRT = findViewById(R.id.txtRT);
        SpAgama = findViewById(R.id.txtAgama);
        SpStatus = findViewById(R.id.txtStatus);
        SpKewarganegaraan = findViewById(R.id.txtKewarganegaraan);
        ACTVKec = findViewById(R.id.txtKecamatan);
        ACTVKel = findViewById(R.id.txtKelurahan);
        ACTVKab = findViewById(R.id.txtKab);
        ACTVProv = findViewById(R.id.txtProv);
        photo_name = findViewById(R.id.photo_name);
        preview = findViewById(R.id.preview);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);

        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                uploadFile();
                Call<PostPutDelKtp> postKontakCall = mApiInterface.postKtp( ACTVKab.getText().toString(),
                                                                            ACTVProv.getText().toString(),
                                                                            txtNIK.getText().toString(),
                                                                            txtNoKK.getText().toString(),
                                                                            txtNama.getText().toString(),
                                                                            txtKota.getText().toString(),
                                                                            txtTanggal.getText().toString(),
                                                                            SpJenKel.getSelectedItem().toString(),
                                                                            SpGoldar.getSelectedItem().toString(),
                                                                            txtAlamat.getText().toString(),
                                                                            kodert, ACTVKel.getText().toString(),
                                                                            ACTVKec.getText().toString(),
                                                                            SpAgama.getSelectedItem().toString(),
                                                                            SpStatus.getSelectedItem().toString(),
                                                                            txtPekerjaan.getText().toString(),
                                                                            SpKewarganegaraan.getSelectedItem().toString(),
                                                                            txtBerlaku.getText().toString()
                );
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
                Intent galleryIntent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(galleryIntent, 0);
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
        try {
            if (requestCode == 0 && resultCode == RESULT_OK && null != data) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                assert cursor != null;
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                mediaPath = cursor.getString(columnIndex);
                String filename = mediaPath.substring(mediaPath.lastIndexOf("/") + 1);
                photo_name.setText(filename);
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                preview.setImageBitmap(bitmap);
                cursor.close();
            } else {
                Toast.makeText(this, "Pilih Foto Dulu", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Ada Sesuatu yang Salah", Toast.LENGTH_LONG).show();
        }
    }

    private void uploadFile() {
        // Map is used to multipart the file using okhttp3.RequestBody
        File file = new File(mediaPath);


        // Parsing any Media type file
        RequestBody requestBody = RequestBody.create(MediaType.parse("*/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("file", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        retrofit2.Call<UploadImage> call = mApiService.uploadFile(fileToUpload, filename);
        call.enqueue(new Callback<UploadImage>() {
            @Override
            public void onResponse(retrofit2.Call<UploadImage> call, Response<UploadImage> response) {
                UploadImage serverResponse = response.body();
                if (serverResponse != null) {
                    if (serverResponse.getSuccess()) {
                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), serverResponse.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(retrofit2.Call<UploadImage> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Gagal", Toast.LENGTH_SHORT).show();
                Log.e(TAG, "onFailure: "+t+call );
            }
        });
    }
    private void updateLabel() {
        String dateFormat = "dd-MM-yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
        txtTanggal.setText(sdf.format(calendar.getTime()));
    }

    private void initSpinnerRt(){
        loading = ProgressDialog.show(mContext, null, "harap tunggu...", true, false);

        mApiService.getSemuaRt().enqueue(new Callback<ResponseRt>() {

            @Override
            public void onResponse(Call<ResponseRt> call, Response<ResponseRt> response) {
                if (response.isSuccessful()) {
                    loading.dismiss();
                    List<ResultItem> semuaRt = response.body().getResult();
                    List<String> listSpinner = new ArrayList<String>();
                    for (int i = 0; i < semuaRt.size(); i++)
                        listSpinner.add("RT : "+semuaRt.get(i).getRt()+" / RW : "+semuaRt.get(i).getRw()
                        );
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext,
                            android.R.layout.simple_spinner_item, listSpinner);
                    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    SpKodeRT.setAdapter(adapter);
                    SpKodeRT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            kodert = semuaRt.get(position).getKodeRt();
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