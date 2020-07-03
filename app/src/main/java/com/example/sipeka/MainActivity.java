package com.example.sipeka;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.sipeka.Model.Ktp.GetKtp;
import com.example.sipeka.Model.Ktp.Ktp;
import com.example.sipeka.Rest.ApiClient;
import com.example.sipeka.Rest.ApiInterface;
import com.example.sipeka.SharedPref.SharedPrefManager;

import java.util.List;

import butterknife.BindView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.logout)
    ImageView logout;
    ImageView menu1, menu2, menu3, menu4, menu5, menu6;
    TextView penduduk, keluarga, domisili, grafik, pengaturan, about, isi;
    SharedPrefManager sharedPrefManager;
    ApiInterface mApiInterface;
    public static MainActivity ma;
    int isinya;
//    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPrefManager = new SharedPrefManager(this);
//        session = new SessionManagement(getApplicationContext());
        isi = (TextView) findViewById(R.id.isi);
        menu1 = findViewById(R.id.menu1);
        menu2 = findViewById(R.id.menu2);
        menu3 = findViewById(R.id.menu3);
        menu4 = findViewById(R.id.menu4);
        menu5 = findViewById(R.id.menu5);
        menu6 = findViewById(R.id.menu6);
        logout = findViewById(R.id.logout);
        penduduk = findViewById(R.id.penduduk);
        keluarga = findViewById(R.id.keluarga);
        domisili = findViewById(R.id.domisili);
        grafik = findViewById(R.id.grafik);
        pengaturan = findViewById(R.id.pengaturan);
        about = findViewById(R.id.about);

        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;

        refresh();
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, false);
                startActivity(new Intent(MainActivity.this, LoginActivity.class)
                        .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK));
                finish();
            }
        });
        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PendudukActivity.class));
            }
        });
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeluargaActivity.class));
            }
        });
        //menu3.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //startActivity(new Intent(MainActivity.this, DomisiliActivity.class));
        //}
        //});
        menu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GrafikActivity.class));
            }
        });
        menu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PengaturanActivity.class));
            }
        });
        menu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
        penduduk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PendudukActivity.class));
            }
        });
        keluarga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, KeluargaActivity.class));
            }
        });
        //domisili.setOnClickListener(new View.OnClickListener() {
        //@Override
        //public void onClick(View v) {
        //startActivity(new Intent(MainActivity.this, DomisiliActivity.class));
        //}
        //});
        grafik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GrafikActivity.class));
            }
        });
        pengaturan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PengaturanActivity.class));
            }
        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AboutActivity.class));
            }
        });
    }

        public void refresh() {
            Call<GetKtp> KtpCall = mApiInterface.getKtp();
            KtpCall.enqueue(new Callback<GetKtp>() {
                @Override
                public void onResponse(Call<GetKtp> call, Response<GetKtp> response) {
                    List<Ktp> KtpList = response.body().getListDataKtp();
                    isi.setText(Integer.toString(KtpList.size()));
                }
                @Override
                public void onFailure(Call<GetKtp> call, Throwable t) {
                    Log.e("Retrofit Get", t.toString());
                }
            });
        }
//        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

//        session.checkLogin();

        // get user data from session
//        HashMap<String, String> user = session.getUserDetails();
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setMessage("Yakin Ingin Keluar dari Aplikasi?");
        builder.setPositiveButton("Iya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user pressed "yes", then he is allowed to exit from application
                finish();
                System.exit(0);
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //if user select "No", just cancel this dialog and continue with app
                dialog.cancel();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
