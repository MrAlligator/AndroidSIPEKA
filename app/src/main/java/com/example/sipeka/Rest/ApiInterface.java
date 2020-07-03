package com.example.sipeka.Rest;



import com.example.sipeka.Model.Anggota.GetAnggota;
import com.example.sipeka.Model.Indonesia.Provinsi;
import com.example.sipeka.Model.Kk.GetKk;
import com.example.sipeka.Model.Kk.PostPutDelKk;
import com.example.sipeka.Model.Ktp.GetKtp;
import com.example.sipeka.Model.Ktp.PostPutDelKtp;
import com.example.sipeka.Model.Response.ResponseRt;
import com.example.sipeka.Model.Response.UploadImage;
import com.example.sipeka.Model.Rt.GetRt;
import com.example.sipeka.Model.Rt.PostPutDelRt;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;

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
    Call<PostPutDelKtp> postKtp(@Field("provinsi") String provinsi,
                                @Field("kabupaten") String kabupaten,
                                @Field("nik") String nik,
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
                                @Field("berlakuHingga") String berlakuHingga);
    @FormUrlEncoded
    @PUT("ktp_android")
    Call<PostPutDelKtp> putKtp(@Field("provinsi") String provinsi,
                               @Field("kabupaten") String kabupaten,
                               @Field("nik") String nik,
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
                               @Field("berlakuHingga") String berlakuHingga);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "ktp_android", hasBody = true)
    Call<PostPutDelKtp> deleteKtp(@Field("nik") String nik);

    @GET("keluarga_android")
    Call<GetKk> getKk();

    @FormUrlEncoded
    @POST("keluarga_android")
    Call<PostPutDelKk> postKk(@Field("noKk") String noKk,
                             @Field("namaKk") String namaKk,
                             @Field("alamat") String alamat,
                             @Field("kelurahan") String kelurahan,
                             @Field("kecamatan") String kecamatan,
                             @Field("kabupaten") String kabupaten,
                             @Field("kodePos") String kodePos,
                             @Field("provinsi") String provinsi,
                             @Field("dikeluarkanTanggal") String dikeluarkanTanggal,
                             @Field("kodeRt") String kodeRt);

    @FormUrlEncoded
    @PUT("keluarga_android")
    Call<PostPutDelKk> putKk(@Field("noKk") String noKk,
                             @Field("namaKk") String namaKk,
                             @Field("alamat") String alamat,
                             @Field("kelurahan") String kelurahan,
                             @Field("kecamatan") String kecamatan,
                             @Field("kabupaten") String kabupaten,
                             @Field("kodePos") String kodePos,
                             @Field("provinsi") String provinsi,
                             @Field("dikeluarkanTanggal") String dikeluarkanTanggal,
                             @Field("kodeRt") String kodeRt);

    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "keluarga_android", hasBody = true)
    Call<PostPutDelKk> deleteKk(@Field("noKk") String noKk);

    @GET("prov_android")
    Call<Provinsi> getProv();

    @FormUrlEncoded
    @POST("load_rt")
    Call<ResponseRt> getkodeRt(@Field("kodeRt") String kodeRt);

    @Multipart
    @POST("upload_ktp")
    Call<UploadImage> uploadFile(@Part MultipartBody.Part file,
                                 @Part("file")RequestBody name);

    @FormUrlEncoded
    @POST("anggota")
    Call<GetAnggota> Anggota(@Field("noKk") String noKk);

}
