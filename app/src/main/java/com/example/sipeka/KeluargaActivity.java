package com.example.sipeka;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sipeka.Adapter.KkAdapter;
import com.example.sipeka.Model.Kk.GetKk;
import com.example.sipeka.Model.Kk.Kk;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KeluargaActivity extends AppCompatActivity {

    private Button tambah, buat;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private KkAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static KeluargaActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluarga);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        tambah = findViewById(R.id.btnTambah);

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(KeluargaActivity.this, TambahKeluargaActivity.class));
            }
        });
        mRecyclerView = (RecyclerView) findViewById(R.id.listView2);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma = this;
        refresh();
    }

    public void refresh() {
        Call<GetKk> KkCall = mApiInterface.getKk();
        KkCall.enqueue(new Callback<GetKk>() {
            @Override
            public void onResponse(Call<GetKk> call, Response<GetKk> response) {
                List<Kk> KkList = response.body().getListDataKk();
                Log.d("Retrofit Get", "Jumlah data Kk :" +
                        String.valueOf(KkList.size()));
                mAdapter = new KkAdapter(KkList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetKk> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
