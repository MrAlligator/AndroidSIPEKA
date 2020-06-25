package com.example.sipeka.Rest.Spinner;

public class UtilsApi {

    // 192.168.1.5 ini adalah localhost.
    public static final String BASE_URL_API = "http://192.168.1.20/kelompok_5/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);
    }
}
