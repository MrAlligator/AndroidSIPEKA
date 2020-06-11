package com.example.sipeka.Rest;



import com.example.sipeka.Model.Ktp.GetKtp;
import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Rt.GetRt;
import com.example.sipeka.Model.Rt.PostPutDelRt;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("rt_android")
    Call<GetRt> getRt();
    @FormUrlEncoded
    @POST("rt_android")
    Call<PostPutDelRt> postRt(@Field("rt") String rt,
                              @Field("rw") String rw);

    @FormUrlEncoded
    @PUT("rt_android")
    Call<PostPutDelRt> putRt(@Field("kodeRt") String kodeRt,
                                     @Field("rt") String rt,
                                     @Field("rw") String rw);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "rt_android", hasBody = true)
    Call<PostPutDelRt> deleteRt(@Field("kodeRt") String kodeRt);

    @GET("ktp_android")
    Call<GetKtp> getKtp();
    @FormUrlEncoded
    @POST("ktp_android")
    Call<PostPutDelKtp> postKtp(@Field("nik") String nik,
                                @Field("nama") String nama,
                                @Field("noKk") String noKk,
                                @Field("tempatLahir") String tempatLahir,
                                @Field("tanggalLahir") String tanggalLahir,
                                @Field("jenisKelamin") String jenisKelamin,
                                @Field("golDarah") String golDarah,
                                @Field("alamat") String alamat,
                                @Field("kodeRt") String kodeRt,
                                @Field("kelurahan") String kelurahan,
                                @Field("kecamatan") String kecamatan,
                                @Field("agama") String agama,
                                @Field("statusPerkawinan") String statusPerkawinan,
                                @Field("pekerjaan") String pekerjaan,
                                @Field("kewarganegaraan") String kewarganegaraan,
                                @Field("berlakuHingga") String berlakuHingga,
                                @Field("gambar_ktp") String gambar_ktp);
    @FormUrlEncoded
    @PUT("ktp_android")
    Call<PostPutDelKtp> putKtp(@Field("nik") String nik,
                               @Field("nama") String nama,
                               @Field("noKk") String noKk,
                               @Field("tempatLahir") String tempatLahir,
                               @Field("tanggalLahir") String tanggalLahir,
                               @Field("jenisKelamin") String jenisKelamin,
                               @Field("golDarah") String golDarah,
                               @Field("alamat") String alamat,
                               @Field("kodeRt") String kodeRt,
                               @Field("kelurahan") String kelurahan,
                               @Field("kecamatan") String kecamatan,
                               @Field("agama") String agama,
                               @Field("statusPerkawinan") String statusPerkawinan,
                               @Field("pekerjaan") String pekerjaan,
                               @Field("kewarganegaraan") String kewarganegaraan,
                               @Field("berlakuHingga") String berlakuHingga,
                               @Field("gambar_ktp") String gambar_ktp);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ktp_android", hasBody = true)
    Call<PostPutDelKtp> deleteKtp(@Field("nik") String nik);
}
