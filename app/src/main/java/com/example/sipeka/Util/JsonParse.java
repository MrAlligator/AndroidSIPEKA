package com.example.sipeka.Util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import android.util.Log;

import com.example.sipeka.Model.Indonesia.Desa;
import com.example.sipeka.Model.Indonesia.Kabupaten;
import com.example.sipeka.Model.Indonesia.Kecamatan;
import com.example.sipeka.Model.Indonesia.Provinsi;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    private static final String TAG = JsonParse.class.getSimpleName();

    String id_prov, id_kab, id_kec;
    Context mContext;
    SharedPreferences.Editor spEditor;
    SharedPreferences sp;

    public JsonParse(Context mContext) {
        this.mContext = mContext;
        spEditor = mContext.getSharedPreferences(SharedPref.SP_PREFS_NAME, Context.MODE_PRIVATE).edit();
        sp = mContext.getSharedPreferences(SharedPref.SP_PREFS_NAME, Context.MODE_PRIVATE);
    }

    public List<Provinsi> getParseJsonProv(String sName){
        List<Provinsi> listProv = new ArrayList<Provinsi>();
        try {
            String temp = sName.replace(" ", "%20");
            URL urlAPI = new URL("http://192.168.1.20/kelompok_5/prov_android/provinces?name="+temp);
            URLConnection urlConnection = urlAPI.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            if (jsonResponse.isNull("provinces")){

            } else {
                JSONArray jsonArray = jsonResponse.getJSONArray("provinces");
                Log.e(TAG, "getParseJsonProv: " + jsonArray );
                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject result = jsonArray.getJSONObject(i);
                    listProv.add(new Provinsi(result.getString("name"), result.getString("name")));
                }
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }

        return listProv;
    }

    public List<Kabupaten> getParseJsonKab(String sNamaKab){
        List<Kabupaten> listKabupaten = new ArrayList<Kabupaten>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String tempKab = sNamaKab.replace(" ", "%20");
            String spIdProv = sp.getString(SharedPref.SP_IDPROV, "");
            URL urlAPI = new URL("http://192.168.1.20/kelompok_5/kabkot_android/regencies?province_id="+spIdProv+
                    "&name="+tempKab);
            URLConnection urlConnection = urlAPI.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            if (jsonResponse.isNull("regencies")){

            } else {
                JSONArray jsonArrayKab = jsonResponse.getJSONArray("regencies");
                for (int i = 0; i < jsonArrayKab.length(); i++){
                    JSONObject result = jsonArrayKab.getJSONObject(i);
                    listKabupaten.add(new Kabupaten(result.getString("id"), result.getString("province_id"),
                            result.getString("name")));
                }
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return listKabupaten;
    }

    public List<Kecamatan> getParseJsonKec(String sNamaKec){
        List<Kecamatan> listKecamatan = new ArrayList<Kecamatan>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String tempKec = sNamaKec.replace(" ", "%20");
            String spIdKab = sp.getString(SharedPref.SP_IDKAB, "");
            URL urlAPI = new URL("http://dev.farizdotid.com/api/daerahindonesia/kecamatan?id_kota="+spIdKab+
                    "&nama="+tempKec);
            URLConnection urlConnection = urlAPI.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            if (jsonResponse.isNull("kecamatan")){

            } else {
                JSONArray jsonArrayKec = jsonResponse.getJSONArray("kecamatan");
                for (int i = 0; i < jsonArrayKec.length(); i++){
                    JSONObject result = jsonArrayKec.getJSONObject(i);
                    listKecamatan.add(new Kecamatan(result.getString("id"), result.getString("id_kota"),
                            result.getString("nama")));
                }
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return listKecamatan;
    }

    public List<Desa> getParseJsonDesa(String sNamaDesa){
        List<Desa> listDesa = new ArrayList<Desa>();
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            String tempDesa = sNamaDesa.replace(" ", "%20");
            String spIdKec = sp.getString(SharedPref.SP_IDKEC, "");
            URL urlAPI = new URL("http://dev.farizdotid.com/api/daerahindonesia/kelurahan?id_kecamatan="+spIdKec+
                    "&nama="+tempDesa);
            URLConnection urlConnection = urlAPI.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line = reader.readLine();
            JSONObject jsonResponse = new JSONObject(line);
            if (jsonResponse.isNull("desa")){

            } else {
                JSONArray jsonArrayDesa = jsonResponse.getJSONArray("desa");
                for (int i = 0; i < jsonArrayDesa.length(); i++){
                    JSONObject result = jsonArrayDesa.getJSONObject(i);
                    listDesa.add(new Desa(result.getString("id"), result.getString("id_kecamatan"),
                            result.getString("nama")));
                }
            }
        } catch (Exception e1){
            e1.printStackTrace();
        }
        return listDesa;
    }

    public void searchIdProv(String namaProv){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String tempProv = namaProv.replace(" ", "%20");
            URL urlAPIProv = new URL("http://dev.farizdotid.com/api/daerahindonesia/provinsi?nama=" + tempProv);
            URLConnection urlConnectionProv = urlAPIProv.openConnection();
            BufferedReader readerProv = new BufferedReader(new InputStreamReader(urlConnectionProv.getInputStream()));
            String lineProv = readerProv.readLine();
            JSONObject jsonResponseProv = new JSONObject(lineProv);
            if (jsonResponseProv.isNull("provinsi")){

            } else {
                JSONArray jsonArrayProv = jsonResponseProv.getJSONArray("provinsi");
                for (int i = 0; i < jsonArrayProv.length(); i++) {
                    JSONObject result = jsonArrayProv.getJSONObject(i);
                    id_prov = result.getString("id");

                    spEditor.putString(SharedPref.SP_IDPROV, id_prov);
                    spEditor.commit();
                }
            }
        }   catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void searchIdKab(String namaKab){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String tempKab = namaKab.replace(" ", "%20");
            String spIdProv = sp.getString(SharedPref.SP_IDPROV, "");
            URL urlAPIKab = new URL("https://farizdotid.com/api/wilayah_indonesia/get_kabupaten.php?id_prov="+spIdProv+
                    "&nama_kab="+tempKab);
            URLConnection urlConnectionKab = urlAPIKab.openConnection();
            BufferedReader readerKab = new BufferedReader(new InputStreamReader(urlConnectionKab.getInputStream()));
            String lineKab = readerKab.readLine();
            JSONObject jsonResponseKab = new JSONObject(lineKab);
            if (jsonResponseKab.isNull("regencies")){

            } else {
                JSONArray jsonArrayKab = jsonResponseKab.getJSONArray("regencies");
                for (int i = 0; i < jsonArrayKab.length(); i++) {
                    JSONObject result = jsonArrayKab.getJSONObject(i);
                    id_kab = result.getString("id");

                    spEditor.putString(SharedPref.SP_IDKAB, id_kab);
                    spEditor.commit();
                }
            }
        }   catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void searchIdKec(String namaKec){
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);

            String tempKec = namaKec.replace(" ", "%20");
            String spIdKab = sp.getString(SharedPref.SP_IDKAB, "");
            URL urlAPIKec = new URL("https://farizdotid.com/api/wilayah_indonesia/get_kecamatan.php?id_kab="+spIdKab+
                    "&nama_kec="+tempKec);
            URLConnection urlConnectionKec = urlAPIKec.openConnection();
            BufferedReader readerKec = new BufferedReader(new InputStreamReader(urlConnectionKec.getInputStream()));
            String lineKec = readerKec.readLine();
            JSONObject jsonResponseKec = new JSONObject(lineKec);
            if (jsonResponseKec.isNull("districts")){

            } else {
                JSONArray jsonArrayKec = jsonResponseKec.getJSONArray("districts");
                for (int i = 0; i < jsonArrayKec.length(); i++) {
                    JSONObject result = jsonArrayKec.getJSONObject(i);
                    id_kec = result.getString("id");
                    spEditor.putString(SharedPref.SP_IDKEC, id_kec);
                    spEditor.commit();
                }
            }
        }   catch (Exception e1){
            e1.printStackTrace();
        }
    }
}
