package com.example.sipeka.Rest.Spinner;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.Part;

public interface UploadApi {

    @Multipart
    Call<RequestBody> uploadImage(@Part MultipartBody.Part part,
                                  @Part("somedate") RequestBody requestBody);

}
