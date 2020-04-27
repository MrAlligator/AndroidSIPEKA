package com.example.sipeka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class LoginActivity extends AppCompatActivity {

    AwesomeText showpass;
    EditText mViewUser, mViewPassword;
    Button masuk;
    TextView lupa;
    SharedPreferences sharedPreferences;
    SessionManagement session;

    Boolean pwdstatus = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        session = new SessionManagement(getApplicationContext());

        showpass = findViewById(R.id.showpass);
        masuk = findViewById(R.id.button);
        mViewUser = findViewById(R.id.username);
        mViewPassword = findViewById(R.id.password);
        lupa = findViewById(R.id.lupa);

        Toast.makeText(getApplicationContext(), "User Login Status : " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        showpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwdstatus) {
                    mViewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwdstatus = false;
                    showpass.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    mViewPassword.setSelection(mViewPassword.length());
                } else {
                    mViewPassword.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwdstatus = true;
                    showpass.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    mViewPassword.setSelection(mViewPassword.length());
                }
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mViewUser.getText().toString();
                String password = mViewPassword.getText().toString();

                if(username.trim().length() > 0 && password.trim().length() > 0){

                    if(username.equals("admin") && password.equals("admin")){

                        session.createLoginSession("Android Hive", "anroidhive@gmail.com");

                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();

                    }else{
                        showDialog2();
                    }
                }else{
                    showDialog3();
                }
            }
        });
    }

    private void showDialog3(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder
                .setMessage("Username dan Password tidak boleh kosong")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();

        alertDialog.show();
    }

    private void showDialog2(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder
                .setMessage("Username atau Password Salah")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private void showDialog(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                this);

        alertDialogBuilder.setTitle("Keluar dari aplikasi?");

        alertDialogBuilder
                .setMessage("Klik Ya untuk keluar!")
                .setIcon(R.mipmap.ic_launcher)
                .setCancelable(false)
                .setPositiveButton("Ya",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        LoginActivity.this.finish();
                    }
                })
                .setNegativeButton("Tidak",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

}
