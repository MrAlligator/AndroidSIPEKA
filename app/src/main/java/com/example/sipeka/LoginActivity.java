package com.example.sipeka;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import cyd.awesome.material.AwesomeText;
import cyd.awesome.material.FontCharacterMaps;

public class LoginActivity extends AppCompatActivity {

    AwesomeText showpass;
    EditText username, password;
    Button masuk;
    TextView lupa;
    SharedPreferences sharedPreferences;

    Boolean pwdstatus = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sharedPreferences = getSharedPreferences("remember", MODE_PRIVATE);
        if(sharedPreferences.getString("username", "").isEmpty()) {

        } else {
            Intent login = new Intent(LoginActivity.this, MainActivity.class);
            login.putExtra("username", sharedPreferences.getString("username", ""));
            startActivity(login);
        }

        showpass = findViewById(R.id.showpass);
        masuk = findViewById(R.id.button);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        lupa = findViewById(R.id.lupa);

        showpass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (pwdstatus) {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                    pwdstatus = false;
                    showpass.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY);
                    password.setSelection(password.length());
                } else {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT);
                    pwdstatus = true;
                    showpass.setMaterialDesignIcon(FontCharacterMaps.MaterialDesign.MD_VISIBILITY_OFF);
                    password.setSelection(password.length());
                }
            }
        });

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String usernameKey = username.getText().toString();
                String passwordKey = password.getText().toString();

                if (usernameKey.equals("admin") && passwordKey.equals("admin")){
                    //Session
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username",usernameKey);
                    editor.commit();
                    //End Session
                    //jika login berhasil
                    Toast.makeText(getApplicationContext(), "Login Berhasil",
                            Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    LoginActivity.this.startActivity(intent);
                    finish();
                }
                else if(usernameKey.isEmpty() && passwordKey.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username dan Password tidak boleh Kosong!")
                            .setNegativeButton("Retry", null).create().show();
                }
                else if(usernameKey.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Masukkan Username Anda!")
                            .setNegativeButton("Retry", null).create().show();
                }
                else if(passwordKey.isEmpty()){
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Masukkan Password Anda!")
                            .setNegativeButton("Retry", null).create().show();
                }
                else {
                    //jika login gagal
                    AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                    builder.setMessage("Username atau Password Anda salah!")
                            .setNegativeButton("Retry", null).create().show();
                }
            }
        });

        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    @Override
    public void onBackPressed(){

    }

}
