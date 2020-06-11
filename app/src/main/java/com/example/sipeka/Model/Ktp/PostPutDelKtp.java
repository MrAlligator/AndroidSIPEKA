package com.example.sipeka.Model.Ktp;

import com.google.gson.annotations.SerializedName;

public class PostPutDelKtp {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Ktp mKtp;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public Ktp getKontak() {
        return mKtp;
    }
    public void setKontak(Ktp Ktp) { mKtp = Ktp;
    }
}
