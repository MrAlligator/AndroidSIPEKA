package com.example.sipeka.Model.Response;

import com.google.gson.annotations.SerializedName;

public class UploadImage {

    @SerializedName("success")
    boolean success;
    @SerializedName("message")
    String message;

    public boolean getSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
