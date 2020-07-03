package com.example.sipeka.Rest.Spinner;

import com.example.sipeka.Model.Ktp.GetKtp;
import com.example.sipeka.Model.Response.ResponseRt;
import com.example.sipeka.Model.Response.UploadImage;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface BaseApiService {
    @GET("rt_android")
    Call<ResponseRt> getSemuaRt();

    @FormUrlEncoded
    @POST("rest_login")
    Call<ResponseBody> loginRequest(@Field("email") String email,
                                    @Field("password") String password);
    @FormUrlEncoded
    @POST("load_rt")
    Call<ResponseRt> getkodeRt(@Field("kodeRt") String kodeRt);

    @Multipart
    @POST("upload_ktp")
    Call<UploadImage> uploadFile(@Part MultipartBody.Part file,
                                 @Part("file") RequestBody name);
    @FormUrlEncoded
    @POST("anggota")
    Call<GetKtp> Anggota(@Field("noKk") String noKk);
}
