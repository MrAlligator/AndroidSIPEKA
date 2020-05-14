package com.example.sipeka.Rest;

import com.example.sipeka.Model.GetKontak;
import com.example.sipeka.Model.PostPutDelKontak;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("kontak_android")
    Call<GetKontak> getKontak();
    @FormUrlEncoded
    @POST("kontak")
    Call<PostPutDelKontak> postKontak(@Field("nama") String nama,
                                      @Field("tempatLahir") String tempatLahir,
                                      @Field("tanggalLahir") String tanggalLahir,
                                      @Field("jenisKelamin") String jenisKelamin,
                                      @Field("golDarah") String golDarah,
                                      @Field("alamat") String alamat,
                                      @Field("kodeRt") String kodeRt,
                                      @Field("kodeRw") String kodeRw,
                                      @Field("kelurahan") String kelurahan,
                                      @Field("kecamatan") String kecamatan,
                                      @Field("agama") String agama,
                                      @Field("statusPerkawinan") String statusPerkawinan,
                                      @Field("pekerjaan") String pekerjaan,
                                      @Field("kewarganegaraan") String kewarganegaraan,
                                      @Field("berlakuHingga") String berlakuHingga,
                                      @Field("gambar_ktp") String gambar_ktp);
    @FormUrlEncoded
    @PUT("kontak")
    Call<PostPutDelKontak> putKontak(@Field("nik") String nik,
                                     @Field("nama") String nama,
                                     @Field("tempatLahir") String tempatLahir,
                                     @Field("tanggalLahir") String tanggalLahir,
                                     @Field("jenisKelamin") String jenisKelamin,
                                     @Field("golDarah") String golDarah,
                                     @Field("alamat") String alamat,
                                     @Field("kodeRt") String kodeRt,
                                     @Field("kodeRw") String kodeRw,
                                     @Field("kelurahan") String kelurahan,
                                     @Field("kecamatan") String kecamatan,
                                     @Field("agama") String agama,
                                     @Field("statusPerkawinan") String statusPerkawinan,
                                     @Field("pekerjaan") String pekerjaan,
                                     @Field("kewarganegaraan") String kewarganegaraan,
                                     @Field("berlakuHingga") String berlakuHingga,
                                     @Field("gambar_ktp") String gambar_ktp);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "kontak", hasBody = true)
    Call<PostPutDelKontak> deleteKontak(@Field("nik") String nik);
}
