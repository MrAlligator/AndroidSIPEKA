package com.example.sipeka.Rest.Spinner;

import com.example.sipeka.Model.Response.ResponseKab;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("kabkot_android")
    Call<ResponseKab> getSemuaKabupaten();

    @GET("kec_android")
    Call<ResponseKab> getSemuaKecamatan();
}
