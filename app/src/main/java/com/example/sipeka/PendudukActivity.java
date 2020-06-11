package com.example.sipeka;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.sipeka.Adapter.KtpAdapter;
import com.example.sipeka.Model.Ktp.GetKtp;
import com.example.sipeka.Model.Ktp.Ktp;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PendudukActivity extends AppCompatActivity {

    private Button buat;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static PendudukActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penduduk);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        buat = findViewById(R.id.btnTambah);

        buat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PendudukActivity.this, TambahActivity.class));
            }
        });

        mRecyclerView = (RecyclerView) findViewById(R.id.listView1);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();

    }

    public void refresh() {
        Call<GetKtp> KtpCall = mApiInterface.getKtp();
        KtpCall.enqueue(new Callback<GetKtp>() {
            @Override
            public void onResponse(Call<GetKtp> call, Response<GetKtp>
                    response) {
                List<Ktp> KtpList = response.body().getListDataKtp();
                Log.d("Retrofit Get", "Jumlah data Ktp: " +
                        String.valueOf(KtpList.size()));
                mAdapter = new KtpAdapter(KtpList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetKtp> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
