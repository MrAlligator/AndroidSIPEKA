package com.example.sipeka.Rest.Spinner;



import com.example.sipeka.Model.Response.ResponseKabupaten;

import retrofit2.Call;
import retrofit2.http.GET;

public interface BaseApiService {
    @GET("rt_android")
    Call<ResponseKabupaten> getKabkot();
}
