package com.example.sipeka.Rest.Spinner;

import com.example.sipeka.Model.Response.ResponseKab;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface BaseApiService {
    @GET("kabkot_android")
    Call<ResponseKab> getSemuaKabupaten();

    @GET("kec_android")
    Call<ResponseKab> getSemuaKecamatan();
    @FormUrlEncoded

    @POST("rest_login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);
}
